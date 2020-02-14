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
