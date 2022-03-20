// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIActivityIndicatorView implementation

#import "crossmobile_ios_uikit_UIActivityIndicatorView.h"
#import "crossmobile_ios_uikit_UIColor.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UIActivityIndicatorView$Ext

@end

@implementation UIActivityIndicatorView (cm_crossmobile_ios_uikit_UIActivityIndicatorView)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIActivityIndicatorView appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIActivityIndicatorView appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UIActivityIndicatorView__
{
    return [self init];
}

// - (instancetype)initWithActivityIndicatorStyle:(UIActivityIndicatorViewStyle)style;
- (instancetype) __init_crossmobile_ios_uikit_UIActivityIndicatorView___int:(int) style 
{
    return [self initWithActivityIndicatorStyle:style];
}

// @property(nonatomic) UIActivityIndicatorViewStyle activityIndicatorViewStyle ;
- (void) setActivityIndicatorViewStyle___int:(int) activityIndicatorViewStyle 
{
    [self setActivityIndicatorViewStyle:activityIndicatorViewStyle];
}

// @property(nonatomic) UIActivityIndicatorViewStyle activityIndicatorViewStyle ;
- (int) activityIndicatorViewStyle__
{
    return [self activityIndicatorViewStyle];
}

// @property(nonatomic, readonly, getter=isAnimating) BOOL animating;
- (BOOL) isAnimating__
{
    return [self isAnimating];
}

// @property(readwrite, nonatomic, strong) UIColor *color;
- (void) setColor___crossmobile_ios_uikit_UIColor:(UIColor*) color 
{
    [self setColor:(color == JAVA_NULL ? nil : color)];
}

// @property(readwrite, nonatomic, strong) UIColor *color;
- (UIColor*) color__
{
    UIColor* re$ult = [self color];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) BOOL hidesWhenStopped ;
- (void) setHidesWhenStopped___boolean:(BOOL) hidesWhenStopped 
{
    [self setHidesWhenStopped:hidesWhenStopped];
}

// @property(nonatomic) BOOL hidesWhenStopped ;
- (BOOL) hidesWhenStopped__
{
    return [self hidesWhenStopped];
}

// - (void)startAnimating;
- (void) startAnimating__
{
    [self startAnimating];
}

// - (void)stopAnimating;
- (void) stopAnimating__
{
    [self stopAnimating];
}

@end
