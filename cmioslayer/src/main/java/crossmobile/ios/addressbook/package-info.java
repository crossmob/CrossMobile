/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

@CMLib(name = "cmaddressbook", libs = {"AddressBook.framework", "AddressBookUI.framework"},
        displayName = "AddressBook Framework", description = "CrossMobile© Compatibility library for AddressBook Framework",
        depends = @CMLibDepends(pluginName = "cmioslayer"), includes = {"<AddressBook/AddressBook.h>", "<AddressBookUI/AddressBookUI.h>", "<Accounts/Accounts.h>"} ,target = CMLibTarget.API_NOUWP)
package crossmobile.ios.addressbook;

import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibDepends;
import org.crossmobile.bridge.ann.CMLibTarget;
