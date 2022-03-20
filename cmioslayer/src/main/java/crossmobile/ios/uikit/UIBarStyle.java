/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIBarStyle class defines styles for different types of bars.
 */
@CMEnum
public final class UIBarStyle {

    /**
     * The default style of a view that is dark content on a white background.
     */
    public static final int Default = 0;

    /**
     * The style of the view is light content on a black background.
     */
    public static final int Black = 1;

    private UIBarStyle() {
    }
}
