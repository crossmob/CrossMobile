/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;
import org.crossmobile.bridge.ann.CMLib;

/**
 * UIImagePickerControllerCameraDevice class defines which camera of the device
 * should be used.
 */
@CMEnum
@CMLib(name = "cmimage")
public final class UIImagePickerControllerCameraDevice {

    /**
     * The rear camera is used.
     */
    public static final int Rear = 0;

    /**
     * The front camera is used.
     */
    public static final int Front = 1;

    private UIImagePickerControllerCameraDevice() {
    }
}
