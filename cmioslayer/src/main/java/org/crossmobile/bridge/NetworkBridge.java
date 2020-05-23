/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge;

import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.URI;
import java.util.Collection;

public interface NetworkBridge {

    boolean openURL(String URLWithString);

    void initCookies();

    void setCookie(URI uri, HttpCookie ncookie);

    void deleteCookie(URI uri, HttpCookie ncookie);

    Collection<HttpCookie> getCookies(URI uri);

    void setCookiePolicy(CookiePolicy cookiePolicy);

}
