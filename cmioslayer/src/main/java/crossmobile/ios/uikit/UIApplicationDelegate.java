/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.foundation.NSData;
import crossmobile.ios.foundation.NSError;
import crossmobile.ios.foundation.NSURL;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMSetter;
import org.robovm.objc.block.VoidBlock1;

import java.util.Map;

/**
 * UIApplicationDelegate interface is the delegate responsible for handling
 * events related to UIApplication singleton object of the application.
 */
@SuppressWarnings("unused")
@CMClass
public interface UIApplicationDelegate {

    /**
     * Constructs and returns the main application window as provided by the delegate.
     *
     * @return The main application window as provided by the delegate
     */
//  @CMSelector("-(UIWindow*) window;")
    @CMGetter("@property(nonatomic, strong) UIWindow *window;")
    default UIWindow window() {
        return null;
    }

    /**
     * The window to use when presenting a storyboard.
     *
     * @param window The window to use when presenting a storyboard.
     */
//  @CMSelector("- (void) setWindow:(UIWindow *)window")
    @CMSetter("@property(nonatomic, strong) UIWindow *window;")
    default void setWindow(UIWindow window) {
    }

    /**
     * It is used in order to handle the fact that the application finishes
     * launching and is about to run.
     *
     * @param app           The singleton application object.
     * @param launchOptions Details of launching in case the application was not
     *                      launched by the user
     * @return FALSE if the app cannot handle the URL resource or continue a
     * user activity.
     * @see UIApplicationLaunchOptionsKey
     */
    @CMSelector("- (BOOL)application:(UIApplication *)application \n"
            + "didFinishLaunchingWithOptions:(NSDictionary *)launchOptions;")
    default boolean didFinishLaunchingWithOptions(UIApplication app, Map<String, Object> launchOptions) {
        return true;
    }

    /**
     * It is used in order to open the specified URL.
     *
     * @param app               The singleton application object.
     * @param url               The URL to open.
     * @param sourceApplication The id of the application that is requesting
     *                          from this app to open the URL.
     * @param annotation        Properties supplied by the source application.
     * @return TRUE if the URL opened successfully.
     */
    @CMSelector("- (BOOL)application:(UIApplication *)application \n"
            + "            openURL:(NSURL *)url \n"
            + "  sourceApplication:(NSString *)sourceApplication \n"
            + "         annotation:(id)annotation;")
    default boolean openURL(UIApplication app, NSURL url, String sourceApplication, Object annotation) {
        return true;
    }

    /**
     * It is used in order to handle the fact that the application has become
     * active.
     *
     * @param app The singleton application object.
     */
    @CMSelector("- (void)applicationDidBecomeActive:(UIApplication *)application;")
    default void didBecomeActive(UIApplication app) {
    }

    /**
     * It is used in order to handle the fact that the application will become
     * inactive.
     *
     * @param app The singleton application object.
     */
    @CMSelector("- (void)applicationWillResignActive:(UIApplication *)application;")
    default void willResignActive(UIApplication app) {
    }

    /**
     * It is used in order to handle the fact that the application is in the
     * background.
     *
     * @param app The singleton application object.
     */
    @CMSelector("- (void)applicationDidEnterBackground:(UIApplication *)application;")
    default void didEnterBackground(UIApplication app) {
    }

    /**
     * It is used in order to handle the fact that the application will enter
     * the foreground.
     *
     * @param app The singleton application object.
     */
    @CMSelector("- (void)applicationWillEnterForeground:(UIApplication *)application;")
    default void willEnterForeground(UIApplication app) {
    }

    /**
     * It is used in order to handle the imminent termination of the
     * application.
     *
     * @param app The singleton application object.
     */
    @CMSelector("- (void)applicationWillTerminate:(UIApplication *)application;")
    default void willTerminate(UIApplication app) {
    }

    /**
     * It is used in order to handle a remote notification that arrived.
     *
     * @param app      The singleton application object.
     * @param userinfo Information related to the remote notification.
     */
    @CMSelector("- (void)application:(UIApplication *)application \n"
            + "didReceiveRemoteNotification:(NSDictionary *)userInfo;")
    default void didReceiveRemoteNotification(UIApplication app, Map<String, Object> userinfo) {
    }

    @CMSelector("- (void)application:(UIApplication *)application \n" +
            "didReceiveRemoteNotification:(NSDictionary *)userInfo \n" +
            "fetchCompletionHandler:(void (^)(UIBackgroundFetchResult result))completionHandler;")
    default void didReceiveRemoteNotificationFetchCompletionHandler(UIApplication app, Map<String, Object> userinfo, VoidBlock1<Integer> completionHandler) {
    }

    /**
     * It is used after a successful registration to the notification service.
     *
     * @param app         The application object that initiated the registration
     *                    process.
     * @param deviceToken A token that identifies the device to APNs.
     */
    @CMSelector("- (void)application:(UIApplication *)application \n"
            + "didRegisterForRemoteNotificationsWithDeviceToken:(NSData *)deviceToken;")
    default void didRegisterForRemoteNotificationsWithDeviceToken(UIApplication app, NSData deviceToken) {
    }

    /**
     * It is used in order to handle the fact that the notification service
     * cannot complete the registration process.
     *
     * @param app   The application object that initiated registration process.
     * @param error The error that occurred.
     */
    @CMSelector("- (void)application:(UIApplication *)application \n"
            + "didFailToRegisterForRemoteNotificationsWithError:(NSError *)error;")
    @Deprecated
    default void didFailToRegisterForRemoteNotificationsWithError(UIApplication app, NSError error) {
    }

    /**
     * It is used in order to handle a local notification.
     *
     * @param app          The application that received the local notification.
     * @param notification The local notification.
     */
    @SuppressWarnings("deprecation")
    @CMSelector("- (void)application:(UIApplication *)application \n"
            + "didReceiveLocalNotification:(UILocalNotification *)notification;")
    default void didReceiveLocalNotification(UIApplication app, UILocalNotification notification) {
    }

    /**
     * It is used in order to handle a memory warning from the system.
     *
     * @param app The singleton application object.
     */
    @CMSelector("- (void)applicationDidReceiveMemoryWarning:(UIApplication *)application;")
    default void didReceiveMemoryWarning(UIApplication app) {
    }

    /**
     * It is used in order to handle a significant change in the time.
     *
     * @param app The singleton application object.
     */
    @CMSelector("- (void)applicationSignificantTimeChange:(UIApplication *)application;")
    default void significantTimeChange(UIApplication app) {
    }

    /**
     * It is used in order to handle the fact that the orientation of the status
     * bar is about to change.
     *
     * @param app                     The singleton application object.
     * @param oldStatusBarOrientation The new orientation of the status bar.
     * @param duration                The duration of the animation in seconds.
     */
    @CMSelector("- (void)application:(UIApplication *)application \n"
            + "willChangeStatusBarOrientation:(UIInterfaceOrientation)newStatusBarOrientation \n"
            + "           duration:(NSTimeInterval)duration;")
    default void willChangeStatusBarOrientation(UIApplication app, int oldStatusBarOrientation, double duration) {
    }

    /**
     * It is used in order to handle the fact that the orientation of the status
     * bar has changed.
     *
     * @param app                     The singleton application object.
     * @param oldStatusBarOrientation The orientation of the status bar before
     *                                the change.
     */
    @CMSelector("- (void)application:(UIApplication *)application \n"
            + "didChangeStatusBarOrientation:(UIInterfaceOrientation)oldStatusBarOrientation;")
    default void didChangeStatusBarOrientation(UIApplication app, int oldStatusBarOrientation) {
    }

    /**
     * It is used in order to handle the fact that the frame of the status bar
     * is about to change.
     *
     * @param app               The singleton application object.
     * @param oldStatusBarFrame The frame of the status bar before the change.
     */
    @CMSelector("- (void)application:(UIApplication *)application \n"
            + "willChangeStatusBarFrame:(CGRect)newStatusBarFrame;")
    default void willChangeStatusBarFrame(UIApplication app, CGRect oldStatusBarFrame) {
    }

    /**
     * Used in order to handle the fact that the frame of the status bar has
     * changed.
     *
     * @param app               The singleton application object.
     * @param oldStatusBarFrame The frame of the status bar before the change.
     */
    @CMSelector("- (void)application:(UIApplication *)application \n"
            + "didChangeStatusBarFrame:(CGRect)oldStatusBarFrame;")
    default void didChangeStatusBarFrame(UIApplication app, CGRect oldStatusBarFrame) {
    }

    /**
     * It is used in order to handle the fact that protected files become
     * unavailable.
     *
     * @param app The singleton application object.
     */
    @CMSelector("- (void)applicationProtectedDataWillBecomeUnavailable:(UIApplication *)application;")
    default void protectedDataWillBecomeUnavailable(UIApplication app) {
    }

    /**
     * It is used in order to handle the fact that the protected files become
     * available.
     *
     * @param app The singleton application object.
     */
    @CMSelector("- (void)applicationProtectedDataDidBecomeAvailable:(UIApplication *)application;")
    default void protectedDataDidBecomeAvailable(UIApplication app) {
    }

    @CMSelector("- (void)application:(UIApplication *)application \n"
            + "didRegisterUserNotificationSettings:(UIUserNotificationSettings *)notificationSettings;")
    @Deprecated
    default void didRegisterUserNotificationSettings(UIApplication application, UIUserNotificationSettings notificationSettings) {
    }

    @SuppressWarnings("rawtypes")
    @CMSelector("- (void)application:(UIApplication *)application \n"
            + "handleActionWithIdentifier:(NSString *)identifier \n"
            + "forRemoteNotification:(NSDictionary *)userInfo \n"
            + "  completionHandler:(void (^)(void))completionHandler;")
    default void handleActionWithIdentifierForRemoteNotification(UIApplication application, String identifier, Map userInfo, Runnable completionHandler) {
    }

    @SuppressWarnings("deprecation")
    @CMSelector("- (void)application:(UIApplication *)application \n"
            + "handleActionWithIdentifier:(NSString *)identifier \n"
            + "forLocalNotification:(UILocalNotification *)notification \n"
            + "  completionHandler:(void (^)(void))completionHandler;")
    default void handleActionWithIdentifierForLocalNotification(UIApplication application, String identifier, UILocalNotification notification, Runnable completionHandler) {
    }
}
