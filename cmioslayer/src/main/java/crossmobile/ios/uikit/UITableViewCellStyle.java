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
 * UITableViewCellStyle class defines the style of cells.
 */
@CMEnum
public final class UITableViewCellStyle {

    /**
     * The default style of a cell.Uses a black text label (left-aligned) with
     * image view(optional).
     */
    public final static int Default = 0;

    /**
     * A left-aligned black text on the left and a smaller right-aligned one on
     * the right.
     */
    public final static int Value1 = 1;

    /**
     * A right-aligned text label on the left and a smaller left-aligned one on
     * the right,suitable for phone contacts applications.
     */
    public final static int Value2 = 2;

    /**
     * Left aligned text label on top and a smaller one below it.
     */
    public final static int Subtitle = 3;

    private UITableViewCellStyle() {
    }
}
