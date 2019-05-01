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
 * UIViewAutoresizing class specifies different options for view autoresizing.
 */
@CMEnum
public final class UIViewAutoresizing {

    /**
     * The view does not resize.
     */
    public static final int None = 0;

    /**
     * The view resizes its width towards the left margin.
     */
    public static final int FlexibleLeftMargin = 1;

    /**
     * The view resizes its width.
     */
    public static final int FlexibleWidth = 1 << 1;

    /**
     * The view resizes its width towards the left margin.
     */
    public static final int FlexibleRightMargin = 1 << 2;

    /**
     * The view resizes its height towards the top margin.
     */
    public static final int FlexibleTopMargin = 1 << 3;

    /**
     * The view increases its height.
     */
    public static final int FlexibleHeight = 1 << 4;

    /**
     * The view resizes its height towards the bottom margin.
     */
    public static final int FlexibleBottomMargin = 1 << 5;

    private UIViewAutoresizing() {
    }
}
