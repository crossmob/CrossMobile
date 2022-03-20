// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSBundle implementation

#import "crossmobile_ios_foundation_NSBundle.h"
#import "crossmobile_ios_foundation_NSURL.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_foundation_NSBundle$Ext

@end

@implementation NSBundle (cm_crossmobile_ios_foundation_NSBundle)

// + (instancetype)bundleWithPath:(NSString *)path;
+ (instancetype) bundleWithPath___java_lang_String:(NSString*) path 
{
    id re$ult = [NSBundle bundleWithPath:(path == JAVA_NULL ? nil : path)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (NSBundle *)mainBundle;
+ (NSBundle*) mainBundle__
{
    NSBundle* re$ult = [NSBundle mainBundle];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy) NSString *bundlePath;
- (NSString*) bundlePath__
{
    NSString* re$ult = [self bundlePath];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSURL *)URLForResource:(NSString *)name withExtension:(NSString *)ext;
- (NSURL*) URLForResource___java_lang_String_java_lang_String:(NSString*) name :(NSString*) ext 
{
    NSURL* re$ult = [self URLForResource:(name == JAVA_NULL ? nil : name) withExtension:(ext == JAVA_NULL ? nil : ext)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSURL *)URLForResource:(NSString *)name withExtension:(NSString *)ext subdirectory:(NSString *)subpath;
- (NSURL*) URLForResource___java_lang_String_java_lang_String_java_lang_String:(NSString*) name :(NSString*) ext :(NSString*) subpath 
{
    NSURL* re$ult = [self URLForResource:(name == JAVA_NULL ? nil : name) withExtension:(ext == JAVA_NULL ? nil : ext) subdirectory:(subpath == JAVA_NULL ? nil : subpath)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSString *)localizedStringForKey:(NSString *)key value:(NSString *)value table:(NSString *)tableName;
- (NSString*) localizedStringForKey___java_lang_String_java_lang_String_java_lang_String:(NSString*) key :(NSString*) value :(NSString*) tableName 
{
    NSString* re$ult = [self localizedStringForKey:(key == JAVA_NULL ? nil : key) value:(value == JAVA_NULL ? nil : value) table:(tableName == JAVA_NULL ? nil : tableName)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSString *)pathForResource:(NSString *)name ofType:(NSString *)ext;
- (NSString*) pathForResource___java_lang_String_java_lang_String:(NSString*) name :(NSString*) ext 
{
    NSString* re$ult = [self pathForResource:(name == JAVA_NULL ? nil : name) ofType:(ext == JAVA_NULL ? nil : ext)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSString *)pathForResource:(NSString *)name ofType:(NSString *)ext inDirectory:(NSString *)subpath;
- (NSString*) pathForResource___java_lang_String_java_lang_String_java_lang_String:(NSString*) name :(NSString*) ext :(NSString*) subpath 
{
    NSString* re$ult = [self pathForResource:(name == JAVA_NULL ? nil : name) ofType:(ext == JAVA_NULL ? nil : ext) inDirectory:(subpath == JAVA_NULL ? nil : subpath)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
