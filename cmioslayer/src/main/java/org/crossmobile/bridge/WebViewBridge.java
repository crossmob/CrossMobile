/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge;

import crossmobile.ios.webkit.WKWebView;
import org.crossmobile.bind.wrapper.WebWrapper;

public interface WebViewBridge {

    WebWrapper webView(WKWebView parent);

}
