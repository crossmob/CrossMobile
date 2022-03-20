/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.wrapper;

import crossmobile.ios.foundation.NSError;
import crossmobile.ios.foundation.NSURLRequest;
import crossmobile.ios.foundation.NSURLResponse;
import crossmobile.ios.uikit.UIView;
import crossmobile.ios.webkit.*;
import org.crossmobile.bind.graphics.GraphicsContext;
import org.crossmobile.bridge.ann.CMLib;
import org.robovm.objc.block.VoidBlock2;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

@CMLib(name = "cmwebkit")
public abstract class WebWrapper<NWIDG extends NativeWrapper<GCX>, GCX extends GraphicsContext<?>> extends WidgetWrapper<UIView, NWIDG, GCX> {

    private final Map<WKNavigation, String> navigation = new WeakHashMap<>();

    public WebWrapper(UIView wv) {
        super(wv);
    }

    public abstract WKNavigation loadRequest(NSURLRequest req);

    public abstract WKNavigation loadData(String data, String MIMEType, String baseURL);

    public abstract WKNavigation reload();

    public abstract void stopLoading();

    public abstract String getTitle();

    public abstract String getUrl();

    public abstract double getProgress();

    public abstract double getMagnification();

    public abstract WKNavigation goBack();

    public abstract WKNavigation goForward();

    public abstract void evaluateJavaScript(String script, VoidBlock2<Object, NSError> callback);

    public abstract boolean isLoading();

    public abstract WKBackForwardList getBackForwardList();

    protected WKNavigation getNavigation(String url) {
        if (url == null)
            return null;
        synchronized (navigation) {
            for (WKNavigation key : navigation.keySet()) {
                String value = navigation.get(key);
                if (url.equals(value))
                    return key;
            }
            WKNavigation nav = WebKitDrill.navigation();
            navigation.put(nav, url);
            return nav;
        }
    }

    protected WKWebView getWebView() {
        UIView view = getIOSWidget();
        return view instanceof WKWebView ? (WKWebView) view : null;
    }

    protected WKNavigationDelegate getDelegate() {
        return getWebView() != null ? getWebView().navigationDelegate() : null;
    }

    public boolean acceptsRequest(NSURLRequest urlRequest, int srcType) {
        if (urlRequest == null || urlRequest.URL() == null || urlRequest.URL().absoluteString() == null)
            return false;
        WKNavigationDelegate delegate = getDelegate();
        if (delegate == null)
            return true;
        AtomicBoolean shouldStart = new AtomicBoolean(true);
        delegate.decidePolicyForNavigationAction(getWebView(), WebKitDrill.navigationAction(urlRequest, null, null),
                v -> shouldStart.set(v == WKNavigationActionPolicy.Allow));
        return shouldStart.get();
    }

    public boolean acceptsResponse(NSURLResponse urlResponse) {
        if (urlResponse == null || urlResponse.URL() == null || urlResponse.URL().absoluteString() == null)
            return false;
        if (getDelegate() != null) {
            WKNavigationDelegate delegate = getDelegate();
            AtomicBoolean shouldStart = new AtomicBoolean(true);
            delegate.decidePolicyForNavigationResponse(getWebView(), WebKitDrill.navigationResponse(true, true, urlResponse),
                    v -> shouldStart.set(v == WKNavigationActionPolicy.Allow));
            return shouldStart.get();
        } else
            return false;
    }
}
