// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIControl implementation

#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_uikit_UIControl.h"
#import "crossmobile_ios_uikit_UIControlDelegate.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "java_lang_reflect_Method.h"
#import "java_util_List.h"
#import "java_util_Set.h"

@implementation crossmobile_ios_uikit_UIControl$Ext

@end

@implementation UIControl (cm_crossmobile_ios_uikit_UIControl)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIControl appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIControl appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UIControl__
{
    return [self init];
}

// - (instancetype)initWithFrame:(CGRect)frame;
- (instancetype) __init_crossmobile_ios_uikit_UIControl___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame 
{
    return [self initWithFrame:[frame getCGRect]];
}

// @property(nonatomic, readonly) NSSet *allTargets;
- (NSSet*) allTargets__
{
    NSSet* re$ult = [self allTargets];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) UIControlContentHorizontalAlignment contentHorizontalAlignment;
- (void) setContentHorizontalAlignment___int:(int) contentHorizontalAlignment 
{
    [self setContentHorizontalAlignment:contentHorizontalAlignment];
}

// @property(nonatomic) UIControlContentHorizontalAlignment contentHorizontalAlignment;
- (int) contentHorizontalAlignment__
{
    return [self contentHorizontalAlignment];
}

// @property(nonatomic) UIControlContentVerticalAlignment contentVerticalAlignment;
- (void) setContentVerticalAlignment___int:(int) contentVerticalAlignment 
{
    [self setContentVerticalAlignment:contentVerticalAlignment];
}

// @property(nonatomic) UIControlContentVerticalAlignment contentVerticalAlignment;
- (int) contentVerticalAlignment__
{
    return [self contentVerticalAlignment];
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

// @property(nonatomic, getter=isHighlighted) BOOL highlighted;
- (void) setHighlighted___boolean:(BOOL) highlighted 
{
    [self setHighlighted:highlighted];
}

// @property(nonatomic, getter=isHighlighted) BOOL highlighted;
- (BOOL) isHighlighted__
{
    return [self isHighlighted];
}

// @property(nonatomic, getter=isSelected) BOOL selected;
- (void) setSelected___boolean:(BOOL) selected 
{
    [self setSelected:selected];
}

// @property(nonatomic, getter=isSelected) BOOL selected;
- (BOOL) isSelected__
{
    return [self isSelected];
}

// @property(nonatomic, readonly) UIControlState state;
- (int) state__
{
    return [self state];
}

// - (void)addTarget:(id)target action:(SEL)action forControlEvents:(UIControlEvents)controlEvents;
- (void) addTarget___crossmobile_ios_uikit_UIControlDelegate_int:(id<crossmobile_ios_uikit_UIControlDelegate>) target :(int) controlEvents 
{
    if (target == JAVA_NULL)
        return;
    if (controlEvents == 0)
        return;
    objc_setAssociatedObject(self, (void*)target, target, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self addTarget:(target == JAVA_NULL ? nil : target) action:@selector(exec___crossmobile_ios_uikit_UIControl_crossmobile_ios_uikit_UIEvent::) forControlEvents:controlEvents];
}

// - (void)removeTarget:(id)target action:(SEL)action forControlEvents:(UIControlEvents)controlEvents;
- (void) removeTarget___crossmobile_ios_uikit_UIControlDelegate_int:(id<crossmobile_ios_uikit_UIControlDelegate>) target :(int) controlEvents 
{
    if (target == JAVA_NULL)
        return;
    if (controlEvents == 0)
        return;
    objc_setAssociatedObject(self, (void*)target, nil, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self removeTarget:(target == JAVA_NULL ? nil : target) action:@selector(exec___crossmobile_ios_uikit_UIControl_crossmobile_ios_uikit_UIEvent::) forControlEvents:controlEvents];
}

// - (void)sendActionsForControlEvents:(UIControlEvents)controlEvents;
- (void) sendActionsForControlEvents___int:(int) controlEvents 
{
    [self sendActionsForControlEvents:controlEvents];
}

@end
