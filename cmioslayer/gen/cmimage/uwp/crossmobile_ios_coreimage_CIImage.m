// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.coreimage.CIImage implementation

#import "crossmobile_ios_coregraphics_CGImage.h"
#import "crossmobile_ios_coreimage_CIImage.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_coreimage_CIImage$Ext

// (CIImage) @property(nonatomic, readonly) CGImageRef CGImage;
- (crossmobile_ios_coregraphics_CGImage*) CGImage__
{
    return [[crossmobile_ios_coregraphics_CGImage alloc] initWithCGImage:[super CGImage]];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValue___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end

@implementation CIImage (cm_crossmobile_ios_coreimage_CIImage)

// direct binding of: + (CIImage *)emptyImage;
+ (CIImage*) emptyImage__
{
    CIImage* re$ult = [CIImage emptyImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (instancetype)initWithCGImage:(CGImageRef)image;
- (instancetype) __init_crossmobile_ios_coreimage_CIImage___crossmobile_ios_coregraphics_CGImage:(crossmobile_ios_coregraphics_CGImage*) image 
{
    return [self initWithCGImage:image->$reference];
}

// direct binding of: @property(nonatomic, readonly) CGImageRef CGImage;
- (crossmobile_ios_coregraphics_CGImage*) CGImage__
{
    return [[crossmobile_ios_coregraphics_CGImage alloc] initWithCGImage:[self CGImage]];
}

@end
