/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.desktop.cgeo;

import org.crossmobile.bind.graphics.NativeBitmap;

public class CButton extends CDrawable implements CClickable {

    private final CEvent event;

    CButton(int x, int y, int width, int height, int orientation, CEvent buttonType, NativeBitmap imagedown, NativeBitmap imageup, boolean autorotate) {
        super(x, y, width, height, orientation, imagedown, imageup, autorotate);
        this.event = buttonType;
    }

    @Override
    public CEvent getEvent() {
        setActive(true);
        return event.getEvent(this);
    }

    void setActive(int virtualX, int virtualY) {
        setActive(contains(virtualX, virtualY));
    }

    public void setActive(int virtualX, int virtualY, int orientation) {
        setActive(contains(virtualX, virtualY, orientation));
    }

    @Override
    protected String getName() {
        return "Button";
    }
}
