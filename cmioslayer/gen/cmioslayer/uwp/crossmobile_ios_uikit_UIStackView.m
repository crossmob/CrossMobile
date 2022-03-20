// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIStackView implementation

#import "crossmobile_ios_uikit_UIStackView.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UIStackView$Ext

@end

@implementation UIStackView (cm_crossmobile_ios_uikit_UIStackView)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIStackView appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIStackView appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// - (instancetype)initWithArrangedSubviews:(NSArray<__kindof UIView *> *)views;
- (instancetype) __init_crossmobile_ios_uikit_UIStackView___java_util_List:(NSArray*) views 
{
    return [self initWithArrangedSubviews:(views == JAVA_NULL ? nil : views)];
}

// @property(nonatomic) UIStackViewAlignment alignment;
- (void) setAlignment___int:(int) alignment 
{
    [self setAlignment:alignment];
}

// @property(nonatomic) UIStackViewAlignment alignment;
- (int) alignment__
{
    return [self alignment];
}

// @property(nonatomic, readonly, copy) NSArray<__kindof UIView *> *arrangedSubviews;
- (NSArray*) arrangedSubviews__
{
    NSArray* re$ult = [self arrangedSubviews];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) UILayoutConstraintAxis axis;
- (void) setAxis___int:(int) axis 
{
    [self setAxis:axis];
}

// @property(nonatomic) UILayoutConstraintAxis axis;
- (int) axis__
{
    return [self axis];
}

// @property(nonatomic, getter=isBaselineRelativeArrangement) BOOL baselineRelativeArrangement;
- (void) setBaselineRelativeArrangement___boolean:(BOOL) baselineRelativeArrangement 
{
    [self setBaselineRelativeArrangement:baselineRelativeArrangement];
}

// @property(nonatomic, getter=isBaselineRelativeArrangement) BOOL baselineRelativeArrangement;
- (BOOL) isBaselineRelativeArrangement__
{
    return [self isBaselineRelativeArrangement];
}

// @property(nonatomic) UIStackViewDistribution distribution;
- (void) setDistribution___int:(int) distribution 
{
    [self setDistribution:distribution];
}

// @property(nonatomic) UIStackViewDistribution distribution;
- (int) distribution__
{
    return [self distribution];
}

// @property(nonatomic, getter=isLayoutMarginsRelativeArrangement) BOOL layoutMarginsRelativeArrangement;
- (void) setLayoutMarginsRelativeArrangement___boolean:(BOOL) layoutMarginsRelativeArrangement 
{
    [self setLayoutMarginsRelativeArrangement:layoutMarginsRelativeArrangement];
}

// @property(nonatomic, getter=isLayoutMarginsRelativeArrangement) BOOL layoutMarginsRelativeArrangement;
- (BOOL) isLayoutMarginsRelativeArrangement__
{
    return [self isLayoutMarginsRelativeArrangement];
}

// @property(nonatomic) CGFloat spacing;
- (void) setSpacing___double:(double) spacing 
{
    [self setSpacing:spacing];
}

// @property(nonatomic) CGFloat spacing;
- (double) spacing__
{
    return [self spacing];
}

// - (void)addArrangedSubview:(UIView *)view;
- (void) addArrangedSubview___crossmobile_ios_uikit_UIView:(UIView*) view 
{
    [self addArrangedSubview:(view == JAVA_NULL ? nil : view)];
}

// - (void)insertArrangedSubview:(UIView *)view atIndex:(NSUInteger)stackIndex;
- (void) insertArrangedSubview___crossmobile_ios_uikit_UIView_int:(UIView*) view :(int) stackIndex 
{
    [self insertArrangedSubview:(view == JAVA_NULL ? nil : view) atIndex:stackIndex];
}

// - (void)removeArrangedSubview:(UIView *)view;
- (void) removeArrangedSubview___crossmobile_ios_uikit_UIView:(UIView*) view 
{
    [self removeArrangedSubview:(view == JAVA_NULL ? nil : view)];
}

@end
