/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
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
