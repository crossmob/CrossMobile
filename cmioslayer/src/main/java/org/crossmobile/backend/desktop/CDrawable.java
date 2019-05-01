/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
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
