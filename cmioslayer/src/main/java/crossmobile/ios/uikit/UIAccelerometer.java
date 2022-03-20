/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMSetter;

/**
 * UIAccelerometer class defines the way, the application receives acceleration
 * events from the related hardware.
 */
@Deprecated
@CMClass
public class UIAccelerometer extends NSObject {

    private static final UIAccelerometer sharedAccelerometer = new UIAccelerometer();
    private UIAccelerometerDelegate delegate = null;

    private UIAccelerometer() {
    }

    /**
     * Returns the accelerometer object of the system that is shared.
     *
     * @return The system's accelerometer object.
     */
    @CMSelector("+ (UIAccelerometer *)sharedAccelerometer;")
    public static UIAccelerometer sharedAccelerometer() {
        return sharedAccelerometer;
    }

    /**
     * Sets the time needed until the deliver of the acceleration data to the
     * delegate.
     *
     * @param i The time needed until the deliver of the acceleration data to
     *          the delegate.
     */
    @CMSetter("@property(nonatomic) NSTimeInterval updateInterval;")
    public void setUpdateInterval(double i) {
    }

    /**
     * Sets the delegate object that receives the acceleration events.
     *
     * @param delegate The delegate object that receives the acceleration
     *                 events.
     */
    @CMSetter("@property(nonatomic, weak) id<UIAccelerometerDelegate> delegate;")
    public void setDelegate(UIAccelerometerDelegate delegate) {
        this.delegate = delegate;
    }
}
