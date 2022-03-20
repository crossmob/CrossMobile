/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.foundation.NSSelector;
import org.crossmobile.bind.graphics.Geometry;
import org.crossmobile.bind.system.VelocityFilter;
import org.crossmobile.bridge.ann.*;

import java.util.Iterator;
import java.util.Set;

import static crossmobile.ios.uikit.UIGestureRecognizerState.*;

/**
 * UIPinchGestureRecognizer class extends UIGestureRecognizer and recognizes
 * pinch gestures when two fingers touching the screen get near or move away
 * translated to zoom in and zoom out respectively.
 */
@CMClass
public class UIPinchGestureRecognizer extends UIGestureRecognizer {

    private double scale;
    private float last_distance;
    private float initial_distance;
    private final VelocityFilter velocity;

    /**
     * Constructs a new UIPinchGestureRecognizer object and attaches it to the
     * specified UIGestureRecognizer.
     *
     * @param target The UIGestureRecognizer to which the new object is attached
     *               to.
     */
    public UIPinchGestureRecognizer(@CMParamMod(association = AssociationType.ADDSELF) @CMJoinSEL(selector = "action", target = "target") NSSelector<UIGestureRecognizer> target) {
        super(target);
        velocity = new VelocityFilter();
    }

    /**
     * Returns the scale factor relative to the point of the two touches.The
     * points are expressed in screen's coordinates.
     *
     * @return The scale factor relative to the point of the two touches.
     */
    @CMGetter("@property(nonatomic) CGFloat scale;")
    public double scale() {
        return scale;
    }

    /**
     * Sets the scale factor relative to the point of the two touches. The
     * points are expressed in screen's coordinates.
     *
     * @param scale The scale factor relative to the point of the two touches.
     */
    @CMSetter("@property(nonatomic) CGFloat scale;")
    public void setScale(double scale) {
        this.scale = scale;
        velocity.reset();
        initial_distance = last_distance;
    }

    /**
     * Returns the velocity of the pinch.(in scale factor per sec)
     *
     * @return The velocity of the pinch
     */
    @CMGetter("@property(nonatomic, readonly) CGFloat velocity;")
    public double velocity() {
        return velocity.getValue();
    }

    @Override
    public void reset() {
        if (velocity != null)
            velocity.reset();
        scale = 1;
        initial_distance = 0;
        last_distance = 0;
    }

    private void update(UITouch one, UITouch two, boolean asFirst) {
        last_distance = distance(one, two);
        if (asFirst)
            initial_distance = last_distance;
        velocity.put(one.timestamp, 1);
    }

    @Override
    public void touchesBegan(Set<UITouch> touches, UIEvent event) {
        Iterator<UITouch> iterator = touches.iterator();
        if (state() == Possible) {
            if (touches.size() == 2) {
                setState(Began);
                update(iterator.next(), iterator.next(), true);
            }
        } else if (state() == Began || state() == Changed)
            if (touches.size() == 2) {
                setState(Changed);
                update(iterator.next(), iterator.next(), false);
            } else
                setState(Ended);
    }

    @Override
    public void touchesMoved(Set<UITouch> touches, UIEvent event) {
        touchesBegan(touches, event);
    }

    @Override
    public void touchesEnded(Set<UITouch> touches, UIEvent event) {
        touchesBegan(touches, event);
        if (state() == Began || state() == Changed)
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

    private static float distance(UITouch one, UITouch two) {
        float distance = Geometry.distance(one.locationInView(one.view), two.locationInView(one.view));
        if (distance < 1)
            distance = 1;
        return distance;
    }
}
