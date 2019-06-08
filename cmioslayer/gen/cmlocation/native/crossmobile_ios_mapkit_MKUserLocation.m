// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.mapkit.MKUserLocation implementation

#import "crossmobile_ios_corelocation_CLLocation.h"
#import "crossmobile_ios_corelocation_CLLocationCoordinate2D.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_mapkit_MKUserLocation.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_mapkit_MKUserLocation$Ext

// (MKUserLocation) @property(nonatomic, readonly) CLLocationCoordinate2D coordinate;
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate__
{
    return [[crossmobile_ios_corelocation_CLLocationCoordinate2D alloc] initWithCLLocationCoordinate2D:[super coordinate]];
}

// (MKUserLocation) @property(readonly, nonatomic) CLLocation *location;
- (CLLocation*) location__
{
    CLLocation* re$ult = [super location];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (MKUserLocation) @property(nonatomic, copy) NSString *subtitle;
- (void) setSubtitle___java_lang_String:(NSString*) subtitle 
{
    [super setSubtitle:(subtitle == JAVA_NULL ? nil : subtitle)];
}

// (MKUserLocation) @property(nonatomic, readonly, copy) NSString *subtitle;
- (NSString*) subtitle__
{
    NSString* re$ult = [super subtitle];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (MKUserLocation) @property(nonatomic, copy) NSString *title;
- (void) setTitle___java_lang_String:(NSString*) title 
{
    [super setTitle:(title == JAVA_NULL ? nil : title)];
}

// (MKUserLocation) @property(nonatomic, readonly, copy) NSString *title;
- (NSString*) title__
{
    NSString* re$ult = [super title];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (MKUserLocation) @property(readonly, nonatomic, getter=isUpdating) BOOL updating;
- (BOOL) isUpdating__
{
    return [super isUpdating];
}

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
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

@implementation MKUserLocation (cm_crossmobile_ios_mapkit_MKUserLocation)

// direct binding of: @property(nonatomic, readonly) CLLocationCoordinate2D coordinate;
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate__
{
    return [[crossmobile_ios_corelocation_CLLocationCoordinate2D alloc] initWithCLLocationCoordinate2D:[self coordinate]];
}

// direct binding of: @property(readonly, nonatomic) CLLocation *location;
- (CLLocation*) location__
{
    CLLocation* re$ult = [self location];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, copy) NSString *subtitle;
- (void) setSubtitle___java_lang_String:(NSString*) subtitle 
{
    [self setSubtitle:(subtitle == JAVA_NULL ? nil : subtitle)];
}

// direct binding of: @property(nonatomic, readonly, copy) NSString *subtitle;
- (NSString*) subtitle__
{
    NSString* re$ult = [self subtitle];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, copy) NSString *title;
- (void) setTitle___java_lang_String:(NSString*) title 
{
    [self setTitle:(title == JAVA_NULL ? nil : title)];
}

// direct binding of: @property(nonatomic, readonly, copy) NSString *title;
- (NSString*) title__
{
    NSString* re$ult = [self title];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, nonatomic, getter=isUpdating) BOOL updating;
- (BOOL) isUpdating__
{
    return [self isUpdating];
}

@end
