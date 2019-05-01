/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.crossmobile.backend.android;

import android.util.DisplayMetrics;
import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.uikit.UIUserInterfaceIdiom;
import org.crossmobile.bind.graphics.DrawableMetrics;
import org.crossmobile.bind.graphics.GraphicsContext;
import org.crossmobile.bridge.Native;

import static crossmobile.ios.uikit.UIDeviceOrientation.*;

public class AndroidDrawableMetrics extends DrawableMetrics {

    private int orientationTranslateX = 0;
    private int orientationTranslateY = 0;
    private double orientationRotate = 0;
    private final boolean hasSoftBar;
    private int hwLeft, hwRight, hwTop, hwBottom;
    private int vLeft, vRight, vTop, vBottom;

    {
        int transparentId = MainActivity.current.getResources().getIdentifier("config_enableTranslucentDecor", "bool", "android");
        hasSoftBar = transparentId != 0 && MainActivity.current.getResources().getBoolean(transparentId);
    }

    @Override
    protected int calculateIdom(int proposedInterfaceIdiom) {
        // Get hardware dimensions
        DisplayMetrics displayMetrics = displayMetrics();
        boolean isWide = displayMetrics.widthPixels > displayMetrics.heightPixels;
        int width = isWide ? displayMetrics.heightPixels : displayMetrics.widthPixels;
        int heigh = isWide ? displayMetrics.widthPixels : displayMetrics.heightPixels;
        setVirtualDimension(isWide ? vHeight : vWidth, isWide ? vWidth : vHeight);
        setHardwareDimension(width, heigh);
        return proposedInterfaceIdiom >= 0
                ? proposedInterfaceIdiom
                : (displayMetrics.heightPixels / displayMetrics.densityDpi) > 6 ? UIUserInterfaceIdiom.Pad : UIUserInterfaceIdiom.Phone;
    }

    @Override
    public CGPoint getHardwareToVirtual(double x, double y) {
        switch (orientation) {
            case LandscapeRight:
                return new CGPoint(y / orientedScaledWidth, (hardwareHeight - x) / orientedScaledHeight);
            case LandscapeLeft:
                return new CGPoint((hardwareWidth - y) / orientedScaledWidth, x / orientedScaledHeight);
            case PortraitUpsideDown:
                return new CGPoint((hardwareWidth - x) / orientedScaledWidth, (hardwareHeight - y) / orientedScaledHeight);
            case Portrait:
            default:
                return new CGPoint(x / orientedScaledWidth, y / orientedScaledHeight);
        }
    }

    @Override
    public CGPoint getVirtualToHardware(double x, double y) {
        return new CGPoint(x * orientedScaledWidth, y * orientedScaledHeight);
    }

    @Override
    public void preDraw(GraphicsContext ctx) {
//        ctx.saveState();
        ctx.translate(orientationTranslateX, orientationTranslateY);
        ctx.rotate(orientationRotate);
//        ctx.restoreState();
        super.preDraw(ctx);
    }

    @Override
    public void update() {
        super.update();
        // No rotation on the view is actually performed
        orientedScaledWidth = scaleOnX;
        orientedScaledHeight = scaleOnY;
        vTop = hasSoftBar ? (int) (hwTop / orientedScaledWidth) : 0;
        vRight = hasSoftBar ? (int) (hwRight / orientedScaledHeight) : 0;
        vBottom = hasSoftBar ? (int) (hwBottom / orientedScaledWidth) : 0;
        vLeft = hasSoftBar ? (int) (hwLeft / orientedScaledHeight) : 0;
        switch (orientation) {
            case LandscapeRight:
                orientationTranslateX = hardwareHeight;
                orientationTranslateY = 0;
                orientationRotate = GraphicsContext._PI_2;
                break;
            case LandscapeLeft:
                orientationTranslateX = 0;
                orientationTranslateY = hardwareWidth;
                orientationRotate = -GraphicsContext._PI_2;
                break;
            case PortraitUpsideDown:
                orientationTranslateX = hardwareWidth;
                orientationTranslateY = hardwareHeight;
                orientationRotate = GraphicsContext._PI;
                break;
            case Portrait:
            default:
                orientationTranslateX = 0;
                orientationTranslateY = 0;
                orientationRotate = 0;
                break;
        }
    }

    @Override
    public void setScaling(double scaleWidth, double scaleHeight, boolean affectHardwareMetrics) {
        Native.lifecycle().notImplemented();
    }

    @Override
    protected void setScale() {
        DisplayMetrics m = displayMetrics();
        if (System.getProperty("cm.screen.scale").equals("DPI")) {
            vHeight = (int) (m.heightPixels / m.scaledDensity);
            vWidth = (int) (m.widthPixels / m.scaledDensity);
        } else if (System.getProperty("cm.screen.scale").split(":")[0].equals("FIXED")) {
            vWidth = Integer.parseInt(System.getProperty("cm.screen.scale").split(":")[1]);
            vHeight = Integer.parseInt(System.getProperty("cm.screen.scale").split(":")[2]);
        } else {
            vHeight = m.heightPixels;
            vWidth = m.widthPixels;
        }
    }

    @Override
    public int getInsetTop() {
        return 0;//vTop;
    }

    @Override
    public int getInsetRight() {
        return vRight;
    }

    @Override
    public int getInsetBottom() {
        return vBottom;
    }

    @Override
    public int getInsetLeft() {
        return vLeft;
    }

    public void updateInsets(int top, int right, int bottom, int left) {
        this.hwTop = 0;//top;
        this.hwRight = right;
        this.hwBottom = bottom;
        this.hwLeft = left;
        MainActivity.current.updateOrientation();
    }

    private DisplayMetrics displayMetrics() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        MainActivity.current.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics;
    }
}
