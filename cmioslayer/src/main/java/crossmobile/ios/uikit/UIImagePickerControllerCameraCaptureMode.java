/*
 * (c) 2020 by Panayotis Katsaloulis
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
