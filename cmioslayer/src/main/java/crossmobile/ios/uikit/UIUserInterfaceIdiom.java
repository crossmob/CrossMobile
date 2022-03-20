/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIUserInterfaceIdiom class defines the type of user interface that should
 * be designed for the device.
 */
@CMEnum
public final class UIUserInterfaceIdiom {

    /**
     * The user interface should be designed for iPhone.
     */
    public static final int Phone = 0;

    /**
     * The user interface should be designed for iPad.
     */
    public static final int Pad = 1;

    private UIUserInterfaceIdiom() {
    }
}
