// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_corelocation_CLPlacemark definition

#import "xmlvm.h"
#import <CoreLocation/CoreLocation.h>
#import <MapKit/MapKit.h>
@class crossmobile_ios_corelocation_CLLocation;
@class crossmobile_ios_corelocation_CLRegion;
@class crossmobile_ios_foundation_NSTimeZone;
@class java_lang_String;
@protocol java_util_List;
@protocol java_util_Map;

@interface crossmobile_ios_corelocation_CLPlacemark$Ext : CLPlacemark
@end

#define crossmobile_ios_corelocation_CLPlacemark CLPlacemark
@interface CLPlacemark (cm_crossmobile_ios_corelocation_CLPlacemark)
- (instancetype) __init_crossmobile_ios_corelocation_CLPlacemark___crossmobile_ios_corelocation_CLPlacemark:(CLPlacemark*) placemark ;
- (NSString*) ISOcountryCode__;
- (NSDictionary*) addressDictionary__;
- (NSString*) administrativeArea__;
- (NSArray*) areasOfInterest__;
- (NSString*) country__;
- (NSString*) inlandWater__;
- (NSString*) locality__;
- (CLLocation*) location__;
- (NSString*) ocean__;
- (NSString*) postalCode__;
- (CLRegion*) region__;
- (NSString*) subAdministrativeArea__;
- (NSString*) subLocality__;
- (NSString*) subThoroughfare__;
- (NSString*) thoroughfare__;
- (NSTimeZone*) timeZone__;
@end
