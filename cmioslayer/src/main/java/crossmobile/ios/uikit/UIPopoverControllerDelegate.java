/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * UIPopoverControllerDelegate interface is the delegate responsible to
 * collaborate with UIPopoverController objects.
 */
@CMClass
public interface UIPopoverControllerDelegate {

    /**
     * It is used in order to handle an imminent dismissal of a popover.
     *
     * @param popoverController The popover controller that corresponds to this
     *                          delegate.
     * @return TRUE if the popover should be dismissed.
     */
    @Deprecated
    @CMSelector("- (BOOL)popoverControllerShouldDismissPopover:(UIPopoverController *)popoverController;")
    public boolean shouldDismissPopover(UIPopoverController popoverController);

    /**
     * It is used after the dismissal of a popover.
     *
     * @param popoverController The popover controller that corresponds to this
     *                          delegate.
     */
    @Deprecated
    @CMSelector("- (void)popoverControllerDidDismissPopover:(UIPopoverController *)popoverController;")
    public void didDismissPopover(UIPopoverController popoverController);
}
