/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.avian;

import crossmobile.ios.coregraphics.CGImage;
import org.crossmobile.backend.desktop.DesktopImageBridge;
import org.crossmobile.bind.graphics.ImageBridgeConstants;
import org.crossmobile.bind.graphics.NativeBitmap;
import org.robovm.objc.block.VoidBlock1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AvianImageBridge extends DesktopImageBridge {

    @Override
    protected NativeBitmap loadFromStreamAndClose(InputStream in) {
        return new SkBitmap(in);
    }

    @Override
    public void fillStreamAndClose(NativeBitmap bitmap, ImageBridgeConstants.ImageType type, double quality, OutputStream out) throws IOException {
    }

    @Override
    public NativeBitmap stretch(NativeBitmap bitmap, int top, int right, int bottom, int left, int reqX, int reqY) {
        return new SkBitmap(null);
    }

    @Override
    public NativeBitmap adjustColor(NativeBitmap bitmap, double saturation, double brightness) {
        return new SkBitmap(null);
    }

    @Override
    public NativeBitmap masked(NativeBitmap bitmap, int color) {
        return new SkBitmap(null);
    }

    @Override
    public NativeBitmap create(int width, int height) {
        return new SkBitmap(null);
    }

    @Override
    public void requestPhotoAlbum(VoidBlock1<CGImage> imageFilenameCallback) {
    }
}
