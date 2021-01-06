/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.system;

import crossmobile.ios.foundation.NSTimer;
import org.crossmobile.bridge.LifecycleBridge.SystemTimerHandler;

import java.util.Collection;
import java.util.LinkedHashSet;

import static crossmobile.ios.foundation.FoundationDrill.fireMillis;

public class GenericSystemTimerHandler extends Thread implements SystemTimerHandler {
    private final Collection<NSTimer> registry = new LinkedHashSet<>();
    private final Collection<NSTimer> toAdd = new LinkedHashSet<>();
    private final Collection<NSTimer> toRemove = new LinkedHashSet<>();

    public GenericSystemTimerHandler() {
        super("NSRunLoopThread");
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
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
            } catch (InterruptedException ignored) {
            }
            synchronized (toRemove) {
                long now = System.currentTimeMillis();
                for (NSTimer timer : registry) {
                    if (fireMillis(timer) <= now)
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

    private long getWaitingMillis() {
        long now = System.currentTimeMillis();
        long next = now + 60 * 60 * 1000;
        long current;
        for (NSTimer timer : registry) {
            current = fireMillis(timer);
            if (current <= now) {
                next = now;
                break;
            } else if (current < next)
                next = current;
        }
        return next - now;  // Always bigger than "now", could be 0
    }


    @Override
    public void addTimer(NSTimer timer) {
        synchronized (toAdd) {
            toAdd.add(timer);
        }
        notifyAll();
    }

    @Override
    public void terminate() {
        for (NSTimer timer : registry)
            timer.invalidate();
        interrupt();
        notifyAll();
    }
}