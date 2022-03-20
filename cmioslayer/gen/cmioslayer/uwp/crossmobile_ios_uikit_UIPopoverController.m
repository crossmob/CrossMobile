// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIPopoverController implementation

#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_coregraphics_CGSize.h"
#import "crossmobile_ios_uikit_UIBarButtonItem.h"
#import "crossmobile_ios_uikit_UIPopoverController.h"
#import "crossmobile_ios_uikit_UIPopoverControllerDelegate.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "crossmobile_ios_uikit_UIViewController.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UIPopoverController$Ext

@end

@implementation UIPopoverController (cm_crossmobile_ios_uikit_UIPopoverController)

// - (instancetype)initWithContentViewController:(UIViewController *)viewController;
- (instancetype) __init_crossmobile_ios_uikit_UIPopoverController___crossmobile_ios_uikit_UIViewController:(UIViewController*) viewController 
{
    return [self initWithContentViewController:(viewController == JAVA_NULL ? nil : viewController)];
}

// @property(nonatomic, strong) UIViewController *contentViewController;
- (void) setContentViewController___crossmobile_ios_uikit_UIViewController:(UIViewController*) contentViewController 
{
    [self setContentViewController:(contentViewController == JAVA_NULL ? nil : contentViewController)];
}

// @property(nonatomic, strong) UIViewController *contentViewController;
- (UIViewController*) contentViewController__
{
    UIViewController* re$ult = [self contentViewController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, weak) id<UIPopoverControllerDelegate> delegate;
- (void) setDelegate___crossmobile_ios_uikit_UIPopoverControllerDelegate:(id<UIPopoverControllerDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// @property(nonatomic, weak) id<UIPopoverControllerDelegate> delegate;
- (id<UIPopoverControllerDelegate>) delegate__
{
    id<UIPopoverControllerDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, copy) NSArray<__kindof UIView *> *passthroughViews;
- (void) setPassthroughViews___java_util_List:(NSArray*) passthroughViews 
{
    [self setPassthroughViews:(passthroughViews == JAVA_NULL ? nil : passthroughViews)];
}

// @property(nonatomic, copy) NSArray<__kindof UIView *> *passthroughViews;
- (NSArray*) passthroughViews__
{
    NSArray* re$ult = [self passthroughViews];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) UIPopoverArrowDirection popoverArrowDirection;
- (JAVA_LONG) popoverArrowDirection__
{
    return [self popoverArrowDirection];
}

// @property(nonatomic) CGSize popoverContentSize;
- (void) setPopoverContentSize___crossmobile_ios_coregraphics_CGSize:(crossmobile_ios_coregraphics_CGSize*) popoverContentSize 
{
    [self setPopoverContentSize:[popoverContentSize getCGSize]];
}

// @property(nonatomic) CGSize popoverContentSize;
- (crossmobile_ios_coregraphics_CGSize*) popoverContentSize__
{
    return [[crossmobile_ios_coregraphics_CGSize alloc] initWithCGSize:[self popoverContentSize]];
}

// @property(nonatomic, readonly, getter=isPopoverVisible) BOOL popoverVisible;
- (BOOL) isPopoverVisible__
{
    return [self isPopoverVisible];
}

// - (void)dismissPopoverAnimated:(BOOL)animated;
- (void) dismissPopoverAnimated___boolean:(BOOL) animated 
{
    [self dismissPopoverAnimated:animated];
}

// - (void)presentPopoverFromBarButtonItem:(UIBarButtonItem *)item permittedArrowDirections:(UIPopoverArrowDirection)arrowDirections animated:(BOOL)animated;
- (void) presentPopoverFromBarButtonItem___crossmobile_ios_uikit_UIBarButtonItem_long_boolean:(UIBarButtonItem*) item :(JAVA_LONG) arrowDirections :(BOOL) animated 
{
    [self presentPopoverFromBarButtonItem:(item == JAVA_NULL ? nil : item) permittedArrowDirections:arrowDirections animated:animated];
}

// - (void)presentPopoverFromRect:(CGRect)rect inView:(UIView *)view permittedArrowDirections:(UIPopoverArrowDirection)arrowDirections animated:(BOOL)animated;
- (void) presentPopoverFromRect___crossmobile_ios_coregraphics_CGRect_crossmobile_ios_uikit_UIView_long_boolean:(crossmobile_ios_coregraphics_CGRect*) rect :(UIView*) view :(JAVA_LONG) arrowDirections :(BOOL) animated 
{
    [self presentPopoverFromRect:[rect getCGRect] inView:(view == JAVA_NULL ? nil : view) permittedArrowDirections:arrowDirections animated:animated];
}

// - (void)setContentViewController:(UIViewController *)viewController animated:(BOOL)animated;
- (void) setContentViewController___crossmobile_ios_uikit_UIViewController_boolean:(UIViewController*) viewController :(BOOL) animated 
{
    [self setContentViewController:(viewController == JAVA_NULL ? nil : viewController) animated:animated];
}

// - (void)setPopoverContentSize:(CGSize)size animated:(BOOL)animated;
- (void) setPopoverContentSize___crossmobile_ios_coregraphics_CGSize_boolean:(crossmobile_ios_coregraphics_CGSize*) size :(BOOL) animated 
{
    [self setPopoverContentSize:[size getCGSize] animated:animated];
}

@end
