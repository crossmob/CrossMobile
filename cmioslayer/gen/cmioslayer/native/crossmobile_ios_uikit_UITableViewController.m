// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UITableViewController implementation

#import "crossmobile_ios_foundation_NSIndexPath.h"
#import "crossmobile_ios_uikit_UITableView.h"
#import "crossmobile_ios_uikit_UITableViewCell.h"
#import "crossmobile_ios_uikit_UITableViewController.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_uikit_UITableViewController$Ext

@end

@implementation UITableViewController (cm_crossmobile_ios_uikit_UITableViewController)

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UITableViewController__
{
    return [self init];
}

// - (instancetype)initWithStyle:(UITableViewStyle)style;
- (instancetype) __init_crossmobile_ios_uikit_UITableViewController___int:(int) style 
{
    return [self initWithStyle:style];
}

// @property(nonatomic, strong) UITableView *tableView;
- (void) setTableView___crossmobile_ios_uikit_UITableView:(UITableView*) tableView 
{
    [self setTableView:(tableView == JAVA_NULL ? nil : tableView)];
}

// @property(nonatomic, strong) UITableView *tableView;
- (UITableView*) tableView__
{
    UITableView* re$ult = [self tableView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath;
- (UITableViewCell*) cellForRowAtIndexPath___crossmobile_ios_uikit_UITableView_crossmobile_ios_foundation_NSIndexPath:(UITableView*) tableView :(NSIndexPath*) indexPath 
{
    UITableViewCell* re$ult = [self tableView:(tableView == JAVA_NULL ? nil : tableView) cellForRowAtIndexPath:(indexPath == JAVA_NULL ? nil : indexPath)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath;
- (double) heightForRowAtIndexPath___crossmobile_ios_uikit_UITableView_crossmobile_ios_foundation_NSIndexPath:(UITableView*) tableView :(NSIndexPath*) indexPath 
{
    return [self tableView:(tableView == JAVA_NULL ? nil : tableView) heightForRowAtIndexPath:(indexPath == JAVA_NULL ? nil : indexPath)];
}

// - (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section;
- (int) numberOfRowsInSection___crossmobile_ios_uikit_UITableView_int:(UITableView*) tableView :(int) section 
{
    return [self tableView:(tableView == JAVA_NULL ? nil : tableView) numberOfRowsInSection:section];
}

// - (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView;
- (int) numberOfSectionsInTableView___crossmobile_ios_uikit_UITableView:(UITableView*) tableView 
{
    return [self numberOfSectionsInTableView:(tableView == JAVA_NULL ? nil : tableView)];
}

// - (NSString *)tableView:(UITableView *)tableView titleForFooterInSection:(NSInteger)section;
- (NSString*) titleForFooterInSection___crossmobile_ios_uikit_UITableView_int:(UITableView*) tableView :(int) section 
{
    NSString* re$ult = [self tableView:(tableView == JAVA_NULL ? nil : tableView) titleForFooterInSection:section];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSString *)tableView:(UITableView *)tableView titleForHeaderInSection:(NSInteger)section;
- (NSString*) titleForHeaderInSection___crossmobile_ios_uikit_UITableView_int:(UITableView*) tableView :(int) section 
{
    NSString* re$ult = [self tableView:(tableView == JAVA_NULL ? nil : tableView) titleForHeaderInSection:section];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
