/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.touchid;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class LABiometryType {
    public final static int None = 0;
    public final static int FaceID = 2;
    public final static int TouchID = 1;

    private LABiometryType() {

    }
}
