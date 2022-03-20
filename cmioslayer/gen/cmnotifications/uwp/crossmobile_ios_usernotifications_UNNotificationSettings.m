// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_usernotifications_UNNotificationSettings implementation

#import "crossmobile_ios_usernotifications_UNNotificationSettings.h"

@implementation crossmobile_ios_usernotifications_UNNotificationSettings$Ext

@end

@implementation UNNotificationSettings (cm_crossmobile_ios_usernotifications_UNNotificationSettings)

// @property(readonly, nonatomic) UNNotificationSetting alertSetting;
- (JAVA_LONG) alertSetting__
{
    return [self alertSetting];
}

// @property(readonly, nonatomic) UNAlertStyle alertStyle;
- (int) alertStyle__
{
    return [self alertStyle];
}

// @property(readonly, nonatomic) UNAuthorizationStatus authorizationStatus;
- (int) authorizationStatus__
{
    return [self authorizationStatus];
}

// @property(readonly, nonatomic) UNNotificationSetting badgeSetting;
- (JAVA_LONG) badgeSetting__
{
    return [self badgeSetting];
}

// @property(readonly, nonatomic) UNNotificationSetting carPlaySetting;
- (JAVA_LONG) carPlaySetting__
{
    return [self carPlaySetting];
}

// @property(readonly, nonatomic) UNNotificationSetting lockScreenSetting;
- (JAVA_LONG) lockScreenSetting__
{
    return [self lockScreenSetting];
}

// @property(readonly, nonatomic) UNNotificationSetting notificationCenterSetting;
- (JAVA_LONG) notificationCenterSetting__
{
    return [self notificationCenterSetting];
}

// @property(readonly, nonatomic) UNNotificationSetting soundSetting;
- (JAVA_LONG) soundSetting__
{
    return [self soundSetting];
}

@end
