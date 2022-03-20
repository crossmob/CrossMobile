/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIAlertActionStyle class defines different style options for alert action
 * buttons.
 */
@CMEnum
public final class UIAlertActionStyle {

    /**
     * The action button has the default style.
     */
    public static final int Default = 0;

    /**
     * The action button has a style proper for canceling the option.
     */
    public static final int Cancel = 1;

    /**
     * The action button has a style proper for the option of changing or
     * deleting data.
     */
    public static final int Destructive = 2;

    private UIAlertActionStyle() {
    }

}
