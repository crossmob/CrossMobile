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
package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * CFNumberFormatterStyle class defines different formatting styles for numbers.
 */
@CMEnum
public final class CFNumberFormatterStyle {

    /**
     * No style.
     */
    public static final int NoStyle = 0;

    /**
     * Decimal style format.
     */
    public static final int DecimalStyle = 1;

    /**
     * Currency style format.
     */
    public static final int CurrencyStyle = 2;

    /**
     * Percent style format.
     */
    public static final int PercentStyle = 3;

    /**
     * Scientific style format.
     */
    public static final int ScientificStyle = 4;

    /**
     * Spelled out style format.
     */
    public static final int SpellOutStyle = 5;

    private CFNumberFormatterStyle() {
    }
}
