// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.corelocation.CLHeading implementation

#import "crossmobile_ios_corelocation_CLHeading.h"
#import "crossmobile_ios_foundation_NSDate.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_corelocation_CLHeading$Ext

// (CLHeading) @property(nonatomic, readonly, copy) NSString *description;
- (NSString*) description__
{
    NSString* re$ult = [super description];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CLHeading) @property(readonly, nonatomic) CLLocationDirection headingAccuracy;
- (double) headingAccuracy__
{
    return [super headingAccuracy];
}

// (CLHeading) @property(readonly, nonatomic) CLLocationDirection magneticHeading;
- (double) magneticHeading__
{
    return [super magneticHeading];
}

// (CLHeading) @property(readonly, nonatomic, copy) NSDate *timestamp;
- (NSDate*) timestamp__
{
    NSDate* re$ult = [super timestamp];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CLHeading) @property(readonly, nonatomic) CLLocationDirection trueHeading;
- (double) trueHeading__
{
    return [super trueHeading];
}

// (CLHeading) @property(readonly, nonatomic) CLHeadingComponentValue x;
- (double) x__
{
    return [super x];
}

// (CLHeading) @property(readonly, nonatomic) CLHeadingComponentValue y;
- (double) y__
{
    return [super y];
}

// (CLHeading) @property(readonly, nonatomic) CLHeadingComponentValue z;
- (double) z__
{
    return [super z];
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

@implementation CLHeading (cm_crossmobile_ios_corelocation_CLHeading)

// direct binding of: @property(nonatomic, readonly, copy) NSString *description;
- (NSString*) description__
{
    NSString* re$ult = [self description];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, nonatomic) CLLocationDirection headingAccuracy;
- (double) headingAccuracy__
{
    return [self headingAccuracy];
}

// direct binding of: @property(readonly, nonatomic) CLLocationDirection magneticHeading;
- (double) magneticHeading__
{
    return [self magneticHeading];
}

// direct binding of: @property(readonly, nonatomic, copy) NSDate *timestamp;
- (NSDate*) timestamp__
{
    NSDate* re$ult = [self timestamp];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, nonatomic) CLLocationDirection trueHeading;
- (double) trueHeading__
{
    return [self trueHeading];
}

// direct binding of: @property(readonly, nonatomic) CLHeadingComponentValue x;
- (double) x__
{
    return [self x];
}

// direct binding of: @property(readonly, nonatomic) CLHeadingComponentValue y;
- (double) y__
{
    return [self y];
}

// direct binding of: @property(readonly, nonatomic) CLHeadingComponentValue z;
- (double) z__
{
    return [self z];
}

@end
