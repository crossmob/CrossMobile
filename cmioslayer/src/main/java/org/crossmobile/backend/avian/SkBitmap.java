/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.avian;

import crossmobile.ios.uikit.UIImageOrientation;
import org.crossmobile.bind.graphics.NativeBitmap;
import org.crossmobile.bind.system.StreamConverter;
import org.crossmobile.bridge.system.BaseUtils;

import java.io.InputStream;
import java.lang.reflect.Field;

public class SkBitmap extends NativeElement implements NativeBitmap {

    private static Class<?> resourceInputStreamClass = null;
    private static Field peerField = null;

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
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getOrientation() {
        return UIImageOrientation.Up;
    }

    private static long init(InputStream inputStream) {
//        if (inputStream == null)
//            return 0;
//        if (resourceInputStreamClass.isAssignableFrom(inputStream.getClass()))
//            try {
//                return initFromBlob((long) peerField.get(inputStream));
//            } catch (Exception ex) {
//                BaseUtils.throwException(ex);
//            }
//        return initFromByteArray(StreamConverter.toBytes(inputStream));
        return initFromFileName("/home/allan/Documents/TotalCross/Aroma/resources/test.png");
    }

    private static native long initFromFileName(String path);

    private static native long initFromByteArray(byte[] data);

    private static native long initFromBlob(long blobPeer);

    protected native void destroy(long peer);
}
