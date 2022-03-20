/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.aroma;

import crossmobile.ios.foundation.NSTimer;
import crossmobile.ios.uikit.UIGraphics;
import crossmobile.ios.uikit.UserInterfaceDrill;
import org.crossmobile.backend.aroma.event.*;
import org.crossmobile.backend.desktop.DesktopDrawableMetrics;
import org.crossmobile.backend.desktop.DesktopLifecycleBridge;
import org.crossmobile.backend.desktop.cgeo.CEvent;
import org.crossmobile.bind.system.GenericSystemTimerHandler;
import org.crossmobile.bridge.LifecycleBridge;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.system.BaseUtils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static crossmobile.ios.coregraphics.GraphicsDrill.convertBaseContextToCGContext;
import static crossmobile.ios.uikit.UITouchPhase.*;
import static org.crossmobile.bind.graphics.GraphicsBridgeConstants.DefaultInitialOrientation;

public class AromaLifecycleBridge extends DesktopLifecycleBridge implements LifecycleBridge.SystemTimerHandler {
    private final BlockingQueue<AromaEvent> eventQueue = new LinkedBlockingQueue<>();

    private Thread eventThread;
    private Thread sdlEventThread;
    private GenericSystemTimerHandler timerScheduler;
    private CEvent clicked = CEvent.unset();

    @SuppressWarnings("unchecked")
    @Override
    public void init(String[] args) {
        super.init(args);
        eventThread = Thread.currentThread();
        ((AromaGraphicsBridge) Native.graphics()).initWindow("Aroma");
        Native.graphics().setOrientation(DefaultInitialOrientation);
        UIGraphics.pushContext(convertBaseContextToCGContext(Native.graphics().newGraphicsContext(null, true)));

        sdlEventThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted())
                addEvent(AromaGraphicsBridge.pollSDLEvents());
        }, "SDL event thread");
        sdlEventThread.setDaemon(true);
        sdlEventThread.start();

        timerScheduler = new GenericSystemTimerHandler();
        timerScheduler.start();
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

    private void addEvent(AromaEvent event) {
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
        return this;
    }

    public void interruptSDLThread() {
        sdlEventThread.interrupt();
    }

    @Override
    public void handleEventLoop() {
        AromaGraphicsBridge graphics = (AromaGraphicsBridge) Native.graphics();
        while (!eventThread.isInterrupted()) {
            try {
                AromaEvent event = eventQueue.take();
                encapsulateContext(() -> {
                    if (event instanceof RunnableEvent)
                        ((RunnableEvent) event).run();
                    else if (event instanceof MouseMotionEvent)
                        fireMouseMotionEvent((MouseMotionEvent) event);
                    else if (event instanceof MouseButtonEvent)
                        fireMouseButtonEvent((MouseButtonEvent) event);
                    else if (event instanceof KeyEvent)
                        fireKeyEvent((KeyEvent) event);
                    else if (event instanceof WindowEvent)
                        fireWindowEvent((WindowEvent) event, graphics);
                    else if (event instanceof QuitEvent)
                        quit();
                });
                graphics.repaint(); // Should be last performed action after all events have been processed
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void quit() {
        Native.lifecycle().quit(null, null);
    }

    private void fireKeyEvent(KeyEvent event) {
        System.out.println("Key event!");
    }

    private void fireWindowEvent(WindowEvent event, AromaGraphicsBridge graphics) {
        switch (event.getEventType()) {
            case WindowEvent.SIZE_CHANGED:
                ((DesktopDrawableMetrics) graphics.metrics()).windowResized(graphics.getWindowWidth(), graphics.getWindowHeight());
                break;
            case WindowEvent.CLOSE:
                quit();
                break;
            case WindowEvent.FOCUS_GAINED:
                Native.lifecycle().activate();
                break;
            case WindowEvent.FOCUS_LOST:
                Native.lifecycle().deactivate();
                break;
            default:
                ((AromaGraphicsBridge) Native.graphics()).requestWindowUpdate();
        }
    }

    private void fireMouseMotionEvent(MouseMotionEvent event) {
        if (!((event.getButtonMask() & MouseButtonEvent.BUTTON_1) > 0))
            return;
        fireMouseEvent(event, Moved);
    }

    private void fireMouseButtonEvent(MouseButtonEvent event) {
        if (event.getButton() != MouseButtonEvent.BUTTON_1)
            return;
        DesktopDrawableMetrics metrics = (DesktopDrawableMetrics) Native.graphics().metrics();
        clicked = metrics.findArea(event.getX(), event.getY());
        if (clicked.isButton())
            Native.graphics().refreshDisplay();
        else if (clicked.isArea())
            fireMouseEvent(event, event.isPressDown() ? Began : Ended);
    }

    private void fireMouseEvent(MouseEvent me, int phase) {
        UserInterfaceDrill.fireUIEvent(me, new double[]{me.getX()}, new double[]{me.getY()}, 0, phase);
    }

    @Override
    public void addTimer(NSTimer timer) {
        timerScheduler.addTimer(timer);
    }

    @Override
    public void quitTimers() {
        timerScheduler.quitTimers();
        interruptSDLThread();
    }
}
