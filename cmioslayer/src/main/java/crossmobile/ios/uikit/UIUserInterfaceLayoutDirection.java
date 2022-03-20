/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIUserNotificationType class defines  the layout alignment of the
 * elements based on the language settings.
 */
@CMEnum
public final class UIUserInterfaceLayoutDirection {
    /**
     * Direction is left to right.
     */
    public static final int LeftToRight = 0;

    /**
     * Direction is right to left.
     */
    public static final int RightToLeft = 1;


    private UIUserInterfaceLayoutDirection() {
    }
}
