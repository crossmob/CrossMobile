// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_usernotifications_UNNotificationRequest definition

#import "xmlvm.h"
#import <UIKit/UIKit.h>
#import <UserNotifications/UserNotifications.h>
@class crossmobile_ios_usernotifications_UNNotificationContent;
@class crossmobile_ios_usernotifications_UNNotificationTrigger;
@class java_lang_String;

@interface crossmobile_ios_usernotifications_UNNotificationRequest$Ext : UNNotificationRequest
@end

#define crossmobile_ios_usernotifications_UNNotificationRequest UNNotificationRequest
@interface UNNotificationRequest (cm_crossmobile_ios_usernotifications_UNNotificationRequest)
+ (instancetype) requestWithIdentifier___java_lang_String_crossmobile_ios_usernotifications_UNNotificationContent_crossmobile_ios_usernotifications_UNNotificationTrigger:(NSString*) identifier :(UNNotificationContent*) content :(UNNotificationTrigger*) trigger ;
- (UNNotificationContent*) content__;
- (NSString*) identifier__;
- (UNNotificationTrigger*) trigger__;
@end
