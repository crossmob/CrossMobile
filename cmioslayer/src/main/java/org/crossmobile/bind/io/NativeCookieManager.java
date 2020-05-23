/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.io;

public interface NativeCookieManager {

    public void setCookie(String url, String headerValue);

    public String getCookie(String url);
}
