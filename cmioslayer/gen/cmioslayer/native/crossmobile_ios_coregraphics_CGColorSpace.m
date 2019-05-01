// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.coregraphics.CGColorSpace implementation

#import "crossmobile_ios_coregraphics_CGColorSpace.h"
#import "java_lang_Object.h"

@implementation crossmobile_ios_coregraphics_CGColorSpace

// direct binding of: CGColorSpaceRef CGColorSpaceCreateDeviceGray ( void );
+ (crossmobile_ios_coregraphics_CGColorSpace*) createDeviceGray__
{
    return [[crossmobile_ios_coregraphics_CGColorSpace alloc] initWithCGColorSpace:CGColorSpaceCreateDeviceGray()];
}

// direct binding of: CGColorSpaceRef CGColorSpaceCreateDeviceRGB ( void );
+ (crossmobile_ios_coregraphics_CGColorSpace*) createDeviceRGB__
{
    return [[crossmobile_ios_coregraphics_CGColorSpace alloc] initWithCGColorSpace:CGColorSpaceCreateDeviceRGB()];
}

// direct binding of: size_t CGColorSpaceGetNumberOfComponents ( CGColorSpaceRef space );
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
