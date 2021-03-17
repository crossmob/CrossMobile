/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.avian;

import crossmobile.ios.uikit.UIGraphics;
import org.crossmobile.backend.avian.event.*;
import org.crossmobile.backend.desktop.DesktopLifecycleBridge;
import org.crossmobile.bind.system.GenericSystemTimerHandler;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.system.BaseUtils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static crossmobile.ios.coregraphics.GraphicsDrill.convertBaseContextToCGContext;
import static org.crossmobile.bind.graphics.GraphicsBridgeConstants.DefaultInitialOrientation;

public class AvianLifecycleBridge extends DesktopLifecycleBridge {
    private Thread eventThread;
    private final BlockingQueue<AvianEvent> eventQueue = new LinkedBlockingQueue<>();

    @SuppressWarnings("unchecked")
    @Override
    public void init(String[] args) {
        super.init(args);
        if (true)
            Aroma.main(args);
        eventThread = Thread.currentThread();
        ((AvianGraphicsBridge) Native.graphics()).initWindow("Aroma");
        Native.graphics().setOrientation(DefaultInitialOrientation);
        UIGraphics.pushContext(convertBaseContextToCGContext(Native.graphics().newGraphicsContext(null, true)));

        Thread sdlEventThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted())
                addEvent(AvianGraphicsBridge.pollSDLEvents());
        }, "SDL event thread");
        sdlEventThread.setDaemon(true);
        sdlEventThread.start();

        new Thread(() -> {
            while (true) {
                addEvent(new AvianEvent() {
                });
                try {
                    Thread.sleep(1000);
                    Native.graphics().refreshDisplay();
                } catch (InterruptedException ignored) {
                }
            }
        }, "Ticker").start();
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
        if (runnable != null)
            addEvent(new RunnableEvent(runnable));
    }

    private void addEvent(AvianEvent event) {
        if (event != null)
            try {
                eventQueue.put(event);
            } catch (InterruptedException e) {
                BaseUtils.throwException(e);
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
        AvianGraphicsBridge graphics = (AvianGraphicsBridge) Native.graphics();
        while (!eventThread.isInterrupted()) {
            try {
                AvianEvent event = eventQueue.take();
                if (event instanceof RunnableEvent)
                    ((RunnableEvent) event).run();
                else if (event instanceof MouseMotionEvent)
                    fireMouseMotionEvent((MouseMotionEvent) event);
                else if (event instanceof MouseButtonEvent)
                    fireMouseButtonEvent((MouseButtonEvent) event);
                else if (event instanceof KeyEvent)
                    fireKeyEvent((KeyEvent) event);
                else if (event instanceof WindowEvent)
                    fireWindowEvent((WindowEvent) event);
                graphics.repaintIfRequired();
                graphics.windowUpdateIfRequired();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void fireMouseMotionEvent(MouseMotionEvent event) {
        System.out.println("Mouse motion event! " + event.getX() + "," + event.getY());
    }

    private void fireMouseButtonEvent(MouseButtonEvent event) {
        System.out.println("Mouse button event! " + event.getX() + "," + event.getY());
    }

    private void fireKeyEvent(KeyEvent event) {
        System.out.println("Key event!");
    }

    private void fireWindowEvent(WindowEvent event) {
        System.out.println("Window event!");
    }
}
