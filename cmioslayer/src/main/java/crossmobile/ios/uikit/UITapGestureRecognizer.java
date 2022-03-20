/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.foundation.NSSelector;
import crossmobile.ios.foundation.NSTimer;
import org.crossmobile.bridge.ann.*;

import java.util.Set;

import static crossmobile.ios.uikit.UIGestureRecognizerState.*;
import static org.crossmobile.bind.graphics.Geometry.distance;

/**
 * UITapGestureRecognizer class recognizes a series of taps as a gesture.
 */
@CMClass
public class UITapGestureRecognizer extends UIGestureRecognizer {

    private int numberOfTapsRequired = 1;
    private int numberOfTouchesRequired = 1;
    boolean timerDisabled = false;

    /**
     * Constructs new UITapGestureRecognizer and attaches it to the specified
     * UIGestureRecognizer.
     *
     * @param target The UIGestureRecognizer to which the new object is attached
     *               to.
     */
    public UITapGestureRecognizer(@CMParamMod(association = AssociationType.ADDSELF) @CMJoinSEL(selector = "action", target = "target") NSSelector<UIGestureRecognizer> target) {
        super(target);
    }

    /**
     * Returns the number of taps required so that the gesture is recognized.
     *
     * @return The number of taps required.
     */
    @CMGetter("@property(nonatomic) NSUInteger numberOfTapsRequired;")
    public int numberOfTapsRequired() {
        return numberOfTapsRequired;
    }

    /**
     * Sets the number of taps required so that the gesture is recognized.
     *
     * @param numberOfTapsRequired The number of taps required.
     */
    @CMSetter("@property(nonatomic) NSUInteger numberOfTapsRequired;")
    public void setNumberOfTapsRequired(int numberOfTapsRequired) {
        this.numberOfTapsRequired = numberOfTapsRequired;
    }

    /**
     * Returns the number of touches required so that the gesture is recognized.
     *
     * @return The number of touches required.
     */
    @CMGetter("@property(nonatomic) NSUInteger numberOfTouchesRequired;")
    public int numberOfTouchesRequired() {
        return numberOfTouchesRequired;
    }

    /**
     * Sets the number of touches required so that the gesture is recognized.
     *
     * @param numberOfTouchesRequired The number of touches required.
     */
    @CMSetter("@property(nonatomic) NSUInteger numberOfTouchesRequired;")
    public void setNumberOfTouchesRequired(int numberOfTouchesRequired) {
        this.numberOfTouchesRequired = numberOfTouchesRequired;
    }

    private void parseTouches(Set<UITouch> touches) {
        if (state() >= Recognized)
            return;
        if (tapcount() < numberOfTapsRequired)
            setState(Failed);
        if (state() == Possible) {  // Launch timer in the first event only
            setState(Began);
            if (!timerDisabled)
                NSTimer.scheduledTimerWithTimeInterval(UITouch.DOUBLETAP, (NSTimer timer) -> {
                    if (state() == Began)
                        setState(Cancelled);
                }, null, false);
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
        if (distance(current(), initial()) > MAXRAD)
            setState(Failed);
    }

    @Override
    public void touchesEnded(Set<UITouch> touches, UIEvent event) {
        super.touchesEnded(touches, event);
        if (state() == Began)
            if (touches.size() >= numberOfTouchesRequired && tapcount() >= numberOfTapsRequired)
                setState(Ended);
            else
                setState(Cancelled);
    }

    @Override
    public void touchesCancelled(Set<UITouch> touches, UIEvent event) {
        setState(Cancelled);
    }

    @Override
    public boolean canBePreventedByGestureRecognizer(UIGestureRecognizer newMaster) {
        if (newMaster instanceof UITapGestureRecognizer)
            return ((UITapGestureRecognizer) newMaster).numberOfTapsRequired > numberOfTapsRequired;
        return false;
    }

    @Override
    public boolean canPreventGestureRecognizer(UIGestureRecognizer newSlave) {
        if (newSlave instanceof UITapGestureRecognizer)
            return ((UITapGestureRecognizer) newSlave).numberOfTapsRequired < numberOfTapsRequired;
        return false;
    }
}
