// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSURLCache definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSURLRequest;
@class java_lang_String;

@interface crossmobile_ios_foundation_NSURLCache$Ext : NSURLCache
@end

#define crossmobile_ios_foundation_NSURLCache NSURLCache
@interface NSURLCache (cm_crossmobile_ios_foundation_NSURLCache)
- (instancetype) __init_crossmobile_ios_foundation_NSURLCache___int_int_java_lang_String:(int) memoryCapacity :(int) diskCapacity :(NSString*) path ;
- (int) currentDiskUsage__;
- (int) currentMemoryUsage__;
- (void) setDiskCapacity___int:(int) diskCapacity ;
- (int) diskCapacity__;
- (void) setMemoryCapacity___int:(int) memoryCapacity ;
- (int) memoryCapacity__;
- (void) removeAllCachedResponses__;
- (void) removeCachedResponseForRequest___crossmobile_ios_foundation_NSURLRequest:(NSURLRequest*) request ;
@end
