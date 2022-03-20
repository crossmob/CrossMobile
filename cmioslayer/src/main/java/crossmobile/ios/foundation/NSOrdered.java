/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * NSOrdered class defines different types of ordering objects of a request.
 */
@CMEnum(typeAlias = "NSComparisonResult")
public final class NSOrdered {

    /**
     * The left object is the smaller.
     */
    public static final int Ascending = -1;

    /**
     * The objects are equal.
     */
    public static final int Same = 0;

    /**
     * The left operand is the greater.
     */
    public static final int Descending = 1;

    private NSOrdered() {
    }
}
