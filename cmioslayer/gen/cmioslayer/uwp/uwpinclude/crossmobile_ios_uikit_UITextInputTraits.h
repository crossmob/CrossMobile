// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UITextInputTraits definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class java_lang_String;

CM_EXPORT_CLASS
@protocol crossmobile_ios_uikit_UITextInputTraits
- (void) setAutocapitalizationType___int:(int) autocapitalizationType ;
- (int) autocapitalizationType__;
- (void) setAutocorrectionType___int:(int) autocorrectionType ;
- (int) autocorrectionType__;
- (void) setEnablesReturnKeyAutomatically___boolean:(BOOL) enablesReturnKeyAutomatically ;
- (BOOL) enablesReturnKeyAutomatically__;
- (void) setKeyboardAppearance___int:(int) keyboardAppearance ;
- (int) keyboardAppearance__;
- (void) setKeyboardType___int:(int) keyboardType ;
- (int) keyboardType__;
- (void) setReturnKeyType___int:(int) returnKeyType ;
- (int) returnKeyType__;
- (void) setSecureTextEntry___boolean:(BOOL) secureTextEntry ;
- (BOOL) isSecureTextEntry__;
- (void) setSmartDashesType___int:(int) smartDashesType ;
- (int) smartDashesType__;
- (void) setSmartInsertDeleteType___int:(int) smartInsertDeleteType ;
- (int) smartInsertDeleteType__;
- (void) setSmartQuotesType___int:(int) smartQuotesType ;
- (int) smartQuotesType__;
- (void) setSpellCheckingType___int:(int) spellCheckingType ;
- (int) spellCheckingType__;
- (void) setTextContentType___java_lang_String:(NSString*) textContentType ;
- (NSString*) textContentType__;
@end
