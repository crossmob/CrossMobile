/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.coregraphics;

import crossmobile.ios.foundation.CFType;
import org.crossmobile.bind.graphics.ImageBridgeConstants;
import org.crossmobile.bind.graphics.NativeBitmap;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMFunction;
import org.crossmobile.bridge.ann.CMReference;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.crossmobile.bind.graphics.ImageBridgeConstants.*;

/**
 * CGImage class defines an object that represents a bitmap image.
 */
@CMReference
public class CGImage extends CFType {

    private final String filename;
    private NativeBitmap bitmap;
    private int width;
    private int height;

    /**
     * Constructs and returns a CGImage using the data of specified image that
     * are contained within the given rectangle.
     *
     * @param image The image that is used.
     * @param rect  The rectangle that specifies which part of the image to use.
     * @return The new CGImage.
     */
    @CMFunction(" CGImageRef CGImageCreateWithImageInRect ( CGImageRef image, CGRect rect ); ")
    public static CGImage createWithImageInRect(CGImage image, CGRect rect) {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Constructs and returns a CGImage from the specified PNG image.
     *
     * @param provider               The PNG image that is used for the CGImage.
     * @param decode                 The decode array to use, usually null.
     * @param shouldInterpolate      WHether interpolation is desired.
     * @param CGColorRenderingIntent The way color is handled.
     * @return The new CGImage object.
     */
    @CMFunction(" CGImageRef CGImageCreateWithPNGDataProvider ( CGDataProviderRef source, const CGFloat *decode, bool shouldInterpolate, CGColorRenderingIntent intent ); ")
    public static CGImage createWithPNGDataProvider(CGDataProvider provider, double[] decode, boolean shouldInterpolate, int CGColorRenderingIntent) {
        Native.system().notImplemented();
        return null;
    }

    @SuppressWarnings("LeakingThisInConstructor")
    CGImage(String filename, NativeBitmap bitmap) {
        if (filename == null && bitmap != null) {
            String tempFile = Native.file().getRandomLocation();
            try {
                Native.image().fillStreamAndClose(bitmap, ImageType.PNG, 1, new FileOutputStream(tempFile));
                filename = tempFile;
            } catch (IOException ex) {
                new File(tempFile).delete();
            }
        }
        Native.image().register(this);
        this.filename = filename;
        this.bitmap = bitmap;
        this.width = bitmap == null ? -1 : bitmap.getWidth();
        this.height = bitmap == null ? -1 : bitmap.getHeight();
    }

    /**
     * Returns the width of this image in pixels.
     *
     * @return The width of this image in pixels.
     */
    @CMFunction(" size_t CGImageGetWidth ( CGImageRef image ); ")
    public int getWidth() {
        if (width < 0)
            bitmap();   // retrieve bitmap and calculate size
        return width;
    }

    /**
     * Returns the height of this image in pixels.
     *
     * @return The height of this image in pixels.
     */
    @CMFunction(" size_t CGImageGetHeight ( CGImageRef image ); ")
    public int getHeight() {
        if (height < 0)
            bitmap();   // retrieve bitmap and calculate size
        return height;
    }

    NativeBitmap bitmap() {
        if (bitmap == null) {
            bitmap = Native.image().retrieve(filename);
            width = bitmap.getWidth();
            height = bitmap.getHeight();
        }
        return bitmap;
    }

    void trash() {
        bitmap = null;
    }

    @Override
    @SuppressWarnings({"FinalizeDeclaration", "deprecated"})
    protected void finalize() throws Throwable {
        super.finalize();
        if (Native.file().isTemporaryLocation(filename))
            Native.lifecycle().postOnEventThread(() -> new File(filename).delete());
    }

    String getFilename() {
        return filename;
    }

    @Override
    public String toString() {
        return "CGImage(width=" + getWidth() + " height=" + getHeight() + " location=" + filename + ")";
    }
}
