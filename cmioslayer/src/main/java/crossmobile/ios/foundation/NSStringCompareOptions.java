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
