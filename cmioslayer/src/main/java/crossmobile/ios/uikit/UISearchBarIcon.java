/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
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
