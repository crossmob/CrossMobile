/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIKeyboardAppearance specifies the appearance of a keyboard.
 */
@CMEnum
public final class UIKeyboardAppearance {

    /**
     * The default appearance.
     */
    public static final int Default = 0;

    /**
     * The appearance suitable for an alert panel.
     */
    public static final int Alert = 1;

    private UIKeyboardAppearance() {
    }
}
