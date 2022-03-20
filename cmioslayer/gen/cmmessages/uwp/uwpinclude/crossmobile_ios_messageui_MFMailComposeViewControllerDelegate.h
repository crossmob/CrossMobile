// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_messageui_MFMailComposeViewControllerDelegate definition

#import "xmlvm.h"
#import <MessageUI/MessageUI.h>
@class crossmobile_ios_foundation_NSError;
@class crossmobile_ios_messageui_MFMailComposeViewController;

CM_EXPORT_CLASS
@protocol crossmobile_ios_messageui_MFMailComposeViewControllerDelegate
- (void) didFinishWithResult___crossmobile_ios_messageui_MFMailComposeViewController_int_crossmobile_ios_foundation_NSError:(MFMailComposeViewController*) controller :(int) result :(NSError*) error ;
@end
