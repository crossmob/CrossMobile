/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.coregraphics.CGColor;
import crossmobile.ios.coregraphics.CGContext;
import crossmobile.ios.coregraphics.CGPathDrawingMode;
import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.uikit.UIButton;
import crossmobile.ios.uikit.UIGraphics;
import crossmobile.ios.uikit.UIImage;

import static crossmobile.ios.uikit.UserInterfaceDrill.cgcolor;

public class BrightSegmentedPainter implements SegmentedPainter<BrightSegmentedPainter.BrightSegmentedExtraData> {

    private static final int FIRST_SEGMENT = -1;
    private static final int MIDDLE_SEGMENT = 0;
    private static final int LAST_SEGMENT = 1;

    @Override
    public void draw(UIButton segment, CGRect rect, BrightSegmentedExtraData extraData) {
        boolean isFirst = extraData.value == FIRST_SEGMENT;
        boolean isLast = extraData.value == LAST_SEGMENT;

        CGColor tintColor = cgcolor(segment.tintColor());
        CGContext cx = UIGraphics.getCurrentContext();
        cx.beginPath();
        double x = rect.getOrigin().getX();
        double y = rect.getOrigin().getY();
        double width = rect.getSize().getWidth();
        double height = rect.getSize().getHeight();
        if (isFirst) {
            // Left
            cx.moveToPoint(x + 4, y);
            cx.addLineToPoint(x + width, y);
            cx.addLineToPoint(x + width, y + height);
            cx.addLineToPoint(x + 4, y + height);
            cx.addCurveToPoint(x + 3, y + height - 1, x + 1, y + height - 3, x, y + height - 4);
            cx.addLineToPoint(x, y + 4);
            cx.addCurveToPoint(x + 1, y + 3, x + 3, y + 1, x + 4, y);
        } else if (isLast) {
            // Right
            cx.moveToPoint(x, y);
            cx.addLineToPoint(x + width - 4, y);
            cx.addCurveToPoint(x + width - 3, y + 1, x + width - 1, y + 3, x + width, y + 4);
            cx.addLineToPoint(x + width, y + height - 4);
            cx.addCurveToPoint(x + width - 1, y + height - 3, x + width - 3, y + height - 1, x + width - 4, y + height);
            cx.addLineToPoint(x, y + height);
        } else {
            // Central
            cx.moveToPoint(x, y);
            cx.addLineToPoint(x + width, y);
            cx.addLineToPoint(x + width, y + height);
            cx.addLineToPoint(x, y + height);
        }
        cx.closePath();
        cx.setLineWidth(1);
        cx.setFillColorWithColor(tintColor);
        cx.drawPath(segment.isSelected() || segment.isHighlighted()
                ? CGPathDrawingMode.FillStroke
                : CGPathDrawingMode.Stroke);
        if (extraData.image != null)
            extraData.image.drawInRect(new CGRect(0, 0, width, height));

    }

    @Override
    public BrightSegmentedExtraData initExtraData() {
        return new BrightSegmentedExtraData();
    }

    @Override
    public void setAsFirstSegment(BrightSegmentedExtraData extraData) {
        extraData.value = FIRST_SEGMENT;
    }

    @Override
    public void setAsMiddleSegment(BrightSegmentedExtraData extraData) {
        extraData.value = MIDDLE_SEGMENT;
    }

    @Override
    public void setAsLastSegment(BrightSegmentedExtraData extraData) {
        extraData.value = LAST_SEGMENT;
    }

    @Override
    public void setSegmentImage(UIImage segmentImage, BrightSegmentedExtraData extraData) {
        extraData.image = segmentImage;
    }

    static class BrightSegmentedExtraData implements PainterExtraData {
        private int value;
        private UIImage image;
    }
}

