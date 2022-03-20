/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class NSKeyValueChangeKey {
    public static final String New = "NSKeyValueChangeNewKey";
    public static final String Old = "NSKeyValueChangeOldKey";

    private NSKeyValueChangeKey() {
    }

}
