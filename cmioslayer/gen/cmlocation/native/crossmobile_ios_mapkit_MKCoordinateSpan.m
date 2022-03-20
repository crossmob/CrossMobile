// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_mapkit_MKCoordinateSpan implementation

#import "crossmobile_ios_mapkit_MKCoordinateSpan.h"

@implementation crossmobile_ios_mapkit_MKCoordinateSpan

// MKCoordinateSpan MKCoordinateSpanMake ( CLLocationDegrees latitudeDelta, CLLocationDegrees longitudeDelta );
- (crossmobile_ios_mapkit_MKCoordinateSpan*) __init_crossmobile_ios_mapkit_MKCoordinateSpan___double_double:(double) latitudeDelta :(double) longitudeDelta 
{
    return [self initWithMKCoordinateSpan:MKCoordinateSpanMake(latitudeDelta, longitudeDelta)];
}

// CLLocationDegrees latitudeDelta;
- (void) setLatitudeDelta___double:(double) latitudeDelta 
{
    self->latitudeDelta_double = latitudeDelta;
}

// CLLocationDegrees latitudeDelta;
- (double) getLatitudeDelta__
{
    return self->latitudeDelta_double;
}

// CLLocationDegrees longitudeDelta;
- (void) setLongitudeDelta___double:(double) longitudeDelta 
{
    self->longitudeDelta_double = longitudeDelta;
}

// CLLocationDegrees longitudeDelta;
- (double) getLongitudeDelta__
{
    return self->longitudeDelta_double;
}

- (instancetype) initWithMKCoordinateSpan:(MKCoordinateSpan) other
{
    self = [super init];
    self->latitudeDelta_double = other.latitudeDelta;
    self->longitudeDelta_double = other.longitudeDelta;
    return self;
}

- (void) setMKCoordinateSpan:(MKCoordinateSpan) other
{
    self->latitudeDelta_double = other.latitudeDelta;
    self->longitudeDelta_double = other.longitudeDelta;
}

- (MKCoordinateSpan) getMKCoordinateSpan
{
    MKCoordinateSpan result;
    result.latitudeDelta = self->latitudeDelta_double;
    result.longitudeDelta = self->longitudeDelta_double;
    return result;
}

@end
