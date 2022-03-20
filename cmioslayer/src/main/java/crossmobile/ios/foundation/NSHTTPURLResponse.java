/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bind.system.SystemUtilities;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

import java.util.List;
import java.util.Map;

/**
 * NSHTTPURLResponse class defines an object that represents the responses from
 * HTTP requests.
 */
@CMClass
public class NSHTTPURLResponse extends NSURLResponse {

    private final int statusCode;
    private final Map<String, ? extends Object> headerFields;

    NSHTTPURLResponse(NSURL URL, String mime, int contentLength, int statusCode, Map<String, ? extends Object> headerFields) {
        super(URL, mime, contentLength);
        this.statusCode = statusCode;
        this.headerFields = headerFields;
    }

    /**
     * Constructs a NSHTTPURLResponse object with the specified parameter
     * values.
     *
     * @param URL          The URL of the NSHTTPURLResponse object.
     * @param statusCode   The status code of the NSHTTPURLResponse object.
     * @param HTTPVersion  The HTTP version of the NSHTTPURLResponse object.
     * @param headerFields The HTTP header fields of the NSHTTPURLResponse
     *                     object.
     */
    @CMConstructor("- (instancetype)initWithURL:(NSURL *)url \n"
            + "                 statusCode:(NSInteger)statusCode \n"
            + "                HTTPVersion:(NSString *)HTTPVersion \n"
            + "               headerFields:(NSDictionary<NSString *,NSString *> *)headerFields;")
    public NSHTTPURLResponse(NSURL URL, int statusCode, String HTTPVersion, Map<String, ? extends Object> headerFields) {
        super(URL, field(headerFields, "Content-Type"), SystemUtilities.stringToInt(field(headerFields, "Content-Length"), (int) NSURLResponse.UnknownLength));
        this.statusCode = statusCode;
        this.headerFields = headerFields;
    }

    /**
     * Returns the HTTP status code of this NSHTTPURLResponse object.
     *
     * @return The HTTP status code of this NSHTTPURLResponse object.
     */
    @CMGetter("@property(readonly) NSInteger statusCode;")
    public int statusCode() {
        return statusCode;
    }

    /**
     * Returns the String representation of the Status code based on RFC 2616
     *
     * @param statusCode The HTTP Status code based on RFC 2616
     * @return The String representation of the Status code based on RFC 2616
     */
    @CMSelector("+ (NSString *)localizedStringForStatusCode:(NSInteger)statusCode")
    public static String localizedStringForStatusCode(int statusCode) {
        return Integer.toString(statusCode);
    }

    /**
     * Returns all the HTTP header fields of this NSHTTPURLResponse object.
     *
     * @return The HTTP header fields of this NSHTTPURLResponse object.
     */
    @CMGetter("@property(readonly, copy) NSDictionary *allHeaderFields;")
    public Map<String, ? extends Object> allHeaderFields() {
        return headerFields;
    }

    private static String field(Map<String, ? extends Object> headerFields, String key) {
        if (headerFields == null)
            return null;
        if (key == null)
            return listItem(headerFields.get(null));
        key = key.toLowerCase();
        for (String hkey : headerFields.keySet())
            if (hkey != null && hkey.toLowerCase().equals(key))
                return listItem(headerFields.get(hkey));
        return null;
    }

    private static String listItem(Object value) {
        if (value == null)
            return null;
        if (value instanceof List) {
            List lvalue = (List) value;
            if (lvalue.size() > 0) {
                Object first = lvalue.get(0);
                return first == null ? null : first.toString();
            } else
                return null;
        }
        return value.toString();
    }
}
