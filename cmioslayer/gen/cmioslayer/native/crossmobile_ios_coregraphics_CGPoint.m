// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.coregraphics.CGPoint implementation

#import "crossmobile_ios_coregraphics_CGAffineTransform.h"
#import "crossmobile_ios_coregraphics_CGPoint.h"

@implementation crossmobile_ios_coregraphics_CGPoint

// direct binding of: const CGPoint CGPointZero;
+ (crossmobile_ios_coregraphics_CGPoint*) zero__
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:CGPointZero];
}

// direct binding of: CGPoint CGPointMake ( CGFloat x, CGFloat y );
- (crossmobile_ios_coregraphics_CGPoint*) __init_crossmobile_ios_coregraphics_CGPoint___double_double:(double) x :(double) y 
{
    return [self initWithCGPoint:CGPointMake(x, y)];
}

// direct binding of: CGFloat x;
- (void) setX___double:(double) x 
{
    self->x_double = x;
}

// direct binding of: CGFloat x;
- (double) getX__
{
    return self->x_double;
}

// direct binding of: CGFloat y;
- (void) setY___double:(double) y 
{
    self->y_double = y;
}

// direct binding of: CGFloat y;
- (double) getY__
{
    return self->y_double;
}

// direct binding of: CGPoint CGPointApplyAffineTransform(CGPoint point, CGAffineTransform t);
- (crossmobile_ios_coregraphics_CGPoint*) applyAffineTransform___crossmobile_ios_coregraphics_CGAffineTransform:(crossmobile_ios_coregraphics_CGAffineTransform*) t 
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:CGPointApplyAffineTransform([self getCGPoint], [t getCGAffineTransform])];
}

- (instancetype) initWithCGPoint:(CGPoint) other
{
    self = [super init];
    self->x_double = other.x;
    self->y_double = other.y;
    return self;
}

- (void) setCGPoint:(CGPoint) other
{
    self->x_double = other.x;
    self->y_double = other.y;
}

- (CGPoint) getCGPoint
{
    CGPoint result;
    result.x = self->x_double;
    result.y = self->y_double;
    return result;
}

@end
