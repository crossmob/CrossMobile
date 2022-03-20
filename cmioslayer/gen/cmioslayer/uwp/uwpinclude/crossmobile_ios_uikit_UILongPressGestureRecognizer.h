// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UILongPressGestureRecognizer definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@protocol crossmobile_ios_foundation_NSSelector;
@class java_lang_reflect_Method;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UILongPressGestureRecognizer$Ext : UILongPressGestureRecognizer
@end

#define crossmobile_ios_uikit_UILongPressGestureRecognizer UILongPressGestureRecognizer
@interface UILongPressGestureRecognizer (cm_crossmobile_ios_uikit_UILongPressGestureRecognizer)
- (instancetype) __init_crossmobile_ios_uikit_UILongPressGestureRecognizer___crossmobile_ios_foundation_NSSelector:(id<crossmobile_ios_foundation_NSSelector>) target ;
- (void) setAllowableMovement___double:(double) allowableMovement ;
- (double) allowableMovement__;
- (void) setMinimumPressDuration___double:(double) minimumPressDuration ;
- (double) minimumPressDuration__;
- (void) setNumberOfTapsRequired___int:(int) numberOfTapsRequired ;
- (int) numberOfTapsRequired__;
- (void) setNumberOfTouchesRequired___int:(int) numberOfTouchesRequired ;
- (int) numberOfTouchesRequired__;
@end
