/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics;

import crossmobile.ios.coregraphics.CGAffineTransform;
import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.coregraphics.CGSize;

public interface GraphicsContext<TRANSF> {

    void setAlpha(double alpha);

    void concatCTM(TRANSF transform);

    CGAffineTransform getCTM();

    void saveState();

    void restoreState();

    void drawBitmap(NativeBitmap image, int x, int y, int width, int height);

    void setFillColorWithColor(int color);

    void setDrawColorWithColor(int color);

    void clipToRect(CGRect frame);

    void translate(double tx, double ty);

    void rotate(double theta);

    void scale(double sx, double sy);

    void setFont(NativeFont font);

    CGSize stringSizeWithFont(String text, NativeFont font);

    void showTextAtPoint(double x, double y, String text);

    void setLineWidth(double width);

    void setLineJoin(int CGLineJoin);

    void setLineCap(int CGLineCap);

    void setAntialias(boolean shouldAntialias);

    void drawLine(double x1, double y1, double x2, double y2);

    void drawRect(double x, double y, double width, double heigh);

    void fillRect(double x, double y, double width, double height);

    void drawEllipse(double x, double y, double width, double height);

    void fillEllipse(double x, double y, double width, double height);

    void drawArc(double x, double y, double width, double height, double from, double extend);

    void fillArc(double x, double y, double width, double height, double from, double extend);

    void drawPath(NativePath path);

    void fillPath(NativePath path);

    void clip(NativePath path);

    void drawLinearGradient(int[] RGBcolors, double[] locations, double startPointX, double startPointY, double endPointX, double endPointY, int CGGradientDrawingOptions);

    void drawRadialGradient(int[] RGBcolors, double[] locations, double startCenterX, double startCenterY, double startRadius, double endCenterX, double endCenterY, double endRadius, int CGGradientDrawingOptions);

    default void drawRoundRodBar(double x, double y, double width, double height, int color) {
        setDrawColorWithColor(color);
        if (height < width) {
            double size = height;
            drawLine(x + size / 2, y, x + width - size / 2, y);
            drawLine(x + size / 2, y + height - 1, x + width - size / 2, y + height - 1);
            drawArc(x, y, size, size, GraphicsContext._PI_2, GraphicsContext._PI);
            drawArc(x + width - size, y, size, size, GraphicsContext._3_PI_2, GraphicsContext._PI);
        } else {
            double size = width;
            drawLine(x, y + size / 2, x, y + height - size / 2);
            drawLine(x + width - 1, y + size / 2, x + width - 1, y + height - size / 2);
            drawArc(x, y, size, size, 0, GraphicsContext._PI);
            drawArc(x, y + height - size, size, size, GraphicsContext._PI, GraphicsContext._PI);
        }
    }

    default void fillRoundRodBar(double x, double y, double width, double height, int color) {
        setFillColorWithColor(color);
        if (height < width) {
            double size = height;
            fillRect(x + size / 2, y, width - size, height);
            if ((color & 0xFF000000) == 0xFF000000) {
                // If it is a solid color, use ellipse since it is considerably faster
                fillEllipse(x, y, size, size);
                fillEllipse(x + width - size, y, size, size);
            } else {
                fillArc(x, y, size, size, GraphicsContext._PI_2, GraphicsContext._PI);
                fillArc(x + width - size, y, size, size, GraphicsContext._3_PI_2, GraphicsContext._PI);
            }
        } else {
            double size = width;
            fillRect(x, y + width / 2, width, height - width);
            if ((color & 0xFF000000) == 0xFF000000) {
                // If it is a solid color, use ellipse since it is considerably faster
                fillEllipse(x, y, size, size);
                fillEllipse(x, y + height - size, size, size);
            } else {
                fillArc(x, y, size, size, 0, GraphicsContext._PI);
                fillArc(x, y + height - size, size, size, GraphicsContext._PI, GraphicsContext._PI);
            }
        }
    }

    default void fillHalfRoundRodBar(double x, double y, double width, double height, int color, boolean isHorizontal, boolean roundIsLeftTop) {
        setFillColorWithColor(color);
        if (isHorizontal) {
            double diameter = height;
            if (roundIsLeftTop) {
                fillRect(x + diameter / 2, y, width - diameter / 2, height);
                fillArc(x, y, diameter, diameter, GraphicsContext._PI_2, GraphicsContext._PI);
            } else {
                fillRect(x, y, width - diameter / 2, height);
                fillArc(x + width - diameter, y, diameter, diameter, GraphicsContext._3_PI_2, GraphicsContext._PI);
            }
        } else {
            double diameter = width;
            if (roundIsLeftTop) {
                fillRect(x, y + diameter / 2, width, height - diameter / 2);
                fillArc(x, y, diameter, diameter, GraphicsContext._PI_2, GraphicsContext._PI);
            } else {
                fillRect(x, y, width, height - diameter / 2);
                fillArc(x, y + height - diameter, diameter, diameter, GraphicsContext._3_PI_2, GraphicsContext._PI);
            }
        }
    }

    /**
     * Check whether this is a live, fast refreshable context or not. For
     * example, screen context should be considered "live", while image context
     * should not.
     *
     * @return true, if it is a live context.
     */
    boolean isLiveContext();

    /**
     * Math constants
     */
    double _PI_2 = Math.PI / 2d;
    double _PI = Math.PI;
    double _3_PI_2 = 3d * Math.PI / 2d;
    double _2_PI = 2d * Math.PI;
    double PI_TO_DEG = 180d / Math.PI;

}
