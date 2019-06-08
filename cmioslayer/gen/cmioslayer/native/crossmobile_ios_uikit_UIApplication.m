// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIApplication implementation

#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_foundation_NSURL.h"
#import "crossmobile_ios_uikit_UIApplication.h"
#import "crossmobile_ios_uikit_UIApplicationDelegate.h"
#import "crossmobile_ios_uikit_UIEvent.h"
#import "crossmobile_ios_uikit_UIResponder.h"
#import "crossmobile_ios_uikit_UIUserNotificationSettings.h"
#import "crossmobile_ios_uikit_UIWindow.h"
#import "java_lang_Class.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Map.h"
#import "java_util_Set.h"

@implementation crossmobile_ios_uikit_UIApplication$Ext

// (UIApplication) @property(nonatomic) NSInteger applicationIconBadgeNumber;
- (void) setApplicationIconBadgeNumber___int:(int) applicationIconBadgeNumber 
{
    [super setApplicationIconBadgeNumber:applicationIconBadgeNumber];
}

// (UIApplication) @property(nonatomic) NSInteger applicationIconBadgeNumber;
- (int) applicationIconBadgeNumber__
{
    return [super applicationIconBadgeNumber];
}

// (UIApplication) @property(nonatomic, readonly) UIUserNotificationSettings *currentUserNotificationSettings;
- (UIUserNotificationSettings*) currentUserNotificationSettings__
{
    UIUserNotificationSettings* re$ult = [super currentUserNotificationSettings];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIApplication) @property(nonatomic, assign) id<UIApplicationDelegate> delegate;
- (void) setDelegate___crossmobile_ios_uikit_UIApplicationDelegate:(id<UIApplicationDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [super setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// (UIApplication) @property(nonatomic, assign) id<UIApplicationDelegate> delegate;
- (id<UIApplicationDelegate>) delegate__
{
    id<UIApplicationDelegate> re$ult = [super delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIApplication) @property(nonatomic, getter=isIdleTimerDisabled) BOOL idleTimerDisabled;
- (void) setIdleTimerDisabled___boolean:(BOOL) idleTimerDisabled 
{
    [super setIdleTimerDisabled:idleTimerDisabled];
}

// (UIApplication) @property(nonatomic, getter=isIdleTimerDisabled) BOOL idleTimerDisabled;
- (BOOL) isIdleTimerDisabled__
{
    return [super isIdleTimerDisabled];
}

// (UIApplication) @property(nonatomic, readonly) UIWindow *keyWindow;
- (UIWindow*) keyWindow__
{
    UIWindow* re$ult = [super keyWindow];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIApplication) @property(nonatomic, getter=isNetworkActivityIndicatorVisible) BOOL networkActivityIndicatorVisible;
- (void) setNetworkActivityIndicatorVisible___boolean:(BOOL) networkActivityIndicatorVisible 
{
    [super setNetworkActivityIndicatorVisible:networkActivityIndicatorVisible];
}

// (UIApplication) @property(nonatomic, getter=isNetworkActivityIndicatorVisible) BOOL networkActivityIndicatorVisible;
- (BOOL) isNetworkActivityIndicatorVisible__
{
    return [super isNetworkActivityIndicatorVisible];
}

// (UIApplication) @property(readonly, nonatomic, getter=isStatusBarHidden) BOOL statusBarHidden;
- (BOOL) isStatusBarHidden__
{
    return [super isStatusBarHidden];
}

// (UIApplication) @property(readonly, nonatomic) UIInterfaceOrientation statusBarOrientation;
- (int) statusBarOrientation__
{
    return [super statusBarOrientation];
}

// (UIApplication) @property(readonly, nonatomic) UIStatusBarStyle statusBarStyle;
- (int) statusBarStyle__
{
    return [super statusBarStyle];
}

// (UIApplication) @property(nonatomic, readonly) UIUserInterfaceLayoutDirection userInterfaceLayoutDirection;
- (int) userInterfaceLayoutDirection__
{
    return [super userInterfaceLayoutDirection];
}

// (UIApplication) @property(nonatomic, readonly) NSArray<__kindof UIWindow *> *windows;
- (NSArray*) windows__
{
    NSArray* re$ult = [super windows];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
}

// (UIResponder) - (BOOL)becomeFirstResponder;
- (BOOL) becomeFirstResponder__
{
    return [super becomeFirstResponder];
}

// (UIApplication) - (UIRemoteNotificationType)enabledRemoteNotificationTypes;
- (int) enabledRemoteNotificationTypes__
{
    return [super enabledRemoteNotificationTypes];
}

// (UIResponder) - (BOOL)isFirstResponder;
- (BOOL) isFirstResponder__
{
    return [super isFirstResponder];
}

// (UIResponder) - (UIResponder *)nextResponder;
- (UIResponder*) nextResponder__
{
    UIResponder* re$ult = [super nextResponder];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (void)observeValueForKeyPath:(NSString *)keyPath ofObject:(id)object change:(NSDictionary<NSKeyValueChangeKey, id> *)change context:(void *)context;
- (void) observeValueForKeyPath___java_lang_String_java_lang_Object_java_util_Map_java_lang_Object:(NSString*) keyPath :(id) object :(NSDictionary*) change :(id) context 
{
    [super observeValueForKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) ofObject:(object == JAVA_NULL ? nil : object) change:(change == JAVA_NULL ? nil : change) context:(context == JAVA_NULL ? nil : context)];
}

// (UIApplication) - (BOOL)openURL:(NSURL *)url;
- (BOOL) openURL___crossmobile_ios_foundation_NSURL:(NSURL*) url 
{
    return [super openURL:(url == JAVA_NULL ? nil : url)];
}

// (UIApplication) - (void)registerForRemoteNotificationTypes:(UIRemoteNotificationType)types;
- (void) registerForRemoteNotificationTypes___int:(int) types 
{
    [super registerForRemoteNotificationTypes:types];
}

// (UIApplication) - (void)registerForRemoteNotifications;
- (void) registerForRemoteNotifications__
{
    [super registerForRemoteNotifications];
}

// (UIApplication) - (void)registerUserNotificationSettings:(UIUserNotificationSettings *)notificationSettings;
- (void) registerUserNotificationSettings___crossmobile_ios_uikit_UIUserNotificationSettings:(UIUserNotificationSettings*) notificationSettings 
{
    [super registerUserNotificationSettings:(notificationSettings == JAVA_NULL ? nil : notificationSettings)];
}

// (NSObject) - (void)removeObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath;
- (void) removeObserver___crossmobile_ios_foundation_NSObject_java_lang_String:(NSObject*) observer :(NSString*) keyPath 
{
    [super removeObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath)];
}

// (NSObject) - (void)removeObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath context:(void *)context;
- (void) removeObserver___crossmobile_ios_foundation_NSObject_java_lang_String_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(id) context 
{
    [super removeObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) context:(context == JAVA_NULL ? nil : context)];
}

// (UIResponder) - (BOOL)resignFirstResponder;
- (BOOL) resignFirstResponder__
{
    return [super resignFirstResponder];
}

// (UIApplication) - (void)setStatusBarHidden:(BOOL)hidden animated:(BOOL)animated;
- (void) setStatusBarHidden___boolean_boolean:(BOOL) hidden :(BOOL) animated 
{
    [super setStatusBarHidden:hidden animated:animated];
}

// (UIApplication) - (void)setStatusBarOrientation:(UIInterfaceOrientation)interfaceOrientation animated:(BOOL)animated;
- (void) setStatusBarOrientation___int_boolean:(int) interfaceOrientation :(BOOL) animated 
{
    [super setStatusBarOrientation:interfaceOrientation animated:animated];
}

// (UIApplication) - (void)setStatusBarStyle:(UIStatusBarStyle)statusBarStyle animated:(BOOL)animated;
- (void) setStatusBarStyle___int_boolean:(int) statusBarStyle :(BOOL) animated 
{
    [super setStatusBarStyle:statusBarStyle animated:animated];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValueForKey___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (void)setValue:(id)value forUndefinedKey:(NSString *)key;
- (void) setValueForUndefinedKey___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forUndefinedKey:(key == JAVA_NULL ? nil : key)];
}

// (UIResponder) - (void)touchesBegan:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event;
- (void) touchesBegan___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event 
{
    [super touchesBegan:(touches == JAVA_NULL ? nil : touches) withEvent:(event == JAVA_NULL ? nil : event)];
}

// (UIResponder) - (void)touchesCancelled:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event;
- (void) touchesCancelled___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event 
{
    [super touchesCancelled:(touches == JAVA_NULL ? nil : touches) withEvent:(event == JAVA_NULL ? nil : event)];
}

// (UIResponder) - (void)touchesEnded:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event;
- (void) touchesEnded___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event 
{
    [super touchesEnded:(touches == JAVA_NULL ? nil : touches) withEvent:(event == JAVA_NULL ? nil : event)];
}

// (UIResponder) - (void)touchesMoved:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event;
- (void) touchesMoved___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event 
{
    [super touchesMoved:(touches == JAVA_NULL ? nil : touches) withEvent:(event == JAVA_NULL ? nil : event)];
}

// (UIApplication) - (void)unregisterForRemoteNotifications;
- (void) unregisterForRemoteNotifications__
{
    [super unregisterForRemoteNotifications];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (id)valueForUndefinedKey:(NSString *)key;
- (id) valueForUndefinedKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForUndefinedKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end

@implementation UIApplication (cm_crossmobile_ios_uikit_UIApplication)

// direct binding of: int UIApplicationMain ( int argc, char * _Nonnull argv[], NSString *principalClassName, NSString *delegateClassName );
+ (int) main___java_lang_String_ARRAYTYPE_java_lang_Class_java_lang_Class:(XMLVMArray*) argv :(java_lang_Class*) principalClassName :(java_lang_Class*) delegateClassName 
{
    char** argv$conv = NULL;
    if (argv != JAVA_NULL && argv->length > 0) {
        argv$conv = malloc(argv->length * (sizeof(char*)));
        NSString * argv$conv$str;
        for (int argv$conv$i = 0; argv$conv$i < argv->length; argv$conv$i++) {
            argv$conv$str = [argv objectAtIndex:argv$conv$i];
            if (argv$conv$str == nil || argv$conv$str == JAVA_NULL || argv$conv$str == NULL)
                argv$conv[argv$conv$i] = 0;
            else
                argv$conv[argv$conv$i] = (char*)[argv$conv$str UTF8String];
        }
    }
    principalClassName = principalClassName == JAVA_NULL ? nil : principalClassName;
    NSString* appName = [principalClassName getName__];
    NSString* principalClassName$conv = [appName stringByReplacingOccurrencesOfString: @"." withString: @"_"];
    [appName release];
    delegateClassName = delegateClassName == JAVA_NULL ? nil : delegateClassName;
    NSString* delName = [delegateClassName getName__];
    NSString* delegateClassName$conv = [delName stringByReplacingOccurrencesOfString: @"." withString: @"_"];
    [delName release];
    int re$ult = UIApplicationMain((argv == JAVA_NULL ? 0 : argv->length), argv$conv, principalClassName$conv, delegateClassName$conv);
    free(argv$conv);
    return re$ult;
}

// direct binding of: + (UIApplication *)sharedApplication;
+ (UIApplication*) sharedApplication__
{
    UIApplication* re$ult = [UIApplication sharedApplication];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UIApplication__
{
    return [self init];
}

// direct binding of: @property(nonatomic) NSInteger applicationIconBadgeNumber;
- (void) setApplicationIconBadgeNumber___int:(int) applicationIconBadgeNumber 
{
    [self setApplicationIconBadgeNumber:applicationIconBadgeNumber];
}

// direct binding of: @property(nonatomic) NSInteger applicationIconBadgeNumber;
- (int) applicationIconBadgeNumber__
{
    return [self applicationIconBadgeNumber];
}

// direct binding of: @property(nonatomic, readonly) UIUserNotificationSettings *currentUserNotificationSettings;
- (UIUserNotificationSettings*) currentUserNotificationSettings__
{
    UIUserNotificationSettings* re$ult = [self currentUserNotificationSettings];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, assign) id<UIApplicationDelegate> delegate;
- (void) setDelegate___crossmobile_ios_uikit_UIApplicationDelegate:(id<UIApplicationDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// direct binding of: @property(nonatomic, assign) id<UIApplicationDelegate> delegate;
- (id<UIApplicationDelegate>) delegate__
{
    id<UIApplicationDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, getter=isIdleTimerDisabled) BOOL idleTimerDisabled;
- (void) setIdleTimerDisabled___boolean:(BOOL) idleTimerDisabled 
{
    [self setIdleTimerDisabled:idleTimerDisabled];
}

// direct binding of: @property(nonatomic, getter=isIdleTimerDisabled) BOOL idleTimerDisabled;
- (BOOL) isIdleTimerDisabled__
{
    return [self isIdleTimerDisabled];
}

// direct binding of: @property(nonatomic, readonly) UIWindow *keyWindow;
- (UIWindow*) keyWindow__
{
    UIWindow* re$ult = [self keyWindow];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, getter=isNetworkActivityIndicatorVisible) BOOL networkActivityIndicatorVisible;
- (void) setNetworkActivityIndicatorVisible___boolean:(BOOL) networkActivityIndicatorVisible 
{
    [self setNetworkActivityIndicatorVisible:networkActivityIndicatorVisible];
}

// direct binding of: @property(nonatomic, getter=isNetworkActivityIndicatorVisible) BOOL networkActivityIndicatorVisible;
- (BOOL) isNetworkActivityIndicatorVisible__
{
    return [self isNetworkActivityIndicatorVisible];
}

// direct binding of: @property(readonly, nonatomic, getter=isStatusBarHidden) BOOL statusBarHidden;
- (BOOL) isStatusBarHidden__
{
    return [self isStatusBarHidden];
}

// direct binding of: @property(readonly, nonatomic) UIInterfaceOrientation statusBarOrientation;
- (int) statusBarOrientation__
{
    return [self statusBarOrientation];
}

// direct binding of: @property(readonly, nonatomic) UIStatusBarStyle statusBarStyle;
- (int) statusBarStyle__
{
    return [self statusBarStyle];
}

// direct binding of: @property(nonatomic, readonly) UIUserInterfaceLayoutDirection userInterfaceLayoutDirection;
- (int) userInterfaceLayoutDirection__
{
    return [self userInterfaceLayoutDirection];
}

// direct binding of: @property(nonatomic, readonly) NSArray<__kindof UIWindow *> *windows;
- (NSArray*) windows__
{
    NSArray* re$ult = [self windows];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (UIRemoteNotificationType)enabledRemoteNotificationTypes;
- (int) enabledRemoteNotificationTypes__
{
    return [self enabledRemoteNotificationTypes];
}

// direct binding of: - (BOOL)openURL:(NSURL *)url;
- (BOOL) openURL___crossmobile_ios_foundation_NSURL:(NSURL*) url 
{
    return [self openURL:(url == JAVA_NULL ? nil : url)];
}

// direct binding of: - (void)registerForRemoteNotificationTypes:(UIRemoteNotificationType)types;
- (void) registerForRemoteNotificationTypes___int:(int) types 
{
    [self registerForRemoteNotificationTypes:types];
}

// direct binding of: - (void)registerForRemoteNotifications;
- (void) registerForRemoteNotifications__
{
    [self registerForRemoteNotifications];
}

// direct binding of: - (void)registerUserNotificationSettings:(UIUserNotificationSettings *)notificationSettings;
- (void) registerUserNotificationSettings___crossmobile_ios_uikit_UIUserNotificationSettings:(UIUserNotificationSettings*) notificationSettings 
{
    [self registerUserNotificationSettings:(notificationSettings == JAVA_NULL ? nil : notificationSettings)];
}

// direct binding of: - (void)setStatusBarHidden:(BOOL)hidden animated:(BOOL)animated;
- (void) setStatusBarHidden___boolean_boolean:(BOOL) hidden :(BOOL) animated 
{
    [self setStatusBarHidden:hidden animated:animated];
}

// direct binding of: - (void)setStatusBarOrientation:(UIInterfaceOrientation)interfaceOrientation animated:(BOOL)animated;
- (void) setStatusBarOrientation___int_boolean:(int) interfaceOrientation :(BOOL) animated 
{
    [self setStatusBarOrientation:interfaceOrientation animated:animated];
}

// direct binding of: - (void)setStatusBarStyle:(UIStatusBarStyle)statusBarStyle animated:(BOOL)animated;
- (void) setStatusBarStyle___int_boolean:(int) statusBarStyle :(BOOL) animated 
{
    [self setStatusBarStyle:statusBarStyle animated:animated];
}

// direct binding of: - (void)unregisterForRemoteNotifications;
- (void) unregisterForRemoteNotifications__
{
    [self unregisterForRemoteNotifications];
}

@end
