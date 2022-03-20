// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_coregraphics_CGRect definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "java_lang_Object.h"
@class crossmobile_ios_coregraphics_CGAffineTransform;
@class crossmobile_ios_coregraphics_CGPoint;
@class crossmobile_ios_coregraphics_CGSize;

@interface crossmobile_ios_coregraphics_CGRect : java_lang_Object {
@public crossmobile_ios_coregraphics_CGPoint* origin_crossmobile_ios_coregraphics_CGPoint;
@public crossmobile_ios_coregraphics_CGSize* size_crossmobile_ios_coregraphics_CGSize;
}

+ (crossmobile_ios_coregraphics_CGRect*) Null__;
+ (crossmobile_ios_coregraphics_CGRect*) infinite__;
+ (crossmobile_ios_coregraphics_CGRect*) zero__;
- (crossmobile_ios_coregraphics_CGRect*) __init_crossmobile_ios_coregraphics_CGRect___double_double_double_double:(double) x :(double) y :(double) width :(double) height ;
- (void) setOrigin___crossmobile_ios_coregraphics_CGPoint:(crossmobile_ios_coregraphics_CGPoint*) origin ;
- (crossmobile_ios_coregraphics_CGPoint*) getOrigin__;
- (void) setSize___crossmobile_ios_coregraphics_CGSize:(crossmobile_ios_coregraphics_CGSize*) size ;
- (crossmobile_ios_coregraphics_CGSize*) getSize__;
- (crossmobile_ios_coregraphics_CGRect*) applyAffineTransform___crossmobile_ios_coregraphics_CGAffineTransform:(crossmobile_ios_coregraphics_CGAffineTransform*) t ;
- (BOOL) containsPoint___crossmobile_ios_coregraphics_CGPoint:(crossmobile_ios_coregraphics_CGPoint*) point ;
- (double) getMaxX__;
- (double) getMaxY__;
- (double) getMinX__;
- (double) getMinY__;
- (crossmobile_ios_coregraphics_CGRect*) intersection___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) r2 ;
- (BOOL) isEmpty__;
- (BOOL) isInfinite__;
- (BOOL) isNull__;
- (instancetype) initWithCGRect:(CGRect) reference;
- (void) setCGRect:(CGRect) other;
- (CGRect) getCGRect;
@end
