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
 * UILayoutPriority class defines values that indicate priorities of
 * restrictions for the constraint based layout system.
 */
@CMEnum
public final class UILayoutPriority {

    /**
     * A required priority constraint that restricts all layout constraints to
     * exceed this value.
     */
    public static final float Required = 1000;

    /**
     * The priority related to a view's content compressing resistance.
     */
    public static final float DefaultHigh = 750;

    /**
     * The priority related to the way a view horizontally encloses its content.
     */
    public static final float DefaultLow = 250;

    /**
     * The priority related to a view's resistance to comply with a size
     * computed to fit the layout.
     */
    public static final float FittingSizeLevel = 50;

    private UILayoutPriority() {
    }
}
