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
 * UIUserNotificationType class defines different types of application alerts
 * after a notification arises.
 */
@CMEnum
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

}
