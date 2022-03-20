// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UITabBarControllerDelegate definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UITabBarController;
@class crossmobile_ios_uikit_UIViewController;
@protocol java_util_List;

@protocol crossmobile_ios_uikit_UITabBarControllerDelegate
- (void) didEndCustomizingViewControllers___crossmobile_ios_uikit_UITabBarController_java_util_List_boolean:(UITabBarController*) tabBarController :(NSArray*) viewControllers :(BOOL) changed ;
- (void) didSelectViewController___crossmobile_ios_uikit_UITabBarController_crossmobile_ios_uikit_UIViewController:(UITabBarController*) tabBarController :(UIViewController*) viewController ;
- (BOOL) shouldSelectViewController___crossmobile_ios_uikit_UITabBarController_crossmobile_ios_uikit_UIViewController:(UITabBarController*) tabBarController :(UIViewController*) viewController ;
- (void) willBeginCustomizingViewControllers___crossmobile_ios_uikit_UITabBarController_java_util_List:(UITabBarController*) tabBarController :(NSArray*) viewControllers ;
- (void) willEndCustomizingViewControllers___crossmobile_ios_uikit_UITabBarController_java_util_List_boolean:(UITabBarController*) tabBarController :(NSArray*) viewControllers :(BOOL) changed ;
@end
