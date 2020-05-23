/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
