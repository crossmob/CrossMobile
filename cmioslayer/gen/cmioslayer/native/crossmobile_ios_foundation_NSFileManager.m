// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSFileManager implementation

#import "crossmobile_ios_foundation_NSFileManager.h"
#import "crossmobile_rt_StrongReference.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_foundation_NSFileManager$Ext

@end

@implementation NSFileManager (cm_crossmobile_ios_foundation_NSFileManager)

// + (NSFileManager *)defaultManager;
+ (NSFileManager*) defaultManager__
{
    NSFileManager* re$ult = [NSFileManager defaultManager];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSArray<NSString *> *)contentsOfDirectoryAtPath:(NSString *)path error:(NSError * _Nullable *)error;
- (NSArray*) contentsOfDirectoryAtPath___java_lang_String_crossmobile_rt_StrongReference:(NSString*) path :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    NSArray* re$ult = [self contentsOfDirectoryAtPath:(path == JAVA_NULL ? nil : path) error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (BOOL)createDirectoryAtPath:(NSString *)path withIntermediateDirectories:(BOOL)createIntermediates attributes:(NSDictionary<NSString *,id> *)attributes error:(NSError * _Nullable *)error;
- (BOOL) createDirectoryAtPath___java_lang_String_boolean_java_util_Map_crossmobile_rt_StrongReference:(NSString*) path :(BOOL) createIntermediates :(NSDictionary*) attributes :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    BOOL re$ult = [self createDirectoryAtPath:(path == JAVA_NULL ? nil : path) withIntermediateDirectories:createIntermediates attributes:(attributes == JAVA_NULL ? nil : attributes) error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return re$ult;
}

// - (BOOL)fileExistsAtPath:(NSString *)path;
- (BOOL) fileExistsAtPath___java_lang_String:(NSString*) path 
{
    return [self fileExistsAtPath:(path == JAVA_NULL ? nil : path)];
}

@end
