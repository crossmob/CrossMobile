/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import crossmobile.ios.webkit.WKWebView;
import org.crossmobile.bind.wrapper.WebWrapper;
import org.crossmobile.bridge.WebViewBridge;
import org.crossmobile.bridge.ann.CMLib;

@CMLib(name = "cmwebkit")
public class AndroidWebViewBridge implements WebViewBridge {
    @Override
    public WebWrapper webView(WKWebView parent) {
        return new AndroidWebWrapper(parent);
    }
}
