/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.addressbook;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * ABPersonViewControllerDelegate is the delegate that cooperates with the
 * ABPersonViewController.
 */
@CMClass
public interface ABPersonViewControllerDelegate {

    /**
     * It is used when the user selects a specific property value of the person
     * displayed in a person view controller.
     *
     * @param personViewController The ABPersonViewController that corresponds
     *                             to this delegate.
     * @param person               The person that the personViewController displays.
     * @param property             The property selected by the user.
     * @param identifier           The value of the property that the user selected.(for
     *                             multivalue properties)
     * @return TRUE if the ABPersonViewController should perform the predefined
     * action.
     */
    @SuppressWarnings("deprecation")
    @CMSelector("- (BOOL)personViewController:(ABPersonViewController *)personViewController \n"
            + "shouldPerformDefaultActionForPerson:(ABRecordRef)person \n"
            + "                    property:(ABPropertyID)property \n"
            + "                  identifier:(ABMultiValueIdentifier)identifier;")
    public boolean shouldPerformDefaultActionForPerson(ABPersonViewController personViewController, ABRecord person, int property, int identifier);
}
