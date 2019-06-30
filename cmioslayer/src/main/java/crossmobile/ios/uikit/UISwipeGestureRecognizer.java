/*
 * (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
 */
package crossmobile.ios.uikit;

import crossmobile.ios.foundation.NSSelector;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

import java.util.Set;

/**
 * UISwipeGestureRecognizer class extends UIGestureRecognizer and recognizes a
 * swipe gesture in one or more directions.
 */
@CMClass
public class UISwipeGestureRecognizer extends UIGestureRecognizer {

    private int numberOfTouchesRequired;
    private int direction;

    /**
     * Constructs a UISwipeGestureRecognizer and associates it with the
     * specified target.
     *
     * @param target The target of the new UISwipeGestureRecognizer.
     */
    public UISwipeGestureRecognizer(@CMParamMod(association = AssociationType.ADDSELF) @CMJoinSEL(selector = "action", target = "target") NSSelector<UIGestureRecognizer> target) {
        super(target);
    }

    /**
     * Returns the threshold of the number of touches for the gesture.
     *
     * @return The threshold of the number of touches for the gesture.
     */
    @CMGetter("@property(nonatomic) NSUInteger numberOfTouchesRequired;\n"
            + "")
    public int numberOfTouchesRequired() {
        return numberOfTouchesRequired;
    }

    /**
     * Sets the threshold of the number of touches required to recognize this
     * gesture.
     *
     * @param numberOfTouchesRequired The threshold of the number of touches for
     *                                the gesture.
     */
    @CMSetter("@property(nonatomic) NSUInteger numberOfTouchesRequired;\n"
            + "")
    public void setNumberOfTouchesRequired(int numberOfTouchesRequired) {
        this.numberOfTouchesRequired = numberOfTouchesRequired;
    }

    /**
     * Returns the acceptable recognized direction of the swipe.
     *
     * @return The direction of the swipe.
     * @see crossmobile.ios.uikit.UISwipeGestureRecognizerDirection
     */
    @CMGetter("@property(nonatomic) UISwipeGestureRecognizerDirection direction;")
    public int direction() {
        return direction;
    }

    /**
     * Sets the acceptable recognized direction of the swipe.The default
     * direction is right.
     *
     * @param direction The direction of the swipe.
     * @see crossmobile.ios.uikit.UISwipeGestureRecognizerDirection
     */
    @CMSetter("@property(nonatomic) UISwipeGestureRecognizerDirection direction;")
    public void setDirection(int direction) {
        this.direction = direction;
    }

    @Override
    public void touchesBegan(Set<UITouch> touches, UIEvent event) {
        Native.lifecycle().notImplemented();
    }

    @Override
    public void touchesMoved(Set<UITouch> touches, UIEvent event) {
        Native.lifecycle().notImplemented();
    }

    @Override
    public void touchesEnded(Set<UITouch> touches, UIEvent event) {
        Native.lifecycle().notImplemented();
    }

    @Override
    public void touchesCancelled(Set<UITouch> touches, UIEvent event) {
        Native.lifecycle().notImplemented();
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
