/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.coregraphics;

import crossmobile.ios.foundation.CFType;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMJoinMEM;
import org.crossmobile.bridge.ann.CMReference;

import java.util.List;

/**
 * CGGradient class defines an object that represents a color gradient.
 */
@CMReference
public class CGGradient extends CFType {

    final int[] RGBcolors;
    final double locations[];

    /**
     * Constructs a CGGradient object with the specified parameter values.
     *
     * @param space      The color space.
     * @param components The color components for each color.
     * @param locations  The locations of the colors.
     */
    @CMConstructor(" CGGradientRef CGGradientCreateWithColorComponents ( CGColorSpaceRef space, const CGFloat *components, const CGFloat *locations, size_t count ); ")
    public CGGradient(CGColorSpace space, double[] components, @CMJoinMEM(memory = "locations", size = "count") double[] locations) {
        int colorSpaceSize = space.getNumberOfComponents() + 1; // plus alpha
        RGBcolors = new int[components.length / colorSpaceSize];
        if (locations.length != RGBcolors.length)
            throw new ArrayIndexOutOfBoundsException("Incorrect number of colors: " + locations.length + " required based on locations, " + RGBcolors.length + " found");
        for (int i = 0; i < RGBcolors.length; i++)
            RGBcolors[i] = space.pack(components, i * colorSpaceSize);
        this.locations = boundingCheck(locations);
        sort();
    }

    /**
     * Constructs a CGGradient object with the specified parameter values.
     *
     * @param space     The color space.
     * @param colors    The list of colors.
     * @param locations The locations of the colors.
     */
    @CMConstructor(" CGGradientRef CGGradientCreateWithColors ( CGColorSpaceRef space, CFArrayRef colors, const CGFloat *locations ); ")
    public CGGradient(CGColorSpace space, List<CGColor> colors, double[] locations) {
        if (locations.length != colors.size())
            throw new ArrayIndexOutOfBoundsException("Incorrect number of colors: " + locations.length + " required based on locations, " + colors.size() + " found");
        RGBcolors = new int[locations.length];
        for (int i = 0; i < RGBcolors.length; i++)
            RGBcolors[i] = colors.get(i).color;
        this.locations = boundingCheck(locations);
        sort();
    }

    private void sort() {
        int n = locations.length;
        double tempD;
        int tempI;
        for (int pass = 1; pass < n; pass++)
            for (int i = 0; i < n - pass; i++)
                if (locations[i] > locations[i + 1]) {
                    tempD = locations[i];
                    locations[i] = locations[i + 1];
                    locations[i + 1] = tempD;
                    tempI = RGBcolors[i];
                    RGBcolors[i] = RGBcolors[i + 1];
                    RGBcolors[i + 1] = tempI;
                }
    }

    private static double[] boundingCheck(double[] locations) {
        double[] res = new double[locations.length];
        double temp;
        for (int i = 0; i < locations.length; i++) {
            temp = locations[i];
            if (temp < 0)
                temp = 0;
            if (temp > 1)
                temp = 1;
            res[i] = temp;
        }
        return res;
    }

}
