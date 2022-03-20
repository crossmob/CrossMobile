/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UISplitViewControllerDisplayMode class defines the options of display mode
 * for the split view controller.
 */
@CMEnum
public final class UISplitViewControllerDisplayMode {

    /**
     * The display mode is automatically chosen.
     */
    public static final int Automatic = 0;

    /**
     * The primary view controller is hidden.
     */
    public static final int PrimaryHidden = 1;

    /**
     * All view controllers are displayed one next to the other.
     */
    public static final int AllVisible = 2;

    /**
     * The primary view controller is displayed over the secondary view
     * controller.
     */
    public static final int PrimaryOverlay = 3;

    private UISplitViewControllerDisplayMode() {
    }

}
