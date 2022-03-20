// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_corelocation_CLHeading implementation

#import "crossmobile_ios_corelocation_CLHeading.h"
#import "crossmobile_ios_foundation_NSDate.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_corelocation_CLHeading$Ext

@end

@implementation CLHeading (cm_crossmobile_ios_corelocation_CLHeading)

// @property(nonatomic, readonly, copy) NSString *description;
- (NSString*) description__
{
    NSString* re$ult = [self description];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, nonatomic) CLLocationDirection headingAccuracy;
- (double) headingAccuracy__
{
    return [self headingAccuracy];
}

// @property(readonly, nonatomic) CLLocationDirection magneticHeading;
- (double) magneticHeading__
{
    return [self magneticHeading];
}

// @property(readonly, nonatomic, copy) NSDate *timestamp;
- (NSDate*) timestamp__
{
    NSDate* re$ult = [self timestamp];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, nonatomic) CLLocationDirection trueHeading;
- (double) trueHeading__
{
    return [self trueHeading];
}

// @property(readonly, nonatomic) CLHeadingComponentValue x;
- (double) x__
{
    return [self x];
}

// @property(readonly, nonatomic) CLHeadingComponentValue y;
- (double) y__
{
    return [self y];
}

// @property(readonly, nonatomic) CLHeadingComponentValue z;
- (double) z__
{
    return [self z];
}

@end
