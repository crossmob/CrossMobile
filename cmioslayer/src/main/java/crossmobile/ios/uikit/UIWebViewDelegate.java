/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.foundation.NSError;
import crossmobile.ios.foundation.NSURLRequest;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * UIWebViewDelegate interface is the delegate that is responsible for handling
 * operations related to web views.
 */
@CMClass
@CMLib(name = "cmwebkit")
public interface UIWebViewDelegate {

    /**
     * It is used for a web view's failure to loading a frame.
     *
     * @param webView The web view that corresponds to this delegate.
     * @param error   The error of the loading.
     */
    @CMSelector("- (void)webView:(UIWebView *)webView \n" +
            "didFailLoadWithError:(NSError *)error;")
    default void didFailLoadWithError(UIWebView webView, NSError error) {
    }

    /**
     * It is used before this web view starts the loading of a frame.
     *
     * @param webView                 The web view that corresponds to this delegate.
     * @param request                 The content location of the frame.
     * @param UIWebViewNavigationType The user action that triggered the load
     *                                request
     * @return TRUE if frame loading is permitted.
     * @see crossmobile.ios.uikit.UIWebViewNavigationType
     */
    @CMSelector("- (BOOL)webView:(UIWebView *)webView \n" +
            "shouldStartLoadWithRequest:(NSURLRequest *)request \n" +
            " navigationType:(UIWebViewNavigationType)navigationType;")
    default boolean shouldStartLoadWithRequest(UIWebView webView, NSURLRequest request, int UIWebViewNavigationType) {
        return true;
    }

    /**
     * It is used after this web view finished loading a frame.
     *
     * @param webView The web view that corresponds to this delegate.
     */
    @CMSelector("- (void)webViewDidFinishLoad:(UIWebView *)webView;")
    default void didFinishLoad(UIWebView webView) {
    }

    /**
     * It is used after this web view started loading a frame.
     *
     * @param webView The web view that corresponds to this delegate.
     */
    @CMSelector("- (void)webViewDidStartLoad:(UIWebView *)webView;")
    default void didStartLoad(UIWebView webView) {
    }
}
