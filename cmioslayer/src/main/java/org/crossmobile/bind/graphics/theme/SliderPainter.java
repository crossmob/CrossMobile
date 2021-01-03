/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.uikit.UISlider;

public interface SliderPainter extends ThemePainter<UISlider, SliderPainter.SliderExtraData> {
    int getThumbSize();

    int getThumbColorUp();

    int getThumbColorDown(int colorUp);

    final class SliderExtraData {
        public boolean isDown;
        public int thumbColorUp;
        public int thumbColorDown;
    }
}
