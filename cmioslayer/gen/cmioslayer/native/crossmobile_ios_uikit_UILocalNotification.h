// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UILocalNotification definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSCalendar;
@class crossmobile_ios_foundation_NSDate;
@class crossmobile_ios_foundation_NSTimeZone;
@class java_lang_String;
@protocol java_util_Map;

@interface crossmobile_ios_uikit_UILocalNotification$Ext : UILocalNotification
@end

#define crossmobile_ios_uikit_UILocalNotification UILocalNotification
@interface UILocalNotification (cm_crossmobile_ios_uikit_UILocalNotification)
- (instancetype) __init_crossmobile_ios_uikit_UILocalNotification__;
- (void) setAlertAction___java_lang_String:(NSString*) alertAction ;
- (NSString*) alertAction__;
- (void) setAlertBody___java_lang_String:(NSString*) alertBody ;
- (NSString*) alertBody__;
- (void) setAlertLaunchImage___java_lang_String:(NSString*) alertLaunchImage ;
- (NSString*) alertLaunchImage__;
- (void) setApplicationIconBadgeNumber___int:(int) applicationIconBadgeNumber ;
- (int) applicationIconBadgeNumber__;
- (void) setFireDate___crossmobile_ios_foundation_NSDate:(NSDate*) fireDate ;
- (NSDate*) fireDate__;
- (void) setHasAction___boolean:(BOOL) hasAction ;
- (BOOL) hasAction__;
- (void) setRepeatCalendar___crossmobile_ios_foundation_NSCalendar:(NSCalendar*) repeatCalendar ;
- (NSCalendar*) repeatCalendar__;
- (void) setRepeatInterval___int:(int) repeatInterval ;
- (int) repeatInterval__;
- (void) setSoundName___java_lang_String:(NSString*) soundName ;
- (NSString*) soundName__;
- (void) setTimeZone___crossmobile_ios_foundation_NSTimeZone:(NSTimeZone*) timeZone ;
- (NSTimeZone*) timeZone__;
- (void) setUserInfo___java_util_Map:(NSDictionary*) userInfo ;
- (NSDictionary*) userInfo__;
@end
