/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.desktop.cgeo;

public class CScreen extends CArea implements CClickable {

    private final boolean stretched;
    private final boolean withStatusBar;

    public CScreen(int x, int y, int width, int height, boolean stretched, boolean withStatusBar) {
        super(x, y, width, height);
        this.stretched = stretched;
        this.withStatusBar = withStatusBar;
    }

    public boolean isStretched() {
        return stretched;
    }

    public boolean isWithStatusBar() {
        return withStatusBar;
    }

    @Override
    public CEvent getEvent() {
        return CEvent.screen();
    }

    @Override
    protected String getName() {
        return "Screen";
    }
}
