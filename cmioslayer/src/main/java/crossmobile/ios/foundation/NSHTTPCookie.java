/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;

import java.net.HttpCookie;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * NSHTTPCookie class defines an object that represents an HTTP cookie.
 */
@CMClass
public class NSHTTPCookie extends NSObject {

    final HttpCookie ncookie;

    NSHTTPCookie(HttpCookie ncookie) {
        this.ncookie = ncookie;
    }

    /**
     * Returns the comment string of this cookie.
     *
     * @return The comment string of this cookie.
     */
    @CMGetter("@property(readonly, copy) NSString *comment;")
    public String comment() {
        return ncookie.getComment();
    }

    /**
     * Returns the comment URL of this cookie.
     *
     * @return The comment URL of this cookie.
     */
    @CMGetter("@property(readonly, copy) NSURL *commentURL;")
    public NSURL commentURL() {
        return NSURL.URLWithString(ncookie.getCommentURL());
    }

    /**
     * Returns the domain of this cookie.
     *
     * @return The domain of this cookie.
     */
    @CMGetter("@property(readonly, copy) NSString *domain;")
    public String domain() {
        return ncookie.getDomain();
    }

    /**
     * Returns the expiration date of this cookie.
     *
     * @return The expiration date of this cookie.
     */
    @CMGetter("@property(readonly, copy) NSDate *expiresDate;")
    public NSDate expiresDate() {
        System.out.println(ncookie.getMaxAge());
        return null;
    }

    /**
     * Returns a Boolean that shows whether this cookie should be sent to HTTP
     * servers per RFC 2965.
     *
     * @return TRUE then this cookie should be sent via HTTP headers only.
     */
    @CMGetter("@property(readonly, getter=isHTTPOnly) BOOL HTTPOnly;")
    public boolean isHTTPOnly() {
        return ncookie.isHttpOnly();
    }

    /**
     * Returns a Boolean that show whether this cookie should be sent over
     * secure channels only.
     *
     * @return TRUE then the cookie should be sent over secure channels only.
     */
    @CMGetter("@property(readonly, getter=isSecure) BOOL secure;")
    public boolean isSecure() {
        return ncookie.getSecure();
    }

    /**
     * Returns a Boolean value that shows whether this cookie is only for the
     * current session.
     *
     * @return TRUE then the cookie is used only during the current session.
     */
    @CMGetter("@property(readonly, getter=isSessionOnly) BOOL sessionOnly;")
    public boolean isSessionOnly() {
        return ncookie.getMaxAge() < 0;
    }

    /**
     * Returns the name of this cookie.
     *
     * @return The name of this cookie.
     */
    @CMGetter("@property(readonly, copy) NSString *name;")
    public String name() {
        return ncookie.getName();
    }

    /**
     * Returns the path of this cookie.
     *
     * @return The path of this cookie.
     */
    @CMGetter("@property(readonly, copy) NSString *path;")
    public String path() {
        return ncookie.getPath();
    }

    /**
     * Returns the list of the ports for this cookie.
     *
     * @return The list of the ports for this cookie.
     */
    @CMGetter("@property(readonly, copy) NSArray<NSNumber *> *portList;")
    public List<Integer> portList() {
        List<Integer> result = new ArrayList<Integer>();
        for (String port : ncookie.getPortlist().split(","))
            try {
                result.add(Integer.parseInt(port.trim()));
            } catch (NumberFormatException ex) {
            }
        return result;
    }

    /**
     * Returns the value of this cookie.
     *
     * @return The value of this cookie.
     */
    @CMGetter("@property(readonly, copy) NSString *value;")
    public String value() {
        return ncookie.getValue();
    }

    /**
     * Returns the version of this cookie.
     *
     * @return The version of this cookie.
     */
    @CMGetter("@property(readonly) NSUInteger version;")
    public int version() {
        return ncookie.getVersion();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof NSHTTPCookie))
            return false;
        return ncookie.equals(((NSHTTPCookie) obj).ncookie);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (this.ncookie != null ? this.ncookie.hashCode() : 0);
        return hash;
    }

    URI getURI() {
        String path = ncookie.getPath();
        if (path == null)
            path = "/";
        if (ncookie.getDomain() != null)
            return URI.create(ncookie.getDomain() + path);
        return null;
    }
}
