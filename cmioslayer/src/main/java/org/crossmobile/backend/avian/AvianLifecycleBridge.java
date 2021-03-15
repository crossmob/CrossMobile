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

        new Thread(() -> {
            SDLEvent event;
            while (true) {
                while ((event = AvianGraphicsBridge.pollSDLEvents()) != null) {
                    SDLEvent cEvent = event;
                    if (event instanceof MouseEvent)
                        postOnEventThread(() -> fireMouseEvent((MouseEvent) cEvent));
                    if (event instanceof KeyEvent)
                        postOnEventThread(() -> fireKeyEvent((KeyEvent) cEvent));
                    if (event instanceof WindowEvent)
                        postOnEventThread(() -> fireWindowEvent((WindowEvent) cEvent));
                }
            }
        }, "SDL event thread").start();
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

    @SuppressWarnings("unchecked")
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

            drawWindow(Native.graphics().newGraphicsContext(null, true));
            AvianGraphicsBridge.window.update();

            // This method is wrong. We should implement a better way to handle parallel events
            try {
                //noinspection BusyWait
                Thread.sleep(10);
            } catch (InterruptedException ignored) {
            }
        }
    }

    private void fireMouseEvent(MouseEvent event) {
        System.out.println("Mouse event! " + event.getX() + "," + event.getY());
    }

    private void fireKeyEvent(KeyEvent event) {
        System.out.println("Key event!");
    }

    private void fireWindowEvent(WindowEvent event) {
        System.out.println("Window event!");
    }
}
