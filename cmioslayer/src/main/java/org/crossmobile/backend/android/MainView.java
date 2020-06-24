/*
 * (c) 2020 by Panayotis Katsaloulis
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
import android.widget.AbsoluteLayout;
import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.uikit.UIApplication;
import crossmobile.ios.uikit.UITouch;
import crossmobile.ios.uikit.UIWindow;
import org.crossmobile.bridge.Native;

import static android.view.MotionEvent.*;
import static crossmobile.ios.uikit.UserInterfaceDrill.*;
import static crossmobile.ios.uikit.UITouchPhase.*;

public class MainView extends AbsoluteLayout {

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
    @SuppressWarnings("null")
    public boolean dispatchTouchEvent(MotionEvent ev) {
        super.dispatchTouchEvent(ev);
        int phase;
        int pointer = -1;
        switch (ev.getAction() & MotionEvent.ACTION_MASK) {
            case ACTION_DOWN:
                phase = Began;
                break;
            case ACTION_MOVE:
                phase = Moved;
                break;
            case ACTION_UP:
                phase = Ended;
                break;
            case ACTION_CANCEL:
                phase = Cancelled;
                break;
            case ACTION_POINTER_DOWN:
                phase = Began;
                pointer = (ev.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >>> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
                break;
            case ACTION_POINTER_UP:
                phase = Ended;
                pointer = (ev.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >>> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
                break;
            default:
                phase = Stationary;
                break;
        }
        UIWindow window;
        if (UIApplication.sharedApplication() != null && (window = UIApplication.sharedApplication().keyWindow()) != null) {
            int pcount = ev.getPointerCount();
            UITouch[] touches = new UITouch[pcount];
            CGPoint[] touchLocations = phase == Began || phase == Moved ? new CGPoint[pcount] : null;
            for (int p = 0; p < pcount; p++) {
                touches[p] = newUITouch(ev.getX(p), ev.getY(p), p, window, pointer >= 0 && pointer != p ? Stationary : phase);
                if (touchLocations != null)
                    touchLocations[p] = touches[p].locationInView(null);
            }
            Native.graphics().metrics().setActiveTouchLocations(touchLocations);
            window.sendEvent(newUIEvent(touches, ev, phase));
            return true;
        }
        return false;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.save();
        drawWindow(Native.graphics().newGraphicsContext(canvas, true));
        canvas.restore();
        super.draw(canvas);     // Needed!!!!! or else native widgets will not function properly... It seems that "draw" method does more than what it says
    }

    @Override
    protected boolean fitSystemWindows(Rect insets) {
        if (!newAPI)
            ((AndroidDrawableMetrics) Native.graphics().metrics()).updateInsets(insets.top, insets.right, insets.bottom, insets.left);
        return super.fitSystemWindows(insets); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        if (newAPI)
            ((AndroidDrawableMetrics) Native.graphics().metrics()).updateInsets(insets.getSystemWindowInsetTop(),
                    insets.getSystemWindowInsetRight(),
                    insets.getSystemWindowInsetBottom(),
                    insets.getSystemWindowInsetLeft());
        return super.onApplyWindowInsets(insets); //To change body of generated methods, choose Tools | Templates.
    }
}
