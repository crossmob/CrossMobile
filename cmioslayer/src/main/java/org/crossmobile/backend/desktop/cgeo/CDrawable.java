/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.desktop.cgeo;

import org.crossmobile.bind.graphics.NativeBitmap;
import org.crossmobile.bridge.system.LazyProperty;

public class CDrawable extends CArea {

    private boolean isActive = false;
    private final LazyProperty<NativeBitmap> active;
    private final LazyProperty<NativeBitmap> inactive;
    public final boolean autorotate;

    CDrawable(int x, int y, int width, int height, int orientation, LazyProperty<NativeBitmap> active, LazyProperty<NativeBitmap> inactive, boolean autorotate) {
        super(x, y, width, height, orientation);
        this.active = active;
        this.inactive = inactive == null ? active : inactive;
        this.autorotate = autorotate;
    }

    void setActive(boolean active) {
        this.isActive = active;
    }

    boolean isActive() {
        return isActive;
    }

    public NativeBitmap getImage() {
        return isActive ? active.get() : inactive.get();
    }

    @Override
    protected String getName() {
        return "Drawable";
    }
}
