// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_quartzcore_CAShapeLayer definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGPath;

CM_EXPORT_CLASS
@interface crossmobile_ios_quartzcore_CAShapeLayer$Ext : CAShapeLayer
@end

#define crossmobile_ios_quartzcore_CAShapeLayer CAShapeLayer
@interface CAShapeLayer (cm_crossmobile_ios_quartzcore_CAShapeLayer)
- (instancetype) __init_crossmobile_ios_quartzcore_CAShapeLayer__;
- (void) setPath___crossmobile_ios_coregraphics_CGPath:(crossmobile_ios_coregraphics_CGPath*) path ;
- (crossmobile_ios_coregraphics_CGPath*) path__;
@end
