/*
 * (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
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
