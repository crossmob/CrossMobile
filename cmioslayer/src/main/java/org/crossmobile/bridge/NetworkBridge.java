/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge;

import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.URI;
import java.util.Collection;

public interface NetworkBridge {

    default boolean canOpenURL(String url) {
        return true;    // Should check if this URL can be opened
    }

    default boolean isUniversalLink(String url) {
        return url.startsWith("https://");  // Should properly handle universal links
    }

    boolean openURL(String url);

    void initCookies();

    void setCookie(URI uri, HttpCookie ncookie);

    void deleteCookie(URI uri, HttpCookie ncookie);

    Collection<HttpCookie> getCookies(URI uri);

    void setCookiePolicy(CookiePolicy cookiePolicy);
}
