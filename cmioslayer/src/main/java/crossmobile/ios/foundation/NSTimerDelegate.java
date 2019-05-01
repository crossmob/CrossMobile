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
package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMTarget;

/**
 * NSTimerDelegate interface is the delegate responsible for handling events
 * received from NSTimer.
 */
@CMTarget
public interface NSTimerDelegate {

    /**
     * It is called after an event related to NSTimer is triggered.
     *
     * @param timer The NSTimer that corresponds to the event.
     */
    @CMSelector("- (void)timerFireMethod:(NSTimer *)timer")
    public void fireMethod(NSTimer timer);
}
