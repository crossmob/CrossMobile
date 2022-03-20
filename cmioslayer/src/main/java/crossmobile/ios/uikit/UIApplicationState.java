/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * Application states
 */
@CMEnum
public final class UIApplicationState {
    /**
     * The application is active and in the foreground
     */
    public static final int Active = 0;
    /**
     * The application is in the foreground but not in active state
     */
    public static final int Inactive = 1;
    /**
     * The application runs in the background
     */
    public static final int Background = 2;

    private UIApplicationState() {
    }
}
