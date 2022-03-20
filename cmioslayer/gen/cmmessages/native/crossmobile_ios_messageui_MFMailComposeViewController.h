// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_messageui_MFMailComposeViewController definition

#import "xmlvm.h"
#import <MessageUI/MessageUI.h>
@class crossmobile_ios_foundation_NSData;
@protocol crossmobile_ios_messageui_MFMailComposeViewControllerDelegate;
@class java_lang_String;
@protocol java_util_List;

@interface crossmobile_ios_messageui_MFMailComposeViewController$Ext : MFMailComposeViewController
@end

#define crossmobile_ios_messageui_MFMailComposeViewController MFMailComposeViewController
@interface MFMailComposeViewController (cm_crossmobile_ios_messageui_MFMailComposeViewController)
+ (BOOL) canSendMail__;
- (instancetype) __init_crossmobile_ios_messageui_MFMailComposeViewController__;
- (void) setMailComposeDelegate___crossmobile_ios_messageui_MFMailComposeViewControllerDelegate:(id<MFMailComposeViewControllerDelegate>) mailComposeDelegate ;
- (id<MFMailComposeViewControllerDelegate>) mailComposeDelegate__;
- (void) addAttachmentData___crossmobile_ios_foundation_NSData_java_lang_String_java_lang_String:(NSData*) attachment :(NSString*) mimeType :(NSString*) filename ;
- (void) setBccRecipients___java_util_List:(NSArray*) bccRecipients ;
- (void) setCcRecipients___java_util_List:(NSArray*) ccRecipients ;
- (void) setMessageBody___java_lang_String_boolean:(NSString*) body :(BOOL) isHTML ;
- (void) setSubject___java_lang_String:(NSString*) subject ;
- (void) setToRecipients___java_util_List:(NSArray*) toRecipients ;
@end
