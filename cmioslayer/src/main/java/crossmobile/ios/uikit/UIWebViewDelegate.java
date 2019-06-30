/*
 * (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
 */
package crossmobile.ios.uikit;

import crossmobile.ios.foundation.NSError;
import crossmobile.ios.foundation.NSURLRequest;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * UIWebViewDelegate interface is the delegate that is responsible for handling
 * operations related to web views.
 */
@CMClass
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
