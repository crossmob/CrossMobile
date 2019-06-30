/*
 * (c) 2019 by Panayotis Katsaloulis
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
    @CMSelector("- (BOOL)personViewController:(ABPersonViewController *)personViewController \n"
            + "shouldPerformDefaultActionForPerson:(ABRecordRef)person \n"
            + "                    property:(ABPropertyID)property \n"
            + "                  identifier:(ABMultiValueIdentifier)identifier;")
    public boolean shouldPerformDefaultActionForPerson(ABPersonViewController personViewController, ABRecord person, int property, int identifier);
}
