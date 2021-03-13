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

import java.util.Collections;
import java.util.List;

public class AvianGraphicsBridge extends DesktopGraphicsBridge<SkCanvas, SkMatrix> {
    public static SDLWindow window;

    static {
        initSDL();
    }

    @Override
    protected void resizeWindow(int width, int height) {
        window.setSize(width, height);
    }

    @Override
    // TODO: rethink if this is a Swing-only feature
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
    public GraphicsContext<SkMatrix> newGraphicsContext(SkCanvas avianGraphicsContext, boolean isLive) {
        return avianGraphicsContext == null ? new SkCanvas(AvianGraphicsBridge.window) : avianGraphicsContext;
    }

    @Override
    public SkCanvas createCanvas(NativeBitmap bitmap) {
        return new SkCanvas(null);
    }

    @Override
    @SuppressWarnings("FinalizeCalledExplicitly")
    public void destroyCanvas(SkCanvas avianGraphicsContext) {
        avianGraphicsContext.finalize();
    }

    @Override
    public CGAffineTransform nativeToTarget(SkMatrix from, CGAffineTransform to) {
        return CGAffineTransform.identity();
    }

    @Override
    public SkMatrix targetToNative(CGAffineTransform from, SkMatrix to) {
        return new SkMatrix();
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
        return new SkFont(fontName, size);
    }

    @Override
    public NativePath newNativePath() {
        return new SkPath();
    }

    @Override
    public String getBackChar() {
        return "<";
    }

    @Override
    public List<String> listFontFamilies() {
        return Collections.emptyList();
    }

    @Override
    public List<String> listFont(String familyName) {
        return Collections.emptyList();
    }

    private static native boolean initSDL();

    static native void quitSDL();

    static native SDLEvent pollSDLEvents();

}
