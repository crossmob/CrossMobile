/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.swing;

import org.crossmobile.backend.desktop.DesktopDrawableMetrics;
import org.crossmobile.bind.graphics.GraphicsContext;

import java.awt.*;

public class SwingDrawableMetrics extends DesktopDrawableMetrics {

    @Override
    public void preDraw(GraphicsContext<?> ctx) {
        SwingGraphicsBridge.defaultGraphics = ((SwingGraphicsContext) ctx).g2;
        SwingGraphicsBridge.defaultGraphics.setComposite(AlphaComposite.SrcOver);
        super.preDraw(ctx);
    }
}
