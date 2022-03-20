// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_webkit_WKNavigationDelegate definition

#import "xmlvm.h"
#import <WebKit/WebKit.h>
@class crossmobile_ios_foundation_NSError;
@class crossmobile_ios_webkit_WKNavigation;
@class crossmobile_ios_webkit_WKNavigationAction;
@class crossmobile_ios_webkit_WKNavigationResponse;
@class crossmobile_ios_webkit_WKWebView;
@class java_lang_Integer;
@class java_lang_Number;
@protocol org_robovm_objc_block_VoidBlock1;

CM_EXPORT_CLASS
@protocol crossmobile_ios_webkit_WKNavigationDelegate
- (void) decidePolicyForNavigationAction___crossmobile_ios_webkit_WKWebView_crossmobile_ios_webkit_WKNavigationAction_org_robovm_objc_block_VoidBlock1:(WKWebView*) webView :(WKNavigationAction*) navigationAction :(id<org_robovm_objc_block_VoidBlock1>) decisionHandler ;
- (void) decidePolicyForNavigationResponse___crossmobile_ios_webkit_WKWebView_crossmobile_ios_webkit_WKNavigationResponse_org_robovm_objc_block_VoidBlock1:(WKWebView*) webView :(WKNavigationResponse*) navigationResponse :(id<org_robovm_objc_block_VoidBlock1>) decisionHandler ;
- (void) didCommitNavigation___crossmobile_ios_webkit_WKWebView_crossmobile_ios_webkit_WKNavigation:(WKWebView*) webView :(WKNavigation*) navigation ;
- (void) didFailNavigation___crossmobile_ios_webkit_WKWebView_crossmobile_ios_webkit_WKNavigation_crossmobile_ios_foundation_NSError:(WKWebView*) webView :(WKNavigation*) navigation :(NSError*) error ;
- (void) didFailProvisionalNavigation___crossmobile_ios_webkit_WKWebView_crossmobile_ios_webkit_WKNavigation_crossmobile_ios_foundation_NSError:(WKWebView*) webView :(WKNavigation*) navigation :(NSError*) error ;
- (void) didFinishNavigation___crossmobile_ios_webkit_WKWebView_crossmobile_ios_webkit_WKNavigation:(WKWebView*) webView :(WKNavigation*) navigation ;
- (void) didReceiveServerRedirectForProvisionalNavigation___crossmobile_ios_webkit_WKWebView_crossmobile_ios_webkit_WKNavigation:(WKWebView*) webView :(WKNavigation*) navigation ;
- (void) didStartProvisionalNavigation___crossmobile_ios_webkit_WKWebView_crossmobile_ios_webkit_WKNavigation:(WKWebView*) webView :(WKNavigation*) navigation ;
- (void) webContentProcessDidTerminate___crossmobile_ios_webkit_WKWebView:(WKWebView*) webView ;
@end
