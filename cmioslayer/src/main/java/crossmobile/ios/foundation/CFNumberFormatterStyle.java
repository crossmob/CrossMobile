/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
