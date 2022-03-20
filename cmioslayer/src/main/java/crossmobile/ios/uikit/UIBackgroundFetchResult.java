/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * The result of a push notification event
 */
@CMEnum
public final class UIBackgroundFetchResult {
    /**
     * Data was downloaded
     */
    public static final int NewData = 0;
    /**
     * No data is available
     */
    public static final int NoData = 1;
    /**
     * Failed when downloading data
     */
    public static final int Failed = 2;

    private UIBackgroundFetchResult() {
    }
}
