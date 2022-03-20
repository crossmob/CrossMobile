/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * NSStringCompareOptions class defines different string search and comparison
 * options.
 */
@CMEnum
public final class NSStringCompareOptions {

    /**
     * A case sensitive String search.
     */
    public static final int NSCaseInsensitiveSearch = 1;

    /**
     * Compares two Strings character by character.
     */
    public static final int NSLiteralSearch = 2;

    /**
     * Searches the String from the end.
     */
    public static final int NSBackwardsSearch = 4;

    /**
     * Search for a prefix or a suffix in the String.
     */
    public static final int NSAnchoredSearch = 8;

    /**
     * Compares strings using numeric values that is State1 &lt;  State4 &lt; State16.
     */
    public static final int NSNumericSearch = 64;

    /**
     * Searches for Strings ignoring diacritic marks.
     */
    public static final int NSDiacriticInsensitiveSearch = 128;

    /**
     * Used for special occasions when Strings have full-width and half-width
     * forms such as in East Asian language.
     */
    public static final int NSWidthInsensitiveSearch = 256;

    /**
     * Used when comparing strings such as "bbb" and "BBB" that are equivalent
     * but not equal.
     */
    public static final int NSForcedOrderingSearch = 512;

    /**
     * Used when searching for regular expressions.
     */
    public static final int NSRegularExpressionSearch = 1024;

    private NSStringCompareOptions() {
    }
}
