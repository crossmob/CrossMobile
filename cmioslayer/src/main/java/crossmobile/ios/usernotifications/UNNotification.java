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
