/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.uikit.UIColor;
import crossmobile.ios.uikit.UISlider;
import org.crossmobile.bind.graphics.GraphicsContext;

import static crossmobile.ios.coregraphics.GraphicsDrill.color;
import static crossmobile.ios.uikit.UserInterfaceDrill.cgcolor;
import static org.crossmobile.bind.graphics.theme.BrightUtilities.defaultContext;
import static org.crossmobile.bind.graphics.theme.ThumbExtraData.THUMB_SIZE;

public class BrightSliderPainter implements SliderPainter<ThumbExtraData> {

    private final static int YSIZE = 2;
    private final static int DY = (THUMB_SIZE - YSIZE) / 2;

    @Override
    public void draw(UISlider slider, CGRect rect, ThumbExtraData extraData) {
        GraphicsContext<?> gcx = defaultContext();
        double x = rect.getOrigin().getX();
        double y = rect.getOrigin().getY();
        double width = rect.getSize().getWidth();

        double trackMovingArea = width - THUMB_SIZE;
        double percent = slider.value() / (slider.maximumValue() - slider.minimumValue());
        double trackLeft = trackMovingArea * percent;

        gcx.setFillColorWithColor(color(cgcolor(slider.minimumTrackTintColor())));
        gcx.fillRect(x + THUMB_SIZE / 2d, DY + y, trackLeft, YSIZE);
        gcx.setFillColorWithColor(color(cgcolor(slider.maximumTrackTintColor())));
        gcx.fillRect(x + THUMB_SIZE / 2d + trackLeft, DY + y, trackMovingArea - trackLeft, YSIZE);

        extraData.paintThumb(gcx, x + trackLeft, y);
    }

    @Override
    public int getFixedWidth(UISlider entity) {
        return 0;
    }

    @Override
    public int getFixedHeight(UISlider entity) {
        return THUMB_SIZE;
    }

    @Override
    public double setSliderLocation(double x, double width, ThumbExtraData extraData) {
        double where = x - THUMB_SIZE / 2f;
        double trackMovingArea = width - THUMB_SIZE;
        if (where < 0)
            where = 0;
        if (where > trackMovingArea)
            where = trackMovingArea;
        where /= trackMovingArea;
        return where;
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
    public ThumbExtraData initExtraData() {
        return new ThumbExtraData();
    }
}
