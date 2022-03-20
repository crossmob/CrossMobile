/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.foundation.NSSelector;
import crossmobile.ios.foundation.NSTimer;
import org.crossmobile.bind.graphics.Geometry;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

import java.util.Set;

import static crossmobile.ios.uikit.UIGestureRecognizerState.*;

/**
 * UILongPressGestureRecognizer class extends UIGestureRecognizer and recognizes
 * series of touches as long press gestures.This happens only after an extended
 * touch of the screen with one or more fingers.
 */
@CMClass
public class UILongPressGestureRecognizer extends UIGestureRecognizer {

    private static boolean endedTimerAvailable = true;
    private int numberOfTapsRequired = 0;
    private int numberOfTouchesRequired = 1;
    private double minimumPressDuration = 0.5;
    private double allowableMovement = 10;
    private NSTimer timer;
    private int numberOfTouches = 0;

    /**
     * Constructs a new UILongPressGestureRecognizer object and attaches it to
     * the specified UIGestureRecognizer.
     *
     * @param target The UIGestureRecognizer to which the new object is attached
     *               to.
     */
    public UILongPressGestureRecognizer(@CMParamMod(association = AssociationType.ADDSELF) @CMJoinSEL(selector = "action", target = "target") NSSelector<UIGestureRecognizer> target) {
        super(target);
    }

    private void parseTouches(Set<UITouch> touches) {
        if (state() == Began) {
            if (touches.size() < numberOfTouchesRequired)
                setState(Failed);
        } else if (tapcount() > numberOfTapsRequired + 1 || touches.size() > numberOfTouchesRequired)
            setState(Failed);
        else if (state() == Possible && touches.size() == numberOfTouchesRequired && tapcount() == (numberOfTapsRequired + 1)) {
            timer = NSTimer.scheduledTimerWithTimeInterval(minimumPressDuration, timer -> {
                if (state() == Possible) {
                    setState(Began);
                    Native.lifecycle().runOnEventThread(this::performCallbacks);
                }
            }, null, false);
        }
    }

    @Override
    void resetEverything() {
        if (timer != null)
            timer.invalidate();
        timer = null;
        super.resetEverything();
    }

    @Override
    public void touchesBegan(Set<UITouch> touches, UIEvent event) {
        super.touchesBegan(touches, event);
        parseTouches(touches);
    }

    @Override
    public void touchesMoved(Set<UITouch> touches, UIEvent event) {
        super.touchesMoved(touches, event);
        if ((state() != Began && state() != Changed) && Geometry.distance(current(), initial()) > allowableMovement)
            setState(Failed);
        else if (state() == Began) {
            setState(Changed);
            parseTouches(touches);
        }
    }

    @Override
    public void touchesEnded(Set<UITouch> touches, UIEvent event) {
        if ((state() == Began || state() == Changed)) {
            numberOfTouches(touches, false);
            if (endedTimerAvailable) {
                endedTimerAvailable = false;
                NSTimer.scheduledTimerWithTimeInterval(0.1, timer -> {
                    if (numberOfTouches == numberOfTouchesRequired && touches.size() == numberOfTouchesRequired) {
                        setState(Ended);
                        performSelectorOnMainThread(a -> performCallbacks(), null, true);
                    } else
                        setState(Failed);
                    resetEverything();
                    numberOfTouches = 0;
                    endedTimerAvailable = true;
                }, null, false);
            }
        }
    }

    private int numberOfTouches(Set<UITouch> touches, boolean active) {
        for (UITouch t : touches)
            if (active == (t.phase() != UITouchPhase.Cancelled && t.phase() != UITouchPhase.Ended))
                numberOfTouches++;
        return numberOfTouches;
    }

    @Override
    protected void setState(int newstate) {
        if (newstate == Failed && timer != null) {
            timer.invalidate();
            timer = null;
            resetEverything();
        }
        super.setState(newstate);
    }

    @Override
    public void touchesCancelled(Set<UITouch> touches, UIEvent event) {
        setState(Failed);
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
     * Returns the number of taps that are needed for gesture to be recognized
     * as long-press one.
     *
     * @return The number of taps that are needed for gesture to be recognized
     * as long-press one.
     */
    @CMGetter("@property(nonatomic) NSUInteger numberOfTapsRequired;")
    public int numberOfTapsRequired() {
        return numberOfTapsRequired;
    }

    /**
     * Sets the number of taps that are needed for gesture to be recognized as
     * long-press one.
     *
     * @param numberOfTapsRequired The number of taps that are needed for
     *                             gesture to be recognized as long-press one.
     */
    @CMSetter("@property(nonatomic) NSUInteger numberOfTapsRequired;")
    public void setNumberOfTapsRequired(int numberOfTapsRequired) {
        this.numberOfTapsRequired = numberOfTapsRequired;
    }

    /**
     * Returns the number of fingers needed to touch the screen in order to
     * recognize a gesture as a long-press one.
     *
     * @return The number of fingers needed to touch the screen in order to
     * recognize a gesture as a long-press one.
     */
    @CMGetter("@property(nonatomic) NSUInteger numberOfTouchesRequired;")
    public int numberOfTouchesRequired() {
        return numberOfTouchesRequired;
    }

    /**
     * Sets the number of fingers needed to touch the screen in order to
     * recognize a gesture as a long-press one.
     *
     * @param numberOfTouchesRequired The number of fingers needed to touch the
     *                                screen in order to recognize a gesture as a long-press one.
     */
    @CMSetter("@property(nonatomic) NSUInteger numberOfTouchesRequired;")
    public void setNumberOfTouchesRequired(int numberOfTouchesRequired) {
        this.numberOfTouchesRequired = numberOfTouchesRequired;
    }

    /**
     * Returns the minimum touch time that is needed in order to recognize a
     * gesture as a long-press one.
     *
     * @return The time that is needed in order to recognize a gesture as a
     * long-press one.(seconds)
     */
    @CMGetter("@property(nonatomic) CFTimeInterval minimumPressDuration;")
    public double minimumPressDuration() {
        return minimumPressDuration;
    }

    /**
     * Sets the minimum touch time that is needed in order to recognize a
     * gesture as a long-press one.
     *
     * @param minimumPressDuration The time that is needed in order to recognize
     *                             a gesture as a long-press one.(seconds)
     */
    @CMSetter("@property(nonatomic) CFTimeInterval minimumPressDuration;")
    public void setMinimumPressDuration(double minimumPressDuration) {
        this.minimumPressDuration = minimumPressDuration;
    }

    /**
     * Returns the maximum distance(expressed in points) that the fingers can
     * move, until the gesture is rejected and not recognized as a long-press
     * one.
     *
     * @return The maximum distance(expressed in points) that the fingers can
     * move.
     */
    @CMGetter("@property(nonatomic) CGFloat allowableMovement;")
    public double allowableMovement() {
        return allowableMovement;
    }

    /**
     * Sets the maximum distance(expressed in points) that the fingers can move,
     * until the gesture is rejected and not recognized as a long-press one.
     *
     * @param allowableMovement The maximum distance(expressed in points) that
     *                          the fingers can move.
     */
    @CMSetter("@property(nonatomic) CGFloat allowableMovement;")
    public void setAllowableMovement(double allowableMovement) {
        this.allowableMovement = allowableMovement;
    }

}
