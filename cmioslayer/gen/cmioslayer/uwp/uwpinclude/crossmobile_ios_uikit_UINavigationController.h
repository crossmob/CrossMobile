// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UINavigationController definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UINavigationBar;
@protocol crossmobile_ios_uikit_UINavigationControllerDelegate;
@class crossmobile_ios_uikit_UIToolbar;
@class crossmobile_ios_uikit_UIViewController;
@protocol java_util_List;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UINavigationController$Ext : UINavigationController
@end

#define crossmobile_ios_uikit_UINavigationController UINavigationController
@interface UINavigationController (cm_crossmobile_ios_uikit_UINavigationController)
- (instancetype) __init_crossmobile_ios_uikit_UINavigationController__;
- (instancetype) __init_crossmobile_ios_uikit_UINavigationController___crossmobile_ios_uikit_UIViewController:(UIViewController*) rootViewController ;
- (void) setDelegate___crossmobile_ios_uikit_UINavigationControllerDelegate:(id<UINavigationControllerDelegate>) delegate ;
- (id<UINavigationControllerDelegate>) delegate__;
- (UINavigationBar*) navigationBar__;
- (void) setNavigationBarHidden___boolean:(BOOL) navigationBarHidden ;
- (BOOL) isNavigationBarHidden__;
- (UIToolbar*) toolbar__;
- (void) setToolbarHidden___boolean:(BOOL) toolbarHidden ;
- (BOOL) isToolbarHidden__;
- (UIViewController*) topViewController__;
- (void) setViewControllers___java_util_List:(NSArray*) viewControllers ;
- (NSArray*) viewControllers__;
- (UIViewController*) visibleViewController__;
- (NSArray*) popToRootViewControllerAnimated___boolean:(BOOL) animated ;
- (NSArray*) popToViewController___crossmobile_ios_uikit_UIViewController_boolean:(UIViewController*) viewController :(BOOL) animated ;
- (UIViewController*) popViewControllerAnimated___boolean:(BOOL) animated ;
- (void) pushViewController___crossmobile_ios_uikit_UIViewController_boolean:(UIViewController*) viewController :(BOOL) animated ;
- (void) setNavigationBarHidden___boolean_boolean:(BOOL) hidden :(BOOL) animated ;
- (void) setToolbarHidden___boolean_boolean:(BOOL) hidden :(BOOL) animated ;
- (void) setViewControllers___java_util_List_boolean:(NSArray*) viewControllers :(BOOL) animated ;
@end
