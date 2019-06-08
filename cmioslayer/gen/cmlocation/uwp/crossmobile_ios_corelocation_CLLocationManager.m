// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.corelocation.CLLocationManager implementation

#import "crossmobile_ios_corelocation_CLHeading.h"
#import "crossmobile_ios_corelocation_CLLocation.h"
#import "crossmobile_ios_corelocation_CLLocationManager.h"
#import "crossmobile_ios_corelocation_CLLocationManagerDelegate.h"
#import "crossmobile_ios_corelocation_CLRegion.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"
#import "java_util_Set.h"

@implementation crossmobile_ios_corelocation_CLLocationManager$Ext

// (CLLocationManager) @property(assign, nonatomic) id<CLLocationManagerDelegate> delegate;
- (void) setDelegate___crossmobile_ios_corelocation_CLLocationManagerDelegate:(id<CLLocationManagerDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [super setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// (CLLocationManager) @property(assign, nonatomic) id<CLLocationManagerDelegate> delegate;
- (id<CLLocationManagerDelegate>) delegate__
{
    id<CLLocationManagerDelegate> re$ult = [super delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CLLocationManager) @property(assign, nonatomic) CLLocationAccuracy desiredAccuracy;
- (void) setDesiredAccuracy___double:(double) desiredAccuracy 
{
    [super setDesiredAccuracy:desiredAccuracy];
}

// (CLLocationManager) @property(assign, nonatomic) CLLocationAccuracy desiredAccuracy;
- (double) desiredAccuracy__
{
    return [super desiredAccuracy];
}

// (CLLocationManager) @property(assign, nonatomic) CLLocationDistance distanceFilter;
- (void) setDistanceFilter___double:(double) distanceFilter 
{
    [super setDistanceFilter:distanceFilter];
}

// (CLLocationManager) @property(assign, nonatomic) CLLocationDistance distanceFilter;
- (double) distanceFilter__
{
    return [super distanceFilter];
}

// (CLLocationManager) @property(readonly, nonatomic, copy) CLHeading *heading;
- (CLHeading*) heading__
{
    CLHeading* re$ult = [super heading];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CLLocationManager) @property(assign, nonatomic) CLLocationDegrees headingFilter;
- (void) setHeadingFilter___double:(double) headingFilter 
{
    [super setHeadingFilter:headingFilter];
}

// (CLLocationManager) @property(assign, nonatomic) CLLocationDegrees headingFilter;
- (double) headingFilter__
{
    return [super headingFilter];
}

// (CLLocationManager) @property(assign, nonatomic) CLDeviceOrientation headingOrientation;
- (void) setHeadingOrientation___int:(int) headingOrientation 
{
    [super setHeadingOrientation:headingOrientation];
}

// (CLLocationManager) @property(assign, nonatomic) CLDeviceOrientation headingOrientation;
- (int) headingOrientation__
{
    return [super headingOrientation];
}

// (CLLocationManager) @property(readonly, nonatomic, copy) CLLocation *location;
- (CLLocation*) location__
{
    CLLocation* re$ult = [super location];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CLLocationManager) @property(readonly, nonatomic) CLLocationDistance maximumRegionMonitoringDistance;
- (double) maximumRegionMonitoringDistance__
{
    return [super maximumRegionMonitoringDistance];
}

// (CLLocationManager) @property(readonly, nonatomic, copy) NSSet<__kindof CLRegion *> *monitoredRegions;
- (NSSet*) monitoredRegions__
{
    NSSet* re$ult = [super monitoredRegions];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CLLocationManager) @property(copy, nonatomic) NSString *purpose;
- (void) setPurpose___java_lang_String:(NSString*) purpose 
{
    [super setPurpose:(purpose == JAVA_NULL ? nil : purpose)];
}

// (CLLocationManager) @property(copy, nonatomic) NSString *purpose;
- (NSString*) purpose__
{
    NSString* re$ult = [super purpose];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
}

// (CLLocationManager) - (void)dismissHeadingCalibrationDisplay;
- (void) dismissHeadingCalibrationDisplay__
{
    [super dismissHeadingCalibrationDisplay];
}

// (NSObject) - (void)observeValueForKeyPath:(NSString *)keyPath ofObject:(id)object change:(NSDictionary<NSKeyValueChangeKey, id> *)change context:(void *)context;
- (void) observeValueForKeyPath___java_lang_String_java_lang_Object_java_util_Map_java_lang_Object:(NSString*) keyPath :(id) object :(NSDictionary*) change :(id) context 
{
    [super observeValueForKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) ofObject:(object == JAVA_NULL ? nil : object) change:(change == JAVA_NULL ? nil : change) context:(context == JAVA_NULL ? nil : context)];
}

// (NSObject) - (void)removeObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath;
- (void) removeObserver___crossmobile_ios_foundation_NSObject_java_lang_String:(NSObject*) observer :(NSString*) keyPath 
{
    [super removeObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath)];
}

// (NSObject) - (void)removeObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath context:(void *)context;
- (void) removeObserver___crossmobile_ios_foundation_NSObject_java_lang_String_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(id) context 
{
    [super removeObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) context:(context == JAVA_NULL ? nil : context)];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValueForKey___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (void)setValue:(id)value forUndefinedKey:(NSString *)key;
- (void) setValueForUndefinedKey___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forUndefinedKey:(key == JAVA_NULL ? nil : key)];
}

// (CLLocationManager) - (void)startMonitoringForRegion:(CLRegion *)region desiredAccuracy:(CLLocationAccuracy)accuracy;
- (void) startMonitoringForRegion___crossmobile_ios_corelocation_CLRegion_double:(CLRegion*) region :(double) accuracy 
{
    [super startMonitoringForRegion:(region == JAVA_NULL ? nil : region) desiredAccuracy:accuracy];
}

// (CLLocationManager) - (void)startMonitoringSignificantLocationChanges;
- (void) startMonitoringSignificantLocationChanges__
{
    [super startMonitoringSignificantLocationChanges];
}

// (CLLocationManager) - (void)startUpdatingHeading;
- (void) startUpdatingHeading__
{
    [super startUpdatingHeading];
}

// (CLLocationManager) - (void)startUpdatingLocation;
- (void) startUpdatingLocation__
{
    [super startUpdatingLocation];
}

// (CLLocationManager) - (void)stopMonitoringForRegion:(CLRegion *)region;
- (void) stopMonitoringForRegion___crossmobile_ios_corelocation_CLRegion:(CLRegion*) region 
{
    [super stopMonitoringForRegion:(region == JAVA_NULL ? nil : region)];
}

// (CLLocationManager) - (void)stopMonitoringSignificantLocationChanges;
- (void) stopMonitoringSignificantLocationChanges__
{
    [super stopMonitoringSignificantLocationChanges];
}

// (CLLocationManager) - (void)stopUpdatingHeading;
- (void) stopUpdatingHeading__
{
    [super stopUpdatingHeading];
}

// (CLLocationManager) - (void)stopUpdatingLocation;
- (void) stopUpdatingLocation__
{
    [super stopUpdatingLocation];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (id)valueForUndefinedKey:(NSString *)key;
- (id) valueForUndefinedKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForUndefinedKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end

@implementation CLLocationManager (cm_crossmobile_ios_corelocation_CLLocationManager)

// direct binding of: + (BOOL)headingAvailable;
+ (BOOL) headingAvailable__
{
    return [CLLocationManager headingAvailable];
}

// direct binding of: + (BOOL)locationServicesEnabled;
+ (BOOL) locationServicesEnabled__
{
    return [CLLocationManager locationServicesEnabled];
}

// direct binding of: + (BOOL)regionMonitoringAvailable;
+ (BOOL) regionMonitoringAvailable__
{
    return [CLLocationManager regionMonitoringAvailable];
}

// direct binding of: + (BOOL)regionMonitoringEnabled;
+ (BOOL) regionMonitoringEnabled__
{
    return [CLLocationManager regionMonitoringEnabled];
}

// direct binding of: + (BOOL)significantLocationChangeMonitoringAvailable;
+ (BOOL) significantLocationChangeMonitoringAvailable__
{
    return [CLLocationManager significantLocationChangeMonitoringAvailable];
}

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_corelocation_CLLocationManager__
{
    return [self init];
}

// direct binding of: @property(assign, nonatomic) id<CLLocationManagerDelegate> delegate;
- (void) setDelegate___crossmobile_ios_corelocation_CLLocationManagerDelegate:(id<CLLocationManagerDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// direct binding of: @property(assign, nonatomic) id<CLLocationManagerDelegate> delegate;
- (id<CLLocationManagerDelegate>) delegate__
{
    id<CLLocationManagerDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(assign, nonatomic) CLLocationAccuracy desiredAccuracy;
- (void) setDesiredAccuracy___double:(double) desiredAccuracy 
{
    [self setDesiredAccuracy:desiredAccuracy];
}

// direct binding of: @property(assign, nonatomic) CLLocationAccuracy desiredAccuracy;
- (double) desiredAccuracy__
{
    return [self desiredAccuracy];
}

// direct binding of: @property(assign, nonatomic) CLLocationDistance distanceFilter;
- (void) setDistanceFilter___double:(double) distanceFilter 
{
    [self setDistanceFilter:distanceFilter];
}

// direct binding of: @property(assign, nonatomic) CLLocationDistance distanceFilter;
- (double) distanceFilter__
{
    return [self distanceFilter];
}

// direct binding of: @property(readonly, nonatomic, copy) CLHeading *heading;
- (CLHeading*) heading__
{
    CLHeading* re$ult = [self heading];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(assign, nonatomic) CLLocationDegrees headingFilter;
- (void) setHeadingFilter___double:(double) headingFilter 
{
    [self setHeadingFilter:headingFilter];
}

// direct binding of: @property(assign, nonatomic) CLLocationDegrees headingFilter;
- (double) headingFilter__
{
    return [self headingFilter];
}

// direct binding of: @property(assign, nonatomic) CLDeviceOrientation headingOrientation;
- (void) setHeadingOrientation___int:(int) headingOrientation 
{
    [self setHeadingOrientation:headingOrientation];
}

// direct binding of: @property(assign, nonatomic) CLDeviceOrientation headingOrientation;
- (int) headingOrientation__
{
    return [self headingOrientation];
}

// direct binding of: @property(readonly, nonatomic, copy) CLLocation *location;
- (CLLocation*) location__
{
    CLLocation* re$ult = [self location];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, nonatomic) CLLocationDistance maximumRegionMonitoringDistance;
- (double) maximumRegionMonitoringDistance__
{
    return [self maximumRegionMonitoringDistance];
}

// direct binding of: @property(readonly, nonatomic, copy) NSSet<__kindof CLRegion *> *monitoredRegions;
- (NSSet*) monitoredRegions__
{
    NSSet* re$ult = [self monitoredRegions];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(copy, nonatomic) NSString *purpose;
- (void) setPurpose___java_lang_String:(NSString*) purpose 
{
    [self setPurpose:(purpose == JAVA_NULL ? nil : purpose)];
}

// direct binding of: @property(copy, nonatomic) NSString *purpose;
- (NSString*) purpose__
{
    NSString* re$ult = [self purpose];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (void)dismissHeadingCalibrationDisplay;
- (void) dismissHeadingCalibrationDisplay__
{
    [self dismissHeadingCalibrationDisplay];
}

// direct binding of: - (void)startMonitoringForRegion:(CLRegion *)region desiredAccuracy:(CLLocationAccuracy)accuracy;
- (void) startMonitoringForRegion___crossmobile_ios_corelocation_CLRegion_double:(CLRegion*) region :(double) accuracy 
{
    [self startMonitoringForRegion:(region == JAVA_NULL ? nil : region) desiredAccuracy:accuracy];
}

// direct binding of: - (void)startMonitoringSignificantLocationChanges;
- (void) startMonitoringSignificantLocationChanges__
{
    [self startMonitoringSignificantLocationChanges];
}

// direct binding of: - (void)startUpdatingHeading;
- (void) startUpdatingHeading__
{
    [self startUpdatingHeading];
}

// direct binding of: - (void)startUpdatingLocation;
- (void) startUpdatingLocation__
{
    [self startUpdatingLocation];
}

// direct binding of: - (void)stopMonitoringForRegion:(CLRegion *)region;
- (void) stopMonitoringForRegion___crossmobile_ios_corelocation_CLRegion:(CLRegion*) region 
{
    [self stopMonitoringForRegion:(region == JAVA_NULL ? nil : region)];
}

// direct binding of: - (void)stopMonitoringSignificantLocationChanges;
- (void) stopMonitoringSignificantLocationChanges__
{
    [self stopMonitoringSignificantLocationChanges];
}

// direct binding of: - (void)stopUpdatingHeading;
- (void) stopUpdatingHeading__
{
    [self stopUpdatingHeading];
}

// direct binding of: - (void)stopUpdatingLocation;
- (void) stopUpdatingLocation__
{
    [self stopUpdatingLocation];
}

@end
