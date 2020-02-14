/*
 * (c) 2020 by Panayotis Katsaloulis
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

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * UIGestureRecognizerDelegate interface is the delegate responsible for the communication
 * between UIGestureRecognizer concrete objects and related objects.
 */
@CMClass
public interface UIGestureRecognizerDelegate {

    /**
     * Returns a Boolean (default true) that indicates whether the beginning of
     * touch interpretation by the gesture recognizer is permitted.
     *
     * @param recognizer The gesture recognizer that corresponds to this
     *                   delegate.
     * @return Boolean (default true) that defines whether the beginning of
     * touch interpretation is permitted.
     */
    @CMSelector("- (BOOL)gestureRecognizerShouldBegin:(UIGestureRecognizer *)gestureRecognizer;")
    default boolean shouldBegin(UIGestureRecognizer recognizer) {
        return true;
    }

    /**
     * Returns a Boolean (default true) that indicates whether the concurrent
     * recognition of two gestures is permitted.
     *
     * @param recognizer             The gesture recognizer that corresponds to this
     *                               delegate.
     * @param otherGestureRecognizer The other gesture recognizer.
     * @return Boolean (default true) that indicates whether the concurrent
     * recognition of two gestures is permitted.
     */
    @CMSelector("- (BOOL)gestureRecognizer:(UIGestureRecognizer *)gestureRecognizer \n" +
            "shouldRecognizeSimultaneouslyWithGestureRecognizer:(UIGestureRecognizer *)otherGestureRecognizer;")
    default boolean shouldRecognizeSimultaneouslyWithGestureRecognizer(UIGestureRecognizer recognizer, UIGestureRecognizer otherGestureRecognizer) {
        return false;
    }

    /**
     * Returns a Boolean (default true) that indicates whether the gesture
     * recognizer is permitted to receive an object that represents a touch.
     *
     * @param recognizer The gesture recognizer that asks for permission.
     * @param touch      The touch object that is to be received.
     * @return Boolean (default true) that indicates whether the gesture
     * recognizer is permitted to receive an object that represents a touch.
     */
    @CMSelector("- (BOOL)gestureRecognizer:(UIGestureRecognizer *)gestureRecognizer \n" +
            "       shouldReceiveTouch:(UITouch *)touch;")
    default boolean shouldReceiveTouch(UIGestureRecognizer recognizer, UITouch touch) {
        return true;
    }
}
