// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.coregraphics.CGImage implementation

#import "crossmobile_ios_coregraphics_CGDataProvider.h"
#import "crossmobile_ios_coregraphics_CGImage.h"
#import "crossmobile_ios_coregraphics_CGRect.h"
#import "java_lang_Object.h"

@implementation crossmobile_ios_coregraphics_CGImage

// direct binding of: CGImageRef CGImageCreateWithImageInRect ( CGImageRef image, CGRect rect );
+ (crossmobile_ios_coregraphics_CGImage*) createWithImageInRect___crossmobile_ios_coregraphics_CGImage_crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGImage*) image :(crossmobile_ios_coregraphics_CGRect*) rect 
{
    return [[crossmobile_ios_coregraphics_CGImage alloc] initWithCGImage:CGImageCreateWithImageInRect(image->$reference, [rect getCGRect])];
}

// direct binding of: CGImageRef CGImageCreateWithPNGDataProvider ( CGDataProviderRef source, const CGFloat *decode, bool shouldInterpolate, CGColorRenderingIntent intent );
+ (crossmobile_ios_coregraphics_CGImage*) createWithPNGDataProvider___crossmobile_ios_coregraphics_CGDataProvider_double_ARRAYTYPE_boolean_int:(crossmobile_ios_coregraphics_CGDataProvider*) source :(XMLVMArray*) decode :(BOOL) shouldInterpolate :(int) intent 
{
    return [[crossmobile_ios_coregraphics_CGImage alloc] initWithCGImage:CGImageCreateWithPNGDataProvider(source->$reference, (decode == JAVA_NULL ? NULL : decode->array.data), shouldInterpolate, intent)];
}

// direct binding of: size_t CGImageGetHeight ( CGImageRef image );
- (int) getHeight__
{
    return CGImageGetHeight(self->$reference);
}

// direct binding of: size_t CGImageGetWidth ( CGImageRef image );
- (int) getWidth__
{
    return CGImageGetWidth(self->$reference);
}

- (instancetype) initWithCGImage:(CGImageRef) reference
{
    self = [super initWithCFType:reference];
    return self;
}

@end
