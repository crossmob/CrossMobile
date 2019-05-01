/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
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
