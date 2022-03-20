// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UITapGestureRecognizer definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@protocol crossmobile_ios_foundation_NSSelector;
@class java_lang_reflect_Method;

@interface crossmobile_ios_uikit_UITapGestureRecognizer$Ext : UITapGestureRecognizer
@end

#define crossmobile_ios_uikit_UITapGestureRecognizer UITapGestureRecognizer
@interface UITapGestureRecognizer (cm_crossmobile_ios_uikit_UITapGestureRecognizer)
- (instancetype) __init_crossmobile_ios_uikit_UITapGestureRecognizer___crossmobile_ios_foundation_NSSelector:(id<crossmobile_ios_foundation_NSSelector>) target ;
- (void) setNumberOfTapsRequired___int:(int) numberOfTapsRequired ;
- (int) numberOfTapsRequired__;
- (void) setNumberOfTouchesRequired___int:(int) numberOfTouchesRequired ;
- (int) numberOfTouchesRequired__;
@end
