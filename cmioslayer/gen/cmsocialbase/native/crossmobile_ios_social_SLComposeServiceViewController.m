// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.social.SLComposeServiceViewController implementation

#import "crossmobile_ios_coregraphics_CGSize.h"
#import "crossmobile_ios_foundation_NSExtensionContext.h"
#import "crossmobile_ios_social_SLComposeServiceViewController.h"
#import "crossmobile_ios_uikit_UIBarButtonItem.h"
#import "crossmobile_ios_uikit_UIEdgeInsets.h"
#import "crossmobile_ios_uikit_UIEvent.h"
#import "crossmobile_ios_uikit_UILayoutSupport.h"
#import "crossmobile_ios_uikit_UINavigationController.h"
#import "crossmobile_ios_uikit_UINavigationItem.h"
#import "crossmobile_ios_uikit_UIResponder.h"
#import "crossmobile_ios_uikit_UISplitViewController.h"
#import "crossmobile_ios_uikit_UIStoryboard.h"
#import "crossmobile_ios_uikit_UIStoryboardSegue.h"
#import "crossmobile_ios_uikit_UIStoryboardUnwindSegueSource.h"
#import "crossmobile_ios_uikit_UITabBarController.h"
#import "crossmobile_ios_uikit_UITabBarItem.h"
#import "crossmobile_ios_uikit_UITextView.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "crossmobile_ios_uikit_UIViewController.h"
#import "java_lang_Number.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Set.h"

@implementation crossmobile_ios_social_SLComposeServiceViewController$Ext

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

// (SLComposeServiceViewController) @property(strong, nonatomic) UIViewController *autoCompletionViewController;
- (void) setAutoCompletionViewController___crossmobile_ios_uikit_UIViewController:(UIViewController*) autoCompletionViewController 
{
    [super setAutoCompletionViewController:(autoCompletionViewController == JAVA_NULL ? nil : autoCompletionViewController)];
}

// (SLComposeServiceViewController) @property(strong, nonatomic) UIViewController *autoCompletionViewController;
- (UIViewController*) autoCompletionViewController__
{
    UIViewController* re$ult = [super autoCompletionViewController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
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

// (SLComposeServiceViewController) @property(strong, nonatomic) NSNumber *charactersRemaining;
- (void) setCharactersRemaining___java_lang_Number:(java_lang_Number*) charactersRemaining 
{
    [super setCharactersRemaining:(charactersRemaining == JAVA_NULL ? nil : charactersRemaining)];
}

// (SLComposeServiceViewController) @property(strong, nonatomic) NSNumber *charactersRemaining;
- (java_lang_Number*) charactersRemaining__
{
    java_lang_Number* re$ult = [super charactersRemaining];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIViewController) @property(nonatomic, readonly) NSArray<__kindof UIViewController *> *childViewControllers;
- (NSArray*) childViewControllers__
{
    NSArray* re$ult = [super childViewControllers];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
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

// (SLComposeServiceViewController) @property(readonly, nonatomic) NSString *contentText;
- (NSString*) contentText__
{
    NSString* re$ult = [super contentText];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
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

// (UIViewController) @property(nonatomic, readonly) BOOL disablesAutomaticKeyboardDismissal;
- (BOOL) disablesAutomaticKeyboardDismissal__
{
    return [super disablesAutomaticKeyboardDismissal];
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

// (SLComposeServiceViewController) @property(copy, nonatomic) NSString *placeholder;
- (void) setPlaceholder___java_lang_String:(NSString*) placeholder 
{
    [super setPlaceholder:(placeholder == JAVA_NULL ? nil : placeholder)];
}

// (SLComposeServiceViewController) @property(copy, nonatomic) NSString *placeholder;
- (NSString*) placeholder__
{
    NSString* re$ult = [super placeholder];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
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

// (SLComposeServiceViewController) @property(readonly, nonatomic) UITextView *textView;
- (UITextView*) textView__
{
    UITextView* re$ult = [super textView];
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

// (SLComposeServiceViewController) - (void)cancel;
- (void) cancel__
{
    [super cancel];
}

// (UIViewController) - (UIViewController *)childViewControllerContainingSegueSource:(UIStoryboardUnwindSegueSource *)source;
- (UIViewController*) childViewControllerContainingSegueSource___crossmobile_ios_uikit_UIStoryboardUnwindSegueSource:(UIStoryboardUnwindSegueSource*) source 
{
    UIViewController* re$ult = [super childViewControllerContainingSegueSource:(source == JAVA_NULL ? nil : source)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (SLComposeServiceViewController) - (NSArray *)configurationItems;
- (NSArray*) configurationItems__
{
    NSArray* re$ult = [super configurationItems];
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

// (SLComposeServiceViewController) - (void)didSelectCancel;
- (void) didSelectCancel__
{
    [super didSelectCancel];
}

// (SLComposeServiceViewController) - (void)didSelectPost;
- (void) didSelectPost__
{
    [super didSelectPost];
}

// (UIViewController) - (void)dismissModalViewControllerAnimated:(BOOL)animated;
- (void) dismissModalViewControllerAnimated___boolean:(BOOL) animated 
{
    [super dismissModalViewControllerAnimated:animated];
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

// (SLComposeServiceViewController) - (BOOL)isContentValid;
- (BOOL) isContentValid__
{
    return [super isContentValid];
}

// (UIResponder) - (BOOL)isFirstResponder;
- (BOOL) isFirstResponder__
{
    return [super isFirstResponder];
}

// (SLComposeServiceViewController) - (UIView *)loadPreviewView;
- (UIView*) loadPreviewView__
{
    UIView* re$ult = [super loadPreviewView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
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

// (SLComposeServiceViewController) - (void)popConfigurationViewController;
- (void) popConfigurationViewController__
{
    [super popConfigurationViewController];
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

// (SLComposeServiceViewController) - (void)presentationAnimationDidFinish;
- (void) presentationAnimationDidFinish__
{
    [super presentationAnimationDidFinish];
}

// (SLComposeServiceViewController) - (void)pushConfigurationViewController:(UIViewController *)viewController;
- (void) pushConfigurationViewController___crossmobile_ios_uikit_UIViewController:(UIViewController*) viewController 
{
    [super pushConfigurationViewController:(viewController == JAVA_NULL ? nil : viewController)];
}

// (SLComposeServiceViewController) - (void)reloadConfigurationItems;
- (void) reloadConfigurationItems__
{
    [super reloadConfigurationItems];
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

// (SLComposeServiceViewController) - (void)validateContent;
- (void) validateContent__
{
    [super validateContent];
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

@implementation SLComposeServiceViewController (cm_crossmobile_ios_social_SLComposeServiceViewController)

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_social_SLComposeServiceViewController__
{
    return [self init];
}

// direct binding of: @property(strong, nonatomic) UIViewController *autoCompletionViewController;
- (void) setAutoCompletionViewController___crossmobile_ios_uikit_UIViewController:(UIViewController*) autoCompletionViewController 
{
    [self setAutoCompletionViewController:(autoCompletionViewController == JAVA_NULL ? nil : autoCompletionViewController)];
}

// direct binding of: @property(strong, nonatomic) UIViewController *autoCompletionViewController;
- (UIViewController*) autoCompletionViewController__
{
    UIViewController* re$ult = [self autoCompletionViewController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(strong, nonatomic) NSNumber *charactersRemaining;
- (void) setCharactersRemaining___java_lang_Number:(java_lang_Number*) charactersRemaining 
{
    [self setCharactersRemaining:(charactersRemaining == JAVA_NULL ? nil : charactersRemaining)];
}

// direct binding of: @property(strong, nonatomic) NSNumber *charactersRemaining;
- (java_lang_Number*) charactersRemaining__
{
    java_lang_Number* re$ult = [self charactersRemaining];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, nonatomic) NSString *contentText;
- (NSString*) contentText__
{
    NSString* re$ult = [self contentText];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(copy, nonatomic) NSString *placeholder;
- (void) setPlaceholder___java_lang_String:(NSString*) placeholder 
{
    [self setPlaceholder:(placeholder == JAVA_NULL ? nil : placeholder)];
}

// direct binding of: @property(copy, nonatomic) NSString *placeholder;
- (NSString*) placeholder__
{
    NSString* re$ult = [self placeholder];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, nonatomic) UITextView *textView;
- (UITextView*) textView__
{
    UITextView* re$ult = [self textView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (void)cancel;
- (void) cancel__
{
    [self cancel];
}

// direct binding of: - (NSArray *)configurationItems;
- (NSArray*) configurationItems__
{
    NSArray* re$ult = [self configurationItems];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (void)didSelectCancel;
- (void) didSelectCancel__
{
    [self didSelectCancel];
}

// direct binding of: - (void)didSelectPost;
- (void) didSelectPost__
{
    [self didSelectPost];
}

// direct binding of: - (BOOL)isContentValid;
- (BOOL) isContentValid__
{
    return [self isContentValid];
}

// direct binding of: - (UIView *)loadPreviewView;
- (UIView*) loadPreviewView__
{
    UIView* re$ult = [self loadPreviewView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (void)popConfigurationViewController;
- (void) popConfigurationViewController__
{
    [self popConfigurationViewController];
}

// direct binding of: - (void)presentationAnimationDidFinish;
- (void) presentationAnimationDidFinish__
{
    [self presentationAnimationDidFinish];
}

// direct binding of: - (void)pushConfigurationViewController:(UIViewController *)viewController;
- (void) pushConfigurationViewController___crossmobile_ios_uikit_UIViewController:(UIViewController*) viewController 
{
    [self pushConfigurationViewController:(viewController == JAVA_NULL ? nil : viewController)];
}

// direct binding of: - (void)reloadConfigurationItems;
- (void) reloadConfigurationItems__
{
    [self reloadConfigurationItems];
}

// direct binding of: - (void)validateContent;
- (void) validateContent__
{
    [self validateContent];
}

@end
