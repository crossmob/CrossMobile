// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.mapkit.MKReverseGeocoder implementation

#import "crossmobile_ios_corelocation_CLLocationCoordinate2D.h"
#import "crossmobile_ios_mapkit_MKPlacemark.h"
#import "crossmobile_ios_mapkit_MKReverseGeocoder.h"
#import "crossmobile_ios_mapkit_MKReverseGeocoderDelegate.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_mapkit_MKReverseGeocoder$Ext

// (MKReverseGeocoder) @property(nonatomic, readonly) CLLocationCoordinate2D coordinate;
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate__
{
    return [[crossmobile_ios_corelocation_CLLocationCoordinate2D alloc] initWithCLLocationCoordinate2D:[super coordinate]];
}

// (MKReverseGeocoder) @property(nonatomic, weak) id<MKReverseGeocoderDelegate> delegate;
- (void) setDelegate___crossmobile_ios_mapkit_MKReverseGeocoderDelegate:(id<MKReverseGeocoderDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [super setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// (MKReverseGeocoder) @property(nonatomic, weak) id<MKReverseGeocoderDelegate> delegate;
- (id<MKReverseGeocoderDelegate>) delegate__
{
    id<MKReverseGeocoderDelegate> re$ult = [super delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (MKReverseGeocoder) @property(nonatomic, readonly) MKPlacemark *placemark;
- (MKPlacemark*) placemark__
{
    MKPlacemark* re$ult = [super placemark];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (MKReverseGeocoder) @property(nonatomic, readonly, getter=isQuerying) BOOL querying;
- (BOOL) isQuerying__
{
    return [super isQuerying];
}

// (MKReverseGeocoder) - (void)cancel;
- (void) cancel__
{
    [super cancel];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValue___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (MKReverseGeocoder) - (void)start;
- (void) start__
{
    [super start];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end

@implementation MKReverseGeocoder (cm_crossmobile_ios_mapkit_MKReverseGeocoder)

// direct binding of: - (instancetype)initWithCoordinate:(CLLocationCoordinate2D)coordinate;
- (instancetype) __init_crossmobile_ios_mapkit_MKReverseGeocoder___crossmobile_ios_corelocation_CLLocationCoordinate2D:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate 
{
    return [self initWithCoordinate:[coordinate getCLLocationCoordinate2D]];
}

// direct binding of: @property(nonatomic, readonly) CLLocationCoordinate2D coordinate;
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate__
{
    return [[crossmobile_ios_corelocation_CLLocationCoordinate2D alloc] initWithCLLocationCoordinate2D:[self coordinate]];
}

// direct binding of: @property(nonatomic, weak) id<MKReverseGeocoderDelegate> delegate;
- (void) setDelegate___crossmobile_ios_mapkit_MKReverseGeocoderDelegate:(id<MKReverseGeocoderDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// direct binding of: @property(nonatomic, weak) id<MKReverseGeocoderDelegate> delegate;
- (id<MKReverseGeocoderDelegate>) delegate__
{
    id<MKReverseGeocoderDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) MKPlacemark *placemark;
- (MKPlacemark*) placemark__
{
    MKPlacemark* re$ult = [self placemark];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly, getter=isQuerying) BOOL querying;
- (BOOL) isQuerying__
{
    return [self isQuerying];
}

// direct binding of: - (void)cancel;
- (void) cancel__
{
    [self cancel];
}

// direct binding of: - (void)start;
- (void) start__
{
    [self start];
}

@end
