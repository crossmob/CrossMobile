/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;
import org.crossmobile.bridge.ann.CMLib;

/**
 * UIUserNotificationActionBehavior class defines different types of additional
 * supported action behaviors.
 */
@CMEnum
@CMLib(name = "cmnotifications")
public final class UIUserNotificationActionBehavior {

    /**
     * There are no additional action behaviors. (default)
     */
    public static final int Default = 0;

    /**
     * The user can add text to be included in the notification.
     */
    public static final int TextInput = 1;

    private UIUserNotificationActionBehavior() {
    }
}
