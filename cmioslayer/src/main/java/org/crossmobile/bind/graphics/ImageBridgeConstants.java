/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
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
