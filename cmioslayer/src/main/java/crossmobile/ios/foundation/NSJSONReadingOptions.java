/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * NSJSONReadingOptions class defines different options to use when Foundation
 * instances are created from JSON data.
 */
@CMEnum
public final class NSJSONReadingOptions {

    /**
     * The objects created are mutable containers.
     */
    public static final int MutableContainers = 1;

    /**
     * Leaf string of the JSON object graph are NSMutable Strings.
     */
    public static final int MutableLeaves = 2;

    /**
     * Top level objects that are not NSArray or NSDictionary instances are
     * allowed.
     */
    public static final int AllowFragments = 4;

    private NSJSONReadingOptions() {
    }
}
