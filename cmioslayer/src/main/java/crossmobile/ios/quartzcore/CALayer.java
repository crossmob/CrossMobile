/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.quartzcore;

import crossmobile.ios.coregraphics.CGContext;
import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.foundation.NSObject;
import crossmobile.ios.uikit.UIView;
import org.crossmobile.bind.system.SystemUtilities;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMSetter;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static crossmobile.ios.uikit.UserInterfaceDrill.drawSelf;

/**
 * CALayer class defines an object that is responsible for handling image
 * content providing animation options along with storing support.
 */
@CMClass
public class CALayer extends NSObject {

    private final Map<String, CAAnimation> animation;
    private WeakReference<UIView> delegateref;
    private CALayer mask;
    CGPoint anchorPoint;
    Map<String, Object> style;

    /**
     * Constructs and returns a CALayer object.
     *
     * @return A new CALayer object.
     */
    @CMSelector("+ (instancetype)layer;")
    public static CALayer layer() {
        return new CALayer();
    }

    /**
     * The default constructor of the CALayer object.
     */
    public CALayer() {
        animation = new HashMap<>();
    }

    /**
     * Add the specified animation object to this CALayer's tree and assigns to
     * it the specified key.
     *
     * @param animation The animation object that is being adde to this
     *                  CALayer's tree.
     * @param key       The key that is assigned to the new animation object added to
     *                  this CALayer.
     */
    @CMSelector("- (void)addAnimation:(CAAnimation *)anim \n"
            + "              forKey:(NSString *)key;")
    public void addAnimation(CAAnimation animation, String key) {
        this.animation.put(key, animation);
    }

    /**
     * Returns the animation object with the specified key.
     *
     * @param key The key of animation object that is requested.
     * @return The requested animation object.
     */
    @CMSelector("- (CAAnimation *)animationForKey:(NSString *)key;")
    public CAAnimation animationForKey(String key) {
        return animation.get(key);
    }

    /**
     * Removes all animations currently attached to this CALayer.
     */
    @CMSelector("- (void)removeAllAnimations;")
    public void removeAllAnimations() {
        animation.clear();
    }

    /**
     * Removes the animation object with specified key.
     *
     * @param key The key of the animation object that will be removed.
     */
    @CMSelector("- (void)removeAnimationForKey:(NSString *)key;\n"
            + "")
    public void removeAnimationForKey(String key) {
        animation.remove(key);
    }

    /**
     * Returns a list containing the animation keys of this CALayer.
     *
     * @return The list with the animation keys of this CALayer.
     */
    @CMSelector("- (NSArray<NSString *> *)animationKeys;")
    public List<String> animationKeys() {
        return new ArrayList<>(animation.keySet());
    }

    /**
     * Renders this CALayer and its sublayers into the specified CGContext.
     *
     * @param context The CGContext into which this CALayer and its sublayers
     *                are rendered.
     */
    @CMSelector("- (void)renderInContext:(CGContextRef)ctx;")
    public void renderInContext(CGContext context) {
        if (delegateref == null || delegateref.get() == null)
            throw new IllegalStateException("Parent object of CALayer does not exist");
        drawSelf(delegateref.get(), context);
    }

    /**
     * Returns the delegate for this CALayer.
     *
     * @return The delegate of this CALayer.
     */
    @CMGetter("@property(weak) id delegate;")
    public UIView delegate() {
        return delegateref == null ? null : delegateref.get();
    }

    /**
     * Sets the delegate for this CALayer.
     *
     * @param delegate The delegate of this CALayer.
     */
    @CMSetter("@property(weak) id delegate;")
    public void setDelegate(UIView delegate) {
        this.delegateref = new WeakReference<>(delegate);
    }

    /**
     * Sets the anchor point of this CALayer.
     *
     * @param point The anchor point of this CALayer.
     */
    @CMSetter("@property CGPoint anchorPoint;")
    public void setAnchorPoint(CGPoint point) {
        this.anchorPoint = point;
        Native.system().notImplemented();
    }

    /**
     * Returns the anchor point of this CALayer.
     *
     * @return The anchor point of this CALayer.
     */
    @CMGetter("@property CGPoint anchorPoint;")
    public CGPoint anchorPoint() {
        return anchorPoint;
    }

    /**
     * Returns a dictionary that is used to store optional properties.
     *
     * @return A dictionary that is used to store optional properties.
     */
    @CMGetter("@property(copy) NSDictionary *style;\n"
            + "")
    public Map<String, Object> style() {
        if (style == null)
            style = new HashMap<>();
        return style;
    }

    @CMGetter("@property(strong) __kindof CALayer *mask;")
    public CALayer mask() {
        return mask;
    }

    @CMSetter("@property(strong) __kindof CALayer *mask;")
    public void setMask(CALayer mask) {
        this.mask = mask;
    }

    @Override
    public String toString() {
        return SystemUtilities.getClassName(getClass());
    }

}
