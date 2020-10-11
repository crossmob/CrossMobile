/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge;

import crossmobile.ios.uikit.UIWebView;
import crossmobile.ios.webkit.WKWebView;
import org.crossmobile.bind.wrapper.WebWrapper;

public interface WebViewBridge {

    WebWrapper webView(UIWebView parent);

    WebWrapper webView(WKWebView parent);

}
