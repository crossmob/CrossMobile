// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile_ios_coregraphics_CGFont implementation

#import "crossmobile_ios_coregraphics_CGDataProvider.h"
#import "crossmobile_ios_coregraphics_CGFont.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_coregraphics_CGFont

// CGFontRef CGFontCreateWithDataProvider ( CGDataProviderRef provider );
+ (crossmobile_ios_coregraphics_CGFont*) createWithDataProvider___crossmobile_ios_coregraphics_CGDataProvider:(crossmobile_ios_coregraphics_CGDataProvider*) provider 
{
    return [[crossmobile_ios_coregraphics_CGFont alloc] initWithCGFont:CGFontCreateWithDataProvider(provider->$reference)];
}

// CGFontRef CGFontCreateWithFontName ( CFStringRef name );
+ (crossmobile_ios_coregraphics_CGFont*) createWithFontName___java_lang_String:(NSString*) name 
{
    return [[crossmobile_ios_coregraphics_CGFont alloc] initWithCGFont:CGFontCreateWithFontName((name == JAVA_NULL ? nil : name))];
}

// int CGFontGetAscent ( CGFontRef font );
- (int) getAscent__
{
    return CGFontGetAscent(self->$reference);
}

// int CGFontGetDescent ( CGFontRef font );
- (int) getDescent__
{
    return CGFontGetDescent(self->$reference);
}

// int CGFontGetUnitsPerEm ( CGFontRef font );
- (int) getUnitsPerEm__
{
    return CGFontGetUnitsPerEm(self->$reference);
}

- (instancetype) initWithCGFont:(CGFontRef) reference
{
    self = [super initWithCFType:reference];
    return self;
}

@end
