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

import crossmobile.ios.coregraphics.CGAffineTransform;
import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.uikit.*;
import org.crossmobile.bridge.GraphicsBridge;
import org.crossmobile.bridge.Native;

import static crossmobile.ios.uikit.UIDeviceOrientation.*;

public abstract class AbstractGraphicsBridge<CANVAS, NTVP, TRANSF> implements GraphicsBridge<CANVAS, NTVP, TRANSF> {

    public static int DrawingDepth;    // Use this variable for debuggin, to check the depth of UIView we are currently drawing

    private final RefreshRunnable refresh = new RefreshRunnable();
    private final DrawableMetrics metrics = newMetrics();

    @Override
    public DrawableMetrics metrics() {
        return metrics;
    }

    @Override
    public void refreshDisplay() {
        if (!refresh.isStillPending) {
            refresh.isStillPending = true;
            Native.system().runOnEventThread(refresh);
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

    @Override
    public synchronized void relayoutMainView() {
        UIApplication app = UIApplication.sharedApplication();
        if (app == null)
            return;
        UIWindow win = $uikit.splashWindow();
        if (win == null)
            win = app.keyWindow();
        if (win == null)
            return;
        final UIViewController vc = win.rootViewController();
        if (vc == null)
            return;
        UIView view = vc.view();
        Runnable actions = () -> {
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
        };
        actions.run();
    }

    protected abstract void requestRepaint();

    protected abstract DrawableMetrics newMetrics();
}
