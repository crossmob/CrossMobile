/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.uikit.UIColor;
import crossmobile.ios.uikit.UIImage;
import crossmobile.ios.uikit.UISwitch;
import org.crossmobile.bind.graphics.GraphicsContext;
import org.crossmobile.bridge.Native;

import static crossmobile.ios.coregraphics.GraphicsDrill.color;
import static crossmobile.ios.uikit.UserInterfaceDrill.cgcolor;

public class StyledSwitchPainter implements SwitchPainter {

    private final static String thumbImageName = "thumb_over";
    private final static int WIDTH = 78;
    private final static int HEIGHT = 28;
    private final static int INSET = 4;
    private final static int THUMB_COLOR = 0xFFF0F0F0;
    private final static int SHADOW_COLOR = 0xFFA0A0A0;
    private final static int TRACK_WIDTH = WIDTH - INSET - INSET;
    private final static int THUMB_SIZE = HEIGHT - INSET - INSET;
    private final static int TRACK_MOVING_AREA = TRACK_WIDTH - THUMB_SIZE;

    private final UIImage thumbImage = UIImage.imageWithContentsOfFile(Native.file().getSystemPrefix() + thumbImageName);
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
        gcx.drawRoundRodBar(x, y, WIDTH, HEIGHT, SHADOW_COLOR);

        // draw thumb
        int buttonLocation = (int) (x + INSET + sliderArea);
        thumbImage.drawInRect(new CGRect(buttonLocation, INSET, THUMB_SIZE, THUMB_SIZE));
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
