/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * NSJSONWritingOptions class defines different options for writing JSON data.
 */
@CMEnum
public final class NSJSONWritingOptions {

    /**
     * The JSON data is whitespaced so that is more readable.
     */
    public static final int PrettyPrinted = 1 << 0;

    private NSJSONWritingOptions() {
    }
}
