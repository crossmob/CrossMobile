// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UITableView definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGPoint;
@class crossmobile_ios_coregraphics_CGRect;
@class crossmobile_ios_foundation_NSIndexPath;
@class crossmobile_ios_uikit_UIColor;
@class crossmobile_ios_uikit_UINib;
@class crossmobile_ios_uikit_UITableViewCell;
@protocol crossmobile_ios_uikit_UITableViewDataSource;
@protocol crossmobile_ios_uikit_UITableViewDelegate;
@class crossmobile_ios_uikit_UIViewAppearance;
@class java_lang_Class;
@class java_lang_String;
@protocol java_util_List;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UITableView$Ext : UITableView
@end

#define crossmobile_ios_uikit_UITableView UITableView
@interface UITableView (cm_crossmobile_ios_uikit_UITableView)
+ (instancetype) appearance__;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes ;
- (instancetype) __init_crossmobile_ios_uikit_UITableView__;
- (instancetype) __init_crossmobile_ios_uikit_UITableView___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame ;
- (instancetype) __init_crossmobile_ios_uikit_UITableView___crossmobile_ios_coregraphics_CGRect_int:(crossmobile_ios_coregraphics_CGRect*) frame :(int) style ;
- (void) setAllowsMultipleSelection___boolean:(BOOL) allowsMultipleSelection ;
- (BOOL) allowsMultipleSelection__;
- (void) setAllowsSelection___boolean:(BOOL) allowsSelection ;
- (BOOL) allowsSelection__;
- (void) setDataSource___crossmobile_ios_uikit_UITableViewDataSource:(id<UITableViewDataSource>) dataSource ;
- (id<UITableViewDataSource>) dataSource__;
- (void) setDelegate___crossmobile_ios_uikit_UITableViewDelegate:(id<UITableViewDelegate>) delegate ;
- (id<UITableViewDelegate>) tableViewDelegate__;
- (void) setEditing___boolean:(BOOL) editing ;
- (BOOL) isEditing__;
- (void) setEstimatedRowHeight___double:(double) estimatedRowHeight ;
- (double) estimatedRowHeight__;
- (NSIndexPath*) indexPathForSelectedRow__;
- (NSArray*) indexPathsForSelectedRows__;
- (NSArray*) indexPathsForVisibleRows__;
- (void) setRowHeight___double:(double) rowHeight ;
- (double) rowHeight__;
- (void) setSectionFooterHeight___double:(double) sectionFooterHeight ;
- (double) sectionFooterHeight__;
- (void) setSectionHeaderHeight___double:(double) sectionHeaderHeight ;
- (double) sectionHeaderHeight__;
- (void) setSeparatorColor___crossmobile_ios_uikit_UIColor:(UIColor*) separatorColor ;
- (UIColor*) separatorColor__;
- (void) setSeparatorStyle___int:(int) separatorStyle ;
- (int) separatorStyle__;
- (void) deleteRowsAtIndexPaths___java_util_List_int:(NSArray*) indexPaths :(int) animation ;
- (UITableViewCell*) dequeueReusableCellWithIdentifier___java_lang_String:(NSString*) identifier ;
- (void) deselectRowAtIndexPath___crossmobile_ios_foundation_NSIndexPath_boolean:(NSIndexPath*) indexPath :(BOOL) animated ;
- (NSIndexPath*) indexPathForRowAtPoint___crossmobile_ios_coregraphics_CGPoint:(crossmobile_ios_coregraphics_CGPoint*) point ;
- (void) insertRowsAtIndexPaths___java_util_List_int:(NSArray*) indexPaths :(int) animation ;
- (void) registerClass___java_lang_Class_java_lang_String:(java_lang_Class*) cellClass :(NSString*) identifier ;
- (void) registerNib___crossmobile_ios_uikit_UINib_java_lang_String:(UINib*) nib :(NSString*) identifier ;
- (void) reloadData__;
- (void) reloadRowsAtIndexPaths___java_util_List_int:(NSArray*) indexPaths :(int) animation ;
- (void) scrollToNearestSelectedRowAtScrollPosition___int_boolean:(int) scrollPosition :(BOOL) animated ;
- (void) scrollToRowAtIndexPath___crossmobile_ios_foundation_NSIndexPath_int_boolean:(NSIndexPath*) indexPath :(int) scrollPosition :(BOOL) animated ;
- (void) selectRowAtIndexPath___crossmobile_ios_foundation_NSIndexPath_boolean_int:(NSIndexPath*) indexPath :(BOOL) animated :(int) scrollPosition ;
- (void) setEditing___boolean_boolean:(BOOL) editing :(BOOL) animated ;
@end
