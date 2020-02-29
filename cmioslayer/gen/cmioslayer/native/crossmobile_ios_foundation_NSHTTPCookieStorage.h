// (c) 2020 under LGPL by CrossMobile plugin tools

// crossmobile_ios_foundation_NSHTTPCookieStorage definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSHTTPCookie;
@class crossmobile_ios_foundation_NSURL;
@protocol java_util_List;

@interface crossmobile_ios_foundation_NSHTTPCookieStorage$Ext : NSHTTPCookieStorage
@end

#define crossmobile_ios_foundation_NSHTTPCookieStorage NSHTTPCookieStorage
@interface NSHTTPCookieStorage (cm_crossmobile_ios_foundation_NSHTTPCookieStorage)
+ (NSHTTPCookieStorage*) sharedHTTPCookieStorage__;
- (void) setCookieAcceptPolicy___int:(int) cookieAcceptPolicy ;
- (int) cookieAcceptPolicy__;
- (NSArray*) cookies__;
- (NSArray*) cookiesForURL___crossmobile_ios_foundation_NSURL:(NSURL*) URL ;
- (void) deleteCookie___crossmobile_ios_foundation_NSHTTPCookie:(NSHTTPCookie*) cookie ;
- (void) setCookie___crossmobile_ios_foundation_NSHTTPCookie:(NSHTTPCookie*) cookie ;
- (void) setCookies___java_util_List_crossmobile_ios_foundation_NSURL_crossmobile_ios_foundation_NSURL:(NSArray*) cookies :(NSURL*) URL :(NSURL*) mainDocumentURL ;
@end
