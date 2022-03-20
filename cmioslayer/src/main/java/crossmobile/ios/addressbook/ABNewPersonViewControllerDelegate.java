/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.addressbook;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * ABNewPersonViewControllerDelegate is the delegate that cooperates with the
 * ABNewPersonViewController.
 */
@SuppressWarnings("deprecation")
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
    void didCompleteWithNewPerson(ABNewPersonViewController newPersonView, ABRecord person);
}
