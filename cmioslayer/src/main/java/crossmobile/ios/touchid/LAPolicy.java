/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.touchid;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class LAPolicy {

    public static final int DeviceOwnerAuthenticationWithBiometrics = 1;
    public static final int DeviceOwnerAuthentication = 2;

    private LAPolicy() {
    }
}
