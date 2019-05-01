/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
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

    static boolean isUnderMainRunLoop() {
        return Thread.currentThread() == mainRunLoop.loopThread;
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
