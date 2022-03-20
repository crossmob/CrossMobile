// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_coregraphics_CGGradient definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "crossmobile_ios_foundation_CFType.h"
@class crossmobile_ios_coregraphics_CGColorSpace;
@class java_lang_Object;
@protocol java_util_List;

@interface crossmobile_ios_coregraphics_CGGradient : crossmobile_ios_foundation_CFType
- (crossmobile_ios_coregraphics_CGGradient*) __init_crossmobile_ios_coregraphics_CGGradient___crossmobile_ios_coregraphics_CGColorSpace_double_ARRAYTYPE_double_ARRAYTYPE:(crossmobile_ios_coregraphics_CGColorSpace*) space :(XMLVMArray*) components :(XMLVMArray*) locations ;
- (crossmobile_ios_coregraphics_CGGradient*) __init_crossmobile_ios_coregraphics_CGGradient___crossmobile_ios_coregraphics_CGColorSpace_java_util_List_double_ARRAYTYPE:(crossmobile_ios_coregraphics_CGColorSpace*) space :(NSArray*) colors :(XMLVMArray*) locations ;
- (instancetype) initWithCGGradient:(CGGradientRef) reference;
@end
