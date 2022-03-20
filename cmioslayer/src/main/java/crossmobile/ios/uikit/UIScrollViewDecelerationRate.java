/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIScrollViewDecelerationRate class specifies how fast a scrolling view moves.
 */
@CMEnum
public final class UIScrollViewDecelerationRate {

    /**
     * The view moves with the default scrolling speed.
     */
    public static final float Normal = 0.998f;

    /**
     * The view moves with fast scrolling speed.
     */
    public static final float Fast = 0.99f;

    private UIScrollViewDecelerationRate() {
    }
}
