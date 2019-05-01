// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.coreimage.CIFilter implementation

#import "crossmobile_ios_coreimage_CIFilter.h"
#import "crossmobile_ios_coreimage_CIImage.h"
#import "crossmobile_ios_foundation_NSData.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_coreimage_CIFilter$Ext

// (CIFilter) @property(nonatomic, readonly) NSDictionary<NSString *,id> *attributes;
- (NSDictionary*) attributes__
{
    NSDictionary* re$ult = [super attributes];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CIFilter) @property(readonly, nonatomic) CIImage *outputImage;
- (CIImage*) outputImage__
{
    CIImage* re$ult = [super outputImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
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

@implementation CIFilter (cm_crossmobile_ios_coreimage_CIFilter)

// direct binding of: + (CIFilter *)filterWithImageData:(NSData *)data options:(NSDictionary *)options;
+ (CIFilter*) filterWithImageData___crossmobile_ios_foundation_NSData_java_util_Map:(NSData*) data :(NSDictionary*) options 
{
    CIFilter* re$ult = [CIFilter filterWithImageData:(data == JAVA_NULL ? nil : data) options:(options == JAVA_NULL ? nil : options)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (CIFilter *)filterWithName:(NSString *)name;
+ (CIFilter*) filterWithName___java_lang_String:(NSString*) name 
{
    CIFilter* re$ult = [CIFilter filterWithName:(name == JAVA_NULL ? nil : name)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) NSDictionary<NSString *,id> *attributes;
- (NSDictionary*) attributes__
{
    NSDictionary* re$ult = [self attributes];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, nonatomic) CIImage *outputImage;
- (CIImage*) outputImage__
{
    CIImage* re$ult = [self outputImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
