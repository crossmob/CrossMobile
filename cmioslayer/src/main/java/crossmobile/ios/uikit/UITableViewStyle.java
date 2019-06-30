/*
 * (c) 2019 by Panayotis Katsaloulis
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
 * UITableViewStyle class specifies the style of a table view.
 */
@CMEnum
public final class UITableViewStyle {

    /**
     * Table view's style is plain. Headers or footers float when the table view
     * is scrolled.
     */
    public static final int Plain = 0;

    /**
     * Table view's style is grouped. It means that all parts are organized in
     * groups of rows.Headers or footers do not float.
     */
    public static final int Grouped = 1;

    private UITableViewStyle() {
    }
}
