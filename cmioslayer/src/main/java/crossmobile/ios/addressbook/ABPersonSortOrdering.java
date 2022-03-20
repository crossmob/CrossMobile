/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.addressbook;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * ABPersonSortOrdering class defines different sort ordering preferences for
 * person lists.
 */
@CMEnum
public final class ABPersonSortOrdering {

    /**
     * Order contacts by first name.
     */
    public static final long ByFirstName = 0;

    /**
     * Order contacts by last name.
     */
    public static final long ByLastName = 1;

    private ABPersonSortOrdering() {
    }

}
