// (c) 2020 by Panayotis Katsaloulis
// SPDX-License-Identifier: LGPL-3.0-only

package org.crossmobile.backend.desktop;

import static crossmobile.ios.uikit.UIInterfaceOrientationMask.All;

public class CArea {

    private final CPoint loc;
    protected int width;
    protected int height;
    public final int orientation;

    protected CArea(CPoint loc, int width, int height) {
        this(loc, width, height, All);
    }

    protected CArea(CPoint loc, int width, int height, int orientation) {
        this.loc = loc;
        this.width = width;
        this.height = height;
        this.orientation = orientation;
    }

    public int x() {
        return loc.x();
    }

    public int y() {
        return loc.y();
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    int uptoX() {
        return x() + width();
    }

    int uptoY() {
        return y() + height();
    }

    protected boolean contains(int x, int y) {
        return contains(x, y, All);
    }

    public boolean contains(int x, int y, int orientation) {
        return (this.orientation & orientation) != 0 && x >= x() && y >= y() && x <= uptoX() && y <= uptoY();
    }

    public void updateWidth(int frameWidth, int frameHeight, int hardwareWidth, int hardwareHeight) {
        loc.updateWidth(width(), height(), frameWidth, frameHeight);
    }

    @Override
    public String toString() {
        return "CArea{" + "x=" + x() + ", y=" + y() + ", width=" + width + ", height=" + height + '}';
    }

}
