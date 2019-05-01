/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
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
