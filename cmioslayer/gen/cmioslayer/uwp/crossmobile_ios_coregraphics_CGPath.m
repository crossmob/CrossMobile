// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_coregraphics_CGPath implementation

#import "crossmobile_ios_coregraphics_CGAffineTransform.h"
#import "crossmobile_ios_coregraphics_CGPath.h"
#import "crossmobile_ios_coregraphics_CGPoint.h"
#import "crossmobile_ios_coregraphics_CGRect.h"

@implementation crossmobile_ios_coregraphics_CGPath

// CGMutablePathRef CGPathCreateMutable ( void );
- (crossmobile_ios_coregraphics_CGPath*) __init_crossmobile_ios_coregraphics_CGPath__
{
    return [self initWithCGPath:CGPathCreateMutable()];
}

// void CGPathAddArc ( CGMutablePathRef path, const CGAffineTransform *m, CGFloat x, CGFloat y, CGFloat radius, CGFloat startAngle, CGFloat endAngle, bool clockwise );
- (void) addArc___crossmobile_ios_coregraphics_CGAffineTransform_double_double_double_double_double_boolean:(crossmobile_ios_coregraphics_CGAffineTransform*) m :(double) x :(double) y :(double) radius :(double) startAngle :(double) endAngle :(BOOL) clockwise 
{
    CGAffineTransform m$conv;
    if (m != JAVA_NULL)
        m$conv = [m getCGAffineTransform];
    CGPathAddArc(self->$reference, (m == JAVA_NULL ? NULL : &m$conv), x, y, radius, startAngle, endAngle, clockwise);
}

// void CGPathAddArcToPoint(CGMutablePathRef path, const CGAffineTransform *m, CGFloat x1, CGFloat y1, CGFloat x2, CGFloat y2, CGFloat radius);
- (void) addArcToPoint___crossmobile_ios_coregraphics_CGAffineTransform_double_double_double_double_double:(crossmobile_ios_coregraphics_CGAffineTransform*) m :(double) x1 :(double) y1 :(double) x2 :(double) y2 :(double) radius 
{
    CGAffineTransform m$conv;
    if (m != JAVA_NULL)
        m$conv = [m getCGAffineTransform];
    CGPathAddArcToPoint(self->$reference, (m == JAVA_NULL ? NULL : &m$conv), x1, y1, x2, y2, radius);
}

// void CGPathAddCurveToPoint ( CGMutablePathRef path, const CGAffineTransform *m, CGFloat cp1x, CGFloat cp1y, CGFloat cp2x, CGFloat cp2y, CGFloat x, CGFloat y );
- (void) addCurveToPoint___crossmobile_ios_coregraphics_CGAffineTransform_double_double_double_double_double_double:(crossmobile_ios_coregraphics_CGAffineTransform*) m :(double) cp1x :(double) cp1y :(double) cp2x :(double) cp2y :(double) x :(double) y 
{
    CGAffineTransform m$conv;
    if (m != JAVA_NULL)
        m$conv = [m getCGAffineTransform];
    CGPathAddCurveToPoint(self->$reference, (m == JAVA_NULL ? NULL : &m$conv), cp1x, cp1y, cp2x, cp2y, x, y);
}

// void CGPathAddEllipseInRect(CGMutablePathRef path, const CGAffineTransform *m, CGRect rect);
- (void) addEllipseInRect___crossmobile_ios_coregraphics_CGAffineTransform_crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGAffineTransform*) m :(crossmobile_ios_coregraphics_CGRect*) rect 
{
    CGAffineTransform m$conv;
    if (m != JAVA_NULL)
        m$conv = [m getCGAffineTransform];
    CGPathAddEllipseInRect(self->$reference, (m == JAVA_NULL ? NULL : &m$conv), [rect getCGRect]);
}

// void CGPathAddLineToPoint ( CGMutablePathRef path, const CGAffineTransform *m, CGFloat x, CGFloat y );
- (void) addLineToPoint___crossmobile_ios_coregraphics_CGAffineTransform_double_double:(crossmobile_ios_coregraphics_CGAffineTransform*) m :(double) x :(double) y 
{
    CGAffineTransform m$conv;
    if (m != JAVA_NULL)
        m$conv = [m getCGAffineTransform];
    CGPathAddLineToPoint(self->$reference, (m == JAVA_NULL ? NULL : &m$conv), x, y);
}

// void CGPathAddLines(CGMutablePathRef path, const CGAffineTransform *m, const CGPoint *points, size_t count);
- (void) addLines___crossmobile_ios_coregraphics_CGAffineTransform_crossmobile_ios_coregraphics_CGPoint_ARRAYTYPE:(crossmobile_ios_coregraphics_CGAffineTransform*) m :(XMLVMArray*) points 
{
    CGAffineTransform m$conv;
    if (m != JAVA_NULL)
        m$conv = [m getCGAffineTransform];
    CGPathAddLines(self->$reference, (m == JAVA_NULL ? NULL : &m$conv), (points == JAVA_NULL ? NULL : points->array.data), (points == JAVA_NULL ? 0 : points->length));
}

// void CGPathAddPath(CGMutablePathRef path1, const CGAffineTransform *m, CGPathRef path2);
- (void) addPath___crossmobile_ios_coregraphics_CGAffineTransform_crossmobile_ios_coregraphics_CGPath:(crossmobile_ios_coregraphics_CGAffineTransform*) m :(crossmobile_ios_coregraphics_CGPath*) path2 
{
    CGAffineTransform m$conv;
    if (m != JAVA_NULL)
        m$conv = [m getCGAffineTransform];
    CGPathAddPath(self->$reference, (m == JAVA_NULL ? NULL : &m$conv), path2->$reference);
}

// void CGPathAddQuadCurveToPoint ( CGMutablePathRef path, const CGAffineTransform *m, CGFloat cpx, CGFloat cpy, CGFloat x, CGFloat y );
- (void) addQuadCurveToPoint___crossmobile_ios_coregraphics_CGAffineTransform_double_double_double_double:(crossmobile_ios_coregraphics_CGAffineTransform*) m :(double) cpx :(double) cpy :(double) x :(double) y 
{
    CGAffineTransform m$conv;
    if (m != JAVA_NULL)
        m$conv = [m getCGAffineTransform];
    CGPathAddQuadCurveToPoint(self->$reference, (m == JAVA_NULL ? NULL : &m$conv), cpx, cpy, x, y);
}

// void CGPathAddRect(CGMutablePathRef path, const CGAffineTransform *m, CGRect rect);
- (void) addRect___crossmobile_ios_coregraphics_CGAffineTransform_crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGAffineTransform*) m :(crossmobile_ios_coregraphics_CGRect*) rect 
{
    CGAffineTransform m$conv;
    if (m != JAVA_NULL)
        m$conv = [m getCGAffineTransform];
    CGPathAddRect(self->$reference, (m == JAVA_NULL ? NULL : &m$conv), [rect getCGRect]);
}

// void CGPathAddRects(CGMutablePathRef path, const CGAffineTransform *m, const CGRect *rects, size_t count);
- (void) addRects___crossmobile_ios_coregraphics_CGAffineTransform_crossmobile_ios_coregraphics_CGRect_ARRAYTYPE:(crossmobile_ios_coregraphics_CGAffineTransform*) m :(XMLVMArray*) rects 
{
    CGAffineTransform m$conv;
    if (m != JAVA_NULL)
        m$conv = [m getCGAffineTransform];
    CGPathAddRects(self->$reference, (m == JAVA_NULL ? NULL : &m$conv), (rects == JAVA_NULL ? NULL : rects->array.data), (rects == JAVA_NULL ? 0 : rects->length));
}

// void CGPathAddRoundedRect(CGMutablePathRef path, const CGAffineTransform *transform, CGRect rect, CGFloat cornerWidth, CGFloat cornerHeight);
- (void) addRoundedRect___crossmobile_ios_coregraphics_CGAffineTransform_crossmobile_ios_coregraphics_CGRect_double_double:(crossmobile_ios_coregraphics_CGAffineTransform*) transform :(crossmobile_ios_coregraphics_CGRect*) rect :(double) cornerWidth :(double) cornerHeight 
{
    CGAffineTransform transform$conv;
    if (transform != JAVA_NULL)
        transform$conv = [transform getCGAffineTransform];
    CGPathAddRoundedRect(self->$reference, (transform == JAVA_NULL ? NULL : &transform$conv), [rect getCGRect], cornerWidth, cornerHeight);
}

// void CGPathCloseSubpath ( CGMutablePathRef path );
- (void) closeSubpath__
{
    CGPathCloseSubpath(self->$reference);
}

// CGPoint CGPathGetCurrentPoint(CGPathRef path);
- (crossmobile_ios_coregraphics_CGPoint*) getCurrentPoint__
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:CGPathGetCurrentPoint(self->$reference)];
}

// void CGPathMoveToPoint ( CGMutablePathRef path, const CGAffineTransform *m, CGFloat x, CGFloat y );
- (void) moveToPoint___crossmobile_ios_coregraphics_CGAffineTransform_double_double:(crossmobile_ios_coregraphics_CGAffineTransform*) m :(double) x :(double) y 
{
    CGAffineTransform m$conv;
    if (m != JAVA_NULL)
        m$conv = [m getCGAffineTransform];
    CGPathMoveToPoint(self->$reference, (m == JAVA_NULL ? NULL : &m$conv), x, y);
}

- (instancetype) initWithCGPath:(CGPathRef) reference
{
    self = [super init];
    self->$reference = reference;
    if (self->$reference)
        CFRetain(self->$reference);
    return self;
}

- (void) dealloc
{
    if (self->$reference)
        CFRelease(self->$reference);
    [super dealloc];
}

@end
