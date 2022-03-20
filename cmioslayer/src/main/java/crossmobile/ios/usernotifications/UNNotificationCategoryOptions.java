/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.usernotifications;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class UNNotificationCategoryOptions {

    public static final long None = (0);
    public static final long CustomDismissAction = (1 << 0);
    public static final long AllowInCarPlay = (2 << 0);

    UNNotificationCategoryOptions() {
    }
}
