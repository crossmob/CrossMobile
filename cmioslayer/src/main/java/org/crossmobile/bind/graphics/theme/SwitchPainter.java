/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.uikit.UISwitch;

public interface SwitchPainter extends ThemePainter<UISwitch, SwitchPainter.SwitchExtraData> {
    double getSliderLocation(double x);

    int getThumbColorUp();

    int getThumbColorDown(int colorUp);

    final class SwitchExtraData {
        public double sliderLoc;
        public boolean isDown;
        public int thumbColorUp;
        public int thumbColorDown;
    }
}
