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
package org.crossmobile.bind.system;

import crossmobile.ios.foundation.NSDate;
import crossmobile.ios.foundation.NSRunLoop;
import crossmobile.ios.foundation.NSTimer;
import crossmobile.ios.foundation.NSTimerDelegate;
import org.crossmobile.bind.graphics.curve.InterpolationCurve;
import org.crossmobile.bridge.Native;

public class Ticker {

    private static final double REPEATS_THRESHOLD = 0.0001;

    public static NSTimer add(TickerConsumer consumer) {
        return add(consumer, InterpolationCurve.Linear);
    }

    public static NSTimer add(TickerConsumer consumer, InterpolationCurve curve) {
        return add(consumer, curve, 0.3, 1, false);
    }

    public static NSTimer add(TickerConsumer consumer, InterpolationCurve curve, double duration) {
        return add(consumer, curve, duration, 1, false);
    }

    public static NSTimer add(final TickerConsumer consumer, final InterpolationCurve curve, final double duration, final double repeats, final boolean pingpong) {
        if (consumer == null)
            return null;
        NSTimer timer = new NSTimer(NSDate.date(), 1 / 60d, new NSTimerDelegate() {

            private final double loop;
            private final double lastValue;
            private final long creationMillis;
            private final long finishMillis;
            private final double arepeats;

            {
                loop = pingpong ? duration * 2 : duration;
                {
                    arepeats = repeats < REPEATS_THRESHOLD ? 1 : repeats;            // Make sure repeats is not too small to be accounted
                    double last = arepeats % 1;                                      // Take care of last item, if we have repeats
                    if (last < REPEATS_THRESHOLD && arepeats >= REPEATS_THRESHOLD)   // If repeats are practically integers, and we have at least one full cycle
                        last = 1;                                                   //   perform a full cycle instead of zeroing
                    if (pingpong) {                                                 // Take care of ping pong
                        last *= 2;
                        if (last > 1)
                            last = 2 - last;
                    }
                    lastValue = last;
                }
                creationMillis = System.currentTimeMillis();
                finishMillis = creationMillis + Math.round(1000 * arepeats * loop);
                consumer.start();
                fireMethod(null);
            }

            @Override
            public void fireMethod(NSTimer timer) {
                boolean lastTick = false;
                long now = System.currentTimeMillis();
                if (now >= finishMillis) {
                    now = finishMillis;
                    lastTick = true;
                }
                double elapsed = ((now - creationMillis) / 1000d) % loop;
                if (elapsed > duration)
                    elapsed = loop - elapsed;
                consumer.apply(lastTick ? lastValue : curve.interpolate(elapsed / duration));
                Native.graphics().refreshDisplay();
                if (lastTick) {
                    if (timer != null)
                        timer.invalidate();
                }
            }
        }, null, true) {
            @Override
            public void invalidate() {
                super.invalidate();
                consumer.end();
            }
        };

        NSRunLoop.mainRunLoop().addTimer(timer, null);
        return timer;
    }

}
