/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.avian;

import crossmobile.ios.coregraphics.CGAffineTransform;
import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.coregraphics.CGSize;
import org.crossmobile.bind.graphics.GraphicsContext;
import org.crossmobile.bind.graphics.NativeBitmap;
import org.crossmobile.bind.graphics.NativeFont;
import org.crossmobile.bind.graphics.NativePath;

public class AvianGraphicsContext implements GraphicsContext<AvianTransformation> {

    @Override
    public void setAlpha(double alpha) {
    }

    @Override
    public void concatCTM(AvianTransformation transform) {
    }

    @Override
    public CGAffineTransform getCTM() {
        return CGAffineTransform.identity();
    }

    @Override
    public void saveState() {
    }

    @Override
    public void restoreState() {
    }

    @Override
    public void drawBitmap(NativeBitmap image, int x, int y, int width, int height) {
    }

    @Override
    public void setFillColorWithColor(int color) {
    }

    @Override
    public void setDrawColorWithColor(int color) {
    }

    @Override
    public void clipToRect(CGRect frame) {
    }

    @Override
    public void translate(double tx, double ty) {
    }

    @Override
    public void rotate(double theta) {
    }

    @Override
    public void scale(double sx, double sy) {
    }

    @Override
    public void setFont(NativeFont font) {
    }

    @Override
    public CGSize stringSizeWithFont(String text, NativeFont font) {
        return new CGSize(0, 0);
    }

    @Override
    public void showTextAtPoint(double x, double y, String text) {
    }

    @Override
    public void setLineWidth(double width) {
    }

    @Override
    public void setLineJoin(int CGLineJoin) {
    }

    @Override
    public void setLineCap(int CGLineCap) {
    }

    @Override
    public void setAntialias(boolean shouldAntialias) {
    }

    @Override
    public void drawLine(double x1, double y1, double x2, double y2) {
    }

    @Override
    public void drawRect(double x, double y, double width, double heigh) {
    }

    @Override
    public void fillRect(double x, double y, double width, double height) {
    }

    @Override
    public void drawEllipse(double x, double y, double width, double height) {
    }

    @Override
    public void fillEllipse(double x, double y, double width, double height) {
    }

    @Override
    public void drawArc(double x, double y, double width, double height, double from, double extend) {
    }

    @Override
    public void fillArc(double x, double y, double width, double height, double from, double extend) {
    }

    @Override
    public void drawPath(NativePath path) {
    }

    @Override
    public void fillPath(NativePath path) {
    }

    @Override
    public void clip(NativePath path) {
    }

    @Override
    public void drawLinearGradient(int[] RGBcolors, double[] locations, double startPointX, double startPointY, double endPointX, double endPointY, int CGGradientDrawingOptions) {
    }

    @Override
    public void drawRadialGradient(int[] RGBcolors, double[] locations, double startCenterX, double startCenterY, double startRadius, double endCenterX, double endCenterY, double endRadius, int CGGradientDrawingOptions) {
    }

    @Override
    public boolean isLiveContext() {
        return false;
    }

    private static native void test();
}
