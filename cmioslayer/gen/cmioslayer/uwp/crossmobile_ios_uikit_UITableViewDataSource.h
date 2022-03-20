// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UITableViewDataSource definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSIndexPath;
@class crossmobile_ios_uikit_UITableView;
@class crossmobile_ios_uikit_UITableViewCell;
@class java_lang_String;

@protocol crossmobile_ios_uikit_UITableViewDataSource
- (BOOL) canEditRowAtIndexPath___crossmobile_ios_uikit_UITableView_crossmobile_ios_foundation_NSIndexPath:(UITableView*) tableView :(NSIndexPath*) indexPath ;
- (BOOL) canMoveRowAtIndexPath___crossmobile_ios_uikit_UITableView_crossmobile_ios_foundation_NSIndexPath:(UITableView*) tableView :(NSIndexPath*) indexPath ;
- (UITableViewCell*) cellForRowAtIndexPath___crossmobile_ios_uikit_UITableView_crossmobile_ios_foundation_NSIndexPath:(UITableView*) tableView :(NSIndexPath*) indexPath ;
- (void) commitEditingStyle___crossmobile_ios_uikit_UITableView_int_crossmobile_ios_foundation_NSIndexPath:(UITableView*) tableView :(int) editingStyle :(NSIndexPath*) indexPath ;
- (void) moveRowAtIndexPath___crossmobile_ios_uikit_UITableView_crossmobile_ios_foundation_NSIndexPath_crossmobile_ios_foundation_NSIndexPath:(UITableView*) tableView :(NSIndexPath*) sourceIndexPath :(NSIndexPath*) destinationIndexPath ;
- (int) numberOfRowsInSection___crossmobile_ios_uikit_UITableView_int:(UITableView*) tableView :(int) section ;
- (int) numberOfSectionsInTableView___crossmobile_ios_uikit_UITableView:(UITableView*) tableView ;
- (NSString*) titleForFooterInSection___crossmobile_ios_uikit_UITableView_int:(UITableView*) tableView :(int) section ;
- (NSString*) titleForHeaderInSection___crossmobile_ios_uikit_UITableView_int:(UITableView*) tableView :(int) section ;
@end
