/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.addressbook;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * ABPeoplePickerNavigationControllerDelegate interface is the delegate that
 * cooperates with the ABPeoplePickerNavigationController and handles
 * people-picker user events.
 */
@SuppressWarnings("deprecation")
@CMClass
public interface ABPeoplePickerNavigationControllerDelegate {

    /**
     * It is used when the user taps Cancel.
     *
     * @param peoplePicker The ABPeoplePickerNavigationController that
     *                     corresponds to this delegate.
     */
    @CMSelector("- (void)peoplePickerNavigationControllerDidCancel:(ABPeoplePickerNavigationController *)peoplePicker;")
    public void didCancel(ABPeoplePickerNavigationController peoplePicker);

    /**
     * It is used when the user selects a contact.
     *
     * @param peoplePicker The ABPeoplePickerNavigationController that
     *                     corresponds to this delegate.
     * @param person       The selected person.
     * @return TRUE if the ABPeoplePickerNavigationController should perform the
     * predefined action.
     */
    @CMSelector("- (BOOL)peoplePickerNavigationController:(ABPeoplePickerNavigationController *)peoplePicker \n"
            + "      shouldContinueAfterSelectingPerson:(ABRecordRef)person;")
    public boolean shouldContinueAfterSelectingPerson(ABPeoplePickerNavigationController peoplePicker, ABRecord person);

    /**
     * It is used when the user selects one property.
     *
     * @param peoplePicker The ABPeoplePickerNavigationController that
     *                     corresponds to this delegate.
     * @param person       The selected person.
     * @param property     The selected property.
     * @param identifier   The id of the property(for multivalue properties).
     * @return TRUE if the ABPeoplePickerNavigationController should perform the
     * predefined action.
     */
    @CMSelector("- (BOOL)peoplePickerNavigationController:(ABPeoplePickerNavigationController *)peoplePicker \n"
            + "      shouldContinueAfterSelectingPerson:(ABRecordRef)person \n"
            + "                                property:(ABPropertyID)property \n"
            + "                              identifier:(ABMultiValueIdentifier)identifier;")
    public boolean shouldContinueAfterSelectingPersonProperty(ABPeoplePickerNavigationController peoplePicker, ABRecord person, int property, int identifier);
}
