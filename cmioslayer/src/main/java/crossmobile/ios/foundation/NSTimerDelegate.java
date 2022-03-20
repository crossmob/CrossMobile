/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMTarget;

/**
 * NSTimerDelegate interface is the delegate responsible for handling events
 * received from NSTimer.
 */
@CMTarget
public interface NSTimerDelegate {

    /**
     * It is called after an event related to NSTimer is triggered.
     *
     * @param timer The NSTimer that corresponds to the event.
     */
    @CMSelector("- (void)timerFireMethod:(NSTimer *)timer")
    void fireMethod(NSTimer timer);
}
