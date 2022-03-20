/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.usernotifications;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class UNNotificationPresentationOptions {

    public final static long None = (0);
    public final static long Badge = (1 << 0);
    public final static long Sound = (1 << 1);
    public final static long Alert = (1 << 2);

    UNNotificationPresentationOptions() {
    }
}
