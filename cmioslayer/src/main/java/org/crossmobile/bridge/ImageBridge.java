/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge;

import crossmobile.ios.coregraphics.CGImage;
import org.crossmobile.bind.graphics.ImageBridgeConstants.ImageInfo;
import org.crossmobile.bind.graphics.ImageBridgeConstants.ImageType;
import org.crossmobile.bind.graphics.NativeBitmap;
import org.robovm.objc.block.VoidBlock1;

import java.io.IOException;
import java.io.OutputStream;

public interface ImageBridge {

    ImageInfo lookup(String shortname);

    NativeBitmap retrieve(String filename);

    void register(CGImage image);

    void recycle();

    void fillStreamAndClose(NativeBitmap bitmap, ImageType type, double quality, OutputStream out) throws IOException;

    /**
     * Create a nine-patch image based on a given image
     *
     * @param bitmap The bitmap to use as a pattern
     * @param top    The top part of the image to keep stationary
     * @param right  The right part of the image to keep stationary
     * @param bottom The bottom part of the image to keep stationary
     * @param left   The left part of the image to keep stationary
     * @param reqX   The width of the new bitmap
     * @param reqY   The height of the new bitmap
     * @return The stretched image
     */
    NativeBitmap stretch(NativeBitmap bitmap, int top, int right, int bottom, int left, int reqX, int reqY);

    /**
     * Create an image with adjusted saturation and brightness, based on an input image. The size of the resulting image
     * will be the same of the original image. This method is used to create images less/more saturated or less/more
     * bright than the original images.
     *
     * @param bitmap     The bitmap input
     * @param saturation The adjusted color saturation
     * @param brightness The adjusted brightness
     * @return The color adjusted image
     */
    NativeBitmap adjustColor(NativeBitmap bitmap, double saturation, double brightness);

    /**
     * Use the alpha channel of an image to create a single-color copy. The color channels of the image will not be
     * used, only the alpha channel. The color of the target image will be the one provided.
     *
     * @param bitmap The input image whose alpha channel will be used.
     * @param color  The target color
     * @return The masked image
     */
    NativeBitmap masked(NativeBitmap bitmap, int color);

    /**
     * Create a new bitmap with specific metrics. The image is usually 4-byte based in the ARGB 8888 color space.
     *
     * @param width  The width of the image
     * @param height The height of the image
     * @return The new image
     */
    NativeBitmap create(int width, int height);

    void requestCamera(VoidBlock1<CGImage> imageFilenameCallback);

    void requestPhotoAlbum(VoidBlock1<CGImage> imageFilenameCallback);

    boolean supportsCamera(ImageSource source);

    enum ImageSource {
        FRONT, BACK, ALBUM, LIBRARY
    }
}
