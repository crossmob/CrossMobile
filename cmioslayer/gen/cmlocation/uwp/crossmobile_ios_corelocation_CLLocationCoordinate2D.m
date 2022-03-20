// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_corelocation_CLLocationCoordinate2D implementation

#import "crossmobile_ios_corelocation_CLLocationCoordinate2D.h"

@implementation crossmobile_ios_corelocation_CLLocationCoordinate2D

// CLLocationCoordinate2D CLLocationCoordinate2DMake(CLLocationDegrees latitude, CLLocationDegrees longitude);
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) __init_crossmobile_ios_corelocation_CLLocationCoordinate2D___double_double:(double) latitude :(double) longitude 
{
    return [self initWithCLLocationCoordinate2D:CLLocationCoordinate2DMake(latitude, longitude)];
}

// CLLocationDegrees latitude;
- (void) setLatitude___double:(double) latitude 
{
    self->latitude_double = latitude;
}

// CLLocationDegrees latitude;
- (double) getLatitude__
{
    return self->latitude_double;
}

// CLLocationDegrees longitude;
- (void) setLongitude___double:(double) longitude 
{
    self->longitude_double = longitude;
}

// CLLocationDegrees longitude;
- (double) getLongitude__
{
    return self->longitude_double;
}

- (instancetype) initWithCLLocationCoordinate2D:(CLLocationCoordinate2D) other
{
    self = [super init];
    self->latitude_double = other.latitude;
    self->longitude_double = other.longitude;
    return self;
}

- (void) setCLLocationCoordinate2D:(CLLocationCoordinate2D) other
{
    self->latitude_double = other.latitude;
    self->longitude_double = other.longitude;
}

- (CLLocationCoordinate2D) getCLLocationCoordinate2D
{
    CLLocationCoordinate2D result;
    result.latitude = self->latitude_double;
    result.longitude = self->longitude_double;
    return result;
}

@end
