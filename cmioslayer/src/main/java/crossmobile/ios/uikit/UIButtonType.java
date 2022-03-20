/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIButtonType class defines the style of a button.
 */
@CMEnum
public final class UIButtonType {

    /**
     * A button with no style.
     */
    public static final int Custom = 0;
    /**
     * A button with default system style.
     */
    public static final int System = 1;

    /**
     * A button used for revealing details.
     */
    public static final int DetailDisclosure = 2;

    /**
     * A button with light background used to display information.
     */
    public static final int InfoLight = 3;

    /**
     * A button with dark background used to display information.
     */
    public static final int InfoDark = 4;

    /**
     * A button for adding contacts.
     */
    public static final int ContactAdd = 5;

    private UIButtonType() {
    }
}
