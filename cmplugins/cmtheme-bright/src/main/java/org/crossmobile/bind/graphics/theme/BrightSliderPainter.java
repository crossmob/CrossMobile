/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.uikit.UISlider;
import org.crossmobile.bind.graphics.GraphicsContext;

import static crossmobile.ios.coregraphics.GraphicsDrill.color;
import static crossmobile.ios.uikit.UserInterfaceDrill.cgcolor;

public class BrightSliderPainter implements SliderPainter {

    private final static int THUMB_SIZE = 24;
    private final static int THUMB_SHADOW_COLOR = 0x80000000;
    private final static int THUMB_COLOR = 0xFFFFFFFF;
    private final static int YSIZE = 2;
    private final static int DY = (THUMB_SIZE - YSIZE) / 2;

    @Override
    public void draw(UISlider slider, CGRect rect, GraphicsContext<?> gcx, SliderExtraData extraData) {
        double x = rect.getOrigin().getX();
        double y = rect.getOrigin().getY();
        double width = rect.getSize().getWidth();

        double trackMovingArea = width - THUMB_SIZE;
        double percent = slider.value() / (slider.maximumValue() - slider.minimumValue());
        double trackLeft = trackMovingArea * percent;

        gcx.setFillColorWithColor(color(cgcolor(slider.minimumTrackTintColor())));
        gcx.fillRect(x + THUMB_SIZE / 2d, DY, trackLeft, YSIZE);
        gcx.setFillColorWithColor(color(cgcolor(slider.maximumTrackTintColor())));
        gcx.fillRect(x + THUMB_SIZE / 2d + trackLeft, DY, trackMovingArea - trackLeft, YSIZE);

        gcx.setFillColorWithColor(extraData.isDown ? extraData.thumbColorDown : extraData.thumbColorUp);
        gcx.fillEllipse(x + trackLeft, 0, THUMB_SIZE, THUMB_SIZE);
        gcx.setLineWidth(2);
        gcx.setDrawColorWithColor(THUMB_SHADOW_COLOR);
        gcx.drawEllipse(x + trackLeft + 1, 1, THUMB_SIZE - 2, THUMB_SIZE - 2);
    }

    @Override
    public int getFixedWidth() {
        return 0;
    }

    @Override
    public int getFixedHeight() {
        return THUMB_SIZE;
    }

    @Override
    public int getThumbSize() {
        return THUMB_SIZE;
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
