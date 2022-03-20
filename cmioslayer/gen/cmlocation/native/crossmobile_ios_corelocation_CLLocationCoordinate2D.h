// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_corelocation_CLLocationCoordinate2D definition

#import "xmlvm.h"
#import <CoreLocation/CoreLocation.h>
#import <MapKit/MapKit.h>
#import "java_lang_Object.h"

@interface crossmobile_ios_corelocation_CLLocationCoordinate2D : java_lang_Object {
@public double latitude_double;
@public double longitude_double;
}

- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) __init_crossmobile_ios_corelocation_CLLocationCoordinate2D___double_double:(double) latitude :(double) longitude ;
- (void) setLatitude___double:(double) latitude ;
- (double) getLatitude__;
- (void) setLongitude___double:(double) longitude ;
- (double) getLongitude__;
- (instancetype) initWithCLLocationCoordinate2D:(CLLocationCoordinate2D) reference;
- (void) setCLLocationCoordinate2D:(CLLocationCoordinate2D) other;
- (CLLocationCoordinate2D) getCLLocationCoordinate2D;
@end
