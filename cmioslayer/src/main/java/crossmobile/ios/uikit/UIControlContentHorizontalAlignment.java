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
 * UIControlContentVerticalAlignment class defines different types of horizontal
 * alignment for the content within a control element.
 */
@CMEnum
public final class UIControlContentHorizontalAlignment {

    /**
     * The content of the control element is horizontally center-aligned.
     */
    public static final int Center = 0;

    /**
     * The content of the control element is horizontally aligned to the left.
     */
    public static final int Left = 1;

    /**
     * The content of the control element is horizontally aligned to the right.
     */
    public static final int Right = 2;

    /**
     * The content of the control element is horizontally aligned so that it
     * fills the rectangle that encloses it.
     */
    public static final int Fill = 3;
    /**
     * The content of the control element is horizontally aligned to the left for
     * left-to-right languages and to the right for right-to-left languages.
     */
    public static final int Leading = 4;
    /**
     * The content of the control element is horizontally aligned to the right for
     * * left-to-right languages and to the left for right-to-left languages.
     */
    public static final int Trailing = 5;

    private UIControlContentHorizontalAlignment() {
    }
}
