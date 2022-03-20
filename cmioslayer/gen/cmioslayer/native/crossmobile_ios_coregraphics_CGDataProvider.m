// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_coregraphics_CGDataProvider implementation

#import "crossmobile_ios_coregraphics_CGDataProvider.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_coregraphics_CGDataProvider

// CGDataProviderRef CGDataProviderCreateWithFilename ( const char *filename );
+ (crossmobile_ios_coregraphics_CGDataProvider*) createWithFilename___java_lang_String:(NSString*) filename 
{
    return [[crossmobile_ios_coregraphics_CGDataProvider alloc] initWithCGDataProvider:CGDataProviderCreateWithFilename([filename UTF8String])];
}

- (instancetype) initWithCGDataProvider:(CGDataProviderRef) reference
{
    self = [super initWithCFType:reference];
    return self;
}

@end
