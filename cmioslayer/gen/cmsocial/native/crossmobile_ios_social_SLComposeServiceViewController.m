// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_social_SLComposeServiceViewController implementation

#import "crossmobile_ios_social_SLComposeServiceViewController.h"
#import "crossmobile_ios_uikit_UITextView.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "crossmobile_ios_uikit_UIViewController.h"
#import "java_lang_Number.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_social_SLComposeServiceViewController$Ext

@end

@implementation SLComposeServiceViewController (cm_crossmobile_ios_social_SLComposeServiceViewController)

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_social_SLComposeServiceViewController__
{
    return [self init];
}

// @property(strong, nonatomic) UIViewController *autoCompletionViewController;
- (void) setAutoCompletionViewController___crossmobile_ios_uikit_UIViewController:(UIViewController*) autoCompletionViewController 
{
    [self setAutoCompletionViewController:(autoCompletionViewController == JAVA_NULL ? nil : autoCompletionViewController)];
}

// @property(strong, nonatomic) UIViewController *autoCompletionViewController;
- (UIViewController*) autoCompletionViewController__
{
    UIViewController* re$ult = [self autoCompletionViewController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(strong, nonatomic) NSNumber *charactersRemaining;
- (void) setCharactersRemaining___java_lang_Number:(java_lang_Number*) charactersRemaining 
{
    [self setCharactersRemaining:(charactersRemaining == JAVA_NULL ? nil : charactersRemaining)];
}

// @property(strong, nonatomic) NSNumber *charactersRemaining;
- (java_lang_Number*) charactersRemaining__
{
    java_lang_Number* re$ult = [self charactersRemaining];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, nonatomic) NSString *contentText;
- (NSString*) contentText__
{
    NSString* re$ult = [self contentText];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(copy, nonatomic) NSString *placeholder;
- (void) setPlaceholder___java_lang_String:(NSString*) placeholder 
{
    [self setPlaceholder:(placeholder == JAVA_NULL ? nil : placeholder)];
}

// @property(copy, nonatomic) NSString *placeholder;
- (NSString*) placeholder__
{
    NSString* re$ult = [self placeholder];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, nonatomic) UITextView *textView;
- (UITextView*) textView__
{
    UITextView* re$ult = [self textView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)cancel;
- (void) cancel__
{
    [self cancel];
}

// - (NSArray *)configurationItems;
- (NSArray*) configurationItems__
{
    NSArray* re$ult = [self configurationItems];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)didSelectCancel;
- (void) didSelectCancel__
{
    [self didSelectCancel];
}

// - (void)didSelectPost;
- (void) didSelectPost__
{
    [self didSelectPost];
}

// - (BOOL)isContentValid;
- (BOOL) isContentValid__
{
    return [self isContentValid];
}

// - (UIView *)loadPreviewView;
- (UIView*) loadPreviewView__
{
    UIView* re$ult = [self loadPreviewView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)popConfigurationViewController;
- (void) popConfigurationViewController__
{
    [self popConfigurationViewController];
}

// - (void)presentationAnimationDidFinish;
- (void) presentationAnimationDidFinish__
{
    [self presentationAnimationDidFinish];
}

// - (void)pushConfigurationViewController:(UIViewController *)viewController;
- (void) pushConfigurationViewController___crossmobile_ios_uikit_UIViewController:(UIViewController*) viewController 
{
    [self pushConfigurationViewController:(viewController == JAVA_NULL ? nil : viewController)];
}

// - (void)reloadConfigurationItems;
- (void) reloadConfigurationItems__
{
    [self reloadConfigurationItems];
}

// - (void)validateContent;
- (void) validateContent__
{
    [self validateContent];
}

@end
