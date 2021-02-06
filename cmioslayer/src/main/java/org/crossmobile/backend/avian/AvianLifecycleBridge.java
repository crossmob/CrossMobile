/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.avian;

import org.crossmobile.backend.desktop.DesktopLifecycleBridge;

public class AvianLifecycleBridge extends DesktopLifecycleBridge {
    @Override
    public void splashTerminated() {

    }

    @Override
    public void runOnEventThread(Runnable runnable) {

    }

    @Override
    public void postOnEventThread(Runnable runnable) {

    }

    @Override
    public boolean isEventThread() {
        return false;
    }

    @Override
    public SystemTimerHandler createSystemTimer() {
        return null;
    }

    @Override
    public void hasAnimationFrames(boolean enabled) {

    }
}
