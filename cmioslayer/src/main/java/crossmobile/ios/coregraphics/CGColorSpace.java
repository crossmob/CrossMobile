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
package crossmobile.ios.coregraphics;

import crossmobile.ios.foundation.CFType;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMFunction;
import org.crossmobile.bridge.ann.CMReference;

/**
 * CGColorSpace class defines an object that incorporates information related to
 * color space.
 */
@CMReference
public abstract class CGColorSpace extends CFType {

    static final RGBColorSpace RGB = new RGBColorSpace();
    static final GrayColorSpace Gray = new GrayColorSpace();

    /**
     * Constructs and returns a new device dependent RGB color space.
     *
     * @return The new device dependent RGB color space.
     */
    @CMFunction(" CGColorSpaceRef CGColorSpaceCreateDeviceRGB ( void ); ")
    public static CGColorSpace createDeviceRGB() {
        return RGB;
    }

    /**
     * Constructs a new gray device dependent color space.
     *
     * @return The new gray device dependent color space.
     */
    @CMFunction(" CGColorSpaceRef CGColorSpaceCreateDeviceGray ( void ); ")
    public static CGColorSpace createDeviceGray() {
        return Gray;
    }

    private CGColorSpace() {
    }

    /**
     * Returns the number of components of this color space.
     *
     * @return The number of components of this color space.
     */
    @CMFunction(" size_t CGColorSpaceGetNumberOfComponents ( CGColorSpaceRef space ); ")
    public abstract int getNumberOfComponents();

    abstract int pack(double[] data, int startIndex);

    abstract double[] unpack(int rgba, double[] buffer);

    static final class RGBColorSpace extends CGColorSpace {

        private RGBColorSpace() {
        }

        @Override
        public int getNumberOfComponents() {
            return 3;
        }

        @Override
        int pack(double[] data, int startIndex) {
            return pack(data[startIndex], data[startIndex + 1], data[startIndex + 2], data[startIndex + 3]);
        }

        int pack(double red, double green, double blue, double alpha) {
            return Native.graphics().colorRGBA(red, green, blue, alpha);
        }

        @Override
        double[] unpack(int rgba, double[] buffer) {
            return Native.graphics().colorUnpack(rgba, buffer);
        }

    }

    static final class GrayColorSpace extends CGColorSpace {

        private GrayColorSpace() {
        }

        @Override
        public int getNumberOfComponents() {
            return 1;
        }

        @Override
        int pack(double[] data, int startIndex) {
            return pack(data[startIndex], data[startIndex + 1]);
        }

        int pack(double value, double alpha) {
            return RGB.pack(value, value, value, alpha);
        }

        @Override
        double[] unpack(int rgba, double[] buffer) {
            if (buffer == null || buffer.length < getNumberOfComponents() + 1)
                buffer = new double[getNumberOfComponents() + 1];
            buffer[0] = (((rgba & 0xFF0000) >>> 16) + ((rgba & 0xFF00) >>> 16) + ((rgba & 0xFF) >>> 16)) / 255d / 3;
            buffer[1] = ((rgba & 0xFF000000) >>> 24) / 255d;
            return buffer;
        }
    }
}
