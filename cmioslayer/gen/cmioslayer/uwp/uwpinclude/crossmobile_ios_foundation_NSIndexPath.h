// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSIndexPath definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>

CM_EXPORT_CLASS
@interface crossmobile_ios_foundation_NSIndexPath$Ext : NSIndexPath
@end

#define crossmobile_ios_foundation_NSIndexPath NSIndexPath
@interface NSIndexPath (cm_crossmobile_ios_foundation_NSIndexPath)
+ (instancetype) indexPathForRow___int_int:(int) row :(int) section ;
- (int) row__;
- (int) section__;
@end
