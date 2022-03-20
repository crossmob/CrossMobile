/*
 * (c) 2022 by Panayotis Katsaloulis
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
import static org.crossmobile.bind.graphics.theme.BrightUtilities.defaultContext;
import static org.crossmobile.bind.graphics.theme.ThumbExtraData.THUMB_SIZE;

public class BrightSwitchPainter implements SwitchPainter<ThumbExtraData> {

    private final static int WIDTH = 52;
    private final static int HEIGHT = 30;
    private final static int INSET = (HEIGHT - THUMB_SIZE) / 2;
    private final static int TRACK_WIDTH = WIDTH - INSET - INSET;
    private final static int TRACK_MOVING_AREA = TRACK_WIDTH - THUMB_SIZE;
    private final int offColor = color(cgcolor(UIColor.colorWithWhiteAlpha(1, 0.85)));

    @Override
    public void draw(UISwitch entity, CGRect rect, ThumbExtraData extraData) {
        GraphicsContext<?> gcx = defaultContext();
        double x = rect.getOrigin().getX();
        double y = rect.getOrigin().getY();
        int onColor = color(cgcolor(entity.onTintColor()));
        int sliderArea = (int) (TRACK_MOVING_AREA * extraData.location);

        gcx.fillRoundRodBar(x, y, WIDTH, HEIGHT, onColor);
        gcx.fillHalfRoundRodBar(sliderArea + INSET + THUMB_SIZE / 2d, y + INSET, TRACK_MOVING_AREA - sliderArea + THUMB_SIZE / 2d, THUMB_SIZE, offColor, true, false);

        // draw thumb
        int buttonLocation = (int) (x + INSET + sliderArea);
        gcx.setFillColorWithColor(extraData.pressed ? extraData.thumbColorDown : extraData.thumbColorUp);
        gcx.fillEllipse(buttonLocation, INSET, THUMB_SIZE, THUMB_SIZE);
        gcx.setLineWidth(2);
        gcx.setDrawColorWithColor(onColor);
        gcx.drawEllipse(buttonLocation, INSET + 0.5, THUMB_SIZE, THUMB_SIZE);
    }

    @Override
    public int getFixedWidth(UISwitch entity) {
        return WIDTH;
    }

    @Override
    public int getFixedHeight(UISwitch entity) {
        return HEIGHT;
    }

    @Override
    public void setThumbColor(UIColor thumpColor, ThumbExtraData extraData) {
        extraData.updateThumbColor(thumpColor);
    }

    @Override
    public void setPressed(boolean pressed, ThumbExtraData extraData) {
        extraData.pressed = pressed;
    }

    @Override
    public boolean setSliderLocation(double x, ThumbExtraData extraData) {
        double where = x - INSET - THUMB_SIZE / 2d;
        if (where < 0)
            where = 0;
        if (where > TRACK_MOVING_AREA)
            where = TRACK_MOVING_AREA;
        extraData.location = where / TRACK_MOVING_AREA;
        return extraData.location > 0.5;
    }

    @Override
    public void setValue(boolean status, ThumbExtraData extraData) {
        extraData.location = status ? 1 : 0;
    }

    @Override
    public ThumbExtraData initExtraData() {
        return new ThumbExtraData();
    }
}
