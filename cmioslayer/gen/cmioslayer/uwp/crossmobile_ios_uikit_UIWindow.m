// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIWindow implementation

#import "crossmobile_ios_coregraphics_CGPoint.h"
#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_uikit_UIEvent.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "crossmobile_ios_uikit_UIViewController.h"
#import "crossmobile_ios_uikit_UIWindow.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UIWindow$Ext

@end

@implementation UIWindow (cm_crossmobile_ios_uikit_UIWindow)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIWindow appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIWindow appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UIWindow__
{
    return [self init];
}

// - (instancetype)initWithFrame:(CGRect)frame;
- (instancetype) __init_crossmobile_ios_uikit_UIWindow___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame 
{
    return [self initWithFrame:[frame getCGRect]];
}

// @property(nonatomic, strong) UIViewController *rootViewController;
- (void) setRootViewController___crossmobile_ios_uikit_UIViewController:(UIViewController*) rootViewController 
{
    [self setRootViewController:(rootViewController == JAVA_NULL ? nil : rootViewController)];
}

// @property(nonatomic, strong) UIViewController *rootViewController;
- (UIViewController*) rootViewController__
{
    UIViewController* re$ult = [self rootViewController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (CGPoint)convertPoint:(CGPoint)point fromWindow:(UIWindow *)window;
- (crossmobile_ios_coregraphics_CGPoint*) convertPointFromWindow___crossmobile_ios_coregraphics_CGPoint_crossmobile_ios_uikit_UIWindow:(crossmobile_ios_coregraphics_CGPoint*) point :(UIWindow*) window 
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[self convertPoint:[point getCGPoint] fromWindow:(window == JAVA_NULL ? nil : window)]];
}

// - (CGPoint)convertPoint:(CGPoint)point toWindow:(UIWindow *)window;
- (crossmobile_ios_coregraphics_CGPoint*) convertPointToWindow___crossmobile_ios_coregraphics_CGPoint_crossmobile_ios_uikit_UIWindow:(crossmobile_ios_coregraphics_CGPoint*) point :(UIWindow*) window 
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[self convertPoint:[point getCGPoint] toWindow:(window == JAVA_NULL ? nil : window)]];
}

// - (CGRect)convertRect:(CGRect)rect fromWindow:(UIWindow *)window;
- (crossmobile_ios_coregraphics_CGRect*) convertRectFromWindow___crossmobile_ios_coregraphics_CGRect_crossmobile_ios_uikit_UIWindow:(crossmobile_ios_coregraphics_CGRect*) rect :(UIWindow*) window 
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:[self convertRect:[rect getCGRect] fromWindow:(window == JAVA_NULL ? nil : window)]];
}

// - (CGRect)convertRect:(CGRect)rect toWindow:(UIWindow *)window;
- (crossmobile_ios_coregraphics_CGRect*) convertRectToWindow___crossmobile_ios_coregraphics_CGRect_crossmobile_ios_uikit_UIWindow:(crossmobile_ios_coregraphics_CGRect*) rect :(UIWindow*) window 
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:[self convertRect:[rect getCGRect] toWindow:(window == JAVA_NULL ? nil : window)]];
}

// - (void)makeKeyAndVisible;
- (void) makeKeyAndVisible__
{
    [self makeKeyAndVisible];
}

// - (void)sendEvent:(UIEvent *)event;
- (void) sendEvent___crossmobile_ios_uikit_UIEvent:(UIEvent*) event 
{
    [self sendEvent:(event == JAVA_NULL ? nil : event)];
}

@end
