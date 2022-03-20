// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_coregraphics_CGImage definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "crossmobile_ios_foundation_CFType.h"
@class crossmobile_ios_coregraphics_CGDataProvider;
@class crossmobile_ios_coregraphics_CGRect;
@class java_lang_Object;

@interface crossmobile_ios_coregraphics_CGImage : crossmobile_ios_foundation_CFType
+ (crossmobile_ios_coregraphics_CGImage*) createWithImageInRect___crossmobile_ios_coregraphics_CGImage_crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGImage*) image :(crossmobile_ios_coregraphics_CGRect*) rect ;
+ (crossmobile_ios_coregraphics_CGImage*) createWithPNGDataProvider___crossmobile_ios_coregraphics_CGDataProvider_double_ARRAYTYPE_boolean_int:(crossmobile_ios_coregraphics_CGDataProvider*) source :(XMLVMArray*) decode :(BOOL) shouldInterpolate :(int) intent ;
- (int) getHeight__;
- (int) getWidth__;
- (instancetype) initWithCGImage:(CGImageRef) reference;
@end
