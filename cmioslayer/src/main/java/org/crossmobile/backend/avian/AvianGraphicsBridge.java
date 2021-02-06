/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.avian;

import crossmobile.ios.coregraphics.CGAffineTransform;
import org.crossmobile.backend.desktop.DesktopDrawableMetrics;
import org.crossmobile.backend.desktop.DesktopGraphicsBridge;
import org.crossmobile.backend.desktop.cgeo.CDrawable;
import org.crossmobile.bind.graphics.*;

import java.util.List;

public class AvianGraphicsBridge extends DesktopGraphicsBridge<AvianGraphicsContext, AvianTransformation> {

    @Override
    protected void resizeWindow(int width, int height) {
    }

    @Override
    public void draw(CDrawable drawable, GraphicsContext<?> cxt, int orientation) {
    }

    @Override
    protected void requestRepaint() {
    }

    @Override
    protected DrawableMetrics newMetrics() {
        return new DesktopDrawableMetrics();
    }

    @Override
    public GraphicsContext<AvianTransformation> newGraphicsContext(AvianGraphicsContext avianGraphicsContext, boolean isLive) {
        return new AvianGraphicsContext();
    }

    @Override
    public AvianGraphicsContext createCanvas(NativeBitmap bitmap) {
        return new AvianGraphicsContext();
    }

    @Override
    public void destroyCanvas(AvianGraphicsContext avianGraphicsContext) {
    }

    @Override
    public CGAffineTransform nativeToTarget(AvianTransformation from, CGAffineTransform to) {
        return null;
    }

    @Override
    public AvianTransformation targetToNative(CGAffineTransform from, AvianTransformation to) {
        return null;
    }

    @Override
    public int colorHSBAtoRGBA(double h, double s, double b, double a) {
        return 0;
    }

    @Override
    public double[] colorRGBAtoHSVA(int color) {
        return new double[4];
    }

    @Override
    public NativeFont getFont(String fontName, double size) {
        return new AvianFont(fontName, size);
    }

    @Override
    public NativePath newNativePath() {
        return new AvianPath();
    }

    @Override
    public String getBackChar() {
        return "<";
    }

    @Override
    public List<String> listFontFamilies() {
        return null;
    }

    @Override
    public List<String> listFont(String familyName) {
        return null;
    }
}
