// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_corelocation_CLLocation implementation

#import "crossmobile_ios_corelocation_CLLocation.h"
#import "crossmobile_ios_corelocation_CLLocationCoordinate2D.h"
#import "crossmobile_ios_foundation_NSDate.h"

@implementation crossmobile_ios_corelocation_CLLocation$Ext

@end

@implementation CLLocation (cm_crossmobile_ios_corelocation_CLLocation)

// - (instancetype)initWithCoordinate:(CLLocationCoordinate2D)coordinate altitude:(CLLocationDistance)altitude horizontalAccuracy:(CLLocationAccuracy)hAccuracy verticalAccuracy:(CLLocationAccuracy)vAccuracy timestamp:(NSDate *)timestamp;
- (instancetype) __init_crossmobile_ios_corelocation_CLLocation___crossmobile_ios_corelocation_CLLocationCoordinate2D_double_double_double_crossmobile_ios_foundation_NSDate:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate :(double) altitude :(double) hAccuracy :(double) vAccuracy :(NSDate*) timestamp 
{
    return [self initWithCoordinate:[coordinate getCLLocationCoordinate2D] altitude:altitude horizontalAccuracy:hAccuracy verticalAccuracy:vAccuracy timestamp:(timestamp == JAVA_NULL ? nil : timestamp)];
}

// - (instancetype)initWithCoordinate:(CLLocationCoordinate2D)coordinate altitude:(CLLocationDistance)altitude horizontalAccuracy:(CLLocationAccuracy)hAccuracy verticalAccuracy:(CLLocationAccuracy)vAccuracy course:(CLLocationDirection)course speed:(CLLocationSpeed)speed timestamp:(NSDate *)timestamp;
- (instancetype) __init_crossmobile_ios_corelocation_CLLocation___crossmobile_ios_corelocation_CLLocationCoordinate2D_double_double_double_double_double_crossmobile_ios_foundation_NSDate:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate :(double) altitude :(double) hAccuracy :(double) vAccuracy :(double) course :(double) speed :(NSDate*) timestamp 
{
    return [self initWithCoordinate:[coordinate getCLLocationCoordinate2D] altitude:altitude horizontalAccuracy:hAccuracy verticalAccuracy:vAccuracy course:course speed:speed timestamp:(timestamp == JAVA_NULL ? nil : timestamp)];
}

// - (instancetype)initWithLatitude:(CLLocationDegrees)latitude longitude:(CLLocationDegrees)longitude;
- (instancetype) __init_crossmobile_ios_corelocation_CLLocation___double_double:(double) latitude :(double) longitude 
{
    return [self initWithLatitude:latitude longitude:longitude];
}

// @property(readonly, nonatomic) CLLocationDistance altitude;
- (double) altitude__
{
    return [self altitude];
}

// @property(readonly, nonatomic) CLLocationCoordinate2D coordinate;
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate__
{
    return [[crossmobile_ios_corelocation_CLLocationCoordinate2D alloc] initWithCLLocationCoordinate2D:[self coordinate]];
}

// @property(readonly, nonatomic) CLLocationDirection course;
- (double) course__
{
    return [self course];
}

// @property(readonly, nonatomic) CLLocationAccuracy horizontalAccuracy;
- (double) horizontalAccuracy__
{
    return [self horizontalAccuracy];
}

// @property(readonly, nonatomic) CLLocationSpeed speed;
- (double) speed__
{
    return [self speed];
}

// @property(readonly, nonatomic, copy) NSDate *timestamp;
- (NSDate*) timestamp__
{
    NSDate* re$ult = [self timestamp];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, nonatomic) CLLocationAccuracy verticalAccuracy;
- (double) verticalAccuracy__
{
    return [self verticalAccuracy];
}

// - (CLLocationDistance)distanceFromLocation:(const CLLocation *)location;
- (double) distanceFromLocation___crossmobile_ios_corelocation_CLLocation:(CLLocation*) location 
{
    return [self distanceFromLocation:(location == JAVA_NULL ? nil : location)];
}

@end
