/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.coregraphics;

import crossmobile.ios.uikit.UIImage;
import org.crossmobile.bind.graphics.NativeBitmap;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMFunction;
import org.crossmobile.bridge.ann.CMReference;

/**
 * CGBitmapContext class defines an object that represents a CGContext object as
 * a bitmap.
 */
@CMReference
public class CGBitmapContext extends CGContext {

    private NativeBitmap bitmap;
    private Object canvas;

    /**
     * Constructs an CGBitmapContext with the specified parameter values.
     *
     * @param data             The render byte array of this CGBitmapContext.
     * @param width            The width of the image
     * @param height           The height of the image
     * @param bitsPerComponent The bits per component.
     * @param bytesPerRow      The number of bytes per row.
     * @param colorspace       The color space.
     * @param CGBitmapInfo     Configuration options.
     * @return The CGBitmapContext.
     * @see crossmobile.ios.coregraphics.CGBitmapInfo
     */
    @CMFunction(" CGContextRef CGBitmapContextCreate ( void *data, size_t width, size_t height, size_t bitsPerComponent, size_t bytesPerRow, CGColorSpaceRef space, uint32_t bitmapInfo ); ")
    public static CGBitmapContext create(byte[] data, int width, int height, int bitsPerComponent, int bytesPerRow, CGColorSpace colorspace, int CGBitmapInfo) {
        NativeBitmap bitmap = Native.image().create(width, height);
        Object canvas = Native.graphics().createCanvas(bitmap);
        return new CGBitmapContext(bitmap, canvas);
    }

    @SuppressWarnings("unchecked")
    private CGBitmapContext(NativeBitmap bitmap, Object canvas) {
        super(Native.graphics().newGraphicsContext(canvas, false));
        setShouldAntialias(true);
        this.bitmap = bitmap;
        this.canvas = canvas;
    }

    /**
     * Returns pointer to the image data of this CGBitmapContext.
     *
     * @return A pointer to the image data of this CGBitmapContext.
     */
    @CMFunction(value = " void * CGBitmapContextGetData ( CGContextRef context ); ", sizeResolver = "(CGBitmapContextGetBytesPerRow(self->" + CMReference.REFERENCE_NAME + ")*CGBitmapContextGetHeight(self->" + CMReference.REFERENCE_NAME + "))")
    public byte[] getData() {
        Native.system().notImplemented();
        return null;
    }

    UIImage image() {
        return bitmap == null ? null : UIImage.imageWithCGImage(new CGImage(null, bitmap));
    }

    @SuppressWarnings("unchecked")
    void destroy() {
        Native.graphics().destroyCanvas(canvas);
        canvas = null;
        bitmap = null;
    }
}
