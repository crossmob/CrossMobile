/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.coregraphics;

import crossmobile.ios.foundation.CFType;
import org.crossmobile.bind.graphics.GraphicsContext;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMFunction;
import org.crossmobile.bridge.ann.CMJoinMEM;
import org.crossmobile.bridge.ann.CMReference;

import static crossmobile.ios.coregraphics.CGColorSpace.createDeviceRGB;

/**
 * CGContext class defines an object that represents the graphics context of the
 * application. It contains related parameters and methods for drawing objects
 * of the application such as color filling, adding shadows and stroke lines.
 */
@SuppressWarnings("unused")
@CMReference
public class CGContext extends CFType {

    @SuppressWarnings("rawtypes")
    final GraphicsContext context;
    private CGPath path;
    private final CGPoint textPosition = CGPoint.zero();
    private double alpha = 1;
    @SuppressWarnings("FieldCanBeLocal")
    private CGColorSpace strokeColorSpace = null;
    private CGColorSpace fillColorSpace = null;

    @SuppressWarnings({"OverridableMethodCallInConstructor", "rawtypes"})
    CGContext(GraphicsContext context) {
        this.context = context;
    }

    /**
     * Changes user's coordinate system according to the specified
     * transformation matrix.
     *
     * @param transform The transformation matrix.
     * @see crossmobile.ios.coregraphics.CGAffineTransform
     */
    @SuppressWarnings("unchecked")
    @CMFunction(" void CGContextConcatCTM ( CGContextRef c, CGAffineTransform transform ); ")
    public void concatCTM(CGAffineTransform transform) {
        if (transform != null)
            context.concatCTM(Native.graphics().targetToNative(transform, null));
    }

    /**
     * Retrieves the current transformation matrix of this graphics context.
     *
     * @return The current transformation matrix of this graphics context.
     */
    @CMFunction(" CGAffineTransform CGContextGetCTM ( CGContextRef c ); ")
    public CGAffineTransform getCTM() {
        return context.getCTM();
    }

    /**
     * Rotates user's coordinate system for this graphics context.
     *
     * @param theta The rotation angle in radians.
     */
    @CMFunction(" void CGContextRotateCTM ( CGContextRef c, CGFloat angle ); ")
    public void rotateCTM(double theta) {
        context.rotate(theta);
    }

    /**
     * Changes current scale of user's coordinate system of this graphics
     * context.
     *
     * @param sx The scale factor of the x axis.
     * @param sy The scale factor of the y axis.
     */
    @CMFunction(" void CGContextScaleCTM ( CGContextRef c, CGFloat sx, CGFloat sy ); ")
    public void scaleCTM(double sx, double sy) {
        context.scale(sx, sy);
    }

    /**
     * Changes user's origin within this graphics context.
     *
     * @param tx The x-value of the origin.
     * @param ty The y-value of the origin.
     */
    @CMFunction(" void CGContextTranslateCTM ( CGContextRef c, CGFloat tx, CGFloat ty ); ")
    public void translateCTM(double tx, double ty) {
        context.translate(tx, ty);
    }

    /**
     * Saves the current graphic state of this graphics context to the graphic
     * state stack.
     */
    @CMFunction(" void CGContextSaveGState ( CGContextRef c ); ")
    public void saveGState() {
        context.saveState();
    }

    /**
     * Restores the previous graphic state of this graphics context.
     */
    @CMFunction(" void CGContextRestoreGState ( CGContextRef c ); ")
    public void restoreGState() {
        context.restoreState();
    }

    /**
     * Sets the opacity for drawing in this graphics context.
     *
     * @param alpha The opacity of this graphic context.
     */
    @CMFunction(" void CGContextSetAlpha ( CGContextRef c, CGFloat alpha ); ")
    public void setAlpha(double alpha) {
        if (this.alpha != alpha) {
            this.alpha = alpha;
            context.setAlpha(alpha);
        }
    }

    /**
     * Draws the specified image within the given rectangle of this graphics
     * context.
     *
     * @param rect  The rectangle within which the image is drawn.
     * @param image The image to be drawn.
     */
    @CMFunction(" void CGContextDrawImage ( CGContextRef c, CGRect rect, CGImageRef image ); ")
    public void drawImage(CGRect rect, CGImage image) {
        if (image != null && rect != null)
            context.drawBitmap(image.bitmap(), (int) (rect.getOrigin().getX()), (int) (rect.getOrigin().getY()), (int) (rect.getSize().getWidth()), (int) (rect.getSize().getHeight()));
    }

    /**
     * Sets the stroke color of this graphics context defined by the specified
     * components.
     *
     * @param components The components that specify the stroke color of this
     *                   graphics context.
     */
    @CMFunction(" void CGContextSetStrokeColor ( CGContextRef c, const CGFloat *components ); ")
    public void setStrokeColor(double[] components) {
//        CGColorSpace space = strokeColorSpace;
//        if (space == null)
//            space = createDeviceRGB();
        context.setDrawColorWithColor(CGColorSpace.RGB.pack(components, 0));
    }

    /**
     * Sets the stroke color of this graphics context.
     *
     * @param color The stroke color of this graphics context.
     */
    @CMFunction(" void CGContextSetStrokeColorWithColor ( CGContextRef c, CGColorRef color ); ")
    public void setStrokeColorWithColor(CGColor color) {
        if (color != null)
            context.setDrawColorWithColor(color.color);
    }

    /**
     * Sets the CGColorSpace stroke color of this graphics context.
     *
     * @param colorSpace The CGColorSpace stroke color of this graphics context.
     * @see crossmobile.ios.coregraphics.CGColorSpace
     */
    @CMFunction(" void CGContextSetStrokeColorSpace ( CGContextRef c, CGColorSpaceRef space ); ")
    public void setStrokeColorSpace(CGColorSpace colorSpace) {
        this.strokeColorSpace = colorSpace;
    }

    /**
     * Sets the fill color of this graphics context defined by the specified
     * components.
     *
     * @param components The components that specify the fill color of this
     *                   graphics context.
     */
    @CMFunction(" void CGContextSetFillColor ( CGContextRef c, const CGFloat *components ); ")
    public void setFillColor(double[] components) {
        CGColorSpace space = fillColorSpace;
        if (space == null)
            space = createDeviceRGB();
        context.setFillColorWithColor(space.pack(components, 0));
    }

    /**
     * Sets CGColor fill color of this graphics context.
     *
     * @param color The new color of the graphics context
     * @see crossmobile.ios.coregraphics.CGColor
     */
    @CMFunction(" void CGContextSetFillColorWithColor ( CGContextRef c, CGColorRef color ); ")
    public void setFillColorWithColor(CGColor color) {
        if (color != null)
            context.setFillColorWithColor(color.color);
    }

    /**
     * Sets the CGColorSpace fill color of this graphics context.
     *
     * @param colorSpace The CGColorSpace fill color.
     * @see crossmobile.ios.coregraphics.CGColorSpace
     */
    @CMFunction(" void CGContextSetFillColorSpace ( CGContextRef c, CGColorSpaceRef space ); ")
    public void setFillColorSpace(CGColorSpace colorSpace) {
        this.fillColorSpace = colorSpace;
    }

    /**
     * Sets the RGBA values for fill color of this graphics context.
     *
     * @param red   The red value of the RGBA.
     * @param green The green value of the RGBA.
     * @param blue  The blue value of the RGBA.
     * @param alpha The alpha value of the RGBA.
     */
    @CMFunction(" void CGContextSetRGBFillColor ( CGContextRef c, CGFloat red, CGFloat green, CGFloat blue, CGFloat alpha ); ")
    public void setRGBFillColor(double red, double green, double blue, double alpha) {
        context.setFillColorWithColor(CGColorSpace.RGB.pack(red, green, blue, alpha));
    }

    /**
     * Sets the RGBA values for the color of stroke lines of this graphics
     * context.
     *
     * @param red   The red value of the RGBA.
     * @param green The green value of the RGBA.
     * @param blue  The blue value of the RGBA.
     * @param alpha The alpha value of the RGBA.
     */
    @CMFunction(" void CGContextSetRGBStrokeColor ( CGContextRef c, CGFloat red, CGFloat green, CGFloat blue, CGFloat alpha ); ")
    public void setRGBStrokeColor(double red, double green, double blue, double alpha) {
        context.setDrawColorWithColor(CGColorSpace.RGB.pack(red, green, blue, alpha));
    }

    /**
     * Sets the width of stroked lines of this graphics context.
     *
     * @param width The width of stroked lines.
     */
    @CMFunction(" void CGContextSetLineWidth ( CGContextRef c, CGFloat width ); ")
    public void setLineWidth(double width) {
        context.setLineWidth(width);
    }

    /**
     * Sets the style of joining stroked lines when they shape an angle of this
     * graphics context.
     *
     * @param CGLineJoin The style of joining stroked lines when they shape an
     *                   angle.
     * @see crossmobile.ios.coregraphics.CGLineJoin
     */
    @CMFunction(" void CGContextSetLineJoin ( CGContextRef c, CGLineJoin join ); ")
    public void setLineJoin(int CGLineJoin) {
        context.setLineJoin(CGLineJoin);
    }

    /**
     * Sets the style of the ending points of lines of this graphics context.
     *
     * @param CGLineCap The style of ending points.
     * @see crossmobile.ios.coregraphics.CGLineCap
     */
    @CMFunction(" void CGContextSetLineCap ( CGContextRef c, CGLineCap cap ); ")
    public void setLineCap(int CGLineCap) {
        context.setLineCap(CGLineCap);
    }

    /**
     * Paints the specified rectangular using the current stroke color.
     *
     * @param rect The rectangular area to be painted.
     */
    @CMFunction(" void CGContextStrokeRect ( CGContextRef c, CGRect rect ); ")
    public void strokeRect(CGRect rect) {
        context.drawRect(rect.getOrigin().getX(), rect.getOrigin().getY(), rect.getSize().getWidth(), rect.getSize().getHeight());
    }

    /**
     * Paints the specified rectangular using the current preferred fill color
     * of this graphics context.
     *
     * @param rect The rectangular area to be painted.
     */
    @CMFunction(" void CGContextFillRect ( CGContextRef c, CGRect rect ); ")
    public void fillRect(CGRect rect) {
        context.fillRect(rect.getOrigin().getX(), rect.getOrigin().getY(), rect.getSize().getWidth(), rect.getSize().getHeight());
    }

    /**
     * Strokes the ellipse of the specified rectangular for this graphics
     * context.
     *
     * @param rect The rectangular that specifies the ellipse.
     */
    @CMFunction(" void CGContextStrokeEllipseInRect ( CGContextRef c, CGRect rect ); ")
    public void strokeEllipseInRect(CGRect rect) {
        context.drawEllipse(rect.getOrigin().getX(), rect.getOrigin().getY(), rect.getSize().getWidth(), rect.getSize().getHeight());
    }

    /**
     * Paints the ellipse of the specified rectangular for this graphics
     * context.
     *
     * @param rect The rectangular that specifies the ellipse.
     */
    @CMFunction(" void CGContextFillEllipseInRect ( CGContextRef c, CGRect rect ); ")
    public void fillEllipseInRect(CGRect rect) {
        context.fillEllipse(rect.getOrigin().getX(), rect.getOrigin().getY(), rect.getSize().getWidth(), rect.getSize().getHeight());
    }

    /**
     * Strokes the line specified by the given points of this graphics context.
     *
     * @param points The points that specify the line that should be stroke.
     */
    @CMFunction(" void CGContextStrokeLineSegments ( CGContextRef c, const CGPoint *points, size_t count ); ")
    public void strokeLineSegments(@CMJoinMEM(memory = "points", size = "count") CGPoint... points) {
        for (int i = 0; i < (points.length - 1); i += 2)
            context.drawLine(points[i].getX(), points[i].getY(), points[i + 1].getX(), points[i + 1].getY());
    }

    /**
     * Sets as clipping path the intersection of the current clipping path with
     * the specified rectangle in this graphics context.
     *
     * @param frame The rectangle that changes the clipping path.
     */
    @CMFunction(" void CGContextClipToRect ( CGContextRef c, CGRect rect ); ")
    public void clipToRect(CGRect frame) {
        if (frame != null)
            context.clipToRect(frame);
    }

    /**
     * Clip graphics context using current path. The path will be closed if it is still open.
     */
    @CMFunction("void CGContextClip(CGContextRef c);")
    public void clip() {
        if (path == null)
            return;
        closePath();
        context.clip(path.path);
        path = null;
    }

    /**
     * Returns the bounding box that encloses all the points of the current
     * clipping path of this graphics context.
     *
     * @return The bounding box of the current clipping path.
     */
    @CMFunction(" CGRect CGContextGetClipBoundingBox ( CGContextRef c ); ")
    public CGRect getClipBoundingBox() {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Sets the font to use for this graphics context.
     *
     * @param font The preferred font.
     */
    @CMFunction(" void CGContextSetFont ( CGContextRef c, CGFontRef font ); ")
    public void setFont(CGFont font) {
        Native.system().notImplemented("You probably want to use selectFont instead");
    }

    /**
     * Set font size for this graphics context.
     *
     * @param size The preferred font size.
     */
    @CMFunction(" void CGContextSetFontSize ( CGContextRef c, CGFloat size ); ")
    public void setFontSize(double size) {
        Native.system().notImplemented();
    }

    /**
     * Sets the font and font size to use for this graphics context.
     *
     * @param fontname       The preferred font.
     * @param size           The size of the font.
     * @param CGTextEncoding The preferred text encoding.
     * @see crossmobile.ios.coregraphics.CGTextEncoding
     */
    @Deprecated
    @CMFunction(" void CGContextSelectFont ( CGContextRef c, const char *name, CGFloat size, CGTextEncoding textEncoding ); ")
    public void selectFont(String fontname, double size, int CGTextEncoding) {
        if (fontname != null)
            context.setFont(Native.graphics().getFont(fontname, size));
    }

    /**
     * Apply the provided affine transformation to the text
     *
     * @param t The affine transformation
     */
    @CMFunction("void CGContextSetTextMatrix(CGContextRef c, CGAffineTransform t);")
    public void setTextMatrix(CGAffineTransform t) {
        Native.system().notImplemented("Please use NSString.drawAtPoint instead");
    }

    /**
     * Displays the given String at the current text position of the text
     * matrix.
     *
     * @param text The String to display.
     */
    @CMFunction(" void CGContextShowText ( CGContextRef c, const char *string, size_t length ); ")
    public void showText(@CMJoinMEM(memory = "string", size = "length") String text) {
        if (text == null || text.length() == 0)
            return;
        showTextAtPoint(textPosition.getX(), textPosition.getY(), text);
    }

    /**
     * Displays the given String at the specified position of this graphics
     * context.
     *
     * @param x    The x-value of this position.
     * @param y    The y-value of this position.
     * @param text The String to display.
     */
    @CMFunction(" void CGContextShowTextAtPoint ( CGContextRef c, CGFloat x, CGFloat y, const char *string, size_t length ); ")
    public void showTextAtPoint(double x, double y, @CMJoinMEM(memory = "string", size = "length") String text) {
        if (text == null || text.isEmpty())
            return;
        Native.system().notImplemented("Please use NSString.drawAtPoint instead");
        context.showTextAtPoint(x, y, text);
    }

    /**
     * Returns the position at which the text should be drawn for this graphics
     * context.
     *
     * @return The position at which the text should be drawn for this graphics
     * context.
     */
    @CMFunction(" CGPoint CGContextGetTextPosition ( CGContextRef c ); ")
    public CGPoint getTextPosition() {
        return new CGPoint(textPosition);
    }

    /**
     * Sets location of at which the text should be drawn for this graphics
     * context.
     *
     * @param x Horizontal location of text
     * @param y Vertical location of text
     */
    @CMFunction(" void CGContextSetTextPosition ( CGContextRef c, CGFloat x, CGFloat y ); ")
    public void setTextPosition(double x, double y) {
        textPosition.setX(x);
        textPosition.setY(y);
    }

    /**
     * Set drawing mode for this graphics context.
     *
     * @param CGTextDrawingMode The drawing mode of this graphics context.
     * @see crossmobile.ios.coregraphics.CGTextDrawingMode
     */
    @CMFunction(" void CGContextSetTextDrawingMode ( CGContextRef c, CGTextDrawingMode mode ); ")
    public void setTextDrawingMode(int CGTextDrawingMode) {
        Native.system().notImplemented();
    }

    /**
     * Creates a new path in this graphics context.
     */
    @CMFunction(" void CGContextBeginPath ( CGContextRef c ); ")
    public void beginPath() {
        path = new CGPath();
    }

    /**
     * Begins a new subpath at the specified point of this graphics context.
     *
     * @param x The x-value of the point.
     * @param y The y-value of the point.
     */
    @CMFunction(" void CGContextMoveToPoint ( CGContextRef c, CGFloat x, CGFloat y ); ")
    public void moveToPoint(double x, double y) {
        if (path == null)
            beginPath();
        path.moveToPoint(null, x, y);
    }

    /**
     * Adds a straight line segment between the specified points of this
     * graphics context.
     *
     * @param x The x-value for the end of the line segment.
     * @param y The y-value for the end of the line segment.
     */
    @CMFunction(" void CGContextAddLineToPoint ( CGContextRef c, CGFloat x, CGFloat y ); ")
    public void addLineToPoint(double x, double y) {
        if (path == null)
            beginPath();
        path.addLineToPoint(null, x, y);
    }

    /**
     * Adds an arc to the current path of this graphics context.
     *
     * @param x          The x-value of the center of the arc.
     * @param y          The y-value of the center of the arc.
     * @param radius     The radius of the arc.
     * @param startAngle The starting angle of the arc expressed in radians.
     * @param endAngle   The ending angle of the arc expressed in radians.
     * @param clockwise  Specify 1 to create a clockwise arc or 0 to create a
     *                   counterclockwise arc. Whether the arc is added clockwise or
     *                   counterclockwise.
     */
    @CMFunction(" void CGContextAddArc ( CGContextRef c, CGFloat x, CGFloat y, CGFloat radius, CGFloat startAngle, CGFloat endAngle, int clockwise ); ")
    public void addArc(double x, double y, double radius, double startAngle, double endAngle, int clockwise) {
        if (path == null)
            beginPath();
        path.addArc(null, x, y, radius, startAngle, endAngle, clockwise == 1);
    }

    /**
     * Adds an arc to the current path of this graphics context.
     *
     * @param x1     The x-value of the first tangent line.
     * @param y1     The y-value of the first tangent line.
     * @param x2     The y-value of the first tangent line.
     * @param y2     The x-value of the second tangent line.
     * @param radius The radius of the arc.
     */
    @CMFunction(" void CGContextAddArcToPoint ( CGContextRef c, CGFloat x1, CGFloat y1, CGFloat x2, CGFloat y2, CGFloat radius ); ")
    public void addArcToPoint(double x1, double y1, double x2, double y2, double radius) {
        if (path == null)
            beginPath();
        path.addArcToPoint(null, x1, y1, x2, y2, radius);
    }

    /**
     * Adds a cubic Bézier curve to the specified subpath of this graphics
     * context.
     *
     * @param cp1x The x-value of first control point of the curve.
     * @param cp1y The y-value of first control point of the curve.
     * @param cp2x The x-value of the second control point of the curve.
     * @param cp2y The y-value of the second control point of the curve.
     * @param x    The x end point of the curve.
     * @param y    The y end point of the curve.
     */
    @CMFunction(" void CGContextAddCurveToPoint ( CGContextRef c, CGFloat cp1x, CGFloat cp1y, CGFloat cp2x, CGFloat cp2y, CGFloat x, CGFloat y ); ")
    public void addCurveToPoint(double cp1x, double cp1y, double cp2x, double cp2y, double x, double y) {
        if (path == null)
            beginPath();
        path.addCurveToPoint(null, cp1x, cp1y, cp2x, cp2y, x, y);
    }

    /**
     * Adds a quadratic Bézier curve to the specified path of this graphics
     * context.
     *
     * @param cpx The y control point of the curve.
     * @param cpy The y control point of the curve.
     * @param x   The x end point of the curve.
     * @param y   The y end point of the curve.
     */
    @CMFunction(" void CGContextAddQuadCurveToPoint ( CGContextRef c, CGFloat cpx, CGFloat cpy, CGFloat x, CGFloat y ); ")
    public void addQuadCurveToPoint(double cpx, double cpy, double x, double y) {
        if (path == null)
            beginPath();
        path.addQuadCurveToPoint(null, cpx, cpy, x, y);
    }

    /**
     * Adds the specified rectangular path to the current path of this graphics
     * context.
     *
     * @param rect The rectangular path to add to the current path.
     */
    @CMFunction(" void CGContextAddRect ( CGContextRef c, CGRect rect ); ")
    public void addRect(CGRect rect) {
        double minX = rect.getMinX();
        double maxX = rect.getMaxX() - 1;
        double minY = rect.getMinY();
        double maxY = rect.getMaxY() - 1;
        moveToPoint(minX, minY);
        addLineToPoint(maxX, minY);
        addLineToPoint(maxX, maxY);
        addLineToPoint(minX, maxY);
        addLineToPoint(minX, minY);
    }

    /**
     * Adds the specified rectangular paths to the current path of this graphics
     * context.
     *
     * @param rects The rectangular paths.
     */
    @CMFunction(" void CGContextAddRects ( CGContextRef c, const CGRect *rects, size_t count ); ")
    public void addRects(@CMJoinMEM(memory = "rects", size = "count") CGRect... rects) {
        if (rects != null)
            for (CGRect rect : rects)
                addRect(rect);
    }

    /**
     * Adds the specified, by the given points line, to the current path of this
     * graphics context.
     *
     * @param points The points of the line.
     */
    @CMFunction(" void CGContextAddLines ( CGContextRef c, const CGPoint *points, size_t count ); ")
    public void addLines(@CMJoinMEM(memory = "points", size = "count") CGPoint... points) {
        if (points != null && points.length > 0) {
            moveToPoint(points[0].getX(), points[0].getY());
            for (int i = 1; i < points.length; i++)
                addLineToPoint(points[i].getX(), points[i].getY());
        }
    }

    /**
     * Closes and completes the current path.
     */
    @CMFunction(" void CGContextClosePath ( CGContextRef c ); ")
    public void closePath() {
        if (path == null)
            return;
        path.closeSubpath();
    }

    /**
     * Draws the current path using the specified drawing mode.
     *
     * @param CGPathDrawingMode A path drawing mode for the path.
     * @see crossmobile.ios.coregraphics.CGPathDrawingMode
     */
    @CMFunction(" void CGContextDrawPath ( CGContextRef c, CGPathDrawingMode mode ); ")
    public void drawPath(int CGPathDrawingMode) {
        switch (CGPathDrawingMode) {
            case crossmobile.ios.coregraphics.CGPathDrawingMode.Fill:
                fillPath();
                break;
            case crossmobile.ios.coregraphics.CGPathDrawingMode.Stroke:
                strokePath();
                break;
            case crossmobile.ios.coregraphics.CGPathDrawingMode.FillStroke:
                fillPath();
                strokePath();
                break;
        }
    }

    /**
     * Fills with color the current path using non-zero winding rule.
     */
    @CMFunction(" void CGContextFillPath ( CGContextRef c ); ")
    public void fillPath() {
        if (path == null)
            return;
        closePath();
        context.fillPath(path.path);
        path = null;
    }

    /**
     * Paints a line within the current path.
     */
    @CMFunction(" void CGContextStrokePath ( CGContextRef c ); ")
    public void strokePath() {
        if (path == null)
            return;
//        closePath();
        context.drawPath(path.path);
        path = null;
    }

    /**
     * Add a new path to current path
     *
     * @param path The path to add
     */
    @CMFunction("void CGContextAddPath(CGContextRef c, CGPathRef path);")
    public void addPath(CGPath path) {
        if (this.path == null)
            beginPath();
        this.path.addPath(null, path);
    }

    /**
     * Draws linear gradient for the specified area of this graphics context.
     *
     * @param gradient                 The CGGradient object.
     * @param startPoint               Starting point's coordinates.
     * @param endPoint                 Ending point's coordinates.
     * @param CGGradientDrawingOptions The drawing locations of the gradients.
     * @see crossmobile.ios.coregraphics.CGGradientDrawingOptions
     */
    @CMFunction(" void CGContextDrawLinearGradient ( CGContextRef c, CGGradientRef gradient, CGPoint startPoint, CGPoint endPoint, CGGradientDrawingOptions options ); ")
    public void drawLinearGradient(CGGradient gradient, CGPoint startPoint, CGPoint endPoint, int CGGradientDrawingOptions) {
        context.drawLinearGradient(gradient.RGBcolors, gradient.locations, startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY(), CGGradientDrawingOptions);
    }

    /**
     * Draws a radial gradient for the specified area of defined by the given
     * circles this graphics context.
     *
     * @param gradient                 The CGGradient object.
     * @param startCenter              Starting circle's coordinates.
     * @param startRadius              Starting circle's radius.
     * @param endCenter                Ending circle's coordinates.
     * @param endRadius                Ending circle's radius.
     * @param CGGradientDrawingOptions The drawing locations of the gradients.
     * @see crossmobile.ios.coregraphics.CGGradientDrawingOptions
     */
    @CMFunction(" void CGContextDrawRadialGradient ( CGContextRef c, CGGradientRef gradient, CGPoint startCenter, CGFloat startRadius, CGPoint endCenter, CGFloat endRadius, CGGradientDrawingOptions options ); ")
    public void drawRadialGradient(CGGradient gradient, CGPoint startCenter, double startRadius, CGPoint endCenter, double endRadius, int CGGradientDrawingOptions) {
        context.drawRadialGradient(gradient.RGBcolors, gradient.locations, startCenter.getX(), startCenter.getY(), startRadius, endCenter.getX(), endCenter.getY(), endRadius, CGGradientDrawingOptions);
    }

    /**
     * Draws shadow with color for this graphics context.
     *
     * @param offset The translation of the shadow offset.
     * @param blur   The amount of blur.
     * @param color  The color of the shadow.
     */
    @CMFunction(" void CGContextSetShadowWithColor ( CGContextRef c, CGSize offset, CGFloat blur, CGColorRef color ); ")
    public void setShadowWithColor(CGSize offset, double blur, CGColor color) {
        Native.system().notImplemented();
    }

    /**
     * Sets a Boolean that defines anti-aliasing status of this graphics
     * context.
     *
     * @param shouldAntialias TRUE to enable anti-aliasing which is the default.
     */
    @CMFunction(" void CGContextSetShouldAntialias ( CGContextRef c, bool shouldAntialias ); ")
    public void setShouldAntialias(boolean shouldAntialias) {
        context.setAntialias(shouldAntialias);
    }

}
