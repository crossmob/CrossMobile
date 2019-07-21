// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIActionSheet definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UIActionSheetAppearance;
@protocol crossmobile_ios_uikit_UIActionSheetDelegate;
@class crossmobile_ios_uikit_UITabBar;
@class crossmobile_ios_uikit_UIToolbar;
@class crossmobile_ios_uikit_UIView;
@class java_lang_String;
@protocol java_util_List;

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
