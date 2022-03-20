/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIImageResizingMode class defines different types of rendering the color of
 * an image.
 */
@CMEnum
public final class UIImageRenderingMode {

    /**
     * Automatically select the color of the image
     */
    public static final int Automatic = 0;
    /**
     * Use only original colors
     */
    public static final int AlwaysOriginal = 1;
    /**
     * Use only tinted colors
     */
    public static final int AlwaysTemplate = 2;

    private UIImageRenderingMode() {
    }
}
