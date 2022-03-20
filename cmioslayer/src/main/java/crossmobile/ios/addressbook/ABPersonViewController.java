/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.addressbook;

import crossmobile.ios.uikit.UIViewController;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMSetter;

import java.util.List;

/**
 * ABPersonViewController class is the UIViewController responsible for
 * displaying ABPerson data.
 */
@Deprecated
@CMClass
public class ABPersonViewController extends UIViewController {


    /**
     * Returns the delegate of this ABPersonViewController.
     *
     * @return The delegate of this ABPersonViewController.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, assign) id<ABPersonViewControllerDelegate> personViewDelegate;")
    public ABPersonViewControllerDelegate personViewDelegate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Sets the delegate of this ABPersonViewController.
     *
     * @param personViewDelegate The delegate of this ABPersonViewController.
     */
    @CMSetter("@property(nonatomic, assign) id<ABPersonViewControllerDelegate> personViewDelegate;")
    public void setPersonViewDelegate(crossmobile.ios.addressbook.ABPersonViewControllerDelegate personViewDelegate) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns the address book of this ABPersonViewController.
     *
     * @return The address book of this ABPersonViewController.
     */
    @CMGetter("@property(nonatomic, readwrite) ABAddressBookRef addressBook;")
    public ABAddressBook addressBook() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Sets the address book of this ABPersonViewController.
     *
     * @param addressBook The address book of this ABPersonViewController.
     */
    @CMSetter("@property(nonatomic, readwrite) ABAddressBookRef addressBook;")
    public void setAddressBook(ABAddressBook addressBook) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns the person that is displayed.
     *
     * @return The person that is displayed.
     */
    @CMGetter("@property(nonatomic, readwrite) ABRecordRef displayedPerson;")
    public ABRecord displayedPerson() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Sets the person that is displayed.
     *
     * @param displayedPerson The person that is displayed.
     */
    @CMSetter("@property(nonatomic, readwrite) ABRecordRef displayedPerson;")
    public void setDisplayedPerson(ABRecord displayedPerson) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns a list with the properties of the displayed person.
     *
     * @return A list that contains the properties of the displayed person.
     */
    @CMGetter("@property(nonatomic, copy) NSArray<NSNumber *> *displayedProperties;")
    public List displayedProperties() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Sets the list with the properties of the displayed person.
     *
     * @param displayedProperties The list with the properties of the displayed
     *                            person.
     */
    @CMSetter("@property(nonatomic, copy) NSArray<NSNumber *> *displayedProperties;")
    public void setDisplayedProperties(List displayedProperties) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns a Boolean that shows whether person's information is editable.
     *
     * @return A Boolean that shows whether person's information is editable.
     */
    @CMGetter("@property(nonatomic) BOOL allowsEditing;")
    public boolean allowsEditing() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Sets a Boolean that defines whether person's information is editable.
     *
     * @param allowsEditing A Boolean that shows whether person's information is
     *                      editable.
     */
    @CMSetter("@property(nonatomic) BOOL allowsEditing;")
    public void setAllowsEditing(boolean allowsEditing) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns a Boolean that shows whether actions such as text message sending
     * are allowed.
     *
     * @return A Boolean that shows whether actions such as text message sending
     * are allowed.
     */
    @CMGetter("@property(nonatomic) BOOL allowsActions;")
    public boolean allowsActions() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Sets a Boolean that defines whether actions such as text message sending
     * are allowed.
     *
     * @param allowsActions A Boolean that shows whether actions such as text
     *                      message sending are allowed.
     */
    @CMSetter("@property(nonatomic) BOOL allowsActions;")
    public void setAllowsActions(boolean allowsActions) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns a Boolean that shows whether data from person records should be
     * displayed.
     *
     * @return A Boolean that shows whether data from person records should be
     * displayed.
     */
    @CMGetter("@property(nonatomic) BOOL shouldShowLinkedPeople;\n"
            + "")
    public boolean shouldShowLinkedPeople() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Sets a Boolean that defines whether data from person records should be
     * displayed.
     *
     * @param shouldShowLinkedPeople A Boolean that defines whether data from
     *                               person records should be displayed.
     */
    @CMSetter("@property(nonatomic) BOOL shouldShowLinkedPeople;\n"
            + "")
    public void setShouldShowLinkedPeople(boolean shouldShowLinkedPeople) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Specifies whether the particular property of the displayed person should
     * be highlighted.
     *
     * @param property   The property to highlight.
     * @param identifier The value to highlight.(for multivalue properties)
     */
    @CMSelector("- (void)setHighlightedItemForProperty:(ABPropertyID)property \n"
            + "                       withIdentifier:(ABMultiValueIdentifier)identifier;")
    public void setHighlightedItemForProperty(int property, int identifier) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
