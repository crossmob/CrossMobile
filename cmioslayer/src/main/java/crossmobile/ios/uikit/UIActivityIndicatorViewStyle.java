/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIActivityIndicatorViewStyle class defines different options for activity
 * indicator's style.
 */
@CMEnum
public final class UIActivityIndicatorViewStyle {

    /**
     * The activity indicator is depicted as a large-sized white gear.
     */
    public static final int WhiteLarge = 0;

    /**
     * The activity indicator's style is the default, a normal white gear.
     */
    public static final int White = 1;

    /**
     * The activity indicator is depicted as a normal sized grey gear.
     */
    public static final int Gray = 2;

    private UIActivityIndicatorViewStyle() {
    }
}
