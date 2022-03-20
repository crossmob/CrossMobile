/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bind.system.AbstractLifecycleBridge;
import org.crossmobile.bridge.LifecycleBridge.SystemTimerHandler;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * NSRunLoop class defines an object that is responsible for dispatching input
 * sources such as messages and events to threads.
 */
@CMClass
public class NSRunLoop extends NSObject {

    private final SystemTimerHandler timerHandler;

    NSRunLoop(SystemTimerHandler loopThread) {
        this.timerHandler = loopThread;
    }

    /**
     * Returns the run loop of the main thread.
     *
     * @return The run loop of the main thread.
     */
    @CMSelector("+ (NSRunLoop *)mainRunLoop;")
    public static NSRunLoop mainRunLoop() {
        return ((AbstractLifecycleBridge) Native.lifecycle()).getMainRunLoop();
    }

    /**
     * Registers the specified timer with the specified loop mode.
     *
     * @param timer         The timer to register.
     * @param NSRunLoopMode The loop mode of the timer.
     * @see crossmobile.ios.foundation.NSRunLoopMode
     */
    @CMSelector("- (void)addTimer:(NSTimer *)timer forMode:(NSString *)mode;")
    public void addTimer(NSTimer timer, String NSRunLoopMode) {
        timerHandler.addTimer(timer);
    }

    void quitTimers() {
        timerHandler.quitTimers();
    }
}
