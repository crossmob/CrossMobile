// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSHTTPCookieStorage implementation

#import "crossmobile_ios_foundation_NSHTTPCookie.h"
#import "crossmobile_ios_foundation_NSHTTPCookieStorage.h"
#import "crossmobile_ios_foundation_NSURL.h"
#import "java_util_List.h"

@implementation crossmobile_ios_foundation_NSHTTPCookieStorage$Ext

@end

@implementation NSHTTPCookieStorage (cm_crossmobile_ios_foundation_NSHTTPCookieStorage)

// + (NSHTTPCookieStorage *)sharedHTTPCookieStorage;
+ (NSHTTPCookieStorage*) sharedHTTPCookieStorage__
{
    NSHTTPCookieStorage* re$ult = [NSHTTPCookieStorage sharedHTTPCookieStorage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property NSHTTPCookieAcceptPolicy cookieAcceptPolicy;
- (void) setCookieAcceptPolicy___int:(int) cookieAcceptPolicy 
{
    [self setCookieAcceptPolicy:cookieAcceptPolicy];
}

// @property NSHTTPCookieAcceptPolicy cookieAcceptPolicy;
- (int) cookieAcceptPolicy__
{
    return [self cookieAcceptPolicy];
}

// @property(readonly, copy) NSArray<NSHTTPCookie *> *cookies;
- (NSArray*) cookies__
{
    NSArray* re$ult = [self cookies];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSArray<NSHTTPCookie *> *)cookiesForURL:(NSURL *)URL;
- (NSArray*) cookiesForURL___crossmobile_ios_foundation_NSURL:(NSURL*) URL 
{
    NSArray* re$ult = [self cookiesForURL:(URL == JAVA_NULL ? nil : URL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)deleteCookie:(NSHTTPCookie *)cookie;
- (void) deleteCookie___crossmobile_ios_foundation_NSHTTPCookie:(NSHTTPCookie*) cookie 
{
    [self deleteCookie:(cookie == JAVA_NULL ? nil : cookie)];
}

// - (void)setCookie:(NSHTTPCookie *)cookie;
- (void) setCookie___crossmobile_ios_foundation_NSHTTPCookie:(NSHTTPCookie*) cookie 
{
    [self setCookie:(cookie == JAVA_NULL ? nil : cookie)];
}

// - (void)setCookies:(NSArray<NSHTTPCookie *> *)cookies forURL:(NSURL *)URL mainDocumentURL:(NSURL *)mainDocumentURL;
- (void) setCookies___java_util_List_crossmobile_ios_foundation_NSURL_crossmobile_ios_foundation_NSURL:(NSArray*) cookies :(NSURL*) URL :(NSURL*) mainDocumentURL 
{
    [self setCookies:(cookies == JAVA_NULL ? nil : cookies) forURL:(URL == JAVA_NULL ? nil : URL) mainDocumentURL:(mainDocumentURL == JAVA_NULL ? nil : mainDocumentURL)];
}

@end
