// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.coregraphics.CGLayer definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "crossmobile_ios_foundation_CFType.h"
@class crossmobile_ios_coregraphics_CGContext;
@class crossmobile_ios_coregraphics_CGSize;
@class java_lang_Object;
@protocol java_util_Map;

CM_EXPORT_CLASS
@interface crossmobile_ios_coregraphics_CGLayer : crossmobile_ios_foundation_CFType
+ (crossmobile_ios_coregraphics_CGLayer*) createWithContext___crossmobile_ios_coregraphics_CGContext_crossmobile_ios_coregraphics_CGSize_java_util_Map:(crossmobile_ios_coregraphics_CGContext*) context :(crossmobile_ios_coregraphics_CGSize*) size :(NSDictionary*) auxiliaryInfo ;
- (crossmobile_ios_coregraphics_CGContext*) getContext__;
- (crossmobile_ios_coregraphics_CGSize*) getSize__;
- (instancetype) initWithCGLayer:(CGLayerRef) reference;
@end
