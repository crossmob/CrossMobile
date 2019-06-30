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
 * UIScrollViewDecelerationRate class specifies how fast a scrolling view moves.
 */
@CMEnum
public final class UIScrollViewDecelerationRate {

    /**
     * The view moves with the default scrolling speed.
     */
    public static final float Normal = 0.998f;

    /**
     * The view moves with fast scrolling speed.
     */
    public static final float Fast = 0.99f;

    private UIScrollViewDecelerationRate() {
    }
}
