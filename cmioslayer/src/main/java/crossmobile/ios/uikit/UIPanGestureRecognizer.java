/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.foundation.NSSelector;
import org.crossmobile.bind.system.VelocityFilter;
import org.crossmobile.bridge.ann.*;

import java.util.Set;

import static crossmobile.ios.uikit.UIGestureRecognizerState.*;

/**
 * UIPanGestureRecognizer class recognizes series of touches as a pan gesture.
 */
@CMClass
public class UIPanGestureRecognizer extends UIGestureRecognizer {

    private int maximumNumberOfTouches = 5;
    private int minimumNumberOfTouches = 1;
    private final VelocityFilter vx = new VelocityFilter();
    private final VelocityFilter vy = new VelocityFilter();

    /**
     * Constructs a new UIPanGestureRecognizer object and attaches it to the
     * specified UIGestureRecognizer.
     *
     * @param target The UIGestureRecognizer to which the new object is attached
     *               to.
     */
    public UIPanGestureRecognizer(@CMParamMod(association = AssociationType.ADDSELF) @CMJoinSEL(selector = "action", target = "target") NSSelector<UIGestureRecognizer> target) {
        super(target);
    }

    /**
     * Returns the maximum number of touching fingers for this pan gesture.
     *
     * @return The maximum number of touching fingers for this pan gesture.
     */
    @CMGetter("@property(nonatomic) NSUInteger maximumNumberOfTouches;")
    public int maximumNumberOfTouches() {
        return maximumNumberOfTouches;
    }

    /**
     * Sets the maximum number of touching fingers for this gesture in order to
     * be recognized as a pan gesture.
     *
     * @param maximumNumberOfTouches The maximum number of touching fingers for
     *                               this gesture in order to be recognized as a pan gesture.
     */
    @CMSetter("@property(nonatomic) NSUInteger maximumNumberOfTouches;")
    public void setMaximumNumberOfTouches(int maximumNumberOfTouches) {
        this.maximumNumberOfTouches = maximumNumberOfTouches;
    }

    /**
     * Returns the minimum number of touching fingers for this pan gesture.
     *
     * @return The minimum number of touching fingers for this pan gesture.
     */
    @CMGetter("@property(nonatomic) NSUInteger minimumNumberOfTouches;")
    public int minimumNumberOfTouches() {
        return minimumNumberOfTouches;
    }

    /**
     * Sets the minimum number of touching fingers for this gesture in order to
     * be recognized as a pan gesture.
     *
     * @param minimumNumberOfTouches The minimum number of touching fingers for
     *                               this gesture in order to be recognized as a pan gesture.
     */
    @CMSetter("@property(nonatomic) NSUInteger minimumNumberOfTouches;")
    public void setMinimumNumberOfTouches(int minimumNumberOfTouches) {
        this.minimumNumberOfTouches = minimumNumberOfTouches;
    }

    @Override
    public void reset() {
        if (vx != null) {    // required for early initialization
            vx.reset();
            vy.reset();
        }
    }

    private boolean validNumberOfTouches(Set<UITouch> touches) {
        return touches.size() >= minimumNumberOfTouches && touches.size() <= maximumNumberOfTouches;
    }

    private void parseTouches(Set<UITouch> touches) {
        if (state() >= Recognized)
            return;
        if (state() == Possible) {
            if (validNumberOfTouches(touches)) {
                setState(Began);
                vx.reset();
                vy.reset();
                vx.put(timestamp(), current().getX());
                vy.put(timestamp(), current().getY());
            }
        } else if (state() == Began || state() == Changed) {
            vx.put(timestamp(), current().getX());
            vy.put(timestamp(), current().getY());
            if (validNumberOfTouches(touches))
                setState(Changed);
            else
                setState(Ended);
        }
    }

    @Override
    public void touchesBegan(Set<UITouch> touches, UIEvent event) {
        super.touchesBegan(touches, event);
        parseTouches(touches);
    }

    @Override
    public void touchesMoved(Set<UITouch> touches, UIEvent event) {
        super.touchesMoved(touches, event);
        parseTouches(touches);
    }

    @Override
    public void touchesEnded(Set<UITouch> touches, UIEvent event) {
        super.touchesEnded(touches, event);
        setState(Ended);
    }

    @Override
    public void touchesCancelled(Set<UITouch> touches, UIEvent event) {
        setState(Cancelled);
    }

    @Override
    public boolean canBePreventedByGestureRecognizer(UIGestureRecognizer preventing) {
        return false;
    }

    @Override
    public boolean canPreventGestureRecognizer(UIGestureRecognizer preventing) {
        return false;
    }

    /**
     * Returns the translation value in the coordinate system of the specified
     * view.
     *
     * @param view The view in whose coordinate system is expressed the
     *             translation.
     * @return The translation value.
     */
    @CMSelector("- (CGPoint)translationInView:(UIView *)view;")
    public CGPoint translationInView(UIView view) {
        return new CGPoint(current().getX() - initial().getX(), current().getY() - initial().getY());
    }

    /**
     * Sets the specified translation value for the pan gesture in the
     * coordinate system of the specified view.
     *
     * @param transl The translation value for the pan gesture.
     * @param view   The view in whose coordinate system is computed the
     *               translation.
     */
    @CMSelector("- (void)setTranslation:(CGPoint)translation \n"
            + "                inView:(UIView *)view;")
    public void setTranslation(CGPoint transl, UIView view) {
        initial().setX(current().getX() - transl.getX());
        initial().setY(current().getY() - transl.getY());
        vx.reset();
        vy.reset();
    }

    /**
     * Returns the velocity of this pan gesture expressed as the final
     * point(when the gesture ends) in the coordinate system of the specified
     * view.
     *
     * @param view The view in which the pan gesture occurred.
     * @return The final point where the pan gesture ended.
     */
    @CMSelector("- (CGPoint)velocityInView:(UIView *)view;")
    public CGPoint velocityInView(UIView view) {
        return new CGPoint((float) vx.getValue(), (float) vy.getValue());
    }

    @Override
    public String toString() {
        return super.toString() + " vx=" + vx.getValue() + " vy=" + vy.getValue();
    }
}
