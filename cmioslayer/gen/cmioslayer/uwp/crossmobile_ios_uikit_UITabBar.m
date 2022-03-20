// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UITabBar implementation

#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_uikit_UIColor.h"
#import "crossmobile_ios_uikit_UIImage.h"
#import "crossmobile_ios_uikit_UITabBar.h"
#import "crossmobile_ios_uikit_UITabBarDelegate.h"
#import "crossmobile_ios_uikit_UITabBarItem.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UITabBar$Ext

@end

@implementation UITabBar (cm_crossmobile_ios_uikit_UITabBar)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UITabBar appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UITabBar appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UITabBar__
{
    return [self init];
}

// - (instancetype)initWithFrame:(CGRect)frame;
- (instancetype) __init_crossmobile_ios_uikit_UITabBar___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame 
{
    return [self initWithFrame:[frame getCGRect]];
}

// @property(nonatomic, strong) UIImage *backgroundImage;
- (void) setBackgroundImage___crossmobile_ios_uikit_UIImage:(UIImage*) backgroundImage 
{
    [self setBackgroundImage:(backgroundImage == JAVA_NULL ? nil : backgroundImage)];
}

// @property(nonatomic, strong) UIImage *backgroundImage;
- (UIImage*) backgroundImage__
{
    UIImage* re$ult = [self backgroundImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
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

// @property(nonatomic, weak) id<UITabBarDelegate> delegate;
- (void) setDelegate___crossmobile_ios_uikit_UITabBarDelegate:(id<UITabBarDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// @property(nonatomic, weak) id<UITabBarDelegate> delegate;
- (id<UITabBarDelegate>) delegate__
{
    id<UITabBarDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) UITabBarItemPositioning itemPositioning;
- (void) setItemPositioning___int:(int) itemPositioning 
{
    [self setItemPositioning:itemPositioning];
}

// @property(nonatomic) UITabBarItemPositioning itemPositioning;
- (int) itemPositioning__
{
    return [self itemPositioning];
}

// @property(nonatomic) CGFloat itemSpacing;
- (void) setItemSpacing___double:(double) itemSpacing 
{
    [self setItemSpacing:itemSpacing];
}

// @property(nonatomic) CGFloat itemSpacing;
- (double) itemSpacing__
{
    return [self itemSpacing];
}

// @property(nonatomic) CGFloat itemWidth;
- (void) setItemWidth___double:(double) itemWidth 
{
    [self setItemWidth:itemWidth];
}

// @property(nonatomic) CGFloat itemWidth;
- (double) itemWidth__
{
    return [self itemWidth];
}

// @property(nonatomic, copy) NSArray<UITabBarItem *> *items;
- (void) setItems___java_util_List:(NSArray*) items 
{
    [self setItems:(items == JAVA_NULL ? nil : items)];
}

// @property(nonatomic, copy) NSArray<UITabBarItem *> *items;
- (NSArray*) items__
{
    NSArray* re$ult = [self items];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, strong) UIColor *selectedImageTintColor;
- (void) setSelectedImageTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) selectedImageTintColor 
{
    [self setSelectedImageTintColor:(selectedImageTintColor == JAVA_NULL ? nil : selectedImageTintColor)];
}

// @property(nonatomic, strong) UIColor *selectedImageTintColor;
- (UIColor*) selectedImageTintColor__
{
    UIColor* re$ult = [self selectedImageTintColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, weak) UITabBarItem *selectedItem;
- (void) setSelectedItem___crossmobile_ios_uikit_UITabBarItem:(UITabBarItem*) selectedItem 
{
    objc_setAssociatedObject(self, @selector(setSelectedItem:), selectedItem, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setSelectedItem:(selectedItem == JAVA_NULL ? nil : selectedItem)];
}

// @property(nonatomic, weak) UITabBarItem *selectedItem;
- (UITabBarItem*) selectedItem__
{
    UITabBarItem* re$ult = [self selectedItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, strong) UIImage *selectionIndicatorImage;
- (void) setSelectionIndicatorImage___crossmobile_ios_uikit_UIImage:(UIImage*) selectionIndicatorImage 
{
    [self setSelectionIndicatorImage:(selectionIndicatorImage == JAVA_NULL ? nil : selectionIndicatorImage)];
}

// @property(nonatomic, strong) UIImage *selectionIndicatorImage;
- (UIImage*) selectionIndicatorImage__
{
    UIImage* re$ult = [self selectionIndicatorImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, strong) UIImage *shadowImage;
- (void) setShadowImage___crossmobile_ios_uikit_UIImage:(UIImage*) shadowImage 
{
    [self setShadowImage:(shadowImage == JAVA_NULL ? nil : shadowImage)];
}

// @property(nonatomic, strong) UIImage *shadowImage;
- (UIImage*) shadowImage__
{
    UIImage* re$ult = [self shadowImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, getter=isTranslucent) BOOL translucent;
- (void) setTranslucent___boolean:(BOOL) translucent 
{
    [self setTranslucent:translucent];
}

// @property(nonatomic, getter=isTranslucent) BOOL translucent;
- (BOOL) isTranslucent__
{
    return [self isTranslucent];
}

// - (void)beginCustomizingItems:(NSArray<UITabBarItem *> *)items;
- (void) beginCustomizingItems___java_util_List:(NSArray*) items 
{
    [self beginCustomizingItems:(items == JAVA_NULL ? nil : items)];
}

// - (BOOL)endCustomizingAnimated:(BOOL)animated;
- (BOOL) endCustomizingAnimated___boolean:(BOOL) animated 
{
    return [self endCustomizingAnimated:animated];
}

// - (BOOL)isCustomizing;
- (BOOL) isCustomizing__
{
    return [self isCustomizing];
}

// - (void)setItems:(NSArray<UITabBarItem *> *)items animated:(BOOL)animated;
- (void) setItems___java_util_List_boolean:(NSArray*) items :(BOOL) animated 
{
    [self setItems:(items == JAVA_NULL ? nil : items) animated:animated];
}

@end
