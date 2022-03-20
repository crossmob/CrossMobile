// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_mapkit_MKPlacemark implementation

#import "crossmobile_ios_corelocation_CLLocationCoordinate2D.h"
#import "crossmobile_ios_mapkit_MKPlacemark.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_mapkit_MKPlacemark$Ext

@end

@implementation MKPlacemark (cm_crossmobile_ios_mapkit_MKPlacemark)

// - (instancetype)initWithCoordinate:(CLLocationCoordinate2D)coordinate addressDictionary:(NSDictionary<NSString *,id> *)addressDictionary;
- (instancetype) __init_crossmobile_ios_mapkit_MKPlacemark___crossmobile_ios_corelocation_CLLocationCoordinate2D_java_util_Map:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate :(NSDictionary*) addressDictionary 
{
    return [self initWithCoordinate:[coordinate getCLLocationCoordinate2D] addressDictionary:(addressDictionary == JAVA_NULL ? nil : addressDictionary)];
}

// @property(nonatomic, readonly) CLLocationCoordinate2D coordinate;
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate__
{
    return [[crossmobile_ios_corelocation_CLLocationCoordinate2D alloc] initWithCLLocationCoordinate2D:[self coordinate]];
}

// @property(nonatomic, readonly) NSString *countryCode;
- (NSString*) countryCode__
{
    NSString* re$ult = [self countryCode];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
