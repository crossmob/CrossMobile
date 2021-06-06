/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.aroma;

import org.crossmobile.bridge.NetworkBridge;

import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;

public class AromaNetworkBridge implements NetworkBridge {
    @Override
    public boolean openURL(String url) {
        return false;
    }

    @Override
    public void initCookies() {
    }

    @Override
    public void setCookie(URI uri, HttpCookie ncookie) {
    }

    @Override
    public void deleteCookie(URI uri, HttpCookie ncookie) {
    }

    @Override
    public Collection<HttpCookie> getCookies(URI uri) {
        return Collections.emptyList();
    }

    @Override
    public void setCookiePolicy(CookiePolicy cookiePolicy) {
    }
}
