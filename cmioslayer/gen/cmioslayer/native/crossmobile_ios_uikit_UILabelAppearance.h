// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UILabelAppearance definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "crossmobile_ios_foundation_NSObject.h"
@class crossmobile_ios_uikit_UIColor;
@class crossmobile_ios_uikit_UIFont;

@interface crossmobile_ios_uikit_UILabelAppearance : crossmobile_ios_foundation_NSObject {
@public id $reference;
}

- (void) setBackgroundColor___crossmobile_ios_uikit_UIColor:(UIColor*) backgroundColor ;
- (void) setFont___crossmobile_ios_uikit_UIFont:(UIFont*) font ;
- (void) setTextColor___crossmobile_ios_uikit_UIColor:(UIColor*) textColor ;
- (instancetype) initWithUILabelAppearance:(id) reference;
@end
