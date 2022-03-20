/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics;

import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.uikit.UIUserInterfaceIdiom;

import static crossmobile.ios.uikit.UIDeviceOrientation.LandscapeLeft;
import static crossmobile.ios.uikit.UIDeviceOrientation.LandscapeRight;

public abstract class DrawableMetrics {

    // Core parameters which do not get recalculated

    // Virtual width & height in points
    protected int virtualWidth = 1;
    protected int virtualHeight = 1;

    // Actual width and height in pixels
    protected int hardwareWidth = 1;
    protected int hardwareHeight = 1;

    protected int orientation = 0; // Unknown
    protected int idiom;

    // Computed parameters based on scaling & orientation
    protected double scaleOnX = 1;
    protected double scaleOnY = 1;
    protected double orientedScaledWidth;
    protected double orientedScaledHeight;

    private CGPoint[] lastTouchPoints = null;  // This is used by debug touch events

    public void setVirtualDimension(int width, int height) {
        if (virtualWidth == width && virtualHeight == height)
            return;
        virtualWidth = width;
        virtualHeight = height;
        update();
    }

    public void setHardwareDimension(int width, int height) {
        if (hardwareWidth == width && hardwareHeight == height)
            return;
        hardwareWidth = width;
        hardwareHeight = height;
        update();
    }

    public boolean setOrientationMetrics(int UIDeviceOrientation) {
        boolean hasChanged = orientation == UIDeviceOrientation;
        orientation = UIDeviceOrientation;
        update();
        return hasChanged;
    }

    public void initIdiom() {
        String given = System.getProperty("cm.device", "").toLowerCase();
        int proposed = given.equals("iphone") ? UIUserInterfaceIdiom.Phone : (given.equals("ipad") ? UIUserInterfaceIdiom.Pad : -1);
        Size size;
        switch (System.getProperty("cm.screen.scale")) {
            case "NATIVE":
                size = initNativeScale();
                break;
            case "DPI":
                size = initDPIScale();
                break;
            default:
                String[] values = System.getProperty("cm.screen.scale").split(":");
                size = initFixedScale(Integer.parseInt(values[1]), Integer.parseInt(values[1]));
        }
        idiom = finalizeScale(proposed, size);
    }

    protected abstract Size initDPIScale();

    protected Size initFixedScale(int width, int height) {
        return new Size(width, height);
    }

    protected abstract Size initNativeScale();

    protected abstract int finalizeScale(int proposedInterfaceIdiom, Size size);

    public int getOrientation() {
        return orientation;
    }

    public int getIdiom() {
        return idiom;
    }

    public int getHardwareWidth() {
        return hardwareWidth;
    }

    public int getHardwareHeight() {
        return hardwareHeight;
    }

    public double getOrientedScaleWidth() {
        return orientedScaledWidth;
    }

    public double getOrientedScaleHeight() {
        return orientedScaledHeight;
    }

    public double getScaleAverage() {
        return (scaleOnY + scaleOnX) / 2;
    }

    public double getVirtualScale() {
        return getScaleAverage();
    }

    public int getVirtualWidth() {
        return virtualWidth;
    }

    public int getVirtualHeight() {
        return virtualHeight;
    }

    public int getOutsetLeft() {
        return 0;
    }

    public int getOutsetTop() {
        return 0;
    }

    public abstract int getInsetTop();

    public abstract int getInsetRight();

    public abstract int getInsetBottom();

    public abstract int getInsetLeft();

    public void preDraw(GraphicsContext<?> ctx) {
        ctx.scale(scaleOnX, scaleOnY);
    }

    public void postDraw(GraphicsContext<?> ctx) {
    }

    protected void update() {
        if (hardwareWidth <= 1 || hardwareHeight <= 1)
            return;
        scaleOnX = ((double) hardwareWidth) / virtualWidth;
        scaleOnY = ((double) hardwareHeight) / virtualHeight;
        if (orientation == LandscapeLeft || orientation == LandscapeRight) {
            //noinspection SuspiciousNameCombination
            orientedScaledWidth = scaleOnY;
            //noinspection SuspiciousNameCombination
            orientedScaledHeight = scaleOnX;
        } else {
            orientedScaledWidth = scaleOnX;
            orientedScaledHeight = scaleOnY;
        }
    }

    public CGPoint[] getActiveTouchLocations() {
        return lastTouchPoints;
    }

    public void setActiveTouchLocations(CGPoint[] lastTouchPoint) {
        this.lastTouchPoints = lastTouchPoint;
    }

    public CGPoint getMirrorVirtualFromHardwarePoint(double hardwareX, double hardwareY) {
        if (orientation == LandscapeLeft || orientation == LandscapeRight)
            return getHardwareToVirtual(hardwareHeight - hardwareX, hardwareWidth - hardwareY);
        else
            return getHardwareToVirtual(hardwareWidth - hardwareX, hardwareHeight - hardwareY);
    }

    public abstract CGPoint getHardwareToVirtual(double x, double y);

    public abstract CGPoint getVirtualToHardware(double x, double y);
}
