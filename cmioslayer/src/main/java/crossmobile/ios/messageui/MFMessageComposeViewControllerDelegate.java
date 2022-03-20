/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.messageui;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * MFMessageComposeViewControllerDelegate interface is the delegate that
 * cooperates with the MFMessageComposeViewController objects.
 */
@CMClass
public interface MFMessageComposeViewControllerDelegate {

    /**
     * It is used when the user has finished message composing.
     *
     * @param controller           The MFMessageComposeViewController that corresponds to
     *                             this delegate.
     * @param MessageComposeResult The result of the message composing
     *                             operation.
     * @see crossmobile.ios.messageui.MessageComposeResult
     */
    @CMSelector("- (void)messageComposeViewController:(MFMessageComposeViewController *)controller \n"
            + "                 didFinishWithResult:(MessageComposeResult)result;")
    public void didFinishWithResult(MFMessageComposeViewController controller, int MessageComposeResult);
}
