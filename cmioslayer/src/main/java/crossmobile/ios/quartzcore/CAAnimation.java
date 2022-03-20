/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.quartzcore;

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMSetter;

/**
 * CAAnimation class is an abstract class used as a base class for animations.
 */
@CMClass
public abstract class CAAnimation extends NSObject implements CAAction, CAMediaTiming {

    private boolean removedOnCompletion;
    private NSObject delegate;

    /**
     * Specifies the default value of the specified key.
     *
     * @param key The key for which the value is requested.
     * @return The default value for the named property. Returns nil if no
     * default value has been set.
     */
    @CMSelector("+ (id)defaultValueForKey:(NSString *)key;")
    public static String defaultValueForKey(String key) {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Constructs and returns a new CAAnimation.
     *
     * @return A new CAAnimation object.
     */
    @CMSelector("+ (instancetype)animation;")
    public static CATransition animation() {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Returns the delegate of this CAAnimation object.
     *
     * @return The delegate of this CAAnimation object.
     */
    @CMGetter("@property(strong) id delegate;")
    public NSObject delegate() {
        return delegate;
    }

    /**
     * Sets the delegate for this CAAnimation object.
     *
     * @param delegate The delegate of this CAAnimation object.
     */
    @CMSetter("@property(strong) id delegate;")
    public void setDelegate(NSObject delegate) {
        this.delegate = delegate;
    }

    /**
     * Returns a Boolean that shows whether this CAAnimation is removed from the
     * layer on completion.
     *
     * @return TRUE then the CAAnimation is removed from the layer on
     * completion.
     */
    @CMGetter("@property(getter=isRemovedOnCompletion) BOOL removedOnCompletion;")
    public boolean isRemovedOnCompletion() {
        return removedOnCompletion;
    }

    /**
     * Sets a Boolean that defines whether this CAAnimation is removed from the
     * layer on completion.
     *
     * @param removedOnCompletion TRUE then the CAAnimation is removed from the
     *                            layer on completion.
     */
    @CMSetter("@property(getter=isRemovedOnCompletion) BOOL removedOnCompletion;")
    public void setRemovedOnCompletion(boolean removedOnCompletion) {
        this.removedOnCompletion = removedOnCompletion;
    }

    /**
     * It is called when the specified CAAnimation begins playing.
     *
     * @param animation The CAAnimation that has just begun playing.
     */
    @CMSelector("- (void)animationDidStart:(CAAnimation *)anim;")
    public abstract void animationDidStart(CAAnimation animation);

    /**
     * It called when the specified CAAnimation finished playing.
     *
     * @param animation The CAAnimation that finished playing.
     * @param finished  Whether the animation finished
     */
    @CMSelector("- (void)animationDidStop:(CAAnimation *)theAnimation finished:(BOOL)flag")
    public abstract void animationDidStop(CAAnimation animation, boolean finished);
}
