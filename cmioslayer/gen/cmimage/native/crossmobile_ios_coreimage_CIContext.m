// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_coreimage_CIContext implementation

#import "crossmobile_ios_coregraphics_CGImage.h"
#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_coreimage_CIContext.h"
#import "crossmobile_ios_coreimage_CIImage.h"

@implementation crossmobile_ios_coreimage_CIContext$Ext

@end

@implementation CIContext (cm_crossmobile_ios_coreimage_CIContext)

// + (CIContext *)context;
+ (CIContext*) context__
{
    CIContext* re$ult = [CIContext context];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (CGImageRef)createCGImage:(CIImage *)image fromRect:(CGRect)fromRect;
- (crossmobile_ios_coregraphics_CGImage*) createCGImage___crossmobile_ios_coreimage_CIImage_crossmobile_ios_coregraphics_CGRect:(CIImage*) image :(crossmobile_ios_coregraphics_CGRect*) fromRect 
{
    return [[crossmobile_ios_coregraphics_CGImage alloc] initWithCGImage:[self createCGImage:(image == JAVA_NULL ? nil : image) fromRect:[fromRect getCGRect]]];
}

@end
