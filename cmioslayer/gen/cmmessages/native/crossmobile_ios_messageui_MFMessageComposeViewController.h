// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_messageui_MFMessageComposeViewController definition

#import "xmlvm.h"
#import <MessageUI/MessageUI.h>
@protocol crossmobile_ios_messageui_MFMessageComposeViewControllerDelegate;
@class java_lang_String;
@protocol java_util_List;

@interface crossmobile_ios_messageui_MFMessageComposeViewController$Ext : MFMessageComposeViewController
@end

#define crossmobile_ios_messageui_MFMessageComposeViewController MFMessageComposeViewController
@interface MFMessageComposeViewController (cm_crossmobile_ios_messageui_MFMessageComposeViewController)
+ (BOOL) canSendText__;
- (instancetype) __init_crossmobile_ios_messageui_MFMessageComposeViewController__;
- (void) setBody___java_lang_String:(NSString*) body ;
- (NSString*) body__;
- (void) setMessageComposeDelegate___crossmobile_ios_messageui_MFMessageComposeViewControllerDelegate:(id<MFMessageComposeViewControllerDelegate>) messageComposeDelegate ;
- (id<MFMessageComposeViewControllerDelegate>) messageComposeDelegate__;
- (void) setRecipients___java_util_List:(NSArray*) recipients ;
- (NSArray*) recipients__;
@end
