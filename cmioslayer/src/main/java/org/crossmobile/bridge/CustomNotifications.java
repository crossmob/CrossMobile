// (c) 2020 by Panayotis Katsaloulis
// SPDX-License-Identifier: LGPL-3.0-only

package org.crossmobile.bridge;

import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;

@CMLib(target = CMLibTarget.BUILDONLY)
public final class CustomNotifications {

    /**
     * Use to cancel the Android back button. By default the back button on the last page exits the application.
     * Before exiting, the system gives the application the chance to handle this event and probably abort program exit.
     * <p>
     * By listening to this notification, the object() property provides an AtomicBoolean with default value to "false".
     * If the application changes this value to "true" then the event is considered handled, and the application does not exit.
     */
    public static final String AndroidBackButtonNotification = "AndroidBackButtonNotification";

    private CustomNotifications() {
    }
}
