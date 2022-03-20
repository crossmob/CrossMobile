/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.coregraphics.CGSize;
import crossmobile.ios.uikit.UIPageControl;
import org.crossmobile.bind.graphics.GraphicsContext;

import static crossmobile.ios.coregraphics.GraphicsDrill.color;
import static crossmobile.ios.uikit.UserInterfaceDrill.cgcolor;
import static org.crossmobile.bind.graphics.theme.BrightUtilities.defaultContext;

public class BrightPageControlPainter implements PageControlPainter {
    private static final int CYCLE_DIAMETER = 6;
    private static final int CYCLE_DISTANCE = 10;

    @Override
    public void draw(UIPageControl entity, CGRect rect) {
        GraphicsContext<?> gcx = defaultContext();
        int numberOfPages = entity.numberOfPages();
        int currentPage = entity.currentPage();
        CGSize size = entity.sizeForNumberOfPages(numberOfPages);
        double xDelta = (rect.getSize().getWidth() - size.getWidth()) / 2d + CYCLE_DISTANCE / 2d;
        double yDelta = (rect.getSize().getHeight() - size.getHeight()) / 2d;
        for (int i = 0; i < numberOfPages; i++) {
            if (i == currentPage)
                gcx.setFillColorWithColor(color(cgcolor(entity.currentPageIndicatorTintColor())));
            else
                gcx.setFillColorWithColor(color(cgcolor(entity.pageIndicatorTintColor())));
            gcx.fillEllipse(xDelta + i * (CYCLE_DIAMETER + CYCLE_DISTANCE), yDelta, CYCLE_DIAMETER, CYCLE_DIAMETER);
        }
    }

    @Override
    public CGSize sizeForNumberOfPages(int pageCount) {
        return new CGSize(pageCount * (CYCLE_DIAMETER + CYCLE_DISTANCE), CYCLE_DIAMETER);
    }
}
