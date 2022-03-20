/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.webkit;

import crossmobile.ios.foundation.NSError;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;
import org.robovm.objc.block.VoidBlock1;
import org.robovm.objc.block.VoidBlock2;

@CMClass
public interface WKNavigationDelegate {
    @CMSelector("- (void)webView:(WKWebView *)webView \n" +
            "didCommitNavigation:(WKNavigation *)navigation;\n")
    default void didCommitNavigation(WKWebView webView, WKNavigation navigation) {
    }

    @CMSelector("- (void)webView:(WKWebView *)webView \n" +
            "didStartProvisionalNavigation:(WKNavigation *)navigation;")
    default void didStartProvisionalNavigation(WKWebView webView, WKNavigation navigation) {
    }

    @CMSelector("- (void)webView:(WKWebView *)webView \n" +
            "didReceiveServerRedirectForProvisionalNavigation:(WKNavigation *)navigation;")
    default void didReceiveServerRedirectForProvisionalNavigation(WKWebView webView, WKNavigation navigation) {
    }

//    @CMSelector("- (void)webView:(WKWebView *)webView \n" +
//            "didReceiveAuthenticationChallenge:(NSURLAuthenticationChallenge *)challenge \n" +
//            "completionHandler:(void (^)(NSURLSessionAuthChallengeDisposition disposition, NSURLCredential *credential))completionHandler;")
//    default void didReceiveAuthenticationChallenge(WKWebView webView, NSURLAuthenticationChallenge challenge, VoidBlock2<Integer, NSURLCredential> completionHandler) {
//    }

    @CMSelector("- (void)webView:(WKWebView *)webView \n" +
            "didFailNavigation:(WKNavigation *)navigation \n" +
            "      withError:(NSError *)error;\n")
    default void didFailNavigation(WKWebView webView, WKNavigation navigation, NSError error) {
    }

    @CMSelector("- (void)webView:(WKWebView *)webView \n" +
            "didFailProvisionalNavigation:(WKNavigation *)navigation \n" +
            "      withError:(NSError *)error;\n")
    default void didFailProvisionalNavigation(WKWebView webView, WKNavigation navigation, NSError error) {
    }

    @CMSelector("- (void)webView:(WKWebView *)webView \n" +
            "didFinishNavigation:(WKNavigation *)navigation;")
    default void didFinishNavigation(WKWebView webView, WKNavigation navigation) {
    }

    @CMSelector("- (void)webViewWebContentProcessDidTerminate:(WKWebView *)webView;")
    default void webContentProcessDidTerminate(WKWebView webView) {
    }

    @CMSelector("- (void)webView:(WKWebView *)webView \n" +
            "decidePolicyForNavigationAction:(WKNavigationAction *)navigationAction \n" +
            "decisionHandler:(void (^)(WKNavigationActionPolicy))decisionHandler;\n")
    default void decidePolicyForNavigationAction(WKWebView webView, WKNavigationAction navigationAction, VoidBlock1<Integer> decisionHandler) {
    }

    @CMSelector("- (void)webView:(WKWebView *)webView \n" +
            "decidePolicyForNavigationResponse:(WKNavigationResponse *)navigationResponse \n" +
            "decisionHandler:(void (^)(WKNavigationResponsePolicy))decisionHandler;")
    default void decidePolicyForNavigationResponse(WKWebView webView, WKNavigationResponse navigationResponse, VoidBlock1<Integer> decisionHandler) {
    }
}
