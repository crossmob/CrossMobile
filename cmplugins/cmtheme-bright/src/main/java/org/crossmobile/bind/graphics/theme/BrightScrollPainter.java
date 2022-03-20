/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.coregraphics.CGSize;
import crossmobile.ios.uikit.UIEdgeInsets;
import crossmobile.ios.uikit.UIScrollView;
import org.crossmobile.bind.graphics.GraphicsContext;

import static crossmobile.ios.uikit.UserInterfaceDrill.*;

public class BrightScrollPainter implements ScrollPainter<BrightScrollExtraData> {

    private final static int INDICATOR_THICKNESS = 8;
    private final static int INDICATOR_INSET = 2;

    @Override
    public void draw(UIScrollView entity, CGRect rect, BrightScrollExtraData extraData) {
        boolean isFullyDrawn = entity.isDragging() || entity.isTracking() || entity.isDecelerating();
        if (!(isFullyDrawn || extraData.flashing))
            return;

        // Access to private & original (for optimization reasons) data
        GraphicsContext<?> ctx = BrightUtilities.defaultContext();
        CGRect frame = frame(entity);
        CGSize contentSize = contentSize(entity);
        UIEdgeInsets contentInset = contentInset(entity);
        UIEdgeInsets scrollIndicatorInsets = scrollIndicatorInsets(entity);
        CGPoint contentOffset = contentOffset(entity);

        double width = frame.getSize().getWidth();
        double height = frame.getSize().getHeight();

        boolean willShowHorizontal = entity.showsHorizontalScrollIndicator() && (contentSize.getWidth() + contentInset.getLeft() + contentInset.getRight()) > width;
        boolean willShowVertical = entity.showsVerticalScrollIndicator() && (contentSize.getHeight() + contentInset.getTop() + contentInset.getBottom()) > height;
        double guiWidth = rect.getSize().getWidth()
                - scrollIndicatorInsets.getLeft()
                - scrollIndicatorInsets.getRight()
                - INDICATOR_INSET - INDICATOR_INSET
                - (willShowVertical ? INDICATOR_THICKNESS : 0);
        double guiHeight = rect.getSize().getHeight()
                - scrollIndicatorInsets.getTop()
                - scrollIndicatorInsets.getBottom()
                - INDICATOR_INSET - INDICATOR_INSET
                - (willShowHorizontal ? INDICATOR_THICKNESS : 0);
        if (guiWidth >= INDICATOR_THICKNESS && guiHeight >= INDICATOR_THICKNESS) {
            double c_alpha = isFullyDrawn ? 1 : extraData.flashAlpha;
            int fillColor = (int) (0xFF * c_alpha * 0.25) << 24;
            int drawColor = ((int) (0xFF * c_alpha) << 24);
            if (willShowHorizontal) {
                double offsetCorrection = contentOffset.getX() < 0 ? -contentOffset.getX() : 0; // too small offset
                double sizeCorrection = Math.max((contentSize.getWidth() + contentInset.getLeft() + contentInset.getRight()), contentOffset.getX() + width);  // too big offset
                double size = guiWidth * width / (sizeCorrection + offsetCorrection);
                double offset = guiWidth * (contentOffset.getX() + offsetCorrection) / (sizeCorrection + offsetCorrection);
                if (size < INDICATOR_THICKNESS)
                    size = INDICATOR_THICKNESS;
                if (offset + size > guiWidth)
                    offset = guiWidth - size;

                double x = rect.getOrigin().getX() + scrollIndicatorInsets.getLeft() + INDICATOR_INSET + offset;
                double y = rect.getOrigin().getY() + rect.getSize().getHeight() - scrollIndicatorInsets.getBottom() - INDICATOR_THICKNESS - INDICATOR_INSET;
                ctx.fillRoundRodBar(x, y, size, INDICATOR_THICKNESS, fillColor);
                ctx.drawRoundRodBar(x, y, size, INDICATOR_THICKNESS, drawColor);
            }
            if (willShowVertical) {
                double offsetCorrection = contentOffset.getY() < 0 ? -contentOffset.getY() : 0;
                double sizeCorrection = Math.max((contentSize.getHeight() + contentInset.getTop() + contentInset.getBottom()), contentOffset.getY() + height);
                double size = guiHeight * height / (sizeCorrection + offsetCorrection);
                double offset = guiHeight * (contentOffset.getY() + offsetCorrection) / (sizeCorrection + offsetCorrection);
                if (size < INDICATOR_THICKNESS)
                    size = INDICATOR_THICKNESS;
                if (offset + size > guiHeight)
                    offset = guiHeight - size;

                double x = rect.getOrigin().getX() + rect.getSize().getWidth() - scrollIndicatorInsets.getRight() - INDICATOR_THICKNESS - INDICATOR_INSET;
                double y = rect.getOrigin().getY() + scrollIndicatorInsets.getTop() + INDICATOR_INSET + offset;
                ctx.fillRoundRodBar(x, y, INDICATOR_THICKNESS, size, fillColor);
                ctx.drawRoundRodBar(x, y, INDICATOR_THICKNESS, size, drawColor);
            }
        }
    }

    @Override
    public BrightScrollExtraData initExtraData() {
        return new BrightScrollExtraData();
    }

    @Override
    public void startFlashing(BrightScrollExtraData extraData) {
        extraData.flashing = true;
        extraData.flashAlpha = 1;
    }

    @Override
    public void endFlashing(BrightScrollExtraData extraData) {
        extraData.flashing = false;
    }

    @Override
    public void setFlashPercent(double progress, BrightScrollExtraData extraData) {
        extraData.flashAlpha = 1 - progress;
    }
}
