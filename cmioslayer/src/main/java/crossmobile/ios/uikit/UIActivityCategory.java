/*
 * (c) 2023 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class UIActivityCategory {

    public static final long Action = 0;
    public static final long Share = 1;

    private UIActivityCategory() {
    }
}
