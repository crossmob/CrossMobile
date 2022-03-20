/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class NSKeyValueObservingOptions {
    public static final int New = 1;
    public static final int Old = 2;
    public static final int Initial = 4;
    public static final int Prior = 8;

    private NSKeyValueObservingOptions() {
    }
}
