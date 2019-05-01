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
 * UILayoutConstraintAxis class defines which axis is being constrained
 * concerning flow layouts.
 */
@CMEnum
public final class UILayoutConstraintAxis {

    /**
     * This constraint is applied to the horizontal axis.
     */
    public final static int Horizontal = 0;

    /**
     * This constraint is applied to the vertical axis.
     */
    public final static int Vertical = 1;

    private UILayoutConstraintAxis() {
    }
}
