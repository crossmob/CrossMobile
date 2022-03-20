// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_usernotifications_UNCalendarNotificationTrigger implementation

#import "crossmobile_ios_foundation_NSDate.h"
#import "crossmobile_ios_foundation_NSDateComponents.h"
#import "crossmobile_ios_usernotifications_UNCalendarNotificationTrigger.h"

@implementation crossmobile_ios_usernotifications_UNCalendarNotificationTrigger$Ext

@end

@implementation UNCalendarNotificationTrigger (cm_crossmobile_ios_usernotifications_UNCalendarNotificationTrigger)

// + (instancetype)triggerWithDateMatchingComponents:(NSDateComponents *)dateComponents repeats:(BOOL)repeats;
+ (instancetype) triggerWithDateMatchingComponents___crossmobile_ios_foundation_NSDateComponents_boolean:(NSDateComponents*) dateComponents :(BOOL) repeats 
{
    id re$ult = [UNCalendarNotificationTrigger triggerWithDateMatchingComponents:(dateComponents == JAVA_NULL ? nil : dateComponents) repeats:repeats];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) NSDateComponents *dateComponents;
- (NSDateComponents*) dateComponents__
{
    NSDateComponents* re$ult = [self dateComponents];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSDate *)nextTriggerDate;
- (NSDate*) nextTriggerDate__
{
    NSDate* re$ult = [self nextTriggerDate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
