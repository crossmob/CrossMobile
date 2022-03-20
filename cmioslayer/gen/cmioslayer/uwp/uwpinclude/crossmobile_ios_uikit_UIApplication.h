// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIApplication definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSURL;
@protocol crossmobile_ios_uikit_UIApplicationDelegate;
@class crossmobile_ios_uikit_UIUserNotificationSettings;
@class crossmobile_ios_uikit_UIWindow;
@class java_lang_Boolean;
@class java_lang_Class;
@protocol java_util_List;
@protocol java_util_Map;
@protocol org_robovm_objc_block_VoidBlock1;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UIApplication$Ext : UIApplication
@end

#define crossmobile_ios_uikit_UIApplication UIApplication
@interface UIApplication (cm_crossmobile_ios_uikit_UIApplication)
+ (int) main___java_lang_String_ARRAYTYPE_java_lang_Class_java_lang_Class:(XMLVMArray*) argv :(java_lang_Class*) principalClassName :(java_lang_Class*) delegateClassName ;
+ (UIApplication*) sharedApplication__;
- (instancetype) __init_crossmobile_ios_uikit_UIApplication__;
- (void) setApplicationIconBadgeNumber___int:(int) applicationIconBadgeNumber ;
- (int) applicationIconBadgeNumber__;
- (int) applicationState__;
- (UIUserNotificationSettings*) currentUserNotificationSettings__;
- (void) setDelegate___crossmobile_ios_uikit_UIApplicationDelegate:(id<UIApplicationDelegate>) delegate ;
- (id<UIApplicationDelegate>) delegate__;
- (void) setIdleTimerDisabled___boolean:(BOOL) idleTimerDisabled ;
- (BOOL) isIdleTimerDisabled__;
- (UIWindow*) keyWindow__;
- (void) setNetworkActivityIndicatorVisible___boolean:(BOOL) networkActivityIndicatorVisible ;
- (BOOL) isNetworkActivityIndicatorVisible__;
- (BOOL) isStatusBarHidden__;
- (int) statusBarOrientation__;
- (int) statusBarStyle__;
- (int) userInterfaceLayoutDirection__;
- (NSArray*) windows__;
- (BOOL) canOpenURL___crossmobile_ios_foundation_NSURL:(NSURL*) url ;
- (int) enabledRemoteNotificationTypes__;
- (BOOL) openURL___crossmobile_ios_foundation_NSURL:(NSURL*) url ;
- (void) openURL___crossmobile_ios_foundation_NSURL_java_util_Map_org_robovm_objc_block_VoidBlock1:(NSURL*) url :(NSDictionary*) options :(id<org_robovm_objc_block_VoidBlock1>) completion ;
- (void) registerForRemoteNotificationTypes___int:(int) types ;
- (void) registerForRemoteNotifications__;
- (void) registerUserNotificationSettings___crossmobile_ios_uikit_UIUserNotificationSettings:(UIUserNotificationSettings*) notificationSettings ;
- (void) setStatusBarHidden___boolean_boolean:(BOOL) hidden :(BOOL) animated ;
- (void) setStatusBarOrientation___int_boolean:(int) interfaceOrientation :(BOOL) animated ;
- (void) setStatusBarStyle___int_boolean:(int) statusBarStyle :(BOOL) animated ;
- (void) unregisterForRemoteNotifications__;
@end
