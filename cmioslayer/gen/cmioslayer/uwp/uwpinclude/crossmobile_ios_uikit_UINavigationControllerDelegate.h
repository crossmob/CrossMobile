// (c) 2020 under LGPL by CrossMobile plugin tools

// crossmobile_ios_uikit_UINavigationControllerDelegate definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UINavigationController;
@class crossmobile_ios_uikit_UIViewController;

CM_EXPORT_CLASS
@protocol crossmobile_ios_uikit_UINavigationControllerDelegate
- (void) didShowViewController___crossmobile_ios_uikit_UINavigationController_crossmobile_ios_uikit_UIViewController_boolean:(UINavigationController*) navigationController :(UIViewController*) viewController :(BOOL) animated ;
- (void) willShowViewController___crossmobile_ios_uikit_UINavigationController_crossmobile_ios_uikit_UIViewController_boolean:(UINavigationController*) navigationController :(UIViewController*) viewController :(BOOL) animated ;
@end
