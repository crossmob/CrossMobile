// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSMutableURLRequest implementation

#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSMutableURLRequest.h"
#import "crossmobile_ios_foundation_NSURL.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_foundation_NSMutableURLRequest$Ext

@end

@implementation NSMutableURLRequest (cm_crossmobile_ios_foundation_NSMutableURLRequest)

// + (instancetype)requestWithURL:(NSURL *)theURL;
+ (instancetype) requestWithURL___crossmobile_ios_foundation_NSURL:(NSURL*) theURL 
{
    id re$ult = [NSMutableURLRequest requestWithURL:(theURL == JAVA_NULL ? nil : theURL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (instancetype)requestWithURL:(NSURL *)theURL cachePolicy:(NSURLRequestCachePolicy)cachePolicy timeoutInterval:(NSTimeInterval)timeoutInterval;
+ (instancetype) requestWithURL___crossmobile_ios_foundation_NSURL_int_double:(NSURL*) theURL :(int) cachePolicy :(double) timeoutInterval 
{
    id re$ult = [NSMutableURLRequest requestWithURL:(theURL == JAVA_NULL ? nil : theURL) cachePolicy:cachePolicy timeoutInterval:timeoutInterval];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (instancetype)initWithURL:(NSURL *)URL;
- (instancetype) __init_crossmobile_ios_foundation_NSMutableURLRequest___crossmobile_ios_foundation_NSURL:(NSURL*) URL 
{
    return [self initWithURL:(URL == JAVA_NULL ? nil : URL)];
}

// - (instancetype)initWithURL:(NSURL *)URL cachePolicy:(NSURLRequestCachePolicy)cachePolicy timeoutInterval:(NSTimeInterval)timeoutInterval;
- (instancetype) __init_crossmobile_ios_foundation_NSMutableURLRequest___crossmobile_ios_foundation_NSURL_int_double:(NSURL*) URL :(int) cachePolicy :(double) timeoutInterval 
{
    return [self initWithURL:(URL == JAVA_NULL ? nil : URL) cachePolicy:cachePolicy timeoutInterval:timeoutInterval];
}

// @property(copy) NSData *HTTPBody;
- (void) setHTTPBody___crossmobile_ios_foundation_NSData:(NSData*) HTTPBody 
{
    [self setHTTPBody:(HTTPBody == JAVA_NULL ? nil : HTTPBody)];
}

// @property(copy) NSData *HTTPBody;
- (NSData*) HTTPBody__
{
    NSData* re$ult = [self HTTPBody];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(copy) NSString *HTTPMethod;
- (void) setHTTPMethod___java_lang_String:(NSString*) HTTPMethod 
{
    [self setHTTPMethod:(HTTPMethod == JAVA_NULL ? nil : HTTPMethod)];
}

// @property BOOL HTTPShouldHandleCookies;
- (void) setHTTPShouldHandleCookies___boolean:(BOOL) HTTPShouldHandleCookies 
{
    [self setHTTPShouldHandleCookies:HTTPShouldHandleCookies];
}

// @property(copy) NSURL *URL;
- (void) setURL___crossmobile_ios_foundation_NSURL:(NSURL*) URL 
{
    [self setURL:(URL == JAVA_NULL ? nil : URL)];
}

// @property(copy) NSDictionary <NSString *,NSString *> *allHTTPHeaderFields;
- (NSDictionary*) allHTTPHeaderFields__
{
    NSDictionary* re$ult = [self allHTTPHeaderFields];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property NSTimeInterval timeoutInterval;
- (void) setTimeoutInterval___double:(double) timeoutInterval 
{
    [self setTimeoutInterval:timeoutInterval];
}

// - (void)addValue:(NSString *)value forHTTPHeaderField:(NSString *)field;
- (void) addValue___java_lang_String_java_lang_String:(NSString*) value :(NSString*) field 
{
    [self addValue:(value == JAVA_NULL ? nil : value) forHTTPHeaderField:(field == JAVA_NULL ? nil : field)];
}

@end
