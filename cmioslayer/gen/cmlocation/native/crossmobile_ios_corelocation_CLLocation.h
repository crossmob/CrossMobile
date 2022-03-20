// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_corelocation_CLLocation definition

#import "xmlvm.h"
#import <CoreLocation/CoreLocation.h>
#import <MapKit/MapKit.h>
@class crossmobile_ios_corelocation_CLLocationCoordinate2D;
@class crossmobile_ios_foundation_NSDate;

@interface crossmobile_ios_corelocation_CLLocation$Ext : CLLocation
@end

#define crossmobile_ios_corelocation_CLLocation CLLocation
@interface CLLocation (cm_crossmobile_ios_corelocation_CLLocation)
- (instancetype) __init_crossmobile_ios_corelocation_CLLocation___crossmobile_ios_corelocation_CLLocationCoordinate2D_double_double_double_crossmobile_ios_foundation_NSDate:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate :(double) altitude :(double) hAccuracy :(double) vAccuracy :(NSDate*) timestamp ;
- (instancetype) __init_crossmobile_ios_corelocation_CLLocation___crossmobile_ios_corelocation_CLLocationCoordinate2D_double_double_double_double_double_crossmobile_ios_foundation_NSDate:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate :(double) altitude :(double) hAccuracy :(double) vAccuracy :(double) course :(double) speed :(NSDate*) timestamp ;
- (instancetype) __init_crossmobile_ios_corelocation_CLLocation___double_double:(double) latitude :(double) longitude ;
- (double) altitude__;
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate__;
- (double) course__;
- (double) horizontalAccuracy__;
- (double) speed__;
- (NSDate*) timestamp__;
- (double) verticalAccuracy__;
- (double) distanceFromLocation___crossmobile_ios_corelocation_CLLocation:(CLLocation*) location ;
@end
