/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.coregraphics;

import crossmobile.ios.foundation.CFType;
import org.crossmobile.bridge.ann.CMFunction;
import org.crossmobile.bridge.ann.CMReference;

import java.util.Map;

/**
 * CGLayer class defines a drawing optimization object.
 */
@CMReference
public class CGLayer extends CFType {

    private final CGContext context;
    private final CGSize size;

    /**
     * Creates and returns a CGLayer object with the specified parameter values.
     *
     * @param context    The graphics context of this CGLayer object.
     * @param size       The size of this CGLayer object.
     * @param dictionary The dictionary related to this CGLayer object.
     * @return The new CGLayer object.
     */
    @CMFunction(" CGLayerRef CGLayerCreateWithContext ( CGContextRef context, CGSize size, CFDictionaryRef auxiliaryInfo ); ")
    public static CGLayer createWithContext(CGContext context, CGSize size, Map dictionary) {
        return new CGLayer(context, size, dictionary);
    }

    private CGLayer(CGContext context, CGSize size, Map dictionary) {
        this.context = context;
        this.size = new CGSize(size);
    }

    /**
     * Returns the graphics context of this CGLayer object.
     *
     * @return The graphics context of this CGLayer object.
     */
    @CMFunction(" CGContextRef CGLayerGetContext ( CGLayerRef layer ); ")
    public CGContext getContext() {
        return context;
    }

    /**
     * Returns the width and height of this CGLayer object.
     *
     * @return The width and height of this CGLayer object.
     */
    @CMFunction(" CGSize CGLayerGetSize ( CGLayerRef layer ); ")
    public CGSize getSize() {
        return new CGSize(size);
    }
}
