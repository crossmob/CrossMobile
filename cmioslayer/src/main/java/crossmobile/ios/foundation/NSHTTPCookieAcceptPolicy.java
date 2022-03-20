/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * NSHTTPCookieAcceptPolicy class defines different types of cookie accept
 * policies.
 */
@CMEnum
public final class NSHTTPCookieAcceptPolicy {

    /**
     * The default policy. All cookies are accepted.
     */
    public static final int Always = 0;

    /**
     * All cookies are rejected.
     */
    public static final int Never = 1;

    /**
     * Only cookies from the main document domain are accepted.
     */
    public static final int OnlyFromMainDocumentDomain = 2;

    private NSHTTPCookieAcceptPolicy() {
    }

}
