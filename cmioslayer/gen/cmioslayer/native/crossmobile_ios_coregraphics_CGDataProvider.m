// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.coregraphics.CGDataProvider implementation

#import "crossmobile_ios_coregraphics_CGDataProvider.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_coregraphics_CGDataProvider

// direct binding of: CGDataProviderRef CGDataProviderCreateWithFilename ( const char *filename );
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
