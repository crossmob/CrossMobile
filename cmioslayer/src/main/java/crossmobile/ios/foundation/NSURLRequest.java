/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * NSURLRequest class defines objects that represent the URL load requests of
 * the application.
 */
@CMClass
public class NSURLRequest extends NSObject {

    private final int cachePolicy;
    private final double timeoutInterval;
    boolean HTTPShouldHandleCookies = true;
    NSURL url;    // package private, to support NSMutableURLRequest

    /**
     * Constructs and returns a URL request for the specified URL.
     *
     * @param theURL The URL that is requested.
     * @return The URL request for the specified parameters.
     */
    @CMSelector("+ (instancetype)requestWithURL:(NSURL *)URL;")
    public static NSURLRequest requestWithURL(NSURL theURL) {
        return theURL == null ? null : new NSURLRequest(theURL);
    }

    /**
     * Constructs and returns a URL request with specified parameter values for
     * cache policy and timeout interval.
     *
     * @param url                     The URL that is requested.
     * @param NSURLRequestCachePolicy The cache policy of the receiver.
     * @param timeoutInterval         The time interval of the request.
     * @return The URL request for the specified parameters.
     */
    @CMSelector("+ (instancetype)requestWithURL:(NSURL *)URL cachePolicy:(NSURLRequestCachePolicy)cachePolicy timeoutInterval:(NSTimeInterval)timeoutInterval;")
    public static NSURLRequest requestWithURL(NSURL url, int NSURLRequestCachePolicy, double timeoutInterval) {
        return url == null ? null : new NSURLRequest(url, NSURLRequestCachePolicy, timeoutInterval);
    }

    /**
     * Constructs a URL request for the specified URL.
     *
     * @param url The URL that is requested.
     */
    @CMConstructor("- (instancetype)initWithURL:(NSURL *)URL;")
    public NSURLRequest(NSURL url) {
        this(url, NSURLRequestCachePolicy.UseProtocolCachePolicy, 60);
    }

    /**
     * Constructs a URL request for the specified URL, cache policy and timeout
     * interval.
     *
     * @param url                     The URL that is requested.
     * @param NSURLRequestCachePolicy The cache policy of the receiver.
     * @param timeoutInterval         The time interval of the request.
     */
    @CMConstructor("- (instancetype)initWithURL:(NSURL *)URL \n"
            + "                cachePolicy:(NSURLRequestCachePolicy)cachePolicy \n"
            + "            timeoutInterval:(NSTimeInterval)timeoutInterval;")
    public NSURLRequest(NSURL url, int NSURLRequestCachePolicy, double timeoutInterval) {
        this.url = url;
        this.cachePolicy = NSURLRequestCachePolicy;
        this.timeoutInterval = timeoutInterval;
    }

    /**
     * Returns the URL of this request.
     *
     * @return The URL of this request.
     */
    @CMGetter("@property(readonly, copy) NSURL *URL;")
    public NSURL URL() {
        return url;
    }

    /**
     * Returns the cache policy of this URL request.
     *
     * @return The cache policy of this URL request.
     */
    @CMGetter("@property(readonly) NSURLRequestCachePolicy cachePolicy;")
    public int cachePolicy() {
        return cachePolicy;
    }

    /**
     * Returns the timeout interval of the receiver expressed in seconds.
     *
     * @return The timeout interval of the receiver expressed in seconds.
     */
    @CMGetter("@property(readonly) NSTimeInterval timeoutInterval;")
    public double timeoutInterval() {
        return timeoutInterval;
    }

    @Override
    public String toString() {
        return "NSURLRequest [" + url.toString() + "]";
    }

    /**
     * Returns a Boolean that defines whether cookies are handled by default for
     * this request.
     *
     * @return TRUE then cookies are handled by default.
     */
    @CMGetter("@property(readonly) BOOL HTTPShouldHandleCookies;")
    public boolean HTTPShouldHandleCookies() {
        return HTTPShouldHandleCookies;
    }

    NSURLRequest copy() {
        NSURLRequest copy = new NSURLRequest(url, cachePolicy, timeoutInterval);
        copy.HTTPShouldHandleCookies = HTTPShouldHandleCookies;
        return copy;
    }
}
