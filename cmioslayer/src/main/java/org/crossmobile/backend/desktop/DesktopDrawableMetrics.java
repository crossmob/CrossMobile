/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.desktop;

import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.uikit.UIApplication;
import crossmobile.ios.uikit.UIInterfaceOrientation;
import crossmobile.ios.uikit.UIWindow;
import org.crossmobile.backend.desktop.cgeo.CArea;
import org.crossmobile.backend.desktop.cgeo.CEvent;
import org.crossmobile.backend.desktop.cgeo.Chassis;
import org.crossmobile.bind.graphics.DrawableMetrics;
import org.crossmobile.bind.graphics.GraphicsContext;
import org.crossmobile.bind.graphics.Size;
import org.crossmobile.bridge.Native;

import static crossmobile.ios.uikit.UIDeviceOrientation.*;
import static crossmobile.ios.uikit.UserInterfaceDrill.splashWindow;

public class DesktopDrawableMetrics extends DrawableMetrics {

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

    private int dpi;

    public void updateDPI(int dpi) {
        this.dpi = dpi;
    }

    @Override
    public double getVirtualScale() {
        return Math.max(super.getVirtualScale(), Math.ceil(dpi / 96d));
    }

    @Override
    public void setVirtualDimension(int width, int height) {
        super.setVirtualDimension(width, height);
        clipping = new CGRect(0, 0, virtualWidth, virtualHeight);
    }

    @Override
    public void initIdiom() {
        if (ch != null)
            throw new RuntimeException("Chassis already defined");
        ch = Chassis.getSkin(System.getProperty(DesktopArguments.USER_ARG_SKIN, System.getProperty("cm.desktop.skin")));
        scr = ch.screen();
        super.initIdiom();
    }

    @Override
    protected Size initDPIScale() {
        double userScale = 1;
        try {
            userScale = Float.parseFloat(System.getProperty(DesktopArguments.USER_ARG_SCALE, "1"));
        } catch (NumberFormatException ignored) {
        }
        ch.setScale(userScale);
        return new Size(scr.virtualWidth(), scr.virtualHeight());
    }

    @Override
    protected Size initNativeScale() {
        return new Size(scr.virtualWidth(), scr.virtualHeight());   // don't support raw pixels yet
    }

    @Override
    protected int finalizeScale(int proposedInterfaceIdiom, Size size) {
        outsetLeft = scr.hardwareX();
        outsetTop = scr.hardwareY();
        outsetRight = ch.hardwareWidth() - scr.hardwareRightEdge();
        outsetBottom = ch.hardwareHeight() - scr.hardwareBottomEdge();
        setVirtualDimension(size.width, size.height);
        setHardwareDimension(scr.hardwareWidth(), scr.hardwareHeight());
        if (hardwareWidth == 1 || hardwareHeight == 1)
            throw new RuntimeException("Method setOutsetsInPortrait should be called AFTER setHardwareDimension has been set.");
        return proposedInterfaceIdiom >= 0 ? proposedInterfaceIdiom : ch.getIdiom();
    }

    public void windowResized(int width, int height) {
        if (orientation == UIInterfaceOrientation.LandscapeLeft || orientation == UIInterfaceOrientation.LandscapeRight) {
            int swap = width;
            //noinspection SuspiciousNameCombination
            width = height;
            height = swap;
        }
        height -= outsetTop + outsetBottom;
        width -= outsetLeft + outsetRight;
        if (hardwareWidth == width && hardwareHeight == height)
            return;
        setHardwareDimension(width, height);
        if (!isStretched()) {
            setVirtualDimension(ch.unscaled(width), ch.unscaled(height));
            UIApplication app = UIApplication.sharedApplication();
            if (app == null)
                return;
            UIWindow win = splashWindow();
            if (win == null)
                win = app.keyWindow();
            if (win == null)
                return;
            win.setFrame(new CGRect(0, 0, ch.unscaled(width), ch.unscaled(height)));  // frame NEEDS to be updated here
            Native.graphics().relayoutMainView();
        }
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
    public void preDraw(GraphicsContext<?> ctx) {
        if (skinRotate != 0)
            ctx.rotate(skinRotate);
        if (skinTranslateX != 0 || skinTranslateY != 0)
            ctx.translate(skinTranslateX, skinTranslateY);
        chassis().draw(ctx, false, 1 << orientation);
        ctx.saveState();    // will restore in postDraw
        if (outsetLeft != 0 || outsetRight != 0)
            ctx.translate(outsetLeft, outsetTop);
        super.preDraw(ctx);
        ctx.clipToRect(clipping);
    }

    @Override
    public void postDraw(GraphicsContext<?> ctx) {
        ctx.restoreState(); // did save in preDraw
        chassis().draw(ctx, true, 1 << orientation);
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
        ch.resize(virtualWidth, virtualHeight);

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
        CGPoint point = getHardwareToVirtual(x, y, false);
        return ch.findArea((int) (point.getX() + 0.5), (int) (point.getY() + 0.5), 1 << orientation);
    }

    public void updateMouseMoving(int x, int y, CEvent clicked) {
        CGPoint point = getHardwareToVirtual(x, y, false);
        clicked.getOwner().setActive((int) (point.getX() + 0.5), (int) (point.getY() + 0.5), 1 << orientation);
    }

    @Override
    public CGPoint getHardwareToVirtual(double x, double y) {
        return getHardwareToVirtual(x, y, true);
    }

    @Override
    public CGPoint getVirtualToHardware(double x, double y) {
        return getVirtualToHardware(x, y, scaleOnX, scaleOnY, outsetLeft, outsetTop);
    }

    protected CGPoint getHardwareToVirtual(double x, double y, boolean useOutset) {
        switch (orientation) {
            case LandscapeRight:
                return new CGPoint((y - (useOutset ? outsetLeft : 0)) / scaleOnX, (frameWidth - x - (useOutset ? outsetTop : 0)) / scaleOnY);
            case LandscapeLeft:
                return new CGPoint((frameHeight - y - (useOutset ? outsetLeft : 0)) / scaleOnX, (x - (useOutset ? outsetTop : 0)) / scaleOnY);
            case PortraitUpsideDown:
                return new CGPoint((frameWidth - x - (useOutset ? outsetLeft : 0)) / scaleOnX, (frameHeight - y - (useOutset ? outsetTop : 0)) / scaleOnY);
            case Portrait:
            default:
                return new CGPoint((x - (useOutset ? outsetLeft : 0)) / scaleOnX, (y - (useOutset ? outsetTop : 0)) / scaleOnY);
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

    public boolean isFullScreen() {
        return chassis().isFullscreen();
    }

    public boolean isSimulator() {
        return chassis().isSimulator();
    }

    public boolean isStretched() {
        return chassis().screen().isStretched();
    }

    public boolean isWithStatusBar() {
        return chassis().screen().isWithStatusBar();
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
}
