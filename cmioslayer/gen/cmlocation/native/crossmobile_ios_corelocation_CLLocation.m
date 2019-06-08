// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.corelocation.CLLocation implementation

#import "crossmobile_ios_corelocation_CLLocation.h"
#import "crossmobile_ios_corelocation_CLLocationCoordinate2D.h"
#import "crossmobile_ios_foundation_NSDate.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_corelocation_CLLocation$Ext

// (CLLocation) @property(readonly, nonatomic) CLLocationDistance altitude;
- (double) altitude__
{
    return [super altitude];
}

// (CLLocation) @property(readonly, nonatomic) CLLocationCoordinate2D coordinate;
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate__
{
    return [[crossmobile_ios_corelocation_CLLocationCoordinate2D alloc] initWithCLLocationCoordinate2D:[super coordinate]];
}

// (CLLocation) @property(readonly, nonatomic) CLLocationDirection course;
- (double) course__
{
    return [super course];
}

// (CLLocation) @property(readonly, nonatomic) CLLocationAccuracy horizontalAccuracy;
- (double) horizontalAccuracy__
{
    return [super horizontalAccuracy];
}

// (CLLocation) @property(readonly, nonatomic) CLLocationSpeed speed;
- (double) speed__
{
    return [super speed];
}

// (CLLocation) @property(readonly, nonatomic, copy) NSDate *timestamp;
- (NSDate*) timestamp__
{
    NSDate* re$ult = [super timestamp];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CLLocation) @property(readonly, nonatomic) CLLocationAccuracy verticalAccuracy;
- (double) verticalAccuracy__
{
    return [super verticalAccuracy];
}

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
}

// (CLLocation) - (CLLocationDistance)distanceFromLocation:(const CLLocation *)location;
- (double) distanceFromLocation___crossmobile_ios_corelocation_CLLocation:(CLLocation*) location 
{
    return [super distanceFromLocation:(location == JAVA_NULL ? nil : location)];
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

@implementation CLLocation (cm_crossmobile_ios_corelocation_CLLocation)

// direct binding of: - (instancetype)initWithCoordinate:(CLLocationCoordinate2D)coordinate altitude:(CLLocationDistance)altitude horizontalAccuracy:(CLLocationAccuracy)hAccuracy verticalAccuracy:(CLLocationAccuracy)vAccuracy timestamp:(NSDate *)timestamp;
- (instancetype) __init_crossmobile_ios_corelocation_CLLocation___crossmobile_ios_corelocation_CLLocationCoordinate2D_double_double_double_crossmobile_ios_foundation_NSDate:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate :(double) altitude :(double) hAccuracy :(double) vAccuracy :(NSDate*) timestamp 
{
    return [self initWithCoordinate:[coordinate getCLLocationCoordinate2D] altitude:altitude horizontalAccuracy:hAccuracy verticalAccuracy:vAccuracy timestamp:(timestamp == JAVA_NULL ? nil : timestamp)];
}

// direct binding of: - (instancetype)initWithCoordinate:(CLLocationCoordinate2D)coordinate altitude:(CLLocationDistance)altitude horizontalAccuracy:(CLLocationAccuracy)hAccuracy verticalAccuracy:(CLLocationAccuracy)vAccuracy course:(CLLocationDirection)course speed:(CLLocationSpeed)speed timestamp:(NSDate *)timestamp;
- (instancetype) __init_crossmobile_ios_corelocation_CLLocation___crossmobile_ios_corelocation_CLLocationCoordinate2D_double_double_double_double_double_crossmobile_ios_foundation_NSDate:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate :(double) altitude :(double) hAccuracy :(double) vAccuracy :(double) course :(double) speed :(NSDate*) timestamp 
{
    return [self initWithCoordinate:[coordinate getCLLocationCoordinate2D] altitude:altitude horizontalAccuracy:hAccuracy verticalAccuracy:vAccuracy course:course speed:speed timestamp:(timestamp == JAVA_NULL ? nil : timestamp)];
}

// direct binding of: - (instancetype)initWithLatitude:(CLLocationDegrees)latitude longitude:(CLLocationDegrees)longitude;
- (instancetype) __init_crossmobile_ios_corelocation_CLLocation___double_double:(double) latitude :(double) longitude 
{
    return [self initWithLatitude:latitude longitude:longitude];
}

// direct binding of: @property(readonly, nonatomic) CLLocationDistance altitude;
- (double) altitude__
{
    return [self altitude];
}

// direct binding of: @property(readonly, nonatomic) CLLocationCoordinate2D coordinate;
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate__
{
    return [[crossmobile_ios_corelocation_CLLocationCoordinate2D alloc] initWithCLLocationCoordinate2D:[self coordinate]];
}

// direct binding of: @property(readonly, nonatomic) CLLocationDirection course;
- (double) course__
{
    return [self course];
}

// direct binding of: @property(readonly, nonatomic) CLLocationAccuracy horizontalAccuracy;
- (double) horizontalAccuracy__
{
    return [self horizontalAccuracy];
}

// direct binding of: @property(readonly, nonatomic) CLLocationSpeed speed;
- (double) speed__
{
    return [self speed];
}

// direct binding of: @property(readonly, nonatomic, copy) NSDate *timestamp;
- (NSDate*) timestamp__
{
    NSDate* re$ult = [self timestamp];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, nonatomic) CLLocationAccuracy verticalAccuracy;
- (double) verticalAccuracy__
{
    return [self verticalAccuracy];
}

// direct binding of: - (CLLocationDistance)distanceFromLocation:(const CLLocation *)location;
- (double) distanceFromLocation___crossmobile_ios_corelocation_CLLocation:(CLLocation*) location 
{
    return [self distanceFromLocation:(location == JAVA_NULL ? nil : location)];
}

@end
