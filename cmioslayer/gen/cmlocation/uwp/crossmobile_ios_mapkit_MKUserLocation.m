// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_mapkit_MKUserLocation implementation

#import "crossmobile_ios_corelocation_CLLocation.h"
#import "crossmobile_ios_corelocation_CLLocationCoordinate2D.h"
#import "crossmobile_ios_mapkit_MKUserLocation.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_mapkit_MKUserLocation$Ext

@end

@implementation MKUserLocation (cm_crossmobile_ios_mapkit_MKUserLocation)

// @property(nonatomic, readonly) CLLocationCoordinate2D coordinate;
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate__
{
    return [[crossmobile_ios_corelocation_CLLocationCoordinate2D alloc] initWithCLLocationCoordinate2D:[self coordinate]];
}

// @property(readonly, nonatomic) CLLocation *location;
- (CLLocation*) location__
{
    CLLocation* re$ult = [self location];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, copy) NSString *subtitle;
- (void) setSubtitle___java_lang_String:(NSString*) subtitle 
{
    [self setSubtitle:(subtitle == JAVA_NULL ? nil : subtitle)];
}

// @property(nonatomic, readonly, copy) NSString *subtitle;
- (NSString*) subtitle__
{
    NSString* re$ult = [self subtitle];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, copy) NSString *title;
- (void) setTitle___java_lang_String:(NSString*) title 
{
    [self setTitle:(title == JAVA_NULL ? nil : title)];
}

// @property(nonatomic, readonly, copy) NSString *title;
- (NSString*) title__
{
    NSString* re$ult = [self title];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, nonatomic, getter=isUpdating) BOOL updating;
- (BOOL) isUpdating__
{
    return [self isUpdating];
}

@end
