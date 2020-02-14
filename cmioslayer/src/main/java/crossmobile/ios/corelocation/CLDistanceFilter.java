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
package crossmobile.ios.corelocation;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * CLDistanceFilter class defines the minimum distance of a device's move
 * horizontally before an update is triggered.
 */
@CMEnum
public final class CLDistanceFilter {

    /**
     * The default value.
     */
    public static final double None = -1;

    private CLDistanceFilter() {
    }
}
