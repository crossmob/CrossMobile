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
package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.coregraphics.CGSize;
import crossmobile.ios.foundation.NSTimer;
import crossmobile.ios.foundation.NSTimerDelegate;
import org.crossmobile.bind.system.Promise;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * UIImageView class extends UIView and defines a custom view for displaying and
 * manipulating UIImage objects.
 */
@CMClass
public class UIImageView extends UIView {

    private Promise<UIImage> image = null;
    private Promise<UIImage> highlightedImage = null;
    private Promise<UIImage> animImage = null;
    private Promise<UIImage> highlightedAnimImage = null;
    private UIImage current = null;
    private boolean highlighted = false;
    private boolean animating = false;
    private NSTimer animateTimer;
    private int animIdx = 0;
    private boolean imageIsDirty;

    /**
     * Constructs a default UIImageView object located at (0,0) with 0 weight
     * and 0 height.
     */
    public UIImageView() {
        this(CGRect.zero());
    }

    /**
     * Constructs a UIImageView object initialized with the dimensions and
     * position specified in the rect parameter.
     *
     * @param rect CGRect that defines dimension and position of UIImageView.
     */
    @CMConstructor("- (instancetype)initWithFrame:(CGRect)frame;")
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public UIImageView(CGRect rect) {
        super(rect);
        setContentMode(UIViewContentMode.Center);
        setUserInteractionEnabled(false);
    }

    /**
     * Sets the image to be displayed in this image view.
     *
     * @param image The image to be displayed in this image view.
     */
    @CMSetter("@property(nonatomic, strong) UIImage *image;")
    public void setImage(UIImage image) {
        setImage(image == null ? null : image.cacheTinted(false, this));
    }

    void setImage(Promise<UIImage> image) {
        this.image = image;
        imageIsDirty = true;
        if (!isHighlighted())
            Native.graphics().refreshDisplay();
    }

    /**
     * Returns the image that is displayed in this image view.
     *
     * @return The image that is displayed in this image view.
     */
    @CMGetter("@property(nonatomic, strong) UIImage *image;")
    public UIImage image() {
        return image == null ? null : image.source();
    }

    /**
     * Sets the image to be displayed when this view is highlighted.
     *
     * @param highlightedImage The image to be displayed when this view is
     *                         highlighted.
     */
    @CMSetter("@property(nonatomic, strong) UIImage *highlightedImage;")
    public void setHighlightedImage(UIImage highlightedImage) {
        setHighlightedImage(highlightedImage == null ? null : highlightedImage.cacheTinted(false, this));
    }

    void setHighlightedImage(Promise<UIImage> highlightedImage) {
        this.highlightedImage = highlightedImage;
        imageIsDirty = true;
        if (isHighlighted())
            Native.graphics().refreshDisplay();
    }

    /**
     * Returns the image that is displayed when this view is highlighted.
     *
     * @return The image that is displayed when this view is highlighted.
     */
    @CMGetter("@property(nonatomic, strong) UIImage *highlightedImage;")
    public UIImage highlightedImage() {
        return highlightedImage.source();
    }

    /**
     * Returns a Boolean that shows whether the image is highlighted.
     *
     * @return A Boolean that shows whether the image is highlighted.
     */
    @CMGetter("@property(nonatomic, getter=isHighlighted) BOOL highlighted;")
    public boolean isHighlighted() {
        return highlighted;
    }

    /**
     * Sets a Boolean that defines whether the image is highlighted.
     *
     * @param highlighted A Boolean that defines whether the image is
     *                    highlighted.
     */
    @CMSetter("@property(nonatomic, getter=isHighlighted) BOOL highlighted;")
    public void setHighlighted(boolean highlighted) {
        if (this.highlighted == highlighted)
            return;
        this.highlighted = highlighted;
        imageIsDirty = true;
        Native.graphics().refreshDisplay();
    }

    /**
     * Starts animation of the images.
     */
    @CMSelector("- (void)startAnimating;")
    public void startAnimating() {
        animating = true;
        if (animateTimer == null)
            animateTimer = NSTimer.scheduledTimerWithTimeInterval(0.04, new AnimDelegate(this), null, true);
    }

    private void stopTimer() {
        if (animateTimer != null)
            animateTimer.invalidate();
        animateTimer = null;
    }

    /**
     * Stops animation of the images.
     */
    @CMSelector("- (void)stopAnimating;")
    public void stopAnimating() {
        animating = false;
    }

    /**
     * Returns a Boolean that shows whether the animation is running.
     *
     * @return A Boolean that shows whether the animation is running.
     */
    @CMSelector("- (BOOL)isAnimating;")
    public boolean isAnimating() {
        return animating;
    }

    /**
     * Sets a list of images to be used as an animation effect.
     *
     * @param animationImages A list of images to be used as an animation
     *                        effect.
     */
    @CMSetter("@property(nonatomic, copy) NSArray<UIImage *> *animationImages;")
    public void setAnimationImages(List<UIImage> animationImages) {
        animImage = animationImages == null || animationImages.isEmpty() ? null
                : UIImage.animatedImageWithImages(animationImages, animationImages.size() * 0.04).cacheTinted(false, this);
        imageIsDirty = true;
        if (!isHighlighted())
            Native.graphics().refreshDisplay();
    }

    /**
     * Returns the list of images that is used as an animation.
     *
     * @return the list of images that is used as an animation.
     */
    @CMGetter("@property(nonatomic, copy) NSArray<UIImage *> *animationImages;")
    public List<UIImage> animationImages() {
        return animImage.source().images();
    }

    /**
     * Sets a list of images to be used, when the view is highlighted, as an
     * animation effect.
     *
     * @param highlightedAnimationImages A list of images to be used, when the
     *                                   view is highlighted, as an animation effect.
     */
    @CMSetter("@property(nonatomic, copy) NSArray<UIImage *> *highlightedAnimationImages;")
    public void setHighlightedAnimationImages(List<UIImage> highlightedAnimationImages) {
        highlightedAnimImage = highlightedAnimationImages == null || highlightedAnimationImages.isEmpty() ? null
                : UIImage.animatedImageWithImages(highlightedAnimationImages, highlightedAnimationImages.size() * 0.04).cacheTinted(false, this);
        imageIsDirty = true;
        if (isHighlighted())
            Native.graphics().refreshDisplay();
    }

    /**
     * Returns the list of images that is used as an animation when the view is
     * highlighted.
     *
     * @return A list of images that is used, when the view is highlighted, as
     * an animation effect.
     */
    @CMGetter("@property(nonatomic, copy) NSArray<UIImage *> *highlightedAnimationImages;")
    public List<UIImage> highlightedAnimationImages() {
        return highlightedAnimImage.source().images();
    }

    private void update() {
        if (!imageIsDirty)
            return;
        if (isAnimating()) {
            List<UIImage> clist = null;
            if (highlighted && highlightedImage != null && highlightedImage.get() != null)
                clist = highlightedAnimImage.get().imagesRef();
            if (clist == null && animImage != null && animImage.get() != null)
                clist = animImage.get().imagesRef();
            if (clist != null) {
                if (animIdx >= clist.size())
                    animIdx = 0;
                if (animIdx >= 0) {
                    current = clist.get(animIdx);
                    imageIsDirty = false;
                    return;
                }
            }
        }
        current = highlighted && highlightedImage != null && highlightedImage.get() != null
                ? highlightedImage.get()
                : (image != null ? image.get() : null);
        imageIsDirty = false;
    }

    @Override
    public final void drawRect(CGRect rect) {
        if (getCurrent() != null)
            getCurrent().drawInRect(rect);
    }

    @Override
    public CGSize sizeThatFits(CGSize size) {
        return getCurrent() == null ? new CGSize(0, 0) : getCurrent().size();
    }

    @Override
    public void tintColorDidChange() {
        super.tintColorDidChange();
        imageIsDirty = true;
        if (image != null)
            image.destroy();
        if (highlightedImage != null)
            highlightedImage.destroy();
        if (animImage != null)
            animImage.destroy();
        if (highlightedAnimImage != null)
            highlightedAnimImage.destroy();
    }

    private static final class AnimDelegate implements NSTimerDelegate {

        private final WeakReference<UIImageView> parent;

        public AnimDelegate(UIImageView parent) {
            this.parent = new WeakReference<>(parent);
        }

        @Override
        public void fireMethod(NSTimer timer) {
            UIImageView view = parent.get();
            if (view == null)
                timer.invalidate();
            else if (view.animating == false)
                view.stopTimer();
            else {
                view.animIdx++;
                view.imageIsDirty = true;
                Native.graphics().refreshDisplay();
            }
        }
    }

    private UIImage getCurrent() {
        if (imageIsDirty)
            update();
        return current;
    }
}
