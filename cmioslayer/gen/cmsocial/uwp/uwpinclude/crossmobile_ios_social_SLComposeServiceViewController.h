// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_social_SLComposeServiceViewController definition

#import "xmlvm.h"
#import <Social/Social.h>
@class crossmobile_ios_uikit_UITextView;
@class crossmobile_ios_uikit_UIView;
@class crossmobile_ios_uikit_UIViewController;
@class java_lang_Number;
@class java_lang_String;
@protocol java_util_List;

CM_EXPORT_CLASS
@interface crossmobile_ios_social_SLComposeServiceViewController$Ext : SLComposeServiceViewController
@end

#define crossmobile_ios_social_SLComposeServiceViewController SLComposeServiceViewController
@interface SLComposeServiceViewController (cm_crossmobile_ios_social_SLComposeServiceViewController)
- (instancetype) __init_crossmobile_ios_social_SLComposeServiceViewController__;
- (void) setAutoCompletionViewController___crossmobile_ios_uikit_UIViewController:(UIViewController*) autoCompletionViewController ;
- (UIViewController*) autoCompletionViewController__;
- (void) setCharactersRemaining___java_lang_Number:(java_lang_Number*) charactersRemaining ;
- (java_lang_Number*) charactersRemaining__;
- (NSString*) contentText__;
- (void) setPlaceholder___java_lang_String:(NSString*) placeholder ;
- (NSString*) placeholder__;
- (UITextView*) textView__;
- (void) cancel__;
- (NSArray*) configurationItems__;
- (void) didSelectCancel__;
- (void) didSelectPost__;
- (BOOL) isContentValid__;
- (UIView*) loadPreviewView__;
- (void) popConfigurationViewController__;
- (void) presentationAnimationDidFinish__;
- (void) pushConfigurationViewController___crossmobile_ios_uikit_UIViewController:(UIViewController*) viewController ;
- (void) reloadConfigurationItems__;
- (void) validateContent__;
@end
