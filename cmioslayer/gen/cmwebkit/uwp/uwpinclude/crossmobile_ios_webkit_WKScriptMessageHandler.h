// (c) 2023 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_webkit_WKScriptMessageHandler definition

#import "xmlvm.h"
#import <WebKit/WebKit.h>
@class crossmobile_ios_webkit_WKScriptMessage;
@class crossmobile_ios_webkit_WKUserContentController;

CM_EXPORT_CLASS
@protocol crossmobile_ios_webkit_WKScriptMessageHandler
- (void) didReceiveScriptMessage___crossmobile_ios_webkit_WKUserContentController_crossmobile_ios_webkit_WKScriptMessage:(WKUserContentController*) userContentController :(WKScriptMessage*) message ;
@end
