// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile_ios_coregraphics_CGColorSpace definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "crossmobile_ios_foundation_CFType.h"
@class java_lang_Object;

CM_EXPORT_CLASS
@interface crossmobile_ios_coregraphics_CGColorSpace : crossmobile_ios_foundation_CFType
+ (crossmobile_ios_coregraphics_CGColorSpace*) createDeviceGray__;
+ (crossmobile_ios_coregraphics_CGColorSpace*) createDeviceRGB__;
- (int) getNumberOfComponents__;
- (instancetype) initWithCGColorSpace:(CGColorSpaceRef) reference;
@end
