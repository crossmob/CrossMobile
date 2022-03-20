/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.corelocation;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * CLDistanceFilter class defines the minimum distance of a device's move
 * horizontally before an update is triggered.
 */
@CMEnum
public final class CLDistanceFilter {

    /**
     * The default value.
     */
    public static final double None = -1;

    private CLDistanceFilter() {
    }
}
