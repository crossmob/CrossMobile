// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_coregraphics_CGRect implementation

#import "crossmobile_ios_coregraphics_CGAffineTransform.h"
#import "crossmobile_ios_coregraphics_CGPoint.h"
#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_coregraphics_CGSize.h"

@implementation crossmobile_ios_coregraphics_CGRect

// const CGRect CGRectNull;
+ (crossmobile_ios_coregraphics_CGRect*) Null__
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:CGRectNull];
}

// const CGRect CGRectInfinite;
+ (crossmobile_ios_coregraphics_CGRect*) infinite__
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:CGRectInfinite];
}

// const CGRect CGRectZero;
+ (crossmobile_ios_coregraphics_CGRect*) zero__
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:CGRectZero];
}

// CGRect CGRectMake(CGFloat x, CGFloat y, CGFloat width, CGFloat height);
- (crossmobile_ios_coregraphics_CGRect*) __init_crossmobile_ios_coregraphics_CGRect___double_double_double_double:(double) x :(double) y :(double) width :(double) height 
{
    return [self initWithCGRect:CGRectMake(x, y, width, height)];
}

// CGPoint origin;
- (void) setOrigin___crossmobile_ios_coregraphics_CGPoint:(crossmobile_ios_coregraphics_CGPoint*) origin 
{
    [self->origin_crossmobile_ios_coregraphics_CGPoint setCGPoint:[origin getCGPoint]];
}

// CGPoint origin;
- (crossmobile_ios_coregraphics_CGPoint*) getOrigin__
{
    return [self->origin_crossmobile_ios_coregraphics_CGPoint retain];
}

// CGSize size;
- (void) setSize___crossmobile_ios_coregraphics_CGSize:(crossmobile_ios_coregraphics_CGSize*) size 
{
    [self->size_crossmobile_ios_coregraphics_CGSize setCGSize:[size getCGSize]];
}

// CGSize size;
- (crossmobile_ios_coregraphics_CGSize*) getSize__
{
    return [self->size_crossmobile_ios_coregraphics_CGSize retain];
}

// CGRect CGRectApplyAffineTransform ( CGRect rect, CGAffineTransform t );
- (crossmobile_ios_coregraphics_CGRect*) applyAffineTransform___crossmobile_ios_coregraphics_CGAffineTransform:(crossmobile_ios_coregraphics_CGAffineTransform*) t 
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:CGRectApplyAffineTransform([self getCGRect], [t getCGAffineTransform])];
}

// bool CGRectContainsPoint(CGRect rect, CGPoint point);
- (BOOL) containsPoint___crossmobile_ios_coregraphics_CGPoint:(crossmobile_ios_coregraphics_CGPoint*) point 
{
    return CGRectContainsPoint([self getCGRect], [point getCGPoint]);
}

// CGFloat CGRectGetMaxX ( CGRect rect );
- (double) getMaxX__
{
    return CGRectGetMaxX([self getCGRect]);
}

// CGFloat CGRectGetMaxY ( CGRect rect );
- (double) getMaxY__
{
    return CGRectGetMaxY([self getCGRect]);
}

// CGFloat CGRectGetMinX ( CGRect rect );
- (double) getMinX__
{
    return CGRectGetMinX([self getCGRect]);
}

// CGFloat CGRectGetMinY ( CGRect rect );
- (double) getMinY__
{
    return CGRectGetMinY([self getCGRect]);
}

// CGRect CGRectIntersection(CGRect r1, CGRect r2);
- (crossmobile_ios_coregraphics_CGRect*) intersection___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) r2 
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:CGRectIntersection([self getCGRect], [r2 getCGRect])];
}

// bool CGRectIsEmpty ( CGRect rect );
- (BOOL) isEmpty__
{
    return CGRectIsEmpty([self getCGRect]);
}

// bool CGRectIsInfinite(CGRect rect);
- (BOOL) isInfinite__
{
    return CGRectIsInfinite([self getCGRect]);
}

// bool CGRectIsNull(CGRect rect);
- (BOOL) isNull__
{
    return CGRectIsNull([self getCGRect]);
}

+ (id) alloc
{
    crossmobile_ios_coregraphics_CGRect* obj = [super alloc];
    obj->origin_crossmobile_ios_coregraphics_CGPoint = [crossmobile_ios_coregraphics_CGPoint alloc];
    obj->size_crossmobile_ios_coregraphics_CGSize = [crossmobile_ios_coregraphics_CGSize alloc];
    return obj;
}

- (void) dealloc
{
    [origin_crossmobile_ios_coregraphics_CGPoint release];
    [size_crossmobile_ios_coregraphics_CGSize release];
    [super dealloc];
}

- (instancetype) initWithCGRect:(CGRect) other
{
    self = [super init];
    self->origin_crossmobile_ios_coregraphics_CGPoint->x_double = other.origin.x;
    self->origin_crossmobile_ios_coregraphics_CGPoint->y_double = other.origin.y;
    self->size_crossmobile_ios_coregraphics_CGSize->width_double = other.size.width;
    self->size_crossmobile_ios_coregraphics_CGSize->height_double = other.size.height;
    return self;
}

- (void) setCGRect:(CGRect) other
{
    self->origin_crossmobile_ios_coregraphics_CGPoint->x_double = other.origin.x;
    self->origin_crossmobile_ios_coregraphics_CGPoint->y_double = other.origin.y;
    self->size_crossmobile_ios_coregraphics_CGSize->width_double = other.size.width;
    self->size_crossmobile_ios_coregraphics_CGSize->height_double = other.size.height;
}

- (CGRect) getCGRect
{
    CGRect result;
    result.origin.x = self->origin_crossmobile_ios_coregraphics_CGPoint->x_double;
    result.origin.y = self->origin_crossmobile_ios_coregraphics_CGPoint->y_double;
    result.size.width = self->size_crossmobile_ios_coregraphics_CGSize->width_double;
    result.size.height = self->size_crossmobile_ios_coregraphics_CGSize->height_double;
    return result;
}

@end
