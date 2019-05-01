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
 * UIInterfaceOrientationMask class defines different types of supported
 * orientations for the view controller interface.
 */
@CMEnum
public final class UIInterfaceOrientationMask {

    /**
     * The supported orientation of the view controller is portrait.
     */
    public static final int Portrait = (1 << UIInterfaceOrientation.Portrait);

    /**
     * The supported orientation of the view controller is landscape-left.
     */
    public static final int LandscapeLeft = (1 << UIInterfaceOrientation.LandscapeLeft);

    /**
     * The supported orientation of the view controller is landscape-right.
     */
    public static final int LandscapeRight = (1 << UIInterfaceOrientation.LandscapeRight);

    /**
     * The supported orientation of the view controller is portrait upside down.
     */
    public static final int PortraitUpsideDown = (1 << UIInterfaceOrientation.PortraitUpsideDown);

    /**
     * The supported orientation of the view controller is landscape (left or
     * right).
     */
    public static final int Landscape = (LandscapeLeft | LandscapeRight);

    /**
     * The view controller supports all the orientations.
     */
    public static final int All = (Portrait | LandscapeLeft | LandscapeRight | PortraitUpsideDown);

    /**
     * The view controller supports all the orientations except for the portrait
     * upside down.
     */
    public static final int AllButUpsideDown = (Portrait | LandscapeLeft | LandscapeRight);

    private UIInterfaceOrientationMask() {
    }
}
