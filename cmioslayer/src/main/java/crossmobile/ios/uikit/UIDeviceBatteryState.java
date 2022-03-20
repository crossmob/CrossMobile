/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIDeviceBatteryState class defines the battery state of the device.
 */
@CMEnum
public final class UIDeviceBatteryState {

    /**
     * The battery state cannot be defined.
     */
    public static final int Unknown = 0;

    /**
     * The battery is unplugged.
     */
    public static final int Unplugged = 1;

    /**
     * The battery is plugged into power and is charging.
     */
    public static final int Charging = 2;

    /**
     * Battery 100% charged and plugged into power.
     */
    public static final int Full = 3;

    private UIDeviceBatteryState() {
    }
}
