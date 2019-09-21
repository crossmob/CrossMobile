// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile_ios_coreimage_CIImage implementation

#import "crossmobile_ios_coregraphics_CGImage.h"
#import "crossmobile_ios_coreimage_CIImage.h"

@implementation crossmobile_ios_coreimage_CIImage$Ext

@end

@implementation CIImage (cm_crossmobile_ios_coreimage_CIImage)

// + (CIImage *)emptyImage;
+ (CIImage*) emptyImage__
{
    CIImage* re$ult = [CIImage emptyImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (instancetype)initWithCGImage:(CGImageRef)image;
- (instancetype) __init_crossmobile_ios_coreimage_CIImage___crossmobile_ios_coregraphics_CGImage:(crossmobile_ios_coregraphics_CGImage*) image 
{
    return [self initWithCGImage:image->$reference];
}

// @property(nonatomic, readonly) CGImageRef CGImage;
- (crossmobile_ios_coregraphics_CGImage*) CGImage__
{
    return [[crossmobile_ios_coregraphics_CGImage alloc] initWithCGImage:[self CGImage]];
}

@end
