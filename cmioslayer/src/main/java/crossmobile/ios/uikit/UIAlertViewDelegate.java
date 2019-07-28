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
package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * UIAlertViewDelegate interface is the delegate responsible for handling events
 * related to alert views.
 *
 *  * This object is deprecated, please use UIAlertController and actions instead.
 *  @see UIAlertController#addAction(UIAlertAction)
 */
@Deprecated
@CMClass
public interface UIAlertViewDelegate {

    /**
     * It is used in order to handle user click on the button of the alert view.
     *
     * @param alertView   The alert view that corresponds to this delegate.
     * @param buttonIndex The index of the button that was clicked.
     */
    @Deprecated
    @CMSelector("- (void)alertView:(UIAlertView *)alertView \n"
            + "clickedButtonAtIndex:(NSInteger)buttonIndex;")
    public void clickedButtonAtIndex(UIAlertView alertView, int buttonIndex);
}
