// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UITableView implementation

#import "crossmobile_ios_coregraphics_CGPoint.h"
#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_foundation_NSIndexPath.h"
#import "crossmobile_ios_uikit_UIColor.h"
#import "crossmobile_ios_uikit_UINib.h"
#import "crossmobile_ios_uikit_UITableView.h"
#import "crossmobile_ios_uikit_UITableViewCell.h"
#import "crossmobile_ios_uikit_UITableViewDataSource.h"
#import "crossmobile_ios_uikit_UITableViewDelegate.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "java_lang_Class.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UITableView$Ext

@end

@implementation UITableView (cm_crossmobile_ios_uikit_UITableView)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UITableView appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UITableView appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UITableView__
{
    return [self init];
}

// - (instancetype)initWithFrame:(CGRect)frame;
- (instancetype) __init_crossmobile_ios_uikit_UITableView___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame 
{
    return [self initWithFrame:[frame getCGRect]];
}

// - (instancetype)initWithFrame:(CGRect)frame style:(UITableViewStyle)style;
- (instancetype) __init_crossmobile_ios_uikit_UITableView___crossmobile_ios_coregraphics_CGRect_int:(crossmobile_ios_coregraphics_CGRect*) frame :(int) style 
{
    return [self initWithFrame:[frame getCGRect] style:style];
}

// @property(nonatomic) BOOL allowsMultipleSelection;
- (void) setAllowsMultipleSelection___boolean:(BOOL) allowsMultipleSelection 
{
    [self setAllowsMultipleSelection:allowsMultipleSelection];
}

// @property(nonatomic) BOOL allowsMultipleSelection;
- (BOOL) allowsMultipleSelection__
{
    return [self allowsMultipleSelection];
}

// @property(nonatomic) BOOL allowsSelection;
- (void) setAllowsSelection___boolean:(BOOL) allowsSelection 
{
    [self setAllowsSelection:allowsSelection];
}

// @property(nonatomic) BOOL allowsSelection;
- (BOOL) allowsSelection__
{
    return [self allowsSelection];
}

// @property(nonatomic, weak) id<UITableViewDataSource> dataSource;
- (void) setDataSource___crossmobile_ios_uikit_UITableViewDataSource:(id<UITableViewDataSource>) dataSource 
{
    objc_setAssociatedObject(self, @selector(setDataSource:), dataSource, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDataSource:(dataSource == JAVA_NULL ? nil : dataSource)];
}

// @property(nonatomic, weak) id<UITableViewDataSource> dataSource;
- (id<UITableViewDataSource>) dataSource__
{
    id<UITableViewDataSource> re$ult = [self dataSource];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, weak) id<UITableViewDelegate> delegate;
- (void) setDelegate___crossmobile_ios_uikit_UITableViewDelegate:(id<UITableViewDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// @property(nonatomic, weak) id<UITableViewDelegate> delegate;
- (id<UITableViewDelegate>) tableViewDelegate__
{
    id<UITableViewDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, getter=isEditing) BOOL editing;
- (void) setEditing___boolean:(BOOL) editing 
{
    [self setEditing:editing];
}

// @property(nonatomic, getter=isEditing) BOOL editing;
- (BOOL) isEditing__
{
    return [self isEditing];
}

// @property(nonatomic) CGFloat estimatedRowHeight;
- (void) setEstimatedRowHeight___double:(double) estimatedRowHeight 
{
    [self setEstimatedRowHeight:estimatedRowHeight];
}

// @property(nonatomic) CGFloat estimatedRowHeight;
- (double) estimatedRowHeight__
{
    return [self estimatedRowHeight];
}

// @property(nonatomic, readonly) NSIndexPath *indexPathForSelectedRow;
- (NSIndexPath*) indexPathForSelectedRow__
{
    NSIndexPath* re$ult = [self indexPathForSelectedRow];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) NSArray<NSIndexPath *> *indexPathsForSelectedRows;
- (NSArray*) indexPathsForSelectedRows__
{
    NSArray* re$ult = [self indexPathsForSelectedRows];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) NSArray<NSIndexPath *> *indexPathsForVisibleRows;
- (NSArray*) indexPathsForVisibleRows__
{
    NSArray* re$ult = [self indexPathsForVisibleRows];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) CGFloat rowHeight;
- (void) setRowHeight___double:(double) rowHeight 
{
    [self setRowHeight:rowHeight];
}

// @property(nonatomic) CGFloat rowHeight;
- (double) rowHeight__
{
    return [self rowHeight];
}

// @property(nonatomic) CGFloat sectionFooterHeight;
- (void) setSectionFooterHeight___double:(double) sectionFooterHeight 
{
    [self setSectionFooterHeight:sectionFooterHeight];
}

// @property(nonatomic) CGFloat sectionFooterHeight;
- (double) sectionFooterHeight__
{
    return [self sectionFooterHeight];
}

// @property(nonatomic) CGFloat sectionHeaderHeight;
- (void) setSectionHeaderHeight___double:(double) sectionHeaderHeight 
{
    [self setSectionHeaderHeight:sectionHeaderHeight];
}

// @property(nonatomic) CGFloat sectionHeaderHeight;
- (double) sectionHeaderHeight__
{
    return [self sectionHeaderHeight];
}

// @property(nonatomic, strong) UIColor *separatorColor;
- (void) setSeparatorColor___crossmobile_ios_uikit_UIColor:(UIColor*) separatorColor 
{
    [self setSeparatorColor:(separatorColor == JAVA_NULL ? nil : separatorColor)];
}

// @property(nonatomic, strong) UIColor *separatorColor;
- (UIColor*) separatorColor__
{
    UIColor* re$ult = [self separatorColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) UITableViewCellSeparatorStyle separatorStyle;
- (void) setSeparatorStyle___int:(int) separatorStyle 
{
    [self setSeparatorStyle:separatorStyle];
}

// @property(nonatomic) UITableViewCellSeparatorStyle separatorStyle;
- (int) separatorStyle__
{
    return [self separatorStyle];
}

// - (void)deleteRowsAtIndexPaths:(NSArray<NSIndexPath *> *)indexPaths withRowAnimation:(UITableViewRowAnimation)animation;
- (void) deleteRowsAtIndexPaths___java_util_List_int:(NSArray*) indexPaths :(int) animation 
{
    [self deleteRowsAtIndexPaths:(indexPaths == JAVA_NULL ? nil : indexPaths) withRowAnimation:animation];
}

// - (__kindof UITableViewCell *)dequeueReusableCellWithIdentifier:(NSString *)identifier;
- (UITableViewCell*) dequeueReusableCellWithIdentifier___java_lang_String:(NSString*) identifier 
{
    UITableViewCell* re$ult = [self dequeueReusableCellWithIdentifier:(identifier == JAVA_NULL ? nil : identifier)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)deselectRowAtIndexPath:(NSIndexPath *)indexPath animated:(BOOL)animated;
- (void) deselectRowAtIndexPath___crossmobile_ios_foundation_NSIndexPath_boolean:(NSIndexPath*) indexPath :(BOOL) animated 
{
    [self deselectRowAtIndexPath:(indexPath == JAVA_NULL ? nil : indexPath) animated:animated];
}

// - (NSIndexPath *)indexPathForRowAtPoint:(CGPoint)point;
- (NSIndexPath*) indexPathForRowAtPoint___crossmobile_ios_coregraphics_CGPoint:(crossmobile_ios_coregraphics_CGPoint*) point 
{
    NSIndexPath* re$ult = [self indexPathForRowAtPoint:[point getCGPoint]];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)insertRowsAtIndexPaths:(NSArray<NSIndexPath *> *)indexPaths withRowAnimation:(UITableViewRowAnimation)animation;
- (void) insertRowsAtIndexPaths___java_util_List_int:(NSArray*) indexPaths :(int) animation 
{
    [self insertRowsAtIndexPaths:(indexPaths == JAVA_NULL ? nil : indexPaths) withRowAnimation:animation];
}

// - (void)registerClass:(Class)cellClass forCellReuseIdentifier:(NSString *)identifier;
- (void) registerClass___java_lang_Class_java_lang_String:(java_lang_Class*) cellClass :(NSString*) identifier 
{
    [self registerClass:jclass_to_class(cellClass == JAVA_NULL ? nil : cellClass) forCellReuseIdentifier:(identifier == JAVA_NULL ? nil : identifier)];
}

// - (void)registerNib:(UINib *)nib forCellReuseIdentifier:(NSString *)identifier;
- (void) registerNib___crossmobile_ios_uikit_UINib_java_lang_String:(UINib*) nib :(NSString*) identifier 
{
    [self registerNib:(nib == JAVA_NULL ? nil : nib) forCellReuseIdentifier:(identifier == JAVA_NULL ? nil : identifier)];
}

// - (void)reloadData;
- (void) reloadData__
{
    [self reloadData];
}

// - (void)reloadRowsAtIndexPaths:(NSArray<NSIndexPath *> *)indexPaths withRowAnimation:(UITableViewRowAnimation)animation;
- (void) reloadRowsAtIndexPaths___java_util_List_int:(NSArray*) indexPaths :(int) animation 
{
    [self reloadRowsAtIndexPaths:(indexPaths == JAVA_NULL ? nil : indexPaths) withRowAnimation:animation];
}

// - (void)scrollToNearestSelectedRowAtScrollPosition:(UITableViewScrollPosition)scrollPosition animated:(BOOL)animated;
- (void) scrollToNearestSelectedRowAtScrollPosition___int_boolean:(int) scrollPosition :(BOOL) animated 
{
    [self scrollToNearestSelectedRowAtScrollPosition:scrollPosition animated:animated];
}

// - (void)scrollToRowAtIndexPath:(NSIndexPath *)indexPath atScrollPosition:(UITableViewScrollPosition)scrollPosition animated:(BOOL)animated;
- (void) scrollToRowAtIndexPath___crossmobile_ios_foundation_NSIndexPath_int_boolean:(NSIndexPath*) indexPath :(int) scrollPosition :(BOOL) animated 
{
    [self scrollToRowAtIndexPath:(indexPath == JAVA_NULL ? nil : indexPath) atScrollPosition:scrollPosition animated:animated];
}

// - (void)selectRowAtIndexPath:(NSIndexPath *)indexPath animated:(BOOL)animated scrollPosition:(UITableViewScrollPosition)scrollPosition;
- (void) selectRowAtIndexPath___crossmobile_ios_foundation_NSIndexPath_boolean_int:(NSIndexPath*) indexPath :(BOOL) animated :(int) scrollPosition 
{
    [self selectRowAtIndexPath:(indexPath == JAVA_NULL ? nil : indexPath) animated:animated scrollPosition:scrollPosition];
}

// - (void)setEditing:(BOOL)editing animated:(BOOL)animated;
- (void) setEditing___boolean_boolean:(BOOL) editing :(BOOL) animated 
{
    [self setEditing:editing animated:animated];
}

@end
