/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.usernotifications;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class UNNotificationSetting {

    public static final long NotSupported = 0;
    public static final long Disabled = 1;
    public static final long Enabled = 2;

    UNNotificationSetting() {
    }
}
