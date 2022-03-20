/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.addressbook;

import crossmobile.ios.foundation.CFType;
import crossmobile.ios.foundation.NSError;
import crossmobile.rt.StrongReference;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMFunction;
import org.crossmobile.bridge.ann.CMReference;

import java.util.List;
import java.util.Map;

/**
 * ABAddressBook class defines an object that is used for handling and
 * representing stored contacts of the application.
 */
@Deprecated
@CMReference
public class ABAddressBook extends CFType {

    /**
     * Returns the authorization status of the application for the address book.
     *
     * @return The authorization status of the application.
     */
    @CMFunction("ABAuthorizationStatus ABAddressBookGetAuthorizationStatus(void);")
    public static int getAuthorizationStatus() {
        return ABAuthorizationStatus.NotDetermined;
    }

    /**
     * Constructs a new ABAddressBook object using the specified options.
     *
     * @param options The options used for the creation of the new object.
     * @param error   The error that occurs in case of failure.
     */
    @CMConstructor(" ABAddressBookRef ABAddressBookCreateWithOptions ( CFDictionaryRef options, CFErrorRef *error ); ")
    public ABAddressBook(Map<String, ? extends Object> options, StrongReference<NSError> error) {
    }

    /**
     * Returns the local version of the specified record label.
     *
     * @param label The label for which the local version is requested.
     * @return The local version of the specified label.
     */
    @CMFunction(" CFStringRef ABAddressBookCopyLocalizedLabel ( CFStringRef label ); ")
    public static String copyLocalizedLabel(String label) {
        return label;
    }

    /**
     * Requests access to address book from the user.
     *
     * @param completion The handler that is called for the specified operation.
     */
    @CMFunction(" void ABAddressBookRequestAccessWithCompletion ( ABAddressBookRef addressBook, ABAddressBookRequestAccessCompletionHandler completion ); ")
    public void requestAccessWithCompletion(ABAddressBookRequestAccessCompletionHandler completion) {

    }

    /**
     * Saves any unsaved changes in the address book.
     *
     * @param error The error that occurs in case of failure.
     * @return TRUE if the operation was successful.
     */
    @CMFunction("bool ABAddressBookSave(ABAddressBookRef addressBook, CFErrorRef *error);")
    public boolean save(StrongReference<NSError> error) {
        return false;
    }

    /**
     * Returns a Boolean that shows whether the address book has unsaved
     * changes.
     *
     * @return TRUE if there are unsaved changes.
     */
    @CMFunction("bool ABAddressBookHasUnsavedChanges ( ABAddressBookRef addressBook );")
    public boolean hasUnsavedChanges() {
        return false;
    }

    /**
     * Adds the specified record to the address book.
     *
     * @param record The record that is added to the address book.
     * @param error  The error that occurs in case of failure.
     * @return TRUE if the operation was successful.
     */
    @CMFunction("bool ABAddressBookAddRecord ( ABAddressBookRef addressBook, ABRecordRef record, CFErrorRef *error );")
    public boolean addRecord(ABRecord record, StrongReference<NSError> error) {
        return false;
    }

    /**
     * Removes the specified record from the address book.
     *
     * @param record The record that is being removed from the address book.
     * @param error  The error that occurs in case of failure.
     * @return TRUE if the operation was successful.
     */
    @CMFunction("bool ABAddressBookRemoveRecord ( ABAddressBookRef addressBook, ABRecordRef record, CFErrorRef *error );")
    public boolean removeRecord(ABRecord record, StrongReference<NSError> error) {
        return false;
    }

//    @CMFunction("void ABAddressBookRegisterExternalChangeCallback(ABAddressBookRef addressBook, ABExternalChangeCallback callback, void *context);")
//    public void registerExternalChangeCallback(NSSelector<Object> callback, Object context) {
//    }
//    
//    @CMFunction("void ABAddressBookUnregisterExternalChangeCallback(ABAddressBookRef addressBook, ABExternalChangeCallback callback, void *context);")
//    public void unregisterExternalChangeCallback(NSSelector<Object> callback, Object context) {
//    }
//

    /**
     * Discards any unsaved changes of the address book.
     */
    @CMFunction("void ABAddressBookRevert(ABAddressBookRef addressBook);")
    public void revert() {
    }

    /**
     * Returns the group of the specified id.
     *
     * @param recordID The id for which the group is requested.
     * @return The group of the specified id.
     */
    @CMFunction("ABRecordRef ABAddressBookGetGroupWithRecordID(ABAddressBookRef addressBook, ABRecordID recordID);")
    public ABRecord getGroupWithRecordID(int recordID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns the number of groups of this address book.
     *
     * @return The number of groups of this address book.
     */
    @CMFunction("CFIndex ABAddressBookGetGroupCount(ABAddressBookRef addressBook);")
    public long getGroupCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns a list of all the groups of this address book.
     *
     * @return A list of all the groups of this address book.
     */
    @CMFunction(" CFArrayRef ABAddressBookCopyArrayOfAllGroups ( ABAddressBookRef addressBook ); ")
    public List copyArrayOfAllGroups() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns a list of all the groups of the specified address book.
     *
     * @param source The address book for which the groups are requested.
     * @return A list with all the groups of the specified address book.
     */
    @CMFunction(" CFArrayRef ABAddressBookCopyArrayOfAllGroupsInSource ( ABAddressBookRef addressBook, ABRecordRef source ); ")
    public List copyArrayOfAllGroupsInSource(ABRecord source) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns the number of records stored in the address book.
     *
     * @return The number of records stored in the address book.
     */
    @CMFunction("CFIndex ABAddressBookGetPersonCount(ABAddressBookRef addressBook);")
    public long getPersonCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns the record of a person that corresponds to the specified id.
     *
     * @param recordID The id of the record that is requested.
     * @return The record that corresponds to the specified id.
     */
    @CMFunction("ABRecordRef ABAddressBookGetPersonWithRecordID(ABAddressBookRef addressBook, ABRecordID recordID);")
    public ABRecord getPersonWithRecordID(int recordID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns a list with all the records of the address book.
     *
     * @return A list with all the records of the address book.
     */
    @CMFunction(" CFArrayRef ABAddressBookCopyArrayOfAllPeople ( ABAddressBookRef addressBook ); ")
    public List copyArrayOfAllPeople() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns a list that contains all person records from this address book.
     *
     * @param source The address book whose person records are returned.
     * @return The list that contains all the records of this address book
     */
    @CMFunction(" CFArrayRef ABAddressBookCopyArrayOfAllPeopleInSource ( ABAddressBookRef addressBook, ABRecordRef source ); ")
    public List copyArrayOfAllPeopleInSource(ABRecord source) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns a sorted list of the all the records of the specified address
     * book using the specified order.
     *
     * @param source       The address book that is used as a source.
     * @param sortOrdering The order to which the records are sorted.
     * @return The sorted list records.
     */
    @CMFunction(" CFArrayRef ABAddressBookCopyArrayOfAllPeopleInSourceWithSortOrdering ( ABAddressBookRef addressBook, ABRecordRef source, ABPersonSortOrdering sortOrdering ); ")
    public List copyArrayOfAllPeopleInSourceWithSortOrdering(ABRecord source, long sortOrdering) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns a list with all the records that contain the specified name as a
     * prefix.
     *
     * @param name The prefix which is used for searching the records.
     * @return A list with all the records with the prefix.
     */
    @CMFunction(" CFArrayRef ABAddressBookCopyPeopleWithName ( ABAddressBookRef addressBook, CFStringRef name ); ")
    public List copyPeopleWithName(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns the default addressbook source.
     *
     * @return The default addressbook source.
     */
    @CMFunction("ABRecordRef ABAddressBookCopyDefaultSource(ABAddressBookRef addressBook);")
    public ABRecord copyDefaultSource() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns the record of the address book for the specified id.
     *
     * @param sourceID The id of the record that is requested.
     * @return The record id of the specified id,NULL if not found.
     */
    @CMFunction("ABRecordRef ABAddressBookGetSourceWithRecordID(ABAddressBookRef addressBook, ABRecordID sourceID);")
    public ABRecord getSourceWithRecordID(int sourceID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns a list that contains all the sources of the address book.
     *
     * @return A list that contains all the sources of the address book.
     */
    @CMFunction(" CFArrayRef ABAddressBookCopyArrayOfAllSources ( ABAddressBookRef addressBook ); ")
    public List copyArrayOfAllSources() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
