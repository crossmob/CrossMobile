// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile_ios_coregraphics_CGPath implementation

#import "crossmobile_ios_coregraphics_CGAffineTransform.h"
#import "crossmobile_ios_coregraphics_CGPath.h"

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

// void CGPathAddCurveToPoint ( CGMutablePathRef path, const CGAffineTransform *m, CGFloat cp1x, CGFloat cp1y, CGFloat cp2x, CGFloat cp2y, CGFloat x, CGFloat y );
- (void) addCurveToPoint___crossmobile_ios_coregraphics_CGAffineTransform_double_double_double_double_double_double:(crossmobile_ios_coregraphics_CGAffineTransform*) m :(double) cp1x :(double) cp1y :(double) cp2x :(double) cp2y :(double) x :(double) y 
{
    CGAffineTransform m$conv;
    if (m != JAVA_NULL)
        m$conv = [m getCGAffineTransform];
    CGPathAddCurveToPoint(self->$reference, (m == JAVA_NULL ? NULL : &m$conv), cp1x, cp1y, cp2x, cp2y, x, y);
}

// void CGPathAddLineToPoint ( CGMutablePathRef path, const CGAffineTransform *m, CGFloat x, CGFloat y );
- (void) addLineToPoint___crossmobile_ios_coregraphics_CGAffineTransform_double_double:(crossmobile_ios_coregraphics_CGAffineTransform*) m :(double) x :(double) y 
{
    CGAffineTransform m$conv;
    if (m != JAVA_NULL)
        m$conv = [m getCGAffineTransform];
    CGPathAddLineToPoint(self->$reference, (m == JAVA_NULL ? NULL : &m$conv), x, y);
}

// void CGPathAddQuadCurveToPoint ( CGMutablePathRef path, const CGAffineTransform *m, CGFloat cpx, CGFloat cpy, CGFloat x, CGFloat y );
- (void) addQuadCurveToPoint___crossmobile_ios_coregraphics_CGAffineTransform_double_double_double_double:(crossmobile_ios_coregraphics_CGAffineTransform*) m :(double) cpx :(double) cpy :(double) x :(double) y 
{
    CGAffineTransform m$conv;
    if (m != JAVA_NULL)
        m$conv = [m getCGAffineTransform];
    CGPathAddQuadCurveToPoint(self->$reference, (m == JAVA_NULL ? NULL : &m$conv), cpx, cpy, x, y);
}

// void CGPathCloseSubpath ( CGMutablePathRef path );
- (void) closeSubpath__
{
    CGPathCloseSubpath(self->$reference);
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
