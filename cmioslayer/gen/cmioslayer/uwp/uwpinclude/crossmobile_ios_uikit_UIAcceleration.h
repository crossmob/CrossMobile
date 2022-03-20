// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIAcceleration definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UIAcceleration$Ext : UIAcceleration
@end

#define crossmobile_ios_uikit_UIAcceleration UIAcceleration
@interface UIAcceleration (cm_crossmobile_ios_uikit_UIAcceleration)
- (double) timestamp__;
- (double) x__;
- (double) y__;
- (double) z__;
@end
