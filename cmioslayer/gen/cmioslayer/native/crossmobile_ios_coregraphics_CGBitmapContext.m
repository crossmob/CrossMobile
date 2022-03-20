// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_coregraphics_CGBitmapContext implementation

#import "crossmobile_ios_coregraphics_CGBitmapContext.h"
#import "crossmobile_ios_coregraphics_CGColorSpace.h"
#import "java_lang_Object.h"

@implementation crossmobile_ios_coregraphics_CGBitmapContext

// CGContextRef CGBitmapContextCreate ( void *data, size_t width, size_t height, size_t bitsPerComponent, size_t bytesPerRow, CGColorSpaceRef space, uint32_t bitmapInfo );
+ (crossmobile_ios_coregraphics_CGContext*) create___byte_ARRAYTYPE_int_int_int_int_crossmobile_ios_coregraphics_CGColorSpace_int:(XMLVMArray*) data :(int) width :(int) height :(int) bitsPerComponent :(int) bytesPerRow :(crossmobile_ios_coregraphics_CGColorSpace*) space :(int) bitmapInfo 
{
    return [[crossmobile_ios_coregraphics_CGContext alloc] initWithCGContext:CGBitmapContextCreate((data == JAVA_NULL ? NULL : data->array.data), width, height, bitsPerComponent, bytesPerRow, space->$reference, bitmapInfo)];
}

// void * CGBitmapContextGetData ( CGContextRef context );
- (void*) getData__
{
    return [XMLVMArray createSingleDimensionWithType:3/*byte*/ size:(CGBitmapContextGetBytesPerRow(self->$reference)*CGBitmapContextGetHeight(self->$reference)) andData:(void*)CGBitmapContextGetData(self->$reference)];
}

- (instancetype) initWithCGBitmapContext:(CGBitmapContextRef) reference
{
    self = [super initWithCGContext:reference];
    return self;
}

@end
