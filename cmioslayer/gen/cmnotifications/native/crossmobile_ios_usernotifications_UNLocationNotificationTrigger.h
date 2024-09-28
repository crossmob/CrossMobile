// (c) 2024 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_usernotifications_UNLocationNotificationTrigger definition

#import "xmlvm.h"
#import <UIKit/UIKit.h>
#import <UserNotifications/UserNotifications.h>
@class crossmobile_ios_corelocation_CLRegion;

@interface crossmobile_ios_usernotifications_UNLocationNotificationTrigger$Ext : UNLocationNotificationTrigger
@end

#define crossmobile_ios_usernotifications_UNLocationNotificationTrigger UNLocationNotificationTrigger
@interface UNLocationNotificationTrigger (cm_crossmobile_ios_usernotifications_UNLocationNotificationTrigger)
+ (instancetype) triggerWithRegion___crossmobile_ios_corelocation_CLRegion_boolean:(CLRegion*) region :(BOOL) repeats ;
- (CLRegion*) region__;
@end
