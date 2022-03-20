// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIGestureRecognizer implementation

#import "crossmobile_ios_coregraphics_CGPoint.h"
#import "crossmobile_ios_foundation_NSSelector.h"
#import "crossmobile_ios_uikit_UIEvent.h"
#import "crossmobile_ios_uikit_UIGestureRecognizer.h"
#import "crossmobile_ios_uikit_UIGestureRecognizerDelegate.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "java_lang_reflect_Method.h"
#import "java_util_Set.h"

@implementation crossmobile_ios_uikit_UIGestureRecognizer$Ext

@end

@implementation UIGestureRecognizer (cm_crossmobile_ios_uikit_UIGestureRecognizer)

// - (instancetype)initWithTarget:(id)target action:(SEL)action;
- (instancetype) __init_crossmobile_ios_uikit_UIGestureRecognizer___crossmobile_ios_foundation_NSSelector:(id<crossmobile_ios_foundation_NSSelector>) target 
{
    objc_setAssociatedObject(self, (void*)target, target, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    return [self initWithTarget:(target == JAVA_NULL ? nil : target) action:@selector(exec___java_lang_Object:)];
}

// @property(nonatomic) BOOL cancelsTouchesInView;
- (void) setCancelsTouchesInView___boolean:(BOOL) cancelsTouchesInView 
{
    [self setCancelsTouchesInView:cancelsTouchesInView];
}

// @property(nonatomic) BOOL cancelsTouchesInView;
- (BOOL) cancelsTouchesInView__
{
    return [self cancelsTouchesInView];
}

// @property(nonatomic) BOOL delaysTouchesBegan;
- (void) setDelaysTouchesBegan___boolean:(BOOL) delaysTouchesBegan 
{
    [self setDelaysTouchesBegan:delaysTouchesBegan];
}

// @property(nonatomic) BOOL delaysTouchesBegan;
- (BOOL) delaysTouchesBegan__
{
    return [self delaysTouchesBegan];
}

// @property(nonatomic) BOOL delaysTouchesEnded;
- (void) setDelaysTouchesEnded___boolean:(BOOL) delaysTouchesEnded 
{
    [self setDelaysTouchesEnded:delaysTouchesEnded];
}

// @property(nonatomic) BOOL delaysTouchesEnded;
- (BOOL) delaysTouchesEnded__
{
    return [self delaysTouchesEnded];
}

// @property(nonatomic, weak) id<UIGestureRecognizerDelegate> delegate;
- (void) setDelegate___crossmobile_ios_uikit_UIGestureRecognizerDelegate:(id<UIGestureRecognizerDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// @property(nonatomic, weak) id<UIGestureRecognizerDelegate> delegate;
- (id<UIGestureRecognizerDelegate>) delegate__
{
    id<UIGestureRecognizerDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, getter=isEnabled) BOOL enabled;
- (void) setEnabled___boolean:(BOOL) enabled 
{
    [self setEnabled:enabled];
}

// @property(nonatomic, getter=isEnabled) BOOL enabled;
- (BOOL) isEnabled__
{
    return [self isEnabled];
}

// @property(nonatomic, readonly) UIGestureRecognizerState state;
- (int) state__
{
    return [self state];
}

// @property(nonatomic, readonly) UIView *view;
- (UIView*) view__
{
    UIView* re$ult = [self view];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)addTarget:(id)target action:(SEL)action;
- (void) addTarget___crossmobile_ios_foundation_NSSelector:(id<crossmobile_ios_foundation_NSSelector>) target 
{
    objc_setAssociatedObject(self, (void*)target, target, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self addTarget:(target == JAVA_NULL ? nil : target) action:@selector(exec___java_lang_Object:)];
}

// - (BOOL)canBePreventedByGestureRecognizer:(UIGestureRecognizer *)preventingGestureRecognizer;
- (BOOL) canBePreventedByGestureRecognizer___crossmobile_ios_uikit_UIGestureRecognizer:(UIGestureRecognizer*) preventingGestureRecognizer 
{
    return [self canBePreventedByGestureRecognizer:(preventingGestureRecognizer == JAVA_NULL ? nil : preventingGestureRecognizer)];
}

// - (BOOL)canPreventGestureRecognizer:(UIGestureRecognizer *)preventedGestureRecognizer;
- (BOOL) canPreventGestureRecognizer___crossmobile_ios_uikit_UIGestureRecognizer:(UIGestureRecognizer*) preventedGestureRecognizer 
{
    return [self canPreventGestureRecognizer:(preventedGestureRecognizer == JAVA_NULL ? nil : preventedGestureRecognizer)];
}

// - (CGPoint)locationInView:(UIView *)view;
- (crossmobile_ios_coregraphics_CGPoint*) locationInView___crossmobile_ios_uikit_UIView:(UIView*) view 
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[self locationInView:(view == JAVA_NULL ? nil : view)]];
}

// - (CGPoint)locationOfTouch:(NSUInteger)touchIndex inView:(UIView *)view;
- (crossmobile_ios_coregraphics_CGPoint*) locationOfTouch___int_crossmobile_ios_uikit_UIView:(int) touchIndex :(UIView*) view 
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[self locationOfTouch:touchIndex inView:(view == JAVA_NULL ? nil : view)]];
}

// - (NSUInteger)numberOfTouches;
- (int) numberOfTouches__
{
    return [self numberOfTouches];
}

// - (void)removeTarget:(id)target action:(SEL)action;
- (void) removeTarget___crossmobile_ios_foundation_NSSelector:(id<crossmobile_ios_foundation_NSSelector>) target 
{
    objc_setAssociatedObject(self, (void*)target, nil, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self removeTarget:(target == JAVA_NULL ? nil : target) action:@selector(exec___java_lang_Object:)];
}

// - (void)requireGestureRecognizerToFail:(UIGestureRecognizer *)otherGestureRecognizer;
- (void) requireGestureRecognizerToFail___crossmobile_ios_uikit_UIGestureRecognizer:(UIGestureRecognizer*) otherGestureRecognizer 
{
    [self requireGestureRecognizerToFail:(otherGestureRecognizer == JAVA_NULL ? nil : otherGestureRecognizer)];
}

// - (void)reset;
- (void) reset__
{
    [self reset];
}

// - (void)touchesBegan:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event;
- (void) touchesBegan___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event 
{
    [self touchesBegan:(touches == JAVA_NULL ? nil : touches) withEvent:(event == JAVA_NULL ? nil : event)];
}

// - (void)touchesCancelled:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event;
- (void) touchesCancelled___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event 
{
    [self touchesCancelled:(touches == JAVA_NULL ? nil : touches) withEvent:(event == JAVA_NULL ? nil : event)];
}

// - (void)touchesEnded:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event;
- (void) touchesEnded___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event 
{
    [self touchesEnded:(touches == JAVA_NULL ? nil : touches) withEvent:(event == JAVA_NULL ? nil : event)];
}

// - (void)touchesMoved:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event;
- (void) touchesMoved___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event 
{
    [self touchesMoved:(touches == JAVA_NULL ? nil : touches) withEvent:(event == JAVA_NULL ? nil : event)];
}

@end
