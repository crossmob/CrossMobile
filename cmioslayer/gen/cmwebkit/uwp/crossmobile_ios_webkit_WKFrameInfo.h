// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_webkit_WKFrameInfo definition

#import "xmlvm.h"
#import <WebKit/WebKit.h>
@class crossmobile_ios_foundation_NSURLRequest;
@class crossmobile_ios_webkit_WKSecurityOrigin;
@class crossmobile_ios_webkit_WKWebView;

@interface crossmobile_ios_webkit_WKFrameInfo$Ext : WKFrameInfo
@end

#define crossmobile_ios_webkit_WKFrameInfo WKFrameInfo
@interface WKFrameInfo (cm_crossmobile_ios_webkit_WKFrameInfo)
- (BOOL) isMainFrame__;
- (NSURLRequest*) request__;
- (WKSecurityOrigin*) securityOrigin__;
- (WKWebView*) webView__;
@end
