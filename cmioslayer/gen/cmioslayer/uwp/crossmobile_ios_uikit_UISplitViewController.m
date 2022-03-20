// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UISplitViewController implementation

#import "crossmobile_ios_uikit_UIBarButtonItem.h"
#import "crossmobile_ios_uikit_UISplitViewController.h"
#import "crossmobile_ios_uikit_UISplitViewControllerDelegate.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UISplitViewController$Ext

@end

@implementation UISplitViewController (cm_crossmobile_ios_uikit_UISplitViewController)

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UISplitViewController__
{
    return [self init];
}

// @property(nonatomic, readonly, getter=isCollapsed) BOOL collapsed;
- (BOOL) isCollapsed__
{
    return [self isCollapsed];
}

// @property(nonatomic, weak) id<UISplitViewControllerDelegate> delegate;
- (void) setDelegate___crossmobile_ios_uikit_UISplitViewControllerDelegate:(id<UISplitViewControllerDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// @property(nonatomic, weak) id<UISplitViewControllerDelegate> delegate;
- (id<UISplitViewControllerDelegate>) delegate__
{
    id<UISplitViewControllerDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) UISplitViewControllerDisplayMode displayMode;
- (int) displayMode__
{
    return [self displayMode];
}

// @property(nonatomic, assign) CGFloat maximumPrimaryColumnWidth;
- (void) setMaximumPrimaryColumnWidth___double:(double) maximumPrimaryColumnWidth 
{
    [self setMaximumPrimaryColumnWidth:maximumPrimaryColumnWidth];
}

// @property(nonatomic, assign) CGFloat maximumPrimaryColumnWidth;
- (double) maximumPrimaryColumnWidth__
{
    return [self maximumPrimaryColumnWidth];
}

// @property(nonatomic, assign) CGFloat minimumPrimaryColumnWidth;
- (void) setMinimumPrimaryColumnWidth___double:(double) minimumPrimaryColumnWidth 
{
    [self setMinimumPrimaryColumnWidth:minimumPrimaryColumnWidth];
}

// @property(nonatomic, assign) CGFloat minimumPrimaryColumnWidth;
- (double) minimumPrimaryColumnWidth__
{
    return [self minimumPrimaryColumnWidth];
}

// @property(nonatomic) UISplitViewControllerDisplayMode preferredDisplayMode;
- (void) setPreferredDisplayMode___int:(int) preferredDisplayMode 
{
    [self setPreferredDisplayMode:preferredDisplayMode];
}

// @property(nonatomic) UISplitViewControllerDisplayMode preferredDisplayMode;
- (int) preferredDisplayMode__
{
    return [self preferredDisplayMode];
}

// @property(nonatomic, assign) CGFloat preferredPrimaryColumnWidthFraction;
- (void) setPreferredPrimaryColumnWidthFraction___double:(double) preferredPrimaryColumnWidthFraction 
{
    [self setPreferredPrimaryColumnWidthFraction:preferredPrimaryColumnWidthFraction];
}

// @property(nonatomic, assign) CGFloat preferredPrimaryColumnWidthFraction;
- (double) preferredPrimaryColumnWidthFraction__
{
    return [self preferredPrimaryColumnWidthFraction];
}

// @property(nonatomic) BOOL presentsWithGesture;
- (void) setPresentsWithGesture___boolean:(BOOL) presentsWithGesture 
{
    [self setPresentsWithGesture:presentsWithGesture];
}

// @property(nonatomic) BOOL presentsWithGesture;
- (BOOL) presentsWithGesture__
{
    return [self presentsWithGesture];
}

// @property(nonatomic, readonly) CGFloat primaryColumnWidth;
- (double) primaryColumnWidth__
{
    return [self primaryColumnWidth];
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

// - (UIBarButtonItem *)displayModeButtonItem;
- (UIBarButtonItem*) displayModeButtonItem__
{
    UIBarButtonItem* re$ult = [self displayModeButtonItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
