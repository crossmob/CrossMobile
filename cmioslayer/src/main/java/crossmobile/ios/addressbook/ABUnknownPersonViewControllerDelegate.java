/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.addressbook;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * ABUnknownPersonViewControllerDelegate interface is the delegate that
 * cooperates with the ABUnknownPersonViewController in order to handle unknown
 * person view user events.
 */
@SuppressWarnings("deprecation")
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
