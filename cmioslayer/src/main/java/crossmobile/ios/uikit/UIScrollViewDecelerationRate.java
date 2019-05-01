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
 * UIScrollViewDecelerationRate class specifies how fast a scrolling view moves.
 */
@CMEnum
public final class UIScrollViewDecelerationRate {

    /**
     * The view moves with the default scrolling speed.
     */
    public static final float Normal = 0.998f;

    /**
     * The view moves with fast scrolling speed.
     */
    public static final float Fast = 0.99f;

    private UIScrollViewDecelerationRate() {
    }
}
