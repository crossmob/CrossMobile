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
 * UIAccelerometerDelegate interface is the delegate that cooperates with the
 * UIAccelerometer.
 */
@CMClass
public interface UIAccelerometerDelegate {

    /**
     * It is used in order to transfer the current acceleration data.
     *
     * @param accelerometer The accelerometer that corresponds to this delegate.
     * @param acceleration  The current acceleration data.
     */
    @Deprecated
    @CMSelector("- (void)accelerometer:(UIAccelerometer *)accelerometer didAccelerate:(UIAcceleration *)acceleration;")
    public void didAccelerate(UIAccelerometer accelerometer, UIAcceleration acceleration);
}
