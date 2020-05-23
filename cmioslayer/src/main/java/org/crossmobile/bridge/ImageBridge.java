/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
