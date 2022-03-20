/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIModalPresentationStyle class defines different styles of modal presentation
 * for view controllers.
 */
@CMEnum
public final class UIModalPresentationStyle {

    /**
     * The view controller covers the whole screen.
     */
    public static final int FullScreen = 0;

    /**
     * The view controller covers part of the underlying content and blurs any
     * uncovered parts in a horizontal position. In a portrait orientation it
     * takes the width and height of screen.
     */
    public static final int PageSheet = 1;

    /**
     * The view controller's content is centered in the screen so its width and
     * height are smaller than screen's. Any uncovered underlying content is
     * blurred. In landscape orientation the keyboard is visible and the view
     * controller is adjusted in order to be visible In a horizontally compact
     * display it takes the width and height of the screen.
     */
    public static final int FormSheet = 2;

    /**
     * The view controller's style is the same as the nearest ancestor that has
     * property definesPresentationContext set to YES.
     */
    public static final int CurrentContext = 3;

    /**
     *
     */
    public static final int Custom = 4;

    /**
     *
     */
    public static final int OverFullScreen = 5;

    /**
     *
     */
    public static final int OverCurrentContext = 6;

    /**
     *
     */
    public static final int Popover = 7;

    /**
     *
     */
    public static final int None = -1;

    private UIModalPresentationStyle() {
    }
}
