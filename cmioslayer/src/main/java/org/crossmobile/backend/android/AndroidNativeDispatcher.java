/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import crossmobile.ios.uikit.UIView;
import org.crossmobile.backend.android.AndroidNativeDispatcher.AndroidNativeWidget;
import org.crossmobile.bind.graphics.GraphicsContext;
import org.crossmobile.bind.wrapper.NativeDispatcher;
import org.crossmobile.bind.wrapper.NativeTouch;
import org.crossmobile.bind.wrapper.NativeWrapper;
import org.crossmobile.bind.wrapper.WidgetWrapper;
import org.crossmobile.bridge.Native;

public class AndroidNativeDispatcher extends NativeDispatcher<UIView, AndroidNativeWidget, MotionEvent, AndroidGraphicsContext> {
    private int oldX = Integer.MIN_VALUE;
    private int oldY = Integer.MIN_VALUE;
    private int oldWidth = Integer.MIN_VALUE;
    private int oldHeight = Integer.MIN_VALUE;

    public AndroidNativeDispatcher(WidgetWrapper<UIView, AndroidNativeWidget, GraphicsContext<?>> holder) {
        super(holder);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void setMetrics(final int x, final int y, final int width, final int height) {
        if (x == oldX && y == oldY && width == oldWidth && height == oldHeight)
            return;
        oldX = x;
        oldY = y;
        oldWidth = width;
        oldHeight = height;
        Native.lifecycle().postOnEventThread(() -> getWidgetWrapper().getNativeWidget().setLayoutParams(new android.widget.AbsoluteLayout.LayoutParams(width, height, x, y)));
    }

    @Override
    public void sendTouchEvents(final MotionEvent original, final NativeTouch[] touches) {
//        if (original != null)
//            Native.lifecycle().runOnEventThread(new Runnable() {
//                @Override
//                public void run() {
//                    MotionEvent.PointerCoords coords[] = new MotionEvent.PointerCoords[touches.length];
//                    int ids[] = new int[touches.length];
//                    for (int i = 0; i < touches.length; i++) {
//                        MotionEvent.PointerCoords c = new MotionEvent.PointerCoords();
//                        c.orientation = 0;
//                        c.pressure = 1;
//                        c.size = 0.5;
//                        c.x = touches[i].x;
//                        c.y = touches[i].y;
//                        coords[i] = c;
//                        ids[i] = touches[i].id;
//                    }
//                    MotionEvent event = MotionEvent.obtain(original.getDownTime(), original.getEventTime(), original.getAction(), touches.length, ids, coords, original.getMetaState(), original.getXPrecision(), original.getYPrecision(), original.getDeviceId(), original.getEdgeFlags(), original.getSource(), original.getFlags());
//                    getWidgetWrapper().getNativeWidget().dispatchTouchEvent(original);
//                }
//            });
    }

    @Override
    public void draw(AndroidGraphicsContext cx) {
        AndroidNativeWidget view = getWidgetWrapper().getNativeWidget();
        int dx = view.getScrollX();
        int dy = view.getScrollY();
        cx.translate(-dx, -dy);
        view.superDraw(cx);
        cx.translate(dx, dy);
    }

    public interface AndroidNativeWidget extends NativeWrapper<AndroidGraphicsContext> {

        void setLayoutParams(LayoutParams layoutParams);

        void layout(int i, int i0, int i1, int i2);

        int getScrollX();

        int getScrollY();

        boolean dispatchTouchEvent(MotionEvent originalEvent);

        default ActivityLifecycleListener getLifecycleListener() {
            return null;
        }
    }

}
