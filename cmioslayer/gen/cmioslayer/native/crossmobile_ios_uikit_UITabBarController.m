// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UITabBarController implementation

#import "crossmobile_ios_uikit_UINavigationController.h"
#import "crossmobile_ios_uikit_UITabBar.h"
#import "crossmobile_ios_uikit_UITabBarController.h"
#import "crossmobile_ios_uikit_UITabBarControllerDelegate.h"
#import "crossmobile_ios_uikit_UIViewController.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UITabBarController$Ext

@end

@implementation UITabBarController (cm_crossmobile_ios_uikit_UITabBarController)

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UITabBarController__
{
    return [self init];
}

// @property(nonatomic, copy) NSArray<__kindof UIViewController *> *customizableViewControllers;
- (void) setCustomizableViewControllers___java_util_List:(NSArray*) customizableViewControllers 
{
    [self setCustomizableViewControllers:(customizableViewControllers == JAVA_NULL ? nil : customizableViewControllers)];
}

// @property(nonatomic, copy) NSArray<__kindof UIViewController *> *customizableViewControllers;
- (NSArray*) customizableViewControllers__
{
    NSArray* re$ult = [self customizableViewControllers];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, weak) id<UITabBarControllerDelegate> delegate;
- (void) setDelegate___crossmobile_ios_uikit_UITabBarControllerDelegate:(id<UITabBarControllerDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// @property(nonatomic, weak) id<UITabBarControllerDelegate> delegate;
- (id<UITabBarControllerDelegate>) delegate__
{
    id<UITabBarControllerDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) UINavigationController *moreNavigationController;
- (UINavigationController*) moreNavigationController__
{
    UINavigationController* re$ult = [self moreNavigationController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) NSUInteger selectedIndex;
- (void) setSelectedIndex___int:(int) selectedIndex 
{
    [self setSelectedIndex:selectedIndex];
}

// @property(nonatomic) NSUInteger selectedIndex;
- (int) selectedIndex__
{
    return [self selectedIndex];
}

// @property(nonatomic, assign) __kindof UIViewController *selectedViewController;
- (void) setSelectedViewController___crossmobile_ios_uikit_UIViewController:(UIViewController*) selectedViewController 
{
    objc_setAssociatedObject(self, @selector(setSelectedViewController:), selectedViewController, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setSelectedViewController:(selectedViewController == JAVA_NULL ? nil : selectedViewController)];
}

// @property(nonatomic, assign) __kindof UIViewController *selectedViewController;
- (UIViewController*) selectedViewController__
{
    UIViewController* re$ult = [self selectedViewController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) UITabBar *tabBar;
- (UITabBar*) tabBar__
{
    UITabBar* re$ult = [self tabBar];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, copy) NSArray<__kindof UIViewController *> *viewControllers;
- (void) setViewControllers___java_util_List:(NSArray*) viewControllers 
{
    [self setViewControllers:(viewControllers == JAVA_NULL ? nil : viewControllers)];
}

// @property(nonatomic, copy) NSArray<__kindof UIViewController *> *viewControllers;
- (NSArray*) viewControllers__
{
    NSArray* re$ult = [self viewControllers];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)setViewControllers:(NSArray<__kindof UIViewController *> *)viewControllers animated:(BOOL)animated;
- (void) setViewControllers___java_util_List_boolean:(NSArray*) viewControllers :(BOOL) animated 
{
    [self setViewControllers:(viewControllers == JAVA_NULL ? nil : viewControllers) animated:animated];
}

@end
