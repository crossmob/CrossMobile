// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UISplitViewController implementation

#import "crossmobile_ios_coregraphics_CGSize.h"
#import "crossmobile_ios_foundation_NSExtensionContext.h"
#import "crossmobile_ios_uikit_UIBarButtonItem.h"
#import "crossmobile_ios_uikit_UIEdgeInsets.h"
#import "crossmobile_ios_uikit_UIEvent.h"
#import "crossmobile_ios_uikit_UILayoutSupport.h"
#import "crossmobile_ios_uikit_UINavigationController.h"
#import "crossmobile_ios_uikit_UINavigationItem.h"
#import "crossmobile_ios_uikit_UIResponder.h"
#import "crossmobile_ios_uikit_UISplitViewController.h"
#import "crossmobile_ios_uikit_UISplitViewControllerDelegate.h"
#import "crossmobile_ios_uikit_UIStoryboard.h"
#import "crossmobile_ios_uikit_UIStoryboardSegue.h"
#import "crossmobile_ios_uikit_UIStoryboardUnwindSegueSource.h"
#import "crossmobile_ios_uikit_UITabBarController.h"
#import "crossmobile_ios_uikit_UITabBarItem.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "crossmobile_ios_uikit_UIViewController.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Set.h"

@implementation crossmobile_ios_uikit_UISplitViewController$Ext

// (UIViewController) @property(nonatomic) UIEdgeInsets additionalSafeAreaInsets;
- (void) setAdditionalSafeAreaInsets___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) additionalSafeAreaInsets 
{
    [super setAdditionalSafeAreaInsets:[additionalSafeAreaInsets getUIEdgeInsets]];
}

// (UIViewController) @property(nonatomic) UIEdgeInsets additionalSafeAreaInsets;
- (crossmobile_ios_uikit_UIEdgeInsets*) additionalSafeAreaInsets__
{
    return [[crossmobile_ios_uikit_UIEdgeInsets alloc] initWithUIEdgeInsets:[super additionalSafeAreaInsets]];
}

// (UIViewController) @property(nonatomic, assign) BOOL automaticallyAdjustsScrollViewInsets;
- (void) setAutomaticallyAdjustsScrollViewInsets___boolean:(BOOL) automaticallyAdjustsScrollViewInsets 
{
    [super setAutomaticallyAdjustsScrollViewInsets:automaticallyAdjustsScrollViewInsets];
}

// (UIViewController) @property(nonatomic, assign) BOOL automaticallyAdjustsScrollViewInsets;
- (BOOL) automaticallyAdjustsScrollViewInsets__
{
    return [super automaticallyAdjustsScrollViewInsets];
}

// (UIViewController) @property(nonatomic, readonly, strong) id<UILayoutSupport> bottomLayoutGuide;
- (id<UILayoutSupport>) bottomLayoutGuide__
{
    id<UILayoutSupport> re$ult = [super bottomLayoutGuide];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIViewController) @property(nonatomic, readonly) NSArray<__kindof UIViewController *> *childViewControllers;
- (NSArray*) childViewControllers__
{
    NSArray* re$ult = [super childViewControllers];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UISplitViewController) @property(nonatomic, readonly, getter=isCollapsed) BOOL collapsed;
- (BOOL) isCollapsed__
{
    return [super isCollapsed];
}

// (UIViewController) @property(nonatomic, readwrite) CGSize contentSizeForViewInPopover;
- (void) setContentSizeForViewInPopover___crossmobile_ios_coregraphics_CGSize:(crossmobile_ios_coregraphics_CGSize*) contentSizeForViewInPopover 
{
    [super setContentSizeForViewInPopover:[contentSizeForViewInPopover getCGSize]];
}

// (UIViewController) @property(nonatomic, readwrite) CGSize contentSizeForViewInPopover;
- (crossmobile_ios_coregraphics_CGSize*) contentSizeForViewInPopover__
{
    return [[crossmobile_ios_coregraphics_CGSize alloc] initWithCGSize:[super contentSizeForViewInPopover]];
}

// (UIViewController) @property(nonatomic, assign) BOOL definesPresentationContext;
- (void) setDefinesPresentationContext___boolean:(BOOL) definesPresentationContext 
{
    [super setDefinesPresentationContext:definesPresentationContext];
}

// (UIViewController) @property(nonatomic, assign) BOOL definesPresentationContext;
- (BOOL) definesPresentationContext__
{
    return [super definesPresentationContext];
}

// (UISplitViewController) @property(nonatomic, weak) id<UISplitViewControllerDelegate> delegate;
- (void) setDelegate___crossmobile_ios_uikit_UISplitViewControllerDelegate:(id<UISplitViewControllerDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [super setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// (UISplitViewController) @property(nonatomic, weak) id<UISplitViewControllerDelegate> delegate;
- (id<UISplitViewControllerDelegate>) delegate__
{
    id<UISplitViewControllerDelegate> re$ult = [super delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIViewController) @property(nonatomic, readonly) BOOL disablesAutomaticKeyboardDismissal;
- (BOOL) disablesAutomaticKeyboardDismissal__
{
    return [super disablesAutomaticKeyboardDismissal];
}

// (UISplitViewController) @property(nonatomic, readonly) UISplitViewControllerDisplayMode displayMode;
- (int) displayMode__
{
    return [super displayMode];
}

// (UIViewController) @property(nonatomic, assign) UIRectEdge edgesForExtendedLayout;
- (void) setEdgesForExtendedLayout___int:(int) edgesForExtendedLayout 
{
    [super setEdgesForExtendedLayout:edgesForExtendedLayout];
}

// (UIViewController) @property(nonatomic, assign) UIRectEdge edgesForExtendedLayout;
- (int) edgesForExtendedLayout__
{
    return [super edgesForExtendedLayout];
}

// (UIViewController) @property(nonatomic, getter=isEditing) BOOL editing;
- (void) setEditing___boolean:(BOOL) editing 
{
    [super setEditing:editing];
}

// (UIViewController) @property(nonatomic, getter=isEditing) BOOL editing;
- (BOOL) isEditing__
{
    return [super isEditing];
}

// (UIViewController) @property(nonatomic, readonly, strong) NSExtensionContext *extensionContext;
- (NSExtensionContext*) extensionContext__
{
    NSExtensionContext* re$ult = [super extensionContext];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIViewController) @property(nonatomic) BOOL hidesBottomBarWhenPushed;
- (void) setHidesBottomBarWhenPushed___boolean:(BOOL) hidesBottomBarWhenPushed 
{
    [super setHidesBottomBarWhenPushed:hidesBottomBarWhenPushed];
}

// (UIViewController) @property(nonatomic) BOOL hidesBottomBarWhenPushed;
- (BOOL) hidesBottomBarWhenPushed__
{
    return [super hidesBottomBarWhenPushed];
}

// (UIViewController) @property(nonatomic, readonly) UIInterfaceOrientation interfaceOrientation;
- (int) interfaceOrientation__
{
    return [super interfaceOrientation];
}

// (UISplitViewController) @property(nonatomic, assign) CGFloat maximumPrimaryColumnWidth;
- (void) setMaximumPrimaryColumnWidth___double:(double) maximumPrimaryColumnWidth 
{
    [super setMaximumPrimaryColumnWidth:maximumPrimaryColumnWidth];
}

// (UISplitViewController) @property(nonatomic, assign) CGFloat maximumPrimaryColumnWidth;
- (double) maximumPrimaryColumnWidth__
{
    return [super maximumPrimaryColumnWidth];
}

// (UISplitViewController) @property(nonatomic, assign) CGFloat minimumPrimaryColumnWidth;
- (void) setMinimumPrimaryColumnWidth___double:(double) minimumPrimaryColumnWidth 
{
    [super setMinimumPrimaryColumnWidth:minimumPrimaryColumnWidth];
}

// (UISplitViewController) @property(nonatomic, assign) CGFloat minimumPrimaryColumnWidth;
- (double) minimumPrimaryColumnWidth__
{
    return [super minimumPrimaryColumnWidth];
}

// (UIViewController) @property(nonatomic, readwrite, getter=isModalInPopover) BOOL modalInPopover;
- (void) setModalInPopover___boolean:(BOOL) modalInPopover 
{
    [super setModalInPopover:modalInPopover];
}

// (UIViewController) @property(nonatomic, readwrite, getter=isModalInPopover) BOOL modalInPopover;
- (BOOL) isModalInPopover__
{
    return [super isModalInPopover];
}

// (UIViewController) @property(nonatomic, assign) UIModalPresentationStyle modalPresentationStyle;
- (void) setModalPresentationStyle___int:(int) modalPresentationStyle 
{
    [super setModalPresentationStyle:modalPresentationStyle];
}

// (UIViewController) @property(nonatomic, assign) UIModalPresentationStyle modalPresentationStyle;
- (int) modalPresentationStyle__
{
    return [super modalPresentationStyle];
}

// (UIViewController) @property(nonatomic, assign) UIModalTransitionStyle modalTransitionStyle;
- (void) setModalTransitionStyle___int:(int) modalTransitionStyle 
{
    [super setModalTransitionStyle:modalTransitionStyle];
}

// (UIViewController) @property(nonatomic, assign) UIModalTransitionStyle modalTransitionStyle;
- (int) modalTransitionStyle__
{
    return [super modalTransitionStyle];
}

// (UIViewController) @property(nonatomic, readonly, strong) UINavigationController *navigationController;
- (UINavigationController*) navigationController__
{
    UINavigationController* re$ult = [super navigationController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIViewController) @property(nonatomic, readonly, strong) UINavigationItem *navigationItem;
- (UINavigationItem*) navigationItem__
{
    UINavigationItem* re$ult = [super navigationItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIViewController) @property(nonatomic, readonly, copy) NSString *nibName;
- (NSString*) nibName__
{
    NSString* re$ult = [super nibName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIViewController) @property(nonatomic, weak, readonly) UIViewController *parentViewController;
- (UIViewController*) parentViewController__
{
    UIViewController* re$ult = [super parentViewController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UISplitViewController) @property(nonatomic) UISplitViewControllerDisplayMode preferredDisplayMode;
- (void) setPreferredDisplayMode___int:(int) preferredDisplayMode 
{
    [super setPreferredDisplayMode:preferredDisplayMode];
}

// (UISplitViewController) @property(nonatomic) UISplitViewControllerDisplayMode preferredDisplayMode;
- (int) preferredDisplayMode__
{
    return [super preferredDisplayMode];
}

// (UISplitViewController) @property(nonatomic, assign) CGFloat preferredPrimaryColumnWidthFraction;
- (void) setPreferredPrimaryColumnWidthFraction___double:(double) preferredPrimaryColumnWidthFraction 
{
    [super setPreferredPrimaryColumnWidthFraction:preferredPrimaryColumnWidthFraction];
}

// (UISplitViewController) @property(nonatomic, assign) CGFloat preferredPrimaryColumnWidthFraction;
- (double) preferredPrimaryColumnWidthFraction__
{
    return [super preferredPrimaryColumnWidthFraction];
}

// (UIViewController) @property(nonatomic, readonly) UIViewController *presentedViewController;
- (UIViewController*) presentedViewController__
{
    UIViewController* re$ult = [super presentedViewController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIViewController) @property(nonatomic, readonly) UIViewController *presentingViewController;
- (UIViewController*) presentingViewController__
{
    UIViewController* re$ult = [super presentingViewController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UISplitViewController) @property(nonatomic) BOOL presentsWithGesture;
- (void) setPresentsWithGesture___boolean:(BOOL) presentsWithGesture 
{
    [super setPresentsWithGesture:presentsWithGesture];
}

// (UISplitViewController) @property(nonatomic) BOOL presentsWithGesture;
- (BOOL) presentsWithGesture__
{
    return [super presentsWithGesture];
}

// (UISplitViewController) @property(nonatomic, readonly) CGFloat primaryColumnWidth;
- (double) primaryColumnWidth__
{
    return [super primaryColumnWidth];
}

// (UIViewController) @property(nonatomic, assign) BOOL providesPresentationContextTransitionStyle;
- (void) setProvidesPresentationContextTransitionStyle___boolean:(BOOL) providesPresentationContextTransitionStyle 
{
    [super setProvidesPresentationContextTransitionStyle:providesPresentationContextTransitionStyle];
}

// (UIViewController) @property(nonatomic, assign) BOOL providesPresentationContextTransitionStyle;
- (BOOL) providesPresentationContextTransitionStyle__
{
    return [super providesPresentationContextTransitionStyle];
}

// (UIViewController) @property(nonatomic, copy) NSString *restorationIdentifier;
- (void) setRestorationIdentifier___java_lang_String:(NSString*) restorationIdentifier 
{
    [super setRestorationIdentifier:(restorationIdentifier == JAVA_NULL ? nil : restorationIdentifier)];
}

// (UIViewController) @property(nonatomic, copy) NSString *restorationIdentifier;
- (NSString*) restorationIdentifier__
{
    NSString* re$ult = [super restorationIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIViewController) @property(nonatomic, readonly) BOOL shouldAutomaticallyForwardAppearanceMethods;
- (BOOL) shouldAutomaticallyForwardAppearanceMethods__
{
    return [super shouldAutomaticallyForwardAppearanceMethods];
}

// (UIViewController) @property(nonatomic, readonly, strong) UISplitViewController *splitViewController;
- (UISplitViewController*) splitViewController__
{
    UISplitViewController* re$ult = [super splitViewController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIViewController) @property(nonatomic, readonly, strong) UIStoryboard *storyboard;
- (UIStoryboard*) storyboard__
{
    UIStoryboard* re$ult = [super storyboard];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIViewController) @property(nonatomic, readonly, strong) UITabBarController *tabBarController;
- (UITabBarController*) tabBarController__
{
    UITabBarController* re$ult = [super tabBarController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIViewController) @property(nonatomic, strong) UITabBarItem *tabBarItem;
- (void) setTabBarItem___crossmobile_ios_uikit_UITabBarItem:(UITabBarItem*) tabBarItem 
{
    [super setTabBarItem:(tabBarItem == JAVA_NULL ? nil : tabBarItem)];
}

// (UIViewController) @property(nonatomic, strong) UITabBarItem *tabBarItem;
- (UITabBarItem*) tabBarItem__
{
    UITabBarItem* re$ult = [super tabBarItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIViewController) @property(nonatomic, copy) NSString *title;
- (void) setTitle___java_lang_String:(NSString*) title 
{
    [super setTitle:(title == JAVA_NULL ? nil : title)];
}

// (UIViewController) @property(nonatomic, copy) NSString *title;
- (NSString*) title__
{
    NSString* re$ult = [super title];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIViewController) @property(nonatomic, strong) NSArray<__kindof UIBarButtonItem *> *toolbarItems;
- (void) setToolbarItems___java_util_List:(NSArray*) toolbarItems 
{
    [super setToolbarItems:(toolbarItems == JAVA_NULL ? nil : toolbarItems)];
}

// (UIViewController) @property(nonatomic, strong) NSArray<__kindof UIBarButtonItem *> *toolbarItems;
- (NSArray*) toolbarItems__
{
    NSArray* re$ult = [super toolbarItems];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIViewController) @property(nonatomic, readonly, strong) id<UILayoutSupport> topLayoutGuide;
- (id<UILayoutSupport>) topLayoutGuide__
{
    id<UILayoutSupport> re$ult = [super topLayoutGuide];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIViewController) @property(nonatomic, strong) UIView *view;
- (void) setView___crossmobile_ios_uikit_UIView:(UIView*) view 
{
    [super setView:(view == JAVA_NULL ? nil : view)];
}

// (UIViewController) @property(nonatomic, strong) UIView *view;
- (UIView*) view__
{
    UIView* re$ult = [super view];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UISplitViewController) @property(nonatomic, copy) NSArray<__kindof UIViewController *> *viewControllers;
- (void) setViewControllers___java_util_List:(NSArray*) viewControllers 
{
    [super setViewControllers:(viewControllers == JAVA_NULL ? nil : viewControllers)];
}

// (UISplitViewController) @property(nonatomic, copy) NSArray<__kindof UIViewController *> *viewControllers;
- (NSArray*) viewControllers__
{
    NSArray* re$ult = [super viewControllers];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIViewController) @property(nonatomic, readonly, strong) UIView *viewIfLoaded;
- (UIView*) viewIfLoaded__
{
    UIView* re$ult = [super viewIfLoaded];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIViewController) @property(nonatomic, readonly, getter=isViewLoaded) BOOL viewLoaded;
- (BOOL) isViewLoaded__
{
    return [super isViewLoaded];
}

// (UIViewController) @property(nonatomic, assign) BOOL wantsFullScreenLayout;
- (void) setWantsFullScreenLayout___boolean:(BOOL) wantsFullScreenLayout 
{
    [super setWantsFullScreenLayout:wantsFullScreenLayout];
}

// (UIViewController) @property(nonatomic, assign) BOOL wantsFullScreenLayout;
- (BOOL) wantsFullScreenLayout__
{
    return [super wantsFullScreenLayout];
}

// (UIViewController) - (void)addChildViewController:(UIViewController *)childController;
- (void) addChildViewController___crossmobile_ios_uikit_UIViewController:(UIViewController*) childController 
{
    [super addChildViewController:(childController == JAVA_NULL ? nil : childController)];
}

// (UIViewController) - (NSArray<UIViewController *> *)allowedChildViewControllersForUnwindingFromSource:(UIStoryboardUnwindSegueSource *)source;
- (NSArray*) allowedChildViewControllersForUnwindingFromSource___crossmobile_ios_uikit_UIStoryboardUnwindSegueSource:(UIStoryboardUnwindSegueSource*) source 
{
    NSArray* re$ult = [super allowedChildViewControllersForUnwindingFromSource:(source == JAVA_NULL ? nil : source)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIResponder) - (BOOL)becomeFirstResponder;
- (BOOL) becomeFirstResponder__
{
    return [super becomeFirstResponder];
}

// (UIViewController) - (void)beginAppearanceTransition:(BOOL)isAppearing animated:(BOOL)animated;
- (void) beginAppearanceTransition___boolean_boolean:(BOOL) isAppearing :(BOOL) animated 
{
    [super beginAppearanceTransition:isAppearing animated:animated];
}

// (UIViewController) - (UIViewController *)childViewControllerContainingSegueSource:(UIStoryboardUnwindSegueSource *)source;
- (UIViewController*) childViewControllerContainingSegueSource___crossmobile_ios_uikit_UIStoryboardUnwindSegueSource:(UIStoryboardUnwindSegueSource*) source 
{
    UIViewController* re$ult = [super childViewControllerContainingSegueSource:(source == JAVA_NULL ? nil : source)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIViewController) - (void)didReceiveMemoryWarning;
- (void) didReceiveMemoryWarning__
{
    [super didReceiveMemoryWarning];
}

// (UIViewController) - (void)didRotateFromInterfaceOrientation:(UIInterfaceOrientation)fromInterfaceOrientation;
- (void) didRotateFromInterfaceOrientation___int:(int) fromInterfaceOrientation 
{
    [super didRotateFromInterfaceOrientation:fromInterfaceOrientation];
}

// (UIViewController) - (void)dismissModalViewControllerAnimated:(BOOL)animated;
- (void) dismissModalViewControllerAnimated___boolean:(BOOL) animated 
{
    [super dismissModalViewControllerAnimated:animated];
}

// (UISplitViewController) - (UIBarButtonItem *)displayModeButtonItem;
- (UIBarButtonItem*) displayModeButtonItem__
{
    UIBarButtonItem* re$ult = [super displayModeButtonItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIViewController) - (UIBarButtonItem *)editButtonItem;
- (UIBarButtonItem*) editButtonItem__
{
    UIBarButtonItem* re$ult = [super editButtonItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIViewController) - (void)endAppearanceTransition;
- (void) endAppearanceTransition__
{
    [super endAppearanceTransition];
}

// (UIResponder) - (BOOL)isFirstResponder;
- (BOOL) isFirstResponder__
{
    return [super isFirstResponder];
}

// (UIViewController) - (void)loadView;
- (void) loadView__
{
    [super loadView];
}

// (UIViewController) - (void)loadViewIfNeeded;
- (void) loadViewIfNeeded__
{
    [super loadViewIfNeeded];
}

// (UIResponder) - (UIResponder *)nextResponder;
- (UIResponder*) nextResponder__
{
    UIResponder* re$ult = [super nextResponder];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIViewController) - (void)performSegueWithIdentifier:(NSString *)identifier sender:(id)sender;
- (void) performSegueWithIdentifier___java_lang_String_java_lang_Object:(NSString*) identifier :(id) sender 
{
    [super performSegueWithIdentifier:(identifier == JAVA_NULL ? nil : identifier) sender:(sender == JAVA_NULL ? nil : sender)];
}

// (UIViewController) - (UIInterfaceOrientation)preferredInterfaceOrientationForPresentation;
- (int) preferredInterfaceOrientationForPresentation__
{
    return [super preferredInterfaceOrientationForPresentation];
}

// (UIViewController) - (BOOL)prefersStatusBarHidden;
- (BOOL) prefersStatusBarHidden__
{
    return [super prefersStatusBarHidden];
}

// (UIViewController) - (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender;
- (void) prepareForSegue___crossmobile_ios_uikit_UIStoryboardSegue_java_lang_Object:(UIStoryboardSegue*) segue :(id) sender 
{
    [super prepareForSegue:(segue == JAVA_NULL ? nil : segue) sender:(sender == JAVA_NULL ? nil : sender)];
}

// (UIViewController) - (void)presentModalViewController:(UIViewController *)modalViewController animated:(BOOL)animated;
- (void) presentModalViewController___crossmobile_ios_uikit_UIViewController_boolean:(UIViewController*) modalViewController :(BOOL) animated 
{
    [super presentModalViewController:(modalViewController == JAVA_NULL ? nil : modalViewController) animated:animated];
}

// (UIViewController) - (void)removeFromParentViewController;
- (void) removeFromParentViewController__
{
    [super removeFromParentViewController];
}

// (UIResponder) - (BOOL)resignFirstResponder;
- (BOOL) resignFirstResponder__
{
    return [super resignFirstResponder];
}

// (UIViewController) - (UIView *)rotatingFooterView;
- (UIView*) rotatingFooterView__
{
    UIView* re$ult = [super rotatingFooterView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIViewController) - (UIView *)rotatingHeaderView;
- (UIView*) rotatingHeaderView__
{
    UIView* re$ult = [super rotatingHeaderView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIViewController) - (void)setEditing:(BOOL)editing animated:(BOOL)animated;
- (void) setEditing___boolean_boolean:(BOOL) editing :(BOOL) animated 
{
    [super setEditing:editing animated:animated];
}

// (UIViewController) - (void)setToolbarItems:(NSArray<UIBarButtonItem *> *)toolbarItems animated:(BOOL)animated;
- (void) setToolbarItems___java_util_List_boolean:(NSArray*) toolbarItems :(BOOL) animated 
{
    [super setToolbarItems:(toolbarItems == JAVA_NULL ? nil : toolbarItems) animated:animated];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValue___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (UIViewController) - (BOOL)shouldAutorotate;
- (BOOL) shouldAutorotate__
{
    return [super shouldAutorotate];
}

// (UIViewController) - (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)toInterfaceOrientation;
- (BOOL) shouldAutorotateToInterfaceOrientation___int:(int) toInterfaceOrientation 
{
    return [super shouldAutorotateToInterfaceOrientation:toInterfaceOrientation];
}

// (UIViewController) - (BOOL)shouldPerformSegueWithIdentifier:(NSString *)identifier sender:(id)sender;
- (BOOL) shouldPerformSegueWithIdentifier___java_lang_String_java_lang_Object:(NSString*) identifier :(id) sender 
{
    return [super shouldPerformSegueWithIdentifier:(identifier == JAVA_NULL ? nil : identifier) sender:(sender == JAVA_NULL ? nil : sender)];
}

// (UIViewController) - (void)showDetailViewController:(UIViewController *)vc sender:(id)sender;
- (void) showDetailViewController___crossmobile_ios_uikit_UIViewController_java_lang_Object:(UIViewController*) vc :(id) sender 
{
    [super showDetailViewController:(vc == JAVA_NULL ? nil : vc) sender:(sender == JAVA_NULL ? nil : sender)];
}

// (UIViewController) - (void)showViewController:(UIViewController *)vc sender:(id)sender;
- (void) showViewController___crossmobile_ios_uikit_UIViewController_java_lang_Object:(UIViewController*) vc :(id) sender 
{
    [super showViewController:(vc == JAVA_NULL ? nil : vc) sender:(sender == JAVA_NULL ? nil : sender)];
}

// (UIViewController) - (UIInterfaceOrientationMask)supportedInterfaceOrientations;
- (int) supportedInterfaceOrientations__
{
    return [super supportedInterfaceOrientations];
}

// (UIResponder) - (void)touchesBegan:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event;
- (void) touchesBegan___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event 
{
    [super touchesBegan:(touches == JAVA_NULL ? nil : touches) withEvent:(event == JAVA_NULL ? nil : event)];
}

// (UIResponder) - (void)touchesCancelled:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event;
- (void) touchesCancelled___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event 
{
    [super touchesCancelled:(touches == JAVA_NULL ? nil : touches) withEvent:(event == JAVA_NULL ? nil : event)];
}

// (UIResponder) - (void)touchesEnded:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event;
- (void) touchesEnded___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event 
{
    [super touchesEnded:(touches == JAVA_NULL ? nil : touches) withEvent:(event == JAVA_NULL ? nil : event)];
}

// (UIResponder) - (void)touchesMoved:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event;
- (void) touchesMoved___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event 
{
    [super touchesMoved:(touches == JAVA_NULL ? nil : touches) withEvent:(event == JAVA_NULL ? nil : event)];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIViewController) - (void)viewDidAppear:(BOOL)animated;
- (void) viewDidAppear___boolean:(BOOL) animated 
{
    [super viewDidAppear:animated];
}

// (UIViewController) - (void)viewDidDisappear:(BOOL)animated;
- (void) viewDidDisappear___boolean:(BOOL) animated 
{
    [super viewDidDisappear:animated];
}

// (UIViewController) - (void)viewDidLayoutSubviews;
- (void) viewDidLayoutSubviews__
{
    [super viewDidLayoutSubviews];
}

// (UIViewController) - (void)viewDidLoad;
- (void) viewDidLoad__
{
    [super viewDidLoad];
}

// (UIViewController) - (void)viewDidUnload;
- (void) viewDidUnload__
{
    [super viewDidUnload];
}

// (UIViewController) - (void)viewSafeAreaInsetsDidChange;
- (void) viewSafeAreaInsetsDidChange__
{
    [super viewSafeAreaInsetsDidChange];
}

// (UIViewController) - (void)viewWillAppear:(BOOL)animated;
- (void) viewWillAppear___boolean:(BOOL) animated 
{
    [super viewWillAppear:animated];
}

// (UIViewController) - (void)viewWillDisappear:(BOOL)animated;
- (void) viewWillDisappear___boolean:(BOOL) animated 
{
    [super viewWillDisappear:animated];
}

// (UIViewController) - (void)viewWillLayoutSubviews;
- (void) viewWillLayoutSubviews__
{
    [super viewWillLayoutSubviews];
}

// (UIViewController) - (void)willAnimateRotationToInterfaceOrientation:(UIInterfaceOrientation)toInterfaceOrientation duration:(NSTimeInterval)duration;
- (void) willAnimateRotationToInterfaceOrientation___int_double:(int) toInterfaceOrientation :(double) duration 
{
    [super willAnimateRotationToInterfaceOrientation:toInterfaceOrientation duration:duration];
}

// (UIViewController) - (void)willRotateToInterfaceOrientation:(UIInterfaceOrientation)toInterfaceOrientation duration:(NSTimeInterval)duration;
- (void) willRotateToInterfaceOrientation___int_double:(int) toInterfaceOrientation :(double) duration 
{
    [super willRotateToInterfaceOrientation:toInterfaceOrientation duration:duration];
}

@end

@implementation UISplitViewController (cm_crossmobile_ios_uikit_UISplitViewController)

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UISplitViewController__
{
    return [self init];
}

// direct binding of: @property(nonatomic, readonly, getter=isCollapsed) BOOL collapsed;
- (BOOL) isCollapsed__
{
    return [self isCollapsed];
}

// direct binding of: @property(nonatomic, weak) id<UISplitViewControllerDelegate> delegate;
- (void) setDelegate___crossmobile_ios_uikit_UISplitViewControllerDelegate:(id<UISplitViewControllerDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// direct binding of: @property(nonatomic, weak) id<UISplitViewControllerDelegate> delegate;
- (id<UISplitViewControllerDelegate>) delegate__
{
    id<UISplitViewControllerDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) UISplitViewControllerDisplayMode displayMode;
- (int) displayMode__
{
    return [self displayMode];
}

// direct binding of: @property(nonatomic, assign) CGFloat maximumPrimaryColumnWidth;
- (void) setMaximumPrimaryColumnWidth___double:(double) maximumPrimaryColumnWidth 
{
    [self setMaximumPrimaryColumnWidth:maximumPrimaryColumnWidth];
}

// direct binding of: @property(nonatomic, assign) CGFloat maximumPrimaryColumnWidth;
- (double) maximumPrimaryColumnWidth__
{
    return [self maximumPrimaryColumnWidth];
}

// direct binding of: @property(nonatomic, assign) CGFloat minimumPrimaryColumnWidth;
- (void) setMinimumPrimaryColumnWidth___double:(double) minimumPrimaryColumnWidth 
{
    [self setMinimumPrimaryColumnWidth:minimumPrimaryColumnWidth];
}

// direct binding of: @property(nonatomic, assign) CGFloat minimumPrimaryColumnWidth;
- (double) minimumPrimaryColumnWidth__
{
    return [self minimumPrimaryColumnWidth];
}

// direct binding of: @property(nonatomic) UISplitViewControllerDisplayMode preferredDisplayMode;
- (void) setPreferredDisplayMode___int:(int) preferredDisplayMode 
{
    [self setPreferredDisplayMode:preferredDisplayMode];
}

// direct binding of: @property(nonatomic) UISplitViewControllerDisplayMode preferredDisplayMode;
- (int) preferredDisplayMode__
{
    return [self preferredDisplayMode];
}

// direct binding of: @property(nonatomic, assign) CGFloat preferredPrimaryColumnWidthFraction;
- (void) setPreferredPrimaryColumnWidthFraction___double:(double) preferredPrimaryColumnWidthFraction 
{
    [self setPreferredPrimaryColumnWidthFraction:preferredPrimaryColumnWidthFraction];
}

// direct binding of: @property(nonatomic, assign) CGFloat preferredPrimaryColumnWidthFraction;
- (double) preferredPrimaryColumnWidthFraction__
{
    return [self preferredPrimaryColumnWidthFraction];
}

// direct binding of: @property(nonatomic) BOOL presentsWithGesture;
- (void) setPresentsWithGesture___boolean:(BOOL) presentsWithGesture 
{
    [self setPresentsWithGesture:presentsWithGesture];
}

// direct binding of: @property(nonatomic) BOOL presentsWithGesture;
- (BOOL) presentsWithGesture__
{
    return [self presentsWithGesture];
}

// direct binding of: @property(nonatomic, readonly) CGFloat primaryColumnWidth;
- (double) primaryColumnWidth__
{
    return [self primaryColumnWidth];
}

// direct binding of: @property(nonatomic, copy) NSArray<__kindof UIViewController *> *viewControllers;
- (void) setViewControllers___java_util_List:(NSArray*) viewControllers 
{
    [self setViewControllers:(viewControllers == JAVA_NULL ? nil : viewControllers)];
}

// direct binding of: @property(nonatomic, copy) NSArray<__kindof UIViewController *> *viewControllers;
- (NSArray*) viewControllers__
{
    NSArray* re$ult = [self viewControllers];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (UIBarButtonItem *)displayModeButtonItem;
- (UIBarButtonItem*) displayModeButtonItem__
{
    UIBarButtonItem* re$ult = [self displayModeButtonItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
