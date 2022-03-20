// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_messageui_MFMailComposeViewController implementation

#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_messageui_MFMailComposeViewController.h"
#import "crossmobile_ios_messageui_MFMailComposeViewControllerDelegate.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_messageui_MFMailComposeViewController$Ext

@end

@implementation MFMailComposeViewController (cm_crossmobile_ios_messageui_MFMailComposeViewController)

// + (BOOL)canSendMail;
+ (BOOL) canSendMail__
{
    return [MFMailComposeViewController canSendMail];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_messageui_MFMailComposeViewController__
{
    return [self init];
}

// @property(nonatomic, assign) id<MFMailComposeViewControllerDelegate> mailComposeDelegate;
- (void) setMailComposeDelegate___crossmobile_ios_messageui_MFMailComposeViewControllerDelegate:(id<MFMailComposeViewControllerDelegate>) mailComposeDelegate 
{
    objc_setAssociatedObject(self, @selector(setMailComposeDelegate:), mailComposeDelegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setMailComposeDelegate:(mailComposeDelegate == JAVA_NULL ? nil : mailComposeDelegate)];
}

// @property(nonatomic, assign) id<MFMailComposeViewControllerDelegate> mailComposeDelegate;
- (id<MFMailComposeViewControllerDelegate>) mailComposeDelegate__
{
    id<MFMailComposeViewControllerDelegate> re$ult = [self mailComposeDelegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)addAttachmentData:(NSData *)attachment mimeType:(NSString *)mimeType fileName:(NSString *)filename;
- (void) addAttachmentData___crossmobile_ios_foundation_NSData_java_lang_String_java_lang_String:(NSData*) attachment :(NSString*) mimeType :(NSString*) filename 
{
    [self addAttachmentData:(attachment == JAVA_NULL ? nil : attachment) mimeType:(mimeType == JAVA_NULL ? nil : mimeType) fileName:(filename == JAVA_NULL ? nil : filename)];
}

// - (void)setBccRecipients:(NSArray<NSString *> *)bccRecipients;
- (void) setBccRecipients___java_util_List:(NSArray*) bccRecipients 
{
    [self setBccRecipients:(bccRecipients == JAVA_NULL ? nil : bccRecipients)];
}

// - (void)setCcRecipients:(NSArray<NSString *> *)ccRecipients;
- (void) setCcRecipients___java_util_List:(NSArray*) ccRecipients 
{
    [self setCcRecipients:(ccRecipients == JAVA_NULL ? nil : ccRecipients)];
}

// - (void)setMessageBody:(NSString *)body isHTML:(BOOL)isHTML;
- (void) setMessageBody___java_lang_String_boolean:(NSString*) body :(BOOL) isHTML 
{
    [self setMessageBody:(body == JAVA_NULL ? nil : body) isHTML:isHTML];
}

// - (void)setSubject:(NSString *)subject;
- (void) setSubject___java_lang_String:(NSString*) subject 
{
    [self setSubject:(subject == JAVA_NULL ? nil : subject)];
}

// - (void)setToRecipients:(NSArray<NSString *> *)toRecipients;
- (void) setToRecipients___java_util_List:(NSArray*) toRecipients 
{
    [self setToRecipients:(toRecipients == JAVA_NULL ? nil : toRecipients)];
}

@end
