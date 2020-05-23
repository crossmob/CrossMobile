/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
