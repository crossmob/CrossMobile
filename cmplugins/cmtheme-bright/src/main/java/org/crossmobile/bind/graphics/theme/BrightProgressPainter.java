/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.uikit.UIColor;
import crossmobile.ios.uikit.UIProgressView;
import crossmobile.ios.uikit.UIProgressViewStyle;
import org.crossmobile.bind.graphics.GraphicsContext;

import static crossmobile.ios.coregraphics.GraphicsDrill.color;
import static crossmobile.ios.uikit.UserInterfaceDrill.cgcolor;
import static org.crossmobile.bind.graphics.theme.BrightUtilities.defaultContext;

public class BrightProgressPainter implements ProgressPainter {

    @Override
    public void draw(UIProgressView progressView, CGRect rect) {
        GraphicsContext<?> gcx = defaultContext();
        boolean shouldDrawTrack = progressView.progressViewStyle() == crossmobile.ios.uikit.UIProgressViewStyle.Default;
        double x = rect.getOrigin().getX();
        double y = rect.getOrigin().getY();
        double width = rect.getSize().getWidth();
        int height = 3;

        if (width < height)
            //noinspection SuspiciousNameCombination
            width = height;

        double currentProgress = width * progressView.progress();
        if (currentProgress < height)
            currentProgress = height;

        if (shouldDrawTrack) {
            gcx.setFillColorWithColor(getColor(progressView, progressView.trackTintColor(), false));
            gcx.fillRect(x, y, width, height);
        }

        if (progressView.progress() > 0.001f) {
            gcx.setFillColorWithColor(getColor(progressView, progressView.progressTintColor(), true));
            gcx.fillRect(x, y, currentProgress, height);
        }
    }

    private int getColor(UIProgressView view, UIColor color, boolean foreground) {
        if (color != null)
            return color(cgcolor(color));
        if (view.progressViewStyle() == UIProgressViewStyle.Bar)
            foreground = !foreground;
        if (foreground)
            return color(cgcolor(view.tintColor()));
        else
            return ThemeUtilities.getControlColor();
    }
}
