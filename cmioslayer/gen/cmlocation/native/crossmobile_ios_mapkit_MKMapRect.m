// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_mapkit_MKMapRect implementation

#import "crossmobile_ios_mapkit_MKMapPoint.h"
#import "crossmobile_ios_mapkit_MKMapRect.h"
#import "crossmobile_ios_mapkit_MKMapSize.h"

@implementation crossmobile_ios_mapkit_MKMapRect

// MKMapRect MKMapRectMake ( double x, double y, double width, double height );
- (crossmobile_ios_mapkit_MKMapRect*) __init_crossmobile_ios_mapkit_MKMapRect___double_double_double_double:(double) x :(double) y :(double) width :(double) height 
{
    return [self initWithMKMapRect:MKMapRectMake(x, y, width, height)];
}

// MKMapPoint origin;
- (void) setOrigin___crossmobile_ios_mapkit_MKMapPoint:(crossmobile_ios_mapkit_MKMapPoint*) origin 
{
    [self->origin_crossmobile_ios_mapkit_MKMapPoint setMKMapPoint:[origin getMKMapPoint]];
}

// MKMapPoint origin;
- (crossmobile_ios_mapkit_MKMapPoint*) getOrigin__
{
    return [self->origin_crossmobile_ios_mapkit_MKMapPoint retain];
}

// MKMapSize size;
- (void) setSize___crossmobile_ios_mapkit_MKMapSize:(crossmobile_ios_mapkit_MKMapSize*) size 
{
    [self->size_crossmobile_ios_mapkit_MKMapSize setMKMapSize:[size getMKMapSize]];
}

// MKMapSize size;
- (crossmobile_ios_mapkit_MKMapSize*) getSize__
{
    return [self->size_crossmobile_ios_mapkit_MKMapSize retain];
}

+ (id) alloc
{
    crossmobile_ios_mapkit_MKMapRect* obj = [super alloc];
    obj->origin_crossmobile_ios_mapkit_MKMapPoint = [crossmobile_ios_mapkit_MKMapPoint alloc];
    obj->size_crossmobile_ios_mapkit_MKMapSize = [crossmobile_ios_mapkit_MKMapSize alloc];
    return obj;
}

- (void) dealloc
{
    [origin_crossmobile_ios_mapkit_MKMapPoint release];
    [size_crossmobile_ios_mapkit_MKMapSize release];
    [super dealloc];
}

- (instancetype) initWithMKMapRect:(MKMapRect) other
{
    self = [super init];
    self->origin_crossmobile_ios_mapkit_MKMapPoint->x_double = other.origin.x;
    self->origin_crossmobile_ios_mapkit_MKMapPoint->y_double = other.origin.y;
    self->size_crossmobile_ios_mapkit_MKMapSize->width_double = other.size.width;
    self->size_crossmobile_ios_mapkit_MKMapSize->height_double = other.size.height;
    return self;
}

- (void) setMKMapRect:(MKMapRect) other
{
    self->origin_crossmobile_ios_mapkit_MKMapPoint->x_double = other.origin.x;
    self->origin_crossmobile_ios_mapkit_MKMapPoint->y_double = other.origin.y;
    self->size_crossmobile_ios_mapkit_MKMapSize->width_double = other.size.width;
    self->size_crossmobile_ios_mapkit_MKMapSize->height_double = other.size.height;
}

- (MKMapRect) getMKMapRect
{
    MKMapRect result;
    result.origin.x = self->origin_crossmobile_ios_mapkit_MKMapPoint->x_double;
    result.origin.y = self->origin_crossmobile_ios_mapkit_MKMapPoint->y_double;
    result.size.width = self->size_crossmobile_ios_mapkit_MKMapSize->width_double;
    result.size.height = self->size_crossmobile_ios_mapkit_MKMapSize->height_double;
    return result;
}

@end
