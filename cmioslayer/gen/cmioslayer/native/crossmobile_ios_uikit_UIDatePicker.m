// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIDatePicker implementation

#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_foundation_NSCalendar.h"
#import "crossmobile_ios_foundation_NSDate.h"
#import "crossmobile_ios_foundation_NSLocale.h"
#import "crossmobile_ios_foundation_NSTimeZone.h"
#import "crossmobile_ios_uikit_UIDatePicker.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UIDatePicker$Ext

@end

@implementation UIDatePicker (cm_crossmobile_ios_uikit_UIDatePicker)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIDatePicker appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIDatePicker appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UIDatePicker__
{
    return [self init];
}

// - (instancetype)initWithFrame:(CGRect)frame;
- (instancetype) __init_crossmobile_ios_uikit_UIDatePicker___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame 
{
    return [self initWithFrame:[frame getCGRect]];
}

// @property(nonatomic, copy) NSCalendar *calendar;
- (void) setCalendar___crossmobile_ios_foundation_NSCalendar:(NSCalendar*) calendar 
{
    [self setCalendar:(calendar == JAVA_NULL ? nil : calendar)];
}

// @property(nonatomic, copy) NSCalendar *calendar;
- (NSCalendar*) calendar__
{
    NSCalendar* re$ult = [self calendar];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) NSTimeInterval countDownDuration;
- (void) setCountDownDuration___double:(double) countDownDuration 
{
    [self setCountDownDuration:countDownDuration];
}

// @property(nonatomic) NSTimeInterval countDownDuration;
- (double) countDownDuration__
{
    return [self countDownDuration];
}

// @property(nonatomic, strong) NSDate *date;
- (void) setDate___crossmobile_ios_foundation_NSDate:(NSDate*) date 
{
    [self setDate:(date == JAVA_NULL ? nil : date)];
}

// @property(nonatomic, strong) NSDate *date;
- (NSDate*) date__
{
    NSDate* re$ult = [self date];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) UIDatePickerMode datePickerMode;
- (void) setDatePickerMode___int:(int) datePickerMode 
{
    [self setDatePickerMode:datePickerMode];
}

// @property(nonatomic) UIDatePickerMode datePickerMode;
- (int) datePickerMode__
{
    return [self datePickerMode];
}

// @property(nonatomic, strong) NSLocale *locale;
- (void) setLocale___crossmobile_ios_foundation_NSLocale:(NSLocale*) locale 
{
    [self setLocale:(locale == JAVA_NULL ? nil : locale)];
}

// @property(nonatomic, strong) NSLocale *locale;
- (NSLocale*) locale__
{
    NSLocale* re$ult = [self locale];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, strong) NSDate *maximumDate;
- (void) setMaximumDate___crossmobile_ios_foundation_NSDate:(NSDate*) maximumDate 
{
    [self setMaximumDate:(maximumDate == JAVA_NULL ? nil : maximumDate)];
}

// @property(nonatomic, strong) NSDate *maximumDate;
- (NSDate*) maximumDate__
{
    NSDate* re$ult = [self maximumDate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, strong) NSDate *minimumDate;
- (void) setMinimumDate___crossmobile_ios_foundation_NSDate:(NSDate*) minimumDate 
{
    [self setMinimumDate:(minimumDate == JAVA_NULL ? nil : minimumDate)];
}

// @property(nonatomic, strong) NSDate *minimumDate;
- (NSDate*) minimumDate__
{
    NSDate* re$ult = [self minimumDate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) NSInteger minuteInterval;
- (void) setMinuteInterval___int:(int) minuteInterval 
{
    [self setMinuteInterval:minuteInterval];
}

// @property(nonatomic) NSInteger minuteInterval;
- (int) minuteInterval__
{
    return [self minuteInterval];
}

// @property(nonatomic, strong) NSTimeZone *timeZone;
- (void) setTimeZone___crossmobile_ios_foundation_NSTimeZone:(NSTimeZone*) timeZone 
{
    [self setTimeZone:(timeZone == JAVA_NULL ? nil : timeZone)];
}

// @property(nonatomic, strong) NSTimeZone *timeZone;
- (NSTimeZone*) timeZone__
{
    NSTimeZone* re$ult = [self timeZone];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)setDate:(NSDate *)date animated:(BOOL)animated;
- (void) setDate___crossmobile_ios_foundation_NSDate_boolean:(NSDate*) date :(BOOL) animated 
{
    [self setDate:(date == JAVA_NULL ? nil : date) animated:animated];
}

@end
