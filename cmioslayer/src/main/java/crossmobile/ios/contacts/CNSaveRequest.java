/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.contacts;

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

@CMClass
public class CNSaveRequest extends NSObject {

    private CNSaveRequest() {
    }

    @CMSelector("- (void)addContact:(CNMutableContact *)contact \n"
            + "toContainerWithIdentifier:(NSString *)identifier;")
    public void addContact(CNMutableContact contact, String identifier) {

    }

    @CMSelector("- (void)updateContact:(CNMutableContact *)contact;")
    public void updateContact(CNMutableContact contact) {

    }

    @CMSelector("- (void)deleteContact:(CNMutableContact *)contact;")
    public void deleteContact(CNMutableContact contact) {

    }

}
