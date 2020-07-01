/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * NSRunLoop class defines an object that is responsible for dispatching input
 * sources such as messages and events to threads.
 */
@CMClass
public class NSRunLoop extends NSObject {

    private static NSRunLoop mainRunLoop;

    private final Collection<NSTimer> registry = new LinkedHashSet<>();
    private final Collection<NSTimer> toAdd = new LinkedHashSet<>();
    private final Collection<NSTimer> toRemove = new LinkedHashSet<>();
    private final LoopThread loopThread = new LoopThread();

    private NSRunLoop() {
    }

    /**
     * Returns the run loop of the main thread.
     *
     * @return The run loop of the main thread.
     */
    @CMSelector("+ (NSRunLoop *)mainRunLoop;")
    public static NSRunLoop mainRunLoop() {
        if (mainRunLoop == null) {
            mainRunLoop = new NSRunLoop();
            mainRunLoop.loopThread.start();
        }
        return mainRunLoop;
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
        synchronized (toAdd) {
            toAdd.add(timer);
        }
        synchronized (loopThread) {
            loopThread.notifyAll();
        }
    }

    private class LoopThread extends Thread {

        public LoopThread() {
            super("NSRunLoopThread");
            setDaemon(true);
        }

        @Override
        public void run() {
            while (true) {
                synchronized (toAdd) {
                    if (!toAdd.isEmpty()) {
                        registry.addAll(toAdd);
                        toAdd.clear();
                    }
                }
                try {
                    long waitTime = getWaitingMillis();
                    if (waitTime > 0)
                        synchronized (this) {
                            wait(waitTime);
                        }
                } catch (InterruptedException ex) {
                }
                synchronized (toRemove) {
                    long now = System.currentTimeMillis();
                    for (NSTimer timer : registry) {
                        if (timer.fireMillis() <= now)
                            timer.fire();
                        if (!timer.isValid())
                            toRemove.add(timer);
                    }
                    if (!toRemove.isEmpty()) {
                        registry.removeAll(toRemove);
                        toRemove.clear();
                    }
                }
            }
        }
    }

    private long getWaitingMillis() {
        long now = System.currentTimeMillis();
        long next = now + 60 * 60 * 1000;
        long current;
        for (NSTimer timer : registry) {
            current = timer.fireMillis();
            if (current <= now) {
                next = now;
                break;
            } else if (current < next)
                next = current;
        }
        return next - now;  // Always bigger than "now", could be 0
    }

    void notifyLoop() {
        synchronized (loopThread) {
            loopThread.notifyAll();
        }
    }

    void invalidateAll() {
        for (NSTimer timer : mainRunLoop.registry)
            timer.invalidate();
    }
}
