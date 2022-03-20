// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_mapkit_MKReverseGeocoder definition

#import "xmlvm.h"
#import <CoreLocation/CoreLocation.h>
#import <MapKit/MapKit.h>
@class crossmobile_ios_corelocation_CLLocationCoordinate2D;
@class crossmobile_ios_mapkit_MKPlacemark;
@protocol crossmobile_ios_mapkit_MKReverseGeocoderDelegate;

@interface crossmobile_ios_mapkit_MKReverseGeocoder$Ext : MKReverseGeocoder
@end

#define crossmobile_ios_mapkit_MKReverseGeocoder MKReverseGeocoder
@interface MKReverseGeocoder (cm_crossmobile_ios_mapkit_MKReverseGeocoder)
- (instancetype) __init_crossmobile_ios_mapkit_MKReverseGeocoder___crossmobile_ios_corelocation_CLLocationCoordinate2D:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate ;
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate__;
- (void) setDelegate___crossmobile_ios_mapkit_MKReverseGeocoderDelegate:(id<MKReverseGeocoderDelegate>) delegate ;
- (id<MKReverseGeocoderDelegate>) delegate__;
- (MKPlacemark*) placemark__;
- (BOOL) isQuerying__;
- (void) cancel__;
- (void) start__;
@end
