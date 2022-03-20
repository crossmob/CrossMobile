/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIAlertControllerStyle class defines different types of alerts.
 */
@CMEnum
public final class UIAlertControllerStyle {

    /**
     * The alert is displayed as an action sheet within the related view
     * controller.
     */
    public static final int Sheet = 0;

    /**
     * The alert is displayed modally for the application.
     */
    public static final int Alert = 1;

    private UIAlertControllerStyle() {
    }

}
