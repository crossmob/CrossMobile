// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UINavigationItem definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UIBarButtonItem;
@class crossmobile_ios_uikit_UIView;
@class java_lang_String;

@interface crossmobile_ios_uikit_UINavigationItem$Ext : UINavigationItem
@end

#define crossmobile_ios_uikit_UINavigationItem UINavigationItem
@interface UINavigationItem (cm_crossmobile_ios_uikit_UINavigationItem)
- (instancetype) __init_crossmobile_ios_uikit_UINavigationItem___java_lang_String:(NSString*) title ;
- (void) setBackBarButtonItem___crossmobile_ios_uikit_UIBarButtonItem:(UIBarButtonItem*) backBarButtonItem ;
- (UIBarButtonItem*) backBarButtonItem__;
- (void) setHidesBackButton___boolean:(BOOL) hidesBackButton ;
- (BOOL) hidesBackButton__;
- (void) setLeftBarButtonItem___crossmobile_ios_uikit_UIBarButtonItem:(UIBarButtonItem*) leftBarButtonItem ;
- (UIBarButtonItem*) leftBarButtonItem__;
- (void) setPrompt___java_lang_String:(NSString*) prompt ;
- (NSString*) prompt__;
- (void) setRightBarButtonItem___crossmobile_ios_uikit_UIBarButtonItem:(UIBarButtonItem*) rightBarButtonItem ;
- (UIBarButtonItem*) rightBarButtonItem__;
- (void) setTitle___java_lang_String:(NSString*) title ;
- (NSString*) title__;
- (void) setTitleView___crossmobile_ios_uikit_UIView:(UIView*) titleView ;
- (UIView*) titleView__;
- (void) setHidesBackButton___boolean_boolean:(BOOL) hidesBackButton :(BOOL) animated ;
- (void) setLeftBarButtonItem___crossmobile_ios_uikit_UIBarButtonItem_boolean:(UIBarButtonItem*) item :(BOOL) animated ;
- (void) setRightBarButtonItem___crossmobile_ios_uikit_UIBarButtonItem_boolean:(UIBarButtonItem*) item :(BOOL) animated ;
@end
