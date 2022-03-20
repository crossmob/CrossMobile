// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSURLResponse definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSURL;
@class java_lang_String;

@interface crossmobile_ios_foundation_NSURLResponse$Ext : NSURLResponse
@end

#define crossmobile_ios_foundation_NSURLResponse NSURLResponse
@interface NSURLResponse (cm_crossmobile_ios_foundation_NSURLResponse)
- (instancetype) __init_crossmobile_ios_foundation_NSURLResponse___crossmobile_ios_foundation_NSURL_java_lang_String_int_java_lang_String:(NSURL*) URL :(NSString*) MIMEType :(int) length :(NSString*) name ;
- (NSString*) MIMEType__;
- (NSURL*) URL__;
- (JAVA_LONG) expectedContentLength__;
- (NSString*) textEncodingName__;
@end
