/*
 * (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
 */
package org.crossmobile.bind.wrapper;

import crossmobile.ios.uikit.UIView;
import org.crossmobile.bind.graphics.DrawableMetrics;
import org.crossmobile.bind.graphics.GraphicsContext;
import org.crossmobile.bridge.Native;

import java.lang.ref.WeakReference;

public abstract class WidgetWrapper<IOSWIDG extends UIView, NWIDG extends NativeWrapper<? extends GraphicsContext>, CXT extends GraphicsContext> {

    public static final boolean useNativeDrawPipeline = false;

    private final WeakReference<IOSWIDG> ioswidget;
    private NWIDG nativewidget;
    /**
     * Use this trick since we don't have multiple inheritance in java
     */
    private NativeDispatcher<UIView, ? extends NWIDG, Object, CXT> dispatcher;

    @SuppressWarnings({"LeakingThisInConstructor", "OverridableMethodCallInConstructor"})
    public WidgetWrapper(IOSWIDG widg) {
        this.ioswidget = new WeakReference<>(widg);
        Native.system().runAndWaitOnEventThread(() -> {
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
        dispatcher.setMetrics(
                (int) (x * metrics.getOrientedScaleWidth() + metrics.getOutsetLeft() + 0.5),
                (int) (y * metrics.getOrientedScaleHeight() + metrics.getOutsetTop() + 0.5),
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
        Native.system().runOnEventThread(() -> nativewidget.setUserInteraction(status));
    }
}
