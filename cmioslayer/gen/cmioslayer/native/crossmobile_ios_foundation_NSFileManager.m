// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSFileManager implementation

#import "crossmobile_ios_foundation_NSFileManager.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_rt_StrongReference.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_foundation_NSFileManager$Ext

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
}

// (NSFileManager) - (NSArray<NSString *> *)contentsOfDirectoryAtPath:(NSString *)path error:(NSError * _Nullable *)error;
- (NSArray*) contentsOfDirectoryAtPath___java_lang_String_crossmobile_rt_StrongReference:(NSString*) path :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    NSArray* re$ult = [super contentsOfDirectoryAtPath:(path == JAVA_NULL ? nil : path) error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSFileManager) - (BOOL)createDirectoryAtPath:(NSString *)path withIntermediateDirectories:(BOOL)createIntermediates attributes:(NSDictionary<NSString *,id> *)attributes error:(NSError * _Nullable *)error;
- (BOOL) createDirectoryAtPath___java_lang_String_boolean_java_util_Map_crossmobile_rt_StrongReference:(NSString*) path :(BOOL) createIntermediates :(NSDictionary*) attributes :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    BOOL re$ult = [super createDirectoryAtPath:(path == JAVA_NULL ? nil : path) withIntermediateDirectories:createIntermediates attributes:(attributes == JAVA_NULL ? nil : attributes) error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return re$ult;
}

// (NSFileManager) - (BOOL)fileExistsAtPath:(NSString *)path;
- (BOOL) fileExistsAtPath___java_lang_String:(NSString*) path 
{
    return [super fileExistsAtPath:(path == JAVA_NULL ? nil : path)];
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

@implementation NSFileManager (cm_crossmobile_ios_foundation_NSFileManager)

// direct binding of: + (NSFileManager *)defaultManager;
+ (NSFileManager*) defaultManager__
{
    NSFileManager* re$ult = [NSFileManager defaultManager];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (NSArray<NSString *> *)contentsOfDirectoryAtPath:(NSString *)path error:(NSError * _Nullable *)error;
- (NSArray*) contentsOfDirectoryAtPath___java_lang_String_crossmobile_rt_StrongReference:(NSString*) path :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    NSArray* re$ult = [self contentsOfDirectoryAtPath:(path == JAVA_NULL ? nil : path) error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (BOOL)createDirectoryAtPath:(NSString *)path withIntermediateDirectories:(BOOL)createIntermediates attributes:(NSDictionary<NSString *,id> *)attributes error:(NSError * _Nullable *)error;
- (BOOL) createDirectoryAtPath___java_lang_String_boolean_java_util_Map_crossmobile_rt_StrongReference:(NSString*) path :(BOOL) createIntermediates :(NSDictionary*) attributes :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    BOOL re$ult = [self createDirectoryAtPath:(path == JAVA_NULL ? nil : path) withIntermediateDirectories:createIntermediates attributes:(attributes == JAVA_NULL ? nil : attributes) error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return re$ult;
}

// direct binding of: - (BOOL)fileExistsAtPath:(NSString *)path;
- (BOOL) fileExistsAtPath___java_lang_String:(NSString*) path 
{
    return [self fileExistsAtPath:(path == JAVA_NULL ? nil : path)];
}

@end
