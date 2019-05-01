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
