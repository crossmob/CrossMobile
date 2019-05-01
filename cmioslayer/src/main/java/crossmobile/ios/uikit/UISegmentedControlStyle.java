/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UISegmentedControlStyle class defines the style of the segmented control.
 */
@CMEnum
public final class UISegmentedControlStyle {

    /**
     * The segmented control has the default plain style.
     */
    public static final int Plain = 0;

    /**
     * The segmented control has large bordered style.
     */
    public static final int Bordered = 1;

    /**
     * The segmented control has small toolbar style with tint color.
     */
    public static final int Bar = 2;

    /**
     * The segmented control has large style with tint color.
     */
    public static final int Bezeled = 3;

    private UISegmentedControlStyle() {
    }
}
