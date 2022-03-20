// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSURLRequest implementation

#import "crossmobile_ios_foundation_NSURL.h"
#import "crossmobile_ios_foundation_NSURLRequest.h"

@implementation crossmobile_ios_foundation_NSURLRequest$Ext

@end

@implementation NSURLRequest (cm_crossmobile_ios_foundation_NSURLRequest)

// + (instancetype)requestWithURL:(NSURL *)URL;
+ (instancetype) requestWithURL___crossmobile_ios_foundation_NSURL:(NSURL*) URL 
{
    id re$ult = [NSURLRequest requestWithURL:(URL == JAVA_NULL ? nil : URL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (instancetype)requestWithURL:(NSURL *)URL cachePolicy:(NSURLRequestCachePolicy)cachePolicy timeoutInterval:(NSTimeInterval)timeoutInterval;
+ (instancetype) requestWithURL___crossmobile_ios_foundation_NSURL_int_double:(NSURL*) URL :(int) cachePolicy :(double) timeoutInterval 
{
    id re$ult = [NSURLRequest requestWithURL:(URL == JAVA_NULL ? nil : URL) cachePolicy:cachePolicy timeoutInterval:timeoutInterval];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (instancetype)initWithURL:(NSURL *)URL;
- (instancetype) __init_crossmobile_ios_foundation_NSURLRequest___crossmobile_ios_foundation_NSURL:(NSURL*) URL 
{
    return [self initWithURL:(URL == JAVA_NULL ? nil : URL)];
}

// - (instancetype)initWithURL:(NSURL *)URL cachePolicy:(NSURLRequestCachePolicy)cachePolicy timeoutInterval:(NSTimeInterval)timeoutInterval;
- (instancetype) __init_crossmobile_ios_foundation_NSURLRequest___crossmobile_ios_foundation_NSURL_int_double:(NSURL*) URL :(int) cachePolicy :(double) timeoutInterval 
{
    return [self initWithURL:(URL == JAVA_NULL ? nil : URL) cachePolicy:cachePolicy timeoutInterval:timeoutInterval];
}

// @property(readonly) BOOL HTTPShouldHandleCookies;
- (BOOL) HTTPShouldHandleCookies__
{
    return [self HTTPShouldHandleCookies];
}

// @property(readonly, copy) NSURL *URL;
- (NSURL*) URL__
{
    NSURL* re$ult = [self URL];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly) NSURLRequestCachePolicy cachePolicy;
- (int) cachePolicy__
{
    return [self cachePolicy];
}

// @property(readonly) NSTimeInterval timeoutInterval;
- (double) timeoutInterval__
{
    return [self timeoutInterval];
}

@end
