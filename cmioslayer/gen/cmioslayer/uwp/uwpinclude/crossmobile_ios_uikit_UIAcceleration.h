// (c) 2020 under LGPL by CrossMobile plugin tools

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
