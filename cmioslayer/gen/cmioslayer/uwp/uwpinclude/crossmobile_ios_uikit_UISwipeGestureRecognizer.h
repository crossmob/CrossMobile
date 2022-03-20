// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UISwipeGestureRecognizer definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@protocol crossmobile_ios_foundation_NSSelector;
@class java_lang_reflect_Method;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UISwipeGestureRecognizer$Ext : UISwipeGestureRecognizer
@end

#define crossmobile_ios_uikit_UISwipeGestureRecognizer UISwipeGestureRecognizer
@interface UISwipeGestureRecognizer (cm_crossmobile_ios_uikit_UISwipeGestureRecognizer)
- (instancetype) __init_crossmobile_ios_uikit_UISwipeGestureRecognizer___crossmobile_ios_foundation_NSSelector:(id<crossmobile_ios_foundation_NSSelector>) target ;
- (void) setDirection___int:(int) direction ;
- (int) direction__;
- (void) setNumberOfTouchesRequired___int:(int) numberOfTouchesRequired ;
- (int) numberOfTouchesRequired__;
@end
