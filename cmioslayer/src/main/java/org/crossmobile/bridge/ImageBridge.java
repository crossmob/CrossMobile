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
package org.crossmobile.bridge;

import crossmobile.ios.coregraphics.CGImage;
import org.crossmobile.bind.graphics.ImageBridgeConstants;
import org.crossmobile.bind.graphics.ImageBridgeConstants.ImageInfo;
import org.crossmobile.bind.graphics.ImageBridgeConstants.ImageType;
import org.crossmobile.bind.graphics.NativeBitmap;
import org.robovm.objc.block.VoidBlock1;

import java.io.IOException;
import java.io.OutputStream;

public interface ImageBridge {

    ImageInfo lookup(String shortname);

    NativeBitmap retrieve(String filename);

    void register(CGImage image);

    void recycle();

    void fillStreamAndClose(NativeBitmap bitmap, ImageType type, double quality, OutputStream out) throws IOException;

    NativeBitmap stretch(NativeBitmap bitmap, int top, int right, int bottom, int left, int reqX, int reqY);

    NativeBitmap adjustColor(NativeBitmap bitmap, double saturation, double brightness);

    NativeBitmap masked(NativeBitmap bitmap, int color);

    NativeBitmap create(int width, int height);

    void requestCamera(VoidBlock1<CGImage> imageFilenameCallback);

    void requestPhotoAlbum(VoidBlock1<CGImage> imageFilenameCallback);

    boolean supportsCamera(ImageSource source);

    enum ImageSource {
        FRONT, BACK, ALBUM, LIBRARY
    }
}
