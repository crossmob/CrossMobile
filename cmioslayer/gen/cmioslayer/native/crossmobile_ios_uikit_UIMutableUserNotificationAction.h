// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIMutableUserNotificationAction definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class java_lang_String;
@protocol java_util_Map;

@interface crossmobile_ios_uikit_UIMutableUserNotificationAction$Ext : UIMutableUserNotificationAction
@end

#define crossmobile_ios_uikit_UIMutableUserNotificationAction UIMutableUserNotificationAction
@interface UIMutableUserNotificationAction (cm_crossmobile_ios_uikit_UIMutableUserNotificationAction)
- (instancetype) __init_crossmobile_ios_uikit_UIMutableUserNotificationAction__;
- (void) setActivationMode___int:(int) activationMode ;
- (void) setAuthenticationRequired___boolean:(BOOL) authenticationRequired ;
- (void) setBehavior___int:(int) behavior ;
- (void) setDestructive___boolean:(BOOL) destructive ;
- (void) setIdentifier___java_lang_String:(NSString*) identifier ;
- (void) setParameters___java_util_Map:(NSDictionary*) parameters ;
- (void) setTitle___java_lang_String:(NSString*) title ;
@end
