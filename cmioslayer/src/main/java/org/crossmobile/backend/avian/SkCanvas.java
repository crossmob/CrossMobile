package org.crossmobile.backend.avian;

import crossmobile.ios.coregraphics.CGAffineTransform;
import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.coregraphics.CGSize;
import org.crossmobile.bind.graphics.GraphicsContext;
import org.crossmobile.bind.graphics.NativeBitmap;
import org.crossmobile.bind.graphics.NativeFont;
import org.crossmobile.bind.graphics.NativePath;

public class SkCanvas extends NativeElement implements GraphicsContext<SkMatrix> {
    static final byte FILL = 0;
    static final byte STROKE = 1;
    static final byte FILL_AND_STROKE = 2;

    static final byte MITER_JOIN = 0;
    static final byte ROUND_JOIN = 1;
    static final byte BEVEL_JOIN = 2;
    static final byte LAST_JOIN = BEVEL_JOIN;
    static final byte DEFAULT_JOIN = MITER_JOIN;

    static final byte BUTT_CAP = 0;
    static final byte ROUND_CAP = 1;
    static final byte SQUARE_CAP = 2;
    static final byte LAST_CAP = SQUARE_CAP;
    static final byte DEFAULT_CAP = ROUND_CAP;

    private final long fillPaintPeer;
    private final long drawPaintPeer;

    private SkFont font = new SkFont();

    SkCanvas(SDLWindow surface) {
        super(initCanvas(surface.getWidth(), surface.getHeight(), surface.getPixels(), surface.getPitch()));
        fillPaintPeer = initPaint();
        drawPaintPeer = initPaint();

        setPaintStyle(fillPaintPeer, FILL);
        setPaintStyle(drawPaintPeer, STROKE);
    }

    public void setAlpha(double alpha) {
        setPaintAlpha(drawPaintPeer, alpha);
    }

    public void saveState() {
        save(peer);
    }

    public void restoreState() {
        restore(peer);
    }

    @Override
    public void drawBitmap(NativeBitmap image, int x, int y, int width, int height) {
        drawImage(peer, ((SkBitmap) image).peer, x, y, width, height, drawPaintPeer);
    }

    @Override
    public void setFillColorWithColor(int color) {
        setPaintColor(fillPaintPeer, color);
    }

    @Override
    public void setDrawColorWithColor(int color) {
        setPaintColor(drawPaintPeer, color);
    }

    @Override
    public void clipToRect(CGRect frame) {
    }

    @Override
    public void translate(double tx, double ty) {
        translate(peer, tx, ty);
    }

    @Override
    public void rotate(double theta) {
        rotate(peer, theta);
    }

    @Override
    public void scale(double sx, double sy) {
        scale(peer, sx, sy);
    }

    @Override
    public void setFont(NativeFont font) {
        this.font = font == null ? this.font : (SkFont) font;
    }

    @Override
    public CGSize stringSizeWithFont(String text, NativeFont font) {
        return null;
    }

    @Override
    public void showTextAtPoint(double x, double y, String text) {
        drawText(peer, x, y, text, fillPaintPeer, font.peer);
    }

    @Override
    public void setLineWidth(double width) {
        setPaintStrokeWidth(drawPaintPeer, width);
    }

    @Override
    // public void setLineJoin(int CGLineJoin) {
    public void setLineJoin(int lineJoin) {
        setPaintStrokeJoin(drawPaintPeer, (byte) lineJoin);
    }

    @Override
    // public void setLineCap(int CGLineCap) {
    public void setLineCap(int lineCap) {
        setPaintStrokeCap(drawPaintPeer, (byte) lineCap);
    }

    @Override
    public void setAntialias(boolean shouldAntialias) {
        setPaintAntialias(fillPaintPeer, shouldAntialias);
        setPaintAntialias(drawPaintPeer, shouldAntialias);
    }

    @Override
    public void drawLine(double x1, double y1, double x2, double y2) {
        drawLine(peer, x1, y1, x2, y2, drawPaintPeer);
    }

    @Override
    public void drawRect(double x, double y, double width, double height) {
        drawRect(peer, x, y, width, height, drawPaintPeer);
    }

    @Override
    public void fillRect(double x, double y, double width, double height) {
        drawRect(peer, x, y, width, height, fillPaintPeer);
    }

    @Override
    public void drawEllipse(double x, double y, double width, double height) {
        drawRRect(peer, x, y, width, height, drawPaintPeer);
    }

    @Override
    public void fillEllipse(double x, double y, double width, double height) {
        drawRRect(peer, x, y, width, height, fillPaintPeer);
    }

    @Override
    public void drawArc(double x, double y, double width, double height, double from, double extend) {
        drawArc(peer, x, y, width, height, from, extend, drawPaintPeer);
    }

    @Override
    public void fillArc(double x, double y, double width, double height, double from, double extend) {
        drawArc(peer, x, y, width, height, from, extend, fillPaintPeer);
    }

    @Override
    public void drawPath(NativePath path) {
        drawPath(peer, drawPaintPeer, ((SkPath) path).getPeer());
    }

    @Override
    public void fillPath(NativePath path) {
        drawPath(peer, fillPaintPeer, ((SkPath) path).getPeer());
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
    public void concatCTM(SkMatrix transform) {
    }

    @Override
    public CGAffineTransform getCTM() {
        return null;
    }

    @Override
    public boolean isLiveContext() {
        return false;
    }

    // TODO: maybe remove this method?
    public void clear(int color) {
        clear(peer, color);
    }

    // TODO: maybe remove this method?
    public void flush() {
        flush(peer);
    }

    @Override
    protected void destroy(long peer) {
        destroyCanvas(peer);
        destroyPaint(fillPaintPeer);
        destroyPaint(drawPaintPeer);
    }

    // SkCanvas object
    private static native long initCanvas(int width, int height, long pixels, int pitch);

    private static native void destroyCanvas(long canvasPeer);

    // SkPaint object
    private static native long initPaint();

    private static native void destroyPaint(long paintPeer);

    // SkCanvas methods
    private static native void clear(long canvasPeer, int color);

    private static native void flush(long canvasPeer);

    private static native void drawText(long canvasPeer, double x, double y, String text, long paintPeer, long fontPeer);

    private static native void drawRect(long canvasPeer, double x, double y, double width, double height, long paintPeer);

    private static native void drawImage(long canvasPeer, long imagePeer, double x, double y, double width, double height, long paintPeer);

    private static native void drawLine(long canvasPeer, double x1, double y1, double x2, double y2, long paintPeer);

    private static native void drawRRect(long canvasPeer, double x, double y, double width, double height, long paintPeer);

    private static native void drawArc(long canvasPeer, double x, double y, double width, double height, double from, double extend, long paintPeer);

    private static native void drawPath(long canvasPeer, long paintPeer, long pathPeer);

    private static native void save(long canvasPeer);

    private static native void restore(long canvasPeer);

    private static native void translate(long canvasPeer, double tx, double ty);

    private static native void rotate(long canvasPeer, double theta);

    private static native void scale(long canvasPeer, double sx, double sy);

    private static native void clipRect(long canvasPeer, double x, double y, double w, double h);

    // SkPaint methods
    private static native void setPaintStyle(long paintPeer, byte style);

    private static native void setPaintStrokeWidth(long paintPeer, double width);

    private static native void setPaintColor(long paintPeer, int color);

    private static native void setPaintAntialias(long paintPeer, boolean shouldAntiAlias);

    private static native void setPaintAlpha(long paintPeer, double alpha);

    private static native void setPaintStrokeJoin(long paintPeer, byte strokeJoin);

    private static native void setPaintStrokeCap(long paintPeer, byte strokeCap);
}
