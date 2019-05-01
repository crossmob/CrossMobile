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
 * ABAuthorizationStatus class defines different values concerning application's
 * authorization to the address book data.
 */
@CMEnum
public final class ABAuthorizationStatus {

    /**
     * Undetermined authorization status.
     */
    public static final int NotDetermined = 0;

    /**
     * Access to address book is denied.
     */
    public static final int Restricted = 1;

    /**
     * Access to address book data is denied explicitly by the user.
     */
    public static final int Denied = 2;

    /**
     * Access to address book data is permitted.
     */
    public static final int Authorized = 3;

    private ABAuthorizationStatus() {
    }

}
