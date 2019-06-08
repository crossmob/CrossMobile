// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.corelocation.CLRegion implementation

#import "crossmobile_ios_corelocation_CLLocationCoordinate2D.h"
#import "crossmobile_ios_corelocation_CLRegion.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_corelocation_CLRegion$Ext

// (CLRegion) @property(readonly, nonatomic) CLLocationCoordinate2D center;
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) center__
{
    return [[crossmobile_ios_corelocation_CLLocationCoordinate2D alloc] initWithCLLocationCoordinate2D:[super center]];
}

// (CLRegion) @property(readonly, nonatomic, copy) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [super identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CLRegion) @property(readonly, nonatomic) CLLocationDistance radius;
- (double) radius__
{
    return [super radius];
}

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
}

// (CLRegion) - (BOOL)containsCoordinate:(CLLocationCoordinate2D)coordinate;
- (BOOL) containsCoordinate___crossmobile_ios_corelocation_CLLocationCoordinate2D:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate 
{
    return [super containsCoordinate:[coordinate getCLLocationCoordinate2D]];
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

@implementation CLRegion (cm_crossmobile_ios_corelocation_CLRegion)

// direct binding of: - (instancetype)initCircularRegionWithCenter:(CLLocationCoordinate2D)center radius:(CLLocationDistance)radius identifier:(NSString *)identifier;
- (instancetype) __init_crossmobile_ios_corelocation_CLRegion___crossmobile_ios_corelocation_CLLocationCoordinate2D_double_java_lang_String:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) center :(double) radius :(NSString*) identifier 
{
    return [self initCircularRegionWithCenter:[center getCLLocationCoordinate2D] radius:radius identifier:(identifier == JAVA_NULL ? nil : identifier)];
}

// direct binding of: @property(readonly, nonatomic) CLLocationCoordinate2D center;
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) center__
{
    return [[crossmobile_ios_corelocation_CLLocationCoordinate2D alloc] initWithCLLocationCoordinate2D:[self center]];
}

// direct binding of: @property(readonly, nonatomic, copy) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [self identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, nonatomic) CLLocationDistance radius;
- (double) radius__
{
    return [self radius];
}

// direct binding of: - (BOOL)containsCoordinate:(CLLocationCoordinate2D)coordinate;
- (BOOL) containsCoordinate___crossmobile_ios_corelocation_CLLocationCoordinate2D:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate 
{
    return [self containsCoordinate:[coordinate getCLLocationCoordinate2D]];
}

@end
