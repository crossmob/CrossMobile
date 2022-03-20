// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIEdgeInsets definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "java_lang_Object.h"

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UIEdgeInsets : java_lang_Object {
@public double top_double;
@public double left_double;
@public double bottom_double;
@public double right_double;
}

+ (crossmobile_ios_uikit_UIEdgeInsets*) zero__;
- (crossmobile_ios_uikit_UIEdgeInsets*) __init_crossmobile_ios_uikit_UIEdgeInsets___double_double_double_double:(double) top :(double) left :(double) bottom :(double) right ;
- (void) setBottom___double:(double) bottom ;
- (double) getBottom__;
- (void) setLeft___double:(double) left ;
- (double) getLeft__;
- (void) setRight___double:(double) right ;
- (double) getRight__;
- (void) setTop___double:(double) top ;
- (double) getTop__;
- (BOOL) equalToEdgeInsets___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) insets2 ;
- (instancetype) initWithUIEdgeInsets:(UIEdgeInsets) reference;
- (void) setUIEdgeInsets:(UIEdgeInsets) other;
- (UIEdgeInsets) getUIEdgeInsets;
@end
