/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.avian;

import crossmobile.ios.coregraphics.CGAffineTransform;
import org.crossmobile.backend.avian.event.AvianEvent;
import org.crossmobile.backend.desktop.DesktopDrawableMetrics;
import org.crossmobile.backend.desktop.DesktopGraphicsBridge;
import org.crossmobile.backend.desktop.cgeo.CDrawable;
import org.crossmobile.bind.graphics.*;
import org.crossmobile.bind.system.Debug;

import java.util.Collections;
import java.util.List;

import static crossmobile.ios.uikit.UserInterfaceDrill.drawWindow;

public class AvianGraphicsBridge extends DesktopGraphicsBridge<SkCanvas, SkMatrix> {
    private SDLWindow window;
    private boolean requestRepaint;
    private boolean requestWindowUpdate;

    static {
        setDebugLevel(Debug.Full_Debug ? 1 : 0);
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
        requestRepaint = true;
    }

    void requestWindowUpdate() {
        requestWindowUpdate = true;
    }

    void initWindow(String title) {
        if (window == null)
            window = new SDLWindow(title);
    }

    int getWindowWidth() {
        return window.getWidth();
    }

    int getWindowHeight() {
        return window.getHeight();
    }

    void repaint() {
        while (requestRepaint) {    // We need a loop, since drawWindow might trigger new repaint request
            requestRepaint = false;
            requestWindowUpdate = true;
            drawWindow(newGraphicsContext(null, true));
            windowUpdate();
        }
        windowUpdate();
    }

    void windowUpdate() {
        if (requestWindowUpdate) {
            requestWindowUpdate = false;
            window.update();
        }
    }

    @Override
    protected DrawableMetrics newMetrics() {
        return new DesktopDrawableMetrics();
    }

    @Override
    public GraphicsContext<SkMatrix> newGraphicsContext(SkCanvas avianGraphicsContext, boolean isLive) {
        return avianGraphicsContext == null ? new SkCanvas(window) : avianGraphicsContext;
    }

    /**
     * Create a SkCanvas for a giver bitmap. Note that this canvas will be used to draw
     * primitives on this bitmap and will be desroyed when no needed any more.
     *
     * @param bitmap the bitmap to draw on
     * @return the SkCanvas wrapper
     */
    @Override
    public SkCanvas createCanvas(NativeBitmap bitmap) {
        return new SkCanvas((SkBitmap) bitmap);
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

    static native AvianEvent pollSDLEvents();

    static native void setDebugLevel(int level);
}
