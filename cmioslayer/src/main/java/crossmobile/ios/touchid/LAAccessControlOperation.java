/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.touchid;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class LAAccessControlOperation {
    public final static int CreateItem = 0;
    public final static int UseItem = 1;
    public final static int CreateKey = 2;
    public final static int UseKeySign = 3;
    public final static int UseKeyDecrypt = 4;
    public final static int UseKeyKeyExchange = 5;

    private LAAccessControlOperation() {
    }
}
