/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.usernotifications;

import crossmobile.ios.foundation.NSObject;
import crossmobile.ios.foundation.NSSecureCoding;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;

@CMClass
public class UNNotificationResponse extends NSObject implements NSSecureCoding {

    private final String actionIdentifier;
    private final UNNotification notification;

    UNNotificationResponse(String actionIdentifier, UNNotification notification) {
        this.actionIdentifier = actionIdentifier;
        this.notification = notification;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSString *actionIdentifier;")
    public String actionIdentifier() {
        return actionIdentifier;
    }

    @CMGetter("@property(readonly, copy, nonatomic) UNNotification *notification;")
    public UNNotification notification() {
        return notification;
    }
}
