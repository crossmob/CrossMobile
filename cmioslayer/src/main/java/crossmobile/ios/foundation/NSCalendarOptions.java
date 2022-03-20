/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * NSCalendarOptions class defines different types of arithmetic operations
 * related to calendars.
 */
@CMEnum
public final class NSCalendarOptions {

    /**
     * Arithmetic addition.
     */
    public static final int NSCalendarWrapComponents = 1 << 0;

    /**
     * Searching for a given time instance forward and backward.
     */
    public static final int NSCalendarMatchStrictly = 1 << 1;

    /**
     * Searching for a given time instance backward.
     */
    public static final int NSCalendarSearchBackwards = 1 << 2;

    /**
     * When searching for a given time instance backward and there is no
     * matching then an instance is returned which has the lower units preserved
     * and the higher units decreased.
     */
    public static final int NSCalendarMatchPreviousTimePreservingSmallerUnits = 1 << 8;

    /**
     * When searching for a given time instance forward and there is no matching
     * then an instance is returned which has the lower units preserved and the
     * higher units increased.
     */
    public static final int NSCalendarMatchNextTimePreservingSmallerUnits = 1 << 9;

    /**
     * When searching for a given time instance and there is no exact matching
     * then an instance is returned which has the next value of the higher units
     * without preserving the lower units.
     */
    public static final int NSCalendarMatchNextTime = 1 << 10;

    /**
     * When searching for a given time instance and there are more matching
     * items the first one is returned.
     */
    public static final int NSCalendarMatchFirst = 1 << 12;

    /**
     * When searching for a given time instance and there are more matching
     * items the last one is returned.
     */
    public static final int NSCalendarMatchLast = 1 << 13;

    private NSCalendarOptions() {
    }
}
