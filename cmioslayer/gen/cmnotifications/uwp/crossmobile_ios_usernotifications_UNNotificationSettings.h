// (c) 2021 under LGPL by CrossMobile plugin tools

// crossmobile_ios_usernotifications_UNNotificationSettings definition

#import "xmlvm.h"
#import <UIKit/UIKit.h>
#import <UserNotifications/UserNotifications.h>

@interface crossmobile_ios_usernotifications_UNNotificationSettings$Ext : UNNotificationSettings
@end

#define crossmobile_ios_usernotifications_UNNotificationSettings UNNotificationSettings
@interface UNNotificationSettings (cm_crossmobile_ios_usernotifications_UNNotificationSettings)
- (JAVA_LONG) alertSetting__;
- (int) alertStyle__;
- (int) authorizationStatus__;
- (JAVA_LONG) badgeSetting__;
- (JAVA_LONG) carPlaySetting__;
- (JAVA_LONG) lockScreenSetting__;
- (JAVA_LONG) notificationCenterSetting__;
- (JAVA_LONG) soundSetting__;
@end
