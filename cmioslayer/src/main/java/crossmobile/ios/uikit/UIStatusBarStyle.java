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
 * UIStatusBarStyle class defines the style of the status bar.
 */
@CMEnum
public final class UIStatusBarStyle {

    /**
     * The status bar has the default dark style used mainly with light
     * backgrounds.
     */
    public static final int Default = 0;

    /**
     * The status bar has light style used mainly with dark backgrounds.
     */
    public static final int LightContent = 1;

    private UIStatusBarStyle() {
    }
}
