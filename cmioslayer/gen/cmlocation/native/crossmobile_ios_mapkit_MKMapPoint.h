// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_mapkit_MKMapPoint definition

#import "xmlvm.h"
#import <CoreLocation/CoreLocation.h>
#import <MapKit/MapKit.h>
#import "java_lang_Object.h"

@interface crossmobile_ios_mapkit_MKMapPoint : java_lang_Object {
@public double x_double;
@public double y_double;
}

- (crossmobile_ios_mapkit_MKMapPoint*) __init_crossmobile_ios_mapkit_MKMapPoint___double_double:(double) x :(double) y ;
- (void) setX___double:(double) x ;
- (double) getX__;
- (void) setY___double:(double) y ;
- (double) getY__;
- (instancetype) initWithMKMapPoint:(MKMapPoint) reference;
- (void) setMKMapPoint:(MKMapPoint) other;
- (MKMapPoint) getMKMapPoint;
@end
