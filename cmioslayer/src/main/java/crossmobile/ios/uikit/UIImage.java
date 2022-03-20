/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.*;
import crossmobile.ios.foundation.NSData;
import crossmobile.ios.foundation.NSObject;
import crossmobile.ios.foundation.NSSecureCoding;
import org.crossmobile.bind.graphics.ImageBridgeConstants.ImageInfo;
import org.crossmobile.bind.graphics.ImageBridgeConstants.ImageType;
import org.crossmobile.bind.graphics.NativeBitmap;
import org.crossmobile.bind.system.Promise;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import static crossmobile.ios.coregraphics.GraphicsDrill.*;
import static org.crossmobile.bind.system.SystemUtilities.writeToRandomFile;

/**
 * UIImage class defines an object that represents images in an application.
 */
@CMClass
public class UIImage extends NSObject implements NSSecureCoding {

    private CGImage scaled;
    private final CGImage orig;
    private final List<UIImage> images;
    private final double scale;
    private final int renderingMode;
    private final int imageOrientation;
    private final UIEdgeInsets capInsets;
    private final double duration;

    UIImage(CGImage image, double scale, UIEdgeInsets capInsets, int renderingMode, int imageOrientation, List<UIImage> images, double duration) {
        this.orig = this.scaled = image;
        this.scale = scale;
        this.capInsets = capInsets == null ? null : capInsets.fixForSize(image.getWidth(), image.getHeight());
        this.renderingMode = renderingMode;
        this.imageOrientation = imageOrientation;
        this.images = images;
        this.duration = duration;
    }

    private UIImage cloneWithBitmap(NativeBitmap bitmap) {
        return new UIImage(cgimage(null, bitmap), scale, capInsets, renderingMode, imageOrientation, images, duration);
    }

    /**
     * Returns an image using the given Core Graphics image.
     *
     * @param img The Core Graphics image used.
     * @return The new image.
     */
    @CMSelector("+ (UIImage *)imageWithCGImage:(CGImageRef)cgImage;")
    public static UIImage imageWithCGImage(CGImage img) {
        return imageWithCGImage(img, 1.0, UIImageOrientation.Up);
    }

    /**
     * Returns an image using the given Core Graphics image with the specified
     * scale and orientation factors.
     *
     * @param img                The Core Graphics image used.
     * @param scale              The scale of the new image.
     * @param UIImageOrientation The orientation of the image.
     * @return The new image.
     * @see crossmobile.ios.uikit.UIImageOrientation
     */
    @CMSelector("+ (UIImage *)imageWithCGImage:(CGImageRef)cgImage scale:(CGFloat)scale orientation:(UIImageOrientation)orientation;")
    public static UIImage imageWithCGImage(CGImage img, double scale, int UIImageOrientation) {
        if (img == null)
            return null;
        return new UIImage(img, scale, null, UIImageRenderingMode.Automatic, UIImageOrientation, null, 0);
    }

    /**
     * Returns the image that corresponds to the specified filename.
     *
     * @param filename The filename for which the image is requested.
     * @return The image that corresponds to the specified filename.
     */
    @CMSelector("+ (UIImage *)imageNamed:(NSString *)name;\n"
            + "")
    public static UIImage imageNamed(String filename) {
        if (filename == null)
            return null;
        if (filename.startsWith("/"))
            filename = filename.substring(1);
        return imageWithContentsOfFile(Native.file().getApplicationPrefix() + "/" + filename);
    }

    /**
     * Returns an image that is created using the specified image data.
     *
     * @param data The image data for the new image.
     * @return The new image created by the specified image data.
     */
    @CMSelector("+ (UIImage *)imageWithData:(NSData *)data;")
    public static UIImage imageWithData(NSData data) {
        return data == null ? null : imageWithContentsOfFile(writeToRandomFile(data.bytes()));
    }

    /**
     * Returns an image that is created using the image data of the specified
     * file.
     *
     * @param filename The file name containing the image data of the new image.
     * @return The new image created using the image data of the file.
     */
    @CMSelector("+ (UIImage *)imageWithContentsOfFile:(NSString *)path;")
    public static UIImage imageWithContentsOfFile(String filename) {
        if (filename == null)
            return null;
        ImageInfo info = Native.image().lookup(filename);
        if (info == null)
            return null;
        return new UIImage(cgimage(info.filename, info.bitmap), info.scale, null, UIImageRenderingMode.Automatic, info.bitmap.getOrientation(), null, 0);
    }

    /**
     * Returns a special animated image based on a image sequence, starting to
     * <b>name</b>0 up to <b>name</b>1024.
     *
     * @param name     The base name of this image
     * @param duration the duration of the animation
     * @return The animated image
     */
    @CMSelector("+ (UIImage *)animatedImageNamed:(NSString *)name \n"
            + "                       duration:(NSTimeInterval)duration;")
    public static UIImage animatedImageNamed(String name, double duration) {
        List<UIImage> images = new ArrayList<>();
        UIImage current;
        for (int i = 0; i <= 1024; i++) {
            current = UIImage.imageNamed(name + i);
            if (current == null)
                break;
            images.add(current);
        }
        if (images.isEmpty())
            return null;
        current = images.get(0);
        return new UIImage(null, current.scale, current.capInsets, current.renderingMode, current.imageOrientation, images, duration);
    }

    @CMSelector("+ (UIImage *)animatedImageWithImages:(NSArray<UIImage *> *)images \n"
            + "                            duration:(NSTimeInterval)duration;")
    public static UIImage animatedImageWithImages(List<UIImage> images, double duration) {
        if (images == null || images.isEmpty())
            return null;
        for (UIImage img : images)
            if (img != null)
                return new UIImage(null, img.scale, img.capInsets, img.renderingMode, img.imageOrientation, images, duration);
        return null;
    }

    /**
     * Returns a stretchable image with the specified cap insets.
     *
     * @param leftCapWidth The width of the cap.
     * @param topCapHeight The height of the cap.
     * @return The new image object.
     */
    @Deprecated
    @CMSelector("- (UIImage *)stretchableImageWithLeftCapWidth:(NSInteger)leftCapWidth \n"
            + "                                 topCapHeight:(NSInteger)topCapHeight;")
    public UIImage stretchableImageWithLeftCapWidth(int leftCapWidth, int topCapHeight) {
        CGSize size = size();
        return resizableImageWithCapInsets(new UIEdgeInsets(topCapHeight, leftCapWidth, size.getHeight() - topCapHeight - 1, size.getWidth() - leftCapWidth - 1), UIImageResizingMode.Stretch);
    }

    /**
     * Returns an image with the specified cap insets.
     *
     * @param capInsets The cap insets of the new image.
     * @return The new image with the specified cap insets.
     */
    @CMSelector("- (UIImage *)resizableImageWithCapInsets:(UIEdgeInsets)capInsets;")
    public UIImage resizableImageWithCapInsets(UIEdgeInsets capInsets) {
        return resizableImageWithCapInsets(capInsets, UIImageResizingMode.Stretch);
    }

    /**
     * Returns an image with the specified cap insets and resizing mode.
     *
     * @param capInsets           The cap insets of the new image.
     * @param UIImageResizingMode The resizing mode of the new image.
     * @return The new image with the specified parameters.
     */
    @CMSelector("- (UIImage *)resizableImageWithCapInsets:(UIEdgeInsets)capInsets \n"
            + "                            resizingMode:(UIImageResizingMode)resizingMode;")
    public UIImage resizableImageWithCapInsets(UIEdgeInsets capInsets, int UIImageResizingMode) {
        return new UIImage(orig, scale, capInsets, renderingMode, imageOrientation, images, duration);
    }

    /**
     * Return a new image, based on the current image, with different rendering
     * mode
     *
     * @param UIImageRenderingMode the new rendering mode
     * @return the new reference image
     */
    @CMSelector("- (UIImage *)imageWithRenderingMode:(UIImageRenderingMode)renderingMode;")
    public UIImage imageWithRenderingMode(int UIImageRenderingMode) {
        return new UIImage(orig, scale, capInsets, UIImageRenderingMode, imageOrientation, images, duration);
    }

    @CMGetter("@property(nonatomic, readonly) UIImageOrientation imageOrientation")
    public int imageOrientation() {
        return imageOrientation;
    }

    /**
     * The scaling of this image: this is used for high resolution images to
     * display correctly.
     *
     * @return the image scaling
     */
    @CMGetter("@property(nonatomic, readonly) CGFloat scale;")
    public double scale() {
        return scale;
    }

    /**
     * Retreive the rendering mode of this image. To change the rendering mode,
     * use the method #imageWithRenderingMode(int)
     *
     * @return the current unmutable rendering mode
     */
    @CMGetter("@property(nonatomic, readonly) UIImageRenderingMode renderingMode;")
    public int renderingMode() {
        return renderingMode;
    }

    /**
     * Returns the underlying image data.
     *
     * @return The underlying image data.
     */
    @CMGetter("@property(nonatomic, readonly) CGImageRef CGImage;")
    public CGImage CGImage() {
        return orig;
    }

    /**
     * Draws this image within the specified rectangle.
     *
     * @param rect The rectangle into which the image is drawn.
     */
    @CMSelector("- (void)drawInRect:(CGRect)rect;")
    public void drawInRect(CGRect rect) {
        if (rect == null || orig == null || (rect.getSize().getWidth() == 0 && rect.getSize().getHeight() == 0))
            return;
        if (isStretchable()) {
            int ctop = (int) (capInsets.getTop() * scale);
            int cleft = (int) (capInsets.getLeft() * scale);
            int cbottom = (int) (capInsets.getBottom() * scale);
            int cright = (int) (capInsets.getRight() * scale);
            int bmwidth = Math.max((int) (rect.getSize().getWidth() * scale), cright + cleft);
            int bmheight = Math.max((int) (rect.getSize().getHeight() * scale), ctop + cbottom);
            NativeBitmap bitmap = bitmap(scaled);
            if (bitmap.getWidth() != bmwidth || bitmap.getHeight() != bmheight)
                scaled = cgimage(null, Native.image().stretch(bitmap(orig), ctop, cright, cbottom, cleft, bmwidth, bmheight));
        }
        UIGraphics.getCurrentContext().drawImage(rect, scaled);
    }

    /**
     * Draws this image using the specified benchmark point.
     *
     * @param point The benchmark point of the image.
     */
    @CMSelector("- (void)drawAtPoint:(CGPoint)point;")
    public void drawAtPoint(CGPoint point) {
        UIGraphics.getCurrentContext().drawImage(new CGRect(point.getX(), point.getY(), orig.getWidth() / scale, orig.getHeight() / scale), orig);
    }

    /**
     * Returns the dimensions of this image.
     *
     * @return The dimensions of the image.
     */
    @CMGetter("@property(nonatomic, readonly) CGSize size;")
    public CGSize size() {
        return new CGSize(orig.getWidth() / scale, orig.getHeight() / scale);
    }

    /**
     * In case this is an animated image, the list of the animated images, or
     * null otherwise.
     *
     * @return List of animated images
     */
    @CMGetter("@property(nonatomic, readonly) NSArray<UIImage *> *images;")
    public List<UIImage> images() {
        return images;
    }

    List<UIImage> imagesRef() {
        return images;
    }

    /**
     * The duration of the animated image, or 0 if it is not animated.
     *
     * @return The animated image duration
     */
    @CMGetter("@property(nonatomic, readonly) NSTimeInterval duration;")
    public double duration() {
        return duration;
    }

    /**
     * Returns PNG encoded data for this image.
     *
     * @return The data of this png image.
     */
    @CMFunction(" NSData * UIImagePNGRepresentation ( UIImage *image ); ")
    public NSData PNGRepresentation() {
        return getImageRepresentation(ImageType.PNG, 1);
    }

    /**
     * Returns JPEG encoded data for this image.
     *
     * @param compressionQuality The quality of the image.
     * @return The data of this JPEG image
     */
    @CMFunction(" NSData * UIImageJPEGRepresentation ( UIImage *image, CGFloat compressionQuality ); ")
    public NSData JPEGRepresentation(double compressionQuality) {
        return getImageRepresentation(ImageType.JPEG, compressionQuality);
    }

    private NSData getImageRepresentation(ImageType type, double quality) {
        ByteArrayOutputStream out = null;
        try {
            out = new ByteArrayOutputStream();
            Native.image().fillStreamAndClose(bitmap(orig), type, quality, out);
            NSData result = NSData.dataWithBytesNoCopy(out.toByteArray());
            return result;
        } catch (IOException ex) {
            Native.system().error("Unable to recreate data from image", ex);
        }
        return null;
    }

    /**
     * Adds this image to the user’s photo album.
     *
     * @param callback    The callback handler.
     * @param contextInfo The context info.
     */
    @CMFunction(" void UIImageWriteToSavedPhotosAlbum ( UIImage *image, id completionTarget, SEL completionSelector, void *contextInfo ); ")
    public void writeToSavedPhotosAlbum(@CMJoinSEL(selector = "completionSelector", target = "completionTarget") UIImageWriteToPhotoAlbumHandler callback, Object contextInfo) {
        Native.system().notImplemented();
    }

    final boolean isStretchable() {
        return capInsets != null;
    }

    @Override
    public String toString() {
        return "UIImage(cgimage=" + orig + ")";
    }

    static UIImage getMidStretchedImage(String full_path) {
        UIImage img = UIImage.imageWithContentsOfFile(full_path);
        if (img == null)
            return null;
        CGSize size = img.size();
        return img.stretchableImageWithLeftCapWidth((int) size.getWidth() / 2, (int) size.getHeight() / 2);
    }

    Promise<UIImage> cacheTinted(boolean favourTint, UIView container) {
        final WeakReference<UIView> containerRef = new WeakReference<>(container);
        return new Promise<>(this, o -> {
            if (o.renderingMode() == UIImageRenderingMode.AlwaysOriginal || (!favourTint && o.renderingMode() == UIImageRenderingMode.Automatic))
                return this;
            else {
                UIView ref = containerRef.get();
                if (ref == null)
                    return this;
                else
                    return o.cloneWithBitmap(Native.image().masked(bitmap(o.orig), color(ref.tintColor().cgcolor)));
            }
        });
    }

    Promise<UIImage> cacheTinted(boolean favourTint, CGColor color) {
        return new Promise<>(this, o -> o.renderingMode() == UIImageRenderingMode.AlwaysOriginal
                || (!favourTint && o.renderingMode() == UIImageRenderingMode.Automatic)
                ? this : o.cloneWithBitmap(Native.image().masked(bitmap(o.orig), color(color))));
    }

    Promise<UIImage> cacheAdjusted(double saturation, double brightness) {
        return new Promise<>(this, o -> o.cloneWithBitmap(Native.image().adjustColor(bitmap(o.orig), saturation, brightness)));
    }
}
