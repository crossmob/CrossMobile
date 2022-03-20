/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics;

import org.crossmobile.bridge.Native;

public final class ImageBridgeConstants {

    public static final int SYSSIZE = Native.file().getSystemPrefix().length();
    public static final int APPSIZE = Native.file().getApplicationPrefix().length() + 1; // we also want to eliminate the "/" character
    public static final String SYSNAME = Native.file().getSystemPrefix().toLowerCase();
    public static final String APPNAME = Native.file().getApplicationPrefix().toLowerCase();

    public static class ImageInfo {

        public final NativeBitmap bitmap;
        public final String filename;
        public final float scale;

        public ImageInfo(NativeBitmap bitmap, String filename, float scale) {
            this.bitmap = bitmap;
            this.filename = filename;
            this.scale = scale;
        }

        @Override
        public String toString() {
            return "[Image file=\"" + filename + "\" width=" + bitmap.getWidth() + " height=" + bitmap.getHeight() + " scale=" + scale + "]";
        }
    }

    private ImageBridgeConstants() {
    }

    public enum ImageType {
        PNG, JPEG
    }
}
