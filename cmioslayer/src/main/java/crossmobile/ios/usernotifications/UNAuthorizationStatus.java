/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.usernotifications;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class UNAuthorizationStatus {

    UNAuthorizationStatus() {
    }

    public static final int NotDetermined = 0;
    public static final int Denied = 1;
    public static final int Authorized = 2;
}
