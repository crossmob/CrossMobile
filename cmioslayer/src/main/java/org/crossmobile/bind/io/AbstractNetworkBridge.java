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
package org.crossmobile.bind.io;

import org.crossmobile.bridge.NetworkBridge;
import org.crossmobile.support.CookieManagerProxy;

import java.net.CookieHandler;
import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractNetworkBridge implements NetworkBridge {

    private CookieManagerProxy cookies;

    @Override
    public void initCookies() {
        if (cookies == null)
            CookieHandler.setDefault(cookies = new CookieManagerProxy(initNativeManager()));
    }

    @Override
    public void deleteCookie(URI uri, HttpCookie ncookie) {
        cookies.getCookieStore().remove(uri, ncookie);
    }

    @Override
    public void setCookie(URI uri, HttpCookie ncookie) {
        cookies.getCookieStore().add(uri, ncookie);
    }

    @Override
    public Collection<HttpCookie> getCookies(URI uri) {
        if (uri == null)
            return cookies.getCookieStore().getCookies();

        List<HttpCookie> result = new ArrayList<HttpCookie>();
        String domain = uri.getHost();
        for (HttpCookie cookie : cookies.getCookieStore().getCookies())
            if (cookie.getDomain().equals(domain))
                result.add(cookie);
        return result;
    }

    @Override
    public void setCookiePolicy(CookiePolicy cookiePolicy) {
        cookies.setCookiePolicy(cookiePolicy);
    }

    public abstract NativeCookieManager initNativeManager();
}
