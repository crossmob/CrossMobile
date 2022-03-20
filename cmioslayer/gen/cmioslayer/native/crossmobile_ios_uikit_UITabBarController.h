// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UITabBarController definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UINavigationController;
@class crossmobile_ios_uikit_UITabBar;
@protocol crossmobile_ios_uikit_UITabBarControllerDelegate;
@class crossmobile_ios_uikit_UIViewController;
@protocol java_util_List;

@interface crossmobile_ios_uikit_UITabBarController$Ext : UITabBarController
@end

#define crossmobile_ios_uikit_UITabBarController UITabBarController
@interface UITabBarController (cm_crossmobile_ios_uikit_UITabBarController)
- (instancetype) __init_crossmobile_ios_uikit_UITabBarController__;
- (void) setCustomizableViewControllers___java_util_List:(NSArray*) customizableViewControllers ;
- (NSArray*) customizableViewControllers__;
- (void) setDelegate___crossmobile_ios_uikit_UITabBarControllerDelegate:(id<UITabBarControllerDelegate>) delegate ;
- (id<UITabBarControllerDelegate>) delegate__;
- (UINavigationController*) moreNavigationController__;
- (void) setSelectedIndex___int:(int) selectedIndex ;
- (int) selectedIndex__;
- (void) setSelectedViewController___crossmobile_ios_uikit_UIViewController:(UIViewController*) selectedViewController ;
- (UIViewController*) selectedViewController__;
- (UITabBar*) tabBar__;
- (void) setViewControllers___java_util_List:(NSArray*) viewControllers ;
- (NSArray*) viewControllers__;
- (void) setViewControllers___java_util_List_boolean:(NSArray*) viewControllers :(BOOL) animated ;
@end
