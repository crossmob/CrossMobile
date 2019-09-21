// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile_ios_coreimage_CIImage definition

#import "xmlvm.h"
#import <CoreImage/CoreImage.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGImage;

@interface crossmobile_ios_coreimage_CIImage$Ext : CIImage
@end

#define crossmobile_ios_coreimage_CIImage CIImage
@interface CIImage (cm_crossmobile_ios_coreimage_CIImage)
+ (CIImage*) emptyImage__;
- (instancetype) __init_crossmobile_ios_coreimage_CIImage___crossmobile_ios_coregraphics_CGImage:(crossmobile_ios_coregraphics_CGImage*) image ;
- (crossmobile_ios_coregraphics_CGImage*) CGImage__;
@end
