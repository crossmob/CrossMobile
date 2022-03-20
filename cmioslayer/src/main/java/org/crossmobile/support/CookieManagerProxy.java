/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

// Modified version of this answer: http://stackoverflow.com/a/18070681/339146
package org.crossmobile.support;

import org.crossmobile.bind.io.NativeCookieManager;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CookieManagerProxy extends CookieManager {

    private final NativeCookieManager cookieManager;

    public CookieManagerProxy(NativeCookieManager proxy) {
        super(null, CookiePolicy.ACCEPT_ALL);
        cookieManager = proxy;
    }

    @Override
    public void put(URI uri, Map<String, List<String>> responseHeaders) throws IOException {
        super.put(uri, responseHeaders);
        if (this.cookieManager == null)
            return;

        // make sure our args are valid
        if ((uri == null) || (responseHeaders == null))
            return;

        // save our url once
        String url = uri.toString();

        // go over the headers
        for (String headerKey : responseHeaders.keySet()) {
            // ignore headers which aren't cookie related
            if ((headerKey == null) || !(headerKey.equalsIgnoreCase("Set-Cookie2") || headerKey.equalsIgnoreCase("Set-Cookie")))
                continue;

            // process each of the headers
            for (String headerValue : responseHeaders.get(headerKey))
                this.cookieManager.setCookie(url, headerValue);
        }
    }

    @Override
    public Map<String, List<String>> get(URI uri, Map<String, List<String>> requestHeaders) throws IOException {
        if (cookieManager == null)
            return super.get(uri, requestHeaders);
        // make sure our args are valid
        if ((uri == null) || (requestHeaders == null))
            throw new IllegalArgumentException("Argument is null");

        // save our url once
        String url = uri.toString();

        // prepare our response
        Map<String, List<String>> res = new java.util.HashMap<>();

        // get the cookie
        String cookie = this.cookieManager.getCookie(url);

        // return it
        if (cookie != null)
            res.put("Cookie", Arrays.asList(cookie));
        return res;
    }

    @Override
    public CookieStore getCookieStore() {
//        if (cookieManager == null)  // No special cookie manager - use system default
        return super.getCookieStore();
        // we don't want anyone to work with this cookie store directly
    }
}
