/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
