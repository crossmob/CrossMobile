// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_corelocation_CLRegion definition

#import "xmlvm.h"
#import <CoreLocation/CoreLocation.h>
#import <MapKit/MapKit.h>
@class crossmobile_ios_corelocation_CLLocationCoordinate2D;
@class java_lang_String;

CM_EXPORT_CLASS
@interface crossmobile_ios_corelocation_CLRegion$Ext : CLRegion
@end

#define crossmobile_ios_corelocation_CLRegion CLRegion
@interface CLRegion (cm_crossmobile_ios_corelocation_CLRegion)
- (instancetype) __init_crossmobile_ios_corelocation_CLRegion___crossmobile_ios_corelocation_CLLocationCoordinate2D_double_java_lang_String:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) center :(double) radius :(NSString*) identifier ;
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) center__;
- (NSString*) identifier__;
- (double) radius__;
- (BOOL) containsCoordinate___crossmobile_ios_corelocation_CLLocationCoordinate2D:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate ;
@end
