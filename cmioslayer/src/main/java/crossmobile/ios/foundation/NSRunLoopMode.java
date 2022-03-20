/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * NSRunLoopMode class defines different loop modes for the NSRunLoop.
 */
@CMEnum
public final class NSRunLoopMode {

    /**
     * The default loop mode for handling input sources.
     */
    public static final String Default = "NSDefaultRunLoopMode";

    /**
     * The loop mode for objects that belong to the common modes set.
     */
    public static final String Common = "NSRunLoopCommonModes";

    private NSRunLoopMode() {
    }

}
