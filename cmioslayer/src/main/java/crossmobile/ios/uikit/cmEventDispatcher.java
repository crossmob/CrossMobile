/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import com.panayotis.ce.CEventManager;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.panayotis.ce.CEventCommons.DEBUG_TOUCH;
import static crossmobile.ios.uikit.UIGestureRecognizerState.*;
import static org.crossmobile.bind.system.Debug.ENABLE_DEBUG;
import static org.crossmobile.bind.system.Debug.Live_Touch_Debug;

class cmEventDispatcher {

    final static cmEventDispatcher dispatcher = new cmEventDispatcher();

    private cmEventDispatcher() {
    }

    synchronized void processTouchEvent(UIEvent event) {
        Map<UIView, Set<UITouch>> map = event.byViews();
        for (UIView view : map.keySet())
            processTouch(view, event, map.get(view));
    }

    private void processTouch(UIView view, UIEvent event, Set<UITouch> touches) {
        boolean cancelTouches = false;
        boolean delayTouches = false;

        if (view.gestures != null && !view.gestures.isEmpty()) {
            Set<UIGestureRecognizer> validRecognizers = new HashSet<>();

            /*
             * Get list of all valid recognizers in the active state
             */
            for (UIGestureRecognizer rec : view.gestures)
                if (rec.enabled)
                    switch (rec.state()) {
                        case Cancelled:
                        case Ended:
                        case Failed:
                            break;
                        case Possible:
                            if (rec.delegate != null && !rec.delegate.shouldBegin(rec)) // Disable if it should not begin - fallthrough switch case if it should begin
                                break;
                        default:
                            if (rec.delegate == null)   // if there is no delegate, no specific test is required any more
                                validRecognizers.add(rec);
                            else {
                                int validTouches = 0;
                                for (UITouch touch : touches)
                                    if (rec.delegate.shouldReceiveTouch(rec, touch))
                                        validTouches++;
                                if (validTouches > 0)
                                    validRecognizers.add(rec);
                            }
                    }

            /*
             * Trim down recognizers that conflict to each other.
             *
             * Implementation note: requireGestureRecognizerToFail is handled as
             * a slave indication. It might be better to completely remove these
             * recognizers from the pipeline instead and not use the "isSlave"
             * private method. This might need more investigation.
             *
             */
            Set<UIGestureRecognizer> freeRecognizers = new HashSet<>(validRecognizers);
            for (UIGestureRecognizer outer : validRecognizers) {
                /*
                 * requireGestureRecognizerToFail
                 */
                for (UIGestureRecognizer slave : outer.getSlaves())
                    if (slave.state() == Possible && slave.view() == view)
                        freeRecognizers.remove(slave);

                /*
                 * canPreventGestureRecognizer
                 * canBePreventedByGestureRecognizer
                 * shouldRecognizeSimultaneouslyWithGestureRecognizer
                 */
                for (UIGestureRecognizer inner : validRecognizers)
                    if (inner != outer) {
                        if (outer.canPreventGestureRecognizer(inner) || inner.canBePreventedByGestureRecognizer(outer))
                            freeRecognizers.remove(inner);
                        if (outer.canBePreventedByGestureRecognizer(inner) || inner.canPreventGestureRecognizer(outer))
                            freeRecognizers.remove(outer);
                        if ((outer.delegate != null && !outer.delegate.shouldRecognizeSimultaneouslyWithGestureRecognizer(outer, inner))
                                && (inner.delegate != null && !inner.delegate.shouldRecognizeSimultaneouslyWithGestureRecognizer(inner, outer))) {
                            freeRecognizers.remove(outer);
                            freeRecognizers.remove(inner);
                        }
                    }
            }
            validRecognizers = freeRecognizers;

            /*
             * Perform touch events on valid gesture recognizers
             */
            for (UIGestureRecognizer rec : validRecognizers) {
                /*
                 * Update state of recognizer
                 */
                int oldState = rec.state();
                rec.setTouchList(touches, event);
                switch (event.phase) {
                    case UITouchPhase.Began:
                        rec.touchesBegan(touches, event);
                        break;
                    case UITouchPhase.Moved:
                        rec.touchesMoved(touches, event);
                        break;
                    case UITouchPhase.Ended:
                        rec.touchesEnded(touches, event);
                        break;
                    case UITouchPhase.Cancelled:
                        rec.touchesCancelled(touches, event);
                        break;
                    default:
                }
                int newstate = rec.state();

                /**
                 * Send gesture events and calculate if low level touch events
                 * should be generated
                 */
                if ((newstate == Began && oldState != Began) || (newstate == Ended && oldState != Ended) || newstate == Changed || newstate == Cancelled)
                    rec.performCallbacks();
                cancelTouches |= rec.cancelsTouchesInView;
                delayTouches |= ((event.phase == UITouchPhase.Began || event.phase == UITouchPhase.Moved) && rec.delaysTouchesBegan)
                        || (event.phase == UITouchPhase.Ended && rec.delaysTouchesEnded);
            }
        }

        if (cancelTouches) {
        } else if (delayTouches) {
        } else {
            // Find target based on which which UIResponder overrides the specific touch event
            UIResponder responder = view;
            while (responder != null && !responder.usesTouches[event.phase]) {
                responder = responder.nextResponder();
                if (responder instanceof UIViewController)
                    responder = responder.nextResponder();
            }
            if (ENABLE_DEBUG && Live_Touch_Debug)
                CEventManager.fireEvent(DEBUG_TOUCH, event);
            if (responder != null)
                switch (event.phase) {
                    case UITouchPhase.Began:
                        responder.touchesBegan(touches, event);
                        break;
                    case UITouchPhase.Moved:
                        responder.touchesMoved(touches, event);
                        break;
                    case UITouchPhase.Ended:
                        responder.touchesEnded(touches, event);
                        break;
                    case UITouchPhase.Cancelled:
                        responder.touchesCancelled(touches, event);
                        break;
                    default:
                }
        }

        /*
         * Reset everything if this is the concluding touch up event with no
         * pending gestures
         */
        if ((event.phase == UITouchPhase.Ended || event.phase == UITouchPhase.Cancelled))
            if (hasPendingGestures(view)) {
            } else if (view.gestures != null)
                for (UIGestureRecognizer rec : view.gestures)
                    rec.resetEverything();
            else {
            }
    }

    /**
     * In order to be sure, check all gesture recognizers to see if anyone is
     * pending
     *
     * @return
     */
    private boolean hasPendingGestures(UIView view) {
        boolean pendingGestures = false;
        if (view.gestures != null)
            for (UIGestureRecognizer rec : view.gestures)
                pendingGestures |= rec.state() == Began || rec.state() == Changed;
        return pendingGestures;
    }
}
