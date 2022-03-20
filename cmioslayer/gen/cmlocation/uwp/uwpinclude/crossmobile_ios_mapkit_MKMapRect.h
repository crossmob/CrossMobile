// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_mapkit_MKMapRect definition

#import "xmlvm.h"
#import <CoreLocation/CoreLocation.h>
#import <MapKit/MapKit.h>
#import "java_lang_Object.h"
@class crossmobile_ios_mapkit_MKMapPoint;
@class crossmobile_ios_mapkit_MKMapSize;

CM_EXPORT_CLASS
@interface crossmobile_ios_mapkit_MKMapRect : java_lang_Object {
@public crossmobile_ios_mapkit_MKMapPoint* origin_crossmobile_ios_mapkit_MKMapPoint;
@public crossmobile_ios_mapkit_MKMapSize* size_crossmobile_ios_mapkit_MKMapSize;
}

- (crossmobile_ios_mapkit_MKMapRect*) __init_crossmobile_ios_mapkit_MKMapRect___double_double_double_double:(double) x :(double) y :(double) width :(double) height ;
- (void) setOrigin___crossmobile_ios_mapkit_MKMapPoint:(crossmobile_ios_mapkit_MKMapPoint*) origin ;
- (crossmobile_ios_mapkit_MKMapPoint*) getOrigin__;
- (void) setSize___crossmobile_ios_mapkit_MKMapSize:(crossmobile_ios_mapkit_MKMapSize*) size ;
- (crossmobile_ios_mapkit_MKMapSize*) getSize__;
- (instancetype) initWithMKMapRect:(MKMapRect) reference;
- (void) setMKMapRect:(MKMapRect) other;
- (MKMapRect) getMKMapRect;
@end
