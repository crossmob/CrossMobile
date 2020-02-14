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

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * ABPeoplePickerNavigationControllerDelegate interface is the delegate that
 * cooperates with the ABPeoplePickerNavigationController and handles
 * people-picker user events.
 */
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
