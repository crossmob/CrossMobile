// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_corelocation_CLRegion implementation

#import "crossmobile_ios_corelocation_CLLocationCoordinate2D.h"
#import "crossmobile_ios_corelocation_CLRegion.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_corelocation_CLRegion$Ext

@end

@implementation CLRegion (cm_crossmobile_ios_corelocation_CLRegion)

// - (instancetype)initCircularRegionWithCenter:(CLLocationCoordinate2D)center radius:(CLLocationDistance)radius identifier:(NSString *)identifier;
- (instancetype) __init_crossmobile_ios_corelocation_CLRegion___crossmobile_ios_corelocation_CLLocationCoordinate2D_double_java_lang_String:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) center :(double) radius :(NSString*) identifier 
{
    return [self initCircularRegionWithCenter:[center getCLLocationCoordinate2D] radius:radius identifier:(identifier == JAVA_NULL ? nil : identifier)];
}

// @property(readonly, nonatomic) CLLocationCoordinate2D center;
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) center__
{
    return [[crossmobile_ios_corelocation_CLLocationCoordinate2D alloc] initWithCLLocationCoordinate2D:[self center]];
}

// @property(readonly, nonatomic, copy) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [self identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, nonatomic) CLLocationDistance radius;
- (double) radius__
{
    return [self radius];
}

// - (BOOL)containsCoordinate:(CLLocationCoordinate2D)coordinate;
- (BOOL) containsCoordinate___crossmobile_ios_corelocation_CLLocationCoordinate2D:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate 
{
    return [self containsCoordinate:[coordinate getCLLocationCoordinate2D]];
}

@end
