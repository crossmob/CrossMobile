/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.webkit;

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;

import java.lang.ref.WeakReference;

@CMClass
public class WKScriptMessage extends NSObject {
    private final Object body;
    private final WKFrameInfo frameInfo;
    private final String name;
    private final WeakReference<WKWebView> webView;

    WKScriptMessage(Object body, WKFrameInfo frameInfo, String name, WKWebView webView) {
        this.body = body;
        this.frameInfo = frameInfo;
        this.name = name;
        this.webView = new WeakReference<>(webView);
    }

    @CMGetter("@property(nonatomic, readonly, copy) id body;")
    public Object body() {
        return body;
    }

    @CMGetter("@property(nonatomic, readonly, copy) WKFrameInfo *frameInfo;")
    public WKFrameInfo frameInfo() {
        return frameInfo;
    }

    @CMGetter("@property(nonatomic, readonly, copy) NSString *name;")
    public String name() {
        return name;
    }

    @CMGetter("@property(nullable, nonatomic, readonly, weak) WKWebView *webView;")
    public WKWebView webView() {
        return webView.get();
    }
}
