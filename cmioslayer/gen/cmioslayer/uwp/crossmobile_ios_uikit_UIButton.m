// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIButton implementation

#import "crossmobile_ios_coregraphics_CGAffineTransform.h"
#import "crossmobile_ios_coregraphics_CGPoint.h"
#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_coregraphics_CGSize.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_quartzcore_CALayer.h"
#import "crossmobile_ios_uikit_NSLayoutConstraint.h"
#import "crossmobile_ios_uikit_NSLayoutDimension.h"
#import "crossmobile_ios_uikit_NSLayoutXAxisAnchor.h"
#import "crossmobile_ios_uikit_NSLayoutYAxisAnchor.h"
#import "crossmobile_ios_uikit_UIButton.h"
#import "crossmobile_ios_uikit_UIColor.h"
#import "crossmobile_ios_uikit_UIControlDelegate.h"
#import "crossmobile_ios_uikit_UIEdgeInsets.h"
#import "crossmobile_ios_uikit_UIEvent.h"
#import "crossmobile_ios_uikit_UIGestureRecognizer.h"
#import "crossmobile_ios_uikit_UIImage.h"
#import "crossmobile_ios_uikit_UIImageView.h"
#import "crossmobile_ios_uikit_UILabel.h"
#import "crossmobile_ios_uikit_UILayoutGuide.h"
#import "crossmobile_ios_uikit_UIResponder.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "crossmobile_ios_uikit_UIWindow.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_lang_reflect_Method.h"
#import "java_util_List.h"
#import "java_util_Map.h"
#import "java_util_Set.h"

@implementation crossmobile_ios_uikit_UIButton$Ext

// (UIButton) @property(nonatomic) BOOL adjustsImageWhenDisabled;
- (void) setAdjustsImageWhenDisabled___boolean:(BOOL) adjustsImageWhenDisabled 
{
    [super setAdjustsImageWhenDisabled:adjustsImageWhenDisabled];
}

// (UIButton) @property(nonatomic) BOOL adjustsImageWhenDisabled;d;
- (BOOL) adjustsImageWhenDisabled__
{
    return [super adjustsImageWhenDisabled];
}

// (UIButton) @property(nonatomic) BOOL adjustsImageWhenHighlighted;
- (void) setAdjustsImageWhenHighlighted___boolean:(BOOL) adjustsImageWhenHighlighted 
{
    [super setAdjustsImageWhenHighlighted:adjustsImageWhenHighlighted];
}

// (UIButton) @property(nonatomic) BOOL adjustsImageWhenHighlighted;
- (BOOL) adjustsImageWhenHighlighted__
{
    return [super adjustsImageWhenHighlighted];
}

// (UIControl) @property(nonatomic, readonly) NSSet *allTargets;
- (NSSet*) allTargets__
{
    NSSet* re$ult = [super allTargets];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(nonatomic) CGFloat alpha;
- (void) setAlpha___double:(double) alpha 
{
    [super setAlpha:alpha];
}

// (UIView) @property(nonatomic) CGFloat alpha;
- (double) alpha__
{
    return [super alpha];
}

// (UIView) @property(nonatomic) BOOL autoresizesSubviews;
- (void) setAutoresizesSubviews___boolean:(BOOL) autoresizesSubviews 
{
    [super setAutoresizesSubviews:autoresizesSubviews];
}

// (UIView) @property(nonatomic) BOOL autoresizesSubviews;
- (BOOL) autoresizesSubviews__
{
    return [super autoresizesSubviews];
}

// (UIView) @property(nonatomic) UIViewAutoresizing autoresizingMask;
- (void) setAutoresizingMask___int:(int) autoresizingMask 
{
    [super setAutoresizingMask:autoresizingMask];
}

// (UIView) @property(nonatomic) UIViewAutoresizing autoresizingMask;
- (int) autoresizingMask__
{
    return [super autoresizingMask];
}

// (UIView) @property(nonatomic, copy) UIColor *backgroundColor;
- (void) setBackgroundColor___crossmobile_ios_uikit_UIColor:(UIColor*) backgroundColor 
{
    [super setBackgroundColor:(backgroundColor == JAVA_NULL ? nil : backgroundColor)];
}

// (UIView) @property(nonatomic, copy) UIColor *backgroundColor;
- (UIColor*) backgroundColor__
{
    UIColor* re$ult = [super backgroundColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(readonly, strong) NSLayoutYAxisAnchor *bottomAnchor;
- (NSLayoutYAxisAnchor*) bottomAnchor__
{
    NSLayoutYAxisAnchor* re$ult = [super bottomAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(nonatomic) CGRect bounds;
- (void) setBounds___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) bounds 
{
    [super setBounds:[bounds getCGRect]];
}

// (UIView) @property(nonatomic) CGRect bounds;
- (crossmobile_ios_coregraphics_CGRect*) bounds__
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:[super bounds]];
}

// (UIButton) @property(nonatomic, readonly) UIButtonType buttonType;
- (int) buttonType__
{
    return [super buttonType];
}

// (UIView) @property(nonatomic) CGPoint center;
- (void) setCenter___crossmobile_ios_coregraphics_CGPoint:(crossmobile_ios_coregraphics_CGPoint*) center 
{
    [super setCenter:[center getCGPoint]];
}

// (UIView) @property(nonatomic) CGPoint center;
- (crossmobile_ios_coregraphics_CGPoint*) center__
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[super center]];
}

// (UIView) @property(readonly, strong) NSLayoutXAxisAnchor *centerXAnchor;
- (NSLayoutXAxisAnchor*) centerXAnchor__
{
    NSLayoutXAxisAnchor* re$ult = [super centerXAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(readonly, strong) NSLayoutYAxisAnchor *centerYAnchor;
- (NSLayoutYAxisAnchor*) centerYAnchor__
{
    NSLayoutYAxisAnchor* re$ult = [super centerYAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(nonatomic) BOOL clearsContextBeforeDrawing;
- (void) setClearsContextBeforeDrawing___boolean:(BOOL) clearsContextBeforeDrawing 
{
    [super setClearsContextBeforeDrawing:clearsContextBeforeDrawing];
}

// (UIView) @property(nonatomic) BOOL clipsToBounds;
- (void) setClipsToBounds___boolean:(BOOL) clipsToBounds 
{
    [super setClipsToBounds:clipsToBounds];
}

// (UIView) @property(nonatomic) BOOL clipsToBounds;
- (BOOL) clipsToBounds__
{
    return [super clipsToBounds];
}

// (UIView) @property(nonatomic, readonly) NSArray<__kindof NSLayoutConstraint *> *constraints;
- (NSArray*) constraints__
{
    NSArray* re$ult = [super constraints];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIButton) @property(nonatomic) UIEdgeInsets contentEdgeInsets;
- (void) setContentEdgeInsets___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) contentEdgeInsets 
{
    [super setContentEdgeInsets:[contentEdgeInsets getUIEdgeInsets]];
}

// (UIButton) @property(nonatomic) UIEdgeInsets contentEdgeInsets;
- (crossmobile_ios_uikit_UIEdgeInsets*) contentEdgeInsets__
{
    return [[crossmobile_ios_uikit_UIEdgeInsets alloc] initWithUIEdgeInsets:[super contentEdgeInsets]];
}

// (UIControl) @property(nonatomic) UIControlContentHorizontalAlignment contentHorizontalAlignment;
- (void) setContentHorizontalAlignment___int:(int) contentHorizontalAlignment 
{
    [super setContentHorizontalAlignment:contentHorizontalAlignment];
}

// (UIControl) @property(nonatomic) UIControlContentHorizontalAlignment contentHorizontalAlignment;
- (int) contentHorizontalAlignment__
{
    return [super contentHorizontalAlignment];
}

// (UIView) @property(nonatomic) UIViewContentMode contentMode;
- (void) setContentMode___int:(int) contentMode 
{
    [super setContentMode:contentMode];
}

// (UIView) @property(nonatomic) UIViewContentMode contentMode;
- (int) contentMode__
{
    return [super contentMode];
}

// (UIControl) @property(nonatomic) UIControlContentVerticalAlignment contentVerticalAlignment;
- (void) setContentVerticalAlignment___int:(int) contentVerticalAlignment 
{
    [super setContentVerticalAlignment:contentVerticalAlignment];
}

// (UIControl) @property(nonatomic) UIControlContentVerticalAlignment contentVerticalAlignment;
- (int) contentVerticalAlignment__
{
    return [super contentVerticalAlignment];
}

// (UIButton) @property(nonatomic, readonly, strong) UIImage *currentBackgroundImage;
- (UIImage*) currentBackgroundImage__
{
    UIImage* re$ult = [super currentBackgroundImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIButton) @property(nonatomic, readonly, strong) UIImage *currentImage;
- (UIImage*) currentImage__
{
    UIImage* re$ult = [super currentImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIButton) @property(nonatomic, readonly, strong) NSString *currentTitle;
- (NSString*) currentTitle__
{
    NSString* re$ult = [super currentTitle];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIButton) @property(nonatomic, readonly, strong) UIColor *currentTitleColor;
- (UIColor*) currentTitleColor__
{
    UIColor* re$ult = [super currentTitleColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIButton) @property(nonatomic, readonly, strong) UIColor *currentTitleShadowColor;
- (UIColor*) currentTitleShadowColor__
{
    UIColor* re$ult = [super currentTitleShadowColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIControl) @property(nonatomic, getter=isEnabled) BOOL enabled;
- (void) setEnabled___boolean:(BOOL) enabled 
{
    [super setEnabled:enabled];
}

// (UIControl) @property(nonatomic, getter=isEnabled) BOOL enabled;
- (BOOL) isEnabled__
{
    return [super isEnabled];
}

// (UIView) @property(nonatomic) CGRect frame;
- (void) setFrame___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame 
{
    [super setFrame:[frame getCGRect]];
}

// (UIView) @property(nonatomic) CGRect frame;
- (crossmobile_ios_coregraphics_CGRect*) frame__
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:[super frame]];
}

// (UIView) @property(nonatomic, copy) NSArray<__kindof UIGestureRecognizer *> *gestureRecognizers;
- (void) setGestureRecognizers___java_util_List:(NSArray*) gestureRecognizers 
{
    [super setGestureRecognizers:(gestureRecognizers == JAVA_NULL ? nil : gestureRecognizers)];
}

// (UIView) @property(nonatomic, copy) NSArray<__kindof UIGestureRecognizer *> *gestureRecognizers;
- (NSArray*) gestureRecognizers__
{
    NSArray* re$ult = [super gestureRecognizers];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(readonly, strong) NSLayoutDimension *heightAnchor;
- (NSLayoutDimension*) heightAnchor__
{
    NSLayoutDimension* re$ult = [super heightAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(nonatomic, getter=isHidden) BOOL hidden;
- (void) setHidden___boolean:(BOOL) hidden 
{
    [super setHidden:hidden];
}

// (UIView) @property(nonatomic, getter=isHidden) BOOL hidden;
- (BOOL) isHidden__
{
    return [super isHidden];
}

// (UIControl) @property(nonatomic, getter=isHighlighted) BOOL highlighted;
- (void) setHighlighted___boolean:(BOOL) highlighted 
{
    [super setHighlighted:highlighted];
}

// (UIControl) @property(nonatomic, getter=isHighlighted) BOOL highlighted;
- (BOOL) isHighlighted__
{
    return [super isHighlighted];
}

// (UIButton) @property(nonatomic) UIEdgeInsets imageEdgeInsets;
- (void) setImageEdgeInsets___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) imageEdgeInsets 
{
    [super setImageEdgeInsets:[imageEdgeInsets getUIEdgeInsets]];
}

// (UIButton) @property(nonatomic) UIEdgeInsets imageEdgeInsets;
- (crossmobile_ios_uikit_UIEdgeInsets*) imageEdgeInsets__
{
    return [[crossmobile_ios_uikit_UIEdgeInsets alloc] initWithUIEdgeInsets:[super imageEdgeInsets]];
}

// (UIButton) @property(nonatomic, readonly, strong) UIImageView *imageView;
- (UIImageView*) imageView__
{
    UIImageView* re$ult = [super imageView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(nonatomic) BOOL insetsLayoutMarginsFromSafeArea;
- (void) setInsetsLayoutMarginsFromSafeArea___boolean:(BOOL) insetsLayoutMarginsFromSafeArea 
{
    [super setInsetsLayoutMarginsFromSafeArea:insetsLayoutMarginsFromSafeArea];
}

// (UIView) @property(nonatomic) BOOL insetsLayoutMarginsFromSafeArea;
- (BOOL) insetsLayoutMarginsFromSafeArea__
{
    return [super insetsLayoutMarginsFromSafeArea];
}

// (UIView) @property(nonatomic, readonly, strong) CALayer *layer;
- (CALayer*) layer__
{
    CALayer* re$ult = [super layer];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(nonatomic) UIEdgeInsets layoutMargins;
- (void) setLayoutMargins___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) layoutMargins 
{
    [super setLayoutMargins:[layoutMargins getUIEdgeInsets]];
}

// (UIView) @property(nonatomic) UIEdgeInsets layoutMargins;
- (crossmobile_ios_uikit_UIEdgeInsets*) layoutMargins__
{
    return [[crossmobile_ios_uikit_UIEdgeInsets alloc] initWithUIEdgeInsets:[super layoutMargins]];
}

// (UIView) @property(readonly, strong) UILayoutGuide *layoutMarginsGuide;
- (UILayoutGuide*) layoutMarginsGuide__
{
    UILayoutGuide* re$ult = [super layoutMarginsGuide];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(readonly, strong) NSLayoutXAxisAnchor *leadingAnchor;
- (NSLayoutXAxisAnchor*) leadingAnchor__
{
    NSLayoutXAxisAnchor* re$ult = [super leadingAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(readonly, strong) NSLayoutXAxisAnchor *leftAnchor;
- (NSLayoutXAxisAnchor*) leftAnchor__
{
    NSLayoutXAxisAnchor* re$ult = [super leftAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(nonatomic, getter=isMultipleTouchEnabled) BOOL multipleTouchEnabled;
- (void) setMultipleTouchEnabled___boolean:(BOOL) multipleTouchEnabled 
{
    [super setMultipleTouchEnabled:multipleTouchEnabled];
}

// (UIView) @property(nonatomic, getter=isMultipleTouchEnabled) BOOL multipleTouchEnabled;
- (BOOL) isMultipleTouchEnabled__
{
    return [super isMultipleTouchEnabled];
}

// (UIView) @property(nonatomic, getter=isOpaque) BOOL opaque;
- (void) setOpaque___boolean:(BOOL) opaque 
{
    [super setOpaque:opaque];
}

// (UIView) @property(nonatomic, getter=isOpaque) BOOL opaque;
- (BOOL) isOpaque__
{
    return [super isOpaque];
}

// (UIView) @property(nonatomic) BOOL preservesSuperviewLayoutMargins;
- (void) setPreservesSuperviewLayoutMargins___boolean:(BOOL) preservesSuperviewLayoutMargins 
{
    [super setPreservesSuperviewLayoutMargins:preservesSuperviewLayoutMargins];
}

// (UIView) @property(nonatomic) BOOL preservesSuperviewLayoutMargins;
- (BOOL) preservesSuperviewLayoutMargins__
{
    return [super preservesSuperviewLayoutMargins];
}

// (UIView) @property(nonatomic, copy) NSString *restorationIdentifier;
- (void) setRestorationIdentifier___java_lang_String:(NSString*) restorationIdentifier 
{
    [super setRestorationIdentifier:(restorationIdentifier == JAVA_NULL ? nil : restorationIdentifier)];
}

// (UIView) @property(nonatomic, copy) NSString *restorationIdentifier;
- (NSString*) restorationIdentifier__
{
    NSString* re$ult = [super restorationIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(readonly, strong) NSLayoutXAxisAnchor *rightAnchor;
- (NSLayoutXAxisAnchor*) rightAnchor__
{
    NSLayoutXAxisAnchor* re$ult = [super rightAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(nonatomic, readonly) UIEdgeInsets safeAreaInsets;
- (crossmobile_ios_uikit_UIEdgeInsets*) safeAreaInsets__
{
    return [[crossmobile_ios_uikit_UIEdgeInsets alloc] initWithUIEdgeInsets:[super safeAreaInsets]];
}

// (UIView) @property(nonatomic, readonly, strong) UILayoutGuide *safeAreaLayoutGuide;
- (UILayoutGuide*) safeAreaLayoutGuide__
{
    UILayoutGuide* re$ult = [super safeAreaLayoutGuide];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIControl) @property(nonatomic, getter=isSelected) BOOL selected;
- (void) setSelected___boolean:(BOOL) selected 
{
    [super setSelected:selected];
}

// (UIControl) @property(nonatomic, getter=isSelected) BOOL selected;
- (BOOL) isSelected__
{
    return [super isSelected];
}

// (UIButton) @property(nonatomic) BOOL showsTouchWhenHighlighted;
- (void) setShowsTouchWhenHighlighted___boolean:(BOOL) showsTouchWhenHighlighted 
{
    [super setShowsTouchWhenHighlighted:showsTouchWhenHighlighted];
}

// (UIButton) @property(nonatomic) BOOL showsTouchWhenHighlighted;
- (BOOL) showsTouchWhenHighlighted__
{
    return [super showsTouchWhenHighlighted];
}

// (UIControl) @property(nonatomic, readonly) UIControlState state;
- (int) state__
{
    return [super state];
}

// (UIView) @property(nonatomic, readonly, copy) NSArray<__kindof UIView *> *subviews;
- (NSArray*) subviews__
{
    NSArray* re$ult = [super subviews];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(nonatomic, readonly) UIView *superview;
- (UIView*) superview__
{
    UIView* re$ult = [super superview];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(nonatomic) NSInteger tag;
- (void) setTag___int:(int) tag 
{
    [super setTag:tag];
}

// (UIView) @property(nonatomic) NSInteger tag;
- (int) tag__
{
    return [super tag];
}

// (UIView) @property(nonatomic) UIViewTintAdjustmentMode tintAdjustmentMode;
- (void) setTintAdjustmentMode___int:(int) tintAdjustmentMode 
{
    [super setTintAdjustmentMode:tintAdjustmentMode];
}

// (UIView) @property(nonatomic) UIViewTintAdjustmentMode tintAdjustmentMode;
- (int) tintAdjustmentMode__
{
    return [super tintAdjustmentMode];
}

// (UIView) @property(nonatomic, strong) UIColor *tintColor;
- (void) setTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) tintColor 
{
    [super setTintColor:(tintColor == JAVA_NULL ? nil : tintColor)];
}

// (UIView) @property(nonatomic, strong) UIColor *tintColor;
- (UIColor*) tintColor__
{
    UIColor* re$ult = [super tintColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIButton) @property(nonatomic) UIEdgeInsets titleEdgeInsets;
- (void) setTitleEdgeInsets___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) titleEdgeInsets 
{
    [super setTitleEdgeInsets:[titleEdgeInsets getUIEdgeInsets]];
}

// (UIButton) @property(nonatomic) UIEdgeInsets titleEdgeInsets;
- (crossmobile_ios_uikit_UIEdgeInsets*) titleEdgeInsets__
{
    return [[crossmobile_ios_uikit_UIEdgeInsets alloc] initWithUIEdgeInsets:[super titleEdgeInsets]];
}

// (UIButton) @property(nonatomic, readonly, strong) UILabel *titleLabel;
- (UILabel*) titleLabel__
{
    UILabel* re$ult = [super titleLabel];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(readonly, strong) NSLayoutYAxisAnchor *topAnchor;
- (NSLayoutYAxisAnchor*) topAnchor__
{
    NSLayoutYAxisAnchor* re$ult = [super topAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(readonly, strong) NSLayoutXAxisAnchor *trailingAnchor;
- (NSLayoutXAxisAnchor*) trailingAnchor__
{
    NSLayoutXAxisAnchor* re$ult = [super trailingAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(nonatomic) CGAffineTransform transform;
- (void) setTransform___crossmobile_ios_coregraphics_CGAffineTransform:(crossmobile_ios_coregraphics_CGAffineTransform*) transform 
{
    [super setTransform:[transform getCGAffineTransform]];
}

// (UIView) @property(nonatomic) CGAffineTransform transform;
- (crossmobile_ios_coregraphics_CGAffineTransform*) transform__
{
    return [[crossmobile_ios_coregraphics_CGAffineTransform alloc] initWithCGAffineTransform:[super transform]];
}

// (UIView) @property(nonatomic) BOOL translatesAutoresizingMaskIntoConstraints;
- (void) setTranslatesAutoresizingMaskIntoConstraints___boolean:(BOOL) translatesAutoresizingMaskIntoConstraints 
{
    [super setTranslatesAutoresizingMaskIntoConstraints:translatesAutoresizingMaskIntoConstraints];
}

// (UIView) @property(nonatomic) BOOL translatesAutoresizingMaskIntoConstraints;
- (BOOL) translatesAutoresizingMaskIntoConstraints__
{
    return [super translatesAutoresizingMaskIntoConstraints];
}

// (UIView) @property(nonatomic, getter=isUserInteractionEnabled) BOOL userInteractionEnabled;
- (void) setUserInteractionEnabled___boolean:(BOOL) userInteractionEnabled 
{
    [super setUserInteractionEnabled:userInteractionEnabled];
}

// (UIView) @property(nonatomic, getter=isUserInteractionEnabled) BOOL userInteractionEnabled;
- (BOOL) isUserInteractionEnabled__
{
    return [super isUserInteractionEnabled];
}

// (UIView) @property(nonatomic, readonly) UIUserInterfaceLayoutDirection userInterfaceLayoutDirection;
- (int) userInterfaceLayoutDirection__
{
    return [super userInterfaceLayoutDirection];
}

// (UIView) @property(readonly, strong) UIView *viewForFirstBaselineLayout;
- (UIView*) viewForFirstBaselineLayout__
{
    UIView* re$ult = [super viewForFirstBaselineLayout];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(readonly, strong) UIView *viewForLastBaselineLayout;
- (UIView*) viewForLastBaselineLayout__
{
    UIView* re$ult = [super viewForLastBaselineLayout];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(readonly, strong) NSLayoutDimension *widthAnchor;
- (NSLayoutDimension*) widthAnchor__
{
    NSLayoutDimension* re$ult = [super widthAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(nonatomic, readonly) UIWindow *window;
- (UIWindow*) window__
{
    UIWindow* re$ult = [super window];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) - (void)addConstraint:(NSLayoutConstraint *)constraint;
- (void) addConstraint___crossmobile_ios_uikit_NSLayoutConstraint:(NSLayoutConstraint*) constraint 
{
    [super addConstraint:(constraint == JAVA_NULL ? nil : constraint)];
}

// (UIView) - (void)addConstraints:(NSArray<__kindof NSLayoutConstraint *> *)constraints;
- (void) addConstraints___java_util_List:(NSArray*) constraints 
{
    [super addConstraints:(constraints == JAVA_NULL ? nil : constraints)];
}

// (UIView) - (void)addGestureRecognizer:(UIGestureRecognizer *)gestureRecognizer;
- (void) addGestureRecognizer___crossmobile_ios_uikit_UIGestureRecognizer:(UIGestureRecognizer*) gestureRecognizer 
{
    [super addGestureRecognizer:(gestureRecognizer == JAVA_NULL ? nil : gestureRecognizer)];
}

// (UIView) - (void)addLayoutGuide:(UILayoutGuide *)layoutGuide;
- (void) addLayoutGuide___crossmobile_ios_uikit_UILayoutGuide:(UILayoutGuide*) layoutGuide 
{
    [super addLayoutGuide:(layoutGuide == JAVA_NULL ? nil : layoutGuide)];
}

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
}

// (UIView) - (void)addSubview:(UIView *)view;
- (void) addSubview___crossmobile_ios_uikit_UIView:(UIView*) view 
{
    [super addSubview:(view == JAVA_NULL ? nil : view)];
}

// (UIControl) - (void)addTarget:(id)target action:(SEL)action forControlEvents:(UIControlEvents)controlEvents;
- (void) addTarget___crossmobile_ios_uikit_UIControlDelegate_int:(id<crossmobile_ios_uikit_UIControlDelegate>) target :(int) controlEvents 
{
    if (target == JAVA_NULL)
        return;
    if (controlEvents == 0)
        return;
    objc_setAssociatedObject(self, (void*)target, target, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [super addTarget:(target == JAVA_NULL ? nil : target) action:@selector(exec___crossmobile_ios_uikit_UIControl_crossmobile_ios_uikit_UIEvent::) forControlEvents:controlEvents];
}

// (UIButton) - (UIImage *)backgroundImageForState:(UIControlState)state;
- (UIImage*) backgroundImageForState___int:(int) state 
{
    UIImage* re$ult = [super backgroundImageForState:state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIResponder) - (BOOL)becomeFirstResponder;
- (BOOL) becomeFirstResponder__
{
    return [super becomeFirstResponder];
}

// (UIView) - (void)bringSubviewToFront:(UIView *)view;
- (void) bringSubviewToFront___crossmobile_ios_uikit_UIView:(UIView*) view 
{
    [super bringSubviewToFront:(view == JAVA_NULL ? nil : view)];
}

// (UIView) - (UILayoutPriority)contentCompressionResistancePriorityForAxis:(UILayoutConstraintAxis)axis;
- (float) contentCompressionResistancePriorityForAxis___int:(int) axis 
{
    return [super contentCompressionResistancePriorityForAxis:axis];
}

// (UIView) - (UILayoutPriority)contentHuggingPriorityForAxis:(UILayoutConstraintAxis)axis;
- (float) contentHuggingPriorityForAxis___int:(int) axis 
{
    return [super contentHuggingPriorityForAxis:axis];
}

// (UIView) - (CGPoint)convertPoint:(CGPoint)point fromView:(UIView *)view;
- (crossmobile_ios_coregraphics_CGPoint*) convertPointFromView___crossmobile_ios_coregraphics_CGPoint_crossmobile_ios_uikit_UIView:(crossmobile_ios_coregraphics_CGPoint*) point :(UIView*) view 
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[super convertPoint:[point getCGPoint] fromView:(view == JAVA_NULL ? nil : view)]];
}

// (UIView) - (CGPoint)convertPoint:(CGPoint)point toView:(UIView *)view;
- (crossmobile_ios_coregraphics_CGPoint*) convertPointToView___crossmobile_ios_coregraphics_CGPoint_crossmobile_ios_uikit_UIView:(crossmobile_ios_coregraphics_CGPoint*) point :(UIView*) view 
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[super convertPoint:[point getCGPoint] toView:(view == JAVA_NULL ? nil : view)]];
}

// (UIView) - (CGRect)convertRect:(CGRect)rect fromView:(UIView *)view;
- (crossmobile_ios_coregraphics_CGRect*) convertRectFromView___crossmobile_ios_coregraphics_CGRect_crossmobile_ios_uikit_UIView:(crossmobile_ios_coregraphics_CGRect*) rect :(UIView*) view 
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:[super convertRect:[rect getCGRect] fromView:(view == JAVA_NULL ? nil : view)]];
}

// (UIView) - (CGRect)convertRect:(CGRect)rect toView:(UIView *)view;
- (crossmobile_ios_coregraphics_CGRect*) convertRectToView___crossmobile_ios_coregraphics_CGRect_crossmobile_ios_uikit_UIView:(crossmobile_ios_coregraphics_CGRect*) rect :(UIView*) view 
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:[super convertRect:[rect getCGRect] toView:(view == JAVA_NULL ? nil : view)]];
}

// (UIView) - (void)didAddSubview:(UIView *)subview;
- (void) didAddSubview___crossmobile_ios_uikit_UIView:(UIView*) subview 
{
    [super didAddSubview:(subview == JAVA_NULL ? nil : subview)];
}

// (UIView) - (void)didMoveToSuperview;
- (void) didMoveToSuperview__
{
    [super didMoveToSuperview];
}

// (UIView) - (void)didMoveToWindow;
- (void) didMoveToWindow__
{
    [super didMoveToWindow];
}

// (UIView) - (void)drawRect:(CGRect)rect;
- (void) drawRect___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) rect 
{
    [super drawRect:[rect getCGRect]];
}

// (UIView) - (UIView *)hitTest:(CGPoint)point withEvent:(UIEvent *)event;
- (UIView*) hitTest___crossmobile_ios_coregraphics_CGPoint_crossmobile_ios_uikit_UIEvent:(crossmobile_ios_coregraphics_CGPoint*) point :(UIEvent*) event 
{
    UIView* re$ult = [super hitTest:[point getCGPoint] withEvent:(event == JAVA_NULL ? nil : event)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIButton) - (UIImage *)imageForState:(UIControlState)state;
- (UIImage*) imageForState___int:(int) state 
{
    UIImage* re$ult = [super imageForState:state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) - (void)insertSubview:(UIView *)view atIndex:(NSInteger)index;
- (void) insertSubview___crossmobile_ios_uikit_UIView_int:(UIView*) view :(int) index 
{
    [super insertSubview:(view == JAVA_NULL ? nil : view) atIndex:index];
}

// (UIView) - (CGSize)intrinsicContentSize;
- (crossmobile_ios_coregraphics_CGSize*) intrinsicContentSize__
{
    return [[crossmobile_ios_coregraphics_CGSize alloc] initWithCGSize:[super intrinsicContentSize]];
}

// (UIView) - (void)invalidateIntrinsicContentSize;
- (void) invalidateIntrinsicContentSize__
{
    [super invalidateIntrinsicContentSize];
}

// (UIResponder) - (BOOL)isFirstResponder;
- (BOOL) isFirstResponder__
{
    return [super isFirstResponder];
}

// (UIView) - (void)layoutIfNeeded;
- (void) layoutIfNeeded__
{
    [super layoutIfNeeded];
}

// (UIView) - (void)layoutMarginsDidChange;
- (void) layoutMarginsDidChange__
{
    [super layoutMarginsDidChange];
}

// (UIView) - (void)layoutSubviews;
- (void) layoutSubviews__
{
    [super layoutSubviews];
}

// (UIView) - (BOOL)needsUpdateConstraints;
- (BOOL) needsUpdateConstraints__
{
    return [super needsUpdateConstraints];
}

// (UIResponder) - (UIResponder *)nextResponder;
- (UIResponder*) nextResponder__
{
    UIResponder* re$ult = [super nextResponder];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (void)observeValueForKeyPath:(NSString *)keyPath ofObject:(id)object change:(NSDictionary<NSKeyValueChangeKey, id> *)change context:(void *)context;
- (void) observeValueForKeyPath___java_lang_String_java_lang_Object_java_util_Map_java_lang_Object:(NSString*) keyPath :(id) object :(NSDictionary*) change :(id) context 
{
    [super observeValueForKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) ofObject:(object == JAVA_NULL ? nil : object) change:(change == JAVA_NULL ? nil : change) context:(context == JAVA_NULL ? nil : context)];
}

// (UIView) - (BOOL)pointInside:(CGPoint)point withEvent:(UIEvent *)event;
- (BOOL) pointInside___crossmobile_ios_coregraphics_CGPoint_crossmobile_ios_uikit_UIEvent:(crossmobile_ios_coregraphics_CGPoint*) point :(UIEvent*) event 
{
    return [super pointInside:[point getCGPoint] withEvent:(event == JAVA_NULL ? nil : event)];
}

// (UIView) - (void)removeConstraint:(NSLayoutConstraint *)constraint;
- (void) removeConstraint___crossmobile_ios_uikit_NSLayoutConstraint:(NSLayoutConstraint*) constraint 
{
    [super removeConstraint:(constraint == JAVA_NULL ? nil : constraint)];
}

// (UIView) - (void)removeConstraints:(NSArray<__kindof NSLayoutConstraint *> *)constraints;
- (void) removeConstraints___java_util_List:(NSArray*) constraints 
{
    [super removeConstraints:(constraints == JAVA_NULL ? nil : constraints)];
}

// (UIView) - (void)removeFromSuperview;
- (void) removeFromSuperview__
{
    [super removeFromSuperview];
}

// (UIView) - (void)removeGestureRecognizer:(UIGestureRecognizer *)gestureRecognizer;
- (void) removeGestureRecognizer___crossmobile_ios_uikit_UIGestureRecognizer:(UIGestureRecognizer*) gestureRecognizer 
{
    [super removeGestureRecognizer:(gestureRecognizer == JAVA_NULL ? nil : gestureRecognizer)];
}

// (UIView) - (void)removeLayoutGuide:(UILayoutGuide *)layoutGuide;
- (void) removeLayoutGuide___crossmobile_ios_uikit_UILayoutGuide:(UILayoutGuide*) layoutGuide 
{
    [super removeLayoutGuide:(layoutGuide == JAVA_NULL ? nil : layoutGuide)];
}

// (NSObject) - (void)removeObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath;
- (void) removeObserver___crossmobile_ios_foundation_NSObject_java_lang_String:(NSObject*) observer :(NSString*) keyPath 
{
    [super removeObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath)];
}

// (NSObject) - (void)removeObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath context:(void *)context;
- (void) removeObserver___crossmobile_ios_foundation_NSObject_java_lang_String_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(id) context 
{
    [super removeObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) context:(context == JAVA_NULL ? nil : context)];
}

// (UIControl) - (void)removeTarget:(id)target action:(SEL)action forControlEvents:(UIControlEvents)controlEvents;
- (void) removeTarget___crossmobile_ios_uikit_UIControlDelegate_int:(id<crossmobile_ios_uikit_UIControlDelegate>) target :(int) controlEvents 
{
    if (target == JAVA_NULL)
        return;
    if (controlEvents == 0)
        return;
    objc_setAssociatedObject(self, (void*)target, nil, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [super removeTarget:(target == JAVA_NULL ? nil : target) action:@selector(exec___crossmobile_ios_uikit_UIControl_crossmobile_ios_uikit_UIEvent::) forControlEvents:controlEvents];
}

// (UIResponder) - (BOOL)resignFirstResponder;
- (BOOL) resignFirstResponder__
{
    return [super resignFirstResponder];
}

// (UIControl) - (void)sendActionsForControlEvents:(UIControlEvents)controlEvents;
- (void) sendActionsForControlEvents___int:(int) controlEvents 
{
    [super sendActionsForControlEvents:controlEvents];
}

// (UIView) - (void)sendSubviewToBack:(UIView *)view;
- (void) sendSubviewToBack___crossmobile_ios_uikit_UIView:(UIView*) view 
{
    [super sendSubviewToBack:(view == JAVA_NULL ? nil : view)];
}

// (UIButton) - (void)setBackgroundImage:(UIImage *)image forState:(UIControlState)state;
- (void) setBackgroundImage___crossmobile_ios_uikit_UIImage_int:(UIImage*) image :(int) state 
{
    [super setBackgroundImage:(image == JAVA_NULL ? nil : image) forState:state];
}

// (UIView) - (void)setContentCompressionResistancePriority:(UILayoutPriority)priority forAxis:(UILayoutConstraintAxis)axis;
- (void) setContentCompressionResistancePriority___float_int:(float) priority :(int) axis 
{
    [super setContentCompressionResistancePriority:priority forAxis:axis];
}

// (UIView) - (void)setContentHuggingPriority:(UILayoutPriority)priority forAxis:(UILayoutConstraintAxis)axis;
- (void) setContentHuggingPriority___float_int:(float) priority :(int) axis 
{
    [super setContentHuggingPriority:priority forAxis:axis];
}

// (UIButton) - (void)setImage:(UIImage *)image forState:(UIControlState)state;
- (void) setImage___crossmobile_ios_uikit_UIImage_int:(UIImage*) image :(int) state 
{
    [super setImage:(image == JAVA_NULL ? nil : image) forState:state];
}

// (UIView) - (void)setNeedsDisplay;
- (void) setNeedsDisplay__
{
    [super setNeedsDisplay];
}

// (UIView) - (void)setNeedsLayout;
- (void) setNeedsLayout__
{
    [super setNeedsLayout];
}

// (UIView) - (void)setNeedsUpdateConstraints;
- (void) setNeedsUpdateConstraints__
{
    [super setNeedsUpdateConstraints];
}

// (UIButton) - (void)setTitle:(NSString *)title forState:(UIControlState)state;
- (void) setTitle___java_lang_String_int:(NSString*) title :(int) state 
{
    [super setTitle:(title == JAVA_NULL ? nil : title) forState:state];
}

// (UIButton) - (void)setTitleColor:(UIColor *)color forState:(UIControlState)state;
- (void) setTitleColor___crossmobile_ios_uikit_UIColor_int:(UIColor*) color :(int) state 
{
    [super setTitleColor:(color == JAVA_NULL ? nil : color) forState:state];
}

// (UIButton) - (void)setTitleShadowColor:(UIColor *)color forState:(UIControlState)state;
- (void) setTitleShadowColor___crossmobile_ios_uikit_UIColor_int:(UIColor*) color :(int) state 
{
    [super setTitleShadowColor:(color == JAVA_NULL ? nil : color) forState:state];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValueForKey___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (void)setValue:(id)value forUndefinedKey:(NSString *)key;
- (void) setValueForUndefinedKey___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forUndefinedKey:(key == JAVA_NULL ? nil : key)];
}

// (UIView) - (CGSize)sizeThatFits:(CGSize)size;
- (crossmobile_ios_coregraphics_CGSize*) sizeThatFits___crossmobile_ios_coregraphics_CGSize:(crossmobile_ios_coregraphics_CGSize*) size 
{
    return [[crossmobile_ios_coregraphics_CGSize alloc] initWithCGSize:[super sizeThatFits:[size getCGSize]]];
}

// (UIView) - (void)sizeToFit;
- (void) sizeToFit__
{
    [super sizeToFit];
}

// (UIView) - (void)tintColorDidChange;
- (void) tintColorDidChange__
{
    [super tintColorDidChange];
}

// (UIButton) - (UIColor *)titleColorForState:(UIControlState)state;
- (UIColor*) titleColorForState___int:(int) state 
{
    UIColor* re$ult = [super titleColorForState:state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIButton) - (NSString *)titleForState:(UIControlState)state;
- (NSString*) titleForState___int:(int) state 
{
    NSString* re$ult = [super titleForState:state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIButton) - (UIColor *)titleShadowColorForState:(UIControlState)state;
- (UIColor*) titleShadowColorForState___int:(int) state 
{
    UIColor* re$ult = [super titleShadowColorForState:state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
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

// (UIView) - (void)updateConstraints;
- (void) updateConstraints__
{
    [super updateConstraints];
}

// (UIView) - (void)updateConstraintsIfNeeded;
- (void) updateConstraintsIfNeeded__
{
    [super updateConstraintsIfNeeded];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (id)valueForUndefinedKey:(NSString *)key;
- (id) valueForUndefinedKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForUndefinedKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) - (void)willMoveToSuperview:(UIView *)newSuperview;
- (void) willMoveToSuperview___crossmobile_ios_uikit_UIView:(UIView*) newSuperview 
{
    [super willMoveToSuperview:(newSuperview == JAVA_NULL ? nil : newSuperview)];
}

// (UIView) - (void)willMoveToWindow:(UIWindow *)newWindow;
- (void) willMoveToWindow___crossmobile_ios_uikit_UIWindow:(UIWindow*) newWindow 
{
    [super willMoveToWindow:(newWindow == JAVA_NULL ? nil : newWindow)];
}

// (UIView) - (void)willRemoveSubview:(UIView *)subview;
- (void) willRemoveSubview___crossmobile_ios_uikit_UIView:(UIView*) subview 
{
    [super willRemoveSubview:(subview == JAVA_NULL ? nil : subview)];
}

@end

@implementation UIButton (cm_crossmobile_ios_uikit_UIButton)

// direct binding of: + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIButton appearance]];
}

// direct binding of: + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIButton appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// direct binding of: + (instancetype)buttonWithType:(UIButtonType)buttonType;
+ (instancetype) buttonWithType___int:(int) buttonType 
{
    id re$ult = [UIButton buttonWithType:buttonType];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic) BOOL adjustsImageWhenDisabled;
- (void) setAdjustsImageWhenDisabled___boolean:(BOOL) adjustsImageWhenDisabled 
{
    [self setAdjustsImageWhenDisabled:adjustsImageWhenDisabled];
}

// direct binding of: @property(nonatomic) BOOL adjustsImageWhenDisabled;d;
- (BOOL) adjustsImageWhenDisabled__
{
    return [self adjustsImageWhenDisabled];
}

// direct binding of: @property(nonatomic) BOOL adjustsImageWhenHighlighted;
- (void) setAdjustsImageWhenHighlighted___boolean:(BOOL) adjustsImageWhenHighlighted 
{
    [self setAdjustsImageWhenHighlighted:adjustsImageWhenHighlighted];
}

// direct binding of: @property(nonatomic) BOOL adjustsImageWhenHighlighted;
- (BOOL) adjustsImageWhenHighlighted__
{
    return [self adjustsImageWhenHighlighted];
}

// direct binding of: @property(nonatomic, readonly) UIButtonType buttonType;
- (int) buttonType__
{
    return [self buttonType];
}

// direct binding of: @property(nonatomic) UIEdgeInsets contentEdgeInsets;
- (void) setContentEdgeInsets___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) contentEdgeInsets 
{
    [self setContentEdgeInsets:[contentEdgeInsets getUIEdgeInsets]];
}

// direct binding of: @property(nonatomic) UIEdgeInsets contentEdgeInsets;
- (crossmobile_ios_uikit_UIEdgeInsets*) contentEdgeInsets__
{
    return [[crossmobile_ios_uikit_UIEdgeInsets alloc] initWithUIEdgeInsets:[self contentEdgeInsets]];
}

// direct binding of: @property(nonatomic, readonly, strong) UIImage *currentBackgroundImage;
- (UIImage*) currentBackgroundImage__
{
    UIImage* re$ult = [self currentBackgroundImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly, strong) UIImage *currentImage;
- (UIImage*) currentImage__
{
    UIImage* re$ult = [self currentImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly, strong) NSString *currentTitle;
- (NSString*) currentTitle__
{
    NSString* re$ult = [self currentTitle];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly, strong) UIColor *currentTitleColor;
- (UIColor*) currentTitleColor__
{
    UIColor* re$ult = [self currentTitleColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly, strong) UIColor *currentTitleShadowColor;
- (UIColor*) currentTitleShadowColor__
{
    UIColor* re$ult = [self currentTitleShadowColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic) UIEdgeInsets imageEdgeInsets;
- (void) setImageEdgeInsets___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) imageEdgeInsets 
{
    [self setImageEdgeInsets:[imageEdgeInsets getUIEdgeInsets]];
}

// direct binding of: @property(nonatomic) UIEdgeInsets imageEdgeInsets;
- (crossmobile_ios_uikit_UIEdgeInsets*) imageEdgeInsets__
{
    return [[crossmobile_ios_uikit_UIEdgeInsets alloc] initWithUIEdgeInsets:[self imageEdgeInsets]];
}

// direct binding of: @property(nonatomic, readonly, strong) UIImageView *imageView;
- (UIImageView*) imageView__
{
    UIImageView* re$ult = [self imageView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic) BOOL showsTouchWhenHighlighted;
- (void) setShowsTouchWhenHighlighted___boolean:(BOOL) showsTouchWhenHighlighted 
{
    [self setShowsTouchWhenHighlighted:showsTouchWhenHighlighted];
}

// direct binding of: @property(nonatomic) BOOL showsTouchWhenHighlighted;
- (BOOL) showsTouchWhenHighlighted__
{
    return [self showsTouchWhenHighlighted];
}

// direct binding of: @property(nonatomic) UIEdgeInsets titleEdgeInsets;
- (void) setTitleEdgeInsets___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) titleEdgeInsets 
{
    [self setTitleEdgeInsets:[titleEdgeInsets getUIEdgeInsets]];
}

// direct binding of: @property(nonatomic) UIEdgeInsets titleEdgeInsets;
- (crossmobile_ios_uikit_UIEdgeInsets*) titleEdgeInsets__
{
    return [[crossmobile_ios_uikit_UIEdgeInsets alloc] initWithUIEdgeInsets:[self titleEdgeInsets]];
}

// direct binding of: @property(nonatomic, readonly, strong) UILabel *titleLabel;
- (UILabel*) titleLabel__
{
    UILabel* re$ult = [self titleLabel];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (UIImage *)backgroundImageForState:(UIControlState)state;
- (UIImage*) backgroundImageForState___int:(int) state 
{
    UIImage* re$ult = [self backgroundImageForState:state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (UIImage *)imageForState:(UIControlState)state;
- (UIImage*) imageForState___int:(int) state 
{
    UIImage* re$ult = [self imageForState:state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (void)setBackgroundImage:(UIImage *)image forState:(UIControlState)state;
- (void) setBackgroundImage___crossmobile_ios_uikit_UIImage_int:(UIImage*) image :(int) state 
{
    [self setBackgroundImage:(image == JAVA_NULL ? nil : image) forState:state];
}

// direct binding of: - (void)setImage:(UIImage *)image forState:(UIControlState)state;
- (void) setImage___crossmobile_ios_uikit_UIImage_int:(UIImage*) image :(int) state 
{
    [self setImage:(image == JAVA_NULL ? nil : image) forState:state];
}

// direct binding of: - (void)setTitle:(NSString *)title forState:(UIControlState)state;
- (void) setTitle___java_lang_String_int:(NSString*) title :(int) state 
{
    [self setTitle:(title == JAVA_NULL ? nil : title) forState:state];
}

// direct binding of: - (void)setTitleColor:(UIColor *)color forState:(UIControlState)state;
- (void) setTitleColor___crossmobile_ios_uikit_UIColor_int:(UIColor*) color :(int) state 
{
    [self setTitleColor:(color == JAVA_NULL ? nil : color) forState:state];
}

// direct binding of: - (void)setTitleShadowColor:(UIColor *)color forState:(UIControlState)state;
- (void) setTitleShadowColor___crossmobile_ios_uikit_UIColor_int:(UIColor*) color :(int) state 
{
    [self setTitleShadowColor:(color == JAVA_NULL ? nil : color) forState:state];
}

// direct binding of: - (UIColor *)titleColorForState:(UIControlState)state;
- (UIColor*) titleColorForState___int:(int) state 
{
    UIColor* re$ult = [self titleColorForState:state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (NSString *)titleForState:(UIControlState)state;
- (NSString*) titleForState___int:(int) state 
{
    NSString* re$ult = [self titleForState:state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (UIColor *)titleShadowColorForState:(UIControlState)state;
- (UIColor*) titleShadowColorForState___int:(int) state 
{
    UIColor* re$ult = [self titleShadowColorForState:state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
