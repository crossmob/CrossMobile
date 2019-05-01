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

public class CButton extends CDrawable implements CClickable {

    private final CEvent event;

    CButton(CPoint loc, int width, int height, int orientation, CEvent buttonType, NativeBitmap imagedown, NativeBitmap imageup, boolean autorotate) {
        super(loc, width, height, orientation, imagedown, imageup, autorotate);
        this.event = buttonType;
    }

    @Override
    public CEvent getEvent() {
        setActive(true);
        return event.getEvent(this);
    }

    void setActive(int x, int y) {
        setActive(contains(x, y));
    }

    void setActive(int x, int y, int orientation) {
        setActive(contains(x, y, orientation));
    }

}
