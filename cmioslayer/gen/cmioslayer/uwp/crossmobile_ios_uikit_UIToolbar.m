// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIToolbar implementation

#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_uikit_UIColor.h"
#import "crossmobile_ios_uikit_UIToolbar.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UIToolbar$Ext

@end

@implementation UIToolbar (cm_crossmobile_ios_uikit_UIToolbar)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIToolbar appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIToolbar appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UIToolbar__
{
    return [self init];
}

// - (instancetype)initWithFrame:(CGRect)frame;
- (instancetype) __init_crossmobile_ios_uikit_UIToolbar___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame 
{
    return [self initWithFrame:[frame getCGRect]];
}

// @property(nonatomic) UIBarStyle barStyle;
- (void) setBarStyle___int:(int) barStyle 
{
    [self setBarStyle:barStyle];
}

// @property(nonatomic) UIBarStyle barStyle;
- (int) barStyle__
{
    return [self barStyle];
}

// @property(nonatomic, strong) UIColor *barTintColor;
- (void) setBarTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) barTintColor 
{
    [self setBarTintColor:(barTintColor == JAVA_NULL ? nil : barTintColor)];
}

// @property(nonatomic, strong) UIColor *barTintColor;
- (UIColor*) barTintColor__
{
    UIColor* re$ult = [self barTintColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, copy) NSArray<UIBarButtonItem *> *items;
- (void) setItems___java_util_List:(NSArray*) items 
{
    [self setItems:(items == JAVA_NULL ? nil : items)];
}

// @property(nonatomic, copy) NSArray<UIBarButtonItem *> *items;
- (NSArray*) items__
{
    NSArray* re$ult = [self items];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, assign, getter=isTranslucent) BOOL translucent;
- (void) setTranslucent___boolean:(BOOL) translucent 
{
    [self setTranslucent:translucent];
}

// @property(nonatomic, assign, getter=isTranslucent) BOOL translucent;
- (BOOL) isTranslucent__
{
    return [self isTranslucent];
}

// - (void)setItems:(NSArray<UIBarButtonItem *> *)items animated:(BOOL)animated;
- (void) setItems___java_util_List_boolean:(NSArray*) items :(BOOL) animated 
{
    [self setItems:(items == JAVA_NULL ? nil : items) animated:animated];
}

@end
