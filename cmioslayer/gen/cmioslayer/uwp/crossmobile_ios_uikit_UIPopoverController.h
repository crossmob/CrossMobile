// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIPopoverController definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGRect;
@class crossmobile_ios_coregraphics_CGSize;
@class crossmobile_ios_uikit_UIBarButtonItem;
@protocol crossmobile_ios_uikit_UIPopoverControllerDelegate;
@class crossmobile_ios_uikit_UIView;
@class crossmobile_ios_uikit_UIViewController;
@protocol java_util_List;

@interface crossmobile_ios_uikit_UIPopoverController$Ext : UIPopoverController
@end

#define crossmobile_ios_uikit_UIPopoverController UIPopoverController
@interface UIPopoverController (cm_crossmobile_ios_uikit_UIPopoverController)
- (instancetype) __init_crossmobile_ios_uikit_UIPopoverController___crossmobile_ios_uikit_UIViewController:(UIViewController*) viewController ;
- (void) setContentViewController___crossmobile_ios_uikit_UIViewController:(UIViewController*) contentViewController ;
- (UIViewController*) contentViewController__;
- (void) setDelegate___crossmobile_ios_uikit_UIPopoverControllerDelegate:(id<UIPopoverControllerDelegate>) delegate ;
- (id<UIPopoverControllerDelegate>) delegate__;
- (void) setPassthroughViews___java_util_List:(NSArray*) passthroughViews ;
- (NSArray*) passthroughViews__;
- (JAVA_LONG) popoverArrowDirection__;
- (void) setPopoverContentSize___crossmobile_ios_coregraphics_CGSize:(crossmobile_ios_coregraphics_CGSize*) popoverContentSize ;
- (crossmobile_ios_coregraphics_CGSize*) popoverContentSize__;
- (BOOL) isPopoverVisible__;
- (void) dismissPopoverAnimated___boolean:(BOOL) animated ;
- (void) presentPopoverFromBarButtonItem___crossmobile_ios_uikit_UIBarButtonItem_long_boolean:(UIBarButtonItem*) item :(JAVA_LONG) arrowDirections :(BOOL) animated ;
- (void) presentPopoverFromRect___crossmobile_ios_coregraphics_CGRect_crossmobile_ios_uikit_UIView_long_boolean:(crossmobile_ios_coregraphics_CGRect*) rect :(UIView*) view :(JAVA_LONG) arrowDirections :(BOOL) animated ;
- (void) setContentViewController___crossmobile_ios_uikit_UIViewController_boolean:(UIViewController*) viewController :(BOOL) animated ;
- (void) setPopoverContentSize___crossmobile_ios_coregraphics_CGSize_boolean:(crossmobile_ios_coregraphics_CGSize*) size :(BOOL) animated ;
@end
