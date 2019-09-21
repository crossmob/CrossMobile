// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile_ios_uikit_UIViewAppearance definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "crossmobile_ios_foundation_NSObject.h"
@class crossmobile_ios_uikit_UIColor;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UIViewAppearance : crossmobile_ios_foundation_NSObject {
@public id $reference;
}

- (void) setBackgroundColor___crossmobile_ios_uikit_UIColor:(UIColor*) backgroundColor ;
- (instancetype) initWithUIViewAppearance:(id) reference;
@end
