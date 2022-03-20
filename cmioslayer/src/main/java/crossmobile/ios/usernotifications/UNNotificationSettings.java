/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.usernotifications;

import crossmobile.ios.foundation.NSObject;
import crossmobile.ios.foundation.NSSecureCoding;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;

@CMClass
public class UNNotificationSettings extends NSObject implements NSSecureCoding {

    private final int authorizationStatus;
    private final long notificationCenterSetting;
    private final long lockScreenSetting;
    private final long carPlaySetting;
    private final long alertSetting;
    private final int alertStyle;
    private final long badgeSetting;
    private final long soundSetting;

    UNNotificationSettings(int authorizationStatus, long notificationCenterSetting, long lockScreenSetting, long carPlaySetting, long alertSetting, int alertStyle, long badgeSetting, long soundSetting) {
        this.authorizationStatus = authorizationStatus;
        this.notificationCenterSetting = notificationCenterSetting;
        this.lockScreenSetting = lockScreenSetting;
        this.carPlaySetting = carPlaySetting;
        this.alertSetting = alertSetting;
        this.alertStyle = alertStyle;
        this.badgeSetting = badgeSetting;
        this.soundSetting = soundSetting;
    }

    @CMGetter("@property(readonly, nonatomic) UNAuthorizationStatus authorizationStatus;")
    public int authorizationStatus() {
        return authorizationStatus;
    }

    @CMGetter("@property(readonly, nonatomic) UNNotificationSetting notificationCenterSetting;")
    public long notificationCenterSetting() {
        return notificationCenterSetting;
    }

    @CMGetter("@property(readonly, nonatomic) UNNotificationSetting lockScreenSetting;")
    public long lockScreenSetting() {
        return lockScreenSetting;
    }

    @CMGetter("@property(readonly, nonatomic) UNNotificationSetting carPlaySetting;")
    public long carPlaySetting() {
        return carPlaySetting;
    }

    @CMGetter("@property(readonly, nonatomic) UNNotificationSetting alertSetting;")
    public long alertSetting() {
        return alertSetting;
    }

    @CMGetter("@property(readonly, nonatomic) UNAlertStyle alertStyle;")
    public int alertStyle() {
        return alertStyle;
    }

    @CMGetter("@property(readonly, nonatomic) UNNotificationSetting badgeSetting;")
    public long badgeSetting() {
        return badgeSetting;
    }

    @CMGetter("@property(readonly, nonatomic) UNNotificationSetting soundSetting;")
    public long soundSetting() {
        return soundSetting;
    }
}
