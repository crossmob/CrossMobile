// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UITextField definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGRect;
@class crossmobile_ios_uikit_UIColor;
@class crossmobile_ios_uikit_UIFont;
@protocol crossmobile_ios_uikit_UITextFieldDelegate;
@class crossmobile_ios_uikit_UIViewAppearance;
@class java_lang_String;
@protocol java_util_List;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UITextField$Ext : UITextField
@end

#define crossmobile_ios_uikit_UITextField UITextField
@interface UITextField (cm_crossmobile_ios_uikit_UITextField)
+ (instancetype) appearance__;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes ;
- (instancetype) __init_crossmobile_ios_uikit_UITextField__;
- (instancetype) __init_crossmobile_ios_uikit_UITextField___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame ;
- (void) setAdjustsFontSizeToFitWidth___boolean:(BOOL) adjustsFontSizeToFitWidth ;
- (BOOL) adjustsFontSizeToFitWidth__;
- (void) setAutocapitalizationType___int:(int) autocapitalizationType ;
- (int) autocapitalizationType__;
- (void) setAutocorrectionType___int:(int) autocorrectionType ;
- (int) autocorrectionType__;
- (void) setBorderStyle___int:(int) borderStyle ;
- (int) borderStyle__;
- (void) setDelegate___crossmobile_ios_uikit_UITextFieldDelegate:(id<UITextFieldDelegate>) delegate ;
- (id<UITextFieldDelegate>) delegate__;
- (void) setEnablesReturnKeyAutomatically___boolean:(BOOL) enablesReturnKeyAutomatically ;
- (BOOL) enablesReturnKeyAutomatically__;
- (void) setFont___crossmobile_ios_uikit_UIFont:(UIFont*) font ;
- (UIFont*) font__;
- (void) setKeyboardAppearance___int:(int) keyboardAppearance ;
- (int) keyboardAppearance__;
- (void) setKeyboardType___int:(int) keyboardType ;
- (int) keyboardType__;
- (void) setPlaceholder___java_lang_String:(NSString*) placeholder ;
- (NSString*) placeholder__;
- (void) setReturnKeyType___int:(int) returnKeyType ;
- (int) returnKeyType__;
- (void) setSecureTextEntry___boolean:(BOOL) secureTextEntry ;
- (BOOL) isSecureTextEntry__;
- (void) setText___java_lang_String:(NSString*) text ;
- (NSString*) text__;
- (void) setTextAlignment___int:(int) textAlignment ;
- (int) textAlignment__;
- (void) setTextColor___crossmobile_ios_uikit_UIColor:(UIColor*) textColor ;
- (UIColor*) textColor__;
- (void) setTextContentType___java_lang_String:(NSString*) textContentType ;
- (NSString*) textContentType__;
@end
