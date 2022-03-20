// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSURLRequest definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSURL;

@interface crossmobile_ios_foundation_NSURLRequest$Ext : NSURLRequest
@end

#define crossmobile_ios_foundation_NSURLRequest NSURLRequest
@interface NSURLRequest (cm_crossmobile_ios_foundation_NSURLRequest)
+ (instancetype) requestWithURL___crossmobile_ios_foundation_NSURL:(NSURL*) URL ;
+ (instancetype) requestWithURL___crossmobile_ios_foundation_NSURL_int_double:(NSURL*) URL :(int) cachePolicy :(double) timeoutInterval ;
- (instancetype) __init_crossmobile_ios_foundation_NSURLRequest___crossmobile_ios_foundation_NSURL:(NSURL*) URL ;
- (instancetype) __init_crossmobile_ios_foundation_NSURLRequest___crossmobile_ios_foundation_NSURL_int_double:(NSURL*) URL :(int) cachePolicy :(double) timeoutInterval ;
- (BOOL) HTTPShouldHandleCookies__;
- (NSURL*) URL__;
- (int) cachePolicy__;
- (double) timeoutInterval__;
@end
