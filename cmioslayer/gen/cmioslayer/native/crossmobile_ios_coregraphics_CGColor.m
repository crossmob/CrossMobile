// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_coregraphics_CGColor implementation

#import "crossmobile_ios_coregraphics_CGColor.h"
#import "java_lang_Object.h"

@implementation crossmobile_ios_coregraphics_CGColor

// CGFloat CGColorGetAlpha ( CGColorRef color );
- (double) getAlpha__
{
    return CGColorGetAlpha(self->$reference);
}

// const CGFloat * CGColorGetComponents ( CGColorRef color );
- (XMLVMArray*) getComponents__
{
    return [XMLVMArray createSingleDimensionWithType:7/*double*/ size:(CGColorGetNumberOfComponents($reference)+1) andData:(void*)CGColorGetComponents(self->$reference)];
}

// size_t CGColorGetNumberOfComponents ( CGColorRef color );
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
