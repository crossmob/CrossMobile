/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIProgressViewStyle class specifies the style of the progress bar.
 */
@CMEnum
public final class UIProgressViewStyle {

    /**
     * The default style of the progress bar.
     */
    public static final int Default = 0;

    /**
     * The style used for a toolbar.
     */
    public static final int Bar = 1;

    private UIProgressViewStyle() {
    }
}
