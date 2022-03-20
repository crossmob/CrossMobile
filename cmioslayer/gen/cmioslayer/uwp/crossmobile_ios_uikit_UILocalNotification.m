// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UILocalNotification implementation

#import "crossmobile_ios_foundation_NSCalendar.h"
#import "crossmobile_ios_foundation_NSDate.h"
#import "crossmobile_ios_foundation_NSTimeZone.h"
#import "crossmobile_ios_uikit_UILocalNotification.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_uikit_UILocalNotification$Ext

@end

@implementation UILocalNotification (cm_crossmobile_ios_uikit_UILocalNotification)

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UILocalNotification__
{
    return [self init];
}

// @property(nonatomic, copy) NSString *alertAction;
- (void) setAlertAction___java_lang_String:(NSString*) alertAction 
{
    [self setAlertAction:(alertAction == JAVA_NULL ? nil : alertAction)];
}

// @property(nonatomic, copy) NSString *alertAction;
- (NSString*) alertAction__
{
    NSString* re$ult = [self alertAction];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, copy) NSString *alertBody;
- (void) setAlertBody___java_lang_String:(NSString*) alertBody 
{
    [self setAlertBody:(alertBody == JAVA_NULL ? nil : alertBody)];
}

// @property(nonatomic, copy) NSString *alertBody;
- (NSString*) alertBody__
{
    NSString* re$ult = [self alertBody];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, copy) NSString *alertLaunchImage;
- (void) setAlertLaunchImage___java_lang_String:(NSString*) alertLaunchImage 
{
    [self setAlertLaunchImage:(alertLaunchImage == JAVA_NULL ? nil : alertLaunchImage)];
}

// @property(nonatomic, copy) NSString *alertLaunchImage;
- (NSString*) alertLaunchImage__
{
    NSString* re$ult = [self alertLaunchImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
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

// @property(nonatomic, copy) NSDate *fireDate;
- (void) setFireDate___crossmobile_ios_foundation_NSDate:(NSDate*) fireDate 
{
    [self setFireDate:(fireDate == JAVA_NULL ? nil : fireDate)];
}

// @property(nonatomic, copy) NSDate *fireDate;
- (NSDate*) fireDate__
{
    NSDate* re$ult = [self fireDate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) BOOL hasAction;
- (void) setHasAction___boolean:(BOOL) hasAction 
{
    [self setHasAction:hasAction];
}

// @property(nonatomic) BOOL hasAction;
- (BOOL) hasAction__
{
    return [self hasAction];
}

// @property(nonatomic, copy) NSCalendar *repeatCalendar;
- (void) setRepeatCalendar___crossmobile_ios_foundation_NSCalendar:(NSCalendar*) repeatCalendar 
{
    [self setRepeatCalendar:(repeatCalendar == JAVA_NULL ? nil : repeatCalendar)];
}

// @property(nonatomic, copy) NSCalendar *repeatCalendar;
- (NSCalendar*) repeatCalendar__
{
    NSCalendar* re$ult = [self repeatCalendar];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) NSCalendarUnit repeatInterval;
- (void) setRepeatInterval___int:(int) repeatInterval 
{
    [self setRepeatInterval:repeatInterval];
}

// @property(nonatomic) NSCalendarUnit repeatInterval;
- (int) repeatInterval__
{
    return [self repeatInterval];
}

// @property(nonatomic, copy) NSString *soundName;
- (void) setSoundName___java_lang_String:(NSString*) soundName 
{
    [self setSoundName:(soundName == JAVA_NULL ? nil : soundName)];
}

// @property(nonatomic, copy) NSString *soundName;
- (NSString*) soundName__
{
    NSString* re$ult = [self soundName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, copy) NSTimeZone *timeZone;
- (void) setTimeZone___crossmobile_ios_foundation_NSTimeZone:(NSTimeZone*) timeZone 
{
    [self setTimeZone:(timeZone == JAVA_NULL ? nil : timeZone)];
}

// @property(nonatomic, copy) NSTimeZone *timeZone;
- (NSTimeZone*) timeZone__
{
    NSTimeZone* re$ult = [self timeZone];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, copy) NSDictionary *userInfo;
- (void) setUserInfo___java_util_Map:(NSDictionary*) userInfo 
{
    [self setUserInfo:(userInfo == JAVA_NULL ? nil : userInfo)];
}

// @property(nonatomic, copy) NSDictionary *userInfo;
- (NSDictionary*) userInfo__
{
    NSDictionary* re$ult = [self userInfo];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
