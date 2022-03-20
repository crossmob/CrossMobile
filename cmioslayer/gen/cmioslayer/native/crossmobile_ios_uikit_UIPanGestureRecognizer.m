// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIPanGestureRecognizer implementation

#import "crossmobile_ios_coregraphics_CGPoint.h"
#import "crossmobile_ios_foundation_NSSelector.h"
#import "crossmobile_ios_uikit_UIPanGestureRecognizer.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "java_lang_reflect_Method.h"

@implementation crossmobile_ios_uikit_UIPanGestureRecognizer$Ext

@end

@implementation UIPanGestureRecognizer (cm_crossmobile_ios_uikit_UIPanGestureRecognizer)

// - (instancetype)initWithTarget:(id)target action:(SEL)action;
- (instancetype) __init_crossmobile_ios_uikit_UIPanGestureRecognizer___crossmobile_ios_foundation_NSSelector:(id<crossmobile_ios_foundation_NSSelector>) target 
{
    objc_setAssociatedObject(self, (void*)target, target, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    return [self initWithTarget:(target == JAVA_NULL ? nil : target) action:@selector(exec___java_lang_Object:)];
}

// @property(nonatomic) NSUInteger maximumNumberOfTouches;
- (void) setMaximumNumberOfTouches___int:(int) maximumNumberOfTouches 
{
    [self setMaximumNumberOfTouches:maximumNumberOfTouches];
}

// @property(nonatomic) NSUInteger maximumNumberOfTouches;
- (int) maximumNumberOfTouches__
{
    return [self maximumNumberOfTouches];
}

// @property(nonatomic) NSUInteger minimumNumberOfTouches;
- (void) setMinimumNumberOfTouches___int:(int) minimumNumberOfTouches 
{
    [self setMinimumNumberOfTouches:minimumNumberOfTouches];
}

// @property(nonatomic) NSUInteger minimumNumberOfTouches;
- (int) minimumNumberOfTouches__
{
    return [self minimumNumberOfTouches];
}

// - (void)setTranslation:(CGPoint)translation inView:(UIView *)view;
- (void) setTranslation___crossmobile_ios_coregraphics_CGPoint_crossmobile_ios_uikit_UIView:(crossmobile_ios_coregraphics_CGPoint*) translation :(UIView*) view 
{
    [self setTranslation:[translation getCGPoint] inView:(view == JAVA_NULL ? nil : view)];
}

// - (CGPoint)translationInView:(UIView *)view;
- (crossmobile_ios_coregraphics_CGPoint*) translationInView___crossmobile_ios_uikit_UIView:(UIView*) view 
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[self translationInView:(view == JAVA_NULL ? nil : view)]];
}

// - (CGPoint)velocityInView:(UIView *)view;
- (crossmobile_ios_coregraphics_CGPoint*) velocityInView___crossmobile_ios_uikit_UIView:(UIView*) view 
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[self velocityInView:(view == JAVA_NULL ? nil : view)]];
}

@end
