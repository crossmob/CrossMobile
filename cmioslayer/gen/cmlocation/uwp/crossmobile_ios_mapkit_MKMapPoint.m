// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_mapkit_MKMapPoint implementation

#import "crossmobile_ios_mapkit_MKMapPoint.h"

@implementation crossmobile_ios_mapkit_MKMapPoint

// MKMapPoint MKMapPointMake ( double x, double y );
- (crossmobile_ios_mapkit_MKMapPoint*) __init_crossmobile_ios_mapkit_MKMapPoint___double_double:(double) x :(double) y 
{
    return [self initWithMKMapPoint:MKMapPointMake(x, y)];
}

// double x;
- (void) setX___double:(double) x 
{
    self->x_double = x;
}

// double x;
- (double) getX__
{
    return self->x_double;
}

// double y;
- (void) setY___double:(double) y 
{
    self->y_double = y;
}

// double y;
- (double) getY__
{
    return self->y_double;
}

- (instancetype) initWithMKMapPoint:(MKMapPoint) other
{
    self = [super init];
    self->x_double = other.x;
    self->y_double = other.y;
    return self;
}

- (void) setMKMapPoint:(MKMapPoint) other
{
    self->x_double = other.x;
    self->y_double = other.y;
}

- (MKMapPoint) getMKMapPoint
{
    MKMapPoint result;
    result.x = self->x_double;
    result.y = self->y_double;
    return result;
}

@end
