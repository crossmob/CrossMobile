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
 * UILayoutPriority class defines values that indicate priorities of
 * restrictions for the constraint based layout system.
 */
@CMEnum
public final class UILayoutPriority {

    /**
     * A required priority constraint that restricts all layout constraints to
     * exceed this value.
     */
    public static final float Required = 1000;

    /**
     * The priority related to a view's content compressing resistance.
     */
    public static final float DefaultHigh = 750;

    /**
     * The priority related to the way a view horizontally encloses its content.
     */
    public static final float DefaultLow = 250;

    /**
     * The priority related to a view's resistance to comply with a size
     * computed to fit the layout.
     */
    public static final float FittingSizeLevel = 50;

    private UILayoutPriority() {
    }
}
