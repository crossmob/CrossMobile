/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.usernotifications;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class UNAuthorizationOptions {

    UNAuthorizationOptions() {
    }

    public static final int Badge = (1 << 0);
    public static final int Sound = (1 << 1);
    public static final int Alert = (1 << 2);
    public static final int CarPlay = (1 << 3);
}
