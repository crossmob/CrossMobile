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

import java.util.Iterator;
import java.util.Set;

import static crossmobile.ios.uikit.UIGestureRecognizerState.*;

/**
 * UIRotationGestureRecognizer class extends UIGestureRecognizer and recognizes
 * rotation gestures when two fingers touch the screen and move in opposite
 * directions formulating a circle.
 */
@CMClass
public class UIRotationGestureRecognizer extends UIGestureRecognizer {

    private double rotation;
    private final VelocityFilter velocity;

    /**
     * Constructs a UIRotationGestureRecognizer and connects is with the
     * specified UIGestureRecognizer.
     *
     * @param target The UIGestureRecognizer to which the new
     *               UIRotationGestureRecognizer is connected to.
     */
    public UIRotationGestureRecognizer(@CMParamMod(association = AssociationType.ADDSELF) @CMJoinSEL(selector = "action", target = "target") NSSelector<UIGestureRecognizer> target) {
        super(target);
        velocity = new VelocityFilter();
    }

    /**
     * Returns the rotation of the gesture.
     *
     * @return The rotation of the gesture expressed in radians.
     */
    @CMGetter("@property(nonatomic) CGFloat rotation;")
    public double rotation() {
        return rotation;
    }

    /**
     * Sets the rotation of the gesture and resets the velocity value.
     *
     * @param rotation The rotation of the gesture expressed in radians.
     */
    @CMSetter("@property(nonatomic) CGFloat rotation;")
    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    /**
     * Returns the velocity of the gesture.Expressed in radians per seconds.
     *
     * @return The velocity of the gesture.
     */
    @CMGetter("@property(nonatomic, readonly) CGFloat velocity;")
    public double velocity() {
        return velocity.getValue();
    }

    @Override
    public void reset() {
        if (velocity != null) // required for early initialization
            velocity.reset();
        rotation = 0;
    }

    void update(UITouch one, UITouch two) {
        rotation = rotation(one, two);
        velocity.put(one.timestamp, rotation);
    }

    @Override
    public void touchesBegan(Set<UITouch> touches, UIEvent event) {
        Iterator<UITouch> iterator = touches.iterator();
        if (state() == Possible) {
            if (touches.size() == 2) {
                setState(Began);
                update(iterator.next(), iterator.next());
            }
        } else if (state() == Began || state() == Changed)
            if (touches.size() != 2)
                setState(Ended);
            else
                update(iterator.next(), iterator.next());
    }

    @Override
    public void touchesMoved(Set<UITouch> touches, UIEvent event) {
        touchesBegan(touches, event);
        if (state() == Began)
            setState(Changed);
    }

    @Override
    public void touchesEnded(Set<UITouch> touches, UIEvent event) {
        touchesBegan(touches, event);
        if (state() == Began || state() == Changed)
            setState(Changed);
    }

    private static float rotation(UITouch t1, UITouch t2) {
        CGPoint one = t1.locationInView(t1.view);
        CGPoint two = t2.locationInView(t1.view);
        double angle = Math.atan((one.getX() - two.getX()) / (one.getY() - two.getY())) + Math.PI / 2;
        if (one.getY() > two.getY())
            angle += Math.PI;
        return (float) angle;
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
}
