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
 * UIModalTransitionStyle class defines different transition styles for view
 * controllers.
 */
@CMEnum
public final class UIModalTransitionStyle {

    /**
     * The default style of a view controller that slides up from the bottom of
     * the screen and then slides again back down.
     */
    public static final int CoverVertical = 0;

    /**
     * The current view controller flips from right to the left and reveals the
     * new view controller and then from left to the right is revealed the
     * previous controller.
     */
    public static final int FlipHorizontal = 1;

    /**
     * The current view fades out and the new fades in while on return happens
     * the opposite revealing.
     */
    public static final int CrossDissolve = 2;

    /**
     * Current view curls up from one corner revealing new view and on return
     * happens the opposite.
     */
    public static final int PartialCurl = 3;

    private UIModalTransitionStyle() {
    }
}
