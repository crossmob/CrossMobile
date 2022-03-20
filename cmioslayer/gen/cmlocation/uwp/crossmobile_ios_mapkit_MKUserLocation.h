// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_mapkit_MKUserLocation definition

#import "xmlvm.h"
#import <CoreLocation/CoreLocation.h>
#import <MapKit/MapKit.h>
@class crossmobile_ios_corelocation_CLLocation;
@class crossmobile_ios_corelocation_CLLocationCoordinate2D;
@class java_lang_String;

@interface crossmobile_ios_mapkit_MKUserLocation$Ext : MKUserLocation
@end

#define crossmobile_ios_mapkit_MKUserLocation MKUserLocation
@interface MKUserLocation (cm_crossmobile_ios_mapkit_MKUserLocation)
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate__;
- (CLLocation*) location__;
- (void) setSubtitle___java_lang_String:(NSString*) subtitle ;
- (NSString*) subtitle__;
- (void) setTitle___java_lang_String:(NSString*) title ;
- (NSString*) title__;
- (BOOL) isUpdating__;
@end
