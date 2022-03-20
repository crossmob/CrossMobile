// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_webkit_WKFrameInfo implementation

#import "crossmobile_ios_foundation_NSURLRequest.h"
#import "crossmobile_ios_webkit_WKFrameInfo.h"
#import "crossmobile_ios_webkit_WKSecurityOrigin.h"
#import "crossmobile_ios_webkit_WKWebView.h"

@implementation crossmobile_ios_webkit_WKFrameInfo$Ext

@end

@implementation WKFrameInfo (cm_crossmobile_ios_webkit_WKFrameInfo)

// @property(nonatomic, readonly, getter=isMainFrame) BOOL mainFrame;
- (BOOL) isMainFrame__
{
    return [self isMainFrame];
}

// @property(nonatomic, readonly, copy) NSURLRequest *request;
- (NSURLRequest*) request__
{
    NSURLRequest* re$ult = [self request];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) WKSecurityOrigin *securityOrigin;
- (WKSecurityOrigin*) securityOrigin__
{
    WKSecurityOrigin* re$ult = [self securityOrigin];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, weak) WKWebView *webView;
- (WKWebView*) webView__
{
    WKWebView* re$ult = [self webView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
