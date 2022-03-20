/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
