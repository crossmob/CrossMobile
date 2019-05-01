// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.mapkit.MKMapPoint implementation

#import "crossmobile_ios_mapkit_MKMapPoint.h"

@implementation crossmobile_ios_mapkit_MKMapPoint

// direct binding of: MKMapPoint MKMapPointMake ( double x, double y );
- (crossmobile_ios_mapkit_MKMapPoint*) __init_crossmobile_ios_mapkit_MKMapPoint___double_double:(double) x :(double) y 
{
    return [self initWithMKMapPoint:MKMapPointMake(x, y)];
}

// direct binding of: double x;
- (void) setX___double:(double) x 
{
    self->x_double = x;
}

// direct binding of: double x;
- (double) getX__
{
    return self->x_double;
}

// direct binding of: double y;
- (void) setY___double:(double) y 
{
    self->y_double = y;
}

// direct binding of: double y;
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
