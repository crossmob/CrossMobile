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

import crossmobile.ios.foundation.Foundation;
import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIDataDetectorTypes class defines different types of information that can be
 * automatically detected in text.
 */
@CMEnum
public final class UIDataDetectorTypes {

    /**
     * Automatically detected phone numbers.
     */
    public static final long PhoneNumber = 1 << 0;

    /**
     * Automatically detected URLs.
     */
    public static final long Link = 1 << 1;

    /**
     * Automatically detected addresses.
     */
    public static final long Address = 1 << 2;

    /**
     * Automatically detected calendar events.
     */
    public static final long CalendarEvent = 1 << 3;

    /**
     * None information is automatically detected.
     */
    public static final long None = 0;

    /**
     * All types of information are automatically detected.
     */
    public static final long All = Foundation.NSUIntegerMax;

    /**
     *
     */
    public static final long UIDataDetectorTypeFlightNumber = 1 << 5;

    /**
     *
     */
    public static final long UIDataDetectorTypeLookupSuggestion = 1 << 6;

    /**
     *
     */
    public static final long UIDataDetectorTypeShipmentTrackingNumber = 1 << 4;

    private UIDataDetectorTypes() {
    }
}
