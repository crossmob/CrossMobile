// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.coregraphics.CGDataProvider definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "crossmobile_ios_foundation_CFType.h"
@class java_lang_Object;
@class java_lang_String;

CM_EXPORT_CLASS
@interface crossmobile_ios_coregraphics_CGDataProvider : crossmobile_ios_foundation_CFType
+ (crossmobile_ios_coregraphics_CGDataProvider*) createWithFilename___java_lang_String:(NSString*) filename ;
- (instancetype) initWithCGDataProvider:(CGDataProviderRef) reference;
@end
