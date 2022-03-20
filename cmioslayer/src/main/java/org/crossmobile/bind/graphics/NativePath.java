/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics;

import crossmobile.ios.coregraphics.CGAffineTransform;

public interface NativePath {

    void addPath(NativePath path, CGAffineTransform transform);

    void moveTo(double x, double y);

    void lineTo(double x, double y);

    void close();

    void quadTo(double cpx, double cpy, double x, double y);

    void cubicTo(double cp1x, double cp1y, double cp2x, double cp2y, double x, double y);

    void arcTo(double x, double y, double xRadius, double yRadius, double startAngle, double extend);

    void addEllipse(double x, double y, double width, double height);

}
