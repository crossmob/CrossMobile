// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_coreimage_CIFilter implementation

#import "crossmobile_ios_coreimage_CIFilter.h"
#import "crossmobile_ios_coreimage_CIImage.h"
#import "crossmobile_ios_foundation_NSData.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_coreimage_CIFilter$Ext

@end

@implementation CIFilter (cm_crossmobile_ios_coreimage_CIFilter)

// + (CIFilter *)filterWithImageData:(NSData *)data options:(NSDictionary *)options;
+ (CIFilter*) filterWithImageData___crossmobile_ios_foundation_NSData_java_util_Map:(NSData*) data :(NSDictionary*) options 
{
    CIFilter* re$ult = [CIFilter filterWithImageData:(data == JAVA_NULL ? nil : data) options:(options == JAVA_NULL ? nil : options)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (CIFilter *)filterWithName:(NSString *)name;
+ (CIFilter*) filterWithName___java_lang_String:(NSString*) name 
{
    CIFilter* re$ult = [CIFilter filterWithName:(name == JAVA_NULL ? nil : name)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) NSDictionary<NSString *,id> *attributes;
- (NSDictionary*) attributes__
{
    NSDictionary* re$ult = [self attributes];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, nonatomic) CIImage *outputImage;
- (CIImage*) outputImage__
{
    CIImage* re$ult = [self outputImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
