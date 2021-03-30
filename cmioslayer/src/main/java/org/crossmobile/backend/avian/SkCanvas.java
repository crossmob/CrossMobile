package org.crossmobile.backend.avian;

import crossmobile.ios.coregraphics.CGAffineTransform;
import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.coregraphics.CGSize;
import org.crossmobile.bind.graphics.GraphicsContext;
import org.crossmobile.bind.graphics.NativeBitmap;
import org.crossmobile.bind.graphics.NativeFont;
import org.crossmobile.bind.graphics.NativePath;

public class SkCanvas extends NativeElement implements GraphicsContext<SkMatrix> {
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

    private SkFont font = new SkFont();
    private final SkPaint fill = new SkPaint();
    private final SkPaint draw = new SkPaint();

    private SkCanvas(long peer) {
        super(peer);
        fill.setStyle(SkPaint.FILL);
        draw.setStyle(SkPaint.STROKE);
    }

    SkCanvas(SDLWindow surface) {
        this(initCanvas(surface.getWidth(), surface.getHeight(), surface.getPixels(), surface.getPitch()));
    }

    SkCanvas(SkBitmap bitmap) {
        this(initCanvas(bitmap.peer));
    }

    public void setAlpha(double alpha) {
        draw.setAlpha(alpha);
    }

    public void saveState() {
        save(peer);
    }

    public void restoreState() {
        restore(peer);
    }

    @Override
    public void drawBitmap(NativeBitmap image, int x, int y, int width, int height) {
        drawImage(peer, ((SkBitmap) image).peer, x, y, width, height);
    }

    @Override
    public void setFillColorWithColor(int color) {
        fill.setColor(color);
    }

    @Override
    public void setDrawColorWithColor(int color) {
        draw.setColor(color);
    }

    @Override
    public void clipToRect(CGRect frame) {
        clipRect(peer, frame.getMaxX() - frame.getMinX(), frame.getMaxY() - frame.getMinY(), fill.peer);
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
        return ((SkFont) font).measureText(text);
    }

    @Override
    public void showTextAtPoint(double x, double y, String text) {
        drawText(peer, x, y - font.ascentText(text), text, fill.peer, font.peer);
    }

    @Override
    public void setLineWidth(double width) {
        draw.setStrokeWidth(width);
    }

    @Override
    // public void setLineJoin(int CGLineJoin) {
    public void setLineJoin(int lineJoin) {
        draw.setStrokeJoin((byte) lineJoin);
    }

    @Override
    // public void setLineCap(int CGLineCap) {
    public void setLineCap(int lineCap) {
        draw.setStrokeCap((byte) lineCap);
    }

    @Override
    public void setAntialias(boolean shouldAntialias) {
        fill.setAntiAlias(shouldAntialias);
        draw.setAntiAlias(shouldAntialias);
    }

    @Override
    public void drawLine(double x1, double y1, double x2, double y2) {
        drawLine(peer, x1, y1, x2, y2, draw.peer);
    }

    @Override
    public void drawRect(double x, double y, double width, double height) {
        drawRect(peer, x, y, width, height, draw.peer);
    }

    @Override
    public void fillRect(double x, double y, double width, double height) {
        drawRect(peer, x, y, width, height, fill.peer);
    }

    @Override
    public void drawEllipse(double x, double y, double width, double height) {
        drawRRect(peer, x, y, width, height, draw.peer);
    }

    @Override
    public void fillEllipse(double x, double y, double width, double height) {
        drawRRect(peer, x, y, width, height, fill.peer);
    }

    @Override
    public void drawArc(double x, double y, double width, double height, double from, double extend) {
        drawArc(peer, x, y, width, height, from, extend, draw.peer);
    }

    @Override
    public void fillArc(double x, double y, double width, double height, double from, double extend) {
        drawArc(peer, x, y, width, height, from, extend, fill.peer);
    }

    @Override
    public void drawPath(NativePath path) {
        drawPath(peer, draw.peer, ((SkPath) path).getPeer());
    }

    @Override
    public void fillPath(NativePath path) {
        drawPath(peer, fill.peer, ((SkPath) path).getPeer());
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

    /**
     * Concat given matrix with the current transformation matrix of this Canvas
     *
     * @param transform the offered transformation matrix to concat with the current one
     */
    @Override
    public void concatCTM(SkMatrix transform) {
    }

    /**
     * Get the current transformation matrix of this canvas
     *
     * @return the transformation matrix
     */
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

    public void fill() {
        fill(this.peer, fill.peer);
    }

    public void drawNinePatch(SkBitmap sourceBitmap, int top, int right, int bottom, int left, int reqX, int reqY) {
        drawNinePatch(this.peer, sourceBitmap.peer, top, right, bottom, left, reqX, reqY);
    }

    @Override
    protected void destroy(long peer) {
        destroyCanvas(peer);
    }

    private static native long initCanvas(int width, int height, long pixels, int pitch);

    private static native long initCanvas(long bitmapPeer);

    private static native void destroyCanvas(long canvasPeer);

    private static native void clear(long canvasPeer, int color);

    private static native void flush(long canvasPeer);

    private static native void drawText(long canvasPeer, double x, double y, String text, long paintPeer, long fontPeer);

    private static native void drawRect(long canvasPeer, double x, double y, double width, double height, long paintPeer);

    private static native void drawImage(long canvasPeer, long imagePeer, double x, double y, double width, double height);

    private static native void drawLine(long canvasPeer, double x1, double y1, double x2, double y2, long paintPeer);

    private static native void drawRRect(long canvasPeer, double x, double y, double width, double height, long paintPeer);

    private static native void drawArc(long canvasPeer, double x, double y, double width, double height, double from, double extend, long paintPeer);

    private static native void drawPath(long canvasPeer, long paintPeer, long pathPeer);

    private static native void save(long canvasPeer);

    private static native void restore(long canvasPeer);

    private static native void translate(long canvasPeer, double tx, double ty);

    private static native void rotate(long canvasPeer, double theta);

    private static native void scale(long canvasPeer, double sx, double sy);

    private static native void clipRect(long canvasPeer, double w, double h, long paintPeer);

    private static native void fill(long canvasPeer, long paintPeer);

    private static native void drawNinePatch(long peer, long sourceBitmapPeer, int top, int right, int bottom, int left, int reqX, int reqY);
}
