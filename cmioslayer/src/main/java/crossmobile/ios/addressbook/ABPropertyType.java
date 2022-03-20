/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.addressbook;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * ABPropertyType defines different types of record properties.
 */
@CMEnum
public final class ABPropertyType {

    /**
     * Multi-value property.
     */
    public static final int MultiValueMask = 1 << 8;

    /**
     * Invalid property.
     */
    public static final int Invalid = 0;

    /**
     * String property.
     */
    public static final int String = 1;

    /**
     * Integer property.
     */
    public static final int Integer = 2;

    /**
     * Real property.
     */
    public static final int Real = 3;

    /**
     * Date-time property.
     */
    public static final int DateTime = 4;

    /**
     * Dictionary property.
     */
    public static final int Dictionary = 5;

    /**
     * Multi-string property.
     */
    public static final int MultiString = MultiValueMask | String;

    /**
     * Multi-integer property.
     */
    public static final int MultiInteger = MultiValueMask | Integer;

    /**
     * Multi-real property.
     */
    public static final int MultiReal = MultiValueMask | Real;

    /**
     * Multi–date-time property.
     */
    public static final int MultiDateTime = MultiValueMask | DateTime;

    /**
     * Multi-dictionary property.
     */
    public static final int MultiDictionary = MultiValueMask | Dictionary;

    /**
     * Invalid property.
     */
    public static final int InvalidID = -1;

    private ABPropertyType() {
    }

}
