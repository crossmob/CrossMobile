// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_coregraphics_CGColorSpace implementation

#import "crossmobile_ios_coregraphics_CGColorSpace.h"
#import "java_lang_Object.h"

@implementation crossmobile_ios_coregraphics_CGColorSpace

// CGColorSpaceRef CGColorSpaceCreateDeviceGray ( void );
+ (crossmobile_ios_coregraphics_CGColorSpace*) createDeviceGray__
{
    return [[crossmobile_ios_coregraphics_CGColorSpace alloc] initWithCGColorSpace:CGColorSpaceCreateDeviceGray()];
}

// CGColorSpaceRef CGColorSpaceCreateDeviceRGB ( void );
+ (crossmobile_ios_coregraphics_CGColorSpace*) createDeviceRGB__
{
    return [[crossmobile_ios_coregraphics_CGColorSpace alloc] initWithCGColorSpace:CGColorSpaceCreateDeviceRGB()];
}

// size_t CGColorSpaceGetNumberOfComponents ( CGColorSpaceRef space );
- (int) getNumberOfComponents__
{
    return CGColorSpaceGetNumberOfComponents(self->$reference);
}

- (instancetype) initWithCGColorSpace:(CGColorSpaceRef) reference
{
    self = [super initWithCFType:reference];
    return self;
}

@end
