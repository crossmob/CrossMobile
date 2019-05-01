// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIPopoverController implementation

#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_coregraphics_CGSize.h"
#import "crossmobile_ios_uikit_UIBarButtonItem.h"
#import "crossmobile_ios_uikit_UIPopoverController.h"
#import "crossmobile_ios_uikit_UIPopoverControllerDelegate.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "crossmobile_ios_uikit_UIViewController.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UIPopoverController$Ext

// (UIPopoverController) @property(nonatomic, strong) UIViewController *contentViewController;
- (void) setContentViewController___crossmobile_ios_uikit_UIViewController:(UIViewController*) contentViewController 
{
    [super setContentViewController:(contentViewController == JAVA_NULL ? nil : contentViewController)];
}

// (UIPopoverController) @property(nonatomic, strong) UIViewController *contentViewController;
- (UIViewController*) contentViewController__
{
    UIViewController* re$ult = [super contentViewController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIPopoverController) @property(nonatomic, weak) id<UIPopoverControllerDelegate> delegate;
- (void) setDelegate___crossmobile_ios_uikit_UIPopoverControllerDelegate:(id<UIPopoverControllerDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [super setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// (UIPopoverController) @property(nonatomic, weak) id<UIPopoverControllerDelegate> delegate;
- (id<UIPopoverControllerDelegate>) delegate__
{
    id<UIPopoverControllerDelegate> re$ult = [super delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIPopoverController) @property(nonatomic, copy) NSArray<__kindof UIView *> *passthroughViews;
- (void) setPassthroughViews___java_util_List:(NSArray*) passthroughViews 
{
    [super setPassthroughViews:(passthroughViews == JAVA_NULL ? nil : passthroughViews)];
}

// (UIPopoverController) @property(nonatomic, copy) NSArray<__kindof UIView *> *passthroughViews;
- (NSArray*) passthroughViews__
{
    NSArray* re$ult = [super passthroughViews];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIPopoverController) @property(nonatomic, readonly) UIPopoverArrowDirection popoverArrowDirection;
- (JAVA_LONG) popoverArrowDirection__
{
    return [super popoverArrowDirection];
}

// (UIPopoverController) @property(nonatomic) CGSize popoverContentSize;
- (void) setPopoverContentSize___crossmobile_ios_coregraphics_CGSize:(crossmobile_ios_coregraphics_CGSize*) popoverContentSize 
{
    [super setPopoverContentSize:[popoverContentSize getCGSize]];
}

// (UIPopoverController) @property(nonatomic) CGSize popoverContentSize;
- (crossmobile_ios_coregraphics_CGSize*) popoverContentSize__
{
    return [[crossmobile_ios_coregraphics_CGSize alloc] initWithCGSize:[super popoverContentSize]];
}

// (UIPopoverController) @property(nonatomic, readonly, getter=isPopoverVisible) BOOL popoverVisible;
- (BOOL) isPopoverVisible__
{
    return [super isPopoverVisible];
}

// (UIPopoverController) - (void)dismissPopoverAnimated:(BOOL)animated;
- (void) dismissPopoverAnimated___boolean:(BOOL) animated 
{
    [super dismissPopoverAnimated:animated];
}

// (UIPopoverController) - (void)presentPopoverFromBarButtonItem:(UIBarButtonItem *)item permittedArrowDirections:(UIPopoverArrowDirection)arrowDirections animated:(BOOL)animated;
- (void) presentPopoverFromBarButtonItem___crossmobile_ios_uikit_UIBarButtonItem_long_boolean:(UIBarButtonItem*) item :(JAVA_LONG) arrowDirections :(BOOL) animated 
{
    [super presentPopoverFromBarButtonItem:(item == JAVA_NULL ? nil : item) permittedArrowDirections:arrowDirections animated:animated];
}

// (UIPopoverController) - (void)presentPopoverFromRect:(CGRect)rect inView:(UIView *)view permittedArrowDirections:(UIPopoverArrowDirection)arrowDirections animated:(BOOL)animated;
- (void) presentPopoverFromRect___crossmobile_ios_coregraphics_CGRect_crossmobile_ios_uikit_UIView_long_boolean:(crossmobile_ios_coregraphics_CGRect*) rect :(UIView*) view :(JAVA_LONG) arrowDirections :(BOOL) animated 
{
    [super presentPopoverFromRect:[rect getCGRect] inView:(view == JAVA_NULL ? nil : view) permittedArrowDirections:arrowDirections animated:animated];
}

// (UIPopoverController) - (void)setContentViewController:(UIViewController *)viewController animated:(BOOL)animated;
- (void) setContentViewController___crossmobile_ios_uikit_UIViewController_boolean:(UIViewController*) viewController :(BOOL) animated 
{
    [super setContentViewController:(viewController == JAVA_NULL ? nil : viewController) animated:animated];
}

// (UIPopoverController) - (void)setPopoverContentSize:(CGSize)size animated:(BOOL)animated;
- (void) setPopoverContentSize___crossmobile_ios_coregraphics_CGSize_boolean:(crossmobile_ios_coregraphics_CGSize*) size :(BOOL) animated 
{
    [super setPopoverContentSize:[size getCGSize] animated:animated];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValue___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end

@implementation UIPopoverController (cm_crossmobile_ios_uikit_UIPopoverController)

// direct binding of: - (instancetype)initWithContentViewController:(UIViewController *)viewController;
- (instancetype) __init_crossmobile_ios_uikit_UIPopoverController___crossmobile_ios_uikit_UIViewController:(UIViewController*) viewController 
{
    return [self initWithContentViewController:(viewController == JAVA_NULL ? nil : viewController)];
}

// direct binding of: @property(nonatomic, strong) UIViewController *contentViewController;
- (void) setContentViewController___crossmobile_ios_uikit_UIViewController:(UIViewController*) contentViewController 
{
    [self setContentViewController:(contentViewController == JAVA_NULL ? nil : contentViewController)];
}

// direct binding of: @property(nonatomic, strong) UIViewController *contentViewController;
- (UIViewController*) contentViewController__
{
    UIViewController* re$ult = [self contentViewController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, weak) id<UIPopoverControllerDelegate> delegate;
- (void) setDelegate___crossmobile_ios_uikit_UIPopoverControllerDelegate:(id<UIPopoverControllerDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// direct binding of: @property(nonatomic, weak) id<UIPopoverControllerDelegate> delegate;
- (id<UIPopoverControllerDelegate>) delegate__
{
    id<UIPopoverControllerDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, copy) NSArray<__kindof UIView *> *passthroughViews;
- (void) setPassthroughViews___java_util_List:(NSArray*) passthroughViews 
{
    [self setPassthroughViews:(passthroughViews == JAVA_NULL ? nil : passthroughViews)];
}

// direct binding of: @property(nonatomic, copy) NSArray<__kindof UIView *> *passthroughViews;
- (NSArray*) passthroughViews__
{
    NSArray* re$ult = [self passthroughViews];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) UIPopoverArrowDirection popoverArrowDirection;
- (JAVA_LONG) popoverArrowDirection__
{
    return [self popoverArrowDirection];
}

// direct binding of: @property(nonatomic) CGSize popoverContentSize;
- (void) setPopoverContentSize___crossmobile_ios_coregraphics_CGSize:(crossmobile_ios_coregraphics_CGSize*) popoverContentSize 
{
    [self setPopoverContentSize:[popoverContentSize getCGSize]];
}

// direct binding of: @property(nonatomic) CGSize popoverContentSize;
- (crossmobile_ios_coregraphics_CGSize*) popoverContentSize__
{
    return [[crossmobile_ios_coregraphics_CGSize alloc] initWithCGSize:[self popoverContentSize]];
}

// direct binding of: @property(nonatomic, readonly, getter=isPopoverVisible) BOOL popoverVisible;
- (BOOL) isPopoverVisible__
{
    return [self isPopoverVisible];
}

// direct binding of: - (void)dismissPopoverAnimated:(BOOL)animated;
- (void) dismissPopoverAnimated___boolean:(BOOL) animated 
{
    [self dismissPopoverAnimated:animated];
}

// direct binding of: - (void)presentPopoverFromBarButtonItem:(UIBarButtonItem *)item permittedArrowDirections:(UIPopoverArrowDirection)arrowDirections animated:(BOOL)animated;
- (void) presentPopoverFromBarButtonItem___crossmobile_ios_uikit_UIBarButtonItem_long_boolean:(UIBarButtonItem*) item :(JAVA_LONG) arrowDirections :(BOOL) animated 
{
    [self presentPopoverFromBarButtonItem:(item == JAVA_NULL ? nil : item) permittedArrowDirections:arrowDirections animated:animated];
}

// direct binding of: - (void)presentPopoverFromRect:(CGRect)rect inView:(UIView *)view permittedArrowDirections:(UIPopoverArrowDirection)arrowDirections animated:(BOOL)animated;
- (void) presentPopoverFromRect___crossmobile_ios_coregraphics_CGRect_crossmobile_ios_uikit_UIView_long_boolean:(crossmobile_ios_coregraphics_CGRect*) rect :(UIView*) view :(JAVA_LONG) arrowDirections :(BOOL) animated 
{
    [self presentPopoverFromRect:[rect getCGRect] inView:(view == JAVA_NULL ? nil : view) permittedArrowDirections:arrowDirections animated:animated];
}

// direct binding of: - (void)setContentViewController:(UIViewController *)viewController animated:(BOOL)animated;
- (void) setContentViewController___crossmobile_ios_uikit_UIViewController_boolean:(UIViewController*) viewController :(BOOL) animated 
{
    [self setContentViewController:(viewController == JAVA_NULL ? nil : viewController) animated:animated];
}

// direct binding of: - (void)setPopoverContentSize:(CGSize)size animated:(BOOL)animated;
- (void) setPopoverContentSize___crossmobile_ios_coregraphics_CGSize_boolean:(crossmobile_ios_coregraphics_CGSize*) size :(BOOL) animated 
{
    [self setPopoverContentSize:[size getCGSize] animated:animated];
}

@end
