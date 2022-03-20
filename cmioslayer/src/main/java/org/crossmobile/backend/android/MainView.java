/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.WindowInsets;
import org.crossmobile.bridge.Native;

import java.util.concurrent.atomic.AtomicBoolean;

import static android.view.MotionEvent.*;
import static crossmobile.ios.uikit.UITouchPhase.*;
import static crossmobile.ios.uikit.UserInterfaceDrill.drawWindow;
import static crossmobile.ios.uikit.UserInterfaceDrill.fireUIEvent;

@SuppressWarnings("deprecation")
public class MainView extends android.widget.AbsoluteLayout {

    static MainView current;
    private final boolean newAPI = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;

    public MainView(Context context) {
        this(context, null);
    }

    public MainView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundDrawable(null);
        setFocusableInTouchMode(true);
        setClipChildren(false);
        setWillNotDraw(false);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        AtomicBoolean result = new AtomicBoolean(false);
        Native.lifecycle().encapsulateContext(() -> {
            super.dispatchTouchEvent(ev);
            int phase;
            switch (ev.getAction() & MotionEvent.ACTION_MASK) {
                case ACTION_DOWN:
                case ACTION_POINTER_DOWN:
                    phase = Began;
                    break;
                case ACTION_MOVE:
                    phase = Moved;
                    break;
                case ACTION_UP:
                case ACTION_POINTER_UP:
                    phase = Ended;
                    break;
                case ACTION_CANCEL:
                    phase = Cancelled;
                    break;
                default:
                    phase = Stationary;
                    break;
            }
            double[] x = new double[ev.getPointerCount()];
            double[] y = new double[x.length];
            for (int p = 0; p < x.length; p++) {
                x[p] = ev.getX(p);
                y[p] = ev.getY(p);
            }
            int pointer = (ev.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >>> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
            fireUIEvent(ev, x, y, pointer, phase);
            result.set(true);
        });
        return result.get();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void draw(Canvas canvas) {
        Native.lifecycle().encapsulateContext(() -> {
            canvas.save();
            drawWindow(Native.graphics().newGraphicsContext(canvas, true));
            canvas.restore();
            super.draw(canvas);     // Needed!!!!! or else native widgets will not function properly... It seems that "draw" method does more than what it says
        });
    }

    @Override
    @SuppressWarnings("deprecation")
    protected boolean fitSystemWindows(Rect insets) {
        if (!newAPI)
            ((AndroidDrawableMetrics) Native.graphics().metrics()).updateInsets(insets.top, insets.right, insets.bottom, insets.left);
        return super.fitSystemWindows(insets);
    }

    @Override
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        if (newAPI)
            ((AndroidDrawableMetrics) Native.graphics().metrics()).updateInsets(insets.getSystemWindowInsetTop(),
                    insets.getSystemWindowInsetRight(),
                    insets.getSystemWindowInsetBottom(),
                    insets.getSystemWindowInsetLeft());
        return super.onApplyWindowInsets(insets);
    }
}
