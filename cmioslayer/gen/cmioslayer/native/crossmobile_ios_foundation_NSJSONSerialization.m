// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSJSONSerialization implementation

#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSJSONSerialization.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_rt_StrongReference.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_foundation_NSJSONSerialization$Ext

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

@implementation NSJSONSerialization (cm_crossmobile_ios_foundation_NSJSONSerialization)

// direct binding of: + (id)JSONObjectWithData:(NSData *)data options:(NSJSONReadingOptions)opt error:(NSError * _Nullable *)error;
+ (id) JSONObjectWithData___crossmobile_ios_foundation_NSData_int_crossmobile_rt_StrongReference:(NSData*) data :(int) opt :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    id re$ult = [NSJSONSerialization JSONObjectWithData:(data == JAVA_NULL ? nil : data) options:opt error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (NSData *)dataWithJSONObject:(id)obj options:(NSJSONWritingOptions)opt error:(NSError * _Nullable *)error;
+ (NSData*) dataWithJSONObject___java_lang_Object_int_crossmobile_rt_StrongReference:(id) obj :(int) opt :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    NSData* re$ult = [NSJSONSerialization dataWithJSONObject:(obj == JAVA_NULL ? nil : obj) options:opt error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (BOOL)isValidJSONObject:(id)obj;
+ (BOOL) isValidJSONObject___java_lang_Object:(id) obj 
{
    return [NSJSONSerialization isValidJSONObject:(obj == JAVA_NULL ? nil : obj)];
}

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_foundation_NSJSONSerialization__
{
    return [self init];
}

@end
