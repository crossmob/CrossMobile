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
package org.crossmobile.backend.android;

import android.graphics.Path;
import android.graphics.RectF;
import org.crossmobile.bind.graphics.NativePath;

import static org.crossmobile.bind.graphics.GraphicsContext.PI_TO_DEG;

public class AndroidNativePath extends Path implements NativePath {

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
    public void arcTo(double x, double y, double radius, double startAngle, double extend) {
        arcTo(new RectF((float) (x - radius), (float) (y - radius), (float) (x + radius), (float) (y + radius)), (float) (-startAngle * PI_TO_DEG), (float) (-extend * PI_TO_DEG));
    }
}
