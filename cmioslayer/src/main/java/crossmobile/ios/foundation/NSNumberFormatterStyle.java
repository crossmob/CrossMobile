/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
