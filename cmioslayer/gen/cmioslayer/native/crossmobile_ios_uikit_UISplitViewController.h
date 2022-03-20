// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UISplitViewController definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UIBarButtonItem;
@protocol crossmobile_ios_uikit_UISplitViewControllerDelegate;
@protocol java_util_List;

@interface crossmobile_ios_uikit_UISplitViewController$Ext : UISplitViewController
@end

#define crossmobile_ios_uikit_UISplitViewController UISplitViewController
@interface UISplitViewController (cm_crossmobile_ios_uikit_UISplitViewController)
- (instancetype) __init_crossmobile_ios_uikit_UISplitViewController__;
- (BOOL) isCollapsed__;
- (void) setDelegate___crossmobile_ios_uikit_UISplitViewControllerDelegate:(id<UISplitViewControllerDelegate>) delegate ;
- (id<UISplitViewControllerDelegate>) delegate__;
- (int) displayMode__;
- (void) setMaximumPrimaryColumnWidth___double:(double) maximumPrimaryColumnWidth ;
- (double) maximumPrimaryColumnWidth__;
- (void) setMinimumPrimaryColumnWidth___double:(double) minimumPrimaryColumnWidth ;
- (double) minimumPrimaryColumnWidth__;
- (void) setPreferredDisplayMode___int:(int) preferredDisplayMode ;
- (int) preferredDisplayMode__;
- (void) setPreferredPrimaryColumnWidthFraction___double:(double) preferredPrimaryColumnWidthFraction ;
- (double) preferredPrimaryColumnWidthFraction__;
- (void) setPresentsWithGesture___boolean:(BOOL) presentsWithGesture ;
- (BOOL) presentsWithGesture__;
- (double) primaryColumnWidth__;
- (void) setViewControllers___java_util_List:(NSArray*) viewControllers ;
- (NSArray*) viewControllers__;
- (UIBarButtonItem*) displayModeButtonItem__;
@end
