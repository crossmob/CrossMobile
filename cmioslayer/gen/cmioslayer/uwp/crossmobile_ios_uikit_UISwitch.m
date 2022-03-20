// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UISwitch implementation

#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_uikit_UIColor.h"
#import "crossmobile_ios_uikit_UISwitch.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UISwitch$Ext

@end

@implementation UISwitch (cm_crossmobile_ios_uikit_UISwitch)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UISwitch appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UISwitch appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UISwitch__
{
    return [self init];
}

// - (instancetype)initWithFrame:(CGRect)frame;
- (instancetype) __init_crossmobile_ios_uikit_UISwitch___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame 
{
    return [self initWithFrame:[frame getCGRect]];
}

// @property(nonatomic, getter=isOn) BOOL on;
- (void) setOn___boolean:(BOOL) on 
{
    [self setOn:on];
}

// @property(nonatomic, getter=isOn) BOOL on;
- (BOOL) isOn__
{
    return [self isOn];
}

// @property(nonatomic, strong) UIColor *onTintColor;
- (void) setOnTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) onTintColor 
{
    [self setOnTintColor:(onTintColor == JAVA_NULL ? nil : onTintColor)];
}

// @property(nonatomic, strong) UIColor *onTintColor;
- (UIColor*) onTintColor__
{
    UIColor* re$ult = [self onTintColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, strong) UIColor *thumbTintColor;
- (void) setThumbTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) thumbTintColor 
{
    [self setThumbTintColor:(thumbTintColor == JAVA_NULL ? nil : thumbTintColor)];
}

// @property(nonatomic, strong) UIColor *thumbTintColor;
- (UIColor*) thumbTintColor__
{
    UIColor* re$ult = [self thumbTintColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)setOn:(BOOL)on animated:(BOOL)animated;
- (void) setOn___boolean_boolean:(BOOL) on :(BOOL) animated 
{
    [self setOn:on animated:animated];
}

@end
