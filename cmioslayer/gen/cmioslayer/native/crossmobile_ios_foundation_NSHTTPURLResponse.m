// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSHTTPURLResponse implementation

#import "crossmobile_ios_foundation_NSHTTPURLResponse.h"
#import "crossmobile_ios_foundation_NSURL.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_foundation_NSHTTPURLResponse$Ext

@end

@implementation NSHTTPURLResponse (cm_crossmobile_ios_foundation_NSHTTPURLResponse)

// + (NSString *)localizedStringForStatusCode:(NSInteger)statusCode;
+ (NSString*) localizedStringForStatusCode___int:(int) statusCode 
{
    NSString* re$ult = [NSHTTPURLResponse localizedStringForStatusCode:statusCode];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (instancetype)initWithURL:(NSURL *)url statusCode:(NSInteger)statusCode HTTPVersion:(NSString *)HTTPVersion headerFields:(NSDictionary<NSString *,NSString *> *)headerFields;
- (instancetype) __init_crossmobile_ios_foundation_NSHTTPURLResponse___crossmobile_ios_foundation_NSURL_int_java_lang_String_java_util_Map:(NSURL*) url :(int) statusCode :(NSString*) HTTPVersion :(NSDictionary*) headerFields 
{
    return [self initWithURL:(url == JAVA_NULL ? nil : url) statusCode:statusCode HTTPVersion:(HTTPVersion == JAVA_NULL ? nil : HTTPVersion) headerFields:(headerFields == JAVA_NULL ? nil : headerFields)];
}

// @property(readonly, copy) NSDictionary *allHeaderFields;
- (NSDictionary*) allHeaderFields__
{
    NSDictionary* re$ult = [self allHeaderFields];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly) NSInteger statusCode;
- (int) statusCode__
{
    return [self statusCode];
}

@end
