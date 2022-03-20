/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.addressbook;

import crossmobile.ios.uikit.UIViewController;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSetter;

/**
 * ABUnknownPersonViewController class is the UIViewController responsible for
 * creating person records.
 */
@Deprecated
@CMClass
public final class ABUnknownPersonViewController extends UIViewController {

    private ABAddressBook addressBook;
    private ABRecord displayedPerson;
    private String alternateName;
    private String message;
    private boolean allowsActions;
    private boolean allowsAddingToAddressBook;

    /**
     * Returns delegate of this ABUnknownPersonViewController.
     *
     * @return The delegate of this ABUnknownPersonViewController.
     */
    @CMGetter(" @property(nonatomic, assign) id< ABUnknownPersonViewControllerDelegate > unknownPersonViewDelegate ")
    public ABUnknownPersonViewControllerDelegate unknownPersonViewDelegate() {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Sets the delegate for this ABUnknownPersonViewController.
     *
     * @param unknownPersonViewDelegate The delegate of this
     *                                  ABUnknownPersonViewController.
     */
    @CMSetter(" @property(nonatomic, assign) id< ABUnknownPersonViewControllerDelegate > unknownPersonViewDelegate ")
    public void setUnknownPersonViewDelegate(ABUnknownPersonViewControllerDelegate unknownPersonViewDelegate) {
        Native.system().notImplemented();
    }

    /**
     * Returns the address book to which the person is added.
     *
     * @return The address book to which the person is added.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, readwrite) ABAddressBookRef addressBook;")
    public ABAddressBook addressBook() {
        return addressBook;
    }

    /**
     * Sets the address book to which the person is added.
     *
     * @param addressBook The address book to which the person is added.
     */
    @Deprecated
    @CMSetter("@property(nonatomic, readwrite) ABAddressBookRef addressBook;")
    public void setAddressBook(ABAddressBook addressBook) {
        this.addressBook = addressBook;
    }

    /**
     * Returns the person record that is displayed by the view controller.
     *
     * @return The person record that is displayed by the view controller.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, readwrite) ABRecordRef displayedPerson;")
    public ABRecord displayedPerson() {
        return displayedPerson;
    }

    /**
     * Sets the person record to be displayed by the view controller.
     *
     * @param displayedPerson The person record to be displayed by the view
     *                        controller.
     */
    @Deprecated
    @CMSetter("@property(nonatomic, readwrite) ABRecordRef displayedPerson;")
    public void setDisplayedPerson(ABRecord displayedPerson) {
        this.displayedPerson = displayedPerson;
    }

    /**
     * Returns a value that is displayed as an alternative of the first and last
     * name.
     *
     * @return A value that is displayed as an alternative of the first and last
     * name.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, copy) NSString *alternateName;")
    public String alternateName() {
        return alternateName;
    }

    /**
     * Sets a value to be displayed as an alternative of the first and last
     * name.
     *
     * @param alternateName A value to be displayed as alternative of the first
     *                      and last name.
     */
    @Deprecated
    @CMSetter("@property(nonatomic, copy) NSString *alternateName;")
    public void setAlternateName(String alternateName) {
        this.alternateName = alternateName;
    }

    /**
     * Returns the text that is displayed below the alternative name.
     *
     * @return The text that is displayed below the alternative name.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, copy) NSString *message;")
    public String message() {
        return message;
    }

    /**
     * Sets the text to be displayed below the alternative name.
     *
     * @param message The text to be displayed below the alternative name.
     */
    @Deprecated
    @CMSetter("@property(nonatomic, copy) NSString *message;")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Returns a Boolean that shows whether actions such as text message sending
     * are allowed.
     *
     * @return TRUE then actions such as text message sending are allowed.
     */
    @Deprecated
    @CMGetter("@property(nonatomic) BOOL allowsActions;")
    public boolean allowsActions() {
        return allowsActions;
    }

    /**
     * Sets a Boolean that defines whether actions such as text message sending
     * are allowed.
     *
     * @param allowsActions TRUE then actions such as text message sending are
     *                      allowed.
     */
    @Deprecated
    @CMSetter("@property(nonatomic) BOOL allowsActions;")
    public void setAllowsActions(boolean allowsActions) {
        this.allowsActions = allowsActions;
    }

    /**
     * Returns a Boolean that shows whether the user can add the properties
     * displayed to the address book.
     *
     * @return TRUE then the user can add the displayed properties to the
     * address book.
     */
    @Deprecated
    @CMGetter("@property(nonatomic) BOOL allowsAddingToAddressBook;")
    public boolean allowsAddingToAddressBook() {
        return allowsAddingToAddressBook;
    }

    /**
     * Sets a Boolean that defines whether the user can add the properties
     * displayed to the address book.
     *
     * @param allowsAddingToAddressBook TRUE then the user can add the displayed
     *                                  properties to the address book.
     */
    @Deprecated
    @CMSetter("@property(nonatomic) BOOL allowsAddingToAddressBook;")
    public void setAllowsAddingToAddressBook(boolean allowsAddingToAddressBook) {
        this.allowsAddingToAddressBook = allowsAddingToAddressBook;
    }
}
