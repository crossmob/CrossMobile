/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIRemoteNotificationType class specifies the types of notifications that the
 * application displays to the user.
 */
@CMEnum
public final class UIRemoteNotificationType {

    /**
     * The application displays no notifications.
     */
    public static final int None = 0;

    /**
     * The application displays notifications as badges.
     */
    public static final int Badge = 1;

    /**
     * The application uses sound notifications.
     */
    public static final int Sound = 2;

    /**
     * The application displays alert notifications.
     */
    public static final int Alert = 4;

    /**
     * The application uses notifications that cause downloading of issue assets
     * for Newsstand applications.
     */
    public static final int NewsstandContentAvailability = 8;

    private UIRemoteNotificationType() {
    }
}
