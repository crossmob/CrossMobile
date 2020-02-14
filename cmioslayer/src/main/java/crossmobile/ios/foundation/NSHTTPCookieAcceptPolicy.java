/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
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
