/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.swing;

import crossmobile.ios.coregraphics.CGAffineTransform;
import org.crossmobile.bind.graphics.NativePath;
import org.crossmobile.bridge.Native;

import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;

import static org.crossmobile.bind.graphics.GraphicsContext.PI_TO_DEG;

public final class SwingNativePath extends Path2D.Double implements NativePath {

    @Override
    public void addPath(NativePath path, CGAffineTransform transform) {
        if (transform == null)
            append(((SwingNativePath) path), false);
        else {
            AffineTransform tr = ((SwingGraphicsBridge) Native.graphics()).targetToNative(transform, null);
            append(((SwingNativePath) path).getPathIterator(tr), false);
        }
    }

    @Override
    public void close() {
        closePath();
    }

    @Override
    public void arcTo(double x, double y, double xRadius, double yRadius, double startAngle, double extend) {
        this.append(new Arc2D.Double(x - xRadius, y - yRadius, xRadius * 2, yRadius * 2, -startAngle * PI_TO_DEG, -extend * PI_TO_DEG, Arc2D.OPEN), true);
    }

    @Override
    public void cubicTo(double cp1x, double cp1y, double cp2x, double cp2y, double x, double y) {
        curveTo(cp1x, cp1y, cp2x, cp2y, x, y);
    }

    @Override
    public void addEllipse(double x, double y, double width, double height) {
        append(new Ellipse2D.Double(x, y, width, height), false);
    }
}
