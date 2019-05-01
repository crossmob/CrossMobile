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
package org.crossmobile.bind.graphics;

public interface NativePath {

    void moveTo(double x, double y);

    void lineTo(double x, double y);

    void close();

    void quadTo(double cpx, double cpy, double x, double y);

    void cubicTo(double cp1x, double cp1y, double cp2x, double cp2y, double x, double y);

    void arcTo(double x, double y, double radius, double startAngle, double extend);
}
