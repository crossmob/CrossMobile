// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.coregraphics.CGColor implementation

#import "crossmobile_ios_coregraphics_CGColor.h"
#import "java_lang_Object.h"

@implementation crossmobile_ios_coregraphics_CGColor

// direct binding of: CGFloat CGColorGetAlpha ( CGColorRef color );
- (double) getAlpha__
{
    return CGColorGetAlpha(self->$reference);
}

// direct binding of: const CGFloat * CGColorGetComponents ( CGColorRef color );
- (XMLVMArray*) getComponents__
{
    return [XMLVMArray createSingleDimensionWithType:7/*double*/ size:(CGColorGetNumberOfComponents($reference)+1) andData:(void*)CGColorGetComponents(self->$reference)];
}

// direct binding of: size_t CGColorGetNumberOfComponents ( CGColorRef color );
- (int) getNumberOfComponents__
{
    return CGColorGetNumberOfComponents(self->$reference);
}

- (instancetype) initWithCGColor:(CGColorRef) reference
{
    self = [super initWithCFType:reference];
    return self;
}

@end
