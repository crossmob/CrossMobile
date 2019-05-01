/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.crossmobile.backend.android;

import android.os.Build;
import android.view.View;
import android.view.Window;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.UIGuidelinesBridge;

public class AndroidUIGuidelinesBridge implements UIGuidelinesBridge {

    @Override
    public boolean shouldDisplayStatusBar() {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT;
    }

    @Override
    public boolean isTabbarOnTop() {
        return true;
    }

    @Override
    public void setStatusBarDark(boolean dark) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Native.system().postOnEventThread(() -> {
                Window window = MainActivity.current.getWindow();
                // Doesn't work
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.MAGENTA);
                int visibility = window.getDecorView().getSystemUiVisibility();
                if (dark)
                    visibility |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                else
                    visibility &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                window.getDecorView().setSystemUiVisibility(visibility);
            });
        }
    }
}
