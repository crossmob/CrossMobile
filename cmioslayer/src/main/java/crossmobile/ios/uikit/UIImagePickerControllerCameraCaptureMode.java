/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;
import org.crossmobile.bridge.ann.CMLib;

/**
 * UIImagePickerControllerCameraCaptureMode class defines different types media
 * capturing for the camera.
 */
@CMEnum
@CMLib(name = "cmimage")
public final class UIImagePickerControllerCameraCaptureMode {

    /**
     * The camera captures photos.
     */
    public static final int Photo = 0;

    /**
     * The camera captures videos.
     */
    public static final int Video = 1;

    private UIImagePickerControllerCameraCaptureMode() {
    }
}
