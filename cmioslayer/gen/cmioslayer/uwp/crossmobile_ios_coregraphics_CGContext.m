// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.coregraphics.CGContext implementation

#import "crossmobile_ios_coregraphics_CGAffineTransform.h"
#import "crossmobile_ios_coregraphics_CGColor.h"
#import "crossmobile_ios_coregraphics_CGColorSpace.h"
#import "crossmobile_ios_coregraphics_CGContext.h"
#import "crossmobile_ios_coregraphics_CGFont.h"
#import "crossmobile_ios_coregraphics_CGGradient.h"
#import "crossmobile_ios_coregraphics_CGImage.h"
#import "crossmobile_ios_coregraphics_CGPoint.h"
#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_coregraphics_CGSize.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_coregraphics_CGContext

// direct binding of: void CGContextAddArc ( CGContextRef c, CGFloat x, CGFloat y, CGFloat radius, CGFloat startAngle, CGFloat endAngle, int clockwise );
- (void) addArc___double_double_double_double_double_int:(double) x :(double) y :(double) radius :(double) startAngle :(double) endAngle :(int) clockwise 
{
    CGContextAddArc(self->$reference, x, y, radius, startAngle, endAngle, clockwise);
}

// direct binding of: void CGContextAddArcToPoint ( CGContextRef c, CGFloat x1, CGFloat y1, CGFloat x2, CGFloat y2, CGFloat radius );
- (void) addArcToPoint___double_double_double_double_double:(double) x1 :(double) y1 :(double) x2 :(double) y2 :(double) radius 
{
    CGContextAddArcToPoint(self->$reference, x1, y1, x2, y2, radius);
}

// direct binding of: void CGContextAddCurveToPoint ( CGContextRef c, CGFloat cp1x, CGFloat cp1y, CGFloat cp2x, CGFloat cp2y, CGFloat x, CGFloat y );
- (void) addCurveToPoint___double_double_double_double_double_double:(double) cp1x :(double) cp1y :(double) cp2x :(double) cp2y :(double) x :(double) y 
{
    CGContextAddCurveToPoint(self->$reference, cp1x, cp1y, cp2x, cp2y, x, y);
}

// direct binding of: void CGContextAddLineToPoint ( CGContextRef c, CGFloat x, CGFloat y );
- (void) addLineToPoint___double_double:(double) x :(double) y 
{
    CGContextAddLineToPoint(self->$reference, x, y);
}

// direct binding of: void CGContextAddLines ( CGContextRef c, const CGPoint *points, size_t count );
- (void) addLines___crossmobile_ios_coregraphics_CGPoint_ARRAYTYPE:(XMLVMArray*) points 
{
    CGContextAddLines(self->$reference, (points == JAVA_NULL ? NULL : points->array.data), (points == JAVA_NULL ? 0 : points->length));
}

// direct binding of: void CGContextAddQuadCurveToPoint ( CGContextRef c, CGFloat cpx, CGFloat cpy, CGFloat x, CGFloat y );
- (void) addQuadCurveToPoint___double_double_double_double:(double) cpx :(double) cpy :(double) x :(double) y 
{
    CGContextAddQuadCurveToPoint(self->$reference, cpx, cpy, x, y);
}

// direct binding of: void CGContextAddRect ( CGContextRef c, CGRect rect );
- (void) addRect___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) rect 
{
    CGContextAddRect(self->$reference, [rect getCGRect]);
}

// direct binding of: void CGContextAddRects ( CGContextRef c, const CGRect *rects, size_t count );
- (void) addRects___crossmobile_ios_coregraphics_CGRect_ARRAYTYPE:(XMLVMArray*) rects 
{
    CGContextAddRects(self->$reference, (rects == JAVA_NULL ? NULL : rects->array.data), (rects == JAVA_NULL ? 0 : rects->length));
}

// direct binding of: void CGContextBeginPath ( CGContextRef c );
- (void) beginPath__
{
    CGContextBeginPath(self->$reference);
}

// direct binding of: void CGContextClipToRect ( CGContextRef c, CGRect rect );
- (void) clipToRect___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) rect 
{
    CGContextClipToRect(self->$reference, [rect getCGRect]);
}

// direct binding of: void CGContextClosePath ( CGContextRef c );
- (void) closePath__
{
    CGContextClosePath(self->$reference);
}

// direct binding of: void CGContextConcatCTM ( CGContextRef c, CGAffineTransform transform );
- (void) concatCTM___crossmobile_ios_coregraphics_CGAffineTransform:(crossmobile_ios_coregraphics_CGAffineTransform*) transform 
{
    CGContextConcatCTM(self->$reference, [transform getCGAffineTransform]);
}

// direct binding of: void CGContextDrawImage ( CGContextRef c, CGRect rect, CGImageRef image );
- (void) drawImage___crossmobile_ios_coregraphics_CGRect_crossmobile_ios_coregraphics_CGImage:(crossmobile_ios_coregraphics_CGRect*) rect :(crossmobile_ios_coregraphics_CGImage*) image 
{
    CGContextDrawImage(self->$reference, [rect getCGRect], image->$reference);
}

// direct binding of: void CGContextDrawLinearGradient ( CGContextRef c, CGGradientRef gradient, CGPoint startPoint, CGPoint endPoint, CGGradientDrawingOptions options );
- (void) drawLinearGradient___crossmobile_ios_coregraphics_CGGradient_crossmobile_ios_coregraphics_CGPoint_crossmobile_ios_coregraphics_CGPoint_int:(crossmobile_ios_coregraphics_CGGradient*) gradient :(crossmobile_ios_coregraphics_CGPoint*) startPoint :(crossmobile_ios_coregraphics_CGPoint*) endPoint :(int) options 
{
    CGContextDrawLinearGradient(self->$reference, gradient->$reference, [startPoint getCGPoint], [endPoint getCGPoint], options);
}

// direct binding of: void CGContextDrawPath ( CGContextRef c, CGPathDrawingMode mode );
- (void) drawPath___int:(int) mode 
{
    CGContextDrawPath(self->$reference, mode);
}

// direct binding of: void CGContextDrawRadialGradient ( CGContextRef c, CGGradientRef gradient, CGPoint startCenter, CGFloat startRadius, CGPoint endCenter, CGFloat endRadius, CGGradientDrawingOptions options );
- (void) drawRadialGradient___crossmobile_ios_coregraphics_CGGradient_crossmobile_ios_coregraphics_CGPoint_double_crossmobile_ios_coregraphics_CGPoint_double_int:(crossmobile_ios_coregraphics_CGGradient*) gradient :(crossmobile_ios_coregraphics_CGPoint*) startCenter :(double) startRadius :(crossmobile_ios_coregraphics_CGPoint*) endCenter :(double) endRadius :(int) options 
{
    CGContextDrawRadialGradient(self->$reference, gradient->$reference, [startCenter getCGPoint], startRadius, [endCenter getCGPoint], endRadius, options);
}

// direct binding of: void CGContextFillEllipseInRect ( CGContextRef c, CGRect rect );
- (void) fillEllipseInRect___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) rect 
{
    CGContextFillEllipseInRect(self->$reference, [rect getCGRect]);
}

// direct binding of: void CGContextFillPath ( CGContextRef c );
- (void) fillPath__
{
    CGContextFillPath(self->$reference);
}

// direct binding of: void CGContextFillRect ( CGContextRef c, CGRect rect );
- (void) fillRect___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) rect 
{
    CGContextFillRect(self->$reference, [rect getCGRect]);
}

// direct binding of: CGAffineTransform CGContextGetCTM ( CGContextRef c );
- (crossmobile_ios_coregraphics_CGAffineTransform*) getCTM__
{
    return [[crossmobile_ios_coregraphics_CGAffineTransform alloc] initWithCGAffineTransform:CGContextGetCTM(self->$reference)];
}

// direct binding of: CGRect CGContextGetClipBoundingBox ( CGContextRef c );
- (crossmobile_ios_coregraphics_CGRect*) getClipBoundingBox__
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:CGContextGetClipBoundingBox(self->$reference)];
}

// direct binding of: CGPoint CGContextGetTextPosition ( CGContextRef c );
- (crossmobile_ios_coregraphics_CGPoint*) getTextPosition__
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:CGContextGetTextPosition(self->$reference)];
}

// direct binding of: void CGContextMoveToPoint ( CGContextRef c, CGFloat x, CGFloat y );
- (void) moveToPoint___double_double:(double) x :(double) y 
{
    CGContextMoveToPoint(self->$reference, x, y);
}

// direct binding of: void CGContextRestoreGState ( CGContextRef c );
- (void) restoreGState__
{
    CGContextRestoreGState(self->$reference);
}

// direct binding of: void CGContextRotateCTM ( CGContextRef c, CGFloat angle );
- (void) rotateCTM___double:(double) angle 
{
    CGContextRotateCTM(self->$reference, angle);
}

// direct binding of: void CGContextSaveGState ( CGContextRef c );
- (void) saveGState__
{
    CGContextSaveGState(self->$reference);
}

// direct binding of: void CGContextScaleCTM ( CGContextRef c, CGFloat sx, CGFloat sy );
- (void) scaleCTM___double_double:(double) sx :(double) sy 
{
    CGContextScaleCTM(self->$reference, sx, sy);
}

// direct binding of: void CGContextSelectFont ( CGContextRef c, const char *name, CGFloat size, CGTextEncoding textEncoding );
- (void) selectFont___java_lang_String_double_int:(NSString*) name :(double) size :(int) textEncoding 
{
    CGContextSelectFont(self->$reference, [name UTF8String], size, textEncoding);
}

// direct binding of: void CGContextSetAlpha ( CGContextRef c, CGFloat alpha );
- (void) setAlpha___double:(double) alpha 
{
    CGContextSetAlpha(self->$reference, alpha);
}

// direct binding of: void CGContextSetFillColor ( CGContextRef c, const CGFloat *components );
- (void) setFillColor___double_ARRAYTYPE:(XMLVMArray*) components 
{
    CGContextSetFillColor(self->$reference, (components == JAVA_NULL ? NULL : components->array.data));
}

// direct binding of: void CGContextSetFillColorSpace ( CGContextRef c, CGColorSpaceRef space );
- (void) setFillColorSpace___crossmobile_ios_coregraphics_CGColorSpace:(crossmobile_ios_coregraphics_CGColorSpace*) space 
{
    CGContextSetFillColorSpace(self->$reference, space->$reference);
}

// direct binding of: void CGContextSetFillColorWithColor ( CGContextRef c, CGColorRef color );
- (void) setFillColorWithColor___crossmobile_ios_coregraphics_CGColor:(crossmobile_ios_coregraphics_CGColor*) color 
{
    CGContextSetFillColorWithColor(self->$reference, color->$reference);
}

// direct binding of: void CGContextSetFont ( CGContextRef c, CGFontRef font );
- (void) setFont___crossmobile_ios_coregraphics_CGFont:(crossmobile_ios_coregraphics_CGFont*) font 
{
    CGContextSetFont(self->$reference, font->$reference);
}

// direct binding of: void CGContextSetFontSize ( CGContextRef c, CGFloat size );
- (void) setFontSize___double:(double) size 
{
    CGContextSetFontSize(self->$reference, size);
}

// direct binding of: void CGContextSetLineCap ( CGContextRef c, CGLineCap cap );
- (void) setLineCap___int:(int) cap 
{
    CGContextSetLineCap(self->$reference, cap);
}

// direct binding of: void CGContextSetLineJoin ( CGContextRef c, CGLineJoin join );
- (void) setLineJoin___int:(int) join 
{
    CGContextSetLineJoin(self->$reference, join);
}

// direct binding of: void CGContextSetLineWidth ( CGContextRef c, CGFloat width );
- (void) setLineWidth___double:(double) width 
{
    CGContextSetLineWidth(self->$reference, width);
}

// direct binding of: void CGContextSetRGBFillColor ( CGContextRef c, CGFloat red, CGFloat green, CGFloat blue, CGFloat alpha );
- (void) setRGBFillColor___double_double_double_double:(double) red :(double) green :(double) blue :(double) alpha 
{
    CGContextSetRGBFillColor(self->$reference, red, green, blue, alpha);
}

// direct binding of: void CGContextSetRGBStrokeColor ( CGContextRef c, CGFloat red, CGFloat green, CGFloat blue, CGFloat alpha );
- (void) setRGBStrokeColor___double_double_double_double:(double) red :(double) green :(double) blue :(double) alpha 
{
    CGContextSetRGBStrokeColor(self->$reference, red, green, blue, alpha);
}

// direct binding of: void CGContextSetShadowWithColor ( CGContextRef c, CGSize offset, CGFloat blur, CGColorRef color );
- (void) setShadowWithColor___crossmobile_ios_coregraphics_CGSize_double_crossmobile_ios_coregraphics_CGColor:(crossmobile_ios_coregraphics_CGSize*) offset :(double) blur :(crossmobile_ios_coregraphics_CGColor*) color 
{
    CGContextSetShadowWithColor(self->$reference, [offset getCGSize], blur, color->$reference);
}

// direct binding of: void CGContextSetShouldAntialias ( CGContextRef c, bool shouldAntialias );
- (void) setShouldAntialias___boolean:(BOOL) shouldAntialias 
{
    CGContextSetShouldAntialias(self->$reference, shouldAntialias);
}

// direct binding of: void CGContextSetStrokeColor ( CGContextRef c, const CGFloat *components );
- (void) setStrokeColor___double_ARRAYTYPE:(XMLVMArray*) components 
{
    CGContextSetStrokeColor(self->$reference, (components == JAVA_NULL ? NULL : components->array.data));
}

// direct binding of: void CGContextSetStrokeColorSpace ( CGContextRef c, CGColorSpaceRef space );
- (void) setStrokeColorSpace___crossmobile_ios_coregraphics_CGColorSpace:(crossmobile_ios_coregraphics_CGColorSpace*) space 
{
    CGContextSetStrokeColorSpace(self->$reference, space->$reference);
}

// direct binding of: void CGContextSetStrokeColorWithColor ( CGContextRef c, CGColorRef color );
- (void) setStrokeColorWithColor___crossmobile_ios_coregraphics_CGColor:(crossmobile_ios_coregraphics_CGColor*) color 
{
    CGContextSetStrokeColorWithColor(self->$reference, color->$reference);
}

// direct binding of: void CGContextSetTextDrawingMode ( CGContextRef c, CGTextDrawingMode mode );
- (void) setTextDrawingMode___int:(int) mode 
{
    CGContextSetTextDrawingMode(self->$reference, mode);
}

// direct binding of: void CGContextSetTextMatrix(CGContextRef c, CGAffineTransform t);
- (void) setTextMatrix___crossmobile_ios_coregraphics_CGAffineTransform:(crossmobile_ios_coregraphics_CGAffineTransform*) t 
{
    CGContextSetTextMatrix(self->$reference, [t getCGAffineTransform]);
}

// direct binding of: void CGContextSetTextPosition ( CGContextRef c, CGFloat x, CGFloat y );
- (void) setTextPosition___double_double:(double) x :(double) y 
{
    CGContextSetTextPosition(self->$reference, x, y);
}

// direct binding of: void CGContextShowText ( CGContextRef c, const char *string, size_t length );
- (void) showText___java_lang_String:(NSString*) string 
{
    CGContextShowText(self->$reference, [string UTF8String], [string length]);
}

// direct binding of: void CGContextShowTextAtPoint ( CGContextRef c, CGFloat x, CGFloat y, const char *string, size_t length );
- (void) showTextAtPoint___double_double_java_lang_String:(double) x :(double) y :(NSString*) string 
{
    CGContextShowTextAtPoint(self->$reference, x, y, [string UTF8String], [string length]);
}

// direct binding of: void CGContextStrokeEllipseInRect ( CGContextRef c, CGRect rect );
- (void) strokeEllipseInRect___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) rect 
{
    CGContextStrokeEllipseInRect(self->$reference, [rect getCGRect]);
}

// direct binding of: void CGContextStrokeLineSegments ( CGContextRef c, const CGPoint *points, size_t count );
- (void) strokeLineSegments___crossmobile_ios_coregraphics_CGPoint_ARRAYTYPE:(XMLVMArray*) points 
{
    CGContextStrokeLineSegments(self->$reference, (points == JAVA_NULL ? NULL : points->array.data), (points == JAVA_NULL ? 0 : points->length));
}

// direct binding of: void CGContextStrokePath ( CGContextRef c );
- (void) strokePath__
{
    CGContextStrokePath(self->$reference);
}

// direct binding of: void CGContextStrokeRect ( CGContextRef c, CGRect rect );
- (void) strokeRect___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) rect 
{
    CGContextStrokeRect(self->$reference, [rect getCGRect]);
}

// direct binding of: void CGContextTranslateCTM ( CGContextRef c, CGFloat tx, CGFloat ty );
- (void) translateCTM___double_double:(double) tx :(double) ty 
{
    CGContextTranslateCTM(self->$reference, tx, ty);
}

- (instancetype) initWithCGContext:(CGContextRef) reference
{
    self = [super initWithCFType:reference];
    return self;
}

@end
