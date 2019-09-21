// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile_ios_usernotifications_UNNotificationTrigger definition

#import "xmlvm.h"
#import <UIKit/UIKit.h>
#import <UserNotifications/UserNotifications.h>

@interface crossmobile_ios_usernotifications_UNNotificationTrigger$Ext : UNNotificationTrigger
@end

#define crossmobile_ios_usernotifications_UNNotificationTrigger UNNotificationTrigger
@interface UNNotificationTrigger (cm_crossmobile_ios_usernotifications_UNNotificationTrigger)
- (BOOL) repeats__;
@end
