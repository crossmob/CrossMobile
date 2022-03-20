// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIControlDelegate definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UIControl;
@class crossmobile_ios_uikit_UIEvent;

CM_EXPORT_CLASS
@protocol crossmobile_ios_uikit_UIControlDelegate
- (void) exec___crossmobile_ios_uikit_UIControl_crossmobile_ios_uikit_UIEvent:(UIControl*) sender :(UIEvent*) event ;
@end
