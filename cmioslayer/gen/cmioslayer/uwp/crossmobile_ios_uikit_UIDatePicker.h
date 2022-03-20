// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIDatePicker definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGRect;
@class crossmobile_ios_foundation_NSCalendar;
@class crossmobile_ios_foundation_NSDate;
@class crossmobile_ios_foundation_NSLocale;
@class crossmobile_ios_foundation_NSTimeZone;
@class crossmobile_ios_uikit_UIViewAppearance;
@protocol java_util_List;

@interface crossmobile_ios_uikit_UIDatePicker$Ext : UIDatePicker
@end

#define crossmobile_ios_uikit_UIDatePicker UIDatePicker
@interface UIDatePicker (cm_crossmobile_ios_uikit_UIDatePicker)
+ (instancetype) appearance__;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes ;
- (instancetype) __init_crossmobile_ios_uikit_UIDatePicker__;
- (instancetype) __init_crossmobile_ios_uikit_UIDatePicker___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame ;
- (void) setCalendar___crossmobile_ios_foundation_NSCalendar:(NSCalendar*) calendar ;
- (NSCalendar*) calendar__;
- (void) setCountDownDuration___double:(double) countDownDuration ;
- (double) countDownDuration__;
- (void) setDate___crossmobile_ios_foundation_NSDate:(NSDate*) date ;
- (NSDate*) date__;
- (void) setDatePickerMode___int:(int) datePickerMode ;
- (int) datePickerMode__;
- (void) setLocale___crossmobile_ios_foundation_NSLocale:(NSLocale*) locale ;
- (NSLocale*) locale__;
- (void) setMaximumDate___crossmobile_ios_foundation_NSDate:(NSDate*) maximumDate ;
- (NSDate*) maximumDate__;
- (void) setMinimumDate___crossmobile_ios_foundation_NSDate:(NSDate*) minimumDate ;
- (NSDate*) minimumDate__;
- (void) setMinuteInterval___int:(int) minuteInterval ;
- (int) minuteInterval__;
- (void) setTimeZone___crossmobile_ios_foundation_NSTimeZone:(NSTimeZone*) timeZone ;
- (NSTimeZone*) timeZone__;
- (void) setDate___crossmobile_ios_foundation_NSDate_boolean:(NSDate*) date :(BOOL) animated ;
@end
