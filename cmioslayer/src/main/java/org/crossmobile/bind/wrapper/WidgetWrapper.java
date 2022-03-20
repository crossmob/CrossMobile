/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.wrapper;

import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.uikit.UIView;
import org.crossmobile.bind.graphics.DrawableMetrics;
import org.crossmobile.bind.graphics.GraphicsContext;
import org.crossmobile.bridge.Native;

import java.lang.ref.WeakReference;

public abstract class WidgetWrapper<IOSWIDG extends UIView, NWIDG extends NativeWrapper<? extends GraphicsContext<?>>, CXT extends GraphicsContext<?>> {

    public static final boolean useNativeDrawPipeline = false;

    private final WeakReference<IOSWIDG> ioswidget;
    private NWIDG nativewidget;
    /**
     * Use this trick since we don't have multiple inheritance in java
     */
    private NativeDispatcher<UIView, ? extends NWIDG, Object, CXT> dispatcher;

    @SuppressWarnings({"LeakingThisInConstructor", "OverridableMethodCallInConstructor", "unchecked"})
    public WidgetWrapper(IOSWIDG widg) {
        this.ioswidget = new WeakReference<>(widg);
        Native.lifecycle().runAndWaitOnEventThread(() -> {
            nativewidget = newNativeWidget();
            dispatcher = Native.widget().newNativeDispatcher(WidgetWrapper.this);
        });
    }

    public IOSWIDG getIOSWidget() {
        return ioswidget.get();
    }

    public NWIDG getNativeWidget() {
        return nativewidget;
    }

    public void setFrame(double x, double y, double width, double height) {
        DrawableMetrics metrics = Native.graphics().metrics();
        CGPoint virtualToHardware = metrics.getVirtualToHardware(x, y);
        dispatcher.setMetrics(
                (int) (virtualToHardware.getX() + 0.5),
                (int) (virtualToHardware.getY() + 0.5),
                (int) (width * metrics.getOrientedScaleWidth() + 0.5),
                (int) (height * metrics.getOrientedScaleHeight() + 0.5));
    }

    public void sendHardwareTouches(Object originalEvent, NativeTouch[] touches) {
        dispatcher.sendTouchEvents(originalEvent, touches);
    }

    public void draw(CXT cx) {
        DrawableMetrics metrics = Native.graphics().metrics();
        cx.scale(1 / metrics.getOrientedScaleWidth(), 1 / metrics.getOrientedScaleHeight());
        dispatcher.draw(cx);
    }

    public abstract NWIDG newNativeWidget();

    public void setUserInteraction(final boolean status) {
        Native.lifecycle().runOnEventThread(() -> nativewidget.setUserInteraction(status));
    }
}
