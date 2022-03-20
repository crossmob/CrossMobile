/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.contacts;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class CNContactDisplayNameOrder {

    public static final int CNContactDisplayNameOrderUserDefault = 0;
    public static final int CNContactDisplayNameOrderGivenNameFirst = 1;
    public static final int CNContactDisplayNameOrderFamilyNameFirst = 2;

    private CNContactDisplayNameOrder() {
    }

}
