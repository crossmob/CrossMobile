/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.UIGuidelinesBridge;

public class AndroidUIGuidelinesBridge implements UIGuidelinesBridge {

    @Override
    public boolean shouldDisplayStatusBar() {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT;
    }

    @Override
    public boolean isTabBarOnTop() {
        return true;
    }

    @Override
    public void setStatusBarDark(boolean dark) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Native.lifecycle().runOnEventThread(() -> {
                Window window = MainActivity.current.getWindow();
                setStatusBarText(window, dark);
            });
        }
    }

    private void setStatusBarColor(Window window, int color) {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(color);
    }

    private void setStatusBarText(Window window, boolean dark) {
        int visibility = window.getDecorView().getSystemUiVisibility();
        if (dark) {
            visibility |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            visibility |= View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
        } else {
            visibility &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            visibility &= ~View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
        }
        window.getDecorView().setSystemUiVisibility(visibility);
    }

    public static void setTranslucentStatusBar() {
        Window window = MainActivity.current.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            // or this code, use both to be safe?
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }
}
