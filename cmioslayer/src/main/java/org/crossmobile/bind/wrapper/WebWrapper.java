/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.wrapper;

import crossmobile.ios.foundation.NSError;
import crossmobile.ios.foundation.NSURLRequest;
import crossmobile.ios.foundation.NSURLResponse;
import crossmobile.ios.uikit.UIView;
import crossmobile.ios.uikit.UIWebView;
import crossmobile.ios.uikit.UIWebViewDelegate;
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

    protected WKWebView getNewWebView() {
        UIView view = getIOSWidget();
        return view instanceof WKWebView ? (WKWebView) view : null;
    }

    protected UIWebView getOldWebView() {
        UIView view = getIOSWidget();
        return view instanceof UIWebView ? (UIWebView) view : null;
    }

    protected WKNavigationDelegate getNewDelegate() {
        return getNewWebView() != null ? getNewWebView().navigationDelegate() : null;
    }

    protected UIWebViewDelegate getOldDelegate() {
        return getOldWebView() != null ? getOldWebView().delegate() : null;
    }

    public boolean acceptsRequest(NSURLRequest urlRequest, int srcType) {
        if (urlRequest == null || urlRequest.URL() == null || urlRequest.URL().absoluteString() == null)
            return false;
        else if (getOldWebView() != null) {
            UIWebViewDelegate delegate = getOldDelegate();
            if (delegate == null)
                return true;
            return delegate.shouldStartLoadWithRequest(getOldWebView(), urlRequest, srcType);
        } else if (getNewWebView() != null) {
            WKNavigationDelegate delegate = getNewDelegate();
            if (delegate == null)
                return true;
            AtomicBoolean shouldStart = new AtomicBoolean(true);
            delegate.decidePolicyForNavigationAction(getNewWebView(), WebKitDrill.navigationAction(urlRequest, null, null),
                    v -> shouldStart.set(v == WKNavigationActionPolicy.Allow));
            return shouldStart.get();
        } else
            return false;
    }

    public boolean acceptsResponse(NSURLResponse urlResponse) {
        if (urlResponse == null || urlResponse.URL() == null || urlResponse.URL().absoluteString() == null)
            return false;
        if (getNewDelegate() != null) {
            WKNavigationDelegate delegate = getNewDelegate();
            AtomicBoolean shouldStart = new AtomicBoolean(true);
            delegate.decidePolicyForNavigationResponse(getNewWebView(), WebKitDrill.navigationResponse(true, true, urlResponse),
                    v -> shouldStart.set(v == WKNavigationActionPolicy.Allow));
            return shouldStart.get();
        } else
            return false;
    }
}
