// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIGraphics definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "java_lang_Object.h"
@class crossmobile_ios_coregraphics_CGContext;
@class crossmobile_ios_coregraphics_CGSize;
@class crossmobile_ios_uikit_UIImage;

@interface crossmobile_ios_uikit_UIGraphics : java_lang_Object
+ (void) beginImageContext___crossmobile_ios_coregraphics_CGSize:(crossmobile_ios_coregraphics_CGSize*) size ;
+ (void) beginImageContextWithOptions___crossmobile_ios_coregraphics_CGSize_boolean_double:(crossmobile_ios_coregraphics_CGSize*) size :(BOOL) opaque :(double) scale ;
+ (void) endImageContext__;
+ (crossmobile_ios_coregraphics_CGContext*) getCurrentContext__;
+ (UIImage*) getImageFromCurrentImageContext__;
+ (void) popContext__;
+ (void) pushContext___crossmobile_ios_coregraphics_CGContext:(crossmobile_ios_coregraphics_CGContext*) context ;
@end
