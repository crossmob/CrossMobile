/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
