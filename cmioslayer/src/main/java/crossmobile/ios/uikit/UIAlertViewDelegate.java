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
 * UIAlertViewDelegate interface is the delegate responsible for handling events
 * related to alert views.
 */
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
