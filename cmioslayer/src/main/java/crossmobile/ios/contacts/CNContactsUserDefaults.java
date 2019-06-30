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
