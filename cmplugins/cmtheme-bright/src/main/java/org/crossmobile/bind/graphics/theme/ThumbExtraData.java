/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.uikit.UIColor;
import org.crossmobile.bind.graphics.GraphicsContext;

import static crossmobile.ios.coregraphics.GraphicsDrill.color;
import static crossmobile.ios.uikit.UserInterfaceDrill.cgcolor;

class ThumbExtraData implements PainterExtraData {
    private static final int THUMB_COLOR = 0xFFFFFFFF;
    private static final int THUMB_SHADOW_COLOR = 0x80000000;
    static final int THUMB_SIZE = 24;

    boolean pressed;
    int thumbColorUp;
    int thumbColorDown;
    double location;

    void updateThumbColor(UIColor thumpColor) {
        this.thumbColorUp = thumpColor == null ? THUMB_COLOR : color(cgcolor(thumpColor));
        this.thumbColorDown = ThemeUtilities.pressedColor(this.thumbColorUp);
    }

    void paintThumb(GraphicsContext<?> gcx, double x, double y) {
        gcx.setFillColorWithColor(pressed ? thumbColorDown : thumbColorUp);
        gcx.fillEllipse(x, y, THUMB_SIZE, THUMB_SIZE);
        gcx.setLineWidth(2);
        gcx.setDrawColorWithColor(THUMB_SHADOW_COLOR);
        gcx.drawEllipse(x + 1, y + 1, THUMB_SIZE - 2, THUMB_SIZE - 2);
    }
}
