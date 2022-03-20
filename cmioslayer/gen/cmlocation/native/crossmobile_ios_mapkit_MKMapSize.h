// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_mapkit_MKMapSize definition

#import "xmlvm.h"
#import <CoreLocation/CoreLocation.h>
#import <MapKit/MapKit.h>
#import "java_lang_Object.h"

@interface crossmobile_ios_mapkit_MKMapSize : java_lang_Object {
@public double width_double;
@public double height_double;
}

- (crossmobile_ios_mapkit_MKMapSize*) __init_crossmobile_ios_mapkit_MKMapSize___double_double:(double) width :(double) height ;
- (void) setHeight___double:(double) height ;
- (double) getHeight__;
- (void) setWidth___double:(double) width ;
- (double) getWidth__;
- (instancetype) initWithMKMapSize:(MKMapSize) reference;
- (void) setMKMapSize:(MKMapSize) other;
- (MKMapSize) getMKMapSize;
@end
