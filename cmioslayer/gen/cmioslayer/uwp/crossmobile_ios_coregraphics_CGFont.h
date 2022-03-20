// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_coregraphics_CGFont definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "crossmobile_ios_foundation_CFType.h"
@class crossmobile_ios_coregraphics_CGDataProvider;
@class java_lang_Object;
@class java_lang_String;

@interface crossmobile_ios_coregraphics_CGFont : crossmobile_ios_foundation_CFType
+ (crossmobile_ios_coregraphics_CGFont*) createWithDataProvider___crossmobile_ios_coregraphics_CGDataProvider:(crossmobile_ios_coregraphics_CGDataProvider*) provider ;
+ (crossmobile_ios_coregraphics_CGFont*) createWithFontName___java_lang_String:(NSString*) name ;
- (int) getAscent__;
- (int) getCapHeight__;
- (int) getDescent__;
- (int) getLeading__;
- (int) getXHeight__;
- (instancetype) initWithCGFont:(CGFontRef) reference;
@end
