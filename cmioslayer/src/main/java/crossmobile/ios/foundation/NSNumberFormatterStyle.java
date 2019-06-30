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
package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * NSNumberFormatterStyle class defines different types of format styles applied
 * to numbers.
 */
@CMEnum
public final class NSNumberFormatterStyle {

    /**
     * The number has no style.
     */
    public static final int NoStyle = CFNumberFormatterStyle.NoStyle;

    /**
     * The number is displayed in decimal style format.
     */
    public static final int DecimalStyle = CFNumberFormatterStyle.DecimalStyle;

    /**
     * The number is displayed in a currency style format.
     */
    public static final int CurrencyStyle = CFNumberFormatterStyle.CurrencyStyle;

    /**
     * The number is displayed in percent style format.
     */
    public static final int PercentStyle = CFNumberFormatterStyle.PercentStyle;

    /**
     * The number is displayed in scientific style format.
     */
    public static final int ScientificStyle = CFNumberFormatterStyle.ScientificStyle;

    /**
     * The number is displayed in spell-out format.
     */
    public static final int SpellOutStyle = CFNumberFormatterStyle.SpellOutStyle;

    private NSNumberFormatterStyle() {
    }
}
