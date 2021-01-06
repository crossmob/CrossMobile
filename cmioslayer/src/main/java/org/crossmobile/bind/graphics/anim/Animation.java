/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.anim;

import org.crossmobile.bind.graphics.anim.curve.InterpolationCurve;

public class Animation {
    private static final double REPEATS_THRESHOLD = 0.0001;

    private final double loop;
    private final double repeats;
    private final double lastValue;
    private final AnimationAction consumer;
    private final double duration;
    private final InterpolationCurve curve;

    private long creationMillis = -1;
    private long finishMillis = -1;
    private boolean valid = true;

    Animation(AnimationAction consumer, InterpolationCurve curve, boolean pingpong, double duration, double repeats) {
        this.consumer = consumer;
        this.curve = curve;
        this.duration = duration;
        this.loop = pingpong ? duration * 2 : duration;
        this.repeats = repeats < REPEATS_THRESHOLD ? 1 : repeats;            // Make sure repeats is not too small to be accounted

        double last = this.repeats % 1;                                      // Take care of last item, if we have repeats
        if (last < REPEATS_THRESHOLD && this.repeats >= REPEATS_THRESHOLD)   // If repeats are practically integers, and we have at least one full cycle
            last = 1;                                                   //   perform a full cycle instead of zeroing
        if (pingpong) {                                                 // Take care of ping pong
            last *= 2;
            if (last > 1)
                last = 2 - last;
        }
        this.lastValue = last;
    }

    public void frame(long frameMillis) {
        if (valid) {
            if (creationMillis < 0) {
                creationMillis = frameMillis;
                finishMillis = creationMillis + Math.round(1000 * repeats * loop);
                consumer.start();
            } else {
                boolean lastTick = false;
                if (frameMillis >= finishMillis) {
                    frameMillis = finishMillis;
                    lastTick = true;
                }
                double elapsed = ((frameMillis - creationMillis) / 1000d) % loop;
                if (elapsed > duration)
                    elapsed = loop - elapsed;
                consumer.apply(lastTick ? lastValue : curve.interpolate(elapsed / duration));
                if (lastTick) {
                    invalidate();
                    consumer.end();
                }
            }
        }
    }

    public void invalidate() {
        valid = false;
    }

    public boolean isValid() {
        return valid;
    }
}

