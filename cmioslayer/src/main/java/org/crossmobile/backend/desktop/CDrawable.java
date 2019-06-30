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
package org.crossmobile.backend.desktop;

import org.crossmobile.bind.graphics.NativeBitmap;

public class CDrawable extends CArea {

    private boolean isActive = false;
    public final NativeBitmap active;
    public final NativeBitmap inactive;
    public final boolean autorotate;

    CDrawable(CPoint loc, int width, int height, int orientation, NativeBitmap active, NativeBitmap inactive, boolean autorotate) {
        super(loc, width, height, orientation);
        this.active = active;
        this.inactive = inactive == null ? active : inactive;
        this.autorotate = autorotate;
    }

    void setActive(boolean active) {
        this.isActive = active;
    }

    public boolean isActive() {
        return isActive;
    }
}
