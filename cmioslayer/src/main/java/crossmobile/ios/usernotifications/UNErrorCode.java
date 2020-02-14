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
