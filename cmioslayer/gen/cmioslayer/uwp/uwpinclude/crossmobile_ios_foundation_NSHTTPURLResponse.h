// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSHTTPURLResponse definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSURL;
@class java_lang_String;
@protocol java_util_Map;

CM_EXPORT_CLASS
@interface crossmobile_ios_foundation_NSHTTPURLResponse$Ext : NSHTTPURLResponse
@end

#define crossmobile_ios_foundation_NSHTTPURLResponse NSHTTPURLResponse
@interface NSHTTPURLResponse (cm_crossmobile_ios_foundation_NSHTTPURLResponse)
+ (NSString*) localizedStringForStatusCode___int:(int) statusCode ;
- (instancetype) __init_crossmobile_ios_foundation_NSHTTPURLResponse___crossmobile_ios_foundation_NSURL_int_java_lang_String_java_util_Map:(NSURL*) url :(int) statusCode :(NSString*) HTTPVersion :(NSDictionary*) headerFields ;
- (NSDictionary*) allHeaderFields__;
- (int) statusCode__;
@end
