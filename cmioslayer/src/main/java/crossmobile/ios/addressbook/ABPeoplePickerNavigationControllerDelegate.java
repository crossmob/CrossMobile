/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
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
