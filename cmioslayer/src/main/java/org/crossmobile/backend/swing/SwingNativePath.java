/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.swing;

import org.crossmobile.bind.graphics.NativePath;

import java.awt.geom.Arc2D;
import java.awt.geom.Path2D;

import static org.crossmobile.bind.graphics.GraphicsContext.PI_TO_DEG;

public class SwingNativePath extends Path2D.Double implements NativePath {

    @Override
    public void close() {
        closePath();
    }

    @Override
    public void arcTo(double x, double y, double radius, double startAngle, double extend) {
        this.append(new Arc2D.Double(x - radius, y - radius, radius * 2, radius * 2, startAngle * PI_TO_DEG, extend * PI_TO_DEG, Arc2D.PIE), true);
    }

    @Override
    public void cubicTo(double cp1x, double cp1y, double cp2x, double cp2y, double x, double y) {
        curveTo(cp1x, cp1y, cp2x, cp2y, x, y);
    }
}
