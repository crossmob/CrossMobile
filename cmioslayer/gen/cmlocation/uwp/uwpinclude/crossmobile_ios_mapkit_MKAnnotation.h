// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_mapkit_MKAnnotation definition

#import "xmlvm.h"
#import <CoreLocation/CoreLocation.h>
#import <MapKit/MapKit.h>
@class crossmobile_ios_corelocation_CLLocationCoordinate2D;
@class java_lang_String;

CM_EXPORT_CLASS
@protocol crossmobile_ios_mapkit_MKAnnotation
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate__;
- (NSString*) subtitle__;
- (NSString*) title__;
- (void) setCoordinate___crossmobile_ios_corelocation_CLLocationCoordinate2D:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) newCoordinate ;
@end
