// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_coregraphics_CGImage implementation

#import "crossmobile_ios_coregraphics_CGDataProvider.h"
#import "crossmobile_ios_coregraphics_CGImage.h"
#import "crossmobile_ios_coregraphics_CGRect.h"
#import "java_lang_Object.h"

@implementation crossmobile_ios_coregraphics_CGImage

// CGImageRef CGImageCreateWithImageInRect ( CGImageRef image, CGRect rect );
+ (crossmobile_ios_coregraphics_CGImage*) createWithImageInRect___crossmobile_ios_coregraphics_CGImage_crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGImage*) image :(crossmobile_ios_coregraphics_CGRect*) rect 
{
    return [[crossmobile_ios_coregraphics_CGImage alloc] initWithCGImage:CGImageCreateWithImageInRect(image->$reference, [rect getCGRect])];
}

// CGImageRef CGImageCreateWithPNGDataProvider ( CGDataProviderRef source, const CGFloat *decode, bool shouldInterpolate, CGColorRenderingIntent intent );
+ (crossmobile_ios_coregraphics_CGImage*) createWithPNGDataProvider___crossmobile_ios_coregraphics_CGDataProvider_double_ARRAYTYPE_boolean_int:(crossmobile_ios_coregraphics_CGDataProvider*) source :(XMLVMArray*) decode :(BOOL) shouldInterpolate :(int) intent 
{
    return [[crossmobile_ios_coregraphics_CGImage alloc] initWithCGImage:CGImageCreateWithPNGDataProvider(source->$reference, (decode == JAVA_NULL ? NULL : decode->array.data), shouldInterpolate, intent)];
}

// size_t CGImageGetHeight ( CGImageRef image );
- (int) getHeight__
{
    return CGImageGetHeight(self->$reference);
}

// size_t CGImageGetWidth ( CGImageRef image );
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
