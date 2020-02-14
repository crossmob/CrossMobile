/*
 * (c) 2020 by Panayotis Katsaloulis
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
import org.crossmobile.bind.graphics.GraphicsContext;

import java.lang.ref.WeakReference;

/**
 * Use this utility object since multiple inheritance is not allowed in Java.
 * Note that the draw method, although it can be implemented here, is not, since
 * in most cases the usual drawing mechanism is skipped and the drawing is
 * performed only when required through a "drawSuper" method. To do this, direct
 * access to the object might me required - or not implement it globally here.
 * Thus, the current implementation will not implement draw here.
 *
 * @param <IOSWIDG>
 * @param <NWIDG>
 * @param <EVENT>
 * @param <CXT>
 */
public abstract class NativeDispatcher<IOSWIDG extends UIView, NWIDG extends NativeWrapper<CXT>, EVENT, CXT extends GraphicsContext> {

    private final WeakReference<WidgetWrapper<IOSWIDG, ? extends NWIDG, ? extends GraphicsContext>> wrapper;

    public NativeDispatcher(WidgetWrapper<IOSWIDG, ? extends NWIDG, ? extends GraphicsContext> holder) {
        this.wrapper = new WeakReference<WidgetWrapper<IOSWIDG, ? extends NWIDG, ? extends GraphicsContext>>(holder);
    }

    public WidgetWrapper<IOSWIDG, ? extends NWIDG, ? extends GraphicsContext> getWidgetWrapper() {
        return wrapper.get();
    }

    public abstract void setMetrics(int x, int y, int width, int height);

    public abstract void sendTouchEvents(EVENT originalEvent, NativeTouch[] touches);

    public abstract void draw(CXT cx);
}
