// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_coregraphics_CGColorSpace definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "crossmobile_ios_foundation_CFType.h"
@class java_lang_Object;

@interface crossmobile_ios_coregraphics_CGColorSpace : crossmobile_ios_foundation_CFType
+ (crossmobile_ios_coregraphics_CGColorSpace*) createDeviceGray__;
+ (crossmobile_ios_coregraphics_CGColorSpace*) createDeviceRGB__;
- (int) getNumberOfComponents__;
- (instancetype) initWithCGColorSpace:(CGColorSpaceRef) reference;
@end
