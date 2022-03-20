/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.desktop.cgeo;

import static crossmobile.ios.uikit.UIInterfaceOrientationMask.All;

public class CArea extends CSizable {

    public final int orientation;
    private final int x, y;

    protected CArea(int x, int y, int width, int height) {
        this(x, y, width, height, All);
    }

    protected CArea(int x, int y, int width, int height, int orientation) {
        super(width, height);
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public int hardwareX() {
        return scaled(x);
    }

    public int hardwareY() {
        return scaled(y);
    }

    public int virtualX() {
        return x;
    }

    public int virtualY() {
        return y;
    }

    public int hardwareRightEdge() {
        return hardwareX() + hardwareWidth();
    }

    public int virtualRightEdge() {
        return virtualX() + virtualWidth();
    }

    public int hardwareBottomEdge() {
        return hardwareY() + hardwareHeight();
    }

    public int virtualBottomEdge() {
        return virtualY() + virtualHeight();
    }

    protected boolean contains(int virtualX, int virtualY) {
        return contains(virtualX, virtualY, All);
    }

    public boolean contains(int virtualX, int virtualY, int orientation) {
        return (this.orientation & orientation) != 0 && virtualX >= virtualX() && virtualY >= virtualY() && virtualX <= virtualRightEdge() && virtualY <= virtualBottomEdge();
    }

    @Override
    public String toString() {
        return getName() + "{" +
                "x=" + virtualX() +
                ", y=" + virtualY() +
                ", width=" + virtualWidth() +
                ", height=" + virtualHeight() +
                '}';
    }

    protected String getName() {
        return "Area";
    }
}
