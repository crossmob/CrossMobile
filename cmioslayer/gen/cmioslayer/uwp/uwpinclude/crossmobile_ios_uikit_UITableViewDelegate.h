// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UITableViewDelegate definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSIndexPath;
@class crossmobile_ios_uikit_UITableView;
@class crossmobile_ios_uikit_UITableViewCell;
@class crossmobile_ios_uikit_UIView;
@class java_lang_String;

CM_EXPORT_CLASS
@protocol crossmobile_ios_uikit_UITableViewDelegate
- (void) accessoryButtonTappedForRowWithIndexPath___crossmobile_ios_uikit_UITableView_crossmobile_ios_foundation_NSIndexPath:(UITableView*) tableView :(NSIndexPath*) indexPath ;
- (void) didDeselectRowAtIndexPath___crossmobile_ios_uikit_UITableView_crossmobile_ios_foundation_NSIndexPath:(UITableView*) tableView :(NSIndexPath*) indexPath ;
- (void) didEndEditingRowAtIndexPath___crossmobile_ios_uikit_UITableView_crossmobile_ios_foundation_NSIndexPath:(UITableView*) tableView :(NSIndexPath*) indexPath ;
- (void) didSelectRowAtIndexPath___crossmobile_ios_uikit_UITableView_crossmobile_ios_foundation_NSIndexPath:(UITableView*) tableView :(NSIndexPath*) indexPath ;
- (int) editingStyleForRowAtIndexPath___crossmobile_ios_uikit_UITableView_crossmobile_ios_foundation_NSIndexPath:(UITableView*) tableView :(NSIndexPath*) indexPath ;
- (double) heightForFooterInSection___crossmobile_ios_uikit_UITableView_int:(UITableView*) tableView :(int) section ;
- (double) heightForHeaderInSection___crossmobile_ios_uikit_UITableView_int:(UITableView*) tableView :(int) section ;
- (double) heightForRowAtIndexPath___crossmobile_ios_uikit_UITableView_crossmobile_ios_foundation_NSIndexPath:(UITableView*) tableView :(NSIndexPath*) indexPath ;
- (BOOL) shouldIndentWhileEditingRowAtIndexPath___crossmobile_ios_uikit_UITableView_crossmobile_ios_foundation_NSIndexPath:(UITableView*) tableView :(NSIndexPath*) indexPath ;
- (NSString*) titleForDeleteConfirmationButtonForRowAtIndexPath___crossmobile_ios_uikit_UITableView_crossmobile_ios_foundation_NSIndexPath:(UITableView*) tableView :(NSIndexPath*) indexPath ;
- (UIView*) viewForFooterInSection___crossmobile_ios_uikit_UITableView_int:(UITableView*) tableView :(int) section ;
- (UIView*) viewForHeaderInSection___crossmobile_ios_uikit_UITableView_int:(UITableView*) tableView :(int) section ;
- (void) willBeginEditingRowAtIndexPath___crossmobile_ios_uikit_UITableView_crossmobile_ios_foundation_NSIndexPath:(UITableView*) tableView :(NSIndexPath*) indexPath ;
- (void) willDisplayCell___crossmobile_ios_uikit_UITableView_crossmobile_ios_uikit_UITableViewCell_crossmobile_ios_foundation_NSIndexPath:(UITableView*) tableView :(UITableViewCell*) cell :(NSIndexPath*) indexPath ;
@end
