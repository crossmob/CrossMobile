/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.anim;

import org.crossmobile.bind.graphics.anim.curve.CommonInterpolations;
import org.crossmobile.bind.graphics.anim.curve.InterpolationCurve;
import org.crossmobile.bridge.Native;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Core object which creates and fires animations.
 * All methods in this class should be called bu the event thread
 */
public class Animator {

    private static final Collection<Animation> animations = new HashSet<>();
    private static final Collection<Animation> toAdd = new HashSet<>();

    // Called always on event thread
    public static void animate(long millis) {
        Iterator<Animation> it = animations.iterator();
        while (it.hasNext()) {
            Animation anim = it.next();
            anim.frame(millis);
            if (!anim.isValid())
                it.remove();
        }
        if (!toAdd.isEmpty()) {
            animations.addAll(toAdd);
            toAdd.clear();
        }
        Native.lifecycle().drainWaitingTasks();
        Native.graphics().refreshDisplay();
        Native.lifecycle().hasAnimationFrames(!animations.isEmpty());
    }

    public static Animation add(AnimationAction consumer) {
        return add(consumer, CommonInterpolations.Linear);
    }

    public static Animation add(AnimationAction consumer, InterpolationCurve curve) {
        return add(consumer, curve, 0.3, 1, false);
    }

    public static Animation add(AnimationAction consumer, InterpolationCurve curve, double duration) {
        return add(consumer, curve, duration, 1, false);
    }

    public static Animation add(final AnimationAction consumer, final InterpolationCurve curve, final double duration, final double repeats, final boolean pingpong) {
        if (consumer == null || duration <= 0)
            return null;
        Animation anim = new Animation(consumer, curve, pingpong, duration, repeats);
        Native.lifecycle().runAndWaitOnEventThread(() -> {
            toAdd.add(anim);
            Native.lifecycle().hasAnimationFrames(true);
        });
        return anim;
    }
}
