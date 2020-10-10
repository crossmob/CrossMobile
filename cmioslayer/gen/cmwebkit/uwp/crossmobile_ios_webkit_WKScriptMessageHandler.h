// (c) 2020 under LGPL by CrossMobile plugin tools

// crossmobile_ios_webkit_WKScriptMessageHandler definition

#import "xmlvm.h"
#import <WebKit/WebKit.h>
@class crossmobile_ios_webkit_WKScriptMessage;
@class crossmobile_ios_webkit_WKUserContentController;

@protocol crossmobile_ios_webkit_WKScriptMessageHandler
- (void) didReceiveScriptMessage___crossmobile_ios_webkit_WKUserContentController_crossmobile_ios_webkit_WKScriptMessage:(WKUserContentController*) userContentController :(WKScriptMessage*) message ;
@end
