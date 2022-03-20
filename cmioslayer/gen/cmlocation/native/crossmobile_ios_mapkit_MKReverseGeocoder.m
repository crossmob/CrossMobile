// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_mapkit_MKReverseGeocoder implementation

#import "crossmobile_ios_corelocation_CLLocationCoordinate2D.h"
#import "crossmobile_ios_mapkit_MKPlacemark.h"
#import "crossmobile_ios_mapkit_MKReverseGeocoder.h"
#import "crossmobile_ios_mapkit_MKReverseGeocoderDelegate.h"

@implementation crossmobile_ios_mapkit_MKReverseGeocoder$Ext

@end

@implementation MKReverseGeocoder (cm_crossmobile_ios_mapkit_MKReverseGeocoder)

// - (instancetype)initWithCoordinate:(CLLocationCoordinate2D)coordinate;
- (instancetype) __init_crossmobile_ios_mapkit_MKReverseGeocoder___crossmobile_ios_corelocation_CLLocationCoordinate2D:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate 
{
    return [self initWithCoordinate:[coordinate getCLLocationCoordinate2D]];
}

// @property(nonatomic, readonly) CLLocationCoordinate2D coordinate;
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate__
{
    return [[crossmobile_ios_corelocation_CLLocationCoordinate2D alloc] initWithCLLocationCoordinate2D:[self coordinate]];
}

// @property(nonatomic, weak) id<MKReverseGeocoderDelegate> delegate;
- (void) setDelegate___crossmobile_ios_mapkit_MKReverseGeocoderDelegate:(id<MKReverseGeocoderDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// @property(nonatomic, weak) id<MKReverseGeocoderDelegate> delegate;
- (id<MKReverseGeocoderDelegate>) delegate__
{
    id<MKReverseGeocoderDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) MKPlacemark *placemark;
- (MKPlacemark*) placemark__
{
    MKPlacemark* re$ult = [self placemark];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, getter=isQuerying) BOOL querying;
- (BOOL) isQuerying__
{
    return [self isQuerying];
}

// - (void)cancel;
- (void) cancel__
{
    [self cancel];
}

// - (void)start;
- (void) start__
{
    [self start];
}

@end
