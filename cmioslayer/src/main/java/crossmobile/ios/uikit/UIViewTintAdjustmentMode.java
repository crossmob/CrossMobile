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
 * UIViewTintAdjustmentMode class defines different options of view tint color
 * adjustment.
 */
@CMEnum
public final class UIViewTintAdjustmentMode {

    /**
     * The view automatically adjusts its tint color to the superview's or to
     * the UIViewTintAdjustmentModeNormal if there is no superview.
     */
    public static final int Automatic = 0;

    /**
     * The view changes its tint color to the initial without changes.
     */
    public static final int Normal = 1;

    /**
     * The view changes its tint color to a desaturated color version of the
     * original.
     */
    public static final int Dimmed = 2;

    private UIViewTintAdjustmentMode() {
    }
}
