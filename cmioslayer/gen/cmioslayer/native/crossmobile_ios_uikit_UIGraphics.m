// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIGraphics implementation

#import "crossmobile_ios_coregraphics_CGContext.h"
#import "crossmobile_ios_coregraphics_CGSize.h"
#import "crossmobile_ios_uikit_UIGraphics.h"
#import "crossmobile_ios_uikit_UIImage.h"

@implementation crossmobile_ios_uikit_UIGraphics

// void UIGraphicsBeginImageContext ( CGSize size );
+ (void) beginImageContext___crossmobile_ios_coregraphics_CGSize:(crossmobile_ios_coregraphics_CGSize*) size 
{
    UIGraphicsBeginImageContext([size getCGSize]);
}

// void UIGraphicsBeginImageContextWithOptions ( CGSize size, BOOL opaque, CGFloat scale );
+ (void) beginImageContextWithOptions___crossmobile_ios_coregraphics_CGSize_boolean_double:(crossmobile_ios_coregraphics_CGSize*) size :(BOOL) opaque :(double) scale 
{
    UIGraphicsBeginImageContextWithOptions([size getCGSize], opaque, scale);
}

// void UIGraphicsEndImageContext ( void );
+ (void) endImageContext__
{
    UIGraphicsEndImageContext();
}

// CGContextRef UIGraphicsGetCurrentContext ( void );
+ (crossmobile_ios_coregraphics_CGContext*) getCurrentContext__
{
    return [[crossmobile_ios_coregraphics_CGContext alloc] initWithCGContext:UIGraphicsGetCurrentContext()];
}

// UIImage * UIGraphicsGetImageFromCurrentImageContext ( void );
+ (UIImage*) getImageFromCurrentImageContext__
{
    UIImage* re$ult = UIGraphicsGetImageFromCurrentImageContext();
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// void UIGraphicsPopContext ( void );
+ (void) popContext__
{
    UIGraphicsPopContext();
}

// void UIGraphicsPushContext ( CGContextRef context );
+ (void) pushContext___crossmobile_ios_coregraphics_CGContext:(crossmobile_ios_coregraphics_CGContext*) context 
{
    UIGraphicsPushContext(context->$reference);
}

@end
