/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
