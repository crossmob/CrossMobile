/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.contacts;

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;
import org.crossmobile.bridge.ann.CMSelector;


@CMClass
@CMLib(target = CMLibTarget.API_NOUWP)
public class CNContactsUserDefaults extends NSObject {

    private String countryCode;
    private CNContactSortOrder order;
    private static CNContactsUserDefaults instance = null;

    @CMSelector("+ (instancetype)sharedDefaults;")
    public static CNContactsUserDefaults sharedDefaults() {
        if (instance == null)
            instance = new CNContactsUserDefaults();
        return instance;
    }

    private CNContactsUserDefaults() {
    }

}
