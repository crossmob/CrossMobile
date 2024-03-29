/*
 * (c) 2023 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.webkit;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class WKNavigationResponsePolicy {
    public static final int Cancel = 0;
    public static final int Allow = 1;

    private WKNavigationResponsePolicy() {
    }
}
