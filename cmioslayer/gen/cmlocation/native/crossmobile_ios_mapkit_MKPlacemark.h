// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_mapkit_MKPlacemark definition

#import "xmlvm.h"
#import <CoreLocation/CoreLocation.h>
#import <MapKit/MapKit.h>
@class crossmobile_ios_corelocation_CLLocationCoordinate2D;
@class java_lang_String;
@protocol java_util_Map;

@interface crossmobile_ios_mapkit_MKPlacemark$Ext : MKPlacemark
@end

#define crossmobile_ios_mapkit_MKPlacemark MKPlacemark
@interface MKPlacemark (cm_crossmobile_ios_mapkit_MKPlacemark)
- (instancetype) __init_crossmobile_ios_mapkit_MKPlacemark___crossmobile_ios_corelocation_CLLocationCoordinate2D_java_util_Map:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate :(NSDictionary*) addressDictionary ;
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate__;
- (NSString*) countryCode__;
@end
