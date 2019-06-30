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
package crossmobile.ios.coregraphics;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * CGGradientDrawingOptions class defines different ways of applying color
 * gradients to specified locations.
 */
@CMEnum
public final class CGGradientDrawingOptions {

    /**
     * The color is applied beyond the specified start location.
     */
    public static final int DrawsBeforeStartLocation = 1;

    /**
     * The color is applied beyond the specified end location.
     */
    public static final int DrawsAfterEndLocation = (1 << 1);

    private CGGradientDrawingOptions() {
    }

}
