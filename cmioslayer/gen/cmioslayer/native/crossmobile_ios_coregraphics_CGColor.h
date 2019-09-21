// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile_ios_coregraphics_CGColor definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "crossmobile_ios_foundation_CFType.h"
@class java_lang_Object;

@interface crossmobile_ios_coregraphics_CGColor : crossmobile_ios_foundation_CFType
- (double) getAlpha__;
- (XMLVMArray*) getComponents__;
- (int) getNumberOfComponents__;
- (instancetype) initWithCGColor:(CGColorRef) reference;
@end
