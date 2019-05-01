// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.coreimage.CIContext implementation

#import "crossmobile_ios_coregraphics_CGImage.h"
#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_coreimage_CIContext.h"
#import "crossmobile_ios_coreimage_CIImage.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_coreimage_CIContext$Ext

// (CIContext) - (CGImageRef)createCGImage:(CIImage *)image fromRect:(CGRect)fromRect;
- (crossmobile_ios_coregraphics_CGImage*) createCGImage___crossmobile_ios_coreimage_CIImage_crossmobile_ios_coregraphics_CGRect:(CIImage*) image :(crossmobile_ios_coregraphics_CGRect*) fromRect 
{
    return [[crossmobile_ios_coregraphics_CGImage alloc] initWithCGImage:[super createCGImage:(image == JAVA_NULL ? nil : image) fromRect:[fromRect getCGRect]]];
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

@implementation CIContext (cm_crossmobile_ios_coreimage_CIContext)

// direct binding of: + (CIContext *)context;
+ (CIContext*) context__
{
    CIContext* re$ult = [CIContext context];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (CGImageRef)createCGImage:(CIImage *)image fromRect:(CGRect)fromRect;
- (crossmobile_ios_coregraphics_CGImage*) createCGImage___crossmobile_ios_coreimage_CIImage_crossmobile_ios_coregraphics_CGRect:(CIImage*) image :(crossmobile_ios_coregraphics_CGRect*) fromRect 
{
    return [[crossmobile_ios_coregraphics_CGImage alloc] initWithCGImage:[self createCGImage:(image == JAVA_NULL ? nil : image) fromRect:[fromRect getCGRect]]];
}

@end
