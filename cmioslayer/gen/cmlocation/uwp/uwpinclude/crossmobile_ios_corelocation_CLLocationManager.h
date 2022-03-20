// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_corelocation_CLLocationManager definition

#import "xmlvm.h"
#import <CoreLocation/CoreLocation.h>
#import <MapKit/MapKit.h>
@class crossmobile_ios_corelocation_CLHeading;
@class crossmobile_ios_corelocation_CLLocation;
@protocol crossmobile_ios_corelocation_CLLocationManagerDelegate;
@class crossmobile_ios_corelocation_CLRegion;
@class java_lang_String;
@protocol java_util_Set;

CM_EXPORT_CLASS
@interface crossmobile_ios_corelocation_CLLocationManager$Ext : CLLocationManager
@end

#define crossmobile_ios_corelocation_CLLocationManager CLLocationManager
@interface CLLocationManager (cm_crossmobile_ios_corelocation_CLLocationManager)
+ (BOOL) headingAvailable__;
+ (BOOL) locationServicesEnabled__;
+ (BOOL) regionMonitoringAvailable__;
+ (BOOL) regionMonitoringEnabled__;
+ (BOOL) significantLocationChangeMonitoringAvailable__;
- (instancetype) __init_crossmobile_ios_corelocation_CLLocationManager__;
- (void) setDelegate___crossmobile_ios_corelocation_CLLocationManagerDelegate:(id<CLLocationManagerDelegate>) delegate ;
- (id<CLLocationManagerDelegate>) delegate__;
- (void) setDesiredAccuracy___double:(double) desiredAccuracy ;
- (double) desiredAccuracy__;
- (void) setDistanceFilter___double:(double) distanceFilter ;
- (double) distanceFilter__;
- (CLHeading*) heading__;
- (void) setHeadingFilter___double:(double) headingFilter ;
- (double) headingFilter__;
- (void) setHeadingOrientation___int:(int) headingOrientation ;
- (int) headingOrientation__;
- (CLLocation*) location__;
- (double) maximumRegionMonitoringDistance__;
- (NSSet*) monitoredRegions__;
- (void) setPurpose___java_lang_String:(NSString*) purpose ;
- (NSString*) purpose__;
- (void) dismissHeadingCalibrationDisplay__;
- (void) startMonitoringForRegion___crossmobile_ios_corelocation_CLRegion_double:(CLRegion*) region :(double) accuracy ;
- (void) startMonitoringSignificantLocationChanges__;
- (void) startUpdatingHeading__;
- (void) startUpdatingLocation__;
- (void) stopMonitoringForRegion___crossmobile_ios_corelocation_CLRegion:(CLRegion*) region ;
- (void) stopMonitoringSignificantLocationChanges__;
- (void) stopUpdatingHeading__;
- (void) stopUpdatingLocation__;
@end
