// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIProgressView implementation

#import "crossmobile_ios_uikit_UIColor.h"
#import "crossmobile_ios_uikit_UIProgressView.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UIProgressView$Ext

@end

@implementation UIProgressView (cm_crossmobile_ios_uikit_UIProgressView)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIProgressView appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIProgressView appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// - (instancetype)initWithProgressViewStyle:(UIProgressViewStyle)style;
- (instancetype) __init_crossmobile_ios_uikit_UIProgressView___int:(int) style 
{
    return [self initWithProgressViewStyle:style];
}

// @property(nonatomic) float progress;
- (void) setProgress___float:(float) progress 
{
    [self setProgress:progress];
}

// @property(nonatomic) float progress;
- (float) progress__
{
    return [self progress];
}

// @property(nonatomic, strong) UIColor *progressTintColor;
- (void) setProgressTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) progressTintColor 
{
    [self setProgressTintColor:(progressTintColor == JAVA_NULL ? nil : progressTintColor)];
}

// @property(nonatomic, strong) UIColor *progressTintColor;
- (UIColor*) progressTintColor__
{
    UIColor* re$ult = [self progressTintColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) UIProgressViewStyle progressViewStyle;
- (void) setProgressViewStyle___int:(int) progressViewStyle 
{
    [self setProgressViewStyle:progressViewStyle];
}

// @property(nonatomic) UIProgressViewStyle progressViewStyle;
- (int) progressViewStyle__
{
    return [self progressViewStyle];
}

// @property(nonatomic, strong) UIColor *trackTintColor;
- (void) setTrackTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) trackTintColor 
{
    [self setTrackTintColor:(trackTintColor == JAVA_NULL ? nil : trackTintColor)];
}

// @property(nonatomic, strong) UIColor *trackTintColor;
- (UIColor*) trackTintColor__
{
    UIColor* re$ult = [self trackTintColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
