// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSNumberFormatter definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>

@interface crossmobile_ios_foundation_NSNumberFormatter$Ext : NSNumberFormatter
@end

#define crossmobile_ios_foundation_NSNumberFormatter NSNumberFormatter
@interface NSNumberFormatter (cm_crossmobile_ios_foundation_NSNumberFormatter)
- (instancetype) __init_crossmobile_ios_foundation_NSNumberFormatter__;
- (void) setMaximumFractionDigits___int:(int) maximumFractionDigits ;
- (int) maximumFractionDigits__;
- (void) setNumberStyle___int:(int) numberStyle ;
- (int) numberStyle__;
@end
