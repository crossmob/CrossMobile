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
public final class UNNotificationActionOptions {

    UNNotificationActionOptions() {
    }

    public static final long None = 0;
    public static final long AuthenticationRequired = (1 << 0);
    public static final long Destructive = (1 << 1);
    public static final long Foreground = (1 << 2);
}
