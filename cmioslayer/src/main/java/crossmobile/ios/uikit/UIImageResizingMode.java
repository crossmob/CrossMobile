/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIImageResizingMode class defines different types resizing modes for an
 * image.
 */
@CMEnum
public final class UIImageResizingMode {

    /**
     * The image is tiled.
     */
    public static final int Tile = 0;

    /**
     * The image is stretched.
     */
    public static final int Stretch = 1;

    private UIImageResizingMode() {
    }
}
