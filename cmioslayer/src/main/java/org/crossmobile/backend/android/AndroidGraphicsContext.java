/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.graphics.*;
import android.graphics.Paint.Style;
import crossmobile.ios.coregraphics.*;
import org.crossmobile.backend.swing.SwingNativePath;
import org.crossmobile.bind.graphics.GraphicsContext;
import org.crossmobile.bind.graphics.NativeBitmap;
import org.crossmobile.bind.graphics.NativeFont;
import org.crossmobile.bind.graphics.NativePath;
import org.crossmobile.bridge.Native;

import java.util.Stack;

public class AndroidGraphicsContext implements GraphicsContext<Matrix> {

    Canvas cv;
    private final boolean isLive;
    private final Rect buffer_text_bounds;
    private final Stack<GState> states;   // We need to keep track of our own stack, because the alpha channel always create a stack, so just a simple "restore" is not enough
    private Paint draw_paint;
    private Paint fill_paint;
    private Typeface typeface;
    private float fontSize;

    public AndroidGraphicsContext(Canvas canvas, boolean isLive) {
        this.cv = canvas;
        this.isLive = isLive;
        draw_paint = new Paint();
        draw_paint.setStyle(Style.STROKE);
        fill_paint = new Paint();
        fill_paint.setStyle(Style.FILL);
        buffer_text_bounds = new Rect();
        states = new Stack<>();
    }

    @Override
    public void setAlpha(double alpha) {
        draw_paint.setAlpha((int) (alpha * 255));
        fill_paint.setAlpha((int) (alpha * 255));
    }

    @Override
    public void saveState() {
        states.add(new GState());
    }

    @Override
    public void restoreState() {
        states.pop().apply();
    }

    @Override
    public void concatCTM(Matrix transform) {
        cv.concat(transform);
    }

    @SuppressWarnings("unchecked")
    @Override
    public CGAffineTransform getCTM() {
        return Native.graphics().nativeToTarget(MainView.current.getMatrix(), null);
    }

    @Override
    public void drawBitmap(NativeBitmap imgc, int x, int y, int width, int height) {
        if (imgc != null)
            cv.drawBitmap(((AndroidBitmap) imgc).bitmap, null, new RectF(x, y, x + width, y + height), draw_paint);
    }

    @Override
    public void drawLine(double x1, double y1, double x2, double y2) {
        cv.drawLine((float) x1, (float) y1, (float) x2, (float) y2, draw_paint);
    }

    @Override
    public void drawPath(NativePath path) {
        cv.drawPath((AndroidNativePath)path, draw_paint);
    }

    @Override
    public void drawRect(double x, double y, double width, double height) {
        cv.drawRect((float) x, (float) y, (float) (x + width), (float) (y + height), draw_paint);
    }

    @Override
    public void drawEllipse(double x, double y, double width, double height) {
        cv.drawOval(new RectF((float) x, (float) y, (float) (x + width - 1), (float) (y + height - 1)), draw_paint);
    }

    @Override
    public void drawArc(double x, double y, double width, double height, double from, double extend) {
        cv.drawArc(new RectF((float) x, (float) y, (float) (x + width - 1), (float) (y + height - 1)), (float) (-from * PI_TO_DEG), (float) (-extend * PI_TO_DEG), false, draw_paint);
    }

    @Override
    public void fillPath(NativePath path) {
        cv.drawPath((AndroidNativePath)path, fill_paint);
    }

    @Override
    public void fillRect(double x, double y, double width, double height) {
        cv.drawRect((float) x, (float) y, (float) (x + width), (float) (y + height), fill_paint);
    }

    @Override
    public void fillEllipse(double x, double y, double width, double height) {
        cv.drawOval(new RectF((float) x, (float) y, (float) (x + width), (float) (y + height)), fill_paint);
    }

    @Override
    public void fillArc(double x, double y, double width, double height, double from, double extend) {
        cv.drawArc(new RectF((float) x, (float) y, (float) (x + width), (float) (y + height)), (float) (-from * PI_TO_DEG), (float) (-extend * PI_TO_DEG), true, fill_paint);
    }

    @Override
    public void drawLinearGradient(int[] RGBcolors, double[] locations, double startPointX, double startPointY, double endPointX, double endPointY, int CGGradientDrawingOptions) {
        Paint p = new Paint();
        float[] locationsF = new float[locations.length];
        for (int i = 0; i < locations.length; i++) locationsF[i] = (float) locations[i];
        p.setShader(new LinearGradient((float) startPointX, (float) startPointY, (float) endPointX, (float) endPointY, RGBcolors, locationsF, Shader.TileMode.CLAMP));
        cv.drawRect((float) startPointX, (float) startPointY, (float) endPointX, (float) endPointY, p);
    }

    @Override
    public void drawRadialGradient(int[] RGBcolors, double[] locations, double startCenterX, double startCenterY, double startRadius, double endCenterX, double endCenterY, double endRadius, int CGGradientDrawingOptions) {
        Paint p = new Paint();
        float[] locationsF = new float[locations.length];
        for (int i = 0; i < locations.length; i++) locationsF[i] = (float) locations[i];
        p.setShader(new RadialGradient((float) startCenterX, (float) startCenterY, (float) startRadius, RGBcolors, locationsF, Shader.TileMode.CLAMP));
        cv.drawOval(new RectF(), p);
    }

    @Override
    public void setDrawColorWithColor(int color) {
        draw_paint.setColor(color);
    }

    @Override
    public void setFillColorWithColor(int color) {
        fill_paint.setColor(color);
    }

    @Override
    public void clipToRect(CGRect frame) {
        cv.clipRect((float) frame.getOrigin().getX(), (float) frame.getOrigin().getY(), (float) (frame.getOrigin().getX() + frame.getSize().getWidth()), (float) (frame.getOrigin().getY() + frame.getSize().getHeight()));
    }

    @Override
    public void clip(NativePath path) {
        cv.clipPath((AndroidNativePath)path);
    }

    @Override
    public void translate(double tx, double ty) {
        cv.translate((float) tx, (float) ty);
    }

    @Override
    public void rotate(double theta) {
        cv.rotate((float) (theta * PI_TO_DEG));
    }

    @Override
    public void scale(double sx, double sy) {
        cv.scale((float) sx, (float) sy);
    }

    @Override
    public void setFont(NativeFont font) {
        this.typeface = ((AndroidFont) font).typeface;
        this.fontSize = ((AndroidFont) font).size;
    }

    @Override
    public CGSize stringSizeWithFont(String text, NativeFont font) {
        if (text == null || text.length() < 1 || font == null)
            return new CGSize(0, 0);
        fill_paint.setTypeface(((AndroidFont) font).typeface);
        fill_paint.setTextSize(((AndroidFont) font).size);
        fill_paint.getTextBounds(text, 0, text.length(), buffer_text_bounds);
        return new CGSize(buffer_text_bounds.right + buffer_text_bounds.left, buffer_text_bounds.bottom - buffer_text_bounds.top);
    }

    @Override
    public void showTextAtPoint(double x, double y, String text) {
        fill_paint.setTypeface(typeface);
        fill_paint.setTextSize(fontSize);
        fill_paint.getTextBounds(text, 0, text.length(), buffer_text_bounds);
        cv.drawText(text, (float) x, (float) y - buffer_text_bounds.top, fill_paint);
//        cv.drawText(text, x - buffer_text_bounds.left, y - buffer_text_bounds.top, fill_paint);
    }

    @Override
    public void setLineCap(int cglinecap) {
        switch (cglinecap) {
            case CGLineCap.Round:
                draw_paint.setStrokeCap(Paint.Cap.ROUND);
                break;
            case CGLineCap.Square:
                draw_paint.setStrokeCap(Paint.Cap.SQUARE);
                break;
            case CGLineCap.Butt:
            default:
                draw_paint.setStrokeCap(Paint.Cap.BUTT);
                break;
        }
    }

    @Override
    public void setLineJoin(int cglinejoin) {
        switch (cglinejoin) {
            case CGLineJoin.Bevel:
                draw_paint.setStrokeJoin(Paint.Join.BEVEL);
                break;
            case CGLineJoin.Round:
                draw_paint.setStrokeJoin(Paint.Join.ROUND);
                break;
            case CGLineJoin.Miter:
            default:
                draw_paint.setStrokeJoin(Paint.Join.MITER);
                break;
        }
    }

    @Override
    public void setLineWidth(double width) {
        draw_paint.setStrokeWidth((float) width);
    }

    @Override
    public void setAntialias(boolean shouldAntialias) {
        if (shouldAntialias) {
            draw_paint.setAntiAlias(true);
            draw_paint.setFilterBitmap(true);
            fill_paint.setAntiAlias(true);
        } else {
            draw_paint.setAntiAlias(false);
            draw_paint.setFilterBitmap(false);
            fill_paint.setAntiAlias(false);
        }
    }

    public Canvas getCanvas() {
        return cv;
    }

    @Override
    public boolean isLiveContext() {
        return isLive;
    }

    private class GState {

        private final int savedState;
        private final Paint _draw_paint;
        private final Paint _fill_paint;
        private final Typeface _typeface;
        private final float _fontSize;

        public GState() {
            _draw_paint = new Paint(draw_paint);
            _fill_paint = new Paint(fill_paint);
            _typeface = typeface;
            _fontSize = fontSize;
            savedState = cv.save();
        }

        private void apply() {
            draw_paint = _draw_paint;
            fill_paint = _fill_paint;
            typeface = _typeface;
            fontSize = _fontSize;
            cv.restoreToCount(savedState);
        }
    }

}
