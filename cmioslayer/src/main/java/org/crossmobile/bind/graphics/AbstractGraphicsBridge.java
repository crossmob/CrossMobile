/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics;

import crossmobile.ios.coregraphics.CGAffineTransform;
import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.uikit.*;
import org.crossmobile.bind.graphics.theme.ThemeFactory;
import org.crossmobile.bind.graphics.theme.ThemeManager;
import org.crossmobile.bridge.GraphicsBridge;
import org.crossmobile.bridge.Native;

import static crossmobile.ios.uikit.UIDeviceOrientation.*;

public abstract class AbstractGraphicsBridge<CANVAS, TRANSF> implements GraphicsBridge<CANVAS, TRANSF> {

    public static int DrawingDepth;    // Use this variable for debugging, to check the depth of UIView we are currently drawing

    private final RefreshRunnable refresh = new RefreshRunnable();
    private final DrawableMetrics metrics = newMetrics();
    private final ThemeManager themeManager;

    {
        try {
            themeManager = ThemeFactory.createManager();
        } catch (Throwable e) {
            throw new RuntimeException("Unable to initialize theme manager");
        }
    }

    @Override
    public DrawableMetrics metrics() {
        return metrics;
    }

    @Override
    public ThemeManager themeManager() {
        return themeManager;
    }

    @Override
    public void refreshDisplay() {
        if (!refresh.isStillPending) {
            refresh.isStillPending = true;
            Native.lifecycle().runOnEventThread(refresh);
        }
    }

    private class RefreshRunnable implements Runnable {

        private boolean isStillPending = false;

        @Override
        public void run() {
            isStillPending = false; // let it roll
            requestRepaint();
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public synchronized void relayoutMainView() {
        UIApplication app = UIApplication.sharedApplication();
        if (app == null)
            return;
        UIWindow win = UserInterfaceDrill.splashWindow();
        if (win == null)
            win = app.keyWindow();
        if (win == null)
            return;
        final UIViewController vc = win.rootViewController();
        if (vc == null)
            return;
        UIView view = vc.view();
        CGRect appframe = UIScreen.mainScreen().applicationFrame();
        boolean isWide = metrics.orientation == LandscapeLeft || metrics.orientation == LandscapeRight;
        double width = isWide ? appframe.getSize().getHeight() : appframe.getSize().getWidth();
        double height = isWide ? appframe.getSize().getWidth() : appframe.getSize().getHeight();

        CGRect frame = new CGRect(appframe.getOrigin().getX() + (appframe.getSize().getWidth() - width) / 2, appframe.getOrigin().getY() + (appframe.getSize().getHeight() - height) / 2, width, height);
        view.setFrame(frame);
        view.layoutSubviews();
        switch (metrics.orientation) {
            case LandscapeRight:
                view.setTransform(CGAffineTransform.makeRotation(-GraphicsContext._PI_2));
                break;
            case LandscapeLeft:
                view.setTransform(CGAffineTransform.makeRotation(GraphicsContext._PI_2));
                break;
            case PortraitUpsideDown:
                view.setTransform(CGAffineTransform.makeRotation(GraphicsContext._PI));
                break;
            case Portrait:
            default:
                view.setTransform(null);
                break;
        }
        app.setStatusBarOrientation(metrics().getOrientation(), false);
    }

    protected abstract void requestRepaint();

    protected abstract DrawableMetrics newMetrics();
}
