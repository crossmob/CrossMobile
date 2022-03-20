/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.addressbook;

import crossmobile.ios.uikit.UINavigationController;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSetter;

import java.util.List;

/**
 * ABPeoplePickerNavigationController class defines an object that is
 * responsible for handling views displaying contacts from the address book.
 */
@CMClass
@Deprecated
public class ABPeoplePickerNavigationController extends UINavigationController {


    /**
     * Returns the delegate of this ABPeoplePickerNavigationController.
     *
     * @return The delegate of this ABPeoplePickerNavigationController.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, assign) id<ABPeoplePickerNavigationControllerDelegate> peoplePickerDelegate;")
    public ABPeoplePickerNavigationControllerDelegate peoplePickerDelegate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Sets the delegate for this ABPeoplePickerNavigationController.
     *
     * @param peoplePickerDelegate The delegate for this
     *                             ABPeoplePickerNavigationController.
     */
    @Deprecated
    @CMSetter("@property(nonatomic, assign) id<ABPeoplePickerNavigationControllerDelegate> peoplePickerDelegate;")
    public void setPeoplePickerDelegate(ABPeoplePickerNavigationControllerDelegate peoplePickerDelegate) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns the list of properties displayed for a person.
     *
     * @return The list of properties displayed for a person.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, copy) NSArray<NSNumber *> *displayedProperties;")
    public List<Integer> displayedProperties() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Sets the list of properties displayed for a person.
     *
     * @param displayedProperties The list of properties displayed for a person.
     */
    @Deprecated
    @CMSetter("@property(nonatomic, copy) NSArray<NSNumber *> *displayedProperties;")
    public void setDisplayedProperties(List<Integer> displayedProperties) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns the address book from which the list of contacts is obtained.
     *
     * @return The address book from which the list of contacts is obtained.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, readwrite) ABAddressBookRef addressBook;\n"
            + "")
    public ABAddressBook addressBook() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Sets the address book from which the list of contacts is obtained.
     *
     * @param addressBook The address book from which the list of contacts is
     *                    obtained.
     */
    @Deprecated
    @CMSetter("@property(nonatomic, readwrite) ABAddressBookRef addressBook;\n"
            + "")
    public void setAddressBook(ABAddressBook addressBook) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
