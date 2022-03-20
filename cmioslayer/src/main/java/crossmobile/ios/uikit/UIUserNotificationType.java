/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
