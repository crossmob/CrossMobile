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
