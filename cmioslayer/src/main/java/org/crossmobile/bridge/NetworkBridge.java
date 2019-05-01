/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
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
