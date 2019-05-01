// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.mapkit.MKMapSize implementation

#import "crossmobile_ios_mapkit_MKMapSize.h"

@implementation crossmobile_ios_mapkit_MKMapSize

// direct binding of: MKMapSize MKMapSizeMake ( double width, double height );
- (crossmobile_ios_mapkit_MKMapSize*) __init_crossmobile_ios_mapkit_MKMapSize___double_double:(double) width :(double) height 
{
    return [self initWithMKMapSize:MKMapSizeMake(width, height)];
}

// direct binding of: double height;
- (void) setHeight___double:(double) height 
{
    self->height_double = height;
}

// direct binding of: double height;
- (double) getHeight__
{
    return self->height_double;
}

// direct binding of: double width;
- (void) setWidth___double:(double) width 
{
    self->width_double = width;
}

// direct binding of: double width;
- (double) getWidth__
{
    return self->width_double;
}

- (instancetype) initWithMKMapSize:(MKMapSize) other
{
    self = [super init];
    self->width_double = other.width;
    self->height_double = other.height;
    return self;
}

- (void) setMKMapSize:(MKMapSize) other
{
    self->width_double = other.width;
    self->height_double = other.height;
}

- (MKMapSize) getMKMapSize
{
    MKMapSize result;
    result.width = self->width_double;
    result.height = self->height_double;
    return result;
}

@end
