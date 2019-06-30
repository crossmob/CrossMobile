/*
 * (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
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
