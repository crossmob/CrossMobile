/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.contacts;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class CNContactSortOrder {

    public final static int none = 0;
    public final static int userDefault = 1;
    public final static int givenName = 2;
    public final static int familyName = 3;

    private CNContactSortOrder() {
    }

}
