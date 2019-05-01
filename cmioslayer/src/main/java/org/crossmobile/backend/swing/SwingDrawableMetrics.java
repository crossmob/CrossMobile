/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.crossmobile.backend.swing;

import org.crossmobile.backend.desktop.DesktopDrawableMetrics;
import org.crossmobile.backend.desktop.DesktopGraphicsBridge;
import org.crossmobile.bind.graphics.GraphicsContext;

import java.awt.*;

public class SwingDrawableMetrics extends DesktopDrawableMetrics {

    @Override
    public void preDraw(GraphicsContext ctx) {
        Graphics2D g = ((SwingGraphicsContext) ctx).g2;
        DesktopGraphicsBridge.setHighQuality(g, true);
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
