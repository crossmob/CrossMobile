/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;
import org.crossmobile.bridge.ann.CMLib;

/**
 * UIImagePickerControllerQualityType class defines different video quality
 * options.
 */
@CMEnum
@CMLib(name = "cmimage")
public final class UIImagePickerControllerQualityType {

    /**
     * The video quality is set to be high.
     */
    public static final int High = 0;

    /**
     * The video quality is VGA (640x480 pixels).
     */
    public static final int D640x480 = 3;

    /**
     * The video quality is set to be medium.
     */
    public static final int Medium = 1;

    /**
     * The video quality is set to be low.
     */
    public static final int Low = 2;

    private UIImagePickerControllerQualityType() {
    }
}
