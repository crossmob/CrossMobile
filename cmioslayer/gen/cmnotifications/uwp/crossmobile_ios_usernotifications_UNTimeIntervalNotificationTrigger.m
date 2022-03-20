// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_usernotifications_UNTimeIntervalNotificationTrigger implementation

#import "crossmobile_ios_foundation_NSDate.h"
#import "crossmobile_ios_usernotifications_UNTimeIntervalNotificationTrigger.h"

@implementation crossmobile_ios_usernotifications_UNTimeIntervalNotificationTrigger$Ext

@end

@implementation UNTimeIntervalNotificationTrigger (cm_crossmobile_ios_usernotifications_UNTimeIntervalNotificationTrigger)

// + (instancetype)triggerWithTimeInterval:(NSTimeInterval)timeInterval repeats:(BOOL)repeats;
+ (instancetype) triggerWithTimeInterval___double_boolean:(double) timeInterval :(BOOL) repeats 
{
    id re$ult = [UNTimeIntervalNotificationTrigger triggerWithTimeInterval:timeInterval repeats:repeats];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, nonatomic) NSTimeInterval timeInterval;
- (double) timeInterval__
{
    return [self timeInterval];
}

// - (NSDate *)nextTriggerDate;
- (NSDate*) nextTriggerDate__
{
    NSDate* re$ult = [self nextTriggerDate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
