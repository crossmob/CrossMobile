/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;
import org.crossmobile.bridge.ann.CMLib;

/**
 * UIUserNotificationActivationMode class defines the position of the
 * application after activation.
 */
@CMEnum
@CMLib(name = "cmnotifications")
public final class UIUserNotificationActivationMode {

    /**
     * The application is activated and moved to the foreground.
     */
    public static final int Foreground = 0;

    /**
     * The application is activated and moved to the background.
     */
    public static final int Background = 1;

    private UIUserNotificationActivationMode() {
    }

}
