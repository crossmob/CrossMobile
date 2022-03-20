/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * NSLayoutRelation class defines equality relation between the initial and the
 * modified attribute of a constraint.
 */
@CMEnum
public final class NSLayoutRelation {

    /**
     * The initial attribute has to be less than or equal to modified one.
     */
    public static final int LessThanOrEqual = -1;

    /**
     * The attributes are equal.
     */
    public static final int RelationEqual = 0;

    /**
     * The initial attribute has to be greater than or equal to modified one.
     */
    public static final int GreaterThanOrEqual = 1;

    private NSLayoutRelation() {
    }
}
