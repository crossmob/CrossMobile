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
