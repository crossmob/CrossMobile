/*
 * (c) 2020 by Panayotis Katsaloulis
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
