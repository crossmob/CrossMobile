// (c) 2020 by Panayotis Katsaloulis
// SPDX-License-Identifier: LGPL-3.0-only

package org.crossmobile.backend.desktop;

public class CScreen extends CArea implements CClickable {

    private final boolean stretched;
    private final boolean withStatusBar;

    public CScreen(CPoint loc, int width, int height, boolean stretched, boolean withStatusBar) {
        super(loc, width, height);
        this.stretched = stretched;
        this.withStatusBar = withStatusBar;
    }

    boolean isStretched() {
        return stretched;
    }

    public boolean isWithStatusBar() {
        return withStatusBar;
    }

    @Override
    public void updateWidth(int frameWidth, int frameHeight, int hardwareWidth, int hardwareHeight) {
        this.width = hardwareWidth;
        this.height = hardwareHeight;
        super.updateWidth(frameWidth, frameHeight, hardwareWidth, hardwareHeight);
    }

    @Override
    public CEvent getEvent() {
        return CEvent.screen();
    }

}
