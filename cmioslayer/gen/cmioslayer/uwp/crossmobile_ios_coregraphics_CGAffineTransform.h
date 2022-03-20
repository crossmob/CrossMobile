// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_coregraphics_CGAffineTransform definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "java_lang_Object.h"

@interface crossmobile_ios_coregraphics_CGAffineTransform : java_lang_Object {
@public double a_double;
@public double b_double;
@public double c_double;
@public double d_double;
@public double tx_double;
@public double ty_double;
}

+ (crossmobile_ios_coregraphics_CGAffineTransform*) identity__;
+ (crossmobile_ios_coregraphics_CGAffineTransform*) makeRotation___double:(double) angle ;
+ (crossmobile_ios_coregraphics_CGAffineTransform*) makeScale___double_double:(double) sx :(double) sy ;
+ (crossmobile_ios_coregraphics_CGAffineTransform*) makeTranslation___double_double:(double) tx :(double) ty ;
- (crossmobile_ios_coregraphics_CGAffineTransform*) __init_crossmobile_ios_coregraphics_CGAffineTransform___double_double_double_double_double_double:(double) a :(double) b :(double) c :(double) d :(double) tx :(double) ty ;
- (void) setA___double:(double) a ;
- (double) getA__;
- (void) setB___double:(double) b ;
- (double) getB__;
- (void) setC___double:(double) c ;
- (double) getC__;
- (void) setD___double:(double) d ;
- (double) getD__;
- (void) setTx___double:(double) tx ;
- (double) getTx__;
- (void) setTy___double:(double) ty ;
- (double) getTy__;
- (crossmobile_ios_coregraphics_CGAffineTransform*) concat___crossmobile_ios_coregraphics_CGAffineTransform:(crossmobile_ios_coregraphics_CGAffineTransform*) t2 ;
- (crossmobile_ios_coregraphics_CGAffineTransform*) invert__;
- (BOOL) isIdentity__;
- (crossmobile_ios_coregraphics_CGAffineTransform*) rotate___double:(double) angle ;
- (crossmobile_ios_coregraphics_CGAffineTransform*) scale___double_double:(double) sx :(double) sy ;
- (crossmobile_ios_coregraphics_CGAffineTransform*) translate___double_double:(double) tx :(double) ty ;
- (instancetype) initWithCGAffineTransform:(CGAffineTransform) reference;
- (void) setCGAffineTransform:(CGAffineTransform) other;
- (CGAffineTransform) getCGAffineTransform;
@end
