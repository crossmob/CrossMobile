/*
 * (c) 2020 by Panayotis Katsaloulis
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
import org.crossmobile.bridge.ann.CMLib;

/**
 * UIUserNotificationActionContext class defines different types of size of the
 * available space for notifications.
 */
@CMEnum
@CMLib(name = "cmnotifications")
public final class UIUserNotificationActionContext {

    /**
     * Full size of the available space for the notification(default).
     */
    public static final int Default = 0;

    /**
     * Minimum size of the space available for the notification.
     */
    public static final int Minimal = 1;

    private UIUserNotificationActionContext() {
    }

}
