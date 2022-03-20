/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * NSURLRequestCachePolicy class defines different types of cache policies
 * concerning the URL requests.
 */
@CMEnum
public final class NSURLRequestCachePolicy {

    /**
     * The cache policy is defined in the protocol implementation and used for
     * special requests.
     */
    public static final int UseProtocolCachePolicy = 0;

    /**
     * The requested data is reloaded.
     */
    public static final int ReloadIgnoringLocalCacheData = 1;

    /**
     * The requested data is reloaded and proxies ignore cache data.
     */
    public static final int ReloadIgnoringLocalAndRemoteCacheData = 4;

    /**
     * The requested data is reloaded regardless of cache.
     */
    public static final int ReloadIgnoringCacheData = ReloadIgnoringLocalCacheData;

    /**
     * The data that are stored in cache are used without checking the
     * expiration date. If there is no data in cache, then the data is reloaded.
     */
    public static final int ReturnCacheDataElseLoad = 2;

    /**
     * The data that are stored in cache are used without checking the
     * expiration date. If there is no data then no attempt to reload the data
     * is made.
     */
    public static final int ReturnCacheDataDontLoad = 3;

    /**
     * The data that are stored in cache are used if they are valid otherwise
     * they are reloaded.
     */
    public static final int ReloadRevalidatingCacheData = 5;

    private NSURLRequestCachePolicy() {
    }
}
