// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIGestureRecognizer definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGPoint;
@protocol crossmobile_ios_foundation_NSSelector;
@class crossmobile_ios_uikit_UIEvent;
@protocol crossmobile_ios_uikit_UIGestureRecognizerDelegate;
@class crossmobile_ios_uikit_UIView;
@class java_lang_reflect_Method;
@protocol java_util_Set;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UIGestureRecognizer$Ext : UIGestureRecognizer
@end

#define crossmobile_ios_uikit_UIGestureRecognizer UIGestureRecognizer
@interface UIGestureRecognizer (cm_crossmobile_ios_uikit_UIGestureRecognizer)
- (instancetype) __init_crossmobile_ios_uikit_UIGestureRecognizer___crossmobile_ios_foundation_NSSelector:(id<crossmobile_ios_foundation_NSSelector>) target ;
- (void) setCancelsTouchesInView___boolean:(BOOL) cancelsTouchesInView ;
- (BOOL) cancelsTouchesInView__;
- (void) setDelaysTouchesBegan___boolean:(BOOL) delaysTouchesBegan ;
- (BOOL) delaysTouchesBegan__;
- (void) setDelaysTouchesEnded___boolean:(BOOL) delaysTouchesEnded ;
- (BOOL) delaysTouchesEnded__;
- (void) setDelegate___crossmobile_ios_uikit_UIGestureRecognizerDelegate:(id<UIGestureRecognizerDelegate>) delegate ;
- (id<UIGestureRecognizerDelegate>) delegate__;
- (void) setEnabled___boolean:(BOOL) enabled ;
- (BOOL) isEnabled__;
- (int) state__;
- (UIView*) view__;
- (void) addTarget___crossmobile_ios_foundation_NSSelector:(id<crossmobile_ios_foundation_NSSelector>) target ;
- (BOOL) canBePreventedByGestureRecognizer___crossmobile_ios_uikit_UIGestureRecognizer:(UIGestureRecognizer*) preventingGestureRecognizer ;
- (BOOL) canPreventGestureRecognizer___crossmobile_ios_uikit_UIGestureRecognizer:(UIGestureRecognizer*) preventedGestureRecognizer ;
- (crossmobile_ios_coregraphics_CGPoint*) locationInView___crossmobile_ios_uikit_UIView:(UIView*) view ;
- (crossmobile_ios_coregraphics_CGPoint*) locationOfTouch___int_crossmobile_ios_uikit_UIView:(int) touchIndex :(UIView*) view ;
- (int) numberOfTouches__;
- (void) removeTarget___crossmobile_ios_foundation_NSSelector:(id<crossmobile_ios_foundation_NSSelector>) target ;
- (void) requireGestureRecognizerToFail___crossmobile_ios_uikit_UIGestureRecognizer:(UIGestureRecognizer*) otherGestureRecognizer ;
- (void) reset__;
- (void) touchesBegan___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event ;
- (void) touchesCancelled___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event ;
- (void) touchesEnded___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event ;
- (void) touchesMoved___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event ;
@end
