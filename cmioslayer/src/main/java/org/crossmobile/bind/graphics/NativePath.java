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

public interface NativePath {

    void moveTo(double x, double y);

    void lineTo(double x, double y);

    void close();

    void quadTo(double cpx, double cpy, double x, double y);

    void cubicTo(double cp1x, double cp1y, double cp2x, double cp2y, double x, double y);

    void arcTo(double x, double y, double radius, double startAngle, double extend);
}
