/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.wrapper;

import crossmobile.ios.coregraphics.CGPoint;

public class NativeTouch {

    public final double x;
    public final double y;
    public final int id;

    public NativeTouch(double x, double y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public NativeTouch(CGPoint location, int id) {
        this.x = location.getX();
        this.y = location.getY();
        this.id = id;
    }

}
