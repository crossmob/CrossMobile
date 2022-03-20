/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import crossmobile.ios.coregraphics.CGAffineTransform;
import crossmobile.ios.uikit.UserInterfaceDrill;
import org.crossmobile.bind.graphics.*;
import org.crossmobile.bridge.Native;

import java.util.List;

import static android.content.pm.ActivityInfo.*;
import static org.crossmobile.bind.graphics.GraphicsBridgeConstants.DefaultInitialOrientation;

public class AndroidGraphicsBridge extends AbstractGraphicsBridge<Canvas, Matrix> {

    private static final int[] AndroidOrientations = {SCREEN_ORIENTATION_UNSPECIFIED, SCREEN_ORIENTATION_PORTRAIT,
            SCREEN_ORIENTATION_REVERSE_PORTRAIT, SCREEN_ORIENTATION_REVERSE_LANDSCAPE, SCREEN_ORIENTATION_LANDSCAPE};

    @Override
    public GraphicsContext<Matrix> newGraphicsContext(Canvas canvas, boolean isLive) {
        return new AndroidGraphicsContext(canvas == null ? new Canvas() : canvas, isLive);
    }

    @Override
    public CGAffineTransform nativeToTarget(Matrix from, CGAffineTransform to) {
        float[] matrix = new float[9];
        from.getValues(matrix);
        if (to == null)
            to = new CGAffineTransform(matrix[0], matrix[3], matrix[1], matrix[4], matrix[2], matrix[5]);
        else {
            to.setA(matrix[0]);
            to.setB(matrix[3]);
            to.setC(matrix[1]);
            to.setD(matrix[4]);
            to.setTx(matrix[2]);
            to.setTy(matrix[5]);
        }
        return to;
    }

    @Override
    public Matrix targetToNative(CGAffineTransform from, Matrix to) {
        if (to == null)
            to = new Matrix();
        to.setValues(new float[]{(float) from.getA(), (float) from.getC(), (float) from.getTx(), (float) from.getB(), (float) from.getD(), (float) from.getTy(), 0, 0, 1});
        return to;
    }

    @Override
    public int colorHSBAtoRGBA(double h, double s, double b, double a) {
        float[] hsv = {(float) (h * 360), (float) s, (float) b};
        return (Color.HSVToColor(hsv) & 0xFFFFFF) | ((int) (a * 0xFF) << 24);
    }

    @Override
    public double[] colorRGBAtoHSVA(int color) {
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);
        return new double[]{hsv[0] / 360d, hsv[1], hsv[2], ((color >>> 24) & 0xFF) / 255d};
    }

    @Override
    protected void requestRepaint() {
        Native.lifecycle().runOnEventThread(() -> MainView.current.invalidate());
    }

    @Override
    public NativeFont getFont(String fontName, double size) {
        return new AndroidFont(fontName, (float) size);
    }

    @Override
    public NativePath newNativePath() {
        return new AndroidNativePath();
    }

    @Override
    public Canvas createCanvas(NativeBitmap bitmap) {
        return new Canvas(((AndroidBitmap) bitmap).bitmap);
    }

    @Override
    public DrawableMetrics newMetrics() {
        return new AndroidDrawableMetrics();
    }

    @Override
    public void destroyCanvas(Canvas canvas) {
        // No need
    }

    @Override
    public String getBackChar() {
        return Theme.Font.BACKCHAR;
    }

    @Override
    public List<String> listFontFamilies() {
        return AndroidFont.families();
    }

    @Override
    public List<String> listFont(String familyName) {
        return AndroidFont.fontsOfFamily(familyName);
    }

    @Override
    public void setOrientation(int iosOrientation) {
        if (UserInterfaceDrill.splashWindow() != null)
            MainActivity.current.setRequestedOrientation(AndroidOrientations[DefaultInitialOrientation]);
        else
            MainActivity.current.setRequestedOrientation(AndroidOrientations[iosOrientation]);
    }

}
