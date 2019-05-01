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
 * UIViewAnimationCurve class specifies the different types of animation curves.
 */
@CMEnum
public final class UIViewAnimationCurve {

    /**
     * The animation curve starts slowly and continues slowly.The default one.
     */
    public static final int EaseInOut = 0;

    /**
     * The animation curve starts slowly and then speeds up.
     */
    public static final int EaseIn = 1;

    /**
     * The animation curve starts quickly and then slows down.
     */
    public static final int EaseOut = 2;

    /**
     * The animation proceeds evenly.
     */
    public static final int Linear = 3;

    private UIViewAnimationCurve() {
    }
}
