// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_usernotifications_UNNotificationTrigger definition

#import "xmlvm.h"
#import <UIKit/UIKit.h>
#import <UserNotifications/UserNotifications.h>

CM_EXPORT_CLASS
@interface crossmobile_ios_usernotifications_UNNotificationTrigger$Ext : UNNotificationTrigger
@end

#define crossmobile_ios_usernotifications_UNNotificationTrigger UNNotificationTrigger
@interface UNNotificationTrigger (cm_crossmobile_ios_usernotifications_UNNotificationTrigger)
- (BOOL) repeats__;
@end
