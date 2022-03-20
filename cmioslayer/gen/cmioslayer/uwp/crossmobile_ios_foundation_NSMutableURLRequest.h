// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSMutableURLRequest definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSData;
@class crossmobile_ios_foundation_NSURL;
@class java_lang_String;
@protocol java_util_Map;

@interface crossmobile_ios_foundation_NSMutableURLRequest$Ext : NSMutableURLRequest
@end

#define crossmobile_ios_foundation_NSMutableURLRequest NSMutableURLRequest
@interface NSMutableURLRequest (cm_crossmobile_ios_foundation_NSMutableURLRequest)
+ (instancetype) requestWithURL___crossmobile_ios_foundation_NSURL:(NSURL*) theURL ;
+ (instancetype) requestWithURL___crossmobile_ios_foundation_NSURL_int_double:(NSURL*) theURL :(int) cachePolicy :(double) timeoutInterval ;
- (instancetype) __init_crossmobile_ios_foundation_NSMutableURLRequest___crossmobile_ios_foundation_NSURL:(NSURL*) URL ;
- (instancetype) __init_crossmobile_ios_foundation_NSMutableURLRequest___crossmobile_ios_foundation_NSURL_int_double:(NSURL*) URL :(int) cachePolicy :(double) timeoutInterval ;
- (void) setHTTPBody___crossmobile_ios_foundation_NSData:(NSData*) HTTPBody ;
- (NSData*) HTTPBody__;
- (void) setHTTPMethod___java_lang_String:(NSString*) HTTPMethod ;
- (void) setHTTPShouldHandleCookies___boolean:(BOOL) HTTPShouldHandleCookies ;
- (void) setURL___crossmobile_ios_foundation_NSURL:(NSURL*) URL ;
- (NSDictionary*) allHTTPHeaderFields__;
- (void) setTimeoutInterval___double:(double) timeoutInterval ;
- (void) addValue___java_lang_String_java_lang_String:(NSString*) value :(NSString*) field ;
@end
