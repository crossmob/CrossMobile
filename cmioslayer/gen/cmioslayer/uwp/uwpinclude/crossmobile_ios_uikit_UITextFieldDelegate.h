// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UITextFieldDelegate definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSRange;
@class crossmobile_ios_uikit_UITextField;
@class java_lang_String;

CM_EXPORT_CLASS
@protocol crossmobile_ios_uikit_UITextFieldDelegate
- (void) didBeginEditing___crossmobile_ios_uikit_UITextField:(UITextField*) textField ;
- (void) didEndEditing___crossmobile_ios_uikit_UITextField:(UITextField*) textField ;
- (BOOL) shouldBeginEditing___crossmobile_ios_uikit_UITextField:(UITextField*) textField ;
- (BOOL) shouldChangeCharactersInRange___crossmobile_ios_uikit_UITextField_crossmobile_ios_foundation_NSRange_java_lang_String:(UITextField*) textField :(crossmobile_ios_foundation_NSRange*) range :(NSString*) string ;
- (BOOL) shouldClear___crossmobile_ios_uikit_UITextField:(UITextField*) textField ;
- (BOOL) shouldEndEditing___crossmobile_ios_uikit_UITextField:(UITextField*) textField ;
- (BOOL) shouldReturn___crossmobile_ios_uikit_UITextField:(UITextField*) textField ;
@end
