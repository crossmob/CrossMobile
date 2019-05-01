// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.usernotifications.UNTimeIntervalNotificationTrigger definition

#import "xmlvm.h"
#import <UserNotifications/UserNotifications.h>
@class crossmobile_ios_foundation_NSDate;

@interface crossmobile_ios_usernotifications_UNTimeIntervalNotificationTrigger$Ext : UNTimeIntervalNotificationTrigger
@end

#define crossmobile_ios_usernotifications_UNTimeIntervalNotificationTrigger UNTimeIntervalNotificationTrigger
@interface UNTimeIntervalNotificationTrigger (cm_crossmobile_ios_usernotifications_UNTimeIntervalNotificationTrigger)
+ (instancetype) triggerWithTimeInterval___double_boolean:(double) timeInterval :(BOOL) repeats ;
- (double) timeInterval__;
- (NSDate*) nextTriggerDate__;
@end
