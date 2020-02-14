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
package crossmobile.ios.mapkit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * MKPinAnnotationColor class defines different colors for annotation pins that
 * indicate point on the map.
 */
@CMEnum
public final class MKPinAnnotationColor {

    /**
     * A red head pin.
     */
    public static final int Red = 0;

    /**
     * A green head pin.
     */
    public static final int Green = 1;

    /**
     * A purple head pin.
     */
    public static final int Purple = 2;

    private MKPinAnnotationColor() {
    }
}
