// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile_ios_coreimage_CIFilter definition

#import "xmlvm.h"
#import <CoreImage/CoreImage.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coreimage_CIImage;
@class crossmobile_ios_foundation_NSData;
@class java_lang_String;
@protocol java_util_Map;

CM_EXPORT_CLASS
@interface crossmobile_ios_coreimage_CIFilter$Ext : CIFilter
@end

#define crossmobile_ios_coreimage_CIFilter CIFilter
@interface CIFilter (cm_crossmobile_ios_coreimage_CIFilter)
+ (CIFilter*) filterWithImageData___crossmobile_ios_foundation_NSData_java_util_Map:(NSData*) data :(NSDictionary*) options ;
+ (CIFilter*) filterWithName___java_lang_String:(NSString*) name ;
- (NSDictionary*) attributes__;
- (CIImage*) outputImage__;
@end
