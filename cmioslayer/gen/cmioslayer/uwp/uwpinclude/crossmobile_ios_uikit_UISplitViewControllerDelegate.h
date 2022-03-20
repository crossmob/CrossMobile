// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UISplitViewControllerDelegate definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UIBarButtonItem;
@class crossmobile_ios_uikit_UIPopoverController;
@class crossmobile_ios_uikit_UISplitViewController;
@class crossmobile_ios_uikit_UIViewController;
@class java_lang_Object;

CM_EXPORT_CLASS
@protocol crossmobile_ios_uikit_UISplitViewControllerDelegate
- (BOOL) collapseSecondaryViewController___crossmobile_ios_uikit_UISplitViewController_crossmobile_ios_uikit_UIViewController_crossmobile_ios_uikit_UIViewController:(UISplitViewController*) splitViewController :(UIViewController*) secondaryViewController :(UIViewController*) primaryViewController ;
- (void) popoverController___crossmobile_ios_uikit_UISplitViewController_crossmobile_ios_uikit_UIPopoverController_crossmobile_ios_uikit_UIViewController:(UISplitViewController*) svc :(UIPopoverController*) pc :(UIViewController*) aViewController ;
- (int) preferredInterfaceOrientationForPresentation___crossmobile_ios_uikit_UISplitViewController:(UISplitViewController*) splitViewController ;
- (UIViewController*) primaryViewControllerForCollapsingSplitViewController___crossmobile_ios_uikit_UISplitViewController:(UISplitViewController*) splitViewController ;
- (UIViewController*) primaryViewControllerForExpandingSplitViewController___crossmobile_ios_uikit_UISplitViewController:(UISplitViewController*) splitViewController ;
- (UIViewController*) separateSecondaryViewControllerFromPrimaryViewController___crossmobile_ios_uikit_UISplitViewController_crossmobile_ios_uikit_UIViewController:(UISplitViewController*) splitViewController :(UIViewController*) primaryViewController ;
- (BOOL) shouldHideViewController___crossmobile_ios_uikit_UISplitViewController_crossmobile_ios_uikit_UIViewController_int:(UISplitViewController*) svc :(UIViewController*) vc :(int) orientation ;
- (BOOL) showDetailViewController___crossmobile_ios_uikit_UISplitViewController_crossmobile_ios_uikit_UIViewController_java_lang_Object:(UISplitViewController*) splitViewController :(UIViewController*) vc :(id) sender ;
- (BOOL) showViewController___crossmobile_ios_uikit_UISplitViewController_crossmobile_ios_uikit_UIViewController_java_lang_Object:(UISplitViewController*) splitViewController :(UIViewController*) vc :(id) sender ;
- (int) supportedInterfaceOrientations___crossmobile_ios_uikit_UISplitViewController:(UISplitViewController*) splitViewController ;
- (int) targetDisplayModeForActionInSplitViewController___crossmobile_ios_uikit_UISplitViewController:(UISplitViewController*) svc ;
- (void) willChangeToDisplayMode___crossmobile_ios_uikit_UISplitViewController_int:(UISplitViewController*) svc :(int) displayMode ;
- (void) willHideViewController___crossmobile_ios_uikit_UISplitViewController_crossmobile_ios_uikit_UIViewController_crossmobile_ios_uikit_UIBarButtonItem_crossmobile_ios_uikit_UIPopoverController:(UISplitViewController*) svc :(UIViewController*) aViewController :(UIBarButtonItem*) barButtonItem :(UIPopoverController*) pc ;
- (void) willShowViewController___crossmobile_ios_uikit_UISplitViewController_crossmobile_ios_uikit_UIViewController_crossmobile_ios_uikit_UIBarButtonItem:(UISplitViewController*) svc :(UIViewController*) aViewController :(UIBarButtonItem*) barButtonItem ;
@end
