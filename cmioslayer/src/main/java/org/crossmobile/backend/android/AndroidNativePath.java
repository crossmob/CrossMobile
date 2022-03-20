/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.graphics.Path;
import android.graphics.RectF;
import crossmobile.ios.coregraphics.CGAffineTransform;
import org.crossmobile.bind.graphics.NativePath;
import org.crossmobile.bridge.Native;

import static org.crossmobile.bind.graphics.GraphicsContext.PI_TO_DEG;
import static org.crossmobile.bind.graphics.GraphicsContext._2_PI;

public final class AndroidNativePath extends Path implements NativePath {

    @Override
    public void addPath(NativePath path, CGAffineTransform transform) {
        if (transform == null)
            addPath((Path) path);
        else
            addPath((Path) path, ((AndroidGraphicsBridge) Native.graphics()).targetToNative(transform, null));
    }

    @Override
    public void moveTo(double x, double y) {
        moveTo((float) x, (float) y);
    }

    @Override
    public void lineTo(double x, double y) {
        lineTo((float) x, (float) y);
    }

    @Override
    public void quadTo(double cpx, double cpy, double x, double y) {
        quadTo((float) cpx, (float) cpy, (float) x, (float) y);
    }

    @Override
    public void cubicTo(double cp1x, double cp1y, double cp2x, double cp2y, double x, double y) {
        cubicTo((float) cp1x, (float) cp1y, (float) cp2x, (float) cp2y, (float) x, (float) y);
    }

    @Override
    public void arcTo(double x, double y, double xRadius, double yRadius, double startAngle, double extend) {
        if ((float) extend >= (float) _2_PI) // have to do this since there's a bug in Android code
            addEllipse(x - xRadius, y - yRadius, xRadius * 2, yRadius * 2);
        else
            arcTo(new RectF((float) (x - xRadius), (float) (y - yRadius), (float) (x + xRadius), (float) (y + yRadius)), (float) (startAngle * PI_TO_DEG), (float) (extend * PI_TO_DEG));
    }

    @Override
    public void addEllipse(double x, double y, double width, double height) {
        addOval((float) x, (float) y, (float) (x + width), (float) (y + height), Direction.CW);
    }
}
