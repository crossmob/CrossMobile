// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_coregraphics_CGContext definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "crossmobile_ios_foundation_CFType.h"
@class crossmobile_ios_coregraphics_CGAffineTransform;
@class crossmobile_ios_coregraphics_CGColor;
@class crossmobile_ios_coregraphics_CGColorSpace;
@class crossmobile_ios_coregraphics_CGFont;
@class crossmobile_ios_coregraphics_CGGradient;
@class crossmobile_ios_coregraphics_CGImage;
@class crossmobile_ios_coregraphics_CGPath;
@class crossmobile_ios_coregraphics_CGPoint;
@class crossmobile_ios_coregraphics_CGRect;
@class crossmobile_ios_coregraphics_CGSize;
@class java_lang_Object;
@class java_lang_String;

@interface crossmobile_ios_coregraphics_CGContext : crossmobile_ios_foundation_CFType
- (void) addArc___double_double_double_double_double_int:(double) x :(double) y :(double) radius :(double) startAngle :(double) endAngle :(int) clockwise ;
- (void) addArcToPoint___double_double_double_double_double:(double) x1 :(double) y1 :(double) x2 :(double) y2 :(double) radius ;
- (void) addCurveToPoint___double_double_double_double_double_double:(double) cp1x :(double) cp1y :(double) cp2x :(double) cp2y :(double) x :(double) y ;
- (void) addLineToPoint___double_double:(double) x :(double) y ;
- (void) addLines___crossmobile_ios_coregraphics_CGPoint_ARRAYTYPE:(XMLVMArray*) points ;
- (void) addPath___crossmobile_ios_coregraphics_CGPath:(crossmobile_ios_coregraphics_CGPath*) path ;
- (void) addQuadCurveToPoint___double_double_double_double:(double) cpx :(double) cpy :(double) x :(double) y ;
- (void) addRect___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) rect ;
- (void) addRects___crossmobile_ios_coregraphics_CGRect_ARRAYTYPE:(XMLVMArray*) rects ;
- (void) beginPath__;
- (void) clip__;
- (void) clipToRect___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) rect ;
- (void) closePath__;
- (void) concatCTM___crossmobile_ios_coregraphics_CGAffineTransform:(crossmobile_ios_coregraphics_CGAffineTransform*) transform ;
- (void) drawImage___crossmobile_ios_coregraphics_CGRect_crossmobile_ios_coregraphics_CGImage:(crossmobile_ios_coregraphics_CGRect*) rect :(crossmobile_ios_coregraphics_CGImage*) image ;
- (void) drawLinearGradient___crossmobile_ios_coregraphics_CGGradient_crossmobile_ios_coregraphics_CGPoint_crossmobile_ios_coregraphics_CGPoint_int:(crossmobile_ios_coregraphics_CGGradient*) gradient :(crossmobile_ios_coregraphics_CGPoint*) startPoint :(crossmobile_ios_coregraphics_CGPoint*) endPoint :(int) options ;
- (void) drawPath___int:(int) mode ;
- (void) drawRadialGradient___crossmobile_ios_coregraphics_CGGradient_crossmobile_ios_coregraphics_CGPoint_double_crossmobile_ios_coregraphics_CGPoint_double_int:(crossmobile_ios_coregraphics_CGGradient*) gradient :(crossmobile_ios_coregraphics_CGPoint*) startCenter :(double) startRadius :(crossmobile_ios_coregraphics_CGPoint*) endCenter :(double) endRadius :(int) options ;
- (void) fillEllipseInRect___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) rect ;
- (void) fillPath__;
- (void) fillRect___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) rect ;
- (crossmobile_ios_coregraphics_CGAffineTransform*) getCTM__;
- (crossmobile_ios_coregraphics_CGRect*) getClipBoundingBox__;
- (crossmobile_ios_coregraphics_CGPoint*) getTextPosition__;
- (void) moveToPoint___double_double:(double) x :(double) y ;
- (void) restoreGState__;
- (void) rotateCTM___double:(double) angle ;
- (void) saveGState__;
- (void) scaleCTM___double_double:(double) sx :(double) sy ;
- (void) selectFont___java_lang_String_double_int:(NSString*) name :(double) size :(int) textEncoding ;
- (void) setAlpha___double:(double) alpha ;
- (void) setFillColor___double_ARRAYTYPE:(XMLVMArray*) components ;
- (void) setFillColorSpace___crossmobile_ios_coregraphics_CGColorSpace:(crossmobile_ios_coregraphics_CGColorSpace*) space ;
- (void) setFillColorWithColor___crossmobile_ios_coregraphics_CGColor:(crossmobile_ios_coregraphics_CGColor*) color ;
- (void) setFont___crossmobile_ios_coregraphics_CGFont:(crossmobile_ios_coregraphics_CGFont*) font ;
- (void) setFontSize___double:(double) size ;
- (void) setLineCap___int:(int) cap ;
- (void) setLineJoin___int:(int) join ;
- (void) setLineWidth___double:(double) width ;
- (void) setRGBFillColor___double_double_double_double:(double) red :(double) green :(double) blue :(double) alpha ;
- (void) setRGBStrokeColor___double_double_double_double:(double) red :(double) green :(double) blue :(double) alpha ;
- (void) setShadowWithColor___crossmobile_ios_coregraphics_CGSize_double_crossmobile_ios_coregraphics_CGColor:(crossmobile_ios_coregraphics_CGSize*) offset :(double) blur :(crossmobile_ios_coregraphics_CGColor*) color ;
- (void) setShouldAntialias___boolean:(BOOL) shouldAntialias ;
- (void) setStrokeColor___double_ARRAYTYPE:(XMLVMArray*) components ;
- (void) setStrokeColorSpace___crossmobile_ios_coregraphics_CGColorSpace:(crossmobile_ios_coregraphics_CGColorSpace*) space ;
- (void) setStrokeColorWithColor___crossmobile_ios_coregraphics_CGColor:(crossmobile_ios_coregraphics_CGColor*) color ;
- (void) setTextDrawingMode___int:(int) mode ;
- (void) setTextMatrix___crossmobile_ios_coregraphics_CGAffineTransform:(crossmobile_ios_coregraphics_CGAffineTransform*) t ;
- (void) setTextPosition___double_double:(double) x :(double) y ;
- (void) showText___java_lang_String:(NSString*) string ;
- (void) showTextAtPoint___double_double_java_lang_String:(double) x :(double) y :(NSString*) string ;
- (void) strokeEllipseInRect___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) rect ;
- (void) strokeLineSegments___crossmobile_ios_coregraphics_CGPoint_ARRAYTYPE:(XMLVMArray*) points ;
- (void) strokePath__;
- (void) strokeRect___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) rect ;
- (void) translateCTM___double_double:(double) tx :(double) ty ;
- (instancetype) initWithCGContext:(CGContextRef) reference;
@end
