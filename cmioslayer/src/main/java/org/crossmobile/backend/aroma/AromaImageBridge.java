/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.aroma;

import crossmobile.ios.coregraphics.CGImage;
import org.crossmobile.backend.desktop.DesktopImageBridge;
import org.crossmobile.bind.graphics.ImageBridgeConstants;
import org.crossmobile.bind.graphics.NativeBitmap;
import org.robovm.objc.block.VoidBlock1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AromaImageBridge extends DesktopImageBridge {

    @Override
    protected NativeBitmap loadFromStreamAndClose(InputStream in) {
        try {
            return new SkBitmap(in);
        } finally {
            try {
                in.close();
            } catch (IOException ignored) {
            }
        }
    }

    @Override
    public void fillStreamAndClose(NativeBitmap bitmap, ImageBridgeConstants.ImageType type, double quality, OutputStream out) throws IOException {
        try {
            byte[] dataBytes = ((SkBitmap) bitmap).getBytesFromImage(type, quality);
            if (dataBytes == null || dataBytes.length == 0)
                throw new IOException("Invalid image data");
            out.write(dataBytes);
        } finally {
            try {
                out.close();
            } catch (Exception ignored) {
            }
        }
    }

    @Override
    public NativeBitmap stretch(NativeBitmap sourceBitmap, int top, int right, int bottom, int left, int reqX, int reqY) {
        SkBitmap targetBitmap = new SkBitmap(sourceBitmap.getWidth(), sourceBitmap.getHeight());
        SkCanvas canvas = new SkCanvas(targetBitmap);
        canvas.drawNinePatch((SkBitmap) sourceBitmap, top, right, bottom, left, reqX, reqY);
        return targetBitmap;
    }

    @Override
    public NativeBitmap adjustColor(NativeBitmap sourceBitmap, double saturation, double brightness) {
        SkBitmap targetBitmap = new SkBitmap((SkBitmap) sourceBitmap);
        targetBitmap.adjustColor(saturation, brightness);
        return targetBitmap;
    }

    @Override
    public NativeBitmap masked(NativeBitmap sourceBitmap, int color) {
        SkBitmap targetBitmap = new SkBitmap(sourceBitmap.getWidth(), sourceBitmap.getHeight());
        ((SkBitmap) sourceBitmap).extractAlpha(targetBitmap);
        SkCanvas canvas = new SkCanvas(targetBitmap);

        canvas.setFillColorWithColor(color);
        canvas.fill();

        return targetBitmap;
    }

    @Override
    public NativeBitmap create(int width, int height) {
        return new SkBitmap(width, height);
    }

    @Override
    public void requestPhotoAlbum(VoidBlock1<CGImage> imageFilenameCallback) {
    }
}
