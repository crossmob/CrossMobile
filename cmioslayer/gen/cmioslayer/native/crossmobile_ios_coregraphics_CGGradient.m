// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_coregraphics_CGGradient implementation

#import "crossmobile_ios_coregraphics_CGColorSpace.h"
#import "crossmobile_ios_coregraphics_CGGradient.h"
#import "java_lang_Object.h"
#import "java_util_List.h"

@implementation crossmobile_ios_coregraphics_CGGradient

// CGGradientRef CGGradientCreateWithColorComponents ( CGColorSpaceRef space, const CGFloat *components, const CGFloat *locations, size_t count );
- (crossmobile_ios_coregraphics_CGGradient*) __init_crossmobile_ios_coregraphics_CGGradient___crossmobile_ios_coregraphics_CGColorSpace_double_ARRAYTYPE_double_ARRAYTYPE:(crossmobile_ios_coregraphics_CGColorSpace*) space :(XMLVMArray*) components :(XMLVMArray*) locations 
{
    return [self initWithCGGradient:CGGradientCreateWithColorComponents(space->$reference, (components == JAVA_NULL ? NULL : components->array.data), (locations == JAVA_NULL ? NULL : locations->array.data), (locations == JAVA_NULL ? 0 : locations->length))];
}

// CGGradientRef CGGradientCreateWithColors ( CGColorSpaceRef space, CFArrayRef colors, const CGFloat *locations );
- (crossmobile_ios_coregraphics_CGGradient*) __init_crossmobile_ios_coregraphics_CGGradient___crossmobile_ios_coregraphics_CGColorSpace_java_util_List_double_ARRAYTYPE:(crossmobile_ios_coregraphics_CGColorSpace*) space :(NSArray*) colors :(XMLVMArray*) locations 
{
    return [self initWithCGGradient:CGGradientCreateWithColors(space->$reference, (colors == JAVA_NULL ? nil : colors), (locations == JAVA_NULL ? NULL : locations->array.data))];
}

- (instancetype) initWithCGGradient:(CGGradientRef) reference
{
    self = [super initWithCFType:reference];
    return self;
}

@end
