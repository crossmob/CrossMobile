/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.usernotifications;

import crossmobile.ios.foundation.NSDate;
import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;

@CMClass
public class UNNotification extends NSObject {

    private final UNNotificationRequest request;
    private final NSDate date;
    public static final String DefaultActionIdentifier = "com.apple.UNNotificationDefaultActionIdentifier";
    public static final String DismissActionIdentifier = "com.apple.UNNotificationDismissActionIdentifier";

    UNNotification(UNNotificationRequest request, NSDate date) {
        this.date = date;
        this.request = request;
    }

    @CMGetter("@property(nonatomic, readonly, copy) UNNotificationRequest *request;")
    public UNNotificationRequest request() {
        return request;
    }

    @CMGetter("@property(nonatomic, readonly, copy) NSDate *date;")
    public NSDate date() {
        return date;
    }
}
