// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_coregraphics_CGBitmapContext definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "crossmobile_ios_coregraphics_CGContext.h"
@class crossmobile_ios_coregraphics_CGColorSpace;
@class java_lang_Object;

CM_EXPORT_CLASS
@interface crossmobile_ios_coregraphics_CGBitmapContext : crossmobile_ios_coregraphics_CGContext
+ (crossmobile_ios_coregraphics_CGContext*) create___byte_ARRAYTYPE_int_int_int_int_crossmobile_ios_coregraphics_CGColorSpace_int:(XMLVMArray*) data :(int) width :(int) height :(int) bitsPerComponent :(int) bytesPerRow :(crossmobile_ios_coregraphics_CGColorSpace*) space :(int) bitmapInfo ;
- (void*) getData__;
- (instancetype) initWithCGBitmapContext:(CGBitmapContextRef) reference;
@end
