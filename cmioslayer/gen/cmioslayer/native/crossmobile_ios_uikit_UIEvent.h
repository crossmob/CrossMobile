// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile_ios_uikit_UIEvent definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@protocol java_util_Set;

@interface crossmobile_ios_uikit_UIEvent$Ext : UIEvent
@end

#define crossmobile_ios_uikit_UIEvent UIEvent
@interface UIEvent (cm_crossmobile_ios_uikit_UIEvent)
- (int) subtype__;
- (double) timestamp__;
- (int) type__;
- (NSSet*) allTouches__;
@end
