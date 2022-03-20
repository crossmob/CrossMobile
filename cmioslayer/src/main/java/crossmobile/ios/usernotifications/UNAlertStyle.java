/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.usernotifications;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class UNAlertStyle {

    UNAlertStyle() {
    }

    public static final int None = 0;
    public static final int Banner = 1;
    public static final int Alert = 2;
}
