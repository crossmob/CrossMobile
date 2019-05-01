// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.messageui.MFMailComposeViewControllerDelegate definition

#import "xmlvm.h"
#import <MessageUI/MessageUI.h>
@class crossmobile_ios_foundation_NSError;
@class crossmobile_ios_messageui_MFMailComposeViewController;

CM_EXPORT_CLASS
@protocol crossmobile_ios_messageui_MFMailComposeViewControllerDelegate
- (void) didFinishWithResult___crossmobile_ios_messageui_MFMailComposeViewController_int_crossmobile_ios_foundation_NSError:(MFMailComposeViewController*) controller :(int) result :(NSError*) error ;
@end
