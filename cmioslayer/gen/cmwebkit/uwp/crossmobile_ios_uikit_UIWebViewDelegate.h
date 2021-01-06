// (c) 2021 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIWebViewDelegate definition

#import "xmlvm.h"
#import <WebKit/WebKit.h>
@class crossmobile_ios_foundation_NSError;
@class crossmobile_ios_foundation_NSURLRequest;
@class crossmobile_ios_uikit_UIWebView;

@protocol crossmobile_ios_uikit_UIWebViewDelegate
- (void) didFailLoadWithError___crossmobile_ios_uikit_UIWebView_crossmobile_ios_foundation_NSError:(UIWebView*) webView :(NSError*) error ;
- (void) didFinishLoad___crossmobile_ios_uikit_UIWebView:(UIWebView*) webView ;
- (void) didStartLoad___crossmobile_ios_uikit_UIWebView:(UIWebView*) webView ;
- (BOOL) shouldStartLoadWithRequest___crossmobile_ios_uikit_UIWebView_crossmobile_ios_foundation_NSURLRequest_int:(UIWebView*) webView :(NSURLRequest*) request :(int) navigationType ;
@end
