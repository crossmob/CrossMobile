// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIApplication implementation

#import "crossmobile_ios_foundation_NSURL.h"
#import "crossmobile_ios_uikit_UIApplication.h"
#import "crossmobile_ios_uikit_UIApplicationDelegate.h"
#import "crossmobile_ios_uikit_UIUserNotificationSettings.h"
#import "crossmobile_ios_uikit_UIWindow.h"
#import "java_lang_Boolean.h"
#import "java_lang_Class.h"
#import "java_util_List.h"
#import "java_util_Map.h"
#import "org_robovm_objc_block_VoidBlock1.h"

@implementation crossmobile_ios_uikit_UIApplication$Ext

@end

@implementation UIApplication (cm_crossmobile_ios_uikit_UIApplication)

// int UIApplicationMain ( int argc, char * _Nonnull argv[], NSString *principalClassName, NSString *delegateClassName );
+ (int) main___java_lang_String_ARRAYTYPE_java_lang_Class_java_lang_Class:(XMLVMArray*) argv :(java_lang_Class*) principalClassName :(java_lang_Class*) delegateClassName 
{
    char** argv$conv = NULL;
    if (argv != JAVA_NULL && argv->length > 0) {
        argv$conv = malloc(argv->length * (sizeof(char*)));
        NSString * argv$conv$str;
        for (int argv$conv$i = 0; argv$conv$i < argv->length; argv$conv$i++) {
            argv$conv$str = argv->array.o[argv$conv$i];
            if (argv$conv$str == nil || argv$conv$str == JAVA_NULL || argv$conv$str == NULL)
                argv$conv[argv$conv$i] = 0;
            else
                argv$conv[argv$conv$i] = (char*)[argv$conv$str UTF8String];
        }
    }
    int re$ult = UIApplicationMain((argv == JAVA_NULL ? 0 : argv->length), argv$conv, jclass_to_string(principalClassName == JAVA_NULL ? nil : principalClassName), jclass_to_string(delegateClassName == JAVA_NULL ? nil : delegateClassName));
    free(argv$conv);
    return re$ult;
}

// + (UIApplication *)sharedApplication;
+ (UIApplication*) sharedApplication__
{
    UIApplication* re$ult = [UIApplication sharedApplication];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UIApplication__
{
    return [self init];
}

// @property(nonatomic) NSInteger applicationIconBadgeNumber;
- (void) setApplicationIconBadgeNumber___int:(int) applicationIconBadgeNumber 
{
    [self setApplicationIconBadgeNumber:applicationIconBadgeNumber];
}

// @property(nonatomic) NSInteger applicationIconBadgeNumber;
- (int) applicationIconBadgeNumber__
{
    return [self applicationIconBadgeNumber];
}

// @property(nonatomic, readonly) UIApplicationState applicationState;
- (int) applicationState__
{
    return [self applicationState];
}

// @property(nonatomic, readonly) UIUserNotificationSettings *currentUserNotificationSettings;
- (UIUserNotificationSettings*) currentUserNotificationSettings__
{
    UIUserNotificationSettings* re$ult = [self currentUserNotificationSettings];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, assign) id<UIApplicationDelegate> delegate;
- (void) setDelegate___crossmobile_ios_uikit_UIApplicationDelegate:(id<UIApplicationDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// @property(nonatomic, assign) id<UIApplicationDelegate> delegate;
- (id<UIApplicationDelegate>) delegate__
{
    id<UIApplicationDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, getter=isIdleTimerDisabled) BOOL idleTimerDisabled;
- (void) setIdleTimerDisabled___boolean:(BOOL) idleTimerDisabled 
{
    [self setIdleTimerDisabled:idleTimerDisabled];
}

// @property(nonatomic, getter=isIdleTimerDisabled) BOOL idleTimerDisabled;
- (BOOL) isIdleTimerDisabled__
{
    return [self isIdleTimerDisabled];
}

// @property(nonatomic, readonly) UIWindow *keyWindow;
- (UIWindow*) keyWindow__
{
    UIWindow* re$ult = [self keyWindow];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, getter=isNetworkActivityIndicatorVisible) BOOL networkActivityIndicatorVisible;
- (void) setNetworkActivityIndicatorVisible___boolean:(BOOL) networkActivityIndicatorVisible 
{
    [self setNetworkActivityIndicatorVisible:networkActivityIndicatorVisible];
}

// @property(nonatomic, getter=isNetworkActivityIndicatorVisible) BOOL networkActivityIndicatorVisible;
- (BOOL) isNetworkActivityIndicatorVisible__
{
    return [self isNetworkActivityIndicatorVisible];
}

// @property(readonly, nonatomic, getter=isStatusBarHidden) BOOL statusBarHidden;
- (BOOL) isStatusBarHidden__
{
    return [self isStatusBarHidden];
}

// @property(readonly, nonatomic) UIInterfaceOrientation statusBarOrientation;
- (int) statusBarOrientation__
{
    return [self statusBarOrientation];
}

// @property(readonly, nonatomic) UIStatusBarStyle statusBarStyle;
- (int) statusBarStyle__
{
    return [self statusBarStyle];
}

// @property(nonatomic, readonly) UIUserInterfaceLayoutDirection userInterfaceLayoutDirection;
- (int) userInterfaceLayoutDirection__
{
    return [self userInterfaceLayoutDirection];
}

// @property(nonatomic, readonly) NSArray<__kindof UIWindow *> *windows;
- (NSArray*) windows__
{
    NSArray* re$ult = [self windows];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (BOOL)canOpenURL:(NSURL *)url;
- (BOOL) canOpenURL___crossmobile_ios_foundation_NSURL:(NSURL*) url 
{
    return [self canOpenURL:(url == JAVA_NULL ? nil : url)];
}

// - (UIRemoteNotificationType)enabledRemoteNotificationTypes;
- (int) enabledRemoteNotificationTypes__
{
    return [self enabledRemoteNotificationTypes];
}

// - (BOOL)openURL:(NSURL *)url;
- (BOOL) openURL___crossmobile_ios_foundation_NSURL:(NSURL*) url 
{
    return [self openURL:(url == JAVA_NULL ? nil : url)];
}

// - (void)openURL:(NSURL *)url options:(NSDictionary<UIApplicationOpenExternalURLOptionsKey, id> *)options completionHandler:(void (^)(BOOL success))completion;
- (void) openURL___crossmobile_ios_foundation_NSURL_java_util_Map_org_robovm_objc_block_VoidBlock1:(NSURL*) url :(NSDictionary*) options :(id<org_robovm_objc_block_VoidBlock1>) completion 
{
    [self openURL:(url == JAVA_NULL ? nil : url) options:(options == JAVA_NULL ? nil : options) completionHandler:(completion == JAVA_NULL ? nil : ^(BOOL success) {
        java_lang_Boolean* success$conv = [[java_lang_Boolean alloc] initWithBool:success];
        [completion invoke___java_lang_Object:success$conv];
        [success$conv release];
    })];
}

// - (void)registerForRemoteNotificationTypes:(UIRemoteNotificationType)types;
- (void) registerForRemoteNotificationTypes___int:(int) types 
{
    [self registerForRemoteNotificationTypes:types];
}

// - (void)registerForRemoteNotifications;
- (void) registerForRemoteNotifications__
{
    [self registerForRemoteNotifications];
}

// - (void)registerUserNotificationSettings:(UIUserNotificationSettings *)notificationSettings;
- (void) registerUserNotificationSettings___crossmobile_ios_uikit_UIUserNotificationSettings:(UIUserNotificationSettings*) notificationSettings 
{
    [self registerUserNotificationSettings:(notificationSettings == JAVA_NULL ? nil : notificationSettings)];
}

// - (void)setStatusBarHidden:(BOOL)hidden animated:(BOOL)animated;
- (void) setStatusBarHidden___boolean_boolean:(BOOL) hidden :(BOOL) animated 
{
    [self setStatusBarHidden:hidden animated:animated];
}

// - (void)setStatusBarOrientation:(UIInterfaceOrientation)interfaceOrientation animated:(BOOL)animated;
- (void) setStatusBarOrientation___int_boolean:(int) interfaceOrientation :(BOOL) animated 
{
    [self setStatusBarOrientation:interfaceOrientation animated:animated];
}

// - (void)setStatusBarStyle:(UIStatusBarStyle)statusBarStyle animated:(BOOL)animated;
- (void) setStatusBarStyle___int_boolean:(int) statusBarStyle :(BOOL) animated 
{
    [self setStatusBarStyle:statusBarStyle animated:animated];
}

// - (void)unregisterForRemoteNotifications;
- (void) unregisterForRemoteNotifications__
{
    [self unregisterForRemoteNotifications];
}

@end
