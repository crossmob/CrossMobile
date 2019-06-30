/*
 * (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
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
