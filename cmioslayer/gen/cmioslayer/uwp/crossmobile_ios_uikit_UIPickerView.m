// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIPickerView implementation

#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_coregraphics_CGSize.h"
#import "crossmobile_ios_uikit_UIPickerView.h"
#import "crossmobile_ios_uikit_UIPickerViewDataSource.h"
#import "crossmobile_ios_uikit_UIPickerViewDelegate.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UIPickerView$Ext

@end

@implementation UIPickerView (cm_crossmobile_ios_uikit_UIPickerView)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIPickerView appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIPickerView appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UIPickerView__
{
    return [self init];
}

// - (instancetype)initWithFrame:(CGRect)frame;
- (instancetype) __init_crossmobile_ios_uikit_UIPickerView___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame 
{
    return [self initWithFrame:[frame getCGRect]];
}

// @property(nonatomic, weak) id<UIPickerViewDataSource> dataSource;
- (void) setDataSource___crossmobile_ios_uikit_UIPickerViewDataSource:(id<UIPickerViewDataSource>) dataSource 
{
    objc_setAssociatedObject(self, @selector(setDataSource:), dataSource, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDataSource:(dataSource == JAVA_NULL ? nil : dataSource)];
}

// @property(nonatomic, weak) id<UIPickerViewDataSource> dataSource;
- (id<UIPickerViewDataSource>) dataSource__
{
    id<UIPickerViewDataSource> re$ult = [self dataSource];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, weak) id<UIPickerViewDelegate> delegate;
- (void) setDelegate___crossmobile_ios_uikit_UIPickerViewDelegate:(id<UIPickerViewDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// @property(nonatomic, weak) id<UIPickerViewDelegate> delegate;
- (id<UIPickerViewDelegate>) delegate__
{
    id<UIPickerViewDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) NSInteger numberOfComponents;
- (int) numberOfComponents__
{
    return [self numberOfComponents];
}

// @property(nonatomic) BOOL showsSelectionIndicator;
- (void) setShowsSelectionIndicator___boolean:(BOOL) showsSelectionIndicator 
{
    [self setShowsSelectionIndicator:showsSelectionIndicator];
}

// @property(nonatomic) BOOL showsSelectionIndicator;
- (BOOL) showsSelectionIndicator__
{
    return [self showsSelectionIndicator];
}

// - (NSInteger)numberOfRowsInComponent:(NSInteger)component;
- (int) numberOfRowsInComponent___int:(int) component 
{
    return [self numberOfRowsInComponent:component];
}

// - (void)reloadAllComponents;
- (void) reloadAllComponents__
{
    [self reloadAllComponents];
}

// - (void)reloadComponent:(NSInteger)component;
- (void) reloadComponent___int:(int) component 
{
    [self reloadComponent:component];
}

// - (CGSize)rowSizeForComponent:(NSInteger)component;
- (crossmobile_ios_coregraphics_CGSize*) rowSizeForComponent___int:(int) component 
{
    return [[crossmobile_ios_coregraphics_CGSize alloc] initWithCGSize:[self rowSizeForComponent:component]];
}

// - (void)selectRow:(NSInteger)row inComponent:(NSInteger)component animated:(BOOL)animated;
- (void) selectRow___int_int_boolean:(int) row :(int) component :(BOOL) animated 
{
    [self selectRow:row inComponent:component animated:animated];
}

// - (NSInteger)selectedRowInComponent:(NSInteger)component;
- (int) selectedRowInComponent___int:(int) component 
{
    return [self selectedRowInComponent:component];
}

// - (UIView *)viewForRow:(NSInteger)row forComponent:(NSInteger)component;
- (UIView*) viewForRow___int_int:(int) row :(int) component 
{
    UIView* re$ult = [self viewForRow:row forComponent:component];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
