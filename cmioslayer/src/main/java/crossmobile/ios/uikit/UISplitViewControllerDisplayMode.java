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
 * UISplitViewControllerDisplayMode class defines the options of display mode
 * for the split view controller.
 */
@CMEnum
public final class UISplitViewControllerDisplayMode {

    /**
     * The display mode is automatically chosen.
     */
    public static final int Automatic = 0;

    /**
     * The primary view controller is hidden.
     */
    public static final int PrimaryHidden = 1;

    /**
     * All view controllers are displayed one next to the other.
     */
    public static final int AllVisible = 2;

    /**
     * The primary view controller is displayed over the secondary view
     * controller.
     */
    public static final int PrimaryOverlay = 3;

    private UISplitViewControllerDisplayMode() {
    }

}
