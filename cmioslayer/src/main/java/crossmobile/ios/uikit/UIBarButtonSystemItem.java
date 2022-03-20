/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIBarButtonSystemItem class defines different types of system UIBarButton
 * items.
 */
@CMEnum
public final class UIBarButtonSystemItem {

    /**
     * System's done button.
     */
    public static final int Done = 0;

    /**
     * System's cancel button.
     */
    public static final int Cancel = 1;

    /**
     * System's edit button.
     */
    public static final int Edit = 2;

    /**
     * System's save button.
     */
    public static final int Save = 3;

    /**
     * System's add button depicting a plus sign.
     */
    public static final int Add = 4;

    /**
     * System's button used to add blank space among items with the space
     * equally distributed.
     */
    public static final int FlexibleSpace = 5;

    /**
     * System's button used to add blank space among items.
     */
    public static final int FixedSpace = 6;

    /**
     * System's compose button.
     */
    public static final int Compose = 7;

    /**
     * System's reply button.
     */
    public static final int Reply = 8;

    /**
     * System's action button.
     */
    public static final int Action = 9;

    /**
     * System's organize button.
     */
    public static final int Organize = 10;

    /**
     * System's bookmarks button.
     */
    public static final int Bookmarks = 11;

    /**
     * System's search button.
     */
    public static final int Search = 12;

    /**
     * System's refresh button.
     */
    public static final int Refresh = 13;

    /**
     * System's stop button.
     */
    public static final int Stop = 14;

    /**
     * System's camera button.
     */
    public static final int Camera = 15;

    /**
     * System's trash button.
     */
    public static final int Trash = 16;

    /**
     * System's play button.
     */
    public static final int Play = 17;

    /**
     * System's pause button.
     */
    public static final int Pause = 18;

    /**
     * System's rewind button.
     */
    public static final int Rewind = 19;

    /**
     * System's fast forward button.
     */
    public static final int FastForward = 20;

    /**
     * System's undo button.
     */
    public static final int Undo = 21;

    /**
     * System's redo button.
     */
    public static final int Redo = 22;

    private UIBarButtonSystemItem() {
    }
}
