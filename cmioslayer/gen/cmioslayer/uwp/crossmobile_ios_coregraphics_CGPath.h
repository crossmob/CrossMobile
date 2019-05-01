// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.coregraphics.CGPath definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "java_lang_Object.h"
@class crossmobile_ios_coregraphics_CGAffineTransform;

@interface crossmobile_ios_coregraphics_CGPath : java_lang_Object {
@public void* $reference;
}

- (crossmobile_ios_coregraphics_CGPath*) __init_crossmobile_ios_coregraphics_CGPath__;
- (void) addArc___crossmobile_ios_coregraphics_CGAffineTransform_double_double_double_double_double_boolean:(crossmobile_ios_coregraphics_CGAffineTransform*) m :(double) x :(double) y :(double) radius :(double) startAngle :(double) endAngle :(BOOL) clockwise ;
- (void) addCurveToPoint___crossmobile_ios_coregraphics_CGAffineTransform_double_double_double_double_double_double:(crossmobile_ios_coregraphics_CGAffineTransform*) m :(double) cp1x :(double) cp1y :(double) cp2x :(double) cp2y :(double) x :(double) y ;
- (void) addLineToPoint___crossmobile_ios_coregraphics_CGAffineTransform_double_double:(crossmobile_ios_coregraphics_CGAffineTransform*) m :(double) x :(double) y ;
- (void) addQuadCurveToPoint___crossmobile_ios_coregraphics_CGAffineTransform_double_double_double_double:(crossmobile_ios_coregraphics_CGAffineTransform*) m :(double) cpx :(double) cpy :(double) x :(double) y ;
- (void) closeSubpath__;
- (void) moveToPoint___crossmobile_ios_coregraphics_CGAffineTransform_double_double:(crossmobile_ios_coregraphics_CGAffineTransform*) m :(double) x :(double) y ;
- (instancetype) initWithCGPath:(CGPathRef) reference;
@end
