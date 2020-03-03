// (c) 2020 by Panayotis Katsaloulis
// SPDX-License-Identifier: LGPL-3.0-only

package org.crossmobile.backend.desktop;

import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.uikit.UIInterfaceOrientation;
import crossmobile.ios.uikit.UIUserInterfaceIdiom;
import org.crossmobile.bind.graphics.DrawableMetrics;
import org.crossmobile.bridge.Native;

import static crossmobile.ios.uikit.UIDeviceOrientation.*;

public abstract class DesktopDrawableMetrics extends DrawableMetrics {

    private Chassis ch;
    private CArea scr;

    protected int outsetTop = 0;
    protected int outsetRight = 0;
    protected int outsetBottom = 0;
    protected int outsetLeft = 0;

    protected int frameWidth = 1;
    protected int frameHeight = 1;
    protected CGRect clipping;

    protected int skinTranslateX = 0;
    protected int skinTranslateY = 0;
    protected double skinRotate = 0;

    private int proposedInterfaceIdiom;

    @Override
    public void setVirtualDimension(int width, int height) {
        super.setVirtualDimension(width, height);
        clipping = new CGRect(0, 0, virtualWidth, virtualHeight);
    }

    @Override
    protected int calculateIdom(int proposedInterfaceIdiom) {
        this.proposedInterfaceIdiom = proposedInterfaceIdiom;
        setVirtualDimension(vWidth, vHeight);
        setHardwareDimension(scr.width(), scr.height());
        // Set outsets AFTER hardware dimension, in order for the metrics to be properly normalized.
        if (hardwareWidth == 1 || hardwareHeight == 1)
            throw new RuntimeException("Method setOutsetsInPortrait should be called AFTER setHardwareDimension has been set.");
        outsetTop = scr.y();
        outsetRight = ch.width() - scr.uptoX();
        outsetBottom = ch.height() - scr.uptoY();
        outsetLeft = scr.x();
        update();
        return proposedInterfaceIdiom >= 0 ? proposedInterfaceIdiom : ch.getIdiom();
    }

    public int getOrientedFrameWidth() {
        return frameWidth;
    }

    public int getOrientedFrameHeight() {
        return frameHeight;
    }

    public Chassis chassis() {
        return ch;
    }

    @Override
    protected void update() {
        if (hardwareWidth <= 1 || hardwareHeight <= 1)
            return;
        super.update();

        if (orientation == LandscapeLeft || orientation == LandscapeRight) {
            frameWidth = outsetTop + hardwareHeight + outsetBottom;
            frameHeight = outsetLeft + hardwareWidth + outsetRight;
        } else {
            frameWidth = outsetLeft + hardwareWidth + outsetRight;
            frameHeight = outsetTop + hardwareHeight + outsetBottom;
        }
        ch.updateMetrics(frameWidth, frameHeight, hardwareWidth, hardwareHeight);

        switch (orientation) {
            case LandscapeLeft:
                skinTranslateX = -frameHeight;
                skinTranslateY = 0;
                skinRotate = (float) (-Math.PI / 2);
                break;
            case LandscapeRight:
                skinTranslateX = 0;
                skinTranslateY = -frameWidth;
                skinRotate = (float) (Math.PI / 2);
                break;
            case PortraitUpsideDown:
                skinTranslateX = -frameWidth;
                skinTranslateY = -frameHeight;
                skinRotate = (float) Math.PI;
                break;
            case Portrait:
            default:
                skinTranslateX = 0;
                skinTranslateY = 0;
                skinRotate = 0;
                break;
        }
    }

    @Override
    public int getOutsetLeft() {
        return outsetLeft;
    }

    @Override
    public int getOutsetTop() {
        return outsetTop;
    }

    public void setActive(boolean status) {
        ch.setActive(status);
        Native.graphics().refreshDisplay();
    }

    public boolean isActive() {
        return ch != null && ch.isActive();
    }

    public CEvent findArea(int x, int y) {
        CGPoint point = getHardwareToVirtual(x, y, 1, 1, 0, 0);
        return ch.findArea((int) (point.getX() + 0.5), (int) (point.getY() + 0.5), 1 << orientation);
    }

    public void updateMouseMoving(int x, int y, CEvent clicked) {
        CGPoint point = getHardwareToVirtual(x, y, 1, 1, 0, 0);
        clicked.owner.setActive((int) (point.getX() + 0.5), (int) (point.getY() + 0.5), 1 << orientation);
    }

    @Override
    public CGPoint getHardwareToVirtual(double x, double y) {
        return getHardwareToVirtual(x, y, scaleOnX, scaleOnY, outsetLeft, outsetTop);
    }

    @Override
    public CGPoint getVirtualToHardware(double x, double y) {
        return getVirtualToHardware(x, y, scaleOnX, scaleOnY, outsetLeft, outsetTop);
    }

    protected CGPoint getHardwareToVirtual(double x, double y, double scX, double scY, double dx, double dy) {
        switch (orientation) {
            case LandscapeRight:
                return new CGPoint((y - dx) / scX, (frameWidth - x - dy) / scY);
            case LandscapeLeft:
                return new CGPoint((frameHeight - y - dx) / scX, (x - dy) / scY);
            case PortraitUpsideDown:
                return new CGPoint((frameWidth - x - dx) / scX, (frameHeight - y - dy) / scY);
            case Portrait:
            default:
                return new CGPoint((x - dx) / scX, (y - dy) / scY);
        }
    }

    protected CGPoint getVirtualToHardware(double x, double y, double scX, double scY, double dx, double dy) {
        switch (orientation) {
            case LandscapeRight:
                return new CGPoint(frameWidth - dy - y * scX, x * scY + dx);
            case LandscapeLeft:
                return new CGPoint(y * scX + dy, frameHeight - dx - x * scY);
            case PortraitUpsideDown:
                return new CGPoint(frameWidth - dx - x * scX, frameHeight - dy - y * scY);
            case Portrait:
            default:
                return new CGPoint(x * scX + dx, y * scY + dy);
        }
    }

    public boolean isDecorated() {
        return chassis().isDecorated();
    }

    public boolean isAutoResized() {
        return chassis().isAutoResized();
    }

    public boolean isStretched() {
        return chassis().screen().isStretched();
    }

    public boolean isWithStatusBar() {
        return chassis().screen().isWithStatusBar();
    }

    @Override
    protected void setScale() {
        if (ch != null)
            throw new RuntimeException("Chassis already defined");
        String skin = System.getProperty("cm.desktop.skin");
        if (skin.equals(Chassis.Default.getName()))
            skin = proposedInterfaceIdiom == UIUserInterfaceIdiom.Pad ? "pad" : "phone";
        ch = Chassis.getChassis(skin);
        /*
         * First set virtual & hardware dimension. Ignore virtual dimension and use skins values instead.
         */
        scr = ch.screen();
        if (System.getProperty("cm.screen.scale").equals("DPI")) {
            scaleOnX = 1;
            scaleOnY = 1;
            vHeight = (int) (((float) scr.height()) / scaleOnY);
            vWidth = (int) (((float) scr.width()) / scaleOnX);
        }
        if (System.getProperty("cm.screen.scale").split(":")[0].equals("FIXED")) {
            vWidth = Integer.parseInt(System.getProperty("cm.screen.scale").split(":")[1]);
            vHeight = Integer.parseInt(System.getProperty("cm.screen.scale").split(":")[2]);
        } else {
            vHeight = scr.height();
            vWidth = scr.width();
        }
    }

    @Override
    public int getInsetTop() {
        return ch.getInset(orientation).top;
    }

    @Override
    public int getInsetRight() {
        return ch.getInset(orientation).right;
    }

    @Override
    public int getInsetBottom() {
        return ch.getInset(orientation).bottom;
    }

    @Override
    public int getInsetLeft() {
        return ch.getInset(orientation).left;
    }

    public Size calculateHardwareSize(int width, int height) {
        if (orientation == UIInterfaceOrientation.LandscapeLeft || orientation == UIInterfaceOrientation.LandscapeRight) {
            int swap = width;
            width = height;
            height = swap;
        }
        height -= outsetTop + outsetBottom;
        width -= outsetLeft + outsetRight;
        return (hardwareWidth == width && hardwareHeight == height)
                ? null
                : new Size(width, height);
    }
}
