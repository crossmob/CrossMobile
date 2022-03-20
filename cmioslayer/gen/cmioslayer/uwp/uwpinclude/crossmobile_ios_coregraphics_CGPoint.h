// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_coregraphics_CGPoint definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "java_lang_Object.h"
@class crossmobile_ios_coregraphics_CGAffineTransform;

CM_EXPORT_CLASS
@interface crossmobile_ios_coregraphics_CGPoint : java_lang_Object {
@public double x_double;
@public double y_double;
}

+ (crossmobile_ios_coregraphics_CGPoint*) zero__;
- (crossmobile_ios_coregraphics_CGPoint*) __init_crossmobile_ios_coregraphics_CGPoint___double_double:(double) x :(double) y ;
- (void) setX___double:(double) x ;
- (double) getX__;
- (void) setY___double:(double) y ;
- (double) getY__;
- (crossmobile_ios_coregraphics_CGPoint*) applyAffineTransform___crossmobile_ios_coregraphics_CGAffineTransform:(crossmobile_ios_coregraphics_CGAffineTransform*) t ;
- (instancetype) initWithCGPoint:(CGPoint) reference;
- (void) setCGPoint:(CGPoint) other;
- (CGPoint) getCGPoint;
@end
