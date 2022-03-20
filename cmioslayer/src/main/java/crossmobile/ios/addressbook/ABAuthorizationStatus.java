/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
