/*
 * (c) 2023 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.io;

public interface NativeCookieManager {

    void setCookie(String url, String headerValue);

    String getCookie(String url);
}
