// (c) 2020 by Panayotis Katsaloulis
// SPDX-License-Identifier: LGPL-3.0-only

package org.crossmobile.bind.graphics.curve;

public interface InterpolationCurve {

    public static final InterpolationCurve Linear = new LinearCurve();
    public static final InterpolationCurve EaseIn = new EaseInCurve();
    public static final InterpolationCurve EaseOut = new EaseOutCurve();
    public static final InterpolationCurve EaseInOut = new EaseInOutCurve();

    public double interpolate(double value);

}
