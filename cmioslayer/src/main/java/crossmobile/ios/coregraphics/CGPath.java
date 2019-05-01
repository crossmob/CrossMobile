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
package crossmobile.ios.coregraphics;

import org.crossmobile.bind.graphics.GraphicsContext;
import org.crossmobile.bind.graphics.NativePath;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMFunction;
import org.crossmobile.bridge.ann.CMParamMod;
import org.crossmobile.bridge.ann.CMReference;

import static org.crossmobile.bind.graphics.Geometry.apply;

/**
 * CGPath class defines an object that represents a graphic path.
 */
@CMReference(alias = "CGMutablePath")
public class CGPath {

    final NativePath path = Native.graphics().newNativePath();

    /**
     * The default constructor of the CGPath.
     */
    @CMConstructor(" CGMutablePathRef CGPathCreateMutable ( void ); ")
    public CGPath() {
    }

    /**
     * Attaches a subpath at the specified location of this path.
     *
     * @param transf The affine transformation.
     * @param x      The x value of the point at which the subpath is attached.
     * @param y      The y value of the point at which the subpath is attached.
     * @see crossmobile.ios.coregraphics.CGAffineTransform
     */
    @CMFunction(" void CGPathMoveToPoint ( CGMutablePathRef path, const CGAffineTransform *m, CGFloat x, CGFloat y ); ")
    public void moveToPoint(@CMParamMod(byRef = true) CGAffineTransform transf, double x, double y) {
        if (transf != null) {
            CGPoint buf = apply(transf, new CGPoint(x, y));
            x = buf.getX();
            y = buf.getY();
        }
        path.moveTo(x, y);
    }

    /**
     * Add a line segment to this path.
     *
     * @param transf The affine transformation.
     * @param x      The x value of the end point of the line segment.
     * @param y      The y value of the end point of the line segment.
     * @see crossmobile.ios.coregraphics.CGAffineTransform
     */
    @CMFunction(" void CGPathAddLineToPoint ( CGMutablePathRef path, const CGAffineTransform *m, CGFloat x, CGFloat y ); ")
    public void addLineToPoint(@CMParamMod(byRef = true) CGAffineTransform transf, double x, double y) {
        if (transf != null) {
            CGPoint buf = apply(transf, new CGPoint(x, y));
            x = buf.getX();
            y = buf.getY();
        }
        path.lineTo(x, y);
    }

    /**
     * Applies an arc to this path.
     *
     * @param transf     The affine transformation.
     * @param x          The x value of the end point of the curve.
     * @param y          The y value of the end point of the curve.
     * @param radius     The radius of the arc.
     * @param startAngle The beginning of the angle.
     * @param endAngle   The end of the angle.
     * @param clockwise  The clockwise rotation of the angle.
     * @see crossmobile.ios.coregraphics.CGAffineTransform
     */
    @CMFunction(" void CGPathAddArc ( CGMutablePathRef path, const CGAffineTransform *m, CGFloat x, CGFloat y, CGFloat radius, CGFloat startAngle, CGFloat endAngle, bool clockwise ); ")
    public void addArc(@CMParamMod(byRef = true) CGAffineTransform transf, double x, double y, double radius, double startAngle, double endAngle, boolean clockwise) {
        if (transf != null) {
            CGPoint buf = apply(transf, new CGPoint(x, y));
            x = buf.getX();
            y = buf.getY();
        }
        startAngle = -startAngle;
        endAngle = -endAngle;
        startAngle %= GraphicsContext._2_PI;
        if (startAngle < 0)
            startAngle += GraphicsContext._2_PI;
        endAngle %= GraphicsContext._2_PI;
        if (endAngle < 0)
            endAngle += GraphicsContext._2_PI;
        double diff = endAngle - startAngle;
        if (diff < 0)
            diff += GraphicsContext._2_PI;
        if (!clockwise)
            diff -= GraphicsContext._2_PI;

        path.arcTo(x, y, radius, startAngle, diff);
    }

    /**
     * Applies a Bézier curve to this path.
     *
     * @param transf The affine transformation.
     * @param cp1x   The x value of the 1st control point.
     * @param cp1y   The y value of the 1st control point.
     * @param cp2x   The x value of the 2nd control point.
     * @param cp2y   The y value of the 2nd control point.
     * @param x      The x value of the end point of the curve.
     * @param y      The x value of the end point of the curve.
     * @see crossmobile.ios.coregraphics.CGAffineTransform
     */
    @CMFunction(" void CGPathAddCurveToPoint ( CGMutablePathRef path, const CGAffineTransform *m, CGFloat cp1x, CGFloat cp1y, CGFloat cp2x, CGFloat cp2y, CGFloat x, CGFloat y );")
    public void addCurveToPoint(@CMParamMod(byRef = true) CGAffineTransform transf, double cp1x, double cp1y, double cp2x, double cp2y, double x, double y) {
        if (transf != null) {
            CGPoint cp1 = apply(transf, new CGPoint(cp1x, cp1y));
            CGPoint cp2 = apply(transf, new CGPoint(cp2x, cp2y));
            CGPoint p = apply(transf, new CGPoint(x, y));
            cp1x = cp1.getX();
            cp1y = cp1.getY();
            cp2x = cp2.getX();
            cp2y = cp2.getY();
            x = p.getX();
            y = p.getY();
        }
        path.cubicTo(cp1x, cp1y, cp2x, cp2y, x, y);
    }

    /**
     * Applies a quadric Bézier curve to this path.
     *
     * @param transf The affine transformation.
     * @param cpx    The x-value control point of the curve.
     * @param cpy    The y-value control point of the curve.
     * @param x      The x-value end point of the curve.
     * @param y      The y-value end point of the curve.
     * @see crossmobile.ios.coregraphics.CGAffineTransform
     */
    @CMFunction(" void CGPathAddQuadCurveToPoint ( CGMutablePathRef path, const CGAffineTransform *m, CGFloat cpx, CGFloat cpy, CGFloat x, CGFloat y ); ")
    public void addQuadCurveToPoint(@CMParamMod(byRef = true) CGAffineTransform transf, double cpx, double cpy, double x, double y) {
        if (transf != null) {
            CGPoint cp = apply(transf, new CGPoint(cpx, cpy));
            CGPoint p = apply(transf, new CGPoint(x, y));
            cpx = cp.getX();
            cpy = cp.getY();
            x = p.getX();
            y = p.getY();
        }
        path.quadTo(cpx, cpy, x, y);
    }

    /**
     * Closes a subpath.
     */
    @CMFunction(" void CGPathCloseSubpath ( CGMutablePathRef path ); ")
    public void closeSubpath() {
        path.close();
    }
}
