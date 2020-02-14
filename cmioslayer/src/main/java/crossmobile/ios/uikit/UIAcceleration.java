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
import org.crossmobile.bridge.ann.CMGetter;


/**
 * UIAcceleration class defines an object that represents the data of an
 * acceleration event.
 */
@CMClass
@Deprecated
public class UIAcceleration extends NSObject {

    private final double x;
    private final double y;
    private final double z;
    private final double timestamp;

    UIAcceleration(double x, double y, double z, double timestamp) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.timestamp = timestamp;
    }

    /**
     * Returns the acceleration value for the x axis of the device.
     *
     * @return The acceleration value for the x axis.
     */
    @CMGetter("@property(nonatomic, readonly) UIAccelerationValue x;")
    public double x() {
        return x;
    }

    /**
     * Returns the acceleration value for the y axis of the device.
     *
     * @return The acceleration value for the y axis.
     */
    @CMGetter("@property(nonatomic, readonly) UIAccelerationValue y;")
    public double y() {
        return y;
    }

    /**
     * Returns the acceleration value for the z axis of the device.
     *
     * @return The acceleration value for the y axis.
     */
    @CMGetter("@property(nonatomic, readonly) UIAccelerationValue z;")
    public double z() {
        return z;
    }

    /**
     * Returns the relative time of the acceleration event.
     *
     * @return The relative time of the acceleration event.
     */
    @CMGetter("@property(nonatomic, readonly) NSTimeInterval timestamp;")
    public double timestamp() {
        return timestamp;
    }
}
