// (c) 2020 under LGPL by CrossMobile plugin tools

// crossmobile_ios_usernotifications_UNNotificationRequest definition

#import "xmlvm.h"
#import <UIKit/UIKit.h>
#import <UserNotifications/UserNotifications.h>
@class crossmobile_ios_usernotifications_UNNotificationContent;
@class crossmobile_ios_usernotifications_UNNotificationTrigger;
@class java_lang_String;

CM_EXPORT_CLASS
@interface crossmobile_ios_usernotifications_UNNotificationRequest$Ext : UNNotificationRequest
@end

#define crossmobile_ios_usernotifications_UNNotificationRequest UNNotificationRequest
@interface UNNotificationRequest (cm_crossmobile_ios_usernotifications_UNNotificationRequest)
+ (instancetype) requestWithIdentifier___java_lang_String_crossmobile_ios_usernotifications_UNNotificationContent_crossmobile_ios_usernotifications_UNNotificationTrigger:(NSString*) identifier :(UNNotificationContent*) content :(UNNotificationTrigger*) trigger ;
- (UNNotificationContent*) content__;
- (NSString*) identifier__;
- (UNNotificationTrigger*) trigger__;
@end
