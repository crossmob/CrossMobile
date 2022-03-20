// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIActionSheet definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@protocol crossmobile_ios_uikit_UIActionSheetDelegate;
@class crossmobile_ios_uikit_UITabBar;
@class crossmobile_ios_uikit_UIToolbar;
@class crossmobile_ios_uikit_UIView;
@class crossmobile_ios_uikit_UIViewAppearance;
@class java_lang_String;
@protocol java_util_List;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UIActionSheet$Ext : UIActionSheet
@end

#define crossmobile_ios_uikit_UIActionSheet UIActionSheet
@interface UIActionSheet (cm_crossmobile_ios_uikit_UIActionSheet)
+ (instancetype) appearance__;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes ;
- (instancetype) __init_crossmobile_ios_uikit_UIActionSheet___java_lang_String_crossmobile_ios_uikit_UIActionSheetDelegate_java_lang_String_java_lang_String_java_lang_String_ARRAYTYPE:(NSString*) title :(id<UIActionSheetDelegate>) delegate :(NSString*) cancelButtonTitle :(NSString*) destructiveButtonTitle :(XMLVMArray*) otherButtonTitles ;
- (int) cancelButtonIndex__;
- (void) setDelegate___crossmobile_ios_uikit_UIActionSheetDelegate:(id<UIActionSheetDelegate>) delegate ;
- (id<UIActionSheetDelegate>) delegate__;
- (int) destructiveButtonIndex__;
- (int) firstOtherButtonIndex__;
- (int) numberOfButtons__;
- (void) setTitle___java_lang_String:(NSString*) title ;
- (NSString*) title__;
- (int) addButtonWithTitle___java_lang_String:(NSString*) title ;
- (void) dismissWithClickedButtonIndex___int_boolean:(int) buttonIndex :(BOOL) animated ;
- (void) showFromTabBar___crossmobile_ios_uikit_UITabBar:(UITabBar*) view ;
- (void) showFromToolbar___crossmobile_ios_uikit_UIToolbar:(UIToolbar*) view ;
- (void) showInView___crossmobile_ios_uikit_UIView:(UIView*) view ;
@end
