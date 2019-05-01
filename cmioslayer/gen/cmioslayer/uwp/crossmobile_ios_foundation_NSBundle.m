// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSBundle implementation

#import "crossmobile_ios_foundation_NSBundle.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_foundation_NSBundle$Ext

// (NSBundle) @property(readonly, copy) NSString *bundlePath;
- (NSString*) bundlePath__
{
    NSString* re$ult = [super bundlePath];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSBundle) - (NSString *)localizedStringForKey:(NSString *)key value:(NSString *)value table:(NSString *)tableName;
- (NSString*) localizedStringForKey___java_lang_String_java_lang_String_java_lang_String:(NSString*) key :(NSString*) value :(NSString*) tableName 
{
    NSString* re$ult = [super localizedStringForKey:(key == JAVA_NULL ? nil : key) value:(value == JAVA_NULL ? nil : value) table:(tableName == JAVA_NULL ? nil : tableName)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
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

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValue___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
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
