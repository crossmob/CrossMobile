/*
 * (c) 2019 by Panayotis Katsaloulis
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
package org.crossmobile.bind.graphics;

import org.crossmobile.bridge.Native;

public final class ImageBridgeConstants {

    public static final int PNG = 1;
    public static final int JPEG = 2;
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
}
