/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.usernotifications;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class UNErrorCode {

    UNErrorCode() {
    }

    public static final int NotificationsNotAllowed = 1;
    public static final int AttachmentInvalidURL = 100;
    public static final int AttachmentUnrecognizedType = 101;
    public static final int AttachmentInvalidFileSize = 102;
    public static final int AttachmentNotInDataStore = 103;
    public static final int AttachmentMoveIntoDataStoreFailed = 104;
    public static final int AttachmentCorrupt = 105;
    public static final int NotificationInvalidNoDate = 1400;
    public static final int NotificationInvalidNoContent = 1401;
}
