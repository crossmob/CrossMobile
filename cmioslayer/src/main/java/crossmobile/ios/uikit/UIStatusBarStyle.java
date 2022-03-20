/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIStatusBarStyle class defines the style of the status bar.
 */
@CMEnum
public final class UIStatusBarStyle {

    /**
     * The status bar has the default dark style used mainly with light
     * backgrounds.
     */
    public static final int Default = 0;

    /**
     * The status bar has light style used mainly with dark backgrounds.
     */
    public static final int LightContent = 1;

    /**
     * The status bar has dark style used mainly with light backgrounds.
     */
    public static final int DarkContent = 3;

    private UIStatusBarStyle() {
    }
}
