// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile_ios_usernotifications_UNNotification definition

#import "xmlvm.h"
#import <UIKit/UIKit.h>
#import <UserNotifications/UserNotifications.h>
@class crossmobile_ios_foundation_NSDate;
@class crossmobile_ios_usernotifications_UNNotificationRequest;

@interface crossmobile_ios_usernotifications_UNNotification$Ext : UNNotification
@end

#define crossmobile_ios_usernotifications_UNNotification UNNotification
@interface UNNotification (cm_crossmobile_ios_usernotifications_UNNotification)
- (NSDate*) date__;
- (UNNotificationRequest*) request__;
@end
