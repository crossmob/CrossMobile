// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_mapkit_MKCoordinateSpan definition

#import "xmlvm.h"
#import <CoreLocation/CoreLocation.h>
#import <MapKit/MapKit.h>
#import "java_lang_Object.h"

@interface crossmobile_ios_mapkit_MKCoordinateSpan : java_lang_Object {
@public double latitudeDelta_double;
@public double longitudeDelta_double;
}

- (crossmobile_ios_mapkit_MKCoordinateSpan*) __init_crossmobile_ios_mapkit_MKCoordinateSpan___double_double:(double) latitudeDelta :(double) longitudeDelta ;
- (void) setLatitudeDelta___double:(double) latitudeDelta ;
- (double) getLatitudeDelta__;
- (void) setLongitudeDelta___double:(double) longitudeDelta ;
- (double) getLongitudeDelta__;
- (instancetype) initWithMKCoordinateSpan:(MKCoordinateSpan) reference;
- (void) setMKCoordinateSpan:(MKCoordinateSpan) other;
- (MKCoordinateSpan) getMKCoordinateSpan;
@end
