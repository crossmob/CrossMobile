// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_coregraphics_CGLayer implementation

#import "crossmobile_ios_coregraphics_CGContext.h"
#import "crossmobile_ios_coregraphics_CGLayer.h"
#import "crossmobile_ios_coregraphics_CGSize.h"
#import "java_lang_Object.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_coregraphics_CGLayer

// CGLayerRef CGLayerCreateWithContext ( CGContextRef context, CGSize size, CFDictionaryRef auxiliaryInfo );
+ (crossmobile_ios_coregraphics_CGLayer*) createWithContext___crossmobile_ios_coregraphics_CGContext_crossmobile_ios_coregraphics_CGSize_java_util_Map:(crossmobile_ios_coregraphics_CGContext*) context :(crossmobile_ios_coregraphics_CGSize*) size :(NSDictionary*) auxiliaryInfo 
{
    return [[crossmobile_ios_coregraphics_CGLayer alloc] initWithCGLayer:CGLayerCreateWithContext(context->$reference, [size getCGSize], (auxiliaryInfo == JAVA_NULL ? nil : auxiliaryInfo))];
}

// CGContextRef CGLayerGetContext ( CGLayerRef layer );
- (crossmobile_ios_coregraphics_CGContext*) getContext__
{
    return [[crossmobile_ios_coregraphics_CGContext alloc] initWithCGContext:CGLayerGetContext(self->$reference)];
}

// CGSize CGLayerGetSize ( CGLayerRef layer );
- (crossmobile_ios_coregraphics_CGSize*) getSize__
{
    return [[crossmobile_ios_coregraphics_CGSize alloc] initWithCGSize:CGLayerGetSize(self->$reference)];
}

- (instancetype) initWithCGLayer:(CGLayerRef) reference
{
    self = [super initWithCFType:reference];
    return self;
}

@end
