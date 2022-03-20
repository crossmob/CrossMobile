/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.coregraphics;

import crossmobile.ios.foundation.CFType;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMFunction;
import org.crossmobile.bridge.ann.CMReference;

/**
 * CGColor class defines an object that represents a color used in the graphics
 * context as a structure of components.
 */
@CMReference
public class CGColor extends CFType {

    final int color;

    CGColor(int color) {
        this.color = color;
    }

    /**
     * Returns the alpha value of this color.
     *
     * @return The alpha value of this color.
     */
    @CMFunction(" CGFloat CGColorGetAlpha ( CGColorRef color ); ")
    public double getAlpha() {
        return ((color & 0xFF000000) >>> 24) / 255d;
    }

    /**
     * Returns the number of components that define this color.
     *
     * @return The number of components of this color.
     */
    @CMFunction(" size_t CGColorGetNumberOfComponents ( CGColorRef color ); ")
    public int getNumberOfComponents() {
        return CGColorSpace.RGB.getNumberOfComponents() + 1;  // plus alpha
    }

    /**
     * Returns the components that specify this color.
     *
     * @return The components of this color.
     */
    @CMFunction(value = " const CGFloat * CGColorGetComponents ( CGColorRef color ); ", sizeResolver = "(CGColorGetNumberOfComponents(" + CMReference.REFERENCE_NAME + ")+1)")
    public double[] getComponents() {
        return CGColorSpace.RGB.unpack(color, new double[getNumberOfComponents() + 1]);
    }

    @Override
    public String toString() {
        return "CGColor " + Native.graphics().colorToString(color);
    }

    @Override
    public int hashCode() {
        return color;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final CGColor other = (CGColor) obj;
        return this.color == other.color;
    }

}
