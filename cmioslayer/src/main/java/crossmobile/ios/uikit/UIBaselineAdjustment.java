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
 * UIBaselineAdjustment class defines different text alignment options. *
 */
@CMEnum
public final class UIBaselineAdjustment {

    /**
     * The alignment of the text is done according to its font baseline.
     */
    public static final int AlignBaselines = 0;

    /**
     * The text is aligned to the center of the box that includes it.
     */
    public static final int AlignCenters = 1;

    /**
     * There is no alignment for the text.
     */
    public static final int None = 2;

    private UIBaselineAdjustment() {
    }

}
