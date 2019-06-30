/*
 * (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
 */
package org.crossmobile.bind.graphics;

import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.uikit.UIUserInterfaceIdiom;

import static crossmobile.ios.uikit.UIDeviceOrientation.LandscapeLeft;
import static crossmobile.ios.uikit.UIDeviceOrientation.LandscapeRight;

public abstract class DrawableMetrics {

    // Core parameters
    // These are fixed parameters which do not get recalculated
    protected int virtualWidth = 1;
    protected int virtualHeight = 1;
    protected int hardwareWidth = 1;
    protected int hardwareHeight = 1;
    protected int orientation = 0; // Unknown
    protected int idiom;
    // Computed parameters based on scaling & orientation
    protected float scaleOnX = 1;
    protected float scaleOnY = 1;
    protected float orientedScaledWidth;
    protected float orientedScaledHeight;
    //Parameters for Scaling Purposes
    protected int vHeight;
    protected int vWidth;
    //
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
        setScale();
        idiom = calculateIdom(proposed);
    }

    protected abstract int calculateIdom(int proposedInterfaceIdiom);

    protected abstract void setScale();

    public void setScaling(double scaleWidth, double scaleHeight, boolean affectHardwareMetrics) {
        if (affectHardwareMetrics) {
            int newWidth = (int) (virtualWidth * scaleWidth + 0.5);
            int newHeight = (int) (virtualHeight * scaleHeight + 0.5);
            if (newHeight == hardwareHeight && newWidth == hardwareWidth)
                return;
            setHardwareDimension(newWidth, newHeight);
        } else {
            int newWidth = (int) (hardwareWidth / scaleWidth + 0.5);
            int newHeight = (int) (hardwareHeight / scaleHeight + 0.5);
            if (newHeight == virtualHeight && newWidth == virtualWidth)
                return;
            setVirtualDimension(newWidth, newHeight);
        }
        // No need to update, since it is alrady updated by setHardwareDimension/setVirtualDimention
    }

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

    public void preDraw(GraphicsContext ctx) {
        ctx.scale(scaleOnX, scaleOnY);
    }

    public void postDraw(GraphicsContext ctx) {
    }

    protected void update() {
        if (hardwareWidth <= 1 || hardwareHeight <= 1)
            return;
        scaleOnX = ((float) hardwareWidth) / virtualWidth;
        scaleOnY = ((float) hardwareHeight) / virtualHeight;
        if (orientation == LandscapeLeft || orientation == LandscapeRight) {
            orientedScaledWidth = scaleOnY;
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
