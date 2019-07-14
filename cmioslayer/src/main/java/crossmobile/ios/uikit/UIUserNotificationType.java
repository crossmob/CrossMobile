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
import org.crossmobile.bridge.ann.CMLib;

/**
 * UIUserNotificationType class defines different types of application alerts
 * after a notification arises.
 */
@CMEnum
@CMLib(name = "cmnotifications")
public final class UIUserNotificationType {

    /**
     * No notification alert.
     */
    public static final int None = 0;

    /**
     * Changes the icon badge.
     */
    @SuppressWarnings("PointlessBitwiseExpression")
    public static final int Badge = 1 << 0;

    /**
     * Plays a sound.
     */
    public static final int Sound = 1 << 1;

    /**
     * Posts an alert.
     */
    public static final int Alert = 1 << 2;

    private UIUserNotificationType() {
    }

    static int notificationTypeToAuthorizationOption(int notificationType) {
        return notificationType & 0x7;
    }
}
