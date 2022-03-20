// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIViewController implementation

#import "crossmobile_ios_coregraphics_CGSize.h"
#import "crossmobile_ios_foundation_NSBundle.h"
#import "crossmobile_ios_foundation_NSExtensionContext.h"
#import "crossmobile_ios_uikit_UIBarButtonItem.h"
#import "crossmobile_ios_uikit_UIEdgeInsets.h"
#import "crossmobile_ios_uikit_UILayoutSupport.h"
#import "crossmobile_ios_uikit_UINavigationController.h"
#import "crossmobile_ios_uikit_UINavigationItem.h"
#import "crossmobile_ios_uikit_UISplitViewController.h"
#import "crossmobile_ios_uikit_UIStoryboard.h"
#import "crossmobile_ios_uikit_UIStoryboardSegue.h"
#import "crossmobile_ios_uikit_UIStoryboardUnwindSegueSource.h"
#import "crossmobile_ios_uikit_UITabBarController.h"
#import "crossmobile_ios_uikit_UITabBarItem.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "crossmobile_ios_uikit_UIViewController.h"
#import "java_lang_Boolean.h"
#import "java_lang_Object.h"
#import "java_lang_Runnable.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "org_robovm_objc_block_VoidBlock1.h"

@implementation crossmobile_ios_uikit_UIViewController$Ext

@end

@implementation UIViewController (cm_crossmobile_ios_uikit_UIViewController)

// + (void)attemptRotationToDeviceOrientation;
+ (void) attemptRotationToDeviceOrientation__
{
    [UIViewController attemptRotationToDeviceOrientation];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UIViewController__
{
    return [self init];
}

// - (instancetype)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil;
- (instancetype) __init_crossmobile_ios_uikit_UIViewController___java_lang_String_crossmobile_ios_foundation_NSBundle:(NSString*) nibNameOrNil :(NSBundle*) nibBundleOrNil 
{
    return [self initWithNibName:(nibNameOrNil == JAVA_NULL ? nil : nibNameOrNil) bundle:(nibBundleOrNil == JAVA_NULL ? nil : nibBundleOrNil)];
}

// @property(nonatomic) UIEdgeInsets additionalSafeAreaInsets;
- (void) setAdditionalSafeAreaInsets___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) additionalSafeAreaInsets 
{
    [self setAdditionalSafeAreaInsets:[additionalSafeAreaInsets getUIEdgeInsets]];
}

// @property(nonatomic) UIEdgeInsets additionalSafeAreaInsets;
- (crossmobile_ios_uikit_UIEdgeInsets*) additionalSafeAreaInsets__
{
    return [[crossmobile_ios_uikit_UIEdgeInsets alloc] initWithUIEdgeInsets:[self additionalSafeAreaInsets]];
}

// @property(nonatomic, assign) BOOL automaticallyAdjustsScrollViewInsets;
- (void) setAutomaticallyAdjustsScrollViewInsets___boolean:(BOOL) automaticallyAdjustsScrollViewInsets 
{
    [self setAutomaticallyAdjustsScrollViewInsets:automaticallyAdjustsScrollViewInsets];
}

// @property(nonatomic, assign) BOOL automaticallyAdjustsScrollViewInsets;
- (BOOL) automaticallyAdjustsScrollViewInsets__
{
    return [self automaticallyAdjustsScrollViewInsets];
}

// @property(nonatomic, readonly, strong) id<UILayoutSupport> bottomLayoutGuide;
- (id<UILayoutSupport>) bottomLayoutGuide__
{
    id<UILayoutSupport> re$ult = [self bottomLayoutGuide];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) UIViewController *childViewControllerForStatusBarHidden;
- (UIViewController*) childViewControllerForStatusBarHidden__
{
    UIViewController* re$ult = [self childViewControllerForStatusBarHidden];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) UIViewController *childViewControllerForStatusBarStyle;
- (UIViewController*) childViewControllerForStatusBarStyle__
{
    UIViewController* re$ult = [self childViewControllerForStatusBarStyle];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) NSArray<__kindof UIViewController *> *childViewControllers;
- (NSArray*) childViewControllers__
{
    NSArray* re$ult = [self childViewControllers];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readwrite) CGSize contentSizeForViewInPopover;
- (void) setContentSizeForViewInPopover___crossmobile_ios_coregraphics_CGSize:(crossmobile_ios_coregraphics_CGSize*) contentSizeForViewInPopover 
{
    [self setContentSizeForViewInPopover:[contentSizeForViewInPopover getCGSize]];
}

// @property(nonatomic, readwrite) CGSize contentSizeForViewInPopover;
- (crossmobile_ios_coregraphics_CGSize*) contentSizeForViewInPopover__
{
    return [[crossmobile_ios_coregraphics_CGSize alloc] initWithCGSize:[self contentSizeForViewInPopover]];
}

// @property(nonatomic, assign) BOOL definesPresentationContext;
- (void) setDefinesPresentationContext___boolean:(BOOL) definesPresentationContext 
{
    [self setDefinesPresentationContext:definesPresentationContext];
}

// @property(nonatomic, assign) BOOL definesPresentationContext;
- (BOOL) definesPresentationContext__
{
    return [self definesPresentationContext];
}

// @property(nonatomic, readonly) BOOL disablesAutomaticKeyboardDismissal;
- (BOOL) disablesAutomaticKeyboardDismissal__
{
    return [self disablesAutomaticKeyboardDismissal];
}

// @property(nonatomic, assign) UIRectEdge edgesForExtendedLayout;
- (void) setEdgesForExtendedLayout___int:(int) edgesForExtendedLayout 
{
    [self setEdgesForExtendedLayout:edgesForExtendedLayout];
}

// @property(nonatomic, assign) UIRectEdge edgesForExtendedLayout;
- (int) edgesForExtendedLayout__
{
    return [self edgesForExtendedLayout];
}

// @property(nonatomic, getter=isEditing) BOOL editing;
- (void) setEditing___boolean:(BOOL) editing 
{
    [self setEditing:editing];
}

// @property(nonatomic, getter=isEditing) BOOL editing;
- (BOOL) isEditing__
{
    return [self isEditing];
}

// @property(nonatomic, readonly, strong) NSExtensionContext *extensionContext;
- (NSExtensionContext*) extensionContext__
{
    NSExtensionContext* re$ult = [self extensionContext];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) BOOL hidesBottomBarWhenPushed;
- (void) setHidesBottomBarWhenPushed___boolean:(BOOL) hidesBottomBarWhenPushed 
{
    [self setHidesBottomBarWhenPushed:hidesBottomBarWhenPushed];
}

// @property(nonatomic) BOOL hidesBottomBarWhenPushed;
- (BOOL) hidesBottomBarWhenPushed__
{
    return [self hidesBottomBarWhenPushed];
}

// @property(nonatomic, readonly) UIInterfaceOrientation interfaceOrientation;
- (int) interfaceOrientation__
{
    return [self interfaceOrientation];
}

// @property(nonatomic, readwrite, getter=isModalInPopover) BOOL modalInPopover;
- (void) setModalInPopover___boolean:(BOOL) modalInPopover 
{
    [self setModalInPopover:modalInPopover];
}

// @property(nonatomic, readwrite, getter=isModalInPopover) BOOL modalInPopover;
- (BOOL) isModalInPopover__
{
    return [self isModalInPopover];
}

// @property(nonatomic, assign) UIModalPresentationStyle modalPresentationStyle;
- (void) setModalPresentationStyle___int:(int) modalPresentationStyle 
{
    [self setModalPresentationStyle:modalPresentationStyle];
}

// @property(nonatomic, assign) UIModalPresentationStyle modalPresentationStyle;
- (int) modalPresentationStyle__
{
    return [self modalPresentationStyle];
}

// @property(nonatomic, assign) UIModalTransitionStyle modalTransitionStyle;
- (void) setModalTransitionStyle___int:(int) modalTransitionStyle 
{
    [self setModalTransitionStyle:modalTransitionStyle];
}

// @property(nonatomic, assign) UIModalTransitionStyle modalTransitionStyle;
- (int) modalTransitionStyle__
{
    return [self modalTransitionStyle];
}

// @property(nonatomic, readonly, strong) UINavigationController *navigationController;
- (UINavigationController*) navigationController__
{
    UINavigationController* re$ult = [self navigationController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, strong) UINavigationItem *navigationItem;
- (UINavigationItem*) navigationItem__
{
    UINavigationItem* re$ult = [self navigationItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, copy) NSString *nibName;
- (NSString*) nibName__
{
    NSString* re$ult = [self nibName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, weak, readonly) UIViewController *parentViewController;
- (UIViewController*) parentViewController__
{
    UIViewController* re$ult = [self parentViewController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) UIStatusBarStyle preferredStatusBarStyle;
- (int) preferredStatusBarStyle__
{
    return [self preferredStatusBarStyle];
}

// @property(nonatomic, readonly) BOOL prefersStatusBarHidden;
- (BOOL) prefersStatusBarHidden__
{
    return [self prefersStatusBarHidden];
}

// @property(nonatomic, readonly) UIViewController *presentedViewController;
- (UIViewController*) presentedViewController__
{
    UIViewController* re$ult = [self presentedViewController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) UIViewController *presentingViewController;
- (UIViewController*) presentingViewController__
{
    UIViewController* re$ult = [self presentingViewController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, assign) BOOL providesPresentationContextTransitionStyle;
- (void) setProvidesPresentationContextTransitionStyle___boolean:(BOOL) providesPresentationContextTransitionStyle 
{
    [self setProvidesPresentationContextTransitionStyle:providesPresentationContextTransitionStyle];
}

// @property(nonatomic, assign) BOOL providesPresentationContextTransitionStyle;
- (BOOL) providesPresentationContextTransitionStyle__
{
    return [self providesPresentationContextTransitionStyle];
}

// @property(nonatomic, copy) NSString *restorationIdentifier;
- (void) setRestorationIdentifier___java_lang_String:(NSString*) restorationIdentifier 
{
    [self setRestorationIdentifier:(restorationIdentifier == JAVA_NULL ? nil : restorationIdentifier)];
}

// @property(nonatomic, copy) NSString *restorationIdentifier;
- (NSString*) restorationIdentifier__
{
    NSString* re$ult = [self restorationIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) BOOL shouldAutomaticallyForwardAppearanceMethods;
- (BOOL) shouldAutomaticallyForwardAppearanceMethods__
{
    return [self shouldAutomaticallyForwardAppearanceMethods];
}

// @property(nonatomic, readonly, strong) UISplitViewController *splitViewController;
- (UISplitViewController*) splitViewController__
{
    UISplitViewController* re$ult = [self splitViewController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, strong) UIStoryboard *storyboard;
- (UIStoryboard*) storyboard__
{
    UIStoryboard* re$ult = [self storyboard];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, strong) UITabBarController *tabBarController;
- (UITabBarController*) tabBarController__
{
    UITabBarController* re$ult = [self tabBarController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, strong) UITabBarItem *tabBarItem;
- (void) setTabBarItem___crossmobile_ios_uikit_UITabBarItem:(UITabBarItem*) tabBarItem 
{
    [self setTabBarItem:(tabBarItem == JAVA_NULL ? nil : tabBarItem)];
}

// @property(nonatomic, strong) UITabBarItem *tabBarItem;
- (UITabBarItem*) tabBarItem__
{
    UITabBarItem* re$ult = [self tabBarItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, copy) NSString *title;
- (void) setTitle___java_lang_String:(NSString*) title 
{
    [self setTitle:(title == JAVA_NULL ? nil : title)];
}

// @property(nonatomic, copy) NSString *title;
- (NSString*) title__
{
    NSString* re$ult = [self title];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, strong) NSArray<__kindof UIBarButtonItem *> *toolbarItems;
- (void) setToolbarItems___java_util_List:(NSArray*) toolbarItems 
{
    [self setToolbarItems:(toolbarItems == JAVA_NULL ? nil : toolbarItems)];
}

// @property(nonatomic, strong) NSArray<__kindof UIBarButtonItem *> *toolbarItems;
- (NSArray*) toolbarItems__
{
    NSArray* re$ult = [self toolbarItems];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, strong) id<UILayoutSupport> topLayoutGuide;
- (id<UILayoutSupport>) topLayoutGuide__
{
    id<UILayoutSupport> re$ult = [self topLayoutGuide];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, strong) UIView *view;
- (void) setView___crossmobile_ios_uikit_UIView:(UIView*) view 
{
    [self setView:(view == JAVA_NULL ? nil : view)];
}

// @property(nonatomic, strong) UIView *view;
- (UIView*) view__
{
    UIView* re$ult = [self view];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, strong) UIView *viewIfLoaded;
- (UIView*) viewIfLoaded__
{
    UIView* re$ult = [self viewIfLoaded];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, getter=isViewLoaded) BOOL viewLoaded;
- (BOOL) isViewLoaded__
{
    return [self isViewLoaded];
}

// @property(nonatomic, assign) BOOL wantsFullScreenLayout;
- (void) setWantsFullScreenLayout___boolean:(BOOL) wantsFullScreenLayout 
{
    [self setWantsFullScreenLayout:wantsFullScreenLayout];
}

// @property(nonatomic, assign) BOOL wantsFullScreenLayout;
- (BOOL) wantsFullScreenLayout__
{
    return [self wantsFullScreenLayout];
}

// - (void)addChildViewController:(UIViewController *)childController;
- (void) addChildViewController___crossmobile_ios_uikit_UIViewController:(UIViewController*) childController 
{
    [self addChildViewController:(childController == JAVA_NULL ? nil : childController)];
}

// - (NSArray<UIViewController *> *)allowedChildViewControllersForUnwindingFromSource:(UIStoryboardUnwindSegueSource *)source;
- (NSArray*) allowedChildViewControllersForUnwindingFromSource___crossmobile_ios_uikit_UIStoryboardUnwindSegueSource:(UIStoryboardUnwindSegueSource*) source 
{
    NSArray* re$ult = [self allowedChildViewControllersForUnwindingFromSource:(source == JAVA_NULL ? nil : source)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)beginAppearanceTransition:(BOOL)isAppearing animated:(BOOL)animated;
- (void) beginAppearanceTransition___boolean_boolean:(BOOL) isAppearing :(BOOL) animated 
{
    [self beginAppearanceTransition:isAppearing animated:animated];
}

// - (UIViewController *)childViewControllerContainingSegueSource:(UIStoryboardUnwindSegueSource *)source;
- (UIViewController*) childViewControllerContainingSegueSource___crossmobile_ios_uikit_UIStoryboardUnwindSegueSource:(UIStoryboardUnwindSegueSource*) source 
{
    UIViewController* re$ult = [self childViewControllerContainingSegueSource:(source == JAVA_NULL ? nil : source)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)didReceiveMemoryWarning;
- (void) didReceiveMemoryWarning__
{
    [self didReceiveMemoryWarning];
}

// - (void)didRotateFromInterfaceOrientation:(UIInterfaceOrientation)fromInterfaceOrientation;
- (void) didRotateFromInterfaceOrientation___int:(int) fromInterfaceOrientation 
{
    [self didRotateFromInterfaceOrientation:fromInterfaceOrientation];
}

// - (void)dismissModalViewControllerAnimated:(BOOL)animated;
- (void) dismissModalViewControllerAnimated___boolean:(BOOL) animated 
{
    [self dismissModalViewControllerAnimated:animated];
}

// - (void)dismissViewControllerAnimated:(BOOL)flag completion:(void (^)(void))completion;
- (void) dismissViewControllerAnimated___boolean_java_lang_Runnable:(BOOL) flag :(id<java_lang_Runnable>) completion 
{
    [self dismissViewControllerAnimated:flag completion:(completion == JAVA_NULL ? nil : ^{
        [completion run__];
    })];
}

// - (UIBarButtonItem *)editButtonItem;
- (UIBarButtonItem*) editButtonItem__
{
    UIBarButtonItem* re$ult = [self editButtonItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)endAppearanceTransition;
- (void) endAppearanceTransition__
{
    [self endAppearanceTransition];
}

// - (void)loadView;
- (void) loadView__
{
    [self loadView];
}

// - (void)loadViewIfNeeded;
- (void) loadViewIfNeeded__
{
    [self loadViewIfNeeded];
}

// - (void)performSegueWithIdentifier:(NSString *)identifier sender:(id)sender;
- (void) performSegueWithIdentifier___java_lang_String_java_lang_Object:(NSString*) identifier :(id) sender 
{
    [self performSegueWithIdentifier:(identifier == JAVA_NULL ? nil : identifier) sender:(sender == JAVA_NULL ? nil : sender)];
}

// - (UIInterfaceOrientation)preferredInterfaceOrientationForPresentation;
- (int) preferredInterfaceOrientationForPresentation__
{
    return [self preferredInterfaceOrientationForPresentation];
}

// - (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender;
- (void) prepareForSegue___crossmobile_ios_uikit_UIStoryboardSegue_java_lang_Object:(UIStoryboardSegue*) segue :(id) sender 
{
    [self prepareForSegue:(segue == JAVA_NULL ? nil : segue) sender:(sender == JAVA_NULL ? nil : sender)];
}

// - (void)presentModalViewController:(UIViewController *)modalViewController animated:(BOOL)animated;
- (void) presentModalViewController___crossmobile_ios_uikit_UIViewController_boolean:(UIViewController*) modalViewController :(BOOL) animated 
{
    [self presentModalViewController:(modalViewController == JAVA_NULL ? nil : modalViewController) animated:animated];
}

// - (void)presentViewController:(UIViewController *)viewControllerToPresent animated:(BOOL)flag completion:(void (^)(void))completion;
- (void) presentViewController___crossmobile_ios_uikit_UIViewController_boolean_java_lang_Runnable:(UIViewController*) viewControllerToPresent :(BOOL) flag :(id<java_lang_Runnable>) completion 
{
    [self presentViewController:(viewControllerToPresent == JAVA_NULL ? nil : viewControllerToPresent) animated:flag completion:(completion == JAVA_NULL ? nil : ^{
        [completion run__];
    })];
}

// - (void)removeFromParentViewController;
- (void) removeFromParentViewController__
{
    [self removeFromParentViewController];
}

// - (UIView *)rotatingFooterView;
- (UIView*) rotatingFooterView__
{
    UIView* re$ult = [self rotatingFooterView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (UIView *)rotatingHeaderView;
- (UIView*) rotatingHeaderView__
{
    UIView* re$ult = [self rotatingHeaderView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)setEditing:(BOOL)editing animated:(BOOL)animated;
- (void) setEditing___boolean_boolean:(BOOL) editing :(BOOL) animated 
{
    [self setEditing:editing animated:animated];
}

// - (void)setNeedsStatusBarAppearanceUpdate;
- (void) setNeedsStatusBarAppearanceUpdate__
{
    [self setNeedsStatusBarAppearanceUpdate];
}

// - (void)setToolbarItems:(NSArray<UIBarButtonItem *> *)toolbarItems animated:(BOOL)animated;
- (void) setToolbarItems___java_util_List_boolean:(NSArray*) toolbarItems :(BOOL) animated 
{
    [self setToolbarItems:(toolbarItems == JAVA_NULL ? nil : toolbarItems) animated:animated];
}

// - (BOOL)shouldAutorotate;
- (BOOL) shouldAutorotate__
{
    return [self shouldAutorotate];
}

// - (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)toInterfaceOrientation;
- (BOOL) shouldAutorotateToInterfaceOrientation___int:(int) toInterfaceOrientation 
{
    return [self shouldAutorotateToInterfaceOrientation:toInterfaceOrientation];
}

// - (BOOL)shouldPerformSegueWithIdentifier:(NSString *)identifier sender:(id)sender;
- (BOOL) shouldPerformSegueWithIdentifier___java_lang_String_java_lang_Object:(NSString*) identifier :(id) sender 
{
    return [self shouldPerformSegueWithIdentifier:(identifier == JAVA_NULL ? nil : identifier) sender:(sender == JAVA_NULL ? nil : sender)];
}

// - (void)showDetailViewController:(UIViewController *)vc sender:(id)sender;
- (void) showDetailViewController___crossmobile_ios_uikit_UIViewController_java_lang_Object:(UIViewController*) vc :(id) sender 
{
    [self showDetailViewController:(vc == JAVA_NULL ? nil : vc) sender:(sender == JAVA_NULL ? nil : sender)];
}

// - (void)showViewController:(UIViewController *)vc sender:(id)sender;
- (void) showViewController___crossmobile_ios_uikit_UIViewController_java_lang_Object:(UIViewController*) vc :(id) sender 
{
    [self showViewController:(vc == JAVA_NULL ? nil : vc) sender:(sender == JAVA_NULL ? nil : sender)];
}

// - (UIInterfaceOrientationMask)supportedInterfaceOrientations;
- (int) supportedInterfaceOrientations__
{
    return [self supportedInterfaceOrientations];
}

// - (void)transitionFromViewController:(UIViewController *)fromViewController toViewController:(UIViewController *)toViewController duration:(NSTimeInterval)duration options:(UIViewAnimationOptions)options animations:(void (^)(void))animations completion:(void (^)(BOOL finished))completion;
- (void) transitionFromViewController___crossmobile_ios_uikit_UIViewController_crossmobile_ios_uikit_UIViewController_double_int_java_lang_Runnable_org_robovm_objc_block_VoidBlock1:(UIViewController*) fromViewController :(UIViewController*) toViewController :(double) duration :(int) options :(id<java_lang_Runnable>) animations :(id<org_robovm_objc_block_VoidBlock1>) completion 
{
    [self transitionFromViewController:(fromViewController == JAVA_NULL ? nil : fromViewController) toViewController:(toViewController == JAVA_NULL ? nil : toViewController) duration:duration options:options animations:(animations == JAVA_NULL ? nil : ^{
        [animations run__];
    }) completion:(completion == JAVA_NULL ? nil : ^(BOOL finished) {
        java_lang_Boolean* finished$conv = [[java_lang_Boolean alloc] initWithBool:finished];
        [completion invoke___java_lang_Object:finished$conv];
        [finished$conv release];
    })];
}

// - (void)viewDidAppear:(BOOL)animated;
- (void) viewDidAppear___boolean:(BOOL) animated 
{
    [self viewDidAppear:animated];
}

// - (void)viewDidDisappear:(BOOL)animated;
- (void) viewDidDisappear___boolean:(BOOL) animated 
{
    [self viewDidDisappear:animated];
}

// - (void)viewDidLayoutSubviews;
- (void) viewDidLayoutSubviews__
{
    [self viewDidLayoutSubviews];
}

// - (void)viewDidLoad;
- (void) viewDidLoad__
{
    [self viewDidLoad];
}

// - (void)viewDidUnload;
- (void) viewDidUnload__
{
    [self viewDidUnload];
}

// - (void)viewSafeAreaInsetsDidChange;
- (void) viewSafeAreaInsetsDidChange__
{
    [self viewSafeAreaInsetsDidChange];
}

// - (void)viewWillAppear:(BOOL)animated;
- (void) viewWillAppear___boolean:(BOOL) animated 
{
    [self viewWillAppear:animated];
}

// - (void)viewWillDisappear:(BOOL)animated;
- (void) viewWillDisappear___boolean:(BOOL) animated 
{
    [self viewWillDisappear:animated];
}

// - (void)viewWillLayoutSubviews;
- (void) viewWillLayoutSubviews__
{
    [self viewWillLayoutSubviews];
}

// - (void)willAnimateRotationToInterfaceOrientation:(UIInterfaceOrientation)toInterfaceOrientation duration:(NSTimeInterval)duration;
- (void) willAnimateRotationToInterfaceOrientation___int_double:(int) toInterfaceOrientation :(double) duration 
{
    [self willAnimateRotationToInterfaceOrientation:toInterfaceOrientation duration:duration];
}

// - (void)willRotateToInterfaceOrientation:(UIInterfaceOrientation)toInterfaceOrientation duration:(NSTimeInterval)duration;
- (void) willRotateToInterfaceOrientation___int_double:(int) toInterfaceOrientation :(double) duration 
{
    [self willRotateToInterfaceOrientation:toInterfaceOrientation duration:duration];
}

@end
