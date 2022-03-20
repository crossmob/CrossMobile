/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import crossmobile.ios.uikit.UITextField;
import crossmobile.ios.uikit.UITextView;
import org.crossmobile.backend.android.AndroidNativeDispatcher.AndroidNativeWidget;
import org.crossmobile.bind.wrapper.NativeDispatcher;
import org.crossmobile.bind.wrapper.WidgetWrapper;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.WrapperUIBridge;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class AndroidWrapperUIBridge implements WrapperUIBridge<View> {

    private final Runnable resignFocus = () -> MainView.current.requestFocus();

    @Override
    public AndroidTextWrapper textField(UITextField parent) {
        return new AndroidTextWrapper(parent);
    }

    @Override
    public AndroidTextWrapper textView(UITextView parent) {
        return new AndroidTextWrapper(parent);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public NativeDispatcher newNativeDispatcher(WidgetWrapper nw) {
        return new AndroidNativeDispatcher(nw);
    }

    @Override
    public void resignFocus() {
        Native.lifecycle().runOnEventThread(resignFocus);
        ((InputMethodManager) MainActivity.current.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(MainView.current.getWindowToken(), 0);
    }

    @Override
    public void requestFocus(final View nativeWidget) {
        Native.lifecycle().runOnEventThread(() -> {
            nativeWidget.requestFocus();
            ((InputMethodManager) MainActivity.current.getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(nativeWidget, 0);
        });
    }

    @Override
    public void setAttached(final View view, final boolean isAttached) {
        Native.lifecycle().runOnEventThread(() -> {
            ViewParent parent = view.getParent();
            boolean isAttachedNow = parent != null;
            if (isAttached == isAttachedNow)
                return;
            ActivityLifecycleListener listener = ((AndroidNativeWidget) view).getLifecycleListener();
            if (isAttachedNow) {
                MainView.current.removeView(view);
                if (listener != null) {
                    MainActivity.current.getStateListener().unregister(listener);
                    listener.onPause();
                    listener.onDestroy();
                }
            } else {
                MainView.current.addView(view);
                if (listener != null) {
                    MainActivity.current.getStateListener().register(listener);
                    listener.onCreate(MainActivity.current.getInstanceState());
                    listener.onResume();
                }
            }
//                AndroidGraphicsBridge.mainview.bringToFront();
        });
    }

    @Override
    public void updateNativeGraphics(final String button_up, final String button_down) {
        Drawable d = new Button(MainActivity.current).getBackground();
        try {
            d.setState(new int[]{android.R.attr.state_window_focused, android.R.attr.state_enabled, android.R.attr.state_multiline});
        } catch (Exception e) {
            d.setState(new int[]{android.R.attr.state_window_focused, android.R.attr.state_enabled});
        }
        buttonDraw(d, button_up);
        try {
            d.setState(new int[]{android.R.attr.state_window_focused, android.R.attr.state_enabled, android.R.attr.state_multiline, android.R.attr.state_pressed});
        } catch (Exception ex) {
            d.setState(new int[]{android.R.attr.state_window_focused, android.R.attr.state_enabled, android.R.attr.state_pressed});
        }
        buttonDraw(d, button_down);
    }

    private static void buttonDraw(Drawable d, String outfile) {
        int width = d.getIntrinsicWidth();
        int height = d.getIntrinsicHeight();
        Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas cvs = new Canvas(bmp);
        d.setBounds(0, 0, width, height);
        d.draw(cvs);
        try {
            bmp.compress(Bitmap.CompressFormat.PNG, 1, new FileOutputStream(outfile));
        } catch (FileNotFoundException ex) {
            Native.system().error("Unable to store button image", ex);
        }
    }
}
