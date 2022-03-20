/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * The UIDatePickerMode class defines the mode of a UIDatePicker object. The
 * arrangement of the options varies depends on the local format.
 */
@CMEnum
public final class UIDatePickerMode {

    /**
     * Selection of hours, minutes, and (optional) AM/PM, for example 2:40:AM.
     */
    public static final int Time = 0;

    /**
     * Selection of months, days and years, for example April/10/1994.
     */
    public static final int Date = 1;

    /**
     * Selection of days of the week, month, hours, minutes, and (optional)
     * AM/PM, for example Fri/Apr/16/33/AM.
     */
    public static final int DateAndTime = 2;

    /**
     * Selection of hours and minutes, for example 3:33.
     */
    public static final int CountDownTimer = 3;

    private UIDatePickerMode() {
    }
}
