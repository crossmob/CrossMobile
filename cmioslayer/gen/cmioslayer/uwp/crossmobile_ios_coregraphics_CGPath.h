// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_coregraphics_CGPath definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "java_lang_Object.h"
@class crossmobile_ios_coregraphics_CGAffineTransform;
@class crossmobile_ios_coregraphics_CGPoint;
@class crossmobile_ios_coregraphics_CGRect;

@interface crossmobile_ios_coregraphics_CGPath : java_lang_Object {
@public void* $reference;
}

- (crossmobile_ios_coregraphics_CGPath*) __init_crossmobile_ios_coregraphics_CGPath__;
- (void) addArc___crossmobile_ios_coregraphics_CGAffineTransform_double_double_double_double_double_boolean:(crossmobile_ios_coregraphics_CGAffineTransform*) m :(double) x :(double) y :(double) radius :(double) startAngle :(double) endAngle :(BOOL) clockwise ;
- (void) addArcToPoint___crossmobile_ios_coregraphics_CGAffineTransform_double_double_double_double_double:(crossmobile_ios_coregraphics_CGAffineTransform*) m :(double) x1 :(double) y1 :(double) x2 :(double) y2 :(double) radius ;
- (void) addCurveToPoint___crossmobile_ios_coregraphics_CGAffineTransform_double_double_double_double_double_double:(crossmobile_ios_coregraphics_CGAffineTransform*) m :(double) cp1x :(double) cp1y :(double) cp2x :(double) cp2y :(double) x :(double) y ;
- (void) addEllipseInRect___crossmobile_ios_coregraphics_CGAffineTransform_crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGAffineTransform*) m :(crossmobile_ios_coregraphics_CGRect*) rect ;
- (void) addLineToPoint___crossmobile_ios_coregraphics_CGAffineTransform_double_double:(crossmobile_ios_coregraphics_CGAffineTransform*) m :(double) x :(double) y ;
- (void) addLines___crossmobile_ios_coregraphics_CGAffineTransform_crossmobile_ios_coregraphics_CGPoint_ARRAYTYPE:(crossmobile_ios_coregraphics_CGAffineTransform*) m :(XMLVMArray*) points ;
- (void) addPath___crossmobile_ios_coregraphics_CGAffineTransform_crossmobile_ios_coregraphics_CGPath:(crossmobile_ios_coregraphics_CGAffineTransform*) m :(crossmobile_ios_coregraphics_CGPath*) path2 ;
- (void) addQuadCurveToPoint___crossmobile_ios_coregraphics_CGAffineTransform_double_double_double_double:(crossmobile_ios_coregraphics_CGAffineTransform*) m :(double) cpx :(double) cpy :(double) x :(double) y ;
- (void) addRect___crossmobile_ios_coregraphics_CGAffineTransform_crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGAffineTransform*) m :(crossmobile_ios_coregraphics_CGRect*) rect ;
- (void) addRects___crossmobile_ios_coregraphics_CGAffineTransform_crossmobile_ios_coregraphics_CGRect_ARRAYTYPE:(crossmobile_ios_coregraphics_CGAffineTransform*) m :(XMLVMArray*) rects ;
- (void) addRoundedRect___crossmobile_ios_coregraphics_CGAffineTransform_crossmobile_ios_coregraphics_CGRect_double_double:(crossmobile_ios_coregraphics_CGAffineTransform*) transform :(crossmobile_ios_coregraphics_CGRect*) rect :(double) cornerWidth :(double) cornerHeight ;
- (void) closeSubpath__;
- (crossmobile_ios_coregraphics_CGPoint*) getCurrentPoint__;
- (void) moveToPoint___crossmobile_ios_coregraphics_CGAffineTransform_double_double:(crossmobile_ios_coregraphics_CGAffineTransform*) m :(double) x :(double) y ;
- (instancetype) initWithCGPath:(CGPathRef) reference;
@end
