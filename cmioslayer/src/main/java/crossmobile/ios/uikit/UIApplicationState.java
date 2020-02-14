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
package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * Application states
 */
@CMEnum
public final class UIApplicationState {
    /**
     * The application is active and in the foreground
     */
    public static final int Active = 0;
    /**
     * The application is in the foreground but not in active state
     */
    public static final int Inactive = 1;
    /**
     * The application runs in the background
     */
    public static final int Background = 2;

    private UIApplicationState() {
    }
}
