/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
