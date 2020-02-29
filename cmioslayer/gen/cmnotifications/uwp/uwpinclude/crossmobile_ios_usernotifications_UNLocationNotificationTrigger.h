// (c) 2020 under LGPL by CrossMobile plugin tools

// crossmobile_ios_usernotifications_UNLocationNotificationTrigger definition

#import "xmlvm.h"
#import <UIKit/UIKit.h>
#import <UserNotifications/UserNotifications.h>
@class crossmobile_ios_corelocation_CLRegion;

CM_EXPORT_CLASS
@interface crossmobile_ios_usernotifications_UNLocationNotificationTrigger$Ext : UNLocationNotificationTrigger
@end

#define crossmobile_ios_usernotifications_UNLocationNotificationTrigger UNLocationNotificationTrigger
@interface UNLocationNotificationTrigger (cm_crossmobile_ios_usernotifications_UNLocationNotificationTrigger)
+ (instancetype) triggerWithRegion___crossmobile_ios_corelocation_CLRegion_boolean:(CLRegion*) region :(BOOL) repeats ;
- (CLRegion*) region__;
@end
