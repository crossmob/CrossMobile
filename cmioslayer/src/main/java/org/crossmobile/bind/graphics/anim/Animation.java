/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.anim;

import org.crossmobile.bind.graphics.anim.curve.InterpolationCurve;

public class Animation {
    // All time is stored in milliseconds
    private final long loop;
    private final long duration;
    private final long totalTime;
    private final double lastValue;
    private long createdAt = -1;
    private long finishedAt = -1;
    private boolean valid = true;

    private final AnimationAction consumer;
    private final InterpolationCurve curve;

    Animation(AnimationAction consumer, InterpolationCurve curve, boolean pingpong, double duration, double repeats) {
        this.consumer = consumer;
        this.curve = curve;
        this.duration = (long) (duration * 1000 + 0.5);
        this.loop = pingpong ? 2 * this.duration : this.duration;
        if (repeats < 0.001) {
            this.totalTime = loop;
            this.lastValue = 1;
        } else {
            this.totalTime = (long) (loop * repeats + 0.5);
            this.lastValue = repeats % 1 < 0.001 ? 1 : repeats % 1;
        }
    }

    public void frame(long frameMillis) {
        if (valid) {
            if (createdAt < 0) {
                createdAt = frameMillis;
                finishedAt = frameMillis + totalTime;
                consumer.start();
                consumer.apply(0);
            } else {
                if (frameMillis >= finishedAt) {
                    invalidate();
                    consumer.apply(lastValue);
                    consumer.end();
                } else {
                    long value = (frameMillis - createdAt) % loop;
                    if (loop > duration && value > duration)    // if pingpong is enabled and value is on the "pong" part
                        value = loop - value;
                    consumer.apply(curve.interpolate(((double) value) / duration));
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

