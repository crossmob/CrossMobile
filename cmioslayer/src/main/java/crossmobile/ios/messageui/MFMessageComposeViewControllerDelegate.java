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
