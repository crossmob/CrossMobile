// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_coregraphics_CGSize implementation

#import "crossmobile_ios_coregraphics_CGAffineTransform.h"
#import "crossmobile_ios_coregraphics_CGSize.h"

@implementation crossmobile_ios_coregraphics_CGSize

// CGSize CGSizeMake(CGFloat width, CGFloat height);
- (crossmobile_ios_coregraphics_CGSize*) __init_crossmobile_ios_coregraphics_CGSize___double_double:(double) width :(double) height 
{
    return [self initWithCGSize:CGSizeMake(width, height)];
}

// CGFloat height;
- (void) setHeight___double:(double) height 
{
    self->height_double = height;
}

// CGFloat height;
- (double) getHeight__
{
    return self->height_double;
}

// CGFloat width;
- (void) setWidth___double:(double) width 
{
    self->width_double = width;
}

// CGFloat width;
- (double) getWidth__
{
    return self->width_double;
}

// CGSize CGSizeApplyAffineTransform ( CGSize size, CGAffineTransform t );
- (crossmobile_ios_coregraphics_CGSize*) applyAffineTransform___crossmobile_ios_coregraphics_CGAffineTransform:(crossmobile_ios_coregraphics_CGAffineTransform*) t 
{
    return [[crossmobile_ios_coregraphics_CGSize alloc] initWithCGSize:CGSizeApplyAffineTransform([self getCGSize], [t getCGAffineTransform])];
}

- (instancetype) initWithCGSize:(CGSize) other
{
    self = [super init];
    self->width_double = other.width;
    self->height_double = other.height;
    return self;
}

- (void) setCGSize:(CGSize) other
{
    self->width_double = other.width;
    self->height_double = other.height;
}

- (CGSize) getCGSize
{
    CGSize result;
    result.width = self->width_double;
    result.height = self->height_double;
    return result;
}

@end
