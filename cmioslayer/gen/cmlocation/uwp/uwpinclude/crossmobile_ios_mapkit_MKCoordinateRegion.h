// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_mapkit_MKCoordinateRegion definition

#import "xmlvm.h"
#import <CoreLocation/CoreLocation.h>
#import <MapKit/MapKit.h>
#import "java_lang_Object.h"
@class crossmobile_ios_corelocation_CLLocationCoordinate2D;
@class crossmobile_ios_mapkit_MKCoordinateSpan;

CM_EXPORT_CLASS
@interface crossmobile_ios_mapkit_MKCoordinateRegion : java_lang_Object {
@public crossmobile_ios_corelocation_CLLocationCoordinate2D* center_crossmobile_ios_corelocation_CLLocationCoordinate2D;
@public crossmobile_ios_mapkit_MKCoordinateSpan* span_crossmobile_ios_mapkit_MKCoordinateSpan;
}

- (crossmobile_ios_mapkit_MKCoordinateRegion*) __init_crossmobile_ios_mapkit_MKCoordinateRegion___crossmobile_ios_corelocation_CLLocationCoordinate2D_crossmobile_ios_mapkit_MKCoordinateSpan:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) centerCoordinate :(crossmobile_ios_mapkit_MKCoordinateSpan*) span ;
- (void) setCenter___crossmobile_ios_corelocation_CLLocationCoordinate2D:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) center ;
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) getCenter__;
- (void) setSpan___crossmobile_ios_mapkit_MKCoordinateSpan:(crossmobile_ios_mapkit_MKCoordinateSpan*) span ;
- (crossmobile_ios_mapkit_MKCoordinateSpan*) getSpan__;
- (instancetype) initWithMKCoordinateRegion:(MKCoordinateRegion) reference;
- (void) setMKCoordinateRegion:(MKCoordinateRegion) other;
- (MKCoordinateRegion) getMKCoordinateRegion;
@end
