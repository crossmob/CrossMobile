// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_corelocation_CLLocationManager implementation

#import "crossmobile_ios_corelocation_CLHeading.h"
#import "crossmobile_ios_corelocation_CLLocation.h"
#import "crossmobile_ios_corelocation_CLLocationManager.h"
#import "crossmobile_ios_corelocation_CLLocationManagerDelegate.h"
#import "crossmobile_ios_corelocation_CLRegion.h"
#import "java_lang_String.h"
#import "java_util_Set.h"

@implementation crossmobile_ios_corelocation_CLLocationManager$Ext

@end

@implementation CLLocationManager (cm_crossmobile_ios_corelocation_CLLocationManager)

// + (BOOL)headingAvailable;
+ (BOOL) headingAvailable__
{
    return [CLLocationManager headingAvailable];
}

// + (BOOL)locationServicesEnabled;
+ (BOOL) locationServicesEnabled__
{
    return [CLLocationManager locationServicesEnabled];
}

// + (BOOL)regionMonitoringAvailable;
+ (BOOL) regionMonitoringAvailable__
{
    return [CLLocationManager regionMonitoringAvailable];
}

// + (BOOL)regionMonitoringEnabled;
+ (BOOL) regionMonitoringEnabled__
{
    return [CLLocationManager regionMonitoringEnabled];
}

// + (BOOL)significantLocationChangeMonitoringAvailable;
+ (BOOL) significantLocationChangeMonitoringAvailable__
{
    return [CLLocationManager significantLocationChangeMonitoringAvailable];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_corelocation_CLLocationManager__
{
    return [self init];
}

// @property(assign, nonatomic) id<CLLocationManagerDelegate> delegate;
- (void) setDelegate___crossmobile_ios_corelocation_CLLocationManagerDelegate:(id<CLLocationManagerDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// @property(assign, nonatomic) id<CLLocationManagerDelegate> delegate;
- (id<CLLocationManagerDelegate>) delegate__
{
    id<CLLocationManagerDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(assign, nonatomic) CLLocationAccuracy desiredAccuracy;
- (void) setDesiredAccuracy___double:(double) desiredAccuracy 
{
    [self setDesiredAccuracy:desiredAccuracy];
}

// @property(assign, nonatomic) CLLocationAccuracy desiredAccuracy;
- (double) desiredAccuracy__
{
    return [self desiredAccuracy];
}

// @property(assign, nonatomic) CLLocationDistance distanceFilter;
- (void) setDistanceFilter___double:(double) distanceFilter 
{
    [self setDistanceFilter:distanceFilter];
}

// @property(assign, nonatomic) CLLocationDistance distanceFilter;
- (double) distanceFilter__
{
    return [self distanceFilter];
}

// @property(readonly, nonatomic, copy) CLHeading *heading;
- (CLHeading*) heading__
{
    CLHeading* re$ult = [self heading];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(assign, nonatomic) CLLocationDegrees headingFilter;
- (void) setHeadingFilter___double:(double) headingFilter 
{
    [self setHeadingFilter:headingFilter];
}

// @property(assign, nonatomic) CLLocationDegrees headingFilter;
- (double) headingFilter__
{
    return [self headingFilter];
}

// @property(assign, nonatomic) CLDeviceOrientation headingOrientation;
- (void) setHeadingOrientation___int:(int) headingOrientation 
{
    [self setHeadingOrientation:headingOrientation];
}

// @property(assign, nonatomic) CLDeviceOrientation headingOrientation;
- (int) headingOrientation__
{
    return [self headingOrientation];
}

// @property(readonly, nonatomic, copy) CLLocation *location;
- (CLLocation*) location__
{
    CLLocation* re$ult = [self location];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, nonatomic) CLLocationDistance maximumRegionMonitoringDistance;
- (double) maximumRegionMonitoringDistance__
{
    return [self maximumRegionMonitoringDistance];
}

// @property(readonly, nonatomic, copy) NSSet<__kindof CLRegion *> *monitoredRegions;
- (NSSet*) monitoredRegions__
{
    NSSet* re$ult = [self monitoredRegions];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(copy, nonatomic) NSString *purpose;
- (void) setPurpose___java_lang_String:(NSString*) purpose 
{
    [self setPurpose:(purpose == JAVA_NULL ? nil : purpose)];
}

// @property(copy, nonatomic) NSString *purpose;
- (NSString*) purpose__
{
    NSString* re$ult = [self purpose];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)dismissHeadingCalibrationDisplay;
- (void) dismissHeadingCalibrationDisplay__
{
    [self dismissHeadingCalibrationDisplay];
}

// - (void)startMonitoringForRegion:(CLRegion *)region desiredAccuracy:(CLLocationAccuracy)accuracy;
- (void) startMonitoringForRegion___crossmobile_ios_corelocation_CLRegion_double:(CLRegion*) region :(double) accuracy 
{
    [self startMonitoringForRegion:(region == JAVA_NULL ? nil : region) desiredAccuracy:accuracy];
}

// - (void)startMonitoringSignificantLocationChanges;
- (void) startMonitoringSignificantLocationChanges__
{
    [self startMonitoringSignificantLocationChanges];
}

// - (void)startUpdatingHeading;
- (void) startUpdatingHeading__
{
    [self startUpdatingHeading];
}

// - (void)startUpdatingLocation;
- (void) startUpdatingLocation__
{
    [self startUpdatingLocation];
}

// - (void)stopMonitoringForRegion:(CLRegion *)region;
- (void) stopMonitoringForRegion___crossmobile_ios_corelocation_CLRegion:(CLRegion*) region 
{
    [self stopMonitoringForRegion:(region == JAVA_NULL ? nil : region)];
}

// - (void)stopMonitoringSignificantLocationChanges;
- (void) stopMonitoringSignificantLocationChanges__
{
    [self stopMonitoringSignificantLocationChanges];
}

// - (void)stopUpdatingHeading;
- (void) stopUpdatingHeading__
{
    [self stopUpdatingHeading];
}

// - (void)stopUpdatingLocation;
- (void) stopUpdatingLocation__
{
    [self stopUpdatingLocation];
}

@end
