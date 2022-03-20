// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UISearchBarDelegate definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UISearchBar;
@class java_lang_String;

CM_EXPORT_CLASS
@protocol crossmobile_ios_uikit_UISearchBarDelegate
- (void) bookmarkButtonClicked___crossmobile_ios_uikit_UISearchBar:(UISearchBar*) searchBar ;
- (void) cancelButtonClicked___crossmobile_ios_uikit_UISearchBar:(UISearchBar*) searchBar ;
- (void) searchButtonClicked___crossmobile_ios_uikit_UISearchBar:(UISearchBar*) searchBar ;
- (void) selectedScopeButtonIndexDidChange___crossmobile_ios_uikit_UISearchBar_int:(UISearchBar*) searchBar :(int) selectedScope ;
- (BOOL) shouldBeginEditing___crossmobile_ios_uikit_UISearchBar:(UISearchBar*) searchBar ;
- (BOOL) shouldEndEditing___crossmobile_ios_uikit_UISearchBar:(UISearchBar*) searchBar ;
- (void) textDidBeginEditing___crossmobile_ios_uikit_UISearchBar:(UISearchBar*) searchBar ;
- (void) textDidChange___crossmobile_ios_uikit_UISearchBar_java_lang_String:(UISearchBar*) searchBar :(NSString*) searchText ;
- (void) textDidEndEditing___crossmobile_ios_uikit_UISearchBar:(UISearchBar*) searchBar ;
@end
