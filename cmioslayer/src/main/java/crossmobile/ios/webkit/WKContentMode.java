/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.webkit;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class WKContentMode {
    public static final int Recommended = 0;
    public static final int Mobile = 1;
    public static final int Desktop = 2;

    private WKContentMode() {
    }
}
