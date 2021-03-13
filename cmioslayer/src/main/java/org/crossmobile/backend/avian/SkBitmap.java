/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.avian;

import crossmobile.ios.uikit.UIImageOrientation;
import org.crossmobile.bind.graphics.NativeBitmap;
import org.crossmobile.bridge.system.BaseUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

public class SkBitmap extends NativeElement implements NativeBitmap {
    SkBitmap(String path) {
        super(init(path));
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

    private static long init(String path) {
        try {
            InputStream inputStream = SkBitmap.class.getClass().getClassLoader().getResourceAsStream(path);
            if (inputStream == null)
                BaseUtils.throwException(new IOException("Resource not found: " + path));
            Field field = inputStream.getClass().getField("peer");
            field.setAccessible(true);
            Long peer = (Long) field.get(inputStream);
            return initFromBlob(peer);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            return initFromFileName(path);
        }
    }

    private static native long initFromFileName(String path);

    private static native long initFromBlob(long blobPeer);

    protected native void destroy(long peer);
}
