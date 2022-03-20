// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIPanGestureRecognizer definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGPoint;
@protocol crossmobile_ios_foundation_NSSelector;
@class crossmobile_ios_uikit_UIView;
@class java_lang_reflect_Method;

@interface crossmobile_ios_uikit_UIPanGestureRecognizer$Ext : UIPanGestureRecognizer
@end

#define crossmobile_ios_uikit_UIPanGestureRecognizer UIPanGestureRecognizer
@interface UIPanGestureRecognizer (cm_crossmobile_ios_uikit_UIPanGestureRecognizer)
- (instancetype) __init_crossmobile_ios_uikit_UIPanGestureRecognizer___crossmobile_ios_foundation_NSSelector:(id<crossmobile_ios_foundation_NSSelector>) target ;
- (void) setMaximumNumberOfTouches___int:(int) maximumNumberOfTouches ;
- (int) maximumNumberOfTouches__;
- (void) setMinimumNumberOfTouches___int:(int) minimumNumberOfTouches ;
- (int) minimumNumberOfTouches__;
- (void) setTranslation___crossmobile_ios_coregraphics_CGPoint_crossmobile_ios_uikit_UIView:(crossmobile_ios_coregraphics_CGPoint*) translation :(UIView*) view ;
- (crossmobile_ios_coregraphics_CGPoint*) translationInView___crossmobile_ios_uikit_UIView:(UIView*) view ;
- (crossmobile_ios_coregraphics_CGPoint*) velocityInView___crossmobile_ios_uikit_UIView:(UIView*) view ;
@end
