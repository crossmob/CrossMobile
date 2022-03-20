/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;
import org.crossmobile.bridge.ann.CMLib;

/**
 * UIImagePickerControllerSourceType class defines different types of sources
 * for the image picker controller.
 */
@CMEnum
@CMLib(name = "cmimage")
public final class UIImagePickerControllerSourceType {

    /**
     * The source of the image picker controller is the photo library of the
     * device.
     */
    public static final int PhotoLibrary = 0;

    /**
     * The source of the image picker controller is the camera of the device.
     */
    public static final int Camera = 1;

    /**
     * The source of the image picker controller is the photo album of the
     * camera.
     */
    public static final int SavedPhotosAlbum = 2;

    private UIImagePickerControllerSourceType() {
    }
}
