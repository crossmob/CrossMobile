// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_coregraphics_CGDataProvider definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "crossmobile_ios_foundation_CFType.h"
@class java_lang_Object;
@class java_lang_String;

CM_EXPORT_CLASS
@interface crossmobile_ios_coregraphics_CGDataProvider : crossmobile_ios_foundation_CFType
+ (crossmobile_ios_coregraphics_CGDataProvider*) createWithFilename___java_lang_String:(NSString*) filename ;
- (instancetype) initWithCGDataProvider:(CGDataProviderRef) reference;
@end
