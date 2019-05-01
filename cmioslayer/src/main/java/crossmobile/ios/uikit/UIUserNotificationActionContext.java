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
 * UIUserNotificationActionContext class defines different types of size of the
 * available space for notifications.
 */
@CMEnum
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
