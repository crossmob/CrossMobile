// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_coregraphics_CGSize definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "java_lang_Object.h"
@class crossmobile_ios_coregraphics_CGAffineTransform;

CM_EXPORT_CLASS
@interface crossmobile_ios_coregraphics_CGSize : java_lang_Object {
@public double width_double;
@public double height_double;
}

- (crossmobile_ios_coregraphics_CGSize*) __init_crossmobile_ios_coregraphics_CGSize___double_double:(double) width :(double) height ;
- (void) setHeight___double:(double) height ;
- (double) getHeight__;
- (void) setWidth___double:(double) width ;
- (double) getWidth__;
- (crossmobile_ios_coregraphics_CGSize*) applyAffineTransform___crossmobile_ios_coregraphics_CGAffineTransform:(crossmobile_ios_coregraphics_CGAffineTransform*) t ;
- (instancetype) initWithCGSize:(CGSize) reference;
- (void) setCGSize:(CGSize) other;
- (CGSize) getCGSize;
@end
