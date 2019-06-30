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
