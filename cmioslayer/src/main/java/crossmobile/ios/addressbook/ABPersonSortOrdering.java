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
