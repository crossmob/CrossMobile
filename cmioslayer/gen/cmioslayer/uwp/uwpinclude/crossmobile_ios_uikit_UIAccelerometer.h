// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIAccelerometer definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@protocol crossmobile_ios_uikit_UIAccelerometerDelegate;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UIAccelerometer$Ext : UIAccelerometer
@end

#define crossmobile_ios_uikit_UIAccelerometer UIAccelerometer
@interface UIAccelerometer (cm_crossmobile_ios_uikit_UIAccelerometer)
+ (UIAccelerometer*) sharedAccelerometer__;
- (void) setDelegate___crossmobile_ios_uikit_UIAccelerometerDelegate:(id<UIAccelerometerDelegate>) delegate ;
- (void) setUpdateInterval___double:(double) updateInterval ;
@end
