// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_usernotifications_UNNotificationResponse definition

#import "xmlvm.h"
#import <UIKit/UIKit.h>
#import <UserNotifications/UserNotifications.h>
@class crossmobile_ios_usernotifications_UNNotification;
@class java_lang_String;

CM_EXPORT_CLASS
@interface crossmobile_ios_usernotifications_UNNotificationResponse$Ext : UNNotificationResponse
@end

#define crossmobile_ios_usernotifications_UNNotificationResponse UNNotificationResponse
@interface UNNotificationResponse (cm_crossmobile_ios_usernotifications_UNNotificationResponse)
- (NSString*) actionIdentifier__;
- (UNNotification*) notification__;
@end
