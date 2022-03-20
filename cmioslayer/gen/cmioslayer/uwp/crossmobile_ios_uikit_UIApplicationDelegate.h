// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIApplicationDelegate definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGRect;
@class crossmobile_ios_foundation_NSData;
@class crossmobile_ios_foundation_NSError;
@class crossmobile_ios_foundation_NSURL;
@class crossmobile_ios_uikit_UIApplication;
@class crossmobile_ios_uikit_UILocalNotification;
@class crossmobile_ios_uikit_UIUserNotificationSettings;
@class crossmobile_ios_uikit_UIWindow;
@class java_lang_Integer;
@class java_lang_Number;
@class java_lang_Object;
@protocol java_lang_Runnable;
@class java_lang_String;
@protocol java_util_Map;
@protocol org_robovm_objc_block_VoidBlock1;

@protocol crossmobile_ios_uikit_UIApplicationDelegate
- (void) setWindow___crossmobile_ios_uikit_UIWindow:(UIWindow*) window ;
- (UIWindow*) window__;
- (void) didBecomeActive___crossmobile_ios_uikit_UIApplication:(UIApplication*) application ;
- (void) didChangeStatusBarFrame___crossmobile_ios_uikit_UIApplication_crossmobile_ios_coregraphics_CGRect:(UIApplication*) application :(crossmobile_ios_coregraphics_CGRect*) oldStatusBarFrame ;
- (void) didChangeStatusBarOrientation___crossmobile_ios_uikit_UIApplication_int:(UIApplication*) application :(int) oldStatusBarOrientation ;
- (void) didEnterBackground___crossmobile_ios_uikit_UIApplication:(UIApplication*) application ;
- (void) didFailToRegisterForRemoteNotificationsWithError___crossmobile_ios_uikit_UIApplication_crossmobile_ios_foundation_NSError:(UIApplication*) application :(NSError*) error ;
- (BOOL) didFinishLaunchingWithOptions___crossmobile_ios_uikit_UIApplication_java_util_Map:(UIApplication*) application :(NSDictionary*) launchOptions ;
- (void) didReceiveLocalNotification___crossmobile_ios_uikit_UIApplication_crossmobile_ios_uikit_UILocalNotification:(UIApplication*) application :(UILocalNotification*) notification ;
- (void) didReceiveMemoryWarning___crossmobile_ios_uikit_UIApplication:(UIApplication*) application ;
- (void) didReceiveRemoteNotification___crossmobile_ios_uikit_UIApplication_java_util_Map:(UIApplication*) application :(NSDictionary*) userInfo ;
- (void) didReceiveRemoteNotificationFetchCompletionHandler___crossmobile_ios_uikit_UIApplication_java_util_Map_org_robovm_objc_block_VoidBlock1:(UIApplication*) application :(NSDictionary*) userInfo :(id<org_robovm_objc_block_VoidBlock1>) completionHandler ;
- (void) didRegisterForRemoteNotificationsWithDeviceToken___crossmobile_ios_uikit_UIApplication_crossmobile_ios_foundation_NSData:(UIApplication*) application :(NSData*) deviceToken ;
- (void) didRegisterUserNotificationSettings___crossmobile_ios_uikit_UIApplication_crossmobile_ios_uikit_UIUserNotificationSettings:(UIApplication*) application :(UIUserNotificationSettings*) notificationSettings ;
- (void) handleActionWithIdentifierForLocalNotification___crossmobile_ios_uikit_UIApplication_java_lang_String_crossmobile_ios_uikit_UILocalNotification_java_lang_Runnable:(UIApplication*) application :(NSString*) identifier :(UILocalNotification*) notification :(id<java_lang_Runnable>) completionHandler ;
- (void) handleActionWithIdentifierForRemoteNotification___crossmobile_ios_uikit_UIApplication_java_lang_String_java_util_Map_java_lang_Runnable:(UIApplication*) application :(NSString*) identifier :(NSDictionary*) userInfo :(id<java_lang_Runnable>) completionHandler ;
- (BOOL) openURL___crossmobile_ios_uikit_UIApplication_crossmobile_ios_foundation_NSURL_java_lang_String_java_lang_Object:(UIApplication*) application :(NSURL*) url :(NSString*) sourceApplication :(id) annotation ;
- (void) protectedDataDidBecomeAvailable___crossmobile_ios_uikit_UIApplication:(UIApplication*) application ;
- (void) protectedDataWillBecomeUnavailable___crossmobile_ios_uikit_UIApplication:(UIApplication*) application ;
- (void) significantTimeChange___crossmobile_ios_uikit_UIApplication:(UIApplication*) application ;
- (void) willChangeStatusBarFrame___crossmobile_ios_uikit_UIApplication_crossmobile_ios_coregraphics_CGRect:(UIApplication*) application :(crossmobile_ios_coregraphics_CGRect*) newStatusBarFrame ;
- (void) willChangeStatusBarOrientation___crossmobile_ios_uikit_UIApplication_int_double:(UIApplication*) application :(int) newStatusBarOrientation :(double) duration ;
- (void) willEnterForeground___crossmobile_ios_uikit_UIApplication:(UIApplication*) application ;
- (void) willResignActive___crossmobile_ios_uikit_UIApplication:(UIApplication*) application ;
- (void) willTerminate___crossmobile_ios_uikit_UIApplication:(UIApplication*) application ;
@end
