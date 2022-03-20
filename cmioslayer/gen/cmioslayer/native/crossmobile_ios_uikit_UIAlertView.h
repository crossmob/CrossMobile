// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIAlertView definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@protocol crossmobile_ios_uikit_UIAlertViewDelegate;
@class crossmobile_ios_uikit_UITextField;
@class crossmobile_ios_uikit_UIViewAppearance;
@class java_lang_String;
@protocol java_util_List;

@interface crossmobile_ios_uikit_UIAlertView$Ext : UIAlertView
@end

#define crossmobile_ios_uikit_UIAlertView UIAlertView
@interface UIAlertView (cm_crossmobile_ios_uikit_UIAlertView)
+ (instancetype) appearance__;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes ;
- (instancetype) __init_crossmobile_ios_uikit_UIAlertView___java_lang_String_java_lang_String_crossmobile_ios_uikit_UIAlertViewDelegate_java_lang_String_java_lang_String_ARRAYTYPE:(NSString*) title :(NSString*) message :(id<UIAlertViewDelegate>) delegate :(NSString*) cancelButtonTitle :(XMLVMArray*) otherButtonTitles ;
- (void) setAlertViewStyle___int:(int) alertViewStyle ;
- (int) alertViewStyle__;
- (void) setDelegate___crossmobile_ios_uikit_UIAlertViewDelegate:(id<UIAlertViewDelegate>) delegate ;
- (id) delegate__;
- (void) setMessage___java_lang_String:(NSString*) message ;
- (NSString*) message__;
- (void) setTitle___java_lang_String:(NSString*) title ;
- (NSString*) title__;
- (int) addButtonWithTitle___java_lang_String:(NSString*) title ;
- (void) show__;
- (UITextField*) textFieldAtIndex___int:(int) textFieldIndex ;
@end
