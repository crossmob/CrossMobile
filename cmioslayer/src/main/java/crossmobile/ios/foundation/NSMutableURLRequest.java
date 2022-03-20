/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMSetter;

import java.util.HashMap;
import java.util.Map;

/**
 * NSMutableURLRequest class defines an object that represents a modifiable URL
 * request.
 */
@CMClass
public class NSMutableURLRequest extends NSURLRequest {

    Map<String, String> header;
    String httpMethod;
    private double timeoutInterval;
    NSData body;

    /**
     * Constructs and returns a NSMutableURLRequest object with the specified
     * URL.
     *
     * @param theURL The URL of the new NSMutableURLRequest object.
     * @return The new NSMutableURLRequest object.
     */
    @CMSelector("+ (instancetype)requestWithURL:(NSURL *)theURL")
    public static NSMutableURLRequest requestWithURL(NSURL theURL) {
        return theURL == null ? null : new NSMutableURLRequest(theURL);
    }

    /**
     * Constructs and returns a NSMutableURLRequest object with the specified
     * parameters.
     *
     * @param url                     The URL of the request.
     * @param NSURLRequestCachePolicy The cache policy of this URL request
     *                                object.
     * @param timeoutInterval         The timeout interval of this URL request object.
     * @return The new NSMutableURLRequest object.
     */
    @CMSelector("+ (instancetype)requestWithURL:(NSURL *)theURL\n"
            + "                   cachePolicy:(NSURLRequestCachePolicy)cachePolicy\n"
            + "               timeoutInterval:(NSTimeInterval)timeoutInterval")
    public static NSMutableURLRequest requestWithURL(NSURL url, int NSURLRequestCachePolicy, double timeoutInterval) {
        return url == null ? null : new NSMutableURLRequest(url, NSURLRequestCachePolicy, timeoutInterval);
    }

    /**
     * Constructs a NSMutableURLRequest object for the specified request.
     *
     * @param request The new NSMutableURLRequest object.
     */
    public NSMutableURLRequest(NSURL request) {
        super(request);
    }

    /**
     * Constructs a URL request object with the specified parameters.
     *
     * @param url                     The URL of the request.
     * @param NSURLRequestCachePolicy The cache policy of this URL request
     *                                object.
     * @param timeoutInterval         The timeout interval of this URL request object.
     * @see crossmobile.ios.foundation.NSURLRequestCachePolicy
     */
    public NSMutableURLRequest(NSURL url, int NSURLRequestCachePolicy, double timeoutInterval) {
        super(url, NSURLRequestCachePolicy, timeoutInterval);
    }

    @CMGetter("@property NSTimeInterval timeoutInterval;")
    @Override
    public double timeoutInterval() {
        return timeoutInterval;
    }

    /**
     * Sets the timeout interval of the receiver expressed in seconds.
     *
     * @param timeoutInterval The timeout interval of the receiver expressed in
     *                        seconds.
     */
    @CMSetter("@property NSTimeInterval timeoutInterval;")
    public void setTimeoutInterval(double timeoutInterval) {
        this.timeoutInterval = timeoutInterval;
    }

    /**
     * Sets the URL of this request.
     *
     * @param url The URL of this request.
     */
    @CMSetter("@property(copy) NSURL *URL;")
    public void setURL(NSURL url) {
        this.url = url;
    }

    /**
     * Adds the specified HTTP header to the HTTP header dictionary of this
     * object.
     *
     * @param value  The HTTP header value
     * @param header The name of the header field
     */
    @CMSelector("- (void)addValue:(NSString *)value \n"
            + "forHTTPHeaderField:(NSString *)field;")
    public void addValue(String value, String header) {
        if (this.header == null)
            this.header = new HashMap<>();
        this.header.put(header, value);
    }

    /**
     * Sets the HTTP request method for this URL request object.
     *
     * @param method The HTTP request method for this URL request object.
     */
    @CMSetter("@property(copy) NSString *HTTPMethod;")
    public void setHTTPMethod(String method) {
        httpMethod = method;
    }

    /**
     * Sets the data of this URL request object.
     *
     * @param body The data of this URL request object.
     */
    @CMSetter("@property(copy) NSData *HTTPBody;")
    public void setHTTPBody(NSData body) {
        this.body = body;
    }

    @CMGetter("@property(copy) NSData *HTTPBody;")
    public NSData HTTPBody() {
        return body;
    }

    /**
     * Sets a Boolean that defines whether this URL request object uses the
     * default cookie.
     *
     * @param HTTPShouldHandleCookies TRUE then the URL request object uses the
     *                                default cookie.
     */
    @CMSetter("@property BOOL HTTPShouldHandleCookies;")
    public void setHTTPShouldHandleCookies(boolean HTTPShouldHandleCookies) {
        this.HTTPShouldHandleCookies = HTTPShouldHandleCookies;
    }

    @CMGetter("@property(copy) NSDictionary <NSString *,NSString *> *allHTTPHeaderFields")
    public Map<String, String> allHTTPHeaderFields() {
        return new HashMap<>(header);
    }

    @Override
    NSURLRequest copy() {
        NSMutableURLRequest copy = new NSMutableURLRequest(URL(), cachePolicy(), timeoutInterval());
        copy.HTTPShouldHandleCookies = HTTPShouldHandleCookies;
        copy.header = header == null ? null : new HashMap<>(header);
        copy.body = body;
        copy.httpMethod = httpMethod;
        return copy;
    }
}
