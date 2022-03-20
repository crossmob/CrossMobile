// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UITableViewController definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSIndexPath;
@class crossmobile_ios_uikit_UITableView;
@class crossmobile_ios_uikit_UITableViewCell;
@class java_lang_String;

@interface crossmobile_ios_uikit_UITableViewController$Ext : UITableViewController
@end

#define crossmobile_ios_uikit_UITableViewController UITableViewController
@interface UITableViewController (cm_crossmobile_ios_uikit_UITableViewController)
- (instancetype) __init_crossmobile_ios_uikit_UITableViewController__;
- (instancetype) __init_crossmobile_ios_uikit_UITableViewController___int:(int) style ;
- (void) setTableView___crossmobile_ios_uikit_UITableView:(UITableView*) tableView ;
- (UITableView*) tableView__;
- (UITableViewCell*) cellForRowAtIndexPath___crossmobile_ios_uikit_UITableView_crossmobile_ios_foundation_NSIndexPath:(UITableView*) tableView :(NSIndexPath*) indexPath ;
- (double) heightForRowAtIndexPath___crossmobile_ios_uikit_UITableView_crossmobile_ios_foundation_NSIndexPath:(UITableView*) tableView :(NSIndexPath*) indexPath ;
- (int) numberOfRowsInSection___crossmobile_ios_uikit_UITableView_int:(UITableView*) tableView :(int) section ;
- (int) numberOfSectionsInTableView___crossmobile_ios_uikit_UITableView:(UITableView*) tableView ;
- (NSString*) titleForFooterInSection___crossmobile_ios_uikit_UITableView_int:(UITableView*) tableView :(int) section ;
- (NSString*) titleForHeaderInSection___crossmobile_ios_uikit_UITableView_int:(UITableView*) tableView :(int) section ;
@end
