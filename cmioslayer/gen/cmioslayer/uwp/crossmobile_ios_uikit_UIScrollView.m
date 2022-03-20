// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIScrollView implementation

#import "crossmobile_ios_coregraphics_CGPoint.h"
#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_coregraphics_CGSize.h"
#import "crossmobile_ios_uikit_UIEdgeInsets.h"
#import "crossmobile_ios_uikit_UIEvent.h"
#import "crossmobile_ios_uikit_UIScrollView.h"
#import "crossmobile_ios_uikit_UIScrollViewDelegate.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "java_util_List.h"
#import "java_util_Set.h"

@implementation crossmobile_ios_uikit_UIScrollView$Ext

@end

@implementation UIScrollView (cm_crossmobile_ios_uikit_UIScrollView)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIScrollView appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIScrollView appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UIScrollView__
{
    return [self init];
}

// - (instancetype)initWithFrame:(CGRect)frame;
- (instancetype) __init_crossmobile_ios_uikit_UIScrollView___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame 
{
    return [self initWithFrame:[frame getCGRect]];
}

// @property(nonatomic) BOOL alwaysBounceHorizontal;
- (void) setAlwaysBounceHorizontal___boolean:(BOOL) alwaysBounceHorizontal 
{
    [self setAlwaysBounceHorizontal:alwaysBounceHorizontal];
}

// @property(nonatomic) BOOL alwaysBounceHorizontal;
- (BOOL) alwaysBounceHorizontal__
{
    return [self alwaysBounceHorizontal];
}

// @property(nonatomic) BOOL alwaysBounceVertical;
- (void) setAlwaysBounceVertical___boolean:(BOOL) alwaysBounceVertical 
{
    [self setAlwaysBounceVertical:alwaysBounceVertical];
}

// @property(nonatomic) BOOL alwaysBounceVertical;
- (BOOL) alwaysBounceVertical__
{
    return [self alwaysBounceVertical];
}

// @property(nonatomic) BOOL bounces;
- (void) setBounces___boolean:(BOOL) bounces 
{
    [self setBounces:bounces];
}

// @property(nonatomic) BOOL bounces;
- (BOOL) bounces__
{
    return [self bounces];
}

// @property(nonatomic) BOOL canCancelContentTouches;
- (void) setCanCancelContentTouches___boolean:(BOOL) canCancelContentTouches 
{
    [self setCanCancelContentTouches:canCancelContentTouches];
}

// @property(nonatomic) BOOL canCancelContentTouches;
- (BOOL) canCancelContentTouches__
{
    return [self canCancelContentTouches];
}

// @property(nonatomic) UIEdgeInsets contentInset;
- (void) setContentInset___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) contentInset 
{
    [self setContentInset:[contentInset getUIEdgeInsets]];
}

// @property(nonatomic) UIEdgeInsets contentInset;
- (crossmobile_ios_uikit_UIEdgeInsets*) contentInset__
{
    return [[crossmobile_ios_uikit_UIEdgeInsets alloc] initWithUIEdgeInsets:[self contentInset]];
}

// @property(nonatomic) CGPoint contentOffset;
- (void) setContentOffset___crossmobile_ios_coregraphics_CGPoint:(crossmobile_ios_coregraphics_CGPoint*) contentOffset 
{
    [self setContentOffset:[contentOffset getCGPoint]];
}

// @property(nonatomic) CGPoint contentOffset;
- (crossmobile_ios_coregraphics_CGPoint*) contentOffset__
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[self contentOffset]];
}

// @property(nonatomic) CGSize contentSize;
- (void) setContentSize___crossmobile_ios_coregraphics_CGSize:(crossmobile_ios_coregraphics_CGSize*) contentSize 
{
    [self setContentSize:[contentSize getCGSize]];
}

// @property(nonatomic) CGSize contentSize;
- (crossmobile_ios_coregraphics_CGSize*) contentSize__
{
    return [[crossmobile_ios_coregraphics_CGSize alloc] initWithCGSize:[self contentSize]];
}

// @property(nonatomic, readonly, getter=isDecelerating) BOOL decelerating;
- (BOOL) isDecelerating__
{
    return [self isDecelerating];
}

// @property(nonatomic) CGFloat decelerationRate;
- (void) setDecelerationRate___double:(double) decelerationRate 
{
    [self setDecelerationRate:decelerationRate];
}

// @property(nonatomic) CGFloat decelerationRate;
- (double) decelerationRate__
{
    return [self decelerationRate];
}

// @property(nonatomic) BOOL delaysContentTouches;
- (void) setDelaysContentTouches___boolean:(BOOL) delaysContentTouches 
{
    [self setDelaysContentTouches:delaysContentTouches];
}

// @property(nonatomic) BOOL delaysContentTouches;
- (BOOL) delaysContentTouches__
{
    return [self delaysContentTouches];
}

// @property(nonatomic, weak) id<UIScrollViewDelegate> delegate;
- (void) setDelegate___crossmobile_ios_uikit_UIScrollViewDelegate:(id<UIScrollViewDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// @property(nonatomic, weak) id<UIScrollViewDelegate> delegate;
- (id<UIScrollViewDelegate>) delegate__
{
    id<UIScrollViewDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, getter=isDirectionalLockEnabled) BOOL directionalLockEnabled;
- (void) setDirectionalLockEnabled___boolean:(BOOL) directionalLockEnabled 
{
    [self setDirectionalLockEnabled:directionalLockEnabled];
}

// @property(nonatomic, getter=isDirectionalLockEnabled) BOOL directionalLockEnabled;
- (BOOL) isDirectionalLockEnabled__
{
    return [self isDirectionalLockEnabled];
}

// @property(nonatomic, readonly, getter=isDragging) BOOL dragging;
- (BOOL) isDragging__
{
    return [self isDragging];
}

// @property(nonatomic) UIScrollViewIndicatorStyle indicatorStyle;
- (void) setIndicatorStyle___int:(int) indicatorStyle 
{
    [self setIndicatorStyle:indicatorStyle];
}

// @property(nonatomic) UIScrollViewIndicatorStyle indicatorStyle;
- (int) indicatorStyle__
{
    return [self indicatorStyle];
}

// @property(nonatomic, getter=isPagingEnabled) BOOL pagingEnabled;
- (void) setPagingEnabled___boolean:(BOOL) pagingEnabled 
{
    [self setPagingEnabled:pagingEnabled];
}

// @property(nonatomic, getter=isPagingEnabled) BOOL pagingEnabled;
- (BOOL) isPagingEnabled__
{
    return [self isPagingEnabled];
}

// @property(nonatomic, getter=isScrollEnabled) BOOL scrollEnabled;
- (void) setScrollEnabled___boolean:(BOOL) scrollEnabled 
{
    [self setScrollEnabled:scrollEnabled];
}

// @property(nonatomic, getter=isScrollEnabled) BOOL scrollEnabled;
- (BOOL) isScrollEnabled__
{
    return [self isScrollEnabled];
}

// @property(nonatomic) UIEdgeInsets scrollIndicatorInsets;
- (void) setScrollIndicatorInsets___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) scrollIndicatorInsets 
{
    [self setScrollIndicatorInsets:[scrollIndicatorInsets getUIEdgeInsets]];
}

// @property(nonatomic) UIEdgeInsets scrollIndicatorInsets;
- (crossmobile_ios_uikit_UIEdgeInsets*) scrollIndicatorInsets__
{
    return [[crossmobile_ios_uikit_UIEdgeInsets alloc] initWithUIEdgeInsets:[self scrollIndicatorInsets]];
}

// @property(nonatomic) BOOL scrollsToTop;
- (void) setScrollsToTop___boolean:(BOOL) scrollsToTop 
{
    [self setScrollsToTop:scrollsToTop];
}

// @property(nonatomic) BOOL scrollsToTop;
- (BOOL) scrollsToTop__
{
    return [self scrollsToTop];
}

// @property(nonatomic) BOOL showsHorizontalScrollIndicator;
- (void) setShowsHorizontalScrollIndicator___boolean:(BOOL) showsHorizontalScrollIndicator 
{
    [self setShowsHorizontalScrollIndicator:showsHorizontalScrollIndicator];
}

// @property(nonatomic) BOOL showsHorizontalScrollIndicator;
- (BOOL) showsHorizontalScrollIndicator__
{
    return [self showsHorizontalScrollIndicator];
}

// @property(nonatomic) BOOL showsVerticalScrollIndicator;
- (void) setShowsVerticalScrollIndicator___boolean:(BOOL) showsVerticalScrollIndicator 
{
    [self setShowsVerticalScrollIndicator:showsVerticalScrollIndicator];
}

// @property(nonatomic) BOOL showsVerticalScrollIndicator;
- (BOOL) showsVerticalScrollIndicator__
{
    return [self showsVerticalScrollIndicator];
}

// @property(nonatomic, readonly, getter=isTracking) BOOL tracking;
- (BOOL) isTracking__
{
    return [self isTracking];
}

// - (void)flashScrollIndicators;
- (void) flashScrollIndicators__
{
    [self flashScrollIndicators];
}

// - (void)scrollRectToVisible:(CGRect)rect animated:(BOOL)animated;
- (void) scrollRectToVisible___crossmobile_ios_coregraphics_CGRect_boolean:(crossmobile_ios_coregraphics_CGRect*) rect :(BOOL) animated 
{
    [self scrollRectToVisible:[rect getCGRect] animated:animated];
}

// - (void)setContentOffset:(CGPoint)contentOffset animated:(BOOL)animated;
- (void) setContentOffset___crossmobile_ios_coregraphics_CGPoint_boolean:(crossmobile_ios_coregraphics_CGPoint*) contentOffset :(BOOL) animated 
{
    [self setContentOffset:[contentOffset getCGPoint] animated:animated];
}

// - (BOOL)touchesShouldBegin:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event inContentView:(UIView *)view;
- (BOOL) touchesShouldBegin___java_util_Set_crossmobile_ios_uikit_UIEvent_crossmobile_ios_uikit_UIView:(NSSet*) touches :(UIEvent*) event :(UIView*) view 
{
    return [self touchesShouldBegin:(touches == JAVA_NULL ? nil : touches) withEvent:(event == JAVA_NULL ? nil : event) inContentView:(view == JAVA_NULL ? nil : view)];
}

// - (BOOL)touchesShouldCancelInContentView:(UIView *)view;
- (BOOL) touchesShouldCancelInContentView___crossmobile_ios_uikit_UIView:(UIView*) view 
{
    return [self touchesShouldCancelInContentView:(view == JAVA_NULL ? nil : view)];
}

@end
