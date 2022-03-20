/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;
import org.crossmobile.bridge.ann.CMLib;

/**
 * UIImagePickerControllerCameraFlashMode defines different types of flash mode
 * for the active camera.
 */
@CMEnum
@CMLib(name = "cmimage")
public final class UIImagePickerControllerCameraFlashMode {

    /**
     * The flash is off.
     */
    public static final int Off = -1;

    /**
     * The flash is in auto mode.
     */
    public static final int Auto = 0;

    /**
     * The flash is on.
     */
    public static final int On = 1;

    private UIImagePickerControllerCameraFlashMode() {
    }
}
