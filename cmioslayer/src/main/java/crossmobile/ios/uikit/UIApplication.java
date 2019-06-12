/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package crossmobile.ios.uikit;

import crossmobile.ios.foundation.*;
import org.crossmobile.bind.graphics.UIStatusBar;
import org.crossmobile.bind.system.SystemUtilities;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.crossmobile.bridge.ann.CMParamMod.JAVA_PARAM;
import static org.crossmobile.bridge.ann.CMParamMod.NATIVE_PARAM;

/**
 * UIApplication class defines an object that is uniquely associated with an
 * application and includes related control and coordination methods.
 */
@CMClass
public class UIApplication extends UIResponder {

    static UIWindow splashWindow = null;
    private static UIApplication instance;
    List<UIWindow> windows;
    private boolean idleTimerDisabled;
    private UIApplicationDelegate delegate;
    private UIWindow keyWindow;
    private boolean networkActivityIndicatorVisible;
    private UIUserNotificationSettings notificationSettings;
    private UIUserNotificationSettings currentUserNotificationSettings;
    private int applicationIconBadgeNumber;
    private final int userInterfaceLayoutDirection = Native.system().isRTL() ? UIUserInterfaceLayoutDirection.RightToLeft : UIUserInterfaceLayoutDirection.LeftToRight;

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
    public static int main(@CMJoinMEM(memory = "argv", size = "argc") String[] args, @CMParamMod(code = ""
            + "NSString* appName = [" + JAVA_PARAM + " getName__];\n"
            + "NSString* " + NATIVE_PARAM + " = [appName stringByReplacingOccurrencesOfString: @\".\" withString: @\"_\"];\n"
            + "[appName release];\n"
            + "", type = String.class) Class<? extends UIApplication> UIApplication, @CMParamMod(code = ""
            + "NSString* delName = [" + JAVA_PARAM + " getName__];\n"
            + "NSString* " + NATIVE_PARAM + " = [delName stringByReplacingOccurrencesOfString: @\".\" withString: @\"_\"];\n"
            + "[delName release];\n"
            + "", type = String.class) Class<? extends UIApplicationDelegate> UIApplicationDelegate) {
        Native.prepare(null);
        Native.lifecycle().init(args);

        // This is preferred since the constraint put during lifetime initialization under Android might not be enough, and a second one here might be required.
        if (instance == null)
            instance = SystemUtilities.safeInstantiation(UIApplication, crossmobile.ios.uikit.UIApplication.class);
        double splashWait = initSplash();
        double launchTime = System.currentTimeMillis();
        Native.graphics().refreshDisplay();
        final Object sleepForever = new Object();
        NSTimerDelegate disableSpash = timer -> {
            instance.windows.remove(splashWindow);
            splashWindow = null;
            if (instance.windows.isEmpty())
                instance.setKeyWindow(null);
            Native.lifecycle().splashTerminated();
            Native.graphics().refreshDisplay();
            if (UIResponder.reqeuestResponderBeforeInit != null)
                Native.system().postOnEventThread(() -> {
                    UIResponder.reqeuestResponderBeforeInit.becomeFirstResponder();
                    UIResponder.reqeuestResponderBeforeInit = null;
                });
            instance.setStatusBarStyle(crossmobile.ios.uikit.UIStatusBarStyle.Default, false);
        };
        Native.system().postOnEventThread(() -> {
            if (instance == null) {
                disableSplash(launchTime, splashWait, disableSpash);
                return;
            }
            if (instance.delegate == null && UIApplicationDelegate != null)
                instance.delegate = SystemUtilities.safeInstantiation(UIApplicationDelegate, crossmobile.ios.uikit.UIApplicationDelegate.class);
            if (instance.delegate == null) {
                disableSplash(launchTime, splashWait, disableSpash);
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
            instance.setStatusBarHidden(Boolean.getBoolean("cm.statusbar.hidden"), false); // also sets orientation
            instance.delegate.didFinishLaunchingWithOptions(instance, new HashMap<>());
            NSNotificationCenter.defaultCenter().postNotificationName(NSNotificationName.UIApplicationDidFinishLaunching, instance);

            instance.delegate.didBecomeActive(instance);
            NSNotificationCenter.defaultCenter().postNotificationName(NSNotificationName.UIApplicationDidBecomeActive, instance);

            if (instance.keyWindow == null)
                throw new NullPointerException("Unable to locate main Window");
            if (instance.keyWindow.rootViewController() == null)
                throw new NullPointerException("Unable to locate main View Controller");
            instance.keyWindow.addSubview(instance.keyWindow.rootViewController().view());
            Native.graphics().relayoutMainView();
            Native.system().postOnEventThread(instance.keyWindow::layoutSubviews);
            disableSplash(launchTime, splashWait, disableSpash);
        });
        if (!Native.system().isEventThread())
            try {
                synchronized (sleepForever) {
                    sleepForever.wait();
                }
            } catch (InterruptedException ex) {
            }
        return 0;
    }

    private static void disableSplash(double launchTime, double splashWait, NSTimerDelegate disableSpash) {
        double deltaTime = (System.currentTimeMillis() - launchTime) / 1000;
        if (deltaTime >= splashWait)
            disableSpash.fireMethod(null);
        else
            NSTimer.scheduledTimerWithTimeInterval(splashWait - deltaTime, disableSpash, null, false);
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
            instance.setStatusBarHidden(Boolean.getBoolean("cm.statusbar.hidden"), false); // also sets orientation
            splashWindow = instance.keyWindow;
            if (splashWindow == null)
                return 0;
            splashWindow.addSubview(splashWindow.rootViewController().view());
            Native.graphics().relayoutMainView();
            Native.system().postOnEventThread(splashWindow.rootViewController().view()::layoutSubviews);

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
        UIStatusBar.getStatusBar().setStatusBarStyleDark(UIStatusBarStyle == crossmobile.ios.uikit.UIStatusBarStyle.Default);
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
        UIStatusBar.getStatusBar().setStatusBarHidden(statusbarhidden, animated);
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
     * Opens the specified URL with appropriate application for this scheme.
     *
     * @param URLWithString An object with the specified scheme for the URL.
     * @return True if opened successfully.
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
            return Native.system().launchPhonecall(url);
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
     * @param uiRemoteNotificationType The type of remote notification that the
     *                                 application is registered to receive.
     * @see crossmobile.ios.uikit.UIRemoteNotificationType
     */
    @Deprecated
    @CMSelector("- (void)registerForRemoteNotificationTypes:(UIRemoteNotificationType)types;")
    public void registerForRemoteNotificationTypes(int uiRemoteNotificationType) {
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
    public void registerUserNotificationSettings(UIUserNotificationSettings notificationSettings) {
        this.notificationSettings = this.currentUserNotificationSettings = notificationSettings;
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
}
