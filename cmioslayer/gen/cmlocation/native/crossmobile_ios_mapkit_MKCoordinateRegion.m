// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_mapkit_MKCoordinateRegion implementation

#import "crossmobile_ios_corelocation_CLLocationCoordinate2D.h"
#import "crossmobile_ios_mapkit_MKCoordinateRegion.h"
#import "crossmobile_ios_mapkit_MKCoordinateSpan.h"

@implementation crossmobile_ios_mapkit_MKCoordinateRegion

// MKCoordinateRegion MKCoordinateRegionMake ( CLLocationCoordinate2D centerCoordinate, MKCoordinateSpan span );
- (crossmobile_ios_mapkit_MKCoordinateRegion*) __init_crossmobile_ios_mapkit_MKCoordinateRegion___crossmobile_ios_corelocation_CLLocationCoordinate2D_crossmobile_ios_mapkit_MKCoordinateSpan:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) centerCoordinate :(crossmobile_ios_mapkit_MKCoordinateSpan*) span 
{
    return [self initWithMKCoordinateRegion:MKCoordinateRegionMake([centerCoordinate getCLLocationCoordinate2D], [span getMKCoordinateSpan])];
}

// CLLocationCoordinate2D center;
- (void) setCenter___crossmobile_ios_corelocation_CLLocationCoordinate2D:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) center 
{
    [self->center_crossmobile_ios_corelocation_CLLocationCoordinate2D setCLLocationCoordinate2D:[center getCLLocationCoordinate2D]];
}

// CLLocationCoordinate2D center;
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) getCenter__
{
    return [self->center_crossmobile_ios_corelocation_CLLocationCoordinate2D retain];
}

// MKCoordinateSpan span;
- (void) setSpan___crossmobile_ios_mapkit_MKCoordinateSpan:(crossmobile_ios_mapkit_MKCoordinateSpan*) span 
{
    [self->span_crossmobile_ios_mapkit_MKCoordinateSpan setMKCoordinateSpan:[span getMKCoordinateSpan]];
}

// MKCoordinateSpan span;
- (crossmobile_ios_mapkit_MKCoordinateSpan*) getSpan__
{
    return [self->span_crossmobile_ios_mapkit_MKCoordinateSpan retain];
}

+ (id) alloc
{
    crossmobile_ios_mapkit_MKCoordinateRegion* obj = [super alloc];
    obj->center_crossmobile_ios_corelocation_CLLocationCoordinate2D = [crossmobile_ios_corelocation_CLLocationCoordinate2D alloc];
    obj->span_crossmobile_ios_mapkit_MKCoordinateSpan = [crossmobile_ios_mapkit_MKCoordinateSpan alloc];
    return obj;
}

- (void) dealloc
{
    [center_crossmobile_ios_corelocation_CLLocationCoordinate2D release];
    [span_crossmobile_ios_mapkit_MKCoordinateSpan release];
    [super dealloc];
}

- (instancetype) initWithMKCoordinateRegion:(MKCoordinateRegion) other
{
    self = [super init];
    self->center_crossmobile_ios_corelocation_CLLocationCoordinate2D->latitude_double = other.center.latitude;
    self->center_crossmobile_ios_corelocation_CLLocationCoordinate2D->longitude_double = other.center.longitude;
    self->span_crossmobile_ios_mapkit_MKCoordinateSpan->latitudeDelta_double = other.span.latitudeDelta;
    self->span_crossmobile_ios_mapkit_MKCoordinateSpan->longitudeDelta_double = other.span.longitudeDelta;
    return self;
}

- (void) setMKCoordinateRegion:(MKCoordinateRegion) other
{
    self->center_crossmobile_ios_corelocation_CLLocationCoordinate2D->latitude_double = other.center.latitude;
    self->center_crossmobile_ios_corelocation_CLLocationCoordinate2D->longitude_double = other.center.longitude;
    self->span_crossmobile_ios_mapkit_MKCoordinateSpan->latitudeDelta_double = other.span.latitudeDelta;
    self->span_crossmobile_ios_mapkit_MKCoordinateSpan->longitudeDelta_double = other.span.longitudeDelta;
}

- (MKCoordinateRegion) getMKCoordinateRegion
{
    MKCoordinateRegion result;
    result.center.latitude = self->center_crossmobile_ios_corelocation_CLLocationCoordinate2D->latitude_double;
    result.center.longitude = self->center_crossmobile_ios_corelocation_CLLocationCoordinate2D->longitude_double;
    result.span.latitudeDelta = self->span_crossmobile_ios_mapkit_MKCoordinateSpan->latitudeDelta_double;
    result.span.longitudeDelta = self->span_crossmobile_ios_mapkit_MKCoordinateSpan->longitudeDelta_double;
    return result;
}

@end
