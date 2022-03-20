// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UINavigationController implementation

#import "crossmobile_ios_uikit_UINavigationBar.h"
#import "crossmobile_ios_uikit_UINavigationController.h"
#import "crossmobile_ios_uikit_UINavigationControllerDelegate.h"
#import "crossmobile_ios_uikit_UIToolbar.h"
#import "crossmobile_ios_uikit_UIViewController.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UINavigationController$Ext

@end

@implementation UINavigationController (cm_crossmobile_ios_uikit_UINavigationController)

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UINavigationController__
{
    return [self init];
}

// - (instancetype)initWithRootViewController:(UIViewController *)rootViewController;
- (instancetype) __init_crossmobile_ios_uikit_UINavigationController___crossmobile_ios_uikit_UIViewController:(UIViewController*) rootViewController 
{
    return [self initWithRootViewController:(rootViewController == JAVA_NULL ? nil : rootViewController)];
}

// @property(nonatomic, weak) id<UINavigationControllerDelegate> delegate;
- (void) setDelegate___crossmobile_ios_uikit_UINavigationControllerDelegate:(id<UINavigationControllerDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// @property(nonatomic, weak) id<UINavigationControllerDelegate> delegate;
- (id<UINavigationControllerDelegate>) delegate__
{
    id<UINavigationControllerDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) UINavigationBar *navigationBar;
- (UINavigationBar*) navigationBar__
{
    UINavigationBar* re$ult = [self navigationBar];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, getter=isNavigationBarHidden) BOOL navigationBarHidden;
- (void) setNavigationBarHidden___boolean:(BOOL) navigationBarHidden 
{
    [self setNavigationBarHidden:navigationBarHidden];
}

// @property(nonatomic, getter=isNavigationBarHidden) BOOL navigationBarHidden;
- (BOOL) isNavigationBarHidden__
{
    return [self isNavigationBarHidden];
}

// @property(nonatomic, readonly) UIToolbar *toolbar;
- (UIToolbar*) toolbar__
{
    UIToolbar* re$ult = [self toolbar];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, getter=isToolbarHidden) BOOL toolbarHidden;
- (void) setToolbarHidden___boolean:(BOOL) toolbarHidden 
{
    [self setToolbarHidden:toolbarHidden];
}

// @property(nonatomic, getter=isToolbarHidden) BOOL toolbarHidden;
- (BOOL) isToolbarHidden__
{
    return [self isToolbarHidden];
}

// @property(nonatomic, readonly, strong) UIViewController *topViewController;
- (UIViewController*) topViewController__
{
    UIViewController* re$ult = [self topViewController];
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

// @property(nonatomic, readonly, strong) UIViewController *visibleViewController;
- (UIViewController*) visibleViewController__
{
    UIViewController* re$ult = [self visibleViewController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSArray<__kindof UIViewController *> *)popToRootViewControllerAnimated:(BOOL)animated;
- (NSArray*) popToRootViewControllerAnimated___boolean:(BOOL) animated 
{
    NSArray* re$ult = [self popToRootViewControllerAnimated:animated];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSArray<__kindof UIViewController *> *)popToViewController:(UIViewController *)viewController animated:(BOOL)animated;
- (NSArray*) popToViewController___crossmobile_ios_uikit_UIViewController_boolean:(UIViewController*) viewController :(BOOL) animated 
{
    NSArray* re$ult = [self popToViewController:(viewController == JAVA_NULL ? nil : viewController) animated:animated];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (UIViewController *)popViewControllerAnimated:(BOOL)animated;
- (UIViewController*) popViewControllerAnimated___boolean:(BOOL) animated 
{
    UIViewController* re$ult = [self popViewControllerAnimated:animated];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)pushViewController:(UIViewController *)viewController animated:(BOOL)animated;
- (void) pushViewController___crossmobile_ios_uikit_UIViewController_boolean:(UIViewController*) viewController :(BOOL) animated 
{
    [self pushViewController:(viewController == JAVA_NULL ? nil : viewController) animated:animated];
}

// - (void)setNavigationBarHidden:(BOOL)hidden animated:(BOOL)animated;
- (void) setNavigationBarHidden___boolean_boolean:(BOOL) hidden :(BOOL) animated 
{
    [self setNavigationBarHidden:hidden animated:animated];
}

// - (void)setToolbarHidden:(BOOL)hidden animated:(BOOL)animated;
- (void) setToolbarHidden___boolean_boolean:(BOOL) hidden :(BOOL) animated 
{
    [self setToolbarHidden:hidden animated:animated];
}

// - (void)setViewControllers:(NSArray<UIViewController *> *)viewControllers animated:(BOOL)animated;
- (void) setViewControllers___java_util_List_boolean:(NSArray*) viewControllers :(BOOL) animated 
{
    [self setViewControllers:(viewControllers == JAVA_NULL ? nil : viewControllers) animated:animated];
}

@end
