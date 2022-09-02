/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.foundation.*;
import crossmobile.ios.usernotifications.UNUserNotificationCenter;
import org.crossmobile.bind.graphics.UIStatusBar;
import org.crossmobile.bind.system.SystemUtilities;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;
import org.crossmobile.bridge.system.BaseUtils;
import org.robovm.objc.block.VoidBlock1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static crossmobile.ios.uikit.UIUserNotificationType.notificationTypeToAuthorizationOption;

/**
 * UIApplication class defines an object that is uniquely associated with an
 * application and includes related control and coordination methods.
 */
@CMClass
public class UIApplication extends UIResponder {

    static UIWindow splashWindow = null;
    private static UIApplication instance;
    private boolean idleTimerDisabled;
    private UIApplicationDelegate delegate;
    private UIWindow keyWindow;
    private boolean networkActivityIndicatorVisible;
    private UIUserNotificationSettings notificationSettings;
    private UIUserNotificationSettings currentUserNotificationSettings;
    private int applicationIconBadgeNumber;
    private final int userInterfaceLayoutDirection = Native.system().isRTL() ? UIUserInterfaceLayoutDirection.RightToLeft : UIUserInterfaceLayoutDirection.LeftToRight;
    List<UIWindow> windows;

    /**
     * The default constructor of the UIAplication.
     */
    public UIApplication() {
        windows = new ArrayList<>();
        idleTimerDisabled = false;
    }

    /**
     * Returns the application instance.
     *
     * @return Returns the application instance.
     */
    @CMSelector("+ (UIApplication *)sharedApplication;")
    public static UIApplication sharedApplication() {
        return instance;
    }

    static UIWindow keyWindowIfExists() {
        return instance == null ? null : instance.keyWindow;
    }

    @CMFunction("int UIApplicationMain ( int argc, char * _Nonnull argv[], NSString *principalClassName, NSString *delegateClassName );")
    public static int main(@CMJoinMEM(memory = "argv", size = "argc") String[] args,
                           @CMParamMod(convertWith = "jclass_to_string", type = String.class) Class<? extends UIApplication> UIApplication,
                           @CMParamMod(convertWith = "jclass_to_string", type = String.class) Class<? extends UIApplicationDelegate> UIApplicationDelegate) {

        Native.prepare(null);
        Native.lifecycle().init(args);
        Native.lifecycle().runOnEventThread(() -> {

            // This is preferred since the constraint put during lifetime initialization under Android might not be enough, and a second one here might be required.
            if (instance == null)
                instance = SystemUtilities.safeInstantiation(UIApplication, crossmobile.ios.uikit.UIApplication.class);
            double splashWait = initSplash();
            double launchTime = System.currentTimeMillis();
            Native.graphics().refreshDisplay();
            NSTimerDelegate disableSplash = timer -> {
                instance.windows.remove(splashWindow);
                splashWindow = null;
                if (instance.windows.isEmpty())
                    instance.setKeyWindow(null);
                Native.lifecycle().splashTerminated();
                Native.graphics().refreshDisplay();
                if (UIResponder.requestResponderBeforeInit != null)
                    Native.lifecycle().postOnEventThread(() -> {
                        UIResponder.requestResponderBeforeInit.becomeFirstResponder();
                        UIResponder.requestResponderBeforeInit = null;
                    });
            };
            Native.lifecycle().postOnEventThread(() -> {
                if (instance == null) {
                    disableSplash(launchTime, splashWait, disableSplash);
                    return;
                }
                if (instance.delegate == null && UIApplicationDelegate != null)
                    instance.delegate = SystemUtilities.safeInstantiation(UIApplicationDelegate, crossmobile.ios.uikit.UIApplicationDelegate.class);
                if (instance.delegate == null) {
                    disableSplash(launchTime, splashWait, disableSplash);
                    return;
                }
                UIViewController initial = initXibApp();
                if (initial != null) {
                    if (instance.delegate.window() == null)
                        instance.delegate.setWindow(new UIWindow(UIScreen.mainScreen().bounds()));
                    try {
                        instance.delegate.window().setRootViewController(initial);
                        instance.delegate.window().makeKeyAndVisible();
                    } catch (NullPointerException ex) {
                        System.out.println("The app delegate must implement the window field and override window() and setWindow(UIWindow window) methods if it wants to use a main storyboard file.");
                    }
                }
                Native.lifecycle().postOnEventThread(() -> disableSplash(launchTime, splashWait, disableSplash));
                instance.delegate.didFinishLaunchingWithOptions(instance, Native.lifecycle().consumeLaunchOptions());
                NSNotificationCenter.defaultCenter().postNotificationName(NSNotificationName.UIApplicationDidFinishLaunching, instance);

                instance.delegate.didBecomeActive(instance);
                NSNotificationCenter.defaultCenter().postNotificationName(NSNotificationName.UIApplicationDidBecomeActive, instance);

                if (instance.keyWindow == null)
                    throw new NullPointerException("Unable to locate main Window");
                if (instance.keyWindow.rootViewController() == null)
                    throw new NullPointerException("Unable to locate main View Controller");
            });
        });
        final Object sleepForever = new Object();
        if (Native.lifecycle().isEventThread())
            Native.lifecycle().handleEventLoop();
        else
            try {
                //noinspection SynchronizationOnLocalVariableOrMethodParameter
                synchronized (sleepForever) {
                    sleepForever.wait();
                }
            } catch (InterruptedException ignored) {
            }
        return 0;
    }

    private static void disableSplash(double launchTime, double splashWait, NSTimerDelegate disableSplash) {
        double deltaTime = (System.currentTimeMillis() - launchTime) / 1000;
        if (deltaTime >= splashWait)
            disableSplash.fireMethod(null);
        else
            NSRunLoop.mainRunLoop().addTimer(NSTimer.timerWithTimeInterval(splashWait - deltaTime, disableSplash,
                    null, false), NSRunLoopMode.Default);
    }

    private static double initSplash() {
        if (instance == null)
            return 0;
        double wait = 1;    // default waiting 1 sec
        try {
            wait = Double.parseDouble(System.getProperty("cm.splash.delay", "0"));
        } catch (NumberFormatException ex) {
        }
        String launchIB;
        if (!(launchIB = System.getProperty("cm.launch.storyboard", "")).isEmpty() && wait > 0) {
            UIStoryboard storyboard = UIStoryboard.storyboardWithName(launchIB, null);
            UIViewController splash = storyboard == null ? null : storyboard.instantiateInitialViewController();
            if (splash == null)
                return 0;
            UIWindow w = new UIWindow(UIScreen.mainScreen().bounds());
            w.setRootViewController(splash);
            w.makeKeyAndVisible();
            splashWindow = instance.keyWindow;
            if (splashWindow == null)
                return 0;
//            UIStatusBar.getStatusBar().setStatusBarHidden(true);
            splashWindow.addSubview(splashWindow.rootViewController().view());
            Native.graphics().relayoutMainView();
            Native.lifecycle().postOnEventThread(splashWindow.rootViewController().view()::layoutSubviews);

            if (wait < 0.1)
                wait = 0.3; // Minimum waiting 0.3 sec
            return wait;
        }
        return 0;
    }

    private static UIViewController initXibApp() {
        String storyBoardName = System.getProperty("cm.main.storyboard");
        if (storyBoardName == null || storyBoardName.isEmpty()) {
            String xib = System.getProperty(Native.graphics().metrics().getIdiom() == UIUserInterfaceIdiom.Phone ? "cm.main.nib.name.phone" : "cm.main.nib.name.pad");
            if (xib == null || xib.trim().isEmpty())
                return null;
            else
                UINib.nibWithNibName(xib, null).instantiateWithOwner(null, null);
        }
        UIStoryboard storyBoard = UIStoryboard.storyboardWithName(storyBoardName, null);
        return storyBoard == null ? null : storyBoard.instantiateInitialViewController();
    }

    /**
     * Returns the delegate of the application
     *
     * @return The delegate of the application.
     */
    @CMGetter("@property(nonatomic, assign) id<UIApplicationDelegate> delegate;")
    public UIApplicationDelegate delegate() {
        return delegate;
    }

    /**
     * Sets the delegate for the application.
     *
     * @param delegate The delegate of the application.
     */
    @CMSetter("@property(nonatomic, assign) id<UIApplicationDelegate> delegate;")
    public void setDelegate(UIApplicationDelegate delegate) {
        this.delegate = delegate;
    }

    /**
     * Returns a Boolean that shows if the idle timer is enabled.
     *
     * @return A Boolean that shows if the idle timer is enabled.
     */
    @CMGetter("@property(nonatomic, getter=isIdleTimerDisabled) BOOL idleTimerDisabled;")
    public boolean isIdleTimerDisabled() {
        return this.idleTimerDisabled;
    }

    /**
     * Sets a Boolean that defines whether the idle timer is enabled.
     *
     * @param flag A Boolean that defines whether the idle timer is enabled.
     */
    @CMSetter("@property(nonatomic, getter=isIdleTimerDisabled) BOOL idleTimerDisabled;")
    public void setIdleTimerDisabled(boolean flag) {
        this.idleTimerDisabled = flag;
    }

    /**
     * Returns the style of the status bar.
     *
     * @return The style of the status bar.
     * @see crossmobile.ios.uikit.UIStatusBarStyle
     */
    @Deprecated
    @CMGetter("@property(readonly, nonatomic) UIStatusBarStyle statusBarStyle;")
    public int statusBarStyle() {
        return UIStatusBar.getStatusBar().statusBarStyleDark() ? UIStatusBarStyle.Default : UIStatusBarStyle.LightContent;
    }

    /**
     * Sets the style of the status bar with animation option.
     *
     * @param UIStatusBarStyle The style of the status bar.
     * @param animated         Changing style is animated if is set true.
     * @see crossmobile.ios.uikit.UIStatusBarStyle
     */
    @Deprecated
    @CMSelector("- (void)setStatusBarStyle:(UIStatusBarStyle)statusBarStyle \n"
            + "                 animated:(BOOL)animated;")
    public void setStatusBarStyle(int UIStatusBarStyle, boolean animated) {
        Native.system().error("UIApplication.setStatusBarStyle is deprecated and has no effect", null);
    }

    /**
     * Returns a Boolean that shows whether the status bar is hidden.
     *
     * @return A Boolean that shows whether the status bar is hidden.
     */
    @Deprecated
    @CMGetter("@property(readonly, nonatomic, getter=isStatusBarHidden) BOOL statusBarHidden;")
    public boolean isStatusBarHidden() {
        return UIStatusBar.getStatusBar().isStatusBarHidden();
    }

    /**
     * Conceals or reveals the status bar with animation option.
     *
     * @param statusbarhidden If true the status bar is hidden.
     * @param animated        If true the status bar is hidden with animation.
     */
    @Deprecated
    @CMSelector("- (void)setStatusBarHidden:(BOOL)hidden animated:(BOOL)animated;")
    public void setStatusBarHidden(boolean statusbarhidden, boolean animated) {
        Native.system().error("UIApplication.setStatusBarHidden is deprecated and has no effect", null);
    }

    /**
     * Returns the current orientation of the status bar.
     *
     * @return The current orientation of the status bar.
     */
    @Deprecated
    @CMGetter("@property(readonly, nonatomic) UIInterfaceOrientation statusBarOrientation;")
    public int statusBarOrientation() {
        return UIStatusBar.getStatusBar().statusBarOrientation();
    }

    /**
     * Changes the orientation of the status bar using animation option.
     *
     * @param UIInterfaceOrientation The new orientation of the status bar.
     * @param animated               The change is animated if set true.
     * @see crossmobile.ios.uikit.UIInterfaceOrientation
     */
    @Deprecated
    @CMSelector("- (void)setStatusBarOrientation:(UIInterfaceOrientation)interfaceOrientation \n"
            + "                       animated:(BOOL)animated;")
    public void setStatusBarOrientation(int UIInterfaceOrientation, boolean animated) {
        UIStatusBar.getStatusBar().setStatusBarOrientation(UIInterfaceOrientation, animated);
    }

    /**
     * Returns a Boolean that shows whether network activity is on.
     *
     * @return A Boolean that shows whether network activity is on.
     */
    @CMGetter("@property(nonatomic, getter=isNetworkActivityIndicatorVisible) BOOL networkActivityIndicatorVisible;")
    public boolean isNetworkActivityIndicatorVisible() {
        return networkActivityIndicatorVisible;
    }

    /**
     * Sets a Boolean that defines whether network activity is on.
     *
     * @param networkActivityIndicatorVisible A Boolean that defines whether
     *                                        network activity is on.
     */
    @CMSetter("@property(nonatomic, getter=isNetworkActivityIndicatorVisible) BOOL networkActivityIndicatorVisible;")
    public void setNetworkActivityIndicatorVisible(boolean networkActivityIndicatorVisible) {
        this.networkActivityIndicatorVisible = networkActivityIndicatorVisible;
    }

    void setKeyWindow(UIWindow window) {
        if (!windows.contains(window))
            windows.add(window);
        keyWindow = window;
    }

    /**
     * Returns the window of the application.
     *
     * @return The window of the application.
     */
    @CMGetter("@property(nonatomic, readonly) UIWindow *keyWindow;")
    public UIWindow keyWindow() {
        return keyWindow;
    }

    /**
     * Returns a list with the visible and hidden windows.
     *
     * @return The application's visible and hidden windows.
     */
    @CMGetter("@property(nonatomic, readonly) NSArray<__kindof UIWindow *> *windows;")
    public List<UIWindow> windows() {
        return new ArrayList<>(windows);
    }

    @CMGetter("@property(nonatomic) NSInteger applicationIconBadgeNumber;")
    public int applicationIconBadgeNumber() {
        return applicationIconBadgeNumber;
    }

    @CMSetter("@property(nonatomic) NSInteger applicationIconBadgeNumber;")
    public void setApplicationIconBadgeNumber(int applicationIconBadgeNumber) {
        this.applicationIconBadgeNumber = applicationIconBadgeNumber;
    }

    /**
     * Check whether a URL can be opened
     *
     * @param url The URL to check
     * @return true if this URL is supported
     */
    @CMSelector("- (BOOL)canOpenURL:(NSURL *)url;")
    public boolean canOpenURL(NSURL url) {
        return url != null && Native.network().canOpenURL(url.absoluteString());
    }

    /**
     * Opens the specific URL using the provided URL options. In any case the completion handler is called
     * with the success code. This method returns immediately.
     *
     * @param url        The requested URL
     * @param options    A Map of open options, as described {@link }
     * @param completion Callback if the requests to open the URL was successful
     */
    @CMSelector("- (void)openURL:(NSURL *)url \n" +
            "        options:(NSDictionary<UIApplicationOpenExternalURLOptionsKey, id> *)options \n" +
            "completionHandler:(void (^)(BOOL success))completion;")
    public void openURL(NSURL url, Map<String, Object> options, VoidBlock1<Boolean> completion) {
        Native.lifecycle().postOnEventThread(() -> {
            boolean result = url != null && isValidLink(options, url) && openURL(url);
            if (completion != null)
                completion.invoke(result);
        });
    }

    private static boolean isValidLink(Map<String, Object> options, NSURL url) {
        if (options != null)
            if (BaseUtils.objectToBoolean(options.get(UIApplicationOpenExternalURLOptionsKey.UniversalLinksOnly)))
                return Native.network().isUniversalLink(url.absoluteString());
        return true;
    }

    /**
     * Opens the specified URL with appropriate application for this scheme.
     *
     * @param URLWithString The requested URL
     * @return True if opened successfully
     */
    @Deprecated
    @CMSelector("- (BOOL)openURL:(NSURL *)url;")
    public boolean openURL(NSURL URLWithString) {
        String url = URLWithString.absoluteString();
        String lurl = url.toLowerCase();

        if (lurl.startsWith("telprompt:")) {
            url = "tel" + url.substring(9);
            lurl = "tel" + lurl.substring(9);
        }
        if (lurl.startsWith("tel:")) {
            url = url.substring(4);
            return Native.system().launchPhoneCall(url);
        } else if (lurl.startsWith("sms:")) {
            url = url.substring(4);
            List<String> recipients = new ArrayList<>();
            recipients.add(url);
            return Native.message().launchSMS(recipients, "", null);
        } else
            return Native.network().openURL(URLWithString.absoluteString());
    }

    /**
     * Registers the application to receive notifications.
     */
    @CMSelector("- (void)registerForRemoteNotifications;")
    public void registerForRemoteNotifications() {
        Native.notification().registerForRemoteNotifications();
    }

    /**
     * Registers the application to receive remote notification of the specified
     * type.
     *
     * @param UIRemoteNotificationType The type of remote notification that the
     *                                 application is registered to receive.
     * @see crossmobile.ios.uikit.UIRemoteNotificationType
     */
    @Deprecated
    @CMSelector("- (void)registerForRemoteNotificationTypes:(UIRemoteNotificationType)types;")
    public void registerForRemoteNotificationTypes(int UIRemoteNotificationType) {
        // TODO : Java implementation
    }

    /**
     * Unregisters the application from receiving remote notifications.
     */
    @CMSelector("- (void)unregisterForRemoteNotifications;")
    public void unregisterForRemoteNotifications() {
        // TODO : Java implementation
    }

    /**
     * Returns the types of remote notifications that the application receives.
     *
     * @return The types of notifications that the application receives.
     * @see crossmobile.ios.uikit.UIRemoteNotificationType
     */
    @Deprecated
    @CMSelector("- (UIRemoteNotificationType)enabledRemoteNotificationTypes;")
    public int enabledRemoteNotificationTypes() {
        // TODO : Java implementation
        return 0;
    }

    /**
     * Registers the notification settings that the user selects.
     *
     * @param notificationSettings User's notification settings.
     */
    @CMSelector("- (void)registerUserNotificationSettings:(UIUserNotificationSettings *)notificationSettings;")
    @Deprecated
    public void registerUserNotificationSettings(UIUserNotificationSettings notificationSettings) {
        this.notificationSettings = this.currentUserNotificationSettings = notificationSettings;
        UNUserNotificationCenter.currentNotificationCenter().requestAuthorizationWithOptions(notificationTypeToAuthorizationOption(notificationSettings.types()), (result, error) -> {
            if (delegate != null)
                if (result)
                    delegate.didRegisterUserNotificationSettings(this, notificationSettings);
                else
                    delegate.didFailToRegisterForRemoteNotificationsWithError(this, error);
        });
    }

    /**
     * Returns the current notification settings.
     *
     * @return User's current notification settings.
     */
    @CMGetter("@property(nonatomic, readonly) UIUserNotificationSettings *currentUserNotificationSettings;")
    public UIUserNotificationSettings currentUserNotificationSettings() {
        return currentUserNotificationSettings;
    }

    /**
     * Return whether the interface layout is left-to-right or right-to-left
     *
     * @return Left-to-right or Right-to-left, as defined in UIUserInterfaceLayoutDirection
     * @see UIUserInterfaceLayoutDirection
     */
    @CMGetter("@property(nonatomic, readonly) UIUserInterfaceLayoutDirection userInterfaceLayoutDirection;")
    public int userInterfaceLayoutDirection() {
        return userInterfaceLayoutDirection;
    }

    /**
     * The state of the application
     *
     * @return application state
     * @see UIApplicationState
     */
    @CMGetter("@property(nonatomic, readonly) UIApplicationState applicationState;")
    public int applicationState() {
        return Native.lifecycle().getApplicationState();
    }

    @Override
    public UIResponder nextResponder() {
        return delegate instanceof UIResponder ? (UIResponder) delegate : null;
    }
}
