/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.swing;

import org.crossmobile.backend.desktop.DesktopDrawableMetrics;
import org.crossmobile.bind.graphics.GraphicsContext;

import java.awt.*;

public class SwingDrawableMetrics extends DesktopDrawableMetrics {

    @Override
    public void preDraw(GraphicsContext ctx) {
        Graphics2D g = ((SwingGraphicsContext) ctx).g2;
        g.setComposite(AlphaComposite.SrcOver);
        g.rotate(skinRotate);
        g.translate(skinTranslateX, skinTranslateY);
        chassis().draw(ctx, false, 1 << orientation);
        ctx.saveState();    // will restore in postDraw
        g.translate(outsetLeft, outsetTop);
        super.preDraw(ctx);
        ctx.clipToRect(clipping);
    }

    @Override
    public void postDraw(GraphicsContext ctx) {
        ctx.restoreState(); // did save in preDraw
        chassis().draw(ctx, true, 1 << orientation);
    }

}
