/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.coregraphics.GraphicsDrill;
import crossmobile.ios.uikit.UIActivityIndicatorView;
import org.crossmobile.bind.graphics.GraphicsContext;

import static crossmobile.ios.uikit.UserInterfaceDrill.cgcolor;

public class BrightActivityIndicatorPainter implements ActivityIndicatorPainter<IntExtraData> {
    private static final int WIDTH_LARGE = 37;
    private static final int WIDTH_SMALL = 20;
    private static final int THICK = 5;
    private static final int THIN = 2;
    private static final int SLICES = 9;

    private static final int ALPHA_SAFE = 4;
    private static final double ANGLE = 0.1;

    @Override
    public void draw(UIActivityIndicatorView entity, CGRect rect, IntExtraData metaData) {
        GraphicsContext<?> gcx = BrightUtilities.defaultContext();
        int baseColor = GraphicsDrill.color(cgcolor(entity.color())) & 0xFFFFFF;
        double fullRadius, height;
        if (isBig(entity)) {
            fullRadius = WIDTH_LARGE / 2d;
            height = THICK;
        } else {
            fullRadius = WIDTH_SMALL / 2d;
            height = THIN;
        }

        double rest = 1 / 4d;
        double centerX = rect.getOrigin().getX() + rect.getSize().getWidth() / 2;
        double centerY = rect.getOrigin().getY() + rect.getSize().getHeight() / 2;
        double radius = (rest + 1) * fullRadius / 2;
        double length = (1 - rest) * fullRadius;
        for (int i = 0; i < SLICES; i++) {
            baseColor = baseColor | (((i + ALPHA_SAFE) * 255 / (SLICES + ALPHA_SAFE - 1)) << 24);
            double angle = (2 * Math.PI) * (i + metaData.value) / SLICES % (Math.PI * 2);
            double dx = centerX + (radius * Math.cos(angle));
            double dy = centerY + (radius * Math.sin(angle));
            angle += ANGLE;
            gcx.translate(dx, dy);
            gcx.rotate(angle);
            gcx.fillRoundRodBar(-length / 2, -height / 2, length, height, baseColor);
            gcx.rotate(-angle);
            gcx.translate(-dx, -dy);
        }
    }

    @Override
    public IntExtraData initExtraData() {
        return new IntExtraData();
    }

    @Override
    public void setAnimationFrame(int frame, IntExtraData extraData) {
        extraData.value = frame;
    }

    @Override
    public double getAnimationFrameDuration() {
        return 0.1;
    }

    @Override
    public int getMaximumFrame() {
        return SLICES;
    }

    @Override
    public int getFixedWidth(UIActivityIndicatorView view) {
        return isBig(view) ? WIDTH_LARGE : WIDTH_SMALL;
    }

    @Override
    public int getFixedHeight(UIActivityIndicatorView view) {
        return isBig(view) ? WIDTH_LARGE : WIDTH_SMALL;
    }

    private boolean isBig(UIActivityIndicatorView view) {
        return view.activityIndicatorViewStyle() == crossmobile.ios.uikit.UIActivityIndicatorViewStyle.WhiteLarge;
    }
}
