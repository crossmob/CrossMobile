// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIView implementation

#import "crossmobile_ios_coregraphics_CGAffineTransform.h"
#import "crossmobile_ios_coregraphics_CGPoint.h"
#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_coregraphics_CGSize.h"
#import "crossmobile_ios_foundation_NSDate.h"
#import "crossmobile_ios_quartzcore_CALayer.h"
#import "crossmobile_ios_uikit_NSLayoutConstraint.h"
#import "crossmobile_ios_uikit_NSLayoutDimension.h"
#import "crossmobile_ios_uikit_NSLayoutXAxisAnchor.h"
#import "crossmobile_ios_uikit_NSLayoutYAxisAnchor.h"
#import "crossmobile_ios_uikit_UIColor.h"
#import "crossmobile_ios_uikit_UIEdgeInsets.h"
#import "crossmobile_ios_uikit_UIEvent.h"
#import "crossmobile_ios_uikit_UIGestureRecognizer.h"
#import "crossmobile_ios_uikit_UILayoutGuide.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "crossmobile_ios_uikit_UIWindow.h"
#import "java_lang_Boolean.h"
#import "java_lang_Runnable.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "org_robovm_objc_block_VoidBlock1.h"

@implementation crossmobile_ios_uikit_UIView$Ext

@end

@implementation UIView (cm_crossmobile_ios_uikit_UIView)

// + (void)animateWithDuration:(NSTimeInterval)duration delay:(NSTimeInterval)delay options:(UIViewAnimationOptions)options animations:(void (^)(void))animations completion:(void (^)(BOOL finished))completion;
+ (void) animateWithDuration___double_double_int_java_lang_Runnable_org_robovm_objc_block_VoidBlock1:(double) duration :(double) delay :(int) options :(id<java_lang_Runnable>) animations :(id<org_robovm_objc_block_VoidBlock1>) completion 
{
    [UIView animateWithDuration:duration delay:delay options:options animations:(animations == JAVA_NULL ? nil : ^{
        [animations run__];
    }) completion:(completion == JAVA_NULL ? nil : ^(BOOL finished) {
        java_lang_Boolean* finished$conv = [[java_lang_Boolean alloc] initWithBool:finished];
        [completion invoke___java_lang_Object:finished$conv];
        [finished$conv release];
    })];
}

// + (void)animateWithDuration:(NSTimeInterval)duration animations:(void (^)(void))animations;
+ (void) animateWithDuration___double_java_lang_Runnable:(double) duration :(id<java_lang_Runnable>) animations 
{
    [UIView animateWithDuration:duration animations:(animations == JAVA_NULL ? nil : ^{
        [animations run__];
    })];
}

// + (void)animateWithDuration:(NSTimeInterval)duration animations:(void (^)(void))animations completion:(void (^)(BOOL finished))completion;
+ (void) animateWithDuration___double_java_lang_Runnable_org_robovm_objc_block_VoidBlock1:(double) duration :(id<java_lang_Runnable>) animations :(id<org_robovm_objc_block_VoidBlock1>) completion 
{
    [UIView animateWithDuration:duration animations:(animations == JAVA_NULL ? nil : ^{
        [animations run__];
    }) completion:(completion == JAVA_NULL ? nil : ^(BOOL finished) {
        java_lang_Boolean* finished$conv = [[java_lang_Boolean alloc] initWithBool:finished];
        [completion invoke___java_lang_Object:finished$conv];
        [finished$conv release];
    })];
}

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIView appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIView appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// + (BOOL)areAnimationsEnabled;
+ (BOOL) areAnimationsEnabled__
{
    return [UIView areAnimationsEnabled];
}

// + (BOOL)requiresConstraintBasedLayout;
+ (BOOL) requiresConstraintBasedLayout__
{
    return [UIView requiresConstraintBasedLayout];
}

// + (void)setAnimationBeginsFromCurrentState:(BOOL)fromCurrentState;
+ (void) setAnimationBeginsFromCurrentState___boolean:(BOOL) fromCurrentState 
{
    [UIView setAnimationBeginsFromCurrentState:fromCurrentState];
}

// + (void)setAnimationCurve:(UIViewAnimationCurve)curve;
+ (void) setAnimationCurve___int:(int) curve 
{
    [UIView setAnimationCurve:curve];
}

// + (void)setAnimationDelay:(NSTimeInterval)delay;
+ (void) setAnimationDelay___double:(double) delay 
{
    [UIView setAnimationDelay:delay];
}

// + (void)setAnimationDuration:(NSTimeInterval)duration;
+ (void) setAnimationDuration___double:(double) duration 
{
    [UIView setAnimationDuration:duration];
}

// + (void)setAnimationRepeatAutoreverses:(BOOL)repeatAutoreverses;
+ (void) setAnimationRepeatAutoreverses___boolean:(BOOL) repeatAutoreverses 
{
    [UIView setAnimationRepeatAutoreverses:repeatAutoreverses];
}

// + (void)setAnimationRepeatCount:(float)repeatCount;
+ (void) setAnimationRepeatCount___float:(float) repeatCount 
{
    [UIView setAnimationRepeatCount:repeatCount];
}

// + (void)setAnimationStartDate:(NSDate *)startDate;
+ (void) setAnimationStartDate___crossmobile_ios_foundation_NSDate:(NSDate*) startDate 
{
    [UIView setAnimationStartDate:(startDate == JAVA_NULL ? nil : startDate)];
}

// + (void)setAnimationsEnabled:(BOOL)enabled;
+ (void) setAnimationsEnabled___boolean:(BOOL) enabled 
{
    [UIView setAnimationsEnabled:enabled];
}

// + (void)transitionWithView:(UIView *)view duration:(NSTimeInterval)duration options:(UIViewAnimationOptions)options animations:(void (^)(void))animations completion:(void (^)(BOOL finished))completion;
+ (void) transitionWithView___crossmobile_ios_uikit_UIView_double_int_java_lang_Runnable_org_robovm_objc_block_VoidBlock1:(UIView*) view :(double) duration :(int) options :(id<java_lang_Runnable>) animations :(id<org_robovm_objc_block_VoidBlock1>) completion 
{
    [UIView transitionWithView:(view == JAVA_NULL ? nil : view) duration:duration options:options animations:(animations == JAVA_NULL ? nil : ^{
        [animations run__];
    }) completion:(completion == JAVA_NULL ? nil : ^(BOOL finished) {
        java_lang_Boolean* finished$conv = [[java_lang_Boolean alloc] initWithBool:finished];
        [completion invoke___java_lang_Object:finished$conv];
        [finished$conv release];
    })];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UIView__
{
    return [self init];
}

// - (instancetype)initWithFrame:(CGRect)frame;
- (instancetype) __init_crossmobile_ios_uikit_UIView___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame 
{
    return [self initWithFrame:[frame getCGRect]];
}

// @property(nonatomic, copy) NSString *accessibilityIdentifier;
- (void) setAccessibilityIdentifier___java_lang_String:(NSString*) accessibilityIdentifier 
{
    [self setAccessibilityIdentifier:(accessibilityIdentifier == JAVA_NULL ? nil : accessibilityIdentifier)];
}

// @property(nonatomic, copy) NSString *accessibilityIdentifier;
- (NSString*) accessibilityIdentifier__
{
    NSString* re$ult = [self accessibilityIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) CGFloat alpha;
- (void) setAlpha___double:(double) alpha 
{
    [self setAlpha:alpha];
}

// @property(nonatomic) CGFloat alpha;
- (double) alpha__
{
    return [self alpha];
}

// @property(nonatomic) BOOL autoresizesSubviews;
- (void) setAutoresizesSubviews___boolean:(BOOL) autoresizesSubviews 
{
    [self setAutoresizesSubviews:autoresizesSubviews];
}

// @property(nonatomic) BOOL autoresizesSubviews;
- (BOOL) autoresizesSubviews__
{
    return [self autoresizesSubviews];
}

// @property(nonatomic) UIViewAutoresizing autoresizingMask;
- (void) setAutoresizingMask___int:(int) autoresizingMask 
{
    [self setAutoresizingMask:autoresizingMask];
}

// @property(nonatomic) UIViewAutoresizing autoresizingMask;
- (int) autoresizingMask__
{
    return [self autoresizingMask];
}

// @property(nonatomic, copy) UIColor *backgroundColor;
- (void) setBackgroundColor___crossmobile_ios_uikit_UIColor:(UIColor*) backgroundColor 
{
    [self setBackgroundColor:(backgroundColor == JAVA_NULL ? nil : backgroundColor)];
}

// @property(nonatomic, copy) UIColor *backgroundColor;
- (UIColor*) backgroundColor__
{
    UIColor* re$ult = [self backgroundColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, strong) NSLayoutYAxisAnchor *bottomAnchor;
- (NSLayoutYAxisAnchor*) bottomAnchor__
{
    NSLayoutYAxisAnchor* re$ult = [self bottomAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) CGRect bounds;
- (void) setBounds___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) bounds 
{
    [self setBounds:[bounds getCGRect]];
}

// @property(nonatomic) CGRect bounds;
- (crossmobile_ios_coregraphics_CGRect*) bounds__
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:[self bounds]];
}

// @property(nonatomic) CGPoint center;
- (void) setCenter___crossmobile_ios_coregraphics_CGPoint:(crossmobile_ios_coregraphics_CGPoint*) center 
{
    [self setCenter:[center getCGPoint]];
}

// @property(nonatomic) CGPoint center;
- (crossmobile_ios_coregraphics_CGPoint*) center__
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[self center]];
}

// @property(readonly, strong) NSLayoutXAxisAnchor *centerXAnchor;
- (NSLayoutXAxisAnchor*) centerXAnchor__
{
    NSLayoutXAxisAnchor* re$ult = [self centerXAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, strong) NSLayoutYAxisAnchor *centerYAnchor;
- (NSLayoutYAxisAnchor*) centerYAnchor__
{
    NSLayoutYAxisAnchor* re$ult = [self centerYAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) BOOL clearsContextBeforeDrawing;
- (void) setClearsContextBeforeDrawing___boolean:(BOOL) clearsContextBeforeDrawing 
{
    [self setClearsContextBeforeDrawing:clearsContextBeforeDrawing];
}

// @property(nonatomic) BOOL clipsToBounds;
- (void) setClipsToBounds___boolean:(BOOL) clipsToBounds 
{
    [self setClipsToBounds:clipsToBounds];
}

// @property(nonatomic) BOOL clipsToBounds;
- (BOOL) clipsToBounds__
{
    return [self clipsToBounds];
}

// @property(nonatomic, readonly) NSArray<__kindof NSLayoutConstraint *> *constraints;
- (NSArray*) constraints__
{
    NSArray* re$ult = [self constraints];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) UIViewContentMode contentMode;
- (void) setContentMode___int:(int) contentMode 
{
    [self setContentMode:contentMode];
}

// @property(nonatomic) UIViewContentMode contentMode;
- (int) contentMode__
{
    return [self contentMode];
}

// @property(nonatomic) CGRect frame;
- (void) setFrame___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame 
{
    [self setFrame:[frame getCGRect]];
}

// @property(nonatomic) CGRect frame;
- (crossmobile_ios_coregraphics_CGRect*) frame__
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:[self frame]];
}

// @property(nonatomic, copy) NSArray<__kindof UIGestureRecognizer *> *gestureRecognizers;
- (void) setGestureRecognizers___java_util_List:(NSArray*) gestureRecognizers 
{
    [self setGestureRecognizers:(gestureRecognizers == JAVA_NULL ? nil : gestureRecognizers)];
}

// @property(nonatomic, copy) NSArray<__kindof UIGestureRecognizer *> *gestureRecognizers;
- (NSArray*) gestureRecognizers__
{
    NSArray* re$ult = [self gestureRecognizers];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, strong) NSLayoutDimension *heightAnchor;
- (NSLayoutDimension*) heightAnchor__
{
    NSLayoutDimension* re$ult = [self heightAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, getter=isHidden) BOOL hidden;
- (void) setHidden___boolean:(BOOL) hidden 
{
    [self setHidden:hidden];
}

// @property(nonatomic, getter=isHidden) BOOL hidden;
- (BOOL) isHidden__
{
    return [self isHidden];
}

// @property(nonatomic) BOOL insetsLayoutMarginsFromSafeArea;
- (void) setInsetsLayoutMarginsFromSafeArea___boolean:(BOOL) insetsLayoutMarginsFromSafeArea 
{
    [self setInsetsLayoutMarginsFromSafeArea:insetsLayoutMarginsFromSafeArea];
}

// @property(nonatomic) BOOL insetsLayoutMarginsFromSafeArea;
- (BOOL) insetsLayoutMarginsFromSafeArea__
{
    return [self insetsLayoutMarginsFromSafeArea];
}

// @property(nonatomic, readonly, strong) CALayer *layer;
- (CALayer*) layer__
{
    CALayer* re$ult = [self layer];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) UIEdgeInsets layoutMargins;
- (void) setLayoutMargins___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) layoutMargins 
{
    [self setLayoutMargins:[layoutMargins getUIEdgeInsets]];
}

// @property(nonatomic) UIEdgeInsets layoutMargins;
- (crossmobile_ios_uikit_UIEdgeInsets*) layoutMargins__
{
    return [[crossmobile_ios_uikit_UIEdgeInsets alloc] initWithUIEdgeInsets:[self layoutMargins]];
}

// @property(readonly, strong) UILayoutGuide *layoutMarginsGuide;
- (UILayoutGuide*) layoutMarginsGuide__
{
    UILayoutGuide* re$ult = [self layoutMarginsGuide];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, strong) NSLayoutXAxisAnchor *leadingAnchor;
- (NSLayoutXAxisAnchor*) leadingAnchor__
{
    NSLayoutXAxisAnchor* re$ult = [self leadingAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, strong) NSLayoutXAxisAnchor *leftAnchor;
- (NSLayoutXAxisAnchor*) leftAnchor__
{
    NSLayoutXAxisAnchor* re$ult = [self leftAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nullable, nonatomic, strong) UIView *maskView;
- (void) setMaskView___crossmobile_ios_uikit_UIView:(UIView*) maskView 
{
    [self setMaskView:(maskView == JAVA_NULL ? nil : maskView)];
}

// @property(nullable, nonatomic, strong) UIView *maskView;
- (UIView*) maskView__
{
    UIView* re$ult = [self maskView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, getter=isMultipleTouchEnabled) BOOL multipleTouchEnabled;
- (void) setMultipleTouchEnabled___boolean:(BOOL) multipleTouchEnabled 
{
    [self setMultipleTouchEnabled:multipleTouchEnabled];
}

// @property(nonatomic, getter=isMultipleTouchEnabled) BOOL multipleTouchEnabled;
- (BOOL) isMultipleTouchEnabled__
{
    return [self isMultipleTouchEnabled];
}

// @property(nonatomic, getter=isOpaque) BOOL opaque;
- (void) setOpaque___boolean:(BOOL) opaque 
{
    [self setOpaque:opaque];
}

// @property(nonatomic, getter=isOpaque) BOOL opaque;
- (BOOL) isOpaque__
{
    return [self isOpaque];
}

// @property(nonatomic) UIUserInterfaceStyle overrideUserInterfaceStyle;
- (void) setOverrideUserInterfaceStyle___int:(int) overrideUserInterfaceStyle 
{
    if (isIosAtLeast(13,0)){
        [self setOverrideUserInterfaceStyle:overrideUserInterfaceStyle];
    }
}

// @property(nonatomic) UIUserInterfaceStyle overrideUserInterfaceStyle;
- (int) overrideUserInterfaceStyle__
{
    if (isIosAtLeast(13,0)){
        return [self overrideUserInterfaceStyle];
    } else {
        return 0;
    }
}

// @property(nonatomic) BOOL preservesSuperviewLayoutMargins;
- (void) setPreservesSuperviewLayoutMargins___boolean:(BOOL) preservesSuperviewLayoutMargins 
{
    [self setPreservesSuperviewLayoutMargins:preservesSuperviewLayoutMargins];
}

// @property(nonatomic) BOOL preservesSuperviewLayoutMargins;
- (BOOL) preservesSuperviewLayoutMargins__
{
    return [self preservesSuperviewLayoutMargins];
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

// @property(readonly, strong) NSLayoutXAxisAnchor *rightAnchor;
- (NSLayoutXAxisAnchor*) rightAnchor__
{
    NSLayoutXAxisAnchor* re$ult = [self rightAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) UIEdgeInsets safeAreaInsets;
- (crossmobile_ios_uikit_UIEdgeInsets*) safeAreaInsets__
{
    return [[crossmobile_ios_uikit_UIEdgeInsets alloc] initWithUIEdgeInsets:[self safeAreaInsets]];
}

// @property(nonatomic, readonly, strong) UILayoutGuide *safeAreaLayoutGuide;
- (UILayoutGuide*) safeAreaLayoutGuide__
{
    UILayoutGuide* re$ult = [self safeAreaLayoutGuide];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, copy) NSArray<__kindof UIView *> *subviews;
- (NSArray*) subviews__
{
    NSArray* re$ult = [self subviews];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) UIView *superview;
- (UIView*) superview__
{
    UIView* re$ult = [self superview];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) NSInteger tag;
- (void) setTag___int:(int) tag 
{
    [self setTag:tag];
}

// @property(nonatomic) NSInteger tag;
- (int) tag__
{
    return [self tag];
}

// @property(nonatomic) UIViewTintAdjustmentMode tintAdjustmentMode;
- (void) setTintAdjustmentMode___int:(int) tintAdjustmentMode 
{
    [self setTintAdjustmentMode:tintAdjustmentMode];
}

// @property(nonatomic) UIViewTintAdjustmentMode tintAdjustmentMode;
- (int) tintAdjustmentMode__
{
    return [self tintAdjustmentMode];
}

// @property(nonatomic, strong) UIColor *tintColor;
- (void) setTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) tintColor 
{
    [self setTintColor:(tintColor == JAVA_NULL ? nil : tintColor)];
}

// @property(nonatomic, strong) UIColor *tintColor;
- (UIColor*) tintColor__
{
    UIColor* re$ult = [self tintColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, strong) NSLayoutYAxisAnchor *topAnchor;
- (NSLayoutYAxisAnchor*) topAnchor__
{
    NSLayoutYAxisAnchor* re$ult = [self topAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, strong) NSLayoutXAxisAnchor *trailingAnchor;
- (NSLayoutXAxisAnchor*) trailingAnchor__
{
    NSLayoutXAxisAnchor* re$ult = [self trailingAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) CGAffineTransform transform;
- (void) setTransform___crossmobile_ios_coregraphics_CGAffineTransform:(crossmobile_ios_coregraphics_CGAffineTransform*) transform 
{
    [self setTransform:[transform getCGAffineTransform]];
}

// @property(nonatomic) CGAffineTransform transform;
- (crossmobile_ios_coregraphics_CGAffineTransform*) transform__
{
    return [[crossmobile_ios_coregraphics_CGAffineTransform alloc] initWithCGAffineTransform:[self transform]];
}

// @property(nonatomic) BOOL translatesAutoresizingMaskIntoConstraints;
- (void) setTranslatesAutoresizingMaskIntoConstraints___boolean:(BOOL) translatesAutoresizingMaskIntoConstraints 
{
    [self setTranslatesAutoresizingMaskIntoConstraints:translatesAutoresizingMaskIntoConstraints];
}

// @property(nonatomic) BOOL translatesAutoresizingMaskIntoConstraints;
- (BOOL) translatesAutoresizingMaskIntoConstraints__
{
    return [self translatesAutoresizingMaskIntoConstraints];
}

// @property(nonatomic, getter=isUserInteractionEnabled) BOOL userInteractionEnabled;
- (void) setUserInteractionEnabled___boolean:(BOOL) userInteractionEnabled 
{
    [self setUserInteractionEnabled:userInteractionEnabled];
}

// @property(nonatomic, getter=isUserInteractionEnabled) BOOL userInteractionEnabled;
- (BOOL) isUserInteractionEnabled__
{
    return [self isUserInteractionEnabled];
}

// @property(nonatomic, readonly) UIUserInterfaceLayoutDirection userInterfaceLayoutDirection;
- (int) userInterfaceLayoutDirection__
{
    return [self userInterfaceLayoutDirection];
}

// @property(readonly, strong) UIView *viewForFirstBaselineLayout;
- (UIView*) viewForFirstBaselineLayout__
{
    UIView* re$ult = [self viewForFirstBaselineLayout];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, strong) UIView *viewForLastBaselineLayout;
- (UIView*) viewForLastBaselineLayout__
{
    UIView* re$ult = [self viewForLastBaselineLayout];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, strong) NSLayoutDimension *widthAnchor;
- (NSLayoutDimension*) widthAnchor__
{
    NSLayoutDimension* re$ult = [self widthAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) UIWindow *window;
- (UIWindow*) window__
{
    UIWindow* re$ult = [self window];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)addConstraint:(NSLayoutConstraint *)constraint;
- (void) addConstraint___crossmobile_ios_uikit_NSLayoutConstraint:(NSLayoutConstraint*) constraint 
{
    [self addConstraint:(constraint == JAVA_NULL ? nil : constraint)];
}

// - (void)addConstraints:(NSArray<__kindof NSLayoutConstraint *> *)constraints;
- (void) addConstraints___java_util_List:(NSArray*) constraints 
{
    [self addConstraints:(constraints == JAVA_NULL ? nil : constraints)];
}

// - (void)addGestureRecognizer:(UIGestureRecognizer *)gestureRecognizer;
- (void) addGestureRecognizer___crossmobile_ios_uikit_UIGestureRecognizer:(UIGestureRecognizer*) gestureRecognizer 
{
    [self addGestureRecognizer:(gestureRecognizer == JAVA_NULL ? nil : gestureRecognizer)];
}

// - (void)addLayoutGuide:(UILayoutGuide *)layoutGuide;
- (void) addLayoutGuide___crossmobile_ios_uikit_UILayoutGuide:(UILayoutGuide*) layoutGuide 
{
    [self addLayoutGuide:(layoutGuide == JAVA_NULL ? nil : layoutGuide)];
}

// - (void)addSubview:(UIView *)view;
- (void) addSubview___crossmobile_ios_uikit_UIView:(UIView*) view 
{
    [self addSubview:(view == JAVA_NULL ? nil : view)];
}

// - (void)bringSubviewToFront:(UIView *)view;
- (void) bringSubviewToFront___crossmobile_ios_uikit_UIView:(UIView*) view 
{
    [self bringSubviewToFront:(view == JAVA_NULL ? nil : view)];
}

// - (UILayoutPriority)contentCompressionResistancePriorityForAxis:(UILayoutConstraintAxis)axis;
- (float) contentCompressionResistancePriorityForAxis___int:(int) axis 
{
    return [self contentCompressionResistancePriorityForAxis:axis];
}

// - (UILayoutPriority)contentHuggingPriorityForAxis:(UILayoutConstraintAxis)axis;
- (float) contentHuggingPriorityForAxis___int:(int) axis 
{
    return [self contentHuggingPriorityForAxis:axis];
}

// - (CGPoint)convertPoint:(CGPoint)point fromView:(UIView *)view;
- (crossmobile_ios_coregraphics_CGPoint*) convertPointFromView___crossmobile_ios_coregraphics_CGPoint_crossmobile_ios_uikit_UIView:(crossmobile_ios_coregraphics_CGPoint*) point :(UIView*) view 
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[self convertPoint:[point getCGPoint] fromView:(view == JAVA_NULL ? nil : view)]];
}

// - (CGPoint)convertPoint:(CGPoint)point toView:(UIView *)view;
- (crossmobile_ios_coregraphics_CGPoint*) convertPointToView___crossmobile_ios_coregraphics_CGPoint_crossmobile_ios_uikit_UIView:(crossmobile_ios_coregraphics_CGPoint*) point :(UIView*) view 
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[self convertPoint:[point getCGPoint] toView:(view == JAVA_NULL ? nil : view)]];
}

// - (CGRect)convertRect:(CGRect)rect fromView:(UIView *)view;
- (crossmobile_ios_coregraphics_CGRect*) convertRectFromView___crossmobile_ios_coregraphics_CGRect_crossmobile_ios_uikit_UIView:(crossmobile_ios_coregraphics_CGRect*) rect :(UIView*) view 
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:[self convertRect:[rect getCGRect] fromView:(view == JAVA_NULL ? nil : view)]];
}

// - (CGRect)convertRect:(CGRect)rect toView:(UIView *)view;
- (crossmobile_ios_coregraphics_CGRect*) convertRectToView___crossmobile_ios_coregraphics_CGRect_crossmobile_ios_uikit_UIView:(crossmobile_ios_coregraphics_CGRect*) rect :(UIView*) view 
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:[self convertRect:[rect getCGRect] toView:(view == JAVA_NULL ? nil : view)]];
}

// - (void)didAddSubview:(UIView *)subview;
- (void) didAddSubview___crossmobile_ios_uikit_UIView:(UIView*) subview 
{
    [self didAddSubview:(subview == JAVA_NULL ? nil : subview)];
}

// - (void)didMoveToSuperview;
- (void) didMoveToSuperview__
{
    [self didMoveToSuperview];
}

// - (void)didMoveToWindow;
- (void) didMoveToWindow__
{
    [self didMoveToWindow];
}

// - (void)drawRect:(CGRect)rect;
- (void) drawRect___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) rect 
{
    [self drawRect:[rect getCGRect]];
}

// - (UIView *)hitTest:(CGPoint)point withEvent:(UIEvent *)event;
- (UIView*) hitTest___crossmobile_ios_coregraphics_CGPoint_crossmobile_ios_uikit_UIEvent:(crossmobile_ios_coregraphics_CGPoint*) point :(UIEvent*) event 
{
    UIView* re$ult = [self hitTest:[point getCGPoint] withEvent:(event == JAVA_NULL ? nil : event)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)insertSubview:(UIView *)view atIndex:(NSInteger)index;
- (void) insertSubview___crossmobile_ios_uikit_UIView_int:(UIView*) view :(int) index 
{
    [self insertSubview:(view == JAVA_NULL ? nil : view) atIndex:index];
}

// - (CGSize)intrinsicContentSize;
- (crossmobile_ios_coregraphics_CGSize*) intrinsicContentSize__
{
    return [[crossmobile_ios_coregraphics_CGSize alloc] initWithCGSize:[self intrinsicContentSize]];
}

// - (void)invalidateIntrinsicContentSize;
- (void) invalidateIntrinsicContentSize__
{
    [self invalidateIntrinsicContentSize];
}

// - (void)layoutIfNeeded;
- (void) layoutIfNeeded__
{
    [self layoutIfNeeded];
}

// - (void)layoutMarginsDidChange;
- (void) layoutMarginsDidChange__
{
    [self layoutMarginsDidChange];
}

// - (void)layoutSubviews;
- (void) layoutSubviews__
{
    [self layoutSubviews];
}

// - (BOOL)needsUpdateConstraints;
- (BOOL) needsUpdateConstraints__
{
    return [self needsUpdateConstraints];
}

// - (BOOL)pointInside:(CGPoint)point withEvent:(UIEvent *)event;
- (BOOL) pointInside___crossmobile_ios_coregraphics_CGPoint_crossmobile_ios_uikit_UIEvent:(crossmobile_ios_coregraphics_CGPoint*) point :(UIEvent*) event 
{
    return [self pointInside:[point getCGPoint] withEvent:(event == JAVA_NULL ? nil : event)];
}

// - (void)removeConstraint:(NSLayoutConstraint *)constraint;
- (void) removeConstraint___crossmobile_ios_uikit_NSLayoutConstraint:(NSLayoutConstraint*) constraint 
{
    [self removeConstraint:(constraint == JAVA_NULL ? nil : constraint)];
}

// - (void)removeConstraints:(NSArray<__kindof NSLayoutConstraint *> *)constraints;
- (void) removeConstraints___java_util_List:(NSArray*) constraints 
{
    [self removeConstraints:(constraints == JAVA_NULL ? nil : constraints)];
}

// - (void)removeFromSuperview;
- (void) removeFromSuperview__
{
    [self removeFromSuperview];
}

// - (void)removeGestureRecognizer:(UIGestureRecognizer *)gestureRecognizer;
- (void) removeGestureRecognizer___crossmobile_ios_uikit_UIGestureRecognizer:(UIGestureRecognizer*) gestureRecognizer 
{
    [self removeGestureRecognizer:(gestureRecognizer == JAVA_NULL ? nil : gestureRecognizer)];
}

// - (void)removeLayoutGuide:(UILayoutGuide *)layoutGuide;
- (void) removeLayoutGuide___crossmobile_ios_uikit_UILayoutGuide:(UILayoutGuide*) layoutGuide 
{
    [self removeLayoutGuide:(layoutGuide == JAVA_NULL ? nil : layoutGuide)];
}

// - (void)sendSubviewToBack:(UIView *)view;
- (void) sendSubviewToBack___crossmobile_ios_uikit_UIView:(UIView*) view 
{
    [self sendSubviewToBack:(view == JAVA_NULL ? nil : view)];
}

// - (void)setContentCompressionResistancePriority:(UILayoutPriority)priority forAxis:(UILayoutConstraintAxis)axis;
- (void) setContentCompressionResistancePriority___float_int:(float) priority :(int) axis 
{
    [self setContentCompressionResistancePriority:priority forAxis:axis];
}

// - (void)setContentHuggingPriority:(UILayoutPriority)priority forAxis:(UILayoutConstraintAxis)axis;
- (void) setContentHuggingPriority___float_int:(float) priority :(int) axis 
{
    [self setContentHuggingPriority:priority forAxis:axis];
}

// - (void)setNeedsDisplay;
- (void) setNeedsDisplay__
{
    [self setNeedsDisplay];
}

// - (void)setNeedsLayout;
- (void) setNeedsLayout__
{
    [self setNeedsLayout];
}

// - (void)setNeedsUpdateConstraints;
- (void) setNeedsUpdateConstraints__
{
    [self setNeedsUpdateConstraints];
}

// - (CGSize)sizeThatFits:(CGSize)size;
- (crossmobile_ios_coregraphics_CGSize*) sizeThatFits___crossmobile_ios_coregraphics_CGSize:(crossmobile_ios_coregraphics_CGSize*) size 
{
    return [[crossmobile_ios_coregraphics_CGSize alloc] initWithCGSize:[self sizeThatFits:[size getCGSize]]];
}

// - (void)sizeToFit;
- (void) sizeToFit__
{
    [self sizeToFit];
}

// - (void)tintColorDidChange;
- (void) tintColorDidChange__
{
    [self tintColorDidChange];
}

// - (void)updateConstraints;
- (void) updateConstraints__
{
    [self updateConstraints];
}

// - (void)updateConstraintsIfNeeded;
- (void) updateConstraintsIfNeeded__
{
    [self updateConstraintsIfNeeded];
}

// - (void)willMoveToSuperview:(UIView *)newSuperview;
- (void) willMoveToSuperview___crossmobile_ios_uikit_UIView:(UIView*) newSuperview 
{
    [self willMoveToSuperview:(newSuperview == JAVA_NULL ? nil : newSuperview)];
}

// - (void)willMoveToWindow:(UIWindow *)newWindow;
- (void) willMoveToWindow___crossmobile_ios_uikit_UIWindow:(UIWindow*) newWindow 
{
    [self willMoveToWindow:(newWindow == JAVA_NULL ? nil : newWindow)];
}

// - (void)willRemoveSubview:(UIView *)subview;
- (void) willRemoveSubview___crossmobile_ios_uikit_UIView:(UIView*) subview 
{
    [self willRemoveSubview:(subview == JAVA_NULL ? nil : subview)];
}

@end
