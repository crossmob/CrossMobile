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

import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMTarget;

/**
 * UIControlDelegate interface is the delegate responsible for handling events
 * received from UIControl.
 */
@CMTarget
public interface UIControlDelegate {

    /**
     * It is used in order to handle events.
     *
     * @param sender The UIControl that corresponds to this delegate.
     * @param event  The event that occurred.
     */
    @CMSelector("- (IBAction)exec:(id)sender forEvent:(UIEvent*)event;")
    public void exec(UIControl sender, UIEvent event);
}
