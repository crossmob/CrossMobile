/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

import java.util.regex.Pattern;

/**
 * NSURL class defines an object that represents a URL.
 */
@CMClass
public class NSURL extends NSObject implements NSSecureCoding {

    private static final Pattern urlPattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9+.\\-]*?:[A-Za-z0-9\\-._~:/?#\\[\\]@!$&'()*+,;=%]*");

    private final String url;

    static {
        /*
         * Here is the mother of all URL requests. Thus put this code here to
         * make sure that cookies are properly handled.
         */
        Native.network().initCookies();
    }

    private NSURL(String url) {
        this.url = url;
    }

    /**
     * Constructs and returns a NSURL object from the specified String.
     *
     * @param u The String that is used for the creation of the url object.
     * @return The NSURL object or NULL if the specified String didn't have the
     * appropriate format.
     */
    @CMSelector("+ (instancetype)URLWithString:(NSString *)URLString;")
    public static NSURL URLWithString(String u) {
        if (urlPattern.matcher(u).matches())
            return new NSURL(u);
        return null;
    }

    /**
     * Constructs and returns a NSURL object using the specified path.
     *
     * @param path The path that is used for the creation of the url object.
     * @return The NSURL object or NULL if the path does not exist.
     */
    @CMSelector("+ (NSURL *)fileURLWithPath:(NSString *)path;")
    public static NSURL fileURLWithPath(String path) {
        if (path == null)
            return null;
        if (!(path.startsWith("jar:") || path.startsWith("file:") || path.startsWith("avianvmresource:")))
            path = "file://" + path;
        return Native.file().fileExists(path) ? new NSURL(path) : null;
    }

    /**
     * Returns the absolute URL of this object.
     *
     * @return The absolute URL of this object.
     */
    @CMGetter("@property(readonly, copy) NSString *absoluteString;")
    public String absoluteString() {
        return url;
    }

    @Override
    public String toString() {
        return "NSURL url=" + absoluteString();
    }

}
