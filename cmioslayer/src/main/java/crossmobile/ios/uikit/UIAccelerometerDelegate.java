/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
