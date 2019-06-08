// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSBundle implementation

#import "crossmobile_ios_foundation_NSBundle.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_foundation_NSBundle$Ext

// (NSBundle) @property(readonly, copy) NSString *bundlePath;
- (NSString*) bundlePath__
{
    NSString* re$ult = [super bundlePath];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
}

// (NSBundle) - (NSString *)localizedStringForKey:(NSString *)key value:(NSString *)value table:(NSString *)tableName;
- (NSString*) localizedStringForKey___java_lang_String_java_lang_String_java_lang_String:(NSString*) key :(NSString*) value :(NSString*) tableName 
{
    NSString* re$ult = [super localizedStringForKey:(key == JAVA_NULL ? nil : key) value:(value == JAVA_NULL ? nil : value) table:(tableName == JAVA_NULL ? nil : tableName)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (void)observeValueForKeyPath:(NSString *)keyPath ofObject:(id)object change:(NSDictionary<NSKeyValueChangeKey, id> *)change context:(void *)context;
- (void) observeValueForKeyPath___java_lang_String_java_lang_Object_java_util_Map_java_lang_Object:(NSString*) keyPath :(id) object :(NSDictionary*) change :(id) context 
{
    [super observeValueForKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) ofObject:(object == JAVA_NULL ? nil : object) change:(change == JAVA_NULL ? nil : change) context:(context == JAVA_NULL ? nil : context)];
}

// (NSBundle) - (NSString *)pathForResource:(NSString *)name ofType:(NSString *)ext;
- (NSString*) pathForResource___java_lang_String_java_lang_String:(NSString*) name :(NSString*) ext 
{
    NSString* re$ult = [super pathForResource:(name == JAVA_NULL ? nil : name) ofType:(ext == JAVA_NULL ? nil : ext)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSBundle) - (NSString *)pathForResource:(NSString *)name ofType:(NSString *)ext inDirectory:(NSString *)subpath;
- (NSString*) pathForResource___java_lang_String_java_lang_String_java_lang_String:(NSString*) name :(NSString*) ext :(NSString*) subpath 
{
    NSString* re$ult = [super pathForResource:(name == JAVA_NULL ? nil : name) ofType:(ext == JAVA_NULL ? nil : ext) inDirectory:(subpath == JAVA_NULL ? nil : subpath)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
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

@implementation NSBundle (cm_crossmobile_ios_foundation_NSBundle)

// direct binding of: + (instancetype)bundleWithPath:(NSString *)path;
+ (instancetype) bundleWithPath___java_lang_String:(NSString*) path 
{
    id re$ult = [NSBundle bundleWithPath:(path == JAVA_NULL ? nil : path)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (NSBundle *)mainBundle;
+ (NSBundle*) mainBundle__
{
    NSBundle* re$ult = [NSBundle mainBundle];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy) NSString *bundlePath;
- (NSString*) bundlePath__
{
    NSString* re$ult = [self bundlePath];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (NSString *)localizedStringForKey:(NSString *)key value:(NSString *)value table:(NSString *)tableName;
- (NSString*) localizedStringForKey___java_lang_String_java_lang_String_java_lang_String:(NSString*) key :(NSString*) value :(NSString*) tableName 
{
    NSString* re$ult = [self localizedStringForKey:(key == JAVA_NULL ? nil : key) value:(value == JAVA_NULL ? nil : value) table:(tableName == JAVA_NULL ? nil : tableName)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (NSString *)pathForResource:(NSString *)name ofType:(NSString *)ext;
- (NSString*) pathForResource___java_lang_String_java_lang_String:(NSString*) name :(NSString*) ext 
{
    NSString* re$ult = [self pathForResource:(name == JAVA_NULL ? nil : name) ofType:(ext == JAVA_NULL ? nil : ext)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (NSString *)pathForResource:(NSString *)name ofType:(NSString *)ext inDirectory:(NSString *)subpath;
- (NSString*) pathForResource___java_lang_String_java_lang_String_java_lang_String:(NSString*) name :(NSString*) ext :(NSString*) subpath 
{
    NSString* re$ult = [self pathForResource:(name == JAVA_NULL ? nil : name) ofType:(ext == JAVA_NULL ? nil : ext) inDirectory:(subpath == JAVA_NULL ? nil : subpath)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
