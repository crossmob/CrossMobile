/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.uikit.UIColor;
import crossmobile.ios.uikit.UISwitch;
import org.crossmobile.bind.graphics.GraphicsContext;

import static crossmobile.ios.coregraphics.GraphicsDrill.color;
import static crossmobile.ios.uikit.UserInterfaceDrill.cgcolor;

public class BrightSwitchPainter implements SwitchPainter {

    private final static int WIDTH = 52;
    private final static int HEIGHT = 30;
    private final static int INSET = 3;
    private final static int TRACK_WIDTH = WIDTH - INSET - INSET;
    private final static int THUMB_SIZE = HEIGHT - INSET - INSET;
    private final static int TRACK_MOVING_AREA = TRACK_WIDTH - THUMB_SIZE;
    private final static int THUMB_COLOR = 0xFFFFFFFF;
    private final int offColor = color(cgcolor(UIColor.colorWithWhiteAlpha(1, 0.85)));

    @Override
    public double getSliderLocation(double x) {
        double where = x - INSET - THUMB_SIZE / 2d;
        if (where < 0)
            where = 0;
        if (where > TRACK_MOVING_AREA)
            where = TRACK_MOVING_AREA;
        return where / TRACK_MOVING_AREA;
    }

    @Override
    public void draw(UISwitch entity, CGRect rect, GraphicsContext<?> gcx, SwitchExtraData extraData) {
        double x = rect.getOrigin().getX();
        double y = rect.getOrigin().getY();
        int onColor = color(cgcolor(entity.onTintColor()));
        int sliderArea = (int) (TRACK_MOVING_AREA * extraData.sliderLoc);

        gcx.fillRoundRodBar(x, y, WIDTH, HEIGHT, onColor);
        gcx.fillHalfRoundRodBar(sliderArea + INSET + THUMB_SIZE / 2d, y + INSET, TRACK_MOVING_AREA - sliderArea + THUMB_SIZE / 2d, THUMB_SIZE, offColor, true, false);

        // draw thumb
        int buttonLocation = (int) (x + INSET + sliderArea);
        gcx.setFillColorWithColor(extraData.isDown ? extraData.thumbColorDown : extraData.thumbColorUp);
        gcx.fillEllipse(buttonLocation, INSET, THUMB_SIZE, THUMB_SIZE);
        gcx.setLineWidth(2);
        gcx.setDrawColorWithColor(onColor);
        gcx.drawEllipse(buttonLocation, INSET + 0.5, THUMB_SIZE, THUMB_SIZE);
    }

    @Override
    public int getFixedWidth() {
        return WIDTH;
    }

    @Override
    public int getFixedHeight() {
        return HEIGHT;
    }

    @Override
    public int getThumbColorUp() {
        return THUMB_COLOR;
    }

    @Override
    public int getThumbColorDown(int colorUp) {
        return ThemeUtilities.pressedColor(colorUp);
    }
}
