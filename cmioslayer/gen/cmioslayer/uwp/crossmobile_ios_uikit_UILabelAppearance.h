// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UILabelAppearance definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "crossmobile_ios_uikit_UIViewAppearance.h"
@class crossmobile_ios_uikit_UIColor;
@class crossmobile_ios_uikit_UIFont;

@interface crossmobile_ios_uikit_UILabelAppearance : crossmobile_ios_uikit_UIViewAppearance
- (void) setFont___crossmobile_ios_uikit_UIFont:(UIFont*) font ;
- (void) setTextColor___crossmobile_ios_uikit_UIColor:(UIColor*) textColor ;
- (instancetype) initWithUILabelAppearance:(id) reference;
@end
