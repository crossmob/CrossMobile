/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.coregraphics;

import org.crossmobile.bind.graphics.NativePath;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

import static org.crossmobile.bind.graphics.Geometry.apply;
import static org.crossmobile.bind.graphics.GraphicsContext.*;

/**
 * CGPath class defines an object that represents a graphic path.
 */
@CMReference(typeAlias = "CGMutablePath")
public class CGPath {

    final NativePath path = Native.graphics().newNativePath();
    private double lastX = 0;
    private double lastY = 0;
    private boolean pathStarted = false;
    private double firstX = 0;
    private double firstY = 0;

    /**
     * The default constructor of the CGPath.
     */
    @CMConstructor(" CGMutablePathRef CGPathCreateMutable ( void ); ")
    public CGPath() {
    }

    /**
     * Return the last point of this path
     *
     * @return The last point
     */
    @CMFunction("CGPoint CGPathGetCurrentPoint(CGPathRef path);")
    public CGPoint getCurrentPoint() {
        return new CGPoint(lastX, lastY);
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
        path.moveTo(lastX = x, lastY = y);
    }

    /**
     * Add a line segment to this path.
     *
     * @param transf The affine transformation
     * @param x      The x value of the end point of the line segment
     * @param y      The y value of the end point of the line segment
     * @see crossmobile.ios.coregraphics.CGAffineTransform
     */
    @CMFunction(" void CGPathAddLineToPoint ( CGMutablePathRef path, const CGAffineTransform *m, CGFloat x, CGFloat y ); ")
    public void addLineToPoint(@CMParamMod(byRef = true) CGAffineTransform transf, double x, double y) {
        if (transf != null) {
            CGPoint buf = apply(transf, new CGPoint(x, y));
            x = buf.getX();
            y = buf.getY();
        }
        if (!pathStarted) {
            pathStarted = true;
            firstX = lastX;
            firstY = lastY;
        }
        path.lineTo(lastX = x, lastY = y);
    }

    /**
     * Add a list of lines to the path. This is equal to add the lines one by one with {@link #addLineToPoint(CGAffineTransform, double, double)}
     *
     * @param transf The affine transformation
     * @param points The list of the lines to add to this path
     */
    @CMFunction("void CGPathAddLines(CGMutablePathRef path, const CGAffineTransform *m, const CGPoint *points, size_t count);")
    public void addLines(@CMParamMod(byRef = true) CGAffineTransform transf, @CMJoinMEM(memory = "points", size = "count") CGPoint... points) {
        if (points != null && points.length > 0)
            for (CGPoint p : points)
                if (p != null)
                    addLineToPoint(transf, p.getX(), p.getY());
    }

    private void addArc(NativePath path, double x, double y, double radiusX, double radiusY, double startAngle, double endAngle, boolean clockwise) {
        if (clockwise) {
            double swap = startAngle;
            startAngle = endAngle;
            endAngle = swap;
        }
        double diff = endAngle - startAngle;
        if (diff < 0) {
            diff %= _2_PI;
            if (diff < 0)
                diff += _2_PI;
        }

        if (!pathStarted) {
            pathStarted = true;
            firstX = lastX;
            firstY = lastY;
        }
        lastX = x + radiusX * Math.cos(endAngle);
        lastY = y + radiusY * Math.sin(endAngle);
        path.arcTo(x, y, radiusX, radiusY, endAngle, -diff);
    }

    /**
     * Add an arc to this path.
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
        addArc(path, x, y, radius, radius, startAngle, endAngle, clockwise);
    }

//    @CMFunction("void CGPathAddRelativeArc(CGMutablePathRef path, const CGAffineTransform *matrix, CGFloat x, CGFloat y, CGFloat radius, CGFloat startAngle, CGFloat delta);")
//    public void addRelativeArc(@CMParamMod(byRef = true) CGAffineTransform transf, double x, double y, double radius, double startAngle, double delta) {
//        double s = startAngle;
//        startAngle %= _2_PI;
//        if (startAngle < 0)
//            startAngle += _2_PI;
//        addArc(transf, x, y, radius, startAngle, startAngle + (delta > 0 ? delta : -delta), delta < 0);
//    }

    /**
     * Add an arc with specific radius and given tangent lines
     *
     * @param transf The affine transformation
     * @param x1     The x value of the point of the 1st tangent line
     * @param y1     The y value of the point of the 1st tangent line
     * @param x2     The x value of the point of the 2nd tangent line
     * @param y2     The y value of the point of the 2nd tangent line
     * @param radius The radius of the arc
     */
    @CMFunction("void CGPathAddArcToPoint(CGMutablePathRef path, const CGAffineTransform *m, CGFloat x1, CGFloat y1, CGFloat x2, CGFloat y2, CGFloat radius);")
    public void addArcToPoint(@CMParamMod(byRef = true) CGAffineTransform transf, double x1, double y1, double x2, double y2, double radius) {
        if (transf != null) {
            CGPoint buf = apply(transf, new CGPoint(x1, y1));
            x1 = buf.getX();
            y1 = buf.getY();
            buf.set(x2, y2);
            buf.applyAffineTransform(transf);
            x2 = buf.getX();
            y2 = buf.getY();
        }
        if (!pathStarted) {
            lastX = x2;
            lastY = y2;
            return;
        }

        double thStart = Math.atan2(lastY - y1, lastX - x1);
        double thEnd = Math.atan2(y2 - y1, x2 - x1);
        double th = thEnd - thStart;
        double cot = 1d / Math.tan(th / 2);
        double fEnd = radius * cot / Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        double fStart = radius * cot / Math.sqrt((lastX - x1) * (lastX - x1) + (lastY - y1) * (lastY - y1));
        double ax = x1 + fStart * (lastX - x1);
        double ay = y1 + fStart * (lastY - y1);
        double bx = x1 + fEnd * (x2 - x1);
        double by = y1 + fEnd * (y2 - y1);

        double D = Math.sqrt((ax - x1) * (ax - x1) + (ay - y1) * (ay - y1)) / Math.cos(th / 2);
        double oX = D * Math.cos((thStart + thEnd) / 2);
        double oY = D * Math.sin((thStart + thEnd) / 2);


        addLineToPoint(null, ax, ay);
        addArc(null, oX, oY, radius, thStart, thEnd, th < 0);
        addLineToPoint(null, x2, y2);
        Native.system().notImplemented();

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
     * @param y      The y value of the end point of the curve.
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
        if (!pathStarted) {
            pathStarted = true;
            firstX = lastX;
            firstY = lastY;
        }
        path.cubicTo(cp1x, cp1y, cp2x, cp2y, lastX = x, lastY = y);
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
        if (!pathStarted) {
            pathStarted = true;
            firstX = lastX;
            firstY = lastY;
        }
        path.quadTo(cpx, cpy, lastX = x, lastY = y);
    }

    /**
     * Add a rectangular area to this path
     *
     * @param transf The affine transformation
     * @param rect   the rectangle to add to this path
     */
    @CMFunction("void CGPathAddRect(CGMutablePathRef path, const CGAffineTransform *m, CGRect rect);")
    public void addRect(@CMParamMod(byRef = true) CGAffineTransform transf, CGRect rect) {
        double x1 = rect.getOrigin().getX();
        double y1 = rect.getOrigin().getY();
        double x3 = x1 + rect.getSize().getWidth();
        double y3 = y1 + rect.getSize().getHeight();
        double x2 = x3;
        double y2 = y1;
        double x4 = x1;
        double y4 = y3;
        if (transf != null) {
            CGPoint b = apply(transf, new CGPoint(x1, y1));
            x1 = b.getX();
            y1 = b.getY();

            b.set(x2, y2);
            apply(transf, b);
            x2 = b.getX();
            y2 = b.getY();

            b.set(x3, y3);
            apply(transf, b);
            x3 = b.getX();
            y3 = b.getY();

            b.set(x4, y4);
            apply(transf, b);
            x4 = b.getX();
            y4 = b.getY();
        }
        moveToPoint(null, x1, y1);
        addLineToPoint(null, x2, y2);
        addLineToPoint(null, x3, y3);
        addLineToPoint(null, x4, y4);
        closeSubpath();
    }

    /**
     * Add a list of rectangles to this path. This is equal to add the rectangles one by one with
     * {@link #addRect(CGAffineTransform, CGRect)}
     *
     * @param transf The affine transformation
     * @param rects  The list of rectangles
     */
    @CMFunction("void CGPathAddRects(CGMutablePathRef path, const CGAffineTransform *m, const CGRect *rects, size_t count);")
    public void addRects(@CMParamMod(byRef = true) CGAffineTransform transf, @CMJoinMEM(memory = "rects", size = "count") CGRect... rects) {
        if (rects != null)
            for (CGRect rect : rects)
                if (rect != null)
                    addRect(transf, rect);
    }

    /**
     * @param transf       The affine transformation
     * @param rect         The rectangle to add to this path
     * @param cornerWidth  The width of the rounded corner
     * @param cornerHeight The hight of the rounded corner
     */
    @CMFunction("void CGPathAddRoundedRect(CGMutablePathRef path, const CGAffineTransform *transform, CGRect rect, CGFloat cornerWidth, CGFloat cornerHeight);")
    public void addRoundedRect(@CMParamMod(byRef = true) CGAffineTransform transf, CGRect rect, double cornerWidth, double cornerHeight) {
        double xLeft = rect.getOrigin().getX();
        double yTop = rect.getOrigin().getY();
        double xRight = xLeft + rect.getSize().getWidth();
        double yBottom = yTop + rect.getSize().getHeight();
        lastX = xLeft;
        lastY = yTop;
        NativePath c = transf == null ? this.path : Native.graphics().newNativePath();
        c.moveTo(xRight - cornerWidth, yTop);
        c.lineTo(xLeft + cornerWidth, yTop);
        addArc(c, xLeft + cornerWidth, yTop + cornerHeight, cornerWidth, cornerHeight, _3_PI_2, _PI, true);
        c.lineTo(xLeft, yBottom - cornerHeight);
        addArc(c, xLeft + cornerWidth, yBottom - cornerHeight, cornerWidth, cornerHeight, _PI, _PI_2, true);
        c.lineTo(xRight - cornerWidth, yBottom);
        addArc(c, xRight - cornerWidth, yBottom - cornerHeight, cornerWidth, cornerHeight, _PI_2, 0d, true);
        c.lineTo(xRight, yTop + cornerHeight);
        addArc(c, xRight - cornerWidth, yTop + cornerHeight, cornerWidth, cornerHeight, 0d, -_PI_2, true);
        c.close();
        if (c != this.path) path.addPath(c, transf);
    }

    /**
     * Add an ellipse to this path
     *
     * @param transf The affine transformation
     * @param rect   The bounding box which defines this ellipse
     */
    @CMFunction("void CGPathAddEllipseInRect(CGMutablePathRef path, const CGAffineTransform *m, CGRect rect);")
    public void addEllipseInRect(@CMParamMod(byRef = true) CGAffineTransform transf, CGRect rect) {
        CGPoint p = new CGPoint(rect.getOrigin().getX(), rect.getOrigin().getY() + rect.getSize().getHeight() / 2);
        if (transf != null)
            p.applyAffineTransform(transf);
        lastX = p.getX();
        lastY = p.getY();

        NativePath c = transf == null ? this.path : Native.graphics().newNativePath();
        c.addEllipse(rect.getOrigin().getX(), rect.getOrigin().getY(), rect.getSize().getWidth(), rect.getSize().getHeight());
        if (c != this.path) path.addPath(c, transf);
    }

    /**
     * Add another path to this path
     *
     * @param transf The affine transformation
     * @param path2  The new path to add to this path
     */
    @CMFunction("void CGPathAddPath(CGMutablePathRef path1, const CGAffineTransform *m, CGPathRef path2);")
    public void addPath(@CMParamMod(byRef = true) CGAffineTransform transf, CGPath path2) {
        if (path2 != null) {
            path.addPath(path2.path, transf);
            lastX = path2.lastX;
            lastY = path2.lastY;
        }
    }


    /**
     * Closes a subpath.
     */
    @CMFunction(" void CGPathCloseSubpath ( CGMutablePathRef path ); ")
    public void closeSubpath() {
        if (pathStarted) {
            lastX = firstX;
            lastY = firstY;
            pathStarted = false;
        }
        path.close();
    }
}
