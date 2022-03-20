/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.usernotifications;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class UNNotificationActionOptions {

    UNNotificationActionOptions() {
    }

    public static final long None = 0;
    public static final long AuthenticationRequired = (1 << 0);
    public static final long Destructive = (1 << 1);
    public static final long Foreground = (1 << 2);
}
