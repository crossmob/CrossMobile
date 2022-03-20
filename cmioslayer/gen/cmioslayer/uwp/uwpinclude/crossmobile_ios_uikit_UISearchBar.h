// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UISearchBar definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGRect;
@class crossmobile_ios_uikit_UIColor;
@class crossmobile_ios_uikit_UIImage;
@protocol crossmobile_ios_uikit_UISearchBarDelegate;
@class crossmobile_ios_uikit_UIViewAppearance;
@class java_lang_String;
@protocol java_util_List;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UISearchBar$Ext : UISearchBar
@end

#define crossmobile_ios_uikit_UISearchBar UISearchBar
@interface UISearchBar (cm_crossmobile_ios_uikit_UISearchBar)
+ (instancetype) appearance__;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes ;
- (instancetype) __init_crossmobile_ios_uikit_UISearchBar__;
- (instancetype) __init_crossmobile_ios_uikit_UISearchBar___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame ;
- (void) setAutocapitalizationType___int:(int) autocapitalizationType ;
- (int) autocapitalizationType__;
- (void) setAutocorrectionType___int:(int) autocorrectionType ;
- (int) autocorrectionType__;
- (void) setBarStyle___int:(int) barStyle ;
- (int) barStyle__;
- (void) setBarTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) barTintColor ;
- (UIColor*) barTintColor__;
- (void) setDelegate___crossmobile_ios_uikit_UISearchBarDelegate:(id<UISearchBarDelegate>) delegate ;
- (id<UISearchBarDelegate>) delegate__;
- (void) setKeyboardType___int:(int) keyboardType ;
- (int) keyboardType__;
- (void) setPlaceholder___java_lang_String:(NSString*) placeholder ;
- (NSString*) placeholder__;
- (void) setPrompt___java_lang_String:(NSString*) prompt ;
- (NSString*) prompt__;
- (void) setScopeButtonTitles___java_util_List:(NSArray*) scopeButtonTitles ;
- (NSArray*) scopeButtonTitles__;
- (void) setSearchBarStyle___int:(int) searchBarStyle ;
- (int) searchBarStyle__;
- (void) setSelectedScopeButtonIndex___int:(int) selectedScopeButtonIndex ;
- (int) selectedScopeButtonIndex__;
- (void) setShowsBookmarkButton___boolean:(BOOL) showsBookmarkButton ;
- (BOOL) showsBookmarkButton__;
- (void) setShowsCancelButton___boolean:(BOOL) showsCancelButton ;
- (BOOL) showsCancelButton__;
- (void) setShowsScopeBar___boolean:(BOOL) showsScopeBar ;
- (BOOL) showsScopeBar__;
- (void) setText___java_lang_String:(NSString*) text ;
- (NSString*) text__;
- (void) setTranslucent___boolean:(BOOL) translucent ;
- (BOOL) isTranslucent__;
- (void) setImage___crossmobile_ios_uikit_UIImage_int_int:(UIImage*) iconImage :(int) icon :(int) state ;
@end
