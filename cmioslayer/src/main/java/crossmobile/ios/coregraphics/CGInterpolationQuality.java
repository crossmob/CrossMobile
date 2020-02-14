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
package crossmobile.ios.coregraphics;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * CGInterpolationQuality class defines different values of interpolation
 * quality when enlarging images.
 */
@CMEnum
public final class CGInterpolationQuality {

    /**
     * The default interpolation quality.
     */
    public static final int Default = 0;

    /**
     * No interpolation.
     */
    public static final int None = 1;

    /**
     * Low interpolation quality.
     */
    public static final int Low = 2;

    /**
     * Medium interpolation quality.
     */
    public static final int Medium = 4;

    /**
     * High level interpolation quality.
     */
    public static final int High = 3;

    private CGInterpolationQuality() {
    }
}
