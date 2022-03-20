// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UITextViewDelegate definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSRange;
@class crossmobile_ios_uikit_UITextView;
@class java_lang_String;

@protocol crossmobile_ios_uikit_UITextViewDelegate
- (void) didBeginEditing___crossmobile_ios_uikit_UITextView:(UITextView*) textView ;
- (void) didChange___crossmobile_ios_uikit_UITextView:(UITextView*) textView ;
- (void) didChangeSelection___crossmobile_ios_uikit_UITextView:(UITextView*) textView ;
- (void) didEndEditing___crossmobile_ios_uikit_UITextView:(UITextView*) textView ;
- (BOOL) shouldBeginEditing___crossmobile_ios_uikit_UITextView:(UITextView*) textView ;
- (BOOL) shouldChangeTextInRange___crossmobile_ios_uikit_UITextView_crossmobile_ios_foundation_NSRange_java_lang_String:(UITextView*) textView :(crossmobile_ios_foundation_NSRange*) range :(NSString*) text ;
- (BOOL) shouldEndEditing___crossmobile_ios_uikit_UITextView:(UITextView*) textView ;
@end
