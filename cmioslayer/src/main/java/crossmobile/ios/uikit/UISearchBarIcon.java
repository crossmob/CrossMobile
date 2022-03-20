/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UISearchBarIcon class specifies the icons that are used in the search bar.
 */
@CMEnum
public final class UISearchBarIcon {

    /**
     * The search icon which by default depicts a magnifying glass.
     */
    public static final int Search = 0;

    /**
     * The clear action icon which by default depicts a circle containing an X.
     */
    public static final int Clear = 1;

    /**
     * The bookmarks icon which by default depicts an open book.
     */
    public static final int Bookmark = 2;

    /**
     * The results list icon which by default depicts a list lozenge icon.
     */
    public static final int ResultsList = 3;
    //
    static final int ITEM_COUNT = 4;

    private UISearchBarIcon() {
    }

}
