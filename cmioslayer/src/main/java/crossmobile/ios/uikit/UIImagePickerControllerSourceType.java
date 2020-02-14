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
