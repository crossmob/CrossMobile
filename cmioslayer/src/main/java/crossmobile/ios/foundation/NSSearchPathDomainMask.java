/*
 * (c) 2019 by Panayotis Katsaloulis
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
 * NSSearchPathDomainMask class defines different base locations of paths used
 * by the NSFileManager.
 */
@CMEnum
public final class NSSearchPathDomainMask {

    /**
     * The user's home directory.
     */
    public static final int UserDomain = 1;

    /**
     * The local domain.
     */
    public static final int LocalDomain = 2;

    /**
     * The network domain.
     */
    public static final int NetworkDomain = 4;

    /**
     * The system domain.
     */
    public static final int SystemDomain = 8;

    /**
     * All the domains.
     */
    public static final int AllDomains = 0x0ffff;

    private NSSearchPathDomainMask() {
    }
}
