/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.contacts;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class CNContactType {

    //Na xanaidothoyn oi times
    public static final int CNContactTypePerson = 0;
    public static final int CNContactTypeOrganization = 1;

    private CNContactType() {
    }

}
