// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile_ios_corelocation_CLLocationManagerDelegate definition

#import "xmlvm.h"
#import <CoreLocation/CoreLocation.h>
#import <MapKit/MapKit.h>
@class crossmobile_ios_corelocation_CLHeading;
@class crossmobile_ios_corelocation_CLLocation;
@class crossmobile_ios_corelocation_CLLocationManager;
@class crossmobile_ios_corelocation_CLRegion;
@class crossmobile_ios_foundation_NSError;

@protocol crossmobile_ios_corelocation_CLLocationManagerDelegate
- (void) didEnterRegion___crossmobile_ios_corelocation_CLLocationManager_crossmobile_ios_corelocation_CLRegion:(CLLocationManager*) manager :(CLRegion*) region ;
- (void) didExitRegion___crossmobile_ios_corelocation_CLLocationManager_crossmobile_ios_corelocation_CLRegion:(CLLocationManager*) manager :(CLRegion*) region ;
- (void) didFailWithError___crossmobile_ios_corelocation_CLLocationManager_crossmobile_ios_foundation_NSError:(CLLocationManager*) manager :(NSError*) error ;
- (void) didUpdateHeading___crossmobile_ios_corelocation_CLLocationManager_crossmobile_ios_corelocation_CLHeading:(CLLocationManager*) manager :(CLHeading*) newHeading ;
- (void) didUpdateToLocation___crossmobile_ios_corelocation_CLLocationManager_crossmobile_ios_corelocation_CLLocation_crossmobile_ios_corelocation_CLLocation:(CLLocationManager*) manager :(CLLocation*) newLocation :(CLLocation*) oldLocation ;
- (void) monitoringDidFailForRegion___crossmobile_ios_corelocation_CLLocationManager_crossmobile_ios_corelocation_CLRegion_crossmobile_ios_foundation_NSError:(CLLocationManager*) manager :(CLRegion*) region :(NSError*) error ;
- (BOOL) shouldDisplayHeadingCalibration___crossmobile_ios_corelocation_CLLocationManager:(CLLocationManager*) manager ;
@end
