// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UINavigationBar implementation

#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_uikit_UIColor.h"
#import "crossmobile_ios_uikit_UINavigationBar.h"
#import "crossmobile_ios_uikit_UINavigationBarDelegate.h"
#import "crossmobile_ios_uikit_UINavigationItem.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "java_util_List.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_uikit_UINavigationBar$Ext

@end

@implementation UINavigationBar (cm_crossmobile_ios_uikit_UINavigationBar)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UINavigationBar appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UINavigationBar appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UINavigationBar__
{
    return [self init];
}

// - (instancetype)initWithFrame:(CGRect)frame;
- (instancetype) __init_crossmobile_ios_uikit_UINavigationBar___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame 
{
    return [self initWithFrame:[frame getCGRect]];
}

// @property(nonatomic, readonly, strong) UINavigationItem *backItem;
- (UINavigationItem*) backItem__
{
    UINavigationItem* re$ult = [self backItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, assign) UIBarStyle barStyle;
- (void) setBarStyle___int:(int) barStyle 
{
    [self setBarStyle:barStyle];
}

// @property(nonatomic, assign) UIBarStyle barStyle;
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

// @property(nonatomic, weak) id<UINavigationBarDelegate> delegate;
- (void) setDelegate___crossmobile_ios_uikit_UINavigationBarDelegate:(id<UINavigationBarDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// @property(nonatomic, weak) id<UINavigationBarDelegate> delegate;
- (id<UINavigationBarDelegate>) delegate__
{
    id<UINavigationBarDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, copy) NSArray<UINavigationItem *> *items;
- (void) setItems___java_util_List:(NSArray*) items 
{
    [self setItems:(items == JAVA_NULL ? nil : items)];
}

// @property(nonatomic, copy) NSArray<UINavigationItem *> *items;
- (NSArray*) items__
{
    NSArray* re$ult = [self items];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, copy) NSDictionary<NSString *,id> *titleTextAttributes;
- (void) setTitleTextAttributes___java_util_Map:(NSDictionary*) titleTextAttributes 
{
    [self setTitleTextAttributes:(titleTextAttributes == JAVA_NULL ? nil : titleTextAttributes)];
}

// @property(nonatomic, copy) NSDictionary<NSString *,id> *titleTextAttributes;
- (NSDictionary*) titleTextAttributes__
{
    NSDictionary* re$ult = [self titleTextAttributes];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, strong) UINavigationItem *topItem;
- (UINavigationItem*) topItem__
{
    UINavigationItem* re$ult = [self topItem];
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

// - (UINavigationItem *)popNavigationItemAnimated:(BOOL)animated;
- (UINavigationItem*) popNavigationItemAnimated___boolean:(BOOL) animated 
{
    UINavigationItem* re$ult = [self popNavigationItemAnimated:animated];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)pushNavigationItem:(UINavigationItem *)item animated:(BOOL)animated;
- (void) pushNavigationItem___crossmobile_ios_uikit_UINavigationItem_boolean:(UINavigationItem*) item :(BOOL) animated 
{
    [self pushNavigationItem:(item == JAVA_NULL ? nil : item) animated:animated];
}

// - (void)setItems:(NSArray<UINavigationItem *> *)items animated:(BOOL)animated;
- (void) setItems___java_util_List_boolean:(NSArray*) items :(BOOL) animated 
{
    [self setItems:(items == JAVA_NULL ? nil : items) animated:animated];
}

@end
