/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.avian;

import crossmobile.ios.uikit.UIGraphics;
import org.crossmobile.backend.desktop.DesktopLifecycleBridge;
import org.crossmobile.bind.system.GenericSystemTimerHandler;
import org.crossmobile.bridge.Native;

import java.util.ArrayList;
import java.util.Collection;

import static crossmobile.ios.coregraphics.GraphicsDrill.convertBaseContextToCGContext;
import static crossmobile.ios.uikit.UserInterfaceDrill.drawWindow;
import static org.crossmobile.bind.graphics.GraphicsBridgeConstants.DefaultInitialOrientation;

public class AvianLifecycleBridge extends DesktopLifecycleBridge {
    private Thread eventThread;
    private final Collection<Runnable> runnableQueue = new ArrayList<>();
    //    private final Queue<SDLEvent> eventQueue = new LinkedList<>();
    private final Object[] lock = new Object[]{};

    @SuppressWarnings("unchecked")
    @Override
    public void init(String[] args) {
        super.init(args);
        if (false)
            Aroma.main(args);
        eventThread = Thread.currentThread();
        AvianGraphicsBridge.window = new SDLWindow("Aroma");
        Native.graphics().setOrientation(DefaultInitialOrientation);
        UIGraphics.pushContext(convertBaseContextToCGContext(Native.graphics().newGraphicsContext(null, true)));
    }

    @Override
    protected boolean supportsExtendedVisuals() {
        return false;
    }

    @Override
    public void splashTerminated() {
    }

    @Override
    public void postOnEventThread(Runnable runnable) {
        synchronized (runnableQueue) {
            runnableQueue.add(runnable);
        }
    }

    @Override
    public boolean isEventThread() {
        return Thread.currentThread() == eventThread;
    }

    @Override
    public SystemTimerHandler createSystemTimer() {
        return new GenericSystemTimerHandler();
    }

    @Override
    public void hasAnimationFrames(boolean enabled) {
    }

    @Override
    public void handleEventLoop() {
        Collection<Runnable> currentList = new ArrayList<>();
        while (!eventThread.isInterrupted()) {
            currentList.clear();
            synchronized (runnableQueue) {
                currentList.addAll(runnableQueue);
                runnableQueue.clear();
            }
            for (Runnable current : currentList)
                current.run();
            synchronized (runnableQueue) {
                if (runnableQueue.isEmpty()) {
                    try {
                        runnableQueue.wait();
                    } catch (InterruptedException ignored) {
                    }
                }
            }
            drawWindow(Native.graphics().newGraphicsContext(null, true));
        }
    }
}
