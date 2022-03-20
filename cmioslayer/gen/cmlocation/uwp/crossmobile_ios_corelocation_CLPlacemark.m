// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_corelocation_CLPlacemark implementation

#import "crossmobile_ios_corelocation_CLLocation.h"
#import "crossmobile_ios_corelocation_CLPlacemark.h"
#import "crossmobile_ios_corelocation_CLRegion.h"
#import "crossmobile_ios_foundation_NSTimeZone.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_corelocation_CLPlacemark$Ext

@end

@implementation CLPlacemark (cm_crossmobile_ios_corelocation_CLPlacemark)

// - (instancetype)initWithPlacemark:(CLPlacemark *)placemark;
- (instancetype) __init_crossmobile_ios_corelocation_CLPlacemark___crossmobile_ios_corelocation_CLPlacemark:(CLPlacemark*) placemark 
{
    return [self initWithPlacemark:(placemark == JAVA_NULL ? nil : placemark)];
}

// @property(nonatomic, readonly, copy) NSString *ISOcountryCode;
- (NSString*) ISOcountryCode__
{
    NSString* re$ult = [self ISOcountryCode];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, copy) NSDictionary *addressDictionary;
- (NSDictionary*) addressDictionary__
{
    NSDictionary* re$ult = [self addressDictionary];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, copy) NSString *administrativeArea;
- (NSString*) administrativeArea__
{
    NSString* re$ult = [self administrativeArea];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, copy) NSArray <NSString *> *areasOfInterest;
- (NSArray*) areasOfInterest__
{
    NSArray* re$ult = [self areasOfInterest];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, copy) NSString *country;
- (NSString*) country__
{
    NSString* re$ult = [self country];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, copy) NSString *inlandWater;
- (NSString*) inlandWater__
{
    NSString* re$ult = [self inlandWater];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, copy) NSString *locality;
- (NSString*) locality__
{
    NSString* re$ult = [self locality];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, copy) CLLocation *location;
- (CLLocation*) location__
{
    CLLocation* re$ult = [self location];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, copy) NSString *ocean;
- (NSString*) ocean__
{
    NSString* re$ult = [self ocean];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, copy) NSString *postalCode;
- (NSString*) postalCode__
{
    NSString* re$ult = [self postalCode];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, copy) CLRegion *region;
- (CLRegion*) region__
{
    CLRegion* re$ult = [self region];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, copy) NSString *subAdministrativeArea;
- (NSString*) subAdministrativeArea__
{
    NSString* re$ult = [self subAdministrativeArea];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, copy) NSString *subLocality;
- (NSString*) subLocality__
{
    NSString* re$ult = [self subLocality];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, copy) NSString *subThoroughfare;
- (NSString*) subThoroughfare__
{
    NSString* re$ult = [self subThoroughfare];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, copy) NSString *thoroughfare;
- (NSString*) thoroughfare__
{
    NSString* re$ult = [self thoroughfare];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, copy) NSTimeZone *timeZone;
- (NSTimeZone*) timeZone__
{
    NSTimeZone* re$ult = [self timeZone];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
