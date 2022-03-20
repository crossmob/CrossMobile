/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
