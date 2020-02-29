// (c) 2020 under LGPL by CrossMobile plugin tools

// crossmobile_ios_uikit_UILabelAppearance definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "crossmobile_ios_uikit_UIViewAppearance.h"
@class crossmobile_ios_uikit_UIColor;
@class crossmobile_ios_uikit_UIFont;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UILabelAppearance : crossmobile_ios_uikit_UIViewAppearance
- (void) setFont___crossmobile_ios_uikit_UIFont:(UIFont*) font ;
- (void) setTextColor___crossmobile_ios_uikit_UIColor:(UIColor*) textColor ;
- (instancetype) initWithUILabelAppearance:(id) reference;
@end
