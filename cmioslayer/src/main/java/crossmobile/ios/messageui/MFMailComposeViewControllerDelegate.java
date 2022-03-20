/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.messageui;

import crossmobile.ios.foundation.NSError;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * MFMailComposeViewControllerDelegate interface is the delegate that cooperates
 * with the MFMailComposeViewController objects.
 */
@CMClass
public interface MFMailComposeViewControllerDelegate {

    /**
     * It is used when the user wants to cancel the email message composing.
     *
     * @param controller          The MFMailComposeViewController that corresponds to
     *                            this delegate.
     * @param MFMailComposeResult The result of the email message composing.
     * @param p3                  The error that occurred.
     * @see crossmobile.ios.messageui.MFMailComposeResult
     */
    @CMSelector("- (void)mailComposeController:(MFMailComposeViewController *)controller \n"
            + "          didFinishWithResult:(MFMailComposeResult)result \n"
            + "                        error:(NSError *)error;")
    public void didFinishWithResult(MFMailComposeViewController controller, int MFMailComposeResult, NSError p3);
}
