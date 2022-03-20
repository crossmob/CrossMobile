/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.desktop;

import org.crossmobile.backend.desktop.cgeo.CDrawable;
import org.crossmobile.bind.graphics.AbstractGraphicsBridge;
import org.crossmobile.bind.graphics.GraphicsBridgeConstants;
import org.crossmobile.bind.graphics.GraphicsContext;
import org.crossmobile.bridge.GraphicsBridge;
import org.crossmobile.bridge.Native;

public abstract class DesktopGraphicsBridge<CANVAS, TRANSF> extends AbstractGraphicsBridge<CANVAS, TRANSF> {

    @Override
    public void setOrientation(int orientation) {
        Native.graphics().metrics().setOrientationMetrics(orientation);
        DesktopDrawableMetrics metrics = (DesktopDrawableMetrics) metrics();
        resizeWindow(metrics.getOrientedFrameWidth(), metrics.getOrientedFrameHeight());
        Native.graphics().relayoutMainView();
    }

    protected abstract void resizeWindow(int width, int height);

    public static void rotateDevice(boolean clockwise) {
        GraphicsBridge<?, ?> graphicsBridge = Native.graphics();
        int orientation = graphicsBridge.metrics().getOrientation();
        for (int i = 0; i < 4; i++) {
            orientation += clockwise ? 1 : -1;
            if (orientation > 4)
                orientation = 1;
            if (orientation < 1)
                orientation = 4;
            if (GraphicsBridgeConstants.shouldAcceptOrientation(orientation)) {
                graphicsBridge.setOrientation(orientation);
                return;
            }
        }
    }

    public abstract void draw(CDrawable drawable, GraphicsContext<?> cxt, int orientation);
}
