/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
