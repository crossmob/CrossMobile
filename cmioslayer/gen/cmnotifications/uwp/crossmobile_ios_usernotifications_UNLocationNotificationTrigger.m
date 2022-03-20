// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_usernotifications_UNLocationNotificationTrigger implementation

#import "crossmobile_ios_corelocation_CLRegion.h"
#import "crossmobile_ios_usernotifications_UNLocationNotificationTrigger.h"

@implementation crossmobile_ios_usernotifications_UNLocationNotificationTrigger$Ext

@end

@implementation UNLocationNotificationTrigger (cm_crossmobile_ios_usernotifications_UNLocationNotificationTrigger)

// + (instancetype)triggerWithRegion:(CLRegion *)region repeats:(BOOL)repeats;
+ (instancetype) triggerWithRegion___crossmobile_ios_corelocation_CLRegion_boolean:(CLRegion*) region :(BOOL) repeats 
{
    id re$ult = [UNLocationNotificationTrigger triggerWithRegion:(region == JAVA_NULL ? nil : region) repeats:repeats];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) CLRegion *region;
- (CLRegion*) region__
{
    CLRegion* re$ult = [self region];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
