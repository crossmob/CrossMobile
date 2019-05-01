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
package crossmobile.ios.usernotifications;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class UNErrorCode {

    UNErrorCode() {
    }

    public static final long NotificationsNotAllowed = 1;
    public static final long AttachmentInvalidURL = 100;
    public static final long AttachmentUnrecognizedType = 101;
    public static final long AttachmentInvalidFileSize = 102;
    public static final long AttachmentNotInDataStore = 103;
    public static final long AttachmentMoveIntoDataStoreFailed = 104;
    public static final long AttachmentCorrupt = 105;
    public static final long NotificationInvalidNoDate = 1400;
    public static final long NotificationInvalidNoContent = 1401;
}
