/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
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
