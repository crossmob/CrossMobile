/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
public abstract class NativeDispatcher<IOSWIDG extends UIView, NWIDG extends NativeWrapper<CXT>, EVENT, CXT extends GraphicsContext<?>> {

    private final WeakReference<WidgetWrapper<IOSWIDG, ? extends NWIDG, ? extends GraphicsContext<?>>> wrapper;

    public NativeDispatcher(WidgetWrapper<IOSWIDG, ? extends NWIDG, ? extends GraphicsContext<?>> holder) {
        this.wrapper = new WeakReference<>(holder);
    }

    public WidgetWrapper<IOSWIDG, ? extends NWIDG, ? extends GraphicsContext<?>> getWidgetWrapper() {
        return wrapper.get();
    }

    public abstract void setMetrics(int x, int y, int width, int height);

    public abstract void sendTouchEvents(EVENT originalEvent, NativeTouch[] touches);

    public abstract void draw(CXT cx);
}
