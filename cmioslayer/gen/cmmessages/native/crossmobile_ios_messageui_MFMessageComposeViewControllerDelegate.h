// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_messageui_MFMessageComposeViewControllerDelegate definition

#import "xmlvm.h"
#import <MessageUI/MessageUI.h>
@class crossmobile_ios_messageui_MFMessageComposeViewController;

@protocol crossmobile_ios_messageui_MFMessageComposeViewControllerDelegate
- (void) didFinishWithResult___crossmobile_ios_messageui_MFMessageComposeViewController_int:(MFMessageComposeViewController*) controller :(int) result ;
@end
