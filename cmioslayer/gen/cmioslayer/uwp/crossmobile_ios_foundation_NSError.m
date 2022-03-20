// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSError implementation

#import "crossmobile_ios_foundation_NSError.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_foundation_NSError$Ext

@end

@implementation NSError (cm_crossmobile_ios_foundation_NSError)

// + (instancetype)errorWithDomain:(NSString *)domain code:(NSInteger)code userInfo:(NSDictionary *)dict;
+ (instancetype) errorWithDomain___java_lang_String_int_java_util_Map:(NSString*) domain :(int) code :(NSDictionary*) dict 
{
    id re$ult = [NSError errorWithDomain:(domain == JAVA_NULL ? nil : domain) code:code userInfo:(dict == JAVA_NULL ? nil : dict)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (instancetype)initWithDomain:(NSString *)domain code:(NSInteger)code userInfo:(NSDictionary *)dict;
- (instancetype) __init_crossmobile_ios_foundation_NSError___java_lang_String_int_java_util_Map:(NSString*) domain :(int) code :(NSDictionary*) dict 
{
    return [self initWithDomain:(domain == JAVA_NULL ? nil : domain) code:code userInfo:(dict == JAVA_NULL ? nil : dict)];
}

// @property(readonly) NSInteger code;
- (int) code__
{
    return [self code];
}

// @property (readonly, copy) NSString *domain;
- (NSString*) domain__
{
    NSString* re$ult = [self domain];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy) NSString *localizedDescription;
- (NSString*) localizedDescription__
{
    NSString* re$ult = [self localizedDescription];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy) NSDictionary *userInfo;
- (NSDictionary*) userInfo__
{
    NSDictionary* re$ult = [self userInfo];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
