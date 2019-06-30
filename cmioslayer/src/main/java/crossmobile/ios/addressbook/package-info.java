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
@CMLib(name = "cmaddressbook", libs = {"AddressBook.framework", "AddressBookUI.framework"},
        displayName = "AddressBook Framework", description = "CrossMobile© Compatibility library for AddressBook Framework",
        depends = @CMLibDepends(pluginName = "cmioslayer"), includes = {"<AddressBook/AddressBook.h>", "<AddressBookUI/AddressBookUI.h>", "<Accounts/Accounts.h>"} ,target = CMLibTarget.API_NOUWP)
package crossmobile.ios.addressbook;

import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibDepends;
import org.crossmobile.bridge.ann.CMLibTarget;
