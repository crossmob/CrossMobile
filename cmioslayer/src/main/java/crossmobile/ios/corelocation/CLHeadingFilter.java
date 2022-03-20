/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.corelocation;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * CLHeadingFilter class defines the minimum change of device's heading before
 * an update is triggered.
 */
@CMEnum
public final class CLHeadingFilter {

    /**
     * The default value that includes all heading changes.
     */
    public static final double None = -1;

    private CLHeadingFilter() {
    }
}
