/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.usernotifications;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class UNNotificationAttachmentOptions {

    UNNotificationAttachmentOptions() {
    }

    public final static String TypeHintKey = "UNNotificationAttachmentOptionsTypeHintKey";
    public final static String ThumbnailHiddenKey = "UNNotificationAttachmentOptionsThumbnailHiddenKey";
    public final static String ThumbnailClippingRectKey = "UNNotificationAttachmentOptionsThumbnailClippingRectKey";
    public final static String ThumbnailTimeKey = "UNNotificationAttachmentOptionsThumbnailTimeKey";
}
