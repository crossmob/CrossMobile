// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_usernotifications_UNCalendarNotificationTrigger definition

#import "xmlvm.h"
#import <UIKit/UIKit.h>
#import <UserNotifications/UserNotifications.h>
@class crossmobile_ios_foundation_NSDate;
@class crossmobile_ios_foundation_NSDateComponents;

CM_EXPORT_CLASS
@interface crossmobile_ios_usernotifications_UNCalendarNotificationTrigger$Ext : UNCalendarNotificationTrigger
@end

#define crossmobile_ios_usernotifications_UNCalendarNotificationTrigger UNCalendarNotificationTrigger
@interface UNCalendarNotificationTrigger (cm_crossmobile_ios_usernotifications_UNCalendarNotificationTrigger)
+ (instancetype) triggerWithDateMatchingComponents___crossmobile_ios_foundation_NSDateComponents_boolean:(NSDateComponents*) dateComponents :(BOOL) repeats ;
- (NSDateComponents*) dateComponents__;
- (NSDate*) nextTriggerDate__;
@end
