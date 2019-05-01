/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
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
