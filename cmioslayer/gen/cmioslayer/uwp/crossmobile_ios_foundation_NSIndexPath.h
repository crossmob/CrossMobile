// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSIndexPath definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>

@interface crossmobile_ios_foundation_NSIndexPath$Ext : NSIndexPath
@end

#define crossmobile_ios_foundation_NSIndexPath NSIndexPath
@interface NSIndexPath (cm_crossmobile_ios_foundation_NSIndexPath)
+ (instancetype) indexPathForRow___int_int:(int) row :(int) section ;
- (int) row__;
- (int) section__;
@end
