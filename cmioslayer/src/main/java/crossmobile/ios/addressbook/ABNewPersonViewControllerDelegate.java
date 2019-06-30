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
 * ABNewPersonViewControllerDelegate is the delegate that cooperates with the
 * ABNewPersonViewController.
 */
@CMClass
public interface ABNewPersonViewControllerDelegate {

    /**
     * It is used after the user taps save or cancel.
     *
     * @param newPersonView The ABNewPersonViewController that corresponds to
     *                      this delegate.
     * @param person        NULL on cancel, the recently added person in case of save.
     */
    @CMSelector("- (void)newPersonViewController:(ABNewPersonViewController *)newPersonViewController\n"
            + "       didCompleteWithNewPerson:(ABRecordRef)person")
    public void didCompleteWithNewPerson(ABNewPersonViewController newPersonView, ABRecord person);
}
