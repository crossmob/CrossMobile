/*
 * (c) 2019 by Panayotis Katsaloulis
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
package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * The result of a push notification event
 */
@CMEnum
public final class UIBackgroundFetchResult {
    /**
     * Data was downloaded
     */
    public static final int NewData = 0;
    /**
     * No data is available
     */
    public static final int NoData = 1;
    /**
     * Failed when downloading data
     */
    public static final int Failed = 2;

    private UIBackgroundFetchResult() {
    }
}
