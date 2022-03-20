// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UITouch definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGPoint;
@class crossmobile_ios_uikit_UIView;
@class crossmobile_ios_uikit_UIWindow;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UITouch$Ext : UITouch
@end

#define crossmobile_ios_uikit_UITouch UITouch
@interface UITouch (cm_crossmobile_ios_uikit_UITouch)
- (int) phase__;
- (int) tapCount__;
- (double) timestamp__;
- (UIView*) view__;
- (UIWindow*) window__;
- (crossmobile_ios_coregraphics_CGPoint*) locationInView___crossmobile_ios_uikit_UIView:(UIView*) view ;
@end
