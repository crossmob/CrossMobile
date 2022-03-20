// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UILayoutSupport definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_NSLayoutDimension;
@class crossmobile_ios_uikit_NSLayoutYAxisAnchor;

@protocol crossmobile_ios_uikit_UILayoutSupport
- (NSLayoutYAxisAnchor*) bottomAnchor__;
- (NSLayoutDimension*) heightAnchor__;
- (double) length__;
- (NSLayoutYAxisAnchor*) topAnchor__;
@end
