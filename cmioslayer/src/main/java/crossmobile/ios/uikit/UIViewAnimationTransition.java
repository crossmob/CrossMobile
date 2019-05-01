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
 * UIViewAnimationTransition class specifies the transition of a view.
 */
@CMEnum
public final class UIViewAnimationTransition {

    /**
     * There is no transition specified.
     */
    public static final int None = 0;

    /**
     * The view flips from left to right.
     */
    public static final int FlipFromLeft = 1;

    /**
     * The view flips from right to left.
     */
    public static final int FlipFromRight = 2;

    /**
     * The view whirls up from the bottom.
     */
    public static final int CurlUp = 3;

    /**
     * The view whirls down from the top.
     */
    public static final int CurlDown = 4;

    private UIViewAnimationTransition() {
    }
}
