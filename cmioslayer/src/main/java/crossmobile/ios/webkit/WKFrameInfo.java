/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.webkit;

import crossmobile.ios.foundation.NSObject;
import crossmobile.ios.foundation.NSURLRequest;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;

import java.lang.ref.WeakReference;

@CMClass
public class WKFrameInfo extends NSObject {
    private final boolean mainFrame;
    private final NSURLRequest request;
    private final WKSecurityOrigin securityOrigin;
    private final WeakReference<WKWebView> webView;

    WKFrameInfo(boolean mainFrame, NSURLRequest request, WKSecurityOrigin securityOrigin, WKWebView webView) {
        this.mainFrame = mainFrame;
        this.request = request;
        this.securityOrigin = securityOrigin;
        this.webView = new WeakReference<>(webView);
    }

    @CMGetter("@property(nonatomic, readonly, getter=isMainFrame) BOOL mainFrame;")
    public boolean isMainFrame() {
        return mainFrame;
    }

    @CMGetter("@property(nonatomic, readonly, copy) NSURLRequest *request;")
    public NSURLRequest request() {
        return request;
    }

    @CMGetter("@property(nonatomic, readonly) WKSecurityOrigin *securityOrigin;")
    public WKSecurityOrigin securityOrigin() {
        return securityOrigin;
    }

    @CMGetter("@property(nonatomic, readonly, weak) WKWebView *webView;")
    public WKWebView webView() {
        return webView.get();
    }
}
