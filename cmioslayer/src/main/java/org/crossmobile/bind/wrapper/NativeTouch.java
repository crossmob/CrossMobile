/*
 * (c) 2019 by Panayotis Katsaloulis
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
