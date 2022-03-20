/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.anim.curve;

public class EaseInOutCurve implements InterpolationCurve {

    @Override
    public double interpolate(double value) {
        return value * value * (3 - 2 * value);
    }
}
