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
 * ABUnknownPersonViewControllerDelegate interface is the delegate that
 * cooperates with the ABUnknownPersonViewController in order to handle unknown
 * person view user events.
 */
@CMClass
public interface ABUnknownPersonViewControllerDelegate {

    /**
     * It is used after the user has created a contact or added properties to an
     * already stored contact.
     *
     * @param unknownCardViewController The personViewController that
     *                                  corresponds to this delegate.
     * @param person                    The contact that is added or edited.
     */
    @CMSelector("- (void)unknownPersonViewController:(ABUnknownPersonViewController *)unknownCardViewController \n"
            + "                 didResolveToPerson:(ABRecordRef)person;")
    public void didResolveToPerson(ABUnknownPersonViewController unknownCardViewController, ABRecord person);

    /**
     * It is used after the user selects a specific property value of the person
     * displayed in a person view controller.
     *
     * @param personViewController The personViewController that corresponds to
     *                             this delegate.
     * @param person               The person that is displayed in the personViewController.
     * @param property             The property selected by the user.
     * @param identifier           The value of the property that the user selected.(for
     *                             multivalue properties)
     * @return TRUE if the ABPersonViewController should perform the predefined
     * action.
     */
    @CMSelector("- (BOOL)unknownPersonViewController:(ABUnknownPersonViewController *)personViewController \n"
            + "shouldPerformDefaultActionForPerson:(ABRecordRef)person \n"
            + "                           property:(ABPropertyID)property \n"
            + "                         identifier:(ABMultiValueIdentifier)identifier;")
    public boolean shouldPerformDefaultActionForPerson(ABUnknownPersonViewController personViewController, ABRecord person, int property, int identifier);
}
