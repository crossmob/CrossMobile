/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.avian;

import crossmobile.ios.uikit.UIImageOrientation;
import org.crossmobile.bind.graphics.ImageBridgeConstants;
import org.crossmobile.bind.graphics.NativeBitmap;
import org.crossmobile.bind.system.StreamConverter;
import org.crossmobile.bridge.system.BaseUtils;

import java.io.InputStream;
import java.lang.reflect.Field;

public class SkBitmap extends NativeElement implements NativeBitmap {

    private static Class<?> resourceInputStreamClass = null;
    private static Field peerField = null;

    private int width;
    private int height;

    static {
        try {
            resourceInputStreamClass = Class.forName("avian/avianvmresource/Handler$ResourceInputStream");
            peerField = resourceInputStreamClass.getField("peer");
            peerField.setAccessible(true);
        } catch (Exception ignored) {
        }
    }

    SkBitmap(InputStream is) {
        super(init(is));
        if (!postInit(this.peer))
            throw new IllegalArgumentException("Unable to initialize bitmap from input stream");
    }

    SkBitmap(int width, int height) {
        super(init(width, height));
        this.width = width;
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getOrientation() {
        return UIImageOrientation.Up;
    }

    private static long init(InputStream inputStream) {
        if (inputStream == null)
            return 0;
        if (resourceInputStreamClass.isAssignableFrom(inputStream.getClass()))
            try {
                return initFromBlob((long) peerField.get(inputStream));
            } catch (Exception ex) {
                BaseUtils.throwException(ex);
            }
        return initFromByteArray(StreamConverter.toBytes(inputStream));
    }

    private static long init(int width, int height) {
        return initFromSizes(width, height);
    }

    byte[] getBytesFromImage(ImageBridgeConstants.ImageType imageType, double quality) {
        return getBytesFromImage(peer, imageType == ImageBridgeConstants.ImageType.PNG, quality);
    }

    private static native long initFromSizes(int width, int height);

    private static native long initFromByteArray(byte[] data);

    private static native long initFromBlob(long blobPeer);

    private native boolean postInit(long peer);

    private static native byte[] getBytesFromImage(long peer, boolean asPNG, double quality);

    protected native void destroy(long peer);
}
