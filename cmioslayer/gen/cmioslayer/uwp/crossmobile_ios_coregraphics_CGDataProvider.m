// (c) 2020 under LGPL by CrossMobile plugin tools

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
