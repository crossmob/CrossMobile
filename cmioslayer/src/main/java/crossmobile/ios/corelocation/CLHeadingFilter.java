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
 * CLHeadingFilter class defines the minimum change of device's heading before
 * an update is triggered.
 */
@CMEnum
public final class CLHeadingFilter {

    /**
     * The default value that includes all heading changes.
     */
    public static final double None = -1;

    private CLHeadingFilter() {
    }
}
