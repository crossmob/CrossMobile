/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
