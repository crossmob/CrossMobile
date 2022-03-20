// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIResponder definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UIEvent;
@protocol java_util_Set;

@interface crossmobile_ios_uikit_UIResponder$Ext : UIResponder
@end

#define crossmobile_ios_uikit_UIResponder UIResponder
@interface UIResponder (cm_crossmobile_ios_uikit_UIResponder)
- (instancetype) __init_crossmobile_ios_uikit_UIResponder__;
- (BOOL) becomeFirstResponder__;
- (BOOL) isFirstResponder__;
- (UIResponder*) nextResponder__;
- (BOOL) resignFirstResponder__;
- (void) touchesBegan___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event ;
- (void) touchesCancelled___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event ;
- (void) touchesEnded___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event ;
- (void) touchesMoved___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event ;
@end
