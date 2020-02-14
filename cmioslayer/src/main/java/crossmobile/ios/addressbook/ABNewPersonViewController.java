/*
 * (c) 2020 by Panayotis Katsaloulis
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
package crossmobile.ios.addressbook;

import crossmobile.ios.uikit.UIViewController;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSetter;

/**
 * ABNewPersonViewController class is view controller that is responsible for
 * handling new contacts that added to the address book.
 */
@Deprecated
@CMClass
public class ABNewPersonViewController extends UIViewController {

    private ABNewPersonViewControllerDelegate newPersonViewDelegate;
    private ABAddressBook addressBook;
    private ABRecord displayedPerson;
    private ABRecord parentGroup;

    /**
     * Returns the delegate of this ABNewPersonViewController.
     *
     * @return The delegate of this ABNewPersonViewController.
     */
    @Deprecated
    @CMGetter(" @property(nonatomic, assign) id< ABNewPersonViewControllerDelegate > newPersonViewDelegate ")
    public ABNewPersonViewControllerDelegate newPersonViewDelegate() {
        return newPersonViewDelegate;
    }

    /**
     * Sets the delegate for this ABNewPersonViewController.
     *
     * @param newPersonViewDelegate The delegate of this
     *                              ABNewPersonViewController.
     */
    @CMSetter(" @property(nonatomic, assign) id< ABNewPersonViewControllerDelegate > newPersonViewDelegate ")
    public void setNewPersonViewDelegate(ABNewPersonViewControllerDelegate newPersonViewDelegate) {
        this.newPersonViewDelegate = newPersonViewDelegate;
    }

    /**
     * Returns the address book of the new added contacts.
     *
     * @return The address book of the new added contacts.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, readwrite) ABAddressBookRef addressBook;")
    public ABAddressBook addressBook() {
        return addressBook;
    }

    /**
     * Sets the address book to which the new contact is added.
     *
     * @param addressBook The address book for the new contact.
     */
    @Deprecated
    @CMSetter("@property(nonatomic, readwrite) ABAddressBookRef addressBook;")
    public void setAddressBook(ABAddressBook addressBook) {
        this.addressBook = addressBook;
    }

    /**
     * Returns the prefilled by the new person view controller person's
     * properties.
     *
     * @return The prefilled by the new person view controller person's
     * properties.
     */
    @CMGetter("@property(nonatomic, readwrite) ABRecordRef displayedPerson;")
    public ABRecord displayedPerson() {
        return displayedPerson;
    }

    /**
     * Sets the prefilled by the new person view controller person's properties.
     *
     * @param displayedPerson The prefilled by the new person view controller
     *                        person's properties.
     */
    @CMSetter("@property(nonatomic, readwrite) ABRecordRef displayedPerson;")
    public void setDisplayedPerson(ABRecord displayedPerson) {
        this.displayedPerson = displayedPerson;
    }

    /**
     * Returns the group into which the new added contacts are saved.
     *
     * @return The group into which the new added contacts are saved.
     */
    @CMGetter("@property(nonatomic, readwrite) ABRecordRef parentGroup;\n"
            + "")
    public ABRecord parentGroup() {
        return parentGroup;
    }

    /**
     * Sets the group into which the new added contacts are saved.
     *
     * @param parentGroup The group into which the new added contacts are saved.
     */
    @CMSetter("@property(nonatomic, readwrite) ABRecordRef parentGroup;\n"
            + "")
    public void setParentGroup(ABRecord parentGroup) {
        this.parentGroup = parentGroup;
    }
}
