// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile_ios_usernotifications_UNNotificationResponse definition

#import "xmlvm.h"
#import <UIKit/UIKit.h>
#import <UserNotifications/UserNotifications.h>
@class crossmobile_ios_usernotifications_UNNotification;
@class java_lang_String;

@interface crossmobile_ios_usernotifications_UNNotificationResponse$Ext : UNNotificationResponse
@end

#define crossmobile_ios_usernotifications_UNNotificationResponse UNNotificationResponse
@interface UNNotificationResponse (cm_crossmobile_ios_usernotifications_UNNotificationResponse)
- (NSString*) actionIdentifier__;
- (UNNotification*) notification__;
@end
