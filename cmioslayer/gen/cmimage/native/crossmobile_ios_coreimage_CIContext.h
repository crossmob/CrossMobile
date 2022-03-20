// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_coreimage_CIContext definition

#import "xmlvm.h"
#import <CoreImage/CoreImage.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGImage;
@class crossmobile_ios_coregraphics_CGRect;
@class crossmobile_ios_coreimage_CIImage;

@interface crossmobile_ios_coreimage_CIContext$Ext : CIContext
@end

#define crossmobile_ios_coreimage_CIContext CIContext
@interface CIContext (cm_crossmobile_ios_coreimage_CIContext)
+ (CIContext*) context__;
- (crossmobile_ios_coregraphics_CGImage*) createCGImage___crossmobile_ios_coreimage_CIImage_crossmobile_ios_coregraphics_CGRect:(CIImage*) image :(crossmobile_ios_coregraphics_CGRect*) fromRect ;
@end
