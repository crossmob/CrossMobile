// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIViewController definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGSize;
@class crossmobile_ios_foundation_NSBundle;
@class crossmobile_ios_foundation_NSExtensionContext;
@class crossmobile_ios_uikit_UIBarButtonItem;
@class crossmobile_ios_uikit_UIEdgeInsets;
@protocol crossmobile_ios_uikit_UILayoutSupport;
@class crossmobile_ios_uikit_UINavigationController;
@class crossmobile_ios_uikit_UINavigationItem;
@class crossmobile_ios_uikit_UISplitViewController;
@class crossmobile_ios_uikit_UIStoryboard;
@class crossmobile_ios_uikit_UIStoryboardSegue;
@class crossmobile_ios_uikit_UIStoryboardUnwindSegueSource;
@class crossmobile_ios_uikit_UITabBarController;
@class crossmobile_ios_uikit_UITabBarItem;
@class crossmobile_ios_uikit_UIView;
@class java_lang_Boolean;
@class java_lang_Object;
@protocol java_lang_Runnable;
@class java_lang_String;
@protocol java_util_List;
@protocol org_robovm_objc_block_VoidBlock1;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UIViewController$Ext : UIViewController
@end

#define crossmobile_ios_uikit_UIViewController UIViewController
@interface UIViewController (cm_crossmobile_ios_uikit_UIViewController)
+ (void) attemptRotationToDeviceOrientation__;
- (instancetype) __init_crossmobile_ios_uikit_UIViewController__;
- (instancetype) __init_crossmobile_ios_uikit_UIViewController___java_lang_String_crossmobile_ios_foundation_NSBundle:(NSString*) nibNameOrNil :(NSBundle*) nibBundleOrNil ;
- (void) setAdditionalSafeAreaInsets___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) additionalSafeAreaInsets ;
- (crossmobile_ios_uikit_UIEdgeInsets*) additionalSafeAreaInsets__;
- (void) setAutomaticallyAdjustsScrollViewInsets___boolean:(BOOL) automaticallyAdjustsScrollViewInsets ;
- (BOOL) automaticallyAdjustsScrollViewInsets__;
- (id<UILayoutSupport>) bottomLayoutGuide__;
- (UIViewController*) childViewControllerForStatusBarHidden__;
- (UIViewController*) childViewControllerForStatusBarStyle__;
- (NSArray*) childViewControllers__;
- (void) setContentSizeForViewInPopover___crossmobile_ios_coregraphics_CGSize:(crossmobile_ios_coregraphics_CGSize*) contentSizeForViewInPopover ;
- (crossmobile_ios_coregraphics_CGSize*) contentSizeForViewInPopover__;
- (void) setDefinesPresentationContext___boolean:(BOOL) definesPresentationContext ;
- (BOOL) definesPresentationContext__;
- (BOOL) disablesAutomaticKeyboardDismissal__;
- (void) setEdgesForExtendedLayout___int:(int) edgesForExtendedLayout ;
- (int) edgesForExtendedLayout__;
- (void) setEditing___boolean:(BOOL) editing ;
- (BOOL) isEditing__;
- (NSExtensionContext*) extensionContext__;
- (void) setHidesBottomBarWhenPushed___boolean:(BOOL) hidesBottomBarWhenPushed ;
- (BOOL) hidesBottomBarWhenPushed__;
- (int) interfaceOrientation__;
- (void) setModalInPopover___boolean:(BOOL) modalInPopover ;
- (BOOL) isModalInPopover__;
- (void) setModalPresentationStyle___int:(int) modalPresentationStyle ;
- (int) modalPresentationStyle__;
- (void) setModalTransitionStyle___int:(int) modalTransitionStyle ;
- (int) modalTransitionStyle__;
- (UINavigationController*) navigationController__;
- (UINavigationItem*) navigationItem__;
- (NSString*) nibName__;
- (UIViewController*) parentViewController__;
- (int) preferredStatusBarStyle__;
- (BOOL) prefersStatusBarHidden__;
- (UIViewController*) presentedViewController__;
- (UIViewController*) presentingViewController__;
- (void) setProvidesPresentationContextTransitionStyle___boolean:(BOOL) providesPresentationContextTransitionStyle ;
- (BOOL) providesPresentationContextTransitionStyle__;
- (void) setRestorationIdentifier___java_lang_String:(NSString*) restorationIdentifier ;
- (NSString*) restorationIdentifier__;
- (BOOL) shouldAutomaticallyForwardAppearanceMethods__;
- (UISplitViewController*) splitViewController__;
- (UIStoryboard*) storyboard__;
- (UITabBarController*) tabBarController__;
- (void) setTabBarItem___crossmobile_ios_uikit_UITabBarItem:(UITabBarItem*) tabBarItem ;
- (UITabBarItem*) tabBarItem__;
- (void) setTitle___java_lang_String:(NSString*) title ;
- (NSString*) title__;
- (void) setToolbarItems___java_util_List:(NSArray*) toolbarItems ;
- (NSArray*) toolbarItems__;
- (id<UILayoutSupport>) topLayoutGuide__;
- (void) setView___crossmobile_ios_uikit_UIView:(UIView*) view ;
- (UIView*) view__;
- (UIView*) viewIfLoaded__;
- (BOOL) isViewLoaded__;
- (void) setWantsFullScreenLayout___boolean:(BOOL) wantsFullScreenLayout ;
- (BOOL) wantsFullScreenLayout__;
- (void) addChildViewController___crossmobile_ios_uikit_UIViewController:(UIViewController*) childController ;
- (NSArray*) allowedChildViewControllersForUnwindingFromSource___crossmobile_ios_uikit_UIStoryboardUnwindSegueSource:(UIStoryboardUnwindSegueSource*) source ;
- (void) beginAppearanceTransition___boolean_boolean:(BOOL) isAppearing :(BOOL) animated ;
- (UIViewController*) childViewControllerContainingSegueSource___crossmobile_ios_uikit_UIStoryboardUnwindSegueSource:(UIStoryboardUnwindSegueSource*) source ;
- (void) didReceiveMemoryWarning__;
- (void) didRotateFromInterfaceOrientation___int:(int) fromInterfaceOrientation ;
- (void) dismissModalViewControllerAnimated___boolean:(BOOL) animated ;
- (void) dismissViewControllerAnimated___boolean_java_lang_Runnable:(BOOL) flag :(id<java_lang_Runnable>) completion ;
- (UIBarButtonItem*) editButtonItem__;
- (void) endAppearanceTransition__;
- (void) loadView__;
- (void) loadViewIfNeeded__;
- (void) performSegueWithIdentifier___java_lang_String_java_lang_Object:(NSString*) identifier :(id) sender ;
- (int) preferredInterfaceOrientationForPresentation__;
- (void) prepareForSegue___crossmobile_ios_uikit_UIStoryboardSegue_java_lang_Object:(UIStoryboardSegue*) segue :(id) sender ;
- (void) presentModalViewController___crossmobile_ios_uikit_UIViewController_boolean:(UIViewController*) modalViewController :(BOOL) animated ;
- (void) presentViewController___crossmobile_ios_uikit_UIViewController_boolean_java_lang_Runnable:(UIViewController*) viewControllerToPresent :(BOOL) flag :(id<java_lang_Runnable>) completion ;
- (void) removeFromParentViewController__;
- (UIView*) rotatingFooterView__;
- (UIView*) rotatingHeaderView__;
- (void) setEditing___boolean_boolean:(BOOL) editing :(BOOL) animated ;
- (void) setNeedsStatusBarAppearanceUpdate__;
- (void) setToolbarItems___java_util_List_boolean:(NSArray*) toolbarItems :(BOOL) animated ;
- (BOOL) shouldAutorotate__;
- (BOOL) shouldAutorotateToInterfaceOrientation___int:(int) toInterfaceOrientation ;
- (BOOL) shouldPerformSegueWithIdentifier___java_lang_String_java_lang_Object:(NSString*) identifier :(id) sender ;
- (void) showDetailViewController___crossmobile_ios_uikit_UIViewController_java_lang_Object:(UIViewController*) vc :(id) sender ;
- (void) showViewController___crossmobile_ios_uikit_UIViewController_java_lang_Object:(UIViewController*) vc :(id) sender ;
- (int) supportedInterfaceOrientations__;
- (void) transitionFromViewController___crossmobile_ios_uikit_UIViewController_crossmobile_ios_uikit_UIViewController_double_int_java_lang_Runnable_org_robovm_objc_block_VoidBlock1:(UIViewController*) fromViewController :(UIViewController*) toViewController :(double) duration :(int) options :(id<java_lang_Runnable>) animations :(id<org_robovm_objc_block_VoidBlock1>) completion ;
- (void) viewDidAppear___boolean:(BOOL) animated ;
- (void) viewDidDisappear___boolean:(BOOL) animated ;
- (void) viewDidLayoutSubviews__;
- (void) viewDidLoad__;
- (void) viewDidUnload__;
- (void) viewSafeAreaInsetsDidChange__;
- (void) viewWillAppear___boolean:(BOOL) animated ;
- (void) viewWillDisappear___boolean:(BOOL) animated ;
- (void) viewWillLayoutSubviews__;
- (void) willAnimateRotationToInterfaceOrientation___int_double:(int) toInterfaceOrientation :(double) duration ;
- (void) willRotateToInterfaceOrientation___int_double:(int) toInterfaceOrientation :(double) duration ;
@end
